package com.umeng.umzid;

import android.text.TextUtils;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* loaded from: classes3.dex */
public final class b implements HostnameVerifier {
    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "utoken.umeng.com".equalsIgnoreCase(str) || "pre-aaid.umeng.com".equalsIgnoreCase(str);
    }
}
