package com.qiniu.android.http.request;

import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.http.UrlConverter;
import com.qiniu.android.http.dns.DnsSource;
import com.qiniu.android.http.metrics.UploadRegionRequestMetrics;
import com.qiniu.android.http.metrics.UploadSingleRequestMetrics;
import com.qiniu.android.http.request.HttpSingleRequest;
import com.qiniu.android.http.request.handler.RequestProgressHandler;
import com.qiniu.android.http.request.handler.RequestShouldRetryHandler;
import com.qiniu.android.storage.Configuration;
import com.qiniu.android.storage.UpToken;
import com.qiniu.android.storage.UploadOptions;
import com.qiniu.android.utils.LogUtil;
import com.qiniu.android.utils.StringUtils;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class HttpRegionRequest {
    private final Configuration config;
    private IUploadServer currentServer;
    private final IUploadRegion region;
    private final UploadRequestInfo requestInfo;
    private UploadRegionRequestMetrics requestMetrics;
    private UploadRequestState requestState;
    private HttpSingleRequest singleRequest;
    private final UpToken token;
    private final UploadOptions uploadOption;

    /* loaded from: classes3.dex */
    public interface RequestCompleteHandler {
        void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject);
    }

    public HttpRegionRequest(Configuration configuration, UploadOptions uploadOptions, UpToken upToken, IUploadRegion iUploadRegion, UploadRequestInfo uploadRequestInfo, UploadRequestState uploadRequestState) {
        this.config = configuration;
        this.uploadOption = uploadOptions;
        this.token = upToken;
        this.region = iUploadRegion;
        this.requestInfo = uploadRequestInfo;
        this.requestState = uploadRequestState;
        this.singleRequest = new HttpSingleRequest(configuration, uploadOptions, upToken, uploadRequestInfo, uploadRequestState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void completeAction(ResponseInfo responseInfo, JSONObject jSONObject, RequestCompleteHandler requestCompleteHandler) {
        this.requestMetrics.end();
        this.singleRequest = null;
        if (requestCompleteHandler != null) {
            requestCompleteHandler.complete(responseInfo, this.requestMetrics, jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IUploadServer getNextServer(ResponseInfo responseInfo) {
        if (this.requestState != null && responseInfo != null && responseInfo.isTlsError()) {
            this.requestState.setUseOldServer(true);
        }
        return this.region.getNextServer(this.requestState, responseInfo, this.currentServer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performRequest(final IUploadServer iUploadServer, final String str, final boolean z, byte[] bArr, final Map<String, String> map, final String str2, final RequestShouldRetryHandler requestShouldRetryHandler, final RequestProgressHandler requestProgressHandler, final RequestCompleteHandler requestCompleteHandler) {
        String str3 = null;
        if (iUploadServer != null && iUploadServer.getHost() != null && iUploadServer.getHost().length() != 0) {
            this.currentServer = iUploadServer;
            String host = iUploadServer.getHost();
            String ip = iUploadServer.getIp();
            UrlConverter urlConverter = this.config.urlConverter;
            if (urlConverter != null) {
                host = urlConverter.convert(host);
            } else {
                str3 = ip;
            }
            String str4 = this.config.useHttps ? "https://" : "http://";
            StringBuilder sb = new StringBuilder();
            sb.append(str4);
            sb.append(host);
            sb.append(str != null ? str : "");
            final Request request = new Request(sb.toString(), str2, map, bArr, this.config.connectTimeout);
            request.host = host;
            request.ip = str3;
            LogUtil.i("key:" + StringUtils.toNonnullString(this.requestInfo.key) + " url:" + StringUtils.toNonnullString(request.urlString));
            LogUtil.i("key:" + StringUtils.toNonnullString(this.requestInfo.key) + " headers:" + StringUtils.toNonnullString(request.allHeaders));
            this.singleRequest.request(request, iUploadServer, z, requestShouldRetryHandler, requestProgressHandler, new HttpSingleRequest.RequestCompleteHandler() { // from class: com.qiniu.android.http.request.HttpRegionRequest.1
                @Override // com.qiniu.android.http.request.HttpSingleRequest.RequestCompleteHandler
                public void complete(ResponseInfo responseInfo, ArrayList<UploadSingleRequestMetrics> arrayList, JSONObject jSONObject) {
                    HttpRegionRequest.this.requestMetrics.addMetricsList(arrayList);
                    boolean z2 = false;
                    if (arrayList != null && arrayList.size() > 0) {
                        UploadSingleRequestMetrics uploadSingleRequestMetrics = arrayList.get(arrayList.size() - 1);
                        boolean z3 = DnsSource.isCustom(uploadSingleRequestMetrics.getSyncDnsSource()) || DnsSource.isDoh(uploadSingleRequestMetrics.getSyncDnsSource()) || DnsSource.isDnspod(uploadSingleRequestMetrics.getSyncDnsSource());
                        if (uploadSingleRequestMetrics.isForsureHijacked() || (uploadSingleRequestMetrics.isMaybeHijacked() && z3)) {
                            z2 = true;
                        }
                    }
                    if (z2) {
                        HttpRegionRequest.this.region.updateIpListFormHost(iUploadServer.getHost());
                    }
                    if ((requestShouldRetryHandler.shouldRetry(responseInfo, jSONObject) && HttpRegionRequest.this.config.allowBackupHost && responseInfo.couldRegionRetry()) || z2) {
                        IUploadServer nextServer = HttpRegionRequest.this.getNextServer(responseInfo);
                        if (nextServer != null) {
                            HttpRegionRequest.this.performRequest(nextServer, str, z, request.httpBody, map, str2, requestShouldRetryHandler, requestProgressHandler, requestCompleteHandler);
                            request.httpBody = null;
                            return;
                        }
                        request.httpBody = null;
                        HttpRegionRequest.this.completeAction(responseInfo, jSONObject, requestCompleteHandler);
                        return;
                    }
                    request.httpBody = null;
                    HttpRegionRequest.this.completeAction(responseInfo, jSONObject, requestCompleteHandler);
                }
            });
            return;
        }
        completeAction(ResponseInfo.sdkInteriorError("server error"), null, requestCompleteHandler);
    }

    public void get(String str, boolean z, Map<String, String> map, RequestShouldRetryHandler requestShouldRetryHandler, RequestCompleteHandler requestCompleteHandler) {
        UploadRegionRequestMetrics uploadRegionRequestMetrics = new UploadRegionRequestMetrics(this.region);
        this.requestMetrics = uploadRegionRequestMetrics;
        uploadRegionRequestMetrics.start();
        performRequest(getNextServer(null), str, z, null, map, "GET", requestShouldRetryHandler, null, requestCompleteHandler);
    }

    public void post(String str, boolean z, byte[] bArr, Map<String, String> map, RequestShouldRetryHandler requestShouldRetryHandler, RequestProgressHandler requestProgressHandler, RequestCompleteHandler requestCompleteHandler) {
        UploadRegionRequestMetrics uploadRegionRequestMetrics = new UploadRegionRequestMetrics(this.region);
        this.requestMetrics = uploadRegionRequestMetrics;
        uploadRegionRequestMetrics.start();
        performRequest(getNextServer(null), str, z, bArr, map, "POST", requestShouldRetryHandler, requestProgressHandler, requestCompleteHandler);
    }

    public void put(String str, boolean z, byte[] bArr, Map<String, String> map, RequestShouldRetryHandler requestShouldRetryHandler, RequestProgressHandler requestProgressHandler, RequestCompleteHandler requestCompleteHandler) {
        UploadRegionRequestMetrics uploadRegionRequestMetrics = new UploadRegionRequestMetrics(this.region);
        this.requestMetrics = uploadRegionRequestMetrics;
        uploadRegionRequestMetrics.start();
        performRequest(getNextServer(null), str, z, bArr, map, Request.HttpMethodPUT, requestShouldRetryHandler, requestProgressHandler, requestCompleteHandler);
    }
}
