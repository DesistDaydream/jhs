package com.ss.android.socialbase.appdownloader.f.a;

import java.io.PrintStream;

/* loaded from: classes3.dex */
public class h extends Exception {
    public Throwable a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public int f5492c;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public h(java.lang.String r4, com.ss.android.socialbase.appdownloader.f.a.g r5, java.lang.Throwable r6) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = ""
            if (r4 != 0) goto Lb
            r4 = r1
            goto L1c
        Lb:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            java.lang.String r4 = " "
            r2.append(r4)
            java.lang.String r4 = r2.toString()
        L1c:
            r0.append(r4)
            if (r5 != 0) goto L23
            r4 = r1
            goto L3d
        L23:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r2 = "(position:"
            r4.append(r2)
            java.lang.String r2 = r5.d()
            r4.append(r2)
            java.lang.String r2 = ") "
            r4.append(r2)
            java.lang.String r4 = r4.toString()
        L3d:
            r0.append(r4)
            if (r6 != 0) goto L43
            goto L54
        L43:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r1 = "caused by: "
            r4.append(r1)
            r4.append(r6)
            java.lang.String r1 = r4.toString()
        L54:
            r0.append(r1)
            java.lang.String r4 = r0.toString()
            r3.<init>(r4)
            r4 = -1
            r3.b = r4
            r3.f5492c = r4
            if (r5 == 0) goto L71
            int r4 = r5.c()
            r3.b = r4
            int r4 = r5.f()
            r3.f5492c = r4
        L71:
            r3.a = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.f.a.h.<init>(java.lang.String, com.ss.android.socialbase.appdownloader.f.a.g, java.lang.Throwable):void");
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        if (this.a == null) {
            super.printStackTrace();
            return;
        }
        synchronized (System.err) {
            PrintStream printStream = System.err;
            printStream.println(super.getMessage() + "; nested exception is:");
            this.a.printStackTrace();
        }
    }
}
