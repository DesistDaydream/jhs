package com.qiniu.android.http;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

/* loaded from: classes3.dex */
public final class ProxyConfiguration {
    public final String hostAddress;
    public final String password;
    public final int port;
    public final Proxy.Type type;
    public final String user;

    public ProxyConfiguration(String str, int i2, String str2, String str3, Proxy.Type type) {
        this.hostAddress = str;
        this.port = i2;
        this.user = str2;
        this.password = str3;
        this.type = type;
    }

    public Authenticator authenticator() {
        return new Authenticator() { // from class: com.qiniu.android.http.ProxyConfiguration.1
            @Override // okhttp3.Authenticator
            public Request authenticate(Route route, Response response) throws IOException {
                ProxyConfiguration proxyConfiguration = ProxyConfiguration.this;
                return response.request().newBuilder().header("Proxy-Authorization", Credentials.basic(proxyConfiguration.user, proxyConfiguration.password)).header("Proxy-Connection", "Keep-Alive").build();
            }
        };
    }

    public Proxy proxy() {
        return new Proxy(this.type, new InetSocketAddress(this.hostAddress, this.port));
    }

    public ProxyConfiguration(String str, int i2) {
        this(str, i2, null, null, Proxy.Type.HTTP);
    }
}
