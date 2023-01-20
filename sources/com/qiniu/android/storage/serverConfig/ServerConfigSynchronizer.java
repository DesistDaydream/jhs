package com.qiniu.android.storage.serverConfig;

import com.qiniu.android.common.Config;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.http.metrics.UploadRegionRequestMetrics;
import com.qiniu.android.http.request.RequestTransaction;
import com.qiniu.android.storage.UpToken;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ServerConfigSynchronizer {
    private static String[] Hosts;
    private static String Token;
    private static RequestTransaction serverConfigTransaction;
    private static RequestTransaction serverUserConfigTransaction;

    /* loaded from: classes3.dex */
    public interface ServerConfigHandler {
        void handle(ServerConfig serverConfig);
    }

    /* loaded from: classes3.dex */
    public interface ServerUserConfigHandler {
        void handle(ServerUserConfig serverUserConfig);
    }

    private static synchronized RequestTransaction createServerConfigTransaction() {
        synchronized (ServerConfigSynchronizer.class) {
            if (serverConfigTransaction != null) {
                return null;
            }
            UpToken parse = UpToken.parse(Token);
            if (parse == null) {
                parse = UpToken.getInvalidToken();
            }
            ArrayList arrayList = new ArrayList();
            String[] strArr = Hosts;
            if (strArr != null && strArr.length > 0) {
                arrayList.addAll(Arrays.asList(strArr));
            } else {
                arrayList.add(Config.preQueryHost00);
                arrayList.add(Config.preQueryHost01);
            }
            RequestTransaction requestTransaction = new RequestTransaction(arrayList, parse);
            serverConfigTransaction = requestTransaction;
            return requestTransaction;
        }
    }

    private static synchronized RequestTransaction createServerUserConfigTransaction() {
        String str;
        synchronized (ServerConfigSynchronizer.class) {
            if (serverUserConfigTransaction == null && (str = Token) != null) {
                UpToken parse = UpToken.parse(str);
                if (parse != null && parse.isValid()) {
                    ArrayList arrayList = new ArrayList();
                    String[] strArr = Hosts;
                    if (strArr != null && strArr.length > 0) {
                        arrayList.addAll(Arrays.asList(strArr));
                    } else {
                        arrayList.add(Config.preQueryHost00);
                        arrayList.add(Config.preQueryHost01);
                    }
                    RequestTransaction requestTransaction = new RequestTransaction(arrayList, parse);
                    serverUserConfigTransaction = requestTransaction;
                    return requestTransaction;
                }
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void destroyServerConfigTransaction() {
        synchronized (ServerConfigSynchronizer.class) {
            serverConfigTransaction = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void destroyServerUserConfigTransaction() {
        synchronized (ServerConfigSynchronizer.class) {
            serverUserConfigTransaction = null;
        }
    }

    public static void getServerConfigFromServer(final ServerConfigHandler serverConfigHandler) {
        if (serverConfigHandler == null) {
            return;
        }
        RequestTransaction createServerConfigTransaction = createServerConfigTransaction();
        if (createServerConfigTransaction == null) {
            serverConfigHandler.handle(null);
        } else {
            createServerConfigTransaction.serverConfig(true, new RequestTransaction.RequestCompleteHandler() { // from class: com.qiniu.android.storage.serverConfig.ServerConfigSynchronizer.1
                @Override // com.qiniu.android.http.request.RequestTransaction.RequestCompleteHandler
                public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                    if (responseInfo.isOK() && jSONObject != null) {
                        ServerConfigHandler.this.handle(new ServerConfig(jSONObject));
                    } else {
                        ServerConfigHandler.this.handle(null);
                    }
                    ServerConfigSynchronizer.destroyServerConfigTransaction();
                }
            });
        }
    }

    public static void getServerUserConfigFromServer(final ServerUserConfigHandler serverUserConfigHandler) {
        if (serverUserConfigHandler == null) {
            return;
        }
        RequestTransaction createServerUserConfigTransaction = createServerUserConfigTransaction();
        if (createServerUserConfigTransaction == null) {
            serverUserConfigHandler.handle(null);
        } else {
            createServerUserConfigTransaction.serverUserConfig(true, new RequestTransaction.RequestCompleteHandler() { // from class: com.qiniu.android.storage.serverConfig.ServerConfigSynchronizer.2
                @Override // com.qiniu.android.http.request.RequestTransaction.RequestCompleteHandler
                public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                    if (responseInfo.isOK() && jSONObject != null) {
                        ServerUserConfigHandler.this.handle(new ServerUserConfig(jSONObject));
                    } else {
                        ServerUserConfigHandler.this.handle(null);
                    }
                    ServerConfigSynchronizer.destroyServerUserConfigTransaction();
                }
            });
        }
    }

    public static void setHosts(String[] strArr) {
        Hosts = strArr;
    }

    public static void setToken(String str) {
        Token = str;
    }
}
