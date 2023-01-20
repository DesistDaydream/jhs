package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.lang.Thread;

/* loaded from: classes.dex */
public class h0 implements Thread.UncaughtExceptionHandler {
    private Thread.UncaughtExceptionHandler a = Thread.getDefaultUncaughtExceptionHandler();
    private String b;

    private h0() {
        Thread.setDefaultUncaughtExceptionHandler(this);
        b();
    }

    private void a() {
        try {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().a();
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0125 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.util.Properties] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.lang.Thread r19, java.lang.Throwable r20) {
        /*
            Method dump skipped, instructions count: 316
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.h0.a(java.lang.Thread, java.lang.Throwable):void");
    }

    private void b() {
        File externalFilesDir;
        Context d2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d();
        if (d2 != null) {
            try {
                if ("mounted".equals(Environment.getExternalStorageState()) && (externalFilesDir = d2.getExternalFilesDir("TTCache")) != null) {
                    externalFilesDir.mkdirs();
                    this.b = externalFilesDir.getPath();
                }
                if (!TextUtils.isEmpty(this.b)) {
                    return;
                }
                File file = new File(d2.getFilesDir(), "TTCache");
                file.mkdirs();
                this.b = file.getPath();
            } catch (Throwable unused) {
            }
        }
    }

    public static h0 c() {
        return new h0();
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void uncaughtException(java.lang.Thread r3, java.lang.Throwable r4) {
        /*
            r2 = this;
            java.io.StringWriter r0 = new java.io.StringWriter     // Catch: java.lang.Throwable -> L1a
            r0.<init>()     // Catch: java.lang.Throwable -> L1a
            java.io.PrintWriter r1 = new java.io.PrintWriter     // Catch: java.lang.Throwable -> L1a
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L1a
            r4.printStackTrace(r1)     // Catch: java.lang.Throwable -> L1a
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L1a
            if (r0 == 0) goto L1a
            java.lang.String r1 = "com.bytedance.msdk"
            boolean r0 = r0.contains(r1)     // Catch: java.lang.Throwable -> L1a
            goto L1b
        L1a:
            r0 = 0
        L1b:
            if (r0 == 0) goto L20
            r2.a(r3, r4)
        L20:
            java.lang.Thread$UncaughtExceptionHandler r0 = r2.a
            if (r0 == 0) goto L29
            if (r0 == r2) goto L29
            r0.uncaughtException(r3, r4)
        L29:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.h0.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
    }
}
