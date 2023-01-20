package com.tencent.tpns.baseapi.core.net;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.tpns.baseapi.base.util.Logger;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes3.dex */
public class a {
    private static a a;
    private Context b;

    private a(Context context) {
        this.b = null;
        if (context != null) {
            if (context.getApplicationContext() != null) {
                this.b = context.getApplicationContext();
            } else {
                this.b = context;
            }
        }
    }

    public static a a(Context context) {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a(context);
                }
            }
        }
        return a;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0093 A[Catch: all -> 0x0257, ConnectException -> 0x025c, SocketTimeoutException -> 0x0261, UnknownHostException -> 0x0266, TRY_ENTER, TryCatch #6 {ConnectException -> 0x025c, SocketTimeoutException -> 0x0261, UnknownHostException -> 0x0266, all -> 0x0257, blocks: (B:6:0x0009, B:15:0x0060, B:18:0x0093, B:20:0x00aa, B:22:0x00c0, B:24:0x00e0, B:26:0x00e6, B:28:0x00ed, B:30:0x00f3, B:45:0x0151, B:47:0x0198, B:48:0x01a6, B:50:0x01ac, B:51:0x01bc, B:53:0x01d2, B:54:0x01d5, B:63:0x0250, B:55:0x01d9, B:56:0x0203, B:58:0x0209, B:59:0x0219, B:61:0x022f, B:62:0x024d, B:44:0x0139, B:21:0x00b7, B:14:0x0047), top: B:89:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b7 A[Catch: all -> 0x0257, ConnectException -> 0x025c, SocketTimeoutException -> 0x0261, UnknownHostException -> 0x0266, TryCatch #6 {ConnectException -> 0x025c, SocketTimeoutException -> 0x0261, UnknownHostException -> 0x0266, all -> 0x0257, blocks: (B:6:0x0009, B:15:0x0060, B:18:0x0093, B:20:0x00aa, B:22:0x00c0, B:24:0x00e0, B:26:0x00e6, B:28:0x00ed, B:30:0x00f3, B:45:0x0151, B:47:0x0198, B:48:0x01a6, B:50:0x01ac, B:51:0x01bc, B:53:0x01d2, B:54:0x01d5, B:63:0x0250, B:55:0x01d9, B:56:0x0203, B:58:0x0209, B:59:0x0219, B:61:0x022f, B:62:0x024d, B:44:0x0139, B:21:0x00b7, B:14:0x0047), top: B:89:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0198 A[Catch: all -> 0x0257, ConnectException -> 0x025c, SocketTimeoutException -> 0x0261, UnknownHostException -> 0x0266, TryCatch #6 {ConnectException -> 0x025c, SocketTimeoutException -> 0x0261, UnknownHostException -> 0x0266, all -> 0x0257, blocks: (B:6:0x0009, B:15:0x0060, B:18:0x0093, B:20:0x00aa, B:22:0x00c0, B:24:0x00e0, B:26:0x00e6, B:28:0x00ed, B:30:0x00f3, B:45:0x0151, B:47:0x0198, B:48:0x01a6, B:50:0x01ac, B:51:0x01bc, B:53:0x01d2, B:54:0x01d5, B:63:0x0250, B:55:0x01d9, B:56:0x0203, B:58:0x0209, B:59:0x0219, B:61:0x022f, B:62:0x024d, B:44:0x0139, B:21:0x00b7, B:14:0x0047), top: B:89:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01d9 A[Catch: all -> 0x0257, ConnectException -> 0x025c, SocketTimeoutException -> 0x0261, UnknownHostException -> 0x0266, TryCatch #6 {ConnectException -> 0x025c, SocketTimeoutException -> 0x0261, UnknownHostException -> 0x0266, all -> 0x0257, blocks: (B:6:0x0009, B:15:0x0060, B:18:0x0093, B:20:0x00aa, B:22:0x00c0, B:24:0x00e0, B:26:0x00e6, B:28:0x00ed, B:30:0x00f3, B:45:0x0151, B:47:0x0198, B:48:0x01a6, B:50:0x01ac, B:51:0x01bc, B:53:0x01d2, B:54:0x01d5, B:63:0x0250, B:55:0x01d9, B:56:0x0203, B:58:0x0209, B:59:0x0219, B:61:0x022f, B:62:0x024d, B:44:0x0139, B:21:0x00b7, B:14:0x0047), top: B:89:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(java.lang.String r9, final java.lang.String r10, java.lang.String r11, com.tencent.tpns.baseapi.core.net.HttpRequestCallback r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 674
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tpns.baseapi.core.net.a.a(java.lang.String, java.lang.String, java.lang.String, com.tencent.tpns.baseapi.core.net.HttpRequestCallback, boolean):java.lang.String");
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new URL(str).getHost();
        } catch (MalformedURLException e2) {
            Logger.e("HttpRequest", "getHostName Exception :", e2);
            return "";
        }
    }
}
