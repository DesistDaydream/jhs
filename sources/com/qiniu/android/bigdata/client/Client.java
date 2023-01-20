package com.qiniu.android.bigdata.client;

import com.moor.imkf.lib.jsoup.helper.HttpConnection;
import com.qiniu.android.common.Constants;
import com.qiniu.android.http.CancellationHandler;
import com.qiniu.android.http.ProgressHandler;
import com.qiniu.android.http.ProxyConfiguration;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.http.UrlConverter;
import com.qiniu.android.http.UserAgent;
import com.qiniu.android.http.dns.Dns;
import com.qiniu.android.http.dns.DnsPrefetcher;
import com.qiniu.android.http.dns.IDnsNetworkAddress;
import com.qiniu.android.http.request.httpclient.CountingRequestBody;
import com.qiniu.android.http.request.httpclient.MultipartBody;
import com.qiniu.android.storage.UpCancellationSignal;
import com.qiniu.android.storage.UpToken;
import com.qiniu.android.utils.AsyncRun;
import com.qiniu.android.utils.StringMap;
import com.qiniu.android.utils.StringUtils;
import com.tencent.android.tpns.mqtt.MqttTopic;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class Client {
    public static final String ContentTypeHeader = "Content-Type";
    public static final String DefaultMime = "application/octet-stream";
    public static final String FormMime = "application/x-www-form-urlencoded";
    public static final String JsonMime = "application/json";
    private final UrlConverter converter;
    private OkHttpClient httpClient;

    /* loaded from: classes3.dex */
    public static class ResponseTag {
        public long duration;
        public String ip;

        private ResponseTag() {
            this.ip = "";
            this.duration = -1L;
        }
    }

    public Client() {
        this(null, 10, 30, null, null);
    }

    private static JSONObject buildJsonResp(byte[] bArr) throws Exception {
        String str = new String(bArr, Constants.UTF_8);
        if (StringUtils.isNullOrEmpty(str)) {
            return new JSONObject();
        }
        return new JSONObject(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0080 A[LOOP:0: B:31:0x007e->B:32:0x0080, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.qiniu.android.http.ResponseInfo buildResponseInfo(okhttp3.Response r3, java.lang.String r4, long r5, com.qiniu.android.storage.UpToken r7, long r8) {
        /*
            int r4 = r3.code()
            java.lang.String r5 = "X-Reqid"
            java.lang.String r5 = r3.header(r5)
            r6 = 0
            if (r5 != 0) goto Le
            goto L1a
        Le:
            java.lang.String r5 = r5.trim()
            java.lang.String r7 = ","
            java.lang.String[] r5 = r5.split(r7)
            r5 = r5[r6]
        L1a:
            r5 = 0
            okhttp3.ResponseBody r7 = r3.body()     // Catch: java.io.IOException -> L25
            byte[] r7 = r7.bytes()     // Catch: java.io.IOException -> L25
            r8 = r5
            goto L2c
        L25:
            r7 = move-exception
            java.lang.String r7 = r7.getMessage()
            r8 = r7
            r7 = r5
        L2c:
            java.lang.String r9 = ctype(r3)
            java.lang.String r0 = "application/json"
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L65
            if (r7 == 0) goto L65
            org.json.JSONObject r9 = buildJsonResp(r7)     // Catch: java.lang.Exception -> L56
            int r0 = r3.code()     // Catch: java.lang.Exception -> L54
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 == r1) goto L71
            java.lang.String r0 = new java.lang.String     // Catch: java.lang.Exception -> L54
            java.lang.String r1 = "utf-8"
            r0.<init>(r7, r1)     // Catch: java.lang.Exception -> L54
            java.lang.String r7 = "error"
            java.lang.String r8 = r9.optString(r7, r0)     // Catch: java.lang.Exception -> L54
            goto L71
        L54:
            r7 = move-exception
            goto L58
        L56:
            r7 = move-exception
            r9 = r5
        L58:
            int r0 = r3.code()
            r1 = 300(0x12c, float:4.2E-43)
            if (r0 >= r1) goto L71
            java.lang.String r8 = r7.getMessage()
            goto L71
        L65:
            if (r7 != 0) goto L6b
            java.lang.String r7 = "null body"
            r8 = r7
            goto L70
        L6b:
            java.lang.String r8 = new java.lang.String
            r8.<init>(r7)
        L70:
            r9 = r5
        L71:
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            okhttp3.Headers r0 = r3.headers()
            int r0 = r0.size()
        L7e:
            if (r6 >= r0) goto L9a
            okhttp3.Headers r1 = r3.headers()
            java.lang.String r1 = r1.name(r6)
            java.lang.String r1 = r1.toLowerCase()
            okhttp3.Headers r2 = r3.headers()
            java.lang.String r2 = r2.value(r6)
            r7.put(r1, r2)
            int r6 = r6 + 1
            goto L7e
        L9a:
            com.qiniu.android.http.ResponseInfo r3 = com.qiniu.android.http.ResponseInfo.create(r5, r4, r7, r9, r8)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.android.bigdata.client.Client.buildResponseInfo(okhttp3.Response, java.lang.String, long, com.qiniu.android.storage.UpToken, long):com.qiniu.android.http.ResponseInfo");
    }

    private static String ctype(Response response) {
        MediaType contentType = response.body().contentType();
        if (contentType == null) {
            return "";
        }
        return contentType.type() + MqttTopic.TOPIC_LEVEL_SEPARATOR + contentType.subtype();
    }

    private static long getContentLength(Response response) {
        try {
            RequestBody body = response.request().body();
            if (body == null) {
                return 0L;
            }
            return body.contentLength();
        } catch (Throwable unused) {
            return -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onRet(Response response, String str, long j2, UpToken upToken, long j3, final CompletionHandler completionHandler) {
        final ResponseInfo buildResponseInfo = buildResponseInfo(response, str, j2, upToken, j3);
        AsyncRun.runInMain(new Runnable() { // from class: com.qiniu.android.bigdata.client.Client.3
            @Override // java.lang.Runnable
            public void run() {
                CompletionHandler completionHandler2 = CompletionHandler.this;
                ResponseInfo responseInfo = buildResponseInfo;
                completionHandler2.complete(responseInfo, responseInfo.response);
            }
        });
    }

    private ResponseInfo send(final Request.Builder builder, StringMap stringMap) {
        if (stringMap != null) {
            stringMap.forEach(new StringMap.Consumer() { // from class: com.qiniu.android.bigdata.client.Client.7
                @Override // com.qiniu.android.utils.StringMap.Consumer
                public void accept(String str, Object obj) {
                    builder.header(str, obj.toString());
                }
            });
        }
        builder.header("User-Agent", UserAgent.instance().getUa(""));
        System.currentTimeMillis();
        ResponseTag responseTag = new ResponseTag();
        try {
            return buildResponseInfo(this.httpClient.newCall(builder.tag(responseTag).build()).execute(), responseTag.ip, responseTag.duration, null, 0L);
        } catch (IOException e2) {
            e2.printStackTrace();
            return ResponseInfo.create(null, -1, null, null, e2.getMessage());
        }
    }

    private static String via(Response response) {
        String header = response.header("X-Via", "");
        if (header.equals("")) {
            String header2 = response.header("X-Px", "");
            if (header2.equals("")) {
                String header3 = response.header("Fw-Via", "");
                if (!header3.equals("")) {
                }
                return header3;
            }
            return header2;
        }
        return header;
    }

    public void asyncGet(String str, StringMap stringMap, UpToken upToken, CompletionHandler completionHandler) {
        asyncSend(new Request.Builder().get().url(str), stringMap, upToken, 0L, completionHandler);
    }

    public void asyncMultipartPost(String str, PostArgs postArgs, UpToken upToken, ProgressHandler progressHandler, CompletionHandler completionHandler, CancellationHandler cancellationHandler) {
        RequestBody create;
        long length;
        if (postArgs.file != null) {
            create = RequestBody.create(MediaType.parse(postArgs.mimeType), postArgs.file);
            length = postArgs.file.length();
        } else {
            create = RequestBody.create(MediaType.parse(postArgs.mimeType), postArgs.data);
            length = postArgs.data.length;
        }
        asyncMultipartPost(str, postArgs.params, upToken, length, progressHandler, postArgs.fileName, create, completionHandler, cancellationHandler);
    }

    public void asyncPost(String str, byte[] bArr, StringMap stringMap, UpToken upToken, long j2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        asyncPost(str, bArr, 0, bArr.length, stringMap, upToken, j2, progressHandler, completionHandler, upCancellationSignal);
    }

    public void asyncSend(final Request.Builder builder, StringMap stringMap, final UpToken upToken, final long j2, final CompletionHandler completionHandler) {
        if (stringMap != null) {
            stringMap.forEach(new StringMap.Consumer() { // from class: com.qiniu.android.bigdata.client.Client.4
                @Override // com.qiniu.android.utils.StringMap.Consumer
                public void accept(String str, Object obj) {
                    builder.header(str, obj.toString());
                }
            });
        }
        if (upToken != null) {
            builder.header("User-Agent", UserAgent.instance().getUa(upToken.accessKey));
        } else {
            builder.header("User-Agent", UserAgent.instance().getUa("pandora"));
        }
        this.httpClient.newCall(builder.tag(new ResponseTag()).build()).enqueue(new Callback() { // from class: com.qiniu.android.bigdata.client.Client.5
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                int i2;
                iOException.printStackTrace();
                String message = iOException.getMessage();
                if (iOException instanceof CancellationHandler.CancellationException) {
                    i2 = -2;
                } else if (iOException instanceof UnknownHostException) {
                    i2 = ResponseInfo.UnknownHost;
                } else if (message != null && message.indexOf("Broken pipe") == 0) {
                    i2 = ResponseInfo.NetworkConnectionLost;
                } else if (iOException instanceof SocketTimeoutException) {
                    i2 = -1001;
                } else {
                    i2 = iOException instanceof ConnectException ? ResponseInfo.CannotConnectToHost : -1;
                }
                completionHandler.complete(ResponseInfo.create(null, i2, null, null, iOException.getMessage()), null);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                ResponseTag responseTag = (ResponseTag) response.request().tag();
                Client.onRet(response, responseTag.ip, responseTag.duration, upToken, j2, completionHandler);
            }
        });
    }

    public ResponseInfo syncGet(String str, StringMap stringMap) {
        return send(new Request.Builder().get().url(str), stringMap);
    }

    public ResponseInfo syncMultipartPost(String str, PostArgs postArgs, UpToken upToken) {
        RequestBody create;
        long length;
        if (postArgs.file != null) {
            create = RequestBody.create(MediaType.parse(postArgs.mimeType), postArgs.file);
            length = postArgs.file.length();
        } else {
            create = RequestBody.create(MediaType.parse(postArgs.mimeType), postArgs.data);
            length = postArgs.data.length;
        }
        return syncMultipartPost(str, postArgs.params, upToken, length, postArgs.fileName, create);
    }

    public ResponseInfo syncSend(final Request.Builder builder, StringMap stringMap, UpToken upToken, long j2) {
        if (stringMap != null) {
            stringMap.forEach(new StringMap.Consumer() { // from class: com.qiniu.android.bigdata.client.Client.9
                @Override // com.qiniu.android.utils.StringMap.Consumer
                public void accept(String str, Object obj) {
                    builder.header(str, obj.toString());
                }
            });
        }
        builder.header("User-Agent", UserAgent.instance().getUa(upToken.accessKey));
        ResponseTag responseTag = new ResponseTag();
        try {
            return buildResponseInfo(this.httpClient.newCall(builder.tag(responseTag).build()).execute(), responseTag.ip, responseTag.duration, upToken, j2);
        } catch (Exception e2) {
            e2.printStackTrace();
            int i2 = -1;
            String message = e2.getMessage();
            if (e2 instanceof UnknownHostException) {
                i2 = ResponseInfo.UnknownHost;
            } else if (message != null && message.indexOf("Broken pipe") == 0) {
                i2 = ResponseInfo.NetworkConnectionLost;
            } else if (e2 instanceof SocketTimeoutException) {
                i2 = -1001;
            } else if (e2 instanceof ConnectException) {
                i2 = ResponseInfo.CannotConnectToHost;
            }
            return ResponseInfo.create(null, i2, null, null, e2.getMessage());
        }
    }

    public Client(ProxyConfiguration proxyConfiguration, int i2, int i3, UrlConverter urlConverter, Dns dns) {
        this.converter = urlConverter;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (proxyConfiguration != null) {
            builder.proxy(proxyConfiguration.proxy());
            if (proxyConfiguration.user != null && proxyConfiguration.password != null) {
                builder.proxyAuthenticator(proxyConfiguration.authenticator());
            }
        }
        builder.dns(new okhttp3.Dns() { // from class: com.qiniu.android.bigdata.client.Client.1
            @Override // okhttp3.Dns
            public List<InetAddress> lookup(String str) throws UnknownHostException {
                InetAddress byName;
                List<IDnsNetworkAddress> inetAddressByHost = DnsPrefetcher.getInstance().getInetAddressByHost(str);
                if (inetAddressByHost != null && inetAddressByHost.size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (IDnsNetworkAddress iDnsNetworkAddress : inetAddressByHost) {
                        if (iDnsNetworkAddress.getIpValue() != null && (byName = InetAddress.getByName(iDnsNetworkAddress.getIpValue())) != null) {
                            arrayList.add(byName);
                        }
                    }
                    if (arrayList.size() > 0) {
                        return arrayList;
                    }
                }
                return okhttp3.Dns.SYSTEM.lookup(str);
            }
        });
        builder.networkInterceptors().add(new Interceptor() { // from class: com.qiniu.android.bigdata.client.Client.2
            @Override // okhttp3.Interceptor
            public Response intercept(Interceptor.Chain chain) throws IOException {
                String str;
                Request request = chain.request();
                long currentTimeMillis = System.currentTimeMillis();
                Response proceed = chain.proceed(request);
                long currentTimeMillis2 = System.currentTimeMillis();
                ResponseTag responseTag = (ResponseTag) request.tag();
                try {
                    str = chain.connection().socket().getRemoteSocketAddress().toString();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    str = "";
                }
                responseTag.ip = str;
                responseTag.duration = currentTimeMillis2 - currentTimeMillis;
                return proceed;
            }
        });
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builder.connectTimeout(i2, timeUnit);
        builder.readTimeout(i3, timeUnit);
        builder.writeTimeout(0L, timeUnit);
        this.httpClient = builder.build();
    }

    public void asyncPost(String str, byte[] bArr, int i2, int i3, StringMap stringMap, UpToken upToken, long j2, ProgressHandler progressHandler, CompletionHandler completionHandler, CancellationHandler cancellationHandler) {
        RequestBody create;
        Object obj;
        UrlConverter urlConverter = this.converter;
        String convert = urlConverter != null ? urlConverter.convert(str) : str;
        if (bArr != null && bArr.length > 0) {
            MediaType parse = MediaType.parse("application/octet-stream");
            if (stringMap != null && (obj = stringMap.get("Content-Type")) != null) {
                parse = MediaType.parse(obj.toString());
            }
            create = RequestBody.create(parse, bArr, i2, i3);
        } else {
            create = RequestBody.create((MediaType) null, new byte[0]);
        }
        CountingRequestBody countingRequestBody = create;
        if (progressHandler != null || cancellationHandler != null) {
            countingRequestBody = new CountingRequestBody(countingRequestBody, progressHandler, j2, cancellationHandler);
        }
        asyncSend(new Request.Builder().url(convert).post(countingRequestBody), stringMap, upToken, j2, completionHandler);
    }

    private void asyncMultipartPost(String str, StringMap stringMap, UpToken upToken, long j2, ProgressHandler progressHandler, String str2, RequestBody requestBody, CompletionHandler completionHandler, CancellationHandler cancellationHandler) {
        UrlConverter urlConverter = this.converter;
        String convert = urlConverter != null ? urlConverter.convert(str) : str;
        final MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.addFormDataPart("file", str2, requestBody);
        stringMap.forEach(new StringMap.Consumer() { // from class: com.qiniu.android.bigdata.client.Client.6
            @Override // com.qiniu.android.utils.StringMap.Consumer
            public void accept(String str3, Object obj) {
                builder.addFormDataPart(str3, obj.toString());
            }
        });
        builder.setType(MediaType.parse(HttpConnection.MULTIPART_FORM_DATA));
        RequestBody build = builder.build();
        if (progressHandler != null || cancellationHandler != null) {
            build = new CountingRequestBody(build, progressHandler, j2, cancellationHandler);
        }
        asyncSend(new Request.Builder().url(convert).post(build), null, upToken, j2, completionHandler);
    }

    private ResponseInfo syncMultipartPost(String str, StringMap stringMap, UpToken upToken, long j2, String str2, RequestBody requestBody) {
        final MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.addFormDataPart("file", str2, requestBody);
        stringMap.forEach(new StringMap.Consumer() { // from class: com.qiniu.android.bigdata.client.Client.8
            @Override // com.qiniu.android.utils.StringMap.Consumer
            public void accept(String str3, Object obj) {
                builder.addFormDataPart(str3, obj.toString());
            }
        });
        builder.setType(MediaType.parse(HttpConnection.MULTIPART_FORM_DATA));
        return syncSend(new Request.Builder().url(str).post(builder.build()), null, upToken, j2);
    }
}
