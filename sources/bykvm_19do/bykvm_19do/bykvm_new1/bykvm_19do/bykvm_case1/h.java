package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1;

import android.content.Context;
import androidx.annotation.NonNull;
import java.io.File;

/* loaded from: classes.dex */
public class h {
    public static File a(@NonNull Context context) {
        return new File(b(context), "crash_history");
    }

    public static String a() {
        return String.format("anr_%s.npth", String.valueOf(System.nanoTime()));
    }

    public static String b() {
        return String.format("java_%s.npth", String.valueOf(System.nanoTime()));
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0039 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    @android.annotation.SuppressLint({"SdCardPath"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String b(@androidx.annotation.NonNull android.content.Context r2) {
        /*
            java.io.File r0 = r2.getFilesDir()     // Catch: java.lang.Exception -> L35
            if (r0 == 0) goto Lf
            java.io.File r2 = r2.getFilesDir()     // Catch: java.lang.Exception -> L35
        La:
            java.lang.String r2 = r2.getPath()     // Catch: java.lang.Exception -> L35
            goto L32
        Lf:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L35
            r0.<init>()     // Catch: java.lang.Exception -> L35
            java.lang.String r1 = "/data/data/"
            r0.append(r1)     // Catch: java.lang.Exception -> L35
            java.lang.String r1 = r2.getPackageName()     // Catch: java.lang.Exception -> L35
            r0.append(r1)     // Catch: java.lang.Exception -> L35
            java.lang.String r1 = "/files/"
            r0.append(r1)     // Catch: java.lang.Exception -> L35
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L35
            r1 = 0
            java.io.File r2 = r2.getDir(r0, r1)     // Catch: java.lang.Exception -> L35
            if (r2 == 0) goto L31
            goto La
        L31:
            r2 = 0
        L32:
            if (r2 == 0) goto L39
            goto L3b
        L35:
            r2 = move-exception
            r2.printStackTrace()
        L39:
            java.lang.String r2 = "/sdcard/"
        L3b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.h.b(android.content.Context):java.lang.String");
    }

    public static File c(@NonNull Context context) {
        return new File(b(context), "CrashLogJavaGM");
    }
}
