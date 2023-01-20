package com.qiniu.android.http.request;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class Request {
    public static final String HttpMethodGet = "GET";
    public static final String HttpMethodHEAD = "HEAD";
    public static final String HttpMethodPOST = "POST";
    public static final String HttpMethodPUT = "PUT";
    public final Map<String, String> allHeaders;
    public String host;
    public byte[] httpBody;
    public final String httpMethod;
    public String ip;
    public final int timeout;
    public final String urlString;

    public Request(String str, String str2, Map<String, String> map, byte[] bArr, int i2) {
        this.urlString = str;
        this.httpMethod = str2 == null ? "GET" : str2;
        this.allHeaders = map == null ? new HashMap<>() : map;
        this.httpBody = bArr == null ? new byte[0] : bArr;
        this.timeout = i2;
    }

    public InetAddress getInetAddress() {
        String str;
        if (this.host != null && (str = this.ip) != null && str.length() != 0) {
            try {
                return InetAddress.getByAddress(this.host, InetAddress.getByName(this.ip).getAddress());
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public boolean isValid() {
        return this.urlString == null || this.httpMethod == null;
    }
}
