package com.qiniu.android.common;

import com.qiniu.android.common.Zone;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.http.dns.DnsPrefetchTransaction;
import com.qiniu.android.http.metrics.UploadRegionRequestMetrics;
import com.qiniu.android.http.request.RequestTransaction;
import com.qiniu.android.storage.UpToken;
import com.qiniu.android.utils.SingleFlight;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class AutoZone extends Zone {
    private static final SingleFlight SingleFlight = new SingleFlight();
    private ArrayList<RequestTransaction> transactions = new ArrayList<>();
    private String[] ucServers;

    /* loaded from: classes3.dex */
    public static class GlobalCache {
        private static GlobalCache globalCache = new GlobalCache();
        private ConcurrentHashMap<String, ZonesInfo> cache = new ConcurrentHashMap<>();

        private GlobalCache() {
        }

        public synchronized void cache(ZonesInfo zonesInfo, String str) {
            if (str != null) {
                if (!str.isEmpty() && zonesInfo != null) {
                    this.cache.put(str, zonesInfo);
                }
            }
        }

        public void clearCache() {
            for (ZonesInfo zonesInfo : this.cache.values()) {
                zonesInfo.toTemporary();
            }
        }

        public static GlobalCache getInstance() {
            return globalCache;
        }

        public synchronized ZonesInfo zonesInfoForKey(String str) {
            if (str != null) {
                if (!str.isEmpty()) {
                    return this.cache.get(str);
                }
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public static class SingleFlightValue {
        private UploadRegionRequestMetrics metrics;
        private JSONObject response;
        private ResponseInfo responseInfo;

        private SingleFlightValue() {
        }
    }

    public static void clearCache() {
        GlobalCache.getInstance().clearCache();
    }

    public RequestTransaction createUploadRequestTransaction(UpToken upToken) {
        RequestTransaction requestTransaction = new RequestTransaction(getUcServerList(), "unknown", upToken);
        this.transactions.add(requestTransaction);
        return requestTransaction;
    }

    public void destroyUploadRequestTransaction(RequestTransaction requestTransaction) {
        this.transactions.remove(requestTransaction);
    }

    private String[] getUcServerArray() {
        String[] strArr = this.ucServers;
        return (strArr == null || strArr.length <= 0) ? new String[]{Config.preQueryHost00, Config.preQueryHost01} : strArr;
    }

    public List<String> getUcServerList() {
        String[] strArr = this.ucServers;
        if (strArr != null && strArr.length > 0) {
            ArrayList arrayList = new ArrayList();
            Collections.addAll(arrayList, this.ucServers);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(Config.preQueryHost02);
        arrayList2.add(Config.preQueryHost00);
        arrayList2.add(Config.preQueryHost01);
        return arrayList2;
    }

    @Override // com.qiniu.android.common.Zone
    public ZonesInfo getZonesInfo(UpToken upToken) {
        if (upToken == null) {
            return null;
        }
        ZonesInfo zonesInfoForKey = GlobalCache.getInstance().zonesInfoForKey(upToken.index());
        if (zonesInfoForKey != null) {
            try {
                return (ZonesInfo) zonesInfoForKey.clone();
            } catch (Exception unused) {
                return zonesInfoForKey;
            }
        }
        return zonesInfoForKey;
    }

    @Override // com.qiniu.android.common.Zone
    public void preQuery(final UpToken upToken, final Zone.QueryHandler queryHandler) {
        if (upToken != null && upToken.isValid()) {
            UploadRegionRequestMetrics uploadRegionRequestMetrics = new UploadRegionRequestMetrics(null);
            uploadRegionRequestMetrics.start();
            final String index = upToken.index();
            ZonesInfo zonesInfoForKey = GlobalCache.getInstance().zonesInfoForKey(index);
            if (zonesInfoForKey != null && zonesInfoForKey.isValid() && !zonesInfoForKey.isTemporary()) {
                uploadRegionRequestMetrics.end();
                queryHandler.complete(0, ResponseInfo.successResponse(), uploadRegionRequestMetrics);
                return;
            }
            DnsPrefetchTransaction.addDnsCheckAndPrefetchTransaction(getUcServerArray());
            try {
                SingleFlight.perform(index, new SingleFlight.ActionHandler() { // from class: com.qiniu.android.common.AutoZone.1
                    {
                        AutoZone.this = this;
                    }

                    @Override // com.qiniu.android.utils.SingleFlight.ActionHandler
                    public void action(final SingleFlight.CompleteHandler completeHandler) throws Exception {
                        final RequestTransaction createUploadRequestTransaction = AutoZone.this.createUploadRequestTransaction(upToken);
                        createUploadRequestTransaction.queryUploadHosts(true, new RequestTransaction.RequestCompleteHandler() { // from class: com.qiniu.android.common.AutoZone.1.1
                            {
                                AnonymousClass1.this = this;
                            }

                            @Override // com.qiniu.android.http.request.RequestTransaction.RequestCompleteHandler
                            public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics2, JSONObject jSONObject) {
                                AutoZone.this.destroyUploadRequestTransaction(createUploadRequestTransaction);
                                SingleFlightValue singleFlightValue = new SingleFlightValue();
                                singleFlightValue.responseInfo = responseInfo;
                                singleFlightValue.response = jSONObject;
                                singleFlightValue.metrics = uploadRegionRequestMetrics2;
                                completeHandler.complete(singleFlightValue);
                            }
                        });
                    }
                }, new SingleFlight.CompleteHandler() { // from class: com.qiniu.android.common.AutoZone.2
                    {
                        AutoZone.this = this;
                    }

                    @Override // com.qiniu.android.utils.SingleFlight.CompleteHandler
                    public void complete(Object obj) {
                        SingleFlightValue singleFlightValue = (SingleFlightValue) obj;
                        ResponseInfo responseInfo = singleFlightValue.responseInfo;
                        UploadRegionRequestMetrics uploadRegionRequestMetrics2 = singleFlightValue.metrics;
                        JSONObject jSONObject = singleFlightValue.response;
                        if (responseInfo != null && responseInfo.isOK() && jSONObject != null) {
                            ZonesInfo createZonesInfo = ZonesInfo.createZonesInfo(jSONObject);
                            if (createZonesInfo.isValid()) {
                                GlobalCache.getInstance().cache(createZonesInfo, index);
                                queryHandler.complete(0, responseInfo, uploadRegionRequestMetrics2);
                                return;
                            }
                            queryHandler.complete(-1015, responseInfo, uploadRegionRequestMetrics2);
                        } else if (responseInfo.isNetworkBroken()) {
                            queryHandler.complete(-1, responseInfo, uploadRegionRequestMetrics2);
                        } else {
                            ZonesInfo zonesInfo = FixedZone.localsZoneInfo().getZonesInfo(upToken);
                            if (zonesInfo.isValid()) {
                                GlobalCache.getInstance().cache(zonesInfo, index);
                                queryHandler.complete(0, responseInfo, uploadRegionRequestMetrics2);
                                return;
                            }
                            queryHandler.complete(-1015, responseInfo, uploadRegionRequestMetrics2);
                        }
                    }
                });
                return;
            } catch (Exception e2) {
                queryHandler.complete(-1, ResponseInfo.localIOError(e2.toString()), null);
                return;
            }
        }
        queryHandler.complete(-1, ResponseInfo.invalidToken("invalid token"), null);
    }

    public void setUcServer(String str) {
        if (str != null) {
            this.ucServers = new String[]{str};
        }
    }

    public void setUcServers(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        this.ucServers = strArr;
    }
}
