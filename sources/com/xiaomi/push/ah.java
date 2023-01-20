package com.xiaomi.push;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;

/* loaded from: classes3.dex */
public class ah implements v {
    private static String a = "content://com.vivo.vms.IdProvider/IdentifierId/";
    private static String b = a + "OAID";

    /* renamed from: c  reason: collision with root package name */
    private static String f8254c = a + "VAID_";

    /* renamed from: d  reason: collision with root package name */
    private static String f8255d = a + "AAID_";

    /* renamed from: e  reason: collision with root package name */
    private static String f8256e = a + "OAIDSTATUS";

    /* renamed from: f  reason: collision with root package name */
    private static String f8257f = "persist.sys.identifierid.supported";

    /* renamed from: g  reason: collision with root package name */
    private Context f8258g;

    public ah(Context context) {
        this.f8258g = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002a, code lost:
        if (r10 != null) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002c, code lost:
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003b, code lost:
        if (r10 == null) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003e, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(java.lang.String r10) {
        /*
            r9 = this;
            r0 = 0
            android.content.Context r1 = r9.f8258g     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L3a
            android.content.ContentResolver r2 = r1.getContentResolver()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L3a
            android.net.Uri r3 = android.net.Uri.parse(r10)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L3a
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r10 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L3a
            if (r10 == 0) goto L2a
            boolean r1 = r10.moveToNext()     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L28
            if (r1 == 0) goto L2a
            java.lang.String r1 = "value"
            int r1 = r10.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L28
            java.lang.String r0 = r10.getString(r1)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L28
            goto L2a
        L26:
            r0 = move-exception
            goto L34
        L28:
            goto L3b
        L2a:
            if (r10 == 0) goto L3e
        L2c:
            r10.close()
            goto L3e
        L30:
            r10 = move-exception
            r8 = r0
            r0 = r10
            r10 = r8
        L34:
            if (r10 == 0) goto L39
            r10.close()
        L39:
            throw r0
        L3a:
            r10 = r0
        L3b:
            if (r10 == 0) goto L3e
            goto L2c
        L3e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.ah.a(java.lang.String):java.lang.String");
    }

    public static boolean a(Context context) {
        try {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(Uri.parse(a).getAuthority(), 128);
            if (resolveContentProvider != null) {
                if ((resolveContentProvider.applicationInfo.flags & 1) != 0) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @Override // com.xiaomi.push.v
    public boolean a() {
        return "1".equals(jk.a(f8257f, "0"));
    }

    @Override // com.xiaomi.push.v
    public String b() {
        return a(b);
    }
}
