package com.qiniu.android.http.request;

/* loaded from: classes3.dex */
public abstract class IUploadServer {
    public static String HttpVersion1 = "http_version_1";
    public static String HttpVersion2 = "http_version_2";
    public static String HttpVersion3 = "http_version_3";

    public abstract String getHost();

    public abstract String getHttpVersion();

    public abstract String getIp();

    public abstract Long getIpPrefetchedTime();

    public abstract String getServerId();

    public abstract String getSource();

    public boolean isHttp2() {
        String httpVersion = getHttpVersion();
        if (httpVersion == null) {
            return false;
        }
        return httpVersion.equals(HttpVersion2);
    }

    public boolean isHttp3() {
        String httpVersion = getHttpVersion();
        if (httpVersion == null) {
            return false;
        }
        return httpVersion.equals(HttpVersion3);
    }
}
