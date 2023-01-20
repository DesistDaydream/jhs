package bykvm_19do.bykvm_19do.bykvm_19do;

import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class e2 {
    public boolean a;
    public boolean b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f104c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f105d;

    public e2(boolean z, boolean z2) {
        this.b = z;
        this.f104c = z2;
        this.f105d = false;
    }

    public e2(boolean z, boolean z2, boolean z3) {
        this.b = z;
        this.f104c = z2;
        this.f105d = z3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00de A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(java.lang.String r8, java.lang.String r9) {
        /*
            r7 = this;
            java.lang.String r0 = android.os.Environment.getExternalStorageState()
            java.lang.String r1 = "mounted"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto Le
            goto Ld0
        Le:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.io.File r1 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r1 = r1.getPath()
            r0.append(r1)
            java.lang.String r1 = "/Android/data/com.snssdk.api.embed/cache"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r2 = "/"
            r1.append(r2)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> La2 java.io.IOException -> La5
            r2.<init>(r0)     // Catch: java.lang.Throwable -> La2 java.io.IOException -> La5
            boolean r0 = r2.exists()     // Catch: java.lang.Throwable -> La2 java.io.IOException -> La5
            if (r0 != 0) goto L4d
            boolean r0 = r2.mkdirs()     // Catch: java.lang.Throwable -> La2 java.io.IOException -> La5
            if (r0 == 0) goto Ld0
        L4d:
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> La2 java.io.IOException -> La5
            r0.<init>(r8)     // Catch: java.lang.Throwable -> La2 java.io.IOException -> La5
            java.io.RandomAccessFile r8 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> La2 java.io.IOException -> La5
            java.lang.String r2 = "rwd"
            r8.<init>(r0, r2)     // Catch: java.lang.Throwable -> La2 java.io.IOException -> La5
            java.nio.channels.FileChannel r2 = r8.getChannel()     // Catch: java.io.IOException -> La0 java.lang.Throwable -> Ld1
            java.nio.channels.FileLock r1 = r2.lock()     // Catch: java.io.IOException -> La0 java.lang.Throwable -> Ld1
            boolean r0 = r0.isFile()     // Catch: java.io.IOException -> La0 java.lang.Throwable -> Ld1
            java.lang.String r2 = "UTF-8"
            if (r0 == 0) goto L8b
            r0 = 129(0x81, float:1.81E-43)
            byte[] r3 = new byte[r0]     // Catch: java.io.IOException -> La0 java.lang.Throwable -> Ld1
            r4 = 0
            int r5 = r8.read(r3, r4, r0)     // Catch: java.io.IOException -> La0 java.lang.Throwable -> Ld1
            if (r5 <= 0) goto L8b
            if (r5 >= r0) goto L8b
            java.lang.String r0 = new java.lang.String     // Catch: java.io.IOException -> La0 java.lang.Throwable -> Ld1
            r0.<init>(r3, r4, r5, r2)     // Catch: java.io.IOException -> La0 java.lang.Throwable -> Ld1
            boolean r3 = bykvm_19do.bykvm_19do.bykvm_19do.k2.a(r0)     // Catch: java.io.IOException -> La0 java.lang.Throwable -> Ld1
            if (r3 == 0) goto L8b
            if (r1 == 0) goto L86
            r1.release()     // Catch: java.lang.Exception -> L86
        L86:
            r8.close()     // Catch: java.lang.Exception -> L89
        L89:
            r9 = r0
            goto Ld0
        L8b:
            byte[] r0 = r9.getBytes(r2)     // Catch: java.io.IOException -> La0 java.lang.Throwable -> Ld1
            r2 = 0
            r8.setLength(r2)     // Catch: java.io.IOException -> La0 java.lang.Throwable -> Ld1
            r8.write(r0)     // Catch: java.io.IOException -> La0 java.lang.Throwable -> Ld1
            if (r1 == 0) goto L9c
            r1.release()     // Catch: java.lang.Exception -> L9c
        L9c:
            r8.close()     // Catch: java.lang.Exception -> Ld0
            goto Ld0
        La0:
            r0 = move-exception
            goto La8
        La2:
            r8 = move-exception
            r9 = r1
            goto Ld5
        La5:
            r8 = move-exception
            r0 = r8
            r8 = r1
        La8:
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> Ld1
            r3 = 23
            if (r2 < r3) goto Lc6
            bykvm_19do.bykvm_19do.bykvm_19do.v1 r2 = bykvm_19do.bykvm_19do.bykvm_19do.v1.i()     // Catch: java.lang.Throwable -> Ld1
            android.app.Application r2 = r2.f177c     // Catch: java.lang.Throwable -> Ld1
            java.lang.String r3 = "android.permission.READ_EXTERNAL_STORAGE"
            int r2 = r2.checkSelfPermission(r3)     // Catch: java.lang.Throwable -> Ld1
            if (r2 != 0) goto Lc0
            bykvm_19do.bykvm_19do.bykvm_19do.l0.a(r0)     // Catch: java.lang.Throwable -> Ld1
            goto Lc6
        Lc0:
            java.lang.SecurityException r9 = new java.lang.SecurityException     // Catch: java.lang.Throwable -> Ld1
            r9.<init>(r0)     // Catch: java.lang.Throwable -> Ld1
            throw r9     // Catch: java.lang.Throwable -> Ld1
        Lc6:
            if (r1 == 0) goto Lcd
            r1.release()     // Catch: java.lang.Exception -> Lcc
            goto Lcd
        Lcc:
        Lcd:
            if (r8 == 0) goto Ld0
            goto L9c
        Ld0:
            return r9
        Ld1:
            r9 = move-exception
            r6 = r9
            r9 = r8
            r8 = r6
        Ld5:
            if (r1 == 0) goto Ldc
            r1.release()     // Catch: java.lang.Exception -> Ldb
            goto Ldc
        Ldb:
        Ldc:
            if (r9 == 0) goto Le1
            r9.close()     // Catch: java.lang.Exception -> Le1
        Le1:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.e2.a(java.lang.String, java.lang.String):java.lang.String");
    }

    public abstract boolean a(JSONObject jSONObject);
}
