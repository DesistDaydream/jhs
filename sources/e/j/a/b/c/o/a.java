package e.j.a.b.c.o;

import android.content.Context;
import android.os.Binder;
import android.os.StrictMode;
import android.util.Log;
import e.j.a.b.c.x.d0;
import java.util.HashSet;
import javax.annotation.concurrent.GuardedBy;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public abstract class a<T> {

    /* renamed from: d  reason: collision with root package name */
    private static final Object f10349d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private static InterfaceC0338a f10350e;

    /* renamed from: f  reason: collision with root package name */
    private static int f10351f;

    /* renamed from: g  reason: collision with root package name */
    private static Context f10352g;
    @GuardedBy("sLock")

    /* renamed from: h  reason: collision with root package name */
    private static HashSet<String> f10353h;
    public final String a;
    public final T b;

    /* renamed from: c  reason: collision with root package name */
    private T f10354c = null;

    /* renamed from: e.j.a.b.c.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0338a {
        Float a(String str, Float f2);

        Boolean b(String str, Boolean bool);

        Long c(String str, Long l2);

        Integer d(String str, Integer num);

        String getString(String str, String str2);
    }

    public a(String str, T t) {
        this.a = str;
        this.b = t;
    }

    @e.j.a.b.c.m.a
    public static boolean c() {
        synchronized (f10349d) {
        }
        return false;
    }

    @e.j.a.b.c.m.a
    public static a<Float> f(String str, Float f2) {
        return new e(str, f2);
    }

    @e.j.a.b.c.m.a
    public static a<Integer> g(String str, Integer num) {
        return new d(str, num);
    }

    @e.j.a.b.c.m.a
    public static a<Long> h(String str, Long l2) {
        return new c(str, l2);
    }

    @e.j.a.b.c.m.a
    public static a<String> i(String str, String str2) {
        return new f(str, str2);
    }

    @e.j.a.b.c.m.a
    public static a<Boolean> j(String str, boolean z) {
        return new b(str, Boolean.valueOf(z));
    }

    private static boolean l() {
        synchronized (f10349d) {
        }
        return false;
    }

    @e.j.a.b.c.m.a
    public final T a() {
        T t = this.f10354c;
        if (t != null) {
            return t;
        }
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        Object obj = f10349d;
        synchronized (obj) {
        }
        synchronized (obj) {
            f10353h = null;
            f10352g = null;
            try {
            } catch (SecurityException unused) {
                long clearCallingIdentity = Binder.clearCallingIdentity();
                T k2 = k(this.a);
                Binder.restoreCallingIdentity(clearCallingIdentity);
                return k2;
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
            }
        }
        return k(this.a);
    }

    @e.j.a.b.c.m.a
    @Deprecated
    public final T b() {
        return a();
    }

    @e.j.a.b.c.m.a
    @d0
    public void d(T t) {
        Log.w("GservicesValue", "GservicesValue.override(): test should probably call initForTests() first");
        this.f10354c = t;
        synchronized (f10349d) {
            l();
        }
    }

    @e.j.a.b.c.m.a
    @d0
    public void e() {
        this.f10354c = null;
    }

    public abstract T k(String str);
}
