package com.qiniu.android.http.serverRegion;

import com.qiniu.android.http.request.IUploadServer;

/* loaded from: classes3.dex */
public class UploadServer extends IUploadServer {
    private final String host;
    private String httpVersion;
    private final String ip;
    private final Long ipPrefetchedTime;
    private final String serverId;
    private final String source;

    public UploadServer(String str, String str2, String str3, String str4, Long l2) {
        this.serverId = str;
        this.host = str2;
        this.ip = str3;
        this.source = str4;
        this.ipPrefetchedTime = l2;
    }

    @Override // com.qiniu.android.http.request.IUploadServer
    public String getHost() {
        return this.host;
    }

    @Override // com.qiniu.android.http.request.IUploadServer
    public String getHttpVersion() {
        return this.httpVersion;
    }

    @Override // com.qiniu.android.http.request.IUploadServer
    public String getIp() {
        return this.ip;
    }

    @Override // com.qiniu.android.http.request.IUploadServer
    public Long getIpPrefetchedTime() {
        return this.ipPrefetchedTime;
    }

    @Override // com.qiniu.android.http.request.IUploadServer
    public String getServerId() {
        return this.serverId;
    }

    @Override // com.qiniu.android.http.request.IUploadServer
    public String getSource() {
        return this.source;
    }

    public void setHttpVersion(String str) {
        this.httpVersion = str;
    }
}
