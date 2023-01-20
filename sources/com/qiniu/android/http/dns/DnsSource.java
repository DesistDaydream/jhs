package com.qiniu.android.http.dns;

/* loaded from: classes3.dex */
public class DnsSource {
    public static final String Custom = "customized";
    public static final String Dnspod = "dnspod";
    public static final String Doh = "doh";
    public static final String None = "none";
    public static final String System = "system";
    public static final String Udp = "dns";

    public static boolean isCustom(String str) {
        return str != null && str.contains(Custom);
    }

    public static boolean isDnspod(String str) {
        return str != null && str.contains(Dnspod);
    }

    public static boolean isDoh(String str) {
        return str != null && str.contains(Doh);
    }

    public static boolean isSystem(String str) {
        return str != null && str.contains(System);
    }

    public static boolean isUdp(String str) {
        return str != null && str.contains(Udp);
    }
}
