package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import java.util.List;

/* loaded from: classes3.dex */
public final class ad extends Thread {

    /* renamed from: e  reason: collision with root package name */
    private ac f6679e;

    /* renamed from: f  reason: collision with root package name */
    private a f6680f;
    private boolean a = false;
    private boolean b = true;

    /* renamed from: c  reason: collision with root package name */
    private boolean f6677c = false;

    /* renamed from: d  reason: collision with root package name */
    private int f6678d = 1;

    /* renamed from: g  reason: collision with root package name */
    private boolean f6681g = true;

    /* loaded from: classes3.dex */
    public interface a {
        void a(boolean z, long j2);
    }

    public final void a(boolean z) {
        this.f6681g = z;
        y.c("set record stack trace enable:" + z, new Object[0]);
    }

    public final boolean b() {
        Handler handler = new Handler(Looper.getMainLooper());
        ac acVar = this.f6679e;
        if (acVar != null) {
            acVar.a(5000L);
        } else {
            this.f6679e = new ac(handler, handler.getLooper().getThread().getName(), 5000L);
        }
        if (isAlive()) {
            return false;
        }
        try {
            start();
            return true;
        } catch (Exception e2) {
            y.b(e2);
            return false;
        }
    }

    public final List<com.tencent.bugly.crashreport.crash.anr.c> c() {
        return this.f6679e.b(200000L);
    }

    public final synchronized void d() {
        this.b = false;
        y.c("Record stack trace is disabled.", new Object[0]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0060, code lost:
        r2.d();
     */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            r10 = this;
            long r0 = java.lang.System.currentTimeMillis()
        L4:
            boolean r2 = r10.a
            if (r2 != 0) goto L8f
            com.tencent.bugly.proguard.ac r2 = r10.f6679e     // Catch: java.lang.OutOfMemoryError -> L83 java.lang.Exception -> L89
            r3 = 0
            if (r2 != 0) goto L15
            java.lang.String r2 = "Main handler checker is null. Stop thread monitor."
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.OutOfMemoryError -> L83 java.lang.Exception -> L89
            com.tencent.bugly.proguard.y.c(r2, r3)     // Catch: java.lang.OutOfMemoryError -> L83 java.lang.Exception -> L89
            return
        L15:
            r2.a()     // Catch: java.lang.OutOfMemoryError -> L83 java.lang.Exception -> L89
            r10.a(r2)     // Catch: java.lang.OutOfMemoryError -> L83 java.lang.Exception -> L89
            boolean r4 = r10.f6681g     // Catch: java.lang.OutOfMemoryError -> L83 java.lang.Exception -> L89
            r5 = 1
            if (r4 == 0) goto L5e
            boolean r4 = r10.b     // Catch: java.lang.OutOfMemoryError -> L83 java.lang.Exception -> L89
            if (r4 != 0) goto L25
            goto L5e
        L25:
            long r6 = r2.c()     // Catch: java.lang.OutOfMemoryError -> L83 java.lang.Exception -> L89
            r8 = 1510(0x5e6, double:7.46E-321)
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 <= 0) goto L5e
            r8 = 199990(0x30d36, double:9.8808E-319)
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 < 0) goto L37
            goto L5e
        L37:
            r8 = 5010(0x1392, double:2.4753E-320)
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 > 0) goto L48
            r10.f6678d = r5     // Catch: java.lang.OutOfMemoryError -> L83 java.lang.Exception -> L89
            java.lang.String r4 = "timeSinceMsgSent in [2s, 5s], record stack"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.OutOfMemoryError -> L83 java.lang.Exception -> L89
            com.tencent.bugly.proguard.y.c(r4, r3)     // Catch: java.lang.OutOfMemoryError -> L83 java.lang.Exception -> L89
            r3 = 1
            goto L5e
        L48:
            int r4 = r10.f6678d     // Catch: java.lang.OutOfMemoryError -> L83 java.lang.Exception -> L89
            int r4 = r4 + r5
            r10.f6678d = r4     // Catch: java.lang.OutOfMemoryError -> L83 java.lang.Exception -> L89
            int r6 = r4 + (-1)
            r4 = r4 & r6
            if (r4 != 0) goto L53
            goto L54
        L53:
            r5 = 0
        L54:
            if (r5 == 0) goto L5d
            java.lang.String r4 = "timeSinceMsgSent in (5s, 200s), should record stack:true"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.OutOfMemoryError -> L83 java.lang.Exception -> L89
            com.tencent.bugly.proguard.y.c(r4, r3)     // Catch: java.lang.OutOfMemoryError -> L83 java.lang.Exception -> L89
        L5d:
            r3 = r5
        L5e:
            if (r3 == 0) goto L63
            r2.d()     // Catch: java.lang.OutOfMemoryError -> L83 java.lang.Exception -> L89
        L63:
            com.tencent.bugly.proguard.ad$a r3 = r10.f6680f     // Catch: java.lang.OutOfMemoryError -> L83 java.lang.Exception -> L89
            if (r3 == 0) goto L76
            boolean r4 = r10.b     // Catch: java.lang.OutOfMemoryError -> L83 java.lang.Exception -> L89
            if (r4 == 0) goto L76
            boolean r4 = r2.b()     // Catch: java.lang.OutOfMemoryError -> L83 java.lang.Exception -> L89
            long r5 = r2.c()     // Catch: java.lang.OutOfMemoryError -> L83 java.lang.Exception -> L89
            r3.a(r4, r5)     // Catch: java.lang.OutOfMemoryError -> L83 java.lang.Exception -> L89
        L76:
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.OutOfMemoryError -> L83 java.lang.Exception -> L89
            long r2 = r2 - r0
            r4 = 500(0x1f4, double:2.47E-321)
            long r2 = r2 % r4
            long r4 = r4 - r2
            com.tencent.bugly.proguard.ab.b(r4)     // Catch: java.lang.OutOfMemoryError -> L83 java.lang.Exception -> L89
            goto L4
        L83:
            r2 = move-exception
            com.tencent.bugly.proguard.y.b(r2)
            goto L4
        L89:
            r2 = move-exception
            com.tencent.bugly.proguard.y.b(r2)
            goto L4
        L8f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ad.run():void");
    }

    public final boolean a() {
        this.a = true;
        if (isAlive()) {
            try {
                interrupt();
            } catch (Exception e2) {
                y.b(e2);
            }
            y.d("MainHandlerChecker is reset to null.", new Object[0]);
            this.f6679e = null;
            return true;
        }
        return false;
    }

    public final synchronized void b(boolean z) {
        this.f6677c = true;
    }

    public final void a(a aVar) {
        this.f6680f = aVar;
    }

    private synchronized void a(ac acVar) {
        if (this.b) {
            return;
        }
        if (this.f6677c && !acVar.b()) {
            y.c("Restart getting main stack trace.", new Object[0]);
            this.b = true;
            this.f6677c = false;
        }
    }
}
