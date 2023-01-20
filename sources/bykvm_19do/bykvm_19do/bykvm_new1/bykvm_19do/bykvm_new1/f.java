package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Printer;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public class f implements Handler.Callback {

    /* renamed from: i  reason: collision with root package name */
    private static Printer f1205i;

    /* renamed from: j  reason: collision with root package name */
    private static f f1206j;

    /* renamed from: k  reason: collision with root package name */
    private static final Printer f1207k = new a();

    /* renamed from: c  reason: collision with root package name */
    private long f1208c;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1213h;
    private int b = 0;

    /* renamed from: d  reason: collision with root package name */
    private final SparseArray<List<Runnable>> f1209d = new SparseArray<>();

    /* renamed from: e  reason: collision with root package name */
    private final List<Printer> f1210e = new LinkedList();

    /* renamed from: f  reason: collision with root package name */
    private final List<Printer> f1211f = new LinkedList();

    /* renamed from: g  reason: collision with root package name */
    private boolean f1212g = false;
    private Handler a = new Handler(h.b().getLooper(), this);

    /* loaded from: classes.dex */
    public static final class a implements Printer {
        @Override // android.util.Printer
        public void println(String str) {
            if (str == null) {
                return;
            }
            if (str.startsWith(">>>>> Dispatching")) {
                f.e().a(str);
            } else if (str.startsWith("<<<<< Finished")) {
                f.e().b(str);
            }
            if (f.f1205i == null || f.f1205i == f.f1207k) {
                return;
            }
            f.f1205i.println(str);
        }
    }

    private f() {
        a();
    }

    private static void a(List<? extends Runnable> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            for (Runnable runnable : list) {
                runnable.run();
            }
        } catch (Exception e2) {
            bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.j.a(e2);
        }
    }

    private void a(List<? extends Printer> list, String str) {
        synchronized (this) {
            if (list != null) {
                if (!list.isEmpty()) {
                    try {
                        for (Printer printer : list) {
                            printer.println(str);
                        }
                    } catch (Exception e2) {
                        bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.j.a(e2);
                    }
                }
            }
        }
    }

    private Printer d() {
        try {
            Field declaredField = Class.forName("android.os.Looper").getDeclaredField("mLogging");
            declaredField.setAccessible(true);
            return (Printer) declaredField.get(Looper.getMainLooper());
        } catch (Exception e2) {
            bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.j.b(e2);
            return null;
        }
    }

    public static f e() {
        if (f1206j == null) {
            synchronized (f.class) {
                try {
                    if (f1206j == null) {
                        f1206j = new f();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f1206j;
    }

    public void a() {
        if (this.f1212g) {
            return;
        }
        this.f1212g = true;
        Printer d2 = d();
        f1205i = d2;
        Printer printer = f1207k;
        if (d2 == printer) {
            f1205i = null;
        }
        Looper.getMainLooper().setMessageLogging(printer);
    }

    public void a(long j2, Runnable runnable) {
        a(j2, runnable, 1, 0L);
    }

    public void a(long j2, Runnable runnable, int i2, long j3) {
        if (j2 < 0) {
            return;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = (int) j2;
            List<Runnable> list = this.f1209d.get(i4);
            if (list == null) {
                synchronized (this.f1209d) {
                    list = this.f1209d.get(i4);
                    if (list == null) {
                        list = new LinkedList<>();
                        this.f1209d.put(i4, list);
                    }
                }
            }
            list.add(runnable);
            j2 += j3;
        }
    }

    public void a(Printer printer) {
        this.f1211f.add(printer);
    }

    public void a(String str) {
        if (!this.f1213h) {
            g.a(32L);
            this.f1213h = true;
        }
        this.f1208c = SystemClock.uptimeMillis();
        try {
            a(this.f1210e, str);
            this.a.sendEmptyMessage(0);
        } catch (Exception e2) {
            bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.j.a(e2);
        }
    }

    public void b(Printer printer) {
        synchronized (this) {
            this.f1210e.add(printer);
        }
    }

    public void b(String str) {
        SystemClock.uptimeMillis();
        try {
            this.a.removeMessages(2);
            a(this.f1211f, str);
            this.a.sendEmptyMessage(1);
        } catch (Exception e2) {
            bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.j.b(e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0070  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean handleMessage(android.os.Message r8) {
        /*
            r7 = this;
            android.os.Handler r0 = r7.a
            r1 = 0
            boolean r0 = r0.hasMessages(r1)
            r2 = 1
            if (r0 == 0) goto Lc
            goto L88
        Lc:
            int r8 = r8.what
            r0 = 2
            if (r8 == 0) goto L44
            if (r8 == r2) goto L1b
            if (r8 == r0) goto L16
            goto L66
        L16:
            android.util.SparseArray<java.util.List<java.lang.Runnable>> r8 = r7.f1209d
            int r1 = r7.b
            goto L58
        L1b:
            android.os.Handler r8 = r7.a
            r8.removeMessages(r0)
            android.util.SparseArray<java.util.List<java.lang.Runnable>> r8 = r7.f1209d
            int r8 = r8.size()
            if (r8 == 0) goto L88
            android.util.SparseArray<java.util.List<java.lang.Runnable>> r8 = r7.f1209d
            int r0 = r8.size()
            int r0 = r0 - r2
            int r8 = r8.keyAt(r0)
            if (r8 != 0) goto L88
            android.util.SparseArray<java.util.List<java.lang.Runnable>> r8 = r7.f1209d
            r0 = 2147483647(0x7fffffff, float:NaN)
            java.lang.Object r8 = r8.get(r0)
            java.util.List r8 = (java.util.List) r8
            a(r8)
            goto L88
        L44:
            r7.b = r1
            android.util.SparseArray<java.util.List<java.lang.Runnable>> r8 = r7.f1209d
            int r8 = r8.size()
            if (r8 == 0) goto L66
            android.util.SparseArray<java.util.List<java.lang.Runnable>> r8 = r7.f1209d
            int r8 = r8.keyAt(r1)
            if (r8 != 0) goto L66
            android.util.SparseArray<java.util.List<java.lang.Runnable>> r8 = r7.f1209d
        L58:
            java.lang.Object r8 = r8.valueAt(r1)
            java.util.List r8 = (java.util.List) r8
            a(r8)
            int r8 = r7.b
            int r8 = r8 + r2
            r7.b = r8
        L66:
            int r8 = r7.b
            android.util.SparseArray<java.util.List<java.lang.Runnable>> r1 = r7.f1209d
            int r1 = r1.size()
            if (r8 >= r1) goto L88
            android.util.SparseArray<java.util.List<java.lang.Runnable>> r8 = r7.f1209d
            int r1 = r7.b
            int r8 = r8.keyAt(r1)
            long r3 = (long) r8
            r5 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 == 0) goto L88
            android.os.Handler r8 = r7.a
            long r5 = r7.f1208c
            long r3 = r3 + r5
            r8.sendEmptyMessageAtTime(r0, r3)
        L88:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.f.handleMessage(android.os.Message):boolean");
    }
}
