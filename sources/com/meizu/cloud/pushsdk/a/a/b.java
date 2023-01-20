package com.meizu.cloud.pushsdk.a.a;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes2.dex */
public class b {
    private static final String a = "b";
    private static final Object b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static b f4618c;

    private b(Context context) {
        try {
            System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        a.a(context);
    }

    public static b a(Context context) {
        if (f4618c == null) {
            synchronized (b) {
                if (f4618c == null) {
                    f4618c = new b(context);
                }
            }
        }
        return f4618c;
    }

    private Map<String, String> a(Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>(2);
        }
        byte[] c2 = a.a().c();
        if (c2 == null || c2.length <= 0) {
            byte[] b2 = a.a().b();
            if (b2 != null && b2.length > 0) {
                String str = new String(a.a().b());
                String str2 = a;
                e.p.a.a.a.e(str2, "attach x_a_key: " + str);
                map.put("X-A-Key", str);
            }
        } else {
            String str3 = new String(c2);
            String str4 = a;
            e.p.a.a.a.e(str4, "attach x_s_key: " + str3);
            map.put("X-S-Key", str3);
        }
        return map;
    }

    private void a(HttpURLConnection httpURLConnection, byte[] bArr) {
        GZIPOutputStream gZIPOutputStream;
        GZIPOutputStream gZIPOutputStream2 = null;
        try {
            gZIPOutputStream = new GZIPOutputStream(httpURLConnection.getOutputStream());
        } catch (Throwable th) {
            th = th;
        }
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.flush();
            try {
                gZIPOutputStream.close();
            } catch (Exception unused) {
            }
        } catch (Throwable th2) {
            th = th2;
            gZIPOutputStream2 = gZIPOutputStream;
            if (gZIPOutputStream2 != null) {
                try {
                    gZIPOutputStream2.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    private void a(URLConnection uRLConnection) {
        try {
            String headerField = uRLConnection.getHeaderField("X-S-Key");
            String str = a;
            e.p.a.a.a.e(str, "get x_s_key = " + headerField);
            if (TextUtils.isEmpty(headerField)) {
                return;
            }
            a.a().a(headerField);
        } catch (NullPointerException unused) {
        }
    }

    private byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int read = inputStream.read();
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(read);
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused) {
                }
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00fc, code lost:
        if (r1 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00fe, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0123, code lost:
        if (r1 != null) goto L26;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.meizu.cloud.pushsdk.a.a.b] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.meizu.cloud.pushsdk.a.a.c b(java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.a.a.b.b(java.lang.String, java.util.Map, java.lang.String):com.meizu.cloud.pushsdk.a.a.c");
    }

    private void b(URLConnection uRLConnection) {
        try {
            String headerField = uRLConnection.getHeaderField("Key-Timeout");
            String str = a;
            e.p.a.a.a.e(str, "get keyTimeout = " + headerField);
        } catch (NullPointerException unused) {
        }
    }

    public c a(String str, Map<String, String> map, String str2) {
        try {
            return b(str, a(map), str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
