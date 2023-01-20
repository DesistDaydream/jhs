package com.umeng.umzid;

/* loaded from: classes3.dex */
public class Spy {
    public static boolean initSuccess = false;

    static {
        try {
            System.loadLibrary("umeng-spy");
            initSuccess = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String getID() {
        if (initSuccess) {
            return getNativeID();
        }
        return null;
    }

    public static native String getNativeID();

    public static native String getNativeLibraryVersion();

    public static native String getNativeTag(boolean z, boolean z2);

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0037, code lost:
        if (r4 != (-1)) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized java.lang.String getTag(android.content.Context r5) {
        /*
            java.lang.Class<com.umeng.umzid.Spy> r0 = com.umeng.umzid.Spy.class
            monitor-enter(r0)
            r1 = 1
            r2 = 0
            if (r5 == 0) goto L3e
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L3a
            r4 = 14
            if (r3 < r4) goto Lf
            r3 = 1
            goto L10
        Lf:
            r3 = 0
        L10:
            if (r3 == 0) goto L28
            java.lang.String r3 = "http.proxyHost"
            java.lang.String r3 = java.lang.System.getProperty(r3)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r4 = "http.proxyPort"
            java.lang.String r4 = java.lang.System.getProperty(r4)     // Catch: java.lang.Throwable -> L3a
            if (r4 == 0) goto L21
            goto L23
        L21:
            java.lang.String r4 = "-1"
        L23:
            int r4 = java.lang.Integer.parseInt(r4)     // Catch: java.lang.Throwable -> L3a
            goto L30
        L28:
            java.lang.String r3 = android.net.Proxy.getHost(r5)     // Catch: java.lang.Throwable -> L3a
            int r4 = android.net.Proxy.getPort(r5)     // Catch: java.lang.Throwable -> L3a
        L30:
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L3a
            if (r3 != 0) goto L3e
            r3 = -1
            if (r4 == r3) goto L3e
            goto L3f
        L3a:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L4b
        L3e:
            r1 = 0
        L3f:
            if (r5 == 0) goto L45
            boolean r2 = com.umeng.umzid.d.d(r5)     // Catch: java.lang.Throwable -> L4b
        L45:
            java.lang.String r5 = getNativeTag(r1, r2)     // Catch: java.lang.Throwable -> L4b
            monitor-exit(r0)
            return r5
        L4b:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.Spy.getTag(android.content.Context):java.lang.String");
    }

    public static String getVersion() {
        if (initSuccess) {
            return getNativeLibraryVersion();
        }
        return null;
    }
}
