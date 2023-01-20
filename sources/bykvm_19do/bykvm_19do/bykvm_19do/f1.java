package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.os.SystemProperties;
import bykvm_19do.bykvm_19do.bykvm_19do.a1;

/* loaded from: classes.dex */
public final class f1 implements a1 {
    private static final o0<Boolean> a = new a();

    /* loaded from: classes.dex */
    public static final class a extends o0<Boolean> {
        @Override // bykvm_19do.bykvm_19do.bykvm_19do.o0
        /* renamed from: c */
        public Boolean a(Object... objArr) {
            return Boolean.valueOf("1".equals(f1.b("persist.sys.identifierid.supported", "0")));
        }
    }

    public f1(Context context) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0054, code lost:
        if (r9 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0056, code lost:
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005a, code lost:
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0069, code lost:
        if (r9 == null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006c, code lost:
        r9.printStackTrace();
        bykvm_19do.bykvm_19do.bykvm_19do.t0.b("Oaid#", "OaidVivo#query close cursor exception.", r9);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0032 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v7 */
    @androidx.annotation.Nullable
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(@androidx.annotation.NonNull android.content.Context r9, int r10, java.lang.String r11) {
        /*
            java.lang.String r0 = "OaidVivo#query close cursor exception."
            java.lang.String r1 = "Oaid#"
            r2 = 0
            if (r10 == 0) goto L29
            r3 = 1
            if (r10 == r3) goto L17
            r3 = 2
            if (r10 == r3) goto Lf
            r4 = r2
            goto L30
        Lf:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r3 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_"
            goto L1e
        L17:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r3 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_"
        L1e:
            r10.append(r3)
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            goto L2b
        L29:
            java.lang.String r10 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID"
        L2b:
            android.net.Uri r10 = android.net.Uri.parse(r10)
            r4 = r10
        L30:
            if (r4 == 0) goto L84
            android.content.ContentResolver r3 = r9.getContentResolver()     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r9 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            if (r9 == 0) goto L54
            boolean r10 = r9.moveToNext()     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L73
            if (r10 == 0) goto L54
            java.lang.String r10 = "value"
            int r10 = r9.getColumnIndex(r10)     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L73
            java.lang.String r10 = r9.getString(r10)     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L73
            r2 = r10
            goto L54
        L52:
            r10 = move-exception
            goto L61
        L54:
            if (r9 == 0) goto L84
        L56:
            r9.close()     // Catch: java.lang.Exception -> L5a
            goto L84
        L5a:
            r9 = move-exception
            goto L6c
        L5c:
            r9 = move-exception
            goto L76
        L5e:
            r9 = move-exception
            r10 = r9
            r9 = r2
        L61:
            r10.printStackTrace()     // Catch: java.lang.Throwable -> L73
            java.lang.String r11 = "OaidVivo#query"
            bykvm_19do.bykvm_19do.bykvm_19do.t0.b(r1, r11, r10)     // Catch: java.lang.Throwable -> L73
            if (r9 == 0) goto L84
            goto L56
        L6c:
            r9.printStackTrace()
            bykvm_19do.bykvm_19do.bykvm_19do.t0.b(r1, r0, r9)
            goto L84
        L73:
            r10 = move-exception
            r2 = r9
            r9 = r10
        L76:
            if (r2 == 0) goto L83
            r2.close()     // Catch: java.lang.Exception -> L7c
            goto L83
        L7c:
            r10 = move-exception
            r10.printStackTrace()
            bykvm_19do.bykvm_19do.bykvm_19do.t0.b(r1, r0, r10)
        L83:
            throw r9
        L84:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.f1.a(android.content.Context, int, java.lang.String):java.lang.String");
    }

    public static boolean a() {
        return a.b(new Object[0]).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str, String str2) {
        try {
            return SystemProperties.get(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.a1
    public boolean a(Context context) {
        return a();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.a1
    public a1.a b(Context context) {
        a1.a aVar = new a1.a();
        aVar.a = a(context, 0, null);
        t0.b("Oaid#", "OaidVivo#oaid " + aVar.a);
        return aVar;
    }
}
