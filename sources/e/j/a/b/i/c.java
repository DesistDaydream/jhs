package e.j.a.b.i;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e.j.a.b.c.r.a0;
import e.j.a.b.c.r.d0;
import e.j.a.b.c.x.b0;
import e.j.a.b.c.x.e0;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.ThreadSafe;

@e.j.a.b.c.m.a
@d0
@ThreadSafe
/* loaded from: classes2.dex */
public class c {
    private static ScheduledExecutorService n;
    private static volatile a o = new d();
    private final Object a;
    private final PowerManager.WakeLock b;

    /* renamed from: c  reason: collision with root package name */
    private WorkSource f10522c;

    /* renamed from: d  reason: collision with root package name */
    private final int f10523d;

    /* renamed from: e  reason: collision with root package name */
    private final String f10524e;

    /* renamed from: f  reason: collision with root package name */
    private final String f10525f;

    /* renamed from: g  reason: collision with root package name */
    private final String f10526g;

    /* renamed from: h  reason: collision with root package name */
    private final Context f10527h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f10528i;

    /* renamed from: j  reason: collision with root package name */
    private final Map<String, Integer[]> f10529j;

    /* renamed from: k  reason: collision with root package name */
    private final Set<Future<?>> f10530k;

    /* renamed from: l  reason: collision with root package name */
    private int f10531l;

    /* renamed from: m  reason: collision with root package name */
    private AtomicInteger f10532m;

    /* loaded from: classes2.dex */
    public interface a {
    }

    @e.j.a.b.c.m.a
    public c(@NonNull Context context, int i2, @NonNull String str) {
        this(context, i2, str, null, context == null ? null : context.getPackageName());
    }

    private final String e(String str) {
        return (!this.f10528i || TextUtils.isEmpty(str)) ? this.f10525f : str;
    }

    private final List<String> f() {
        return e0.c(this.f10522c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(int i2) {
        if (this.b.isHeld()) {
            try {
                this.b.release();
            } catch (RuntimeException e2) {
                if (e2.getClass().equals(RuntimeException.class)) {
                    Log.e("WakeLock", String.valueOf(this.f10524e).concat(" was already released!"), e2);
                } else {
                    throw e2;
                }
            }
            this.b.isHeld();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0054, code lost:
        if (r2 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005c, code lost:
        if (r13.f10531l == 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005e, code lost:
        e.j.a.b.c.w.d.a().e(r13.f10527h, e.j.a.b.c.w.c.b(r13.b, r6), 7, r13.f10524e, r6, null, r13.f10523d, f(), r14);
        r13.f10531l++;
     */
    @e.j.a.b.c.m.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(long r14) {
        /*
            r13 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = r13.f10532m
            r0.incrementAndGet()
            r0 = 0
            java.lang.String r6 = r13.e(r0)
            java.lang.Object r0 = r13.a
            monitor-enter(r0)
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.f10529j     // Catch: java.lang.Throwable -> L96
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L96
            r2 = 0
            if (r1 == 0) goto L1a
            int r1 = r13.f10531l     // Catch: java.lang.Throwable -> L96
            if (r1 <= 0) goto L29
        L1a:
            android.os.PowerManager$WakeLock r1 = r13.b     // Catch: java.lang.Throwable -> L96
            boolean r1 = r1.isHeld()     // Catch: java.lang.Throwable -> L96
            if (r1 != 0) goto L29
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.f10529j     // Catch: java.lang.Throwable -> L96
            r1.clear()     // Catch: java.lang.Throwable -> L96
            r13.f10531l = r2     // Catch: java.lang.Throwable -> L96
        L29:
            boolean r1 = r13.f10528i     // Catch: java.lang.Throwable -> L96
            r12 = 1
            if (r1 == 0) goto L56
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.f10529j     // Catch: java.lang.Throwable -> L96
            java.lang.Object r1 = r1.get(r6)     // Catch: java.lang.Throwable -> L96
            java.lang.Integer[] r1 = (java.lang.Integer[]) r1     // Catch: java.lang.Throwable -> L96
            if (r1 != 0) goto L47
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.f10529j     // Catch: java.lang.Throwable -> L96
            java.lang.Integer[] r3 = new java.lang.Integer[r12]     // Catch: java.lang.Throwable -> L96
            java.lang.Integer r4 = java.lang.Integer.valueOf(r12)     // Catch: java.lang.Throwable -> L96
            r3[r2] = r4     // Catch: java.lang.Throwable -> L96
            r1.put(r6, r3)     // Catch: java.lang.Throwable -> L96
            r2 = 1
            goto L54
        L47:
            r3 = r1[r2]     // Catch: java.lang.Throwable -> L96
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> L96
            int r3 = r3 + r12
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L96
            r1[r2] = r3     // Catch: java.lang.Throwable -> L96
        L54:
            if (r2 != 0) goto L5e
        L56:
            boolean r1 = r13.f10528i     // Catch: java.lang.Throwable -> L96
            if (r1 != 0) goto L7d
            int r1 = r13.f10531l     // Catch: java.lang.Throwable -> L96
            if (r1 != 0) goto L7d
        L5e:
            e.j.a.b.c.w.d r1 = e.j.a.b.c.w.d.a()     // Catch: java.lang.Throwable -> L96
            android.content.Context r2 = r13.f10527h     // Catch: java.lang.Throwable -> L96
            android.os.PowerManager$WakeLock r3 = r13.b     // Catch: java.lang.Throwable -> L96
            java.lang.String r3 = e.j.a.b.c.w.c.b(r3, r6)     // Catch: java.lang.Throwable -> L96
            r4 = 7
            java.lang.String r5 = r13.f10524e     // Catch: java.lang.Throwable -> L96
            r7 = 0
            int r8 = r13.f10523d     // Catch: java.lang.Throwable -> L96
            java.util.List r9 = r13.f()     // Catch: java.lang.Throwable -> L96
            r10 = r14
            r1.e(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L96
            int r1 = r13.f10531l     // Catch: java.lang.Throwable -> L96
            int r1 = r1 + r12
            r13.f10531l = r1     // Catch: java.lang.Throwable -> L96
        L7d:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L96
            android.os.PowerManager$WakeLock r0 = r13.b
            r0.acquire()
            r0 = 0
            int r2 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r2 <= 0) goto L95
            java.util.concurrent.ScheduledExecutorService r0 = e.j.a.b.i.c.n
            e.j.a.b.i.e r1 = new e.j.a.b.i.e
            r1.<init>(r13)
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS
            r0.schedule(r1, r14, r2)
        L95:
            return
        L96:
            r14 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L96
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: e.j.a.b.i.c.a(long):void");
    }

    @e.j.a.b.c.m.a
    public boolean b() {
        return this.b.isHeld();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0050, code lost:
        if (r1 != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0058, code lost:
        if (r12.f10531l == 1) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005a, code lost:
        e.j.a.b.c.w.d.a().d(r12.f10527h, e.j.a.b.c.w.c.b(r12.b, r6), 8, r12.f10524e, r6, null, r12.f10523d, f());
        r12.f10531l--;
     */
    @e.j.a.b.c.m.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c() {
        /*
            r12 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = r12.f10532m
            int r0 = r0.decrementAndGet()
            if (r0 >= 0) goto L19
            java.lang.String r0 = "WakeLock"
            java.lang.String r1 = r12.f10524e
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = " release without a matched acquire!"
            java.lang.String r1 = r1.concat(r2)
            android.util.Log.e(r0, r1)
        L19:
            r0 = 0
            java.lang.String r6 = r12.e(r0)
            java.lang.Object r0 = r12.a
            monitor-enter(r0)
            boolean r1 = r12.f10528i     // Catch: java.lang.Throwable -> L7e
            r10 = 1
            r11 = 0
            if (r1 == 0) goto L52
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r12.f10529j     // Catch: java.lang.Throwable -> L7e
            java.lang.Object r1 = r1.get(r6)     // Catch: java.lang.Throwable -> L7e
            java.lang.Integer[] r1 = (java.lang.Integer[]) r1     // Catch: java.lang.Throwable -> L7e
            if (r1 != 0) goto L33
        L31:
            r1 = 0
            goto L50
        L33:
            r2 = r1[r11]     // Catch: java.lang.Throwable -> L7e
            int r2 = r2.intValue()     // Catch: java.lang.Throwable -> L7e
            if (r2 != r10) goto L42
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r12.f10529j     // Catch: java.lang.Throwable -> L7e
            r1.remove(r6)     // Catch: java.lang.Throwable -> L7e
            r1 = 1
            goto L50
        L42:
            r2 = r1[r11]     // Catch: java.lang.Throwable -> L7e
            int r2 = r2.intValue()     // Catch: java.lang.Throwable -> L7e
            int r2 = r2 - r10
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L7e
            r1[r11] = r2     // Catch: java.lang.Throwable -> L7e
            goto L31
        L50:
            if (r1 != 0) goto L5a
        L52:
            boolean r1 = r12.f10528i     // Catch: java.lang.Throwable -> L7e
            if (r1 != 0) goto L79
            int r1 = r12.f10531l     // Catch: java.lang.Throwable -> L7e
            if (r1 != r10) goto L79
        L5a:
            e.j.a.b.c.w.d r1 = e.j.a.b.c.w.d.a()     // Catch: java.lang.Throwable -> L7e
            android.content.Context r2 = r12.f10527h     // Catch: java.lang.Throwable -> L7e
            android.os.PowerManager$WakeLock r3 = r12.b     // Catch: java.lang.Throwable -> L7e
            java.lang.String r3 = e.j.a.b.c.w.c.b(r3, r6)     // Catch: java.lang.Throwable -> L7e
            r4 = 8
            java.lang.String r5 = r12.f10524e     // Catch: java.lang.Throwable -> L7e
            r7 = 0
            int r8 = r12.f10523d     // Catch: java.lang.Throwable -> L7e
            java.util.List r9 = r12.f()     // Catch: java.lang.Throwable -> L7e
            r1.d(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L7e
            int r1 = r12.f10531l     // Catch: java.lang.Throwable -> L7e
            int r1 = r1 - r10
            r12.f10531l = r1     // Catch: java.lang.Throwable -> L7e
        L79:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7e
            r12.g(r11)
            return
        L7e:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7e
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.j.a.b.i.c.c():void");
    }

    @e.j.a.b.c.m.a
    public void d(boolean z) {
        this.b.setReferenceCounted(z);
        this.f10528i = z;
    }

    private c(@NonNull Context context, int i2, @NonNull String str, @Nullable String str2, @NonNull String str3) {
        this(context, i2, str, null, str3, null);
    }

    @SuppressLint({"UnwrappedWakeLock"})
    private c(@NonNull Context context, int i2, @NonNull String str, @Nullable String str2, @NonNull String str3, @Nullable String str4) {
        this.a = this;
        this.f10528i = true;
        this.f10529j = new HashMap();
        this.f10530k = Collections.synchronizedSet(new HashSet());
        this.f10532m = new AtomicInteger(0);
        a0.l(context, "WakeLock: context must not be null");
        a0.h(str, "WakeLock: wakeLockName must not be empty");
        this.f10523d = i2;
        this.f10525f = null;
        this.f10526g = null;
        Context applicationContext = context.getApplicationContext();
        this.f10527h = applicationContext;
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            String valueOf = String.valueOf(str);
            this.f10524e = valueOf.length() != 0 ? "*gcore*:".concat(valueOf) : new String("*gcore*:");
        } else {
            this.f10524e = str;
        }
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(i2, str);
        this.b = newWakeLock;
        if (e0.d(context)) {
            WorkSource a2 = e0.a(context, b0.b(str3) ? context.getPackageName() : str3);
            this.f10522c = a2;
            if (a2 != null && e0.d(applicationContext)) {
                WorkSource workSource = this.f10522c;
                if (workSource != null) {
                    workSource.add(a2);
                } else {
                    this.f10522c = a2;
                }
                try {
                    newWakeLock.setWorkSource(this.f10522c);
                } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e2) {
                    Log.wtf("WakeLock", e2.toString());
                }
            }
        }
        if (n == null) {
            n = e.j.a.b.c.t.a.a().a();
        }
    }
}
