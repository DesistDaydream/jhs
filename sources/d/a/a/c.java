package d.a.a;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class c {
    private final TimeUnit a;
    private long b = SystemClock.elapsedRealtime();

    /* renamed from: c  reason: collision with root package name */
    private long f9284c = 0;

    /* renamed from: d  reason: collision with root package name */
    private long f9285d;

    public c(TimeUnit timeUnit) {
        this.a = timeUnit;
    }

    public String a() {
        return b(this.f9285d);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0042 A[Catch: Exception -> 0x000c, TryCatch #0 {Exception -> 0x000c, blocks: (B:4:0x0007, B:10:0x0015, B:12:0x001a, B:25:0x003c, B:28:0x0042, B:29:0x0047, B:31:0x004c, B:15:0x0021, B:17:0x0027, B:18:0x002a, B:20:0x0030, B:21:0x0032, B:22:0x0034, B:24:0x0038), top: B:35:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0047 A[Catch: Exception -> 0x000c, TRY_LEAVE, TryCatch #0 {Exception -> 0x000c, blocks: (B:4:0x0007, B:10:0x0015, B:12:0x001a, B:25:0x003c, B:28:0x0042, B:29:0x0047, B:31:0x004c, B:15:0x0021, B:17:0x0027, B:18:0x002a, B:20:0x0030, B:21:0x0032, B:22:0x0034, B:24:0x0038), top: B:35:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String b(long r6) {
        /*
            r5 = this;
            r0 = 0
            r1 = 0
            int r3 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r3 >= 0) goto Le
            java.lang.String r6 = java.lang.String.valueOf(r0)     // Catch: java.lang.Exception -> Lc
            return r6
        Lc:
            r6 = move-exception
            goto L59
        Le:
            r1 = 86400000(0x5265c00, double:4.2687272E-316)
            int r3 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r3 <= 0) goto L1a
            java.lang.String r6 = r5.b(r1)     // Catch: java.lang.Exception -> Lc
            return r6
        L1a:
            java.util.concurrent.TimeUnit r1 = r5.a     // Catch: java.lang.Exception -> Lc
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Exception -> Lc
            if (r1 != r2) goto L21
            goto L3c
        L21:
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.SECONDS     // Catch: java.lang.Exception -> Lc
            r3 = 1148846080(0x447a0000, float:1000.0)
            if (r1 != r2) goto L2a
            float r6 = (float) r6     // Catch: java.lang.Exception -> Lc
            float r6 = r6 / r3
            goto L3d
        L2a:
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MINUTES     // Catch: java.lang.Exception -> Lc
            r4 = 1114636288(0x42700000, float:60.0)
            if (r1 != r2) goto L34
            float r6 = (float) r6     // Catch: java.lang.Exception -> Lc
            float r6 = r6 / r3
        L32:
            float r6 = r6 / r4
            goto L3d
        L34:
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.HOURS     // Catch: java.lang.Exception -> Lc
            if (r1 != r2) goto L3c
            float r6 = (float) r6     // Catch: java.lang.Exception -> Lc
            float r6 = r6 / r3
            float r6 = r6 / r4
            goto L32
        L3c:
            float r6 = (float) r6     // Catch: java.lang.Exception -> Lc
        L3d:
            r7 = 0
            int r7 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r7 >= 0) goto L47
            java.lang.String r6 = java.lang.String.valueOf(r0)     // Catch: java.lang.Exception -> Lc
            goto L58
        L47:
            java.util.Locale r7 = java.util.Locale.CHINA     // Catch: java.lang.Exception -> Lc
            java.lang.String r1 = "%.3f"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> Lc
            java.lang.Float r6 = java.lang.Float.valueOf(r6)     // Catch: java.lang.Exception -> Lc
            r2[r0] = r6     // Catch: java.lang.Exception -> Lc
            java.lang.String r6 = java.lang.String.format(r7, r1, r2)     // Catch: java.lang.Exception -> Lc
        L58:
            return r6
        L59:
            r6.printStackTrace()
            java.lang.String r6 = java.lang.String.valueOf(r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: d.a.a.c.b(long):java.lang.String");
    }

    public String c() {
        return b((SystemClock.elapsedRealtime() - this.b) + this.f9284c);
    }

    public void d(long j2) {
        this.f9285d = j2;
    }

    public long e() {
        return this.f9285d;
    }

    public void f(long j2) {
        this.f9284c = j2;
    }

    public long g() {
        return this.f9284c;
    }

    public void h(long j2) {
        this.b = j2;
    }

    public long i() {
        return this.b;
    }
}
