package com.qiniu.android.http.request;

import com.baidu.mobads.sdk.internal.ak;
import com.qiniu.android.common.ZoneInfo;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.http.UserAgent;
import com.qiniu.android.http.metrics.UploadRegionRequestMetrics;
import com.qiniu.android.http.request.HttpRegionRequest;
import com.qiniu.android.http.request.handler.RequestProgressHandler;
import com.qiniu.android.http.request.handler.RequestShouldRetryHandler;
import com.qiniu.android.http.serverRegion.UploadDomainRegion;
import com.qiniu.android.storage.Configuration;
import com.qiniu.android.storage.UpToken;
import com.qiniu.android.storage.UploadOptions;
import com.qiniu.android.utils.Crc32;
import com.qiniu.android.utils.GZipUtil;
import com.qiniu.android.utils.MD5;
import com.qiniu.android.utils.StringUtils;
import com.qiniu.android.utils.UrlSafeBase64;
import com.qiniu.android.utils.Utils;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class RequestTransaction {
    private final Configuration config;
    private final String key;
    private HttpRegionRequest regionRequest;
    private UploadRequestInfo requestInfo;
    private UploadRequestState requestState;
    private final UpToken token;
    private final UploadOptions uploadOption;
    private final String userAgent;

    /* loaded from: classes3.dex */
    public interface RequestCompleteHandler {
        void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject);
    }

    public RequestTransaction(List<String> list, UpToken upToken) {
        this(new Configuration.Builder().build(), UploadOptions.defaultOptions(), list, (String) null, (String) null, upToken);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void completeAction(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject, RequestCompleteHandler requestCompleteHandler) {
        this.requestInfo = null;
        this.regionRequest = null;
        this.regionRequest = null;
        if (requestCompleteHandler != null) {
            requestCompleteHandler.complete(responseInfo, uploadRegionRequestMetrics, jSONObject);
        }
    }

    private void initData(IUploadRegion iUploadRegion, IUploadRegion iUploadRegion2) {
        this.requestState = new UploadRequestState();
        UploadRequestInfo uploadRequestInfo = new UploadRequestInfo();
        this.requestInfo = uploadRequestInfo;
        uploadRequestInfo.targetRegionId = iUploadRegion.getZoneInfo().getRegionId();
        this.requestInfo.currentRegionId = iUploadRegion2.getZoneInfo().getRegionId();
        UploadRequestInfo uploadRequestInfo2 = this.requestInfo;
        UpToken upToken = this.token;
        uploadRequestInfo2.bucket = upToken != null ? upToken.bucket : "";
        uploadRequestInfo2.key = this.key;
        this.regionRequest = new HttpRegionRequest(this.config, this.uploadOption, upToken, iUploadRegion2, uploadRequestInfo2, this.requestState);
    }

    private String resumeV2EncodeKey(String str) {
        return str == null ? Constants.WAVE_SEPARATOR : str.equals("") ? "" : UrlSafeBase64.encodeToString(str);
    }

    public void completeParts(boolean z, String str, String str2, List<Map<String, Object>> list, final RequestCompleteHandler requestCompleteHandler) {
        this.requestInfo.requestType = UploadRequestInfo.RequestTypeCompletePart;
        if (list != null && list.size() != 0) {
            Object[] objArr = new Object[1];
            String str3 = this.token.token;
            if (str3 == null) {
                str3 = "";
            }
            objArr[0] = str3;
            String format = String.format("UpToken %s", objArr);
            HashMap hashMap = new HashMap();
            hashMap.put("Authorization", format);
            hashMap.put("Content-Type", "application/octet-stream");
            hashMap.put("User-Agent", this.userAgent);
            String str4 = ("/buckets/" + this.token.bucket) + ("/objects/" + resumeV2EncodeKey(this.key)) + ("/uploads/" + str2);
            HashMap hashMap2 = new HashMap();
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < list.size(); i2++) {
                jSONArray.put(new JSONObject(list.get(i2)));
            }
            hashMap2.put("parts", jSONArray);
            if (str != null) {
                hashMap2.put("fname", str);
            }
            String str5 = this.uploadOption.mimeType;
            if (str5 != null) {
                hashMap2.put("mimeType", str5);
            }
            if (this.uploadOption.params != null) {
                hashMap2.put("customVars", new JSONObject(this.uploadOption.params));
            }
            if (this.uploadOption.metaDataParam != null) {
                hashMap2.put("metaData", new JSONObject(this.uploadOption.metaDataParam));
            }
            this.regionRequest.post(str4, z, new JSONObject(hashMap2).toString().getBytes(), hashMap, new RequestShouldRetryHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.15
                @Override // com.qiniu.android.http.request.handler.RequestShouldRetryHandler
                public boolean shouldRetry(ResponseInfo responseInfo, JSONObject jSONObject) {
                    return !responseInfo.isOK();
                }
            }, null, new HttpRegionRequest.RequestCompleteHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.16
                @Override // com.qiniu.android.http.request.HttpRegionRequest.RequestCompleteHandler
                public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                    requestCompleteHandler.complete(responseInfo, uploadRegionRequestMetrics, jSONObject);
                }
            });
            return;
        }
        ResponseInfo invalidArgument = ResponseInfo.invalidArgument("partInfoArray");
        if (requestCompleteHandler != null) {
            requestCompleteHandler.complete(invalidArgument, null, invalidArgument.response);
        }
    }

    public void initPart(boolean z, final RequestCompleteHandler requestCompleteHandler) {
        this.requestInfo.requestType = UploadRequestInfo.RequestTypeInitParts;
        Object[] objArr = new Object[1];
        String str = this.token.token;
        if (str == null) {
            str = "";
        }
        objArr[0] = str;
        String format = String.format("UpToken %s", objArr);
        HashMap hashMap = new HashMap();
        hashMap.put("Authorization", format);
        hashMap.put("Content-Type", "application/octet-stream");
        hashMap.put("User-Agent", this.userAgent);
        this.regionRequest.post(("/buckets/" + this.token.bucket) + ("/objects/" + resumeV2EncodeKey(this.key)) + "/uploads", z, null, hashMap, new RequestShouldRetryHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.11
            @Override // com.qiniu.android.http.request.handler.RequestShouldRetryHandler
            public boolean shouldRetry(ResponseInfo responseInfo, JSONObject jSONObject) {
                return !responseInfo.isOK();
            }
        }, null, new HttpRegionRequest.RequestCompleteHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.12
            @Override // com.qiniu.android.http.request.HttpRegionRequest.RequestCompleteHandler
            public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                requestCompleteHandler.complete(responseInfo, uploadRegionRequestMetrics, jSONObject);
            }
        });
    }

    public void makeBlock(long j2, long j3, byte[] bArr, boolean z, RequestProgressHandler requestProgressHandler, final RequestCompleteHandler requestCompleteHandler) {
        UploadRequestInfo uploadRequestInfo = this.requestInfo;
        uploadRequestInfo.requestType = UploadRequestInfo.RequestTypeMkblk;
        uploadRequestInfo.fileOffset = Long.valueOf(j2);
        Object[] objArr = new Object[1];
        String str = this.token.token;
        if (str == null) {
            str = "";
        }
        objArr[0] = str;
        String format = String.format("UpToken %s", objArr);
        HashMap hashMap = new HashMap();
        hashMap.put("Authorization", format);
        hashMap.put("Content-Type", "application/octet-stream");
        hashMap.put("User-Agent", this.userAgent);
        final String str2 = "" + Crc32.bytes(bArr);
        this.regionRequest.post("/mkblk/" + j3, z, bArr, hashMap, new RequestShouldRetryHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.5
            @Override // com.qiniu.android.http.request.handler.RequestShouldRetryHandler
            public boolean shouldRetry(ResponseInfo responseInfo, JSONObject jSONObject) {
                String str3;
                if (jSONObject == null) {
                    return true;
                }
                String str4 = null;
                try {
                    str3 = jSONObject.getString("ctx");
                    try {
                        str4 = String.valueOf(jSONObject.getLong("crc32"));
                    } catch (JSONException unused) {
                    }
                } catch (JSONException unused2) {
                    str3 = null;
                }
                return !responseInfo.isOK() || str3 == null || str4 == null || !str2.equals(str4);
            }
        }, requestProgressHandler, new HttpRegionRequest.RequestCompleteHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.6
            @Override // com.qiniu.android.http.request.HttpRegionRequest.RequestCompleteHandler
            public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                RequestTransaction.this.completeAction(responseInfo, uploadRegionRequestMetrics, jSONObject, requestCompleteHandler);
            }
        });
    }

    public void makeFile(long j2, String str, String[] strArr, boolean z, final RequestCompleteHandler requestCompleteHandler) {
        String str2;
        String str3;
        this.requestInfo.requestType = UploadRequestInfo.RequestTypeMkfile;
        if (strArr == null) {
            ResponseInfo invalidArgument = ResponseInfo.invalidArgument("invalid blockContexts");
            completeAction(invalidArgument, null, invalidArgument.response, requestCompleteHandler);
            return;
        }
        Object[] objArr = new Object[1];
        String str4 = this.token.token;
        if (str4 == null) {
            str4 = "";
        }
        objArr[0] = str4;
        String format = String.format("UpToken %s", objArr);
        HashMap hashMap = new HashMap();
        hashMap.put("Authorization", format);
        hashMap.put("Content-Type", "application/octet-stream");
        hashMap.put("User-Agent", this.userAgent);
        String str5 = "/mkfile/" + j2 + String.format("/mimeType/%s", UrlSafeBase64.encodeToString(this.uploadOption.mimeType));
        String str6 = this.key;
        if (str6 != null) {
            str5 = str5 + String.format("/key/%s", UrlSafeBase64.encodeToString(str6));
        }
        Map<String, String> map = this.uploadOption.params;
        if (map != null) {
            for (String str7 : map.keySet()) {
                if (this.uploadOption.params.get(str7) != null) {
                    str5 = str5 + (MqttTopic.TOPIC_LEVEL_SEPARATOR + str7 + MqttTopic.TOPIC_LEVEL_SEPARATOR + UrlSafeBase64.encodeToString(str3));
                }
            }
        }
        Map<String, String> map2 = this.uploadOption.metaDataParam;
        if (map2 != null) {
            for (String str8 : map2.keySet()) {
                if (this.uploadOption.metaDataParam.get(str8) != null) {
                    str5 = str5 + (MqttTopic.TOPIC_LEVEL_SEPARATOR + str8 + MqttTopic.TOPIC_LEVEL_SEPARATOR + UrlSafeBase64.encodeToString(str2));
                }
            }
        }
        this.regionRequest.post(str5 + String.format("/fname/%s", UrlSafeBase64.encodeToString(str)), z, StringUtils.join(strArr, Constants.ACCEPT_TIME_SEPARATOR_SP).getBytes(), hashMap, new RequestShouldRetryHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.9
            @Override // com.qiniu.android.http.request.handler.RequestShouldRetryHandler
            public boolean shouldRetry(ResponseInfo responseInfo, JSONObject jSONObject) {
                return !responseInfo.isOK();
            }
        }, null, new HttpRegionRequest.RequestCompleteHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.10
            @Override // com.qiniu.android.http.request.HttpRegionRequest.RequestCompleteHandler
            public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                RequestTransaction.this.completeAction(responseInfo, uploadRegionRequestMetrics, jSONObject, requestCompleteHandler);
            }
        });
    }

    public void queryUploadHosts(boolean z, final RequestCompleteHandler requestCompleteHandler) {
        this.requestInfo.requestType = UploadRequestInfo.RequestTypeUCQuery;
        RequestShouldRetryHandler requestShouldRetryHandler = new RequestShouldRetryHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.1
            @Override // com.qiniu.android.http.request.handler.RequestShouldRetryHandler
            public boolean shouldRetry(ResponseInfo responseInfo, JSONObject jSONObject) {
                return !responseInfo.isOK();
            }
        };
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", this.userAgent);
        UpToken upToken = this.token;
        this.regionRequest.get(String.format("/v4/query?ak=%s&bucket=%s&sdk_version=%s&sdk_name=%s", upToken.accessKey, upToken.bucket, Utils.sdkVerion(), Utils.sdkLanguage()), z, hashMap, requestShouldRetryHandler, new HttpRegionRequest.RequestCompleteHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.2
            @Override // com.qiniu.android.http.request.HttpRegionRequest.RequestCompleteHandler
            public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                RequestTransaction.this.completeAction(responseInfo, uploadRegionRequestMetrics, jSONObject, requestCompleteHandler);
            }
        });
    }

    public void reportLog(byte[] bArr, String str, boolean z, final RequestCompleteHandler requestCompleteHandler) {
        this.requestInfo.requestType = UploadRequestInfo.RequestTypeUpLog;
        Object[] objArr = new Object[1];
        String str2 = this.token.token;
        if (str2 == null) {
            str2 = "";
        }
        objArr[0] = str2;
        String format = String.format("UpToken %s", objArr);
        HashMap hashMap = new HashMap();
        hashMap.put("Authorization", format);
        hashMap.put("Content-Type", ak.f1434e);
        hashMap.put("User-Agent", this.userAgent);
        if (str != null) {
            hashMap.put("X-Log-Client-Id", str);
        }
        this.regionRequest.post("/log/4?compressed=gzip", z, GZipUtil.gZip(bArr), hashMap, new RequestShouldRetryHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.17
            @Override // com.qiniu.android.http.request.handler.RequestShouldRetryHandler
            public boolean shouldRetry(ResponseInfo responseInfo, JSONObject jSONObject) {
                return !responseInfo.isOK();
            }
        }, null, new HttpRegionRequest.RequestCompleteHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.18
            @Override // com.qiniu.android.http.request.HttpRegionRequest.RequestCompleteHandler
            public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                RequestTransaction.this.completeAction(responseInfo, uploadRegionRequestMetrics, jSONObject, requestCompleteHandler);
            }
        });
    }

    public void serverConfig(boolean z, final RequestCompleteHandler requestCompleteHandler) {
        this.requestInfo.requestType = UploadRequestInfo.RequestTypeServerConfig;
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", this.userAgent);
        this.regionRequest.post(String.format("/v1/sdk/config?sdk_name=%s&sdk_version=%s", Utils.sdkLanguage(), Utils.sdkVerion()), z, null, hashMap, new RequestShouldRetryHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.19
            @Override // com.qiniu.android.http.request.handler.RequestShouldRetryHandler
            public boolean shouldRetry(ResponseInfo responseInfo, JSONObject jSONObject) {
                return !responseInfo.isOK();
            }
        }, null, new HttpRegionRequest.RequestCompleteHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.20
            @Override // com.qiniu.android.http.request.HttpRegionRequest.RequestCompleteHandler
            public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                RequestTransaction.this.completeAction(responseInfo, uploadRegionRequestMetrics, jSONObject, requestCompleteHandler);
            }
        });
    }

    public void serverUserConfig(boolean z, final RequestCompleteHandler requestCompleteHandler) {
        this.requestInfo.requestType = UploadRequestInfo.RequestTypeServerUserConfig;
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", this.userAgent);
        this.regionRequest.post(String.format("/v1/sdk/config/user?ak=%s&sdk_name=%s&sdk_version=%s", this.token.accessKey, Utils.sdkLanguage(), Utils.sdkVerion()), z, null, hashMap, new RequestShouldRetryHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.21
            @Override // com.qiniu.android.http.request.handler.RequestShouldRetryHandler
            public boolean shouldRetry(ResponseInfo responseInfo, JSONObject jSONObject) {
                return !responseInfo.isOK();
            }
        }, null, new HttpRegionRequest.RequestCompleteHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.22
            @Override // com.qiniu.android.http.request.HttpRegionRequest.RequestCompleteHandler
            public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                RequestTransaction.this.completeAction(responseInfo, uploadRegionRequestMetrics, jSONObject, requestCompleteHandler);
            }
        });
    }

    public void uploadChunk(String str, long j2, byte[] bArr, long j3, boolean z, RequestProgressHandler requestProgressHandler, final RequestCompleteHandler requestCompleteHandler) {
        UploadRequestInfo uploadRequestInfo = this.requestInfo;
        uploadRequestInfo.requestType = UploadRequestInfo.RequestTypeBput;
        uploadRequestInfo.fileOffset = Long.valueOf(j2 + j3);
        Object[] objArr = new Object[1];
        String str2 = this.token.token;
        if (str2 == null) {
            str2 = "";
        }
        objArr[0] = str2;
        String format = String.format("UpToken %s", objArr);
        HashMap hashMap = new HashMap();
        hashMap.put("Authorization", format);
        hashMap.put("Content-Type", "application/octet-stream");
        hashMap.put("User-Agent", this.userAgent);
        final String str3 = "" + Crc32.bytes(bArr);
        this.regionRequest.post(String.format("/bput/%s/%s", str, j3 + ""), z, bArr, hashMap, new RequestShouldRetryHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.7
            @Override // com.qiniu.android.http.request.handler.RequestShouldRetryHandler
            public boolean shouldRetry(ResponseInfo responseInfo, JSONObject jSONObject) {
                String str4;
                if (jSONObject == null) {
                    return true;
                }
                String str5 = null;
                try {
                    str4 = jSONObject.getString("ctx");
                    try {
                        str5 = String.valueOf(jSONObject.getLong("crc32"));
                    } catch (JSONException unused) {
                    }
                } catch (JSONException unused2) {
                    str4 = null;
                }
                return !responseInfo.isOK() || str4 == null || str5 == null || !str3.equals(str5);
            }
        }, requestProgressHandler, new HttpRegionRequest.RequestCompleteHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.8
            @Override // com.qiniu.android.http.request.HttpRegionRequest.RequestCompleteHandler
            public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                RequestTransaction.this.completeAction(responseInfo, uploadRegionRequestMetrics, jSONObject, requestCompleteHandler);
            }
        });
    }

    public void uploadFormData(byte[] bArr, String str, boolean z, RequestProgressHandler requestProgressHandler, final RequestCompleteHandler requestCompleteHandler) {
        this.requestInfo.requestType = "form";
        HashMap hashMap = new HashMap();
        Map<String, String> map = this.uploadOption.params;
        if (map != null) {
            hashMap.putAll(map);
        }
        Map<String, String> map2 = this.uploadOption.metaDataParam;
        if (map2 != null) {
            hashMap.putAll(map2);
        }
        String str2 = this.key;
        if (str2 != null && str2.length() > 0) {
            hashMap.put("key", this.key);
        }
        String str3 = this.token.token;
        if (str3 == null) {
            str3 = "";
        }
        hashMap.put("token", str3);
        if (this.uploadOption.checkCrc) {
            hashMap.put("crc32", String.valueOf(Crc32.bytes(bArr)));
        }
        StringBuilder sb = new StringBuilder();
        for (String str4 : hashMap.keySet()) {
            sb.append(String.format("--%s\r\n%s; name=\"%s\"\r\n\r\n", "werghnvt54wef654rjuhgb56trtg34tweuyrgf", "Content-Disposition: form-data", str4));
            sb.append(String.format("%s\r\n", (String) hashMap.get(str4)));
        }
        String format = String.format("--%s\r\n%s; name=\"%s\"; filename=\"%s\"\nContent-Type:%s\r\n\r\n", "werghnvt54wef654rjuhgb56trtg34tweuyrgf", "Content-Disposition: form-data", "file", Utils.formEscape(str), this.uploadOption.mimeType);
        String format2 = String.format("\r\n--%s--\r\n", "werghnvt54wef654rjuhgb56trtg34tweuyrgf");
        byte[] bytes = sb.toString().getBytes();
        byte[] bytes2 = format.getBytes();
        byte[] bytes3 = format2.getBytes();
        int length = bytes.length + bytes2.length + bArr.length + bytes3.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
        System.arraycopy(bytes2, 0, bArr2, bytes.length, bytes2.length);
        System.arraycopy(bArr, 0, bArr2, bytes.length + bytes2.length, bArr.length);
        System.arraycopy(bytes3, 0, bArr2, bytes.length + bytes2.length + bArr.length, bytes3.length);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("Content-Type", "multipart/form-data; boundary=werghnvt54wef654rjuhgb56trtg34tweuyrgf");
        hashMap2.put("Content-Length", String.valueOf(length));
        hashMap2.put("User-Agent", this.userAgent);
        this.regionRequest.post(null, z, bArr2, hashMap2, new RequestShouldRetryHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.3
            @Override // com.qiniu.android.http.request.handler.RequestShouldRetryHandler
            public boolean shouldRetry(ResponseInfo responseInfo, JSONObject jSONObject) {
                return !responseInfo.isOK();
            }
        }, requestProgressHandler, new HttpRegionRequest.RequestCompleteHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.4
            @Override // com.qiniu.android.http.request.HttpRegionRequest.RequestCompleteHandler
            public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                RequestTransaction.this.completeAction(responseInfo, uploadRegionRequestMetrics, jSONObject, requestCompleteHandler);
            }
        });
    }

    public void uploadPart(boolean z, String str, int i2, byte[] bArr, RequestProgressHandler requestProgressHandler, final RequestCompleteHandler requestCompleteHandler) {
        String encrypt;
        this.requestInfo.requestType = UploadRequestInfo.RequestTypeUploadPart;
        Object[] objArr = new Object[1];
        String str2 = this.token.token;
        if (str2 == null) {
            str2 = "";
        }
        objArr[0] = str2;
        String format = String.format("UpToken %s", objArr);
        HashMap hashMap = new HashMap();
        hashMap.put("Authorization", format);
        hashMap.put("Content-Type", "application/octet-stream");
        hashMap.put("User-Agent", this.userAgent);
        if (this.uploadOption.checkCrc && (encrypt = MD5.encrypt(bArr)) != null) {
            hashMap.put("Content-MD5", encrypt);
        }
        this.regionRequest.put(("/buckets/" + this.token.bucket) + ("/objects/" + resumeV2EncodeKey(this.key)) + ("/uploads/" + str) + (MqttTopic.TOPIC_LEVEL_SEPARATOR + i2), z, bArr, hashMap, new RequestShouldRetryHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.13
            @Override // com.qiniu.android.http.request.handler.RequestShouldRetryHandler
            public boolean shouldRetry(ResponseInfo responseInfo, JSONObject jSONObject) {
                String str3;
                if (jSONObject == null) {
                    return true;
                }
                String str4 = null;
                try {
                    str3 = jSONObject.getString("etag");
                    try {
                        str4 = jSONObject.getString("md5");
                    } catch (JSONException unused) {
                    }
                } catch (JSONException unused2) {
                    str3 = null;
                }
                return !responseInfo.isOK() || str3 == null || str4 == null;
            }
        }, requestProgressHandler, new HttpRegionRequest.RequestCompleteHandler() { // from class: com.qiniu.android.http.request.RequestTransaction.14
            @Override // com.qiniu.android.http.request.HttpRegionRequest.RequestCompleteHandler
            public void complete(ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics, JSONObject jSONObject) {
                requestCompleteHandler.complete(responseInfo, uploadRegionRequestMetrics, jSONObject);
            }
        });
    }

    public RequestTransaction(List<String> list, String str, UpToken upToken) {
        this(new Configuration.Builder().build(), UploadOptions.defaultOptions(), list, str, (String) null, upToken);
    }

    public RequestTransaction(Configuration configuration, UploadOptions uploadOptions, List<String> list, String str, String str2, UpToken upToken) {
        this(configuration, uploadOptions, str2, upToken);
        UploadDomainRegion uploadDomainRegion = new UploadDomainRegion();
        uploadDomainRegion.setupRegionData(ZoneInfo.buildInfo(list, str));
        initData(uploadDomainRegion, uploadDomainRegion);
    }

    public RequestTransaction(Configuration configuration, UploadOptions uploadOptions, IUploadRegion iUploadRegion, IUploadRegion iUploadRegion2, String str, UpToken upToken) {
        this(configuration, uploadOptions, str, upToken);
        initData(iUploadRegion, iUploadRegion2);
    }

    private RequestTransaction(Configuration configuration, UploadOptions uploadOptions, String str, UpToken upToken) {
        this.config = configuration;
        this.uploadOption = uploadOptions;
        this.key = str;
        this.token = upToken;
        this.userAgent = UserAgent.instance().getUa((upToken == null || (r1 = upToken.accessKey) == null) ? "" : "");
    }
}
