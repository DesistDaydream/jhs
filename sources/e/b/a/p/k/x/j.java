package e.b.a.p.k.x;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class j implements e.b.a.p.k.x.b {

    /* renamed from: h  reason: collision with root package name */
    private static final int f9609h = 4194304;
    @VisibleForTesting

    /* renamed from: i  reason: collision with root package name */
    public static final int f9610i = 8;

    /* renamed from: j  reason: collision with root package name */
    private static final int f9611j = 2;
    private final h<a, Object> b;

    /* renamed from: c  reason: collision with root package name */
    private final b f9612c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<Class<?>, NavigableMap<Integer, Integer>> f9613d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<Class<?>, e.b.a.p.k.x.a<?>> f9614e;

    /* renamed from: f  reason: collision with root package name */
    private final int f9615f;

    /* renamed from: g  reason: collision with root package name */
    private int f9616g;

    /* loaded from: classes.dex */
    public static final class a implements m {
        private final b a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        private Class<?> f9617c;

        public a(b bVar) {
            this.a = bVar;
        }

        @Override // e.b.a.p.k.x.m
        public void a() {
            this.a.c(this);
        }

        public void b(int i2, Class<?> cls) {
            this.b = i2;
            this.f9617c = cls;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.b == aVar.b && this.f9617c == aVar.f9617c;
            }
            return false;
        }

        public int hashCode() {
            int i2 = this.b * 31;
            Class<?> cls = this.f9617c;
            return i2 + (cls != null ? cls.hashCode() : 0);
        }

        public String toString() {
            return "Key{size=" + this.b + "array=" + this.f9617c + '}';
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends d<a> {
        @Override // e.b.a.p.k.x.d
        /* renamed from: d */
        public a a() {
            return new a(this);
        }

        public a e(int i2, Class<?> cls) {
            a b = b();
            b.b(i2, cls);
            return b;
        }
    }

    @VisibleForTesting
    public j() {
        this.b = new h<>();
        this.f9612c = new b();
        this.f9613d = new HashMap();
        this.f9614e = new HashMap();
        this.f9615f = 4194304;
    }

    private void g(int i2, Class<?> cls) {
        NavigableMap<Integer, Integer> o = o(cls);
        Integer num = (Integer) o.get(Integer.valueOf(i2));
        if (num != null) {
            if (num.intValue() == 1) {
                o.remove(Integer.valueOf(i2));
                return;
            } else {
                o.put(Integer.valueOf(i2), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i2 + ", this: " + this);
    }

    private void h() {
        i(this.f9615f);
    }

    private void i(int i2) {
        while (this.f9616g > i2) {
            Object f2 = this.b.f();
            e.b.a.v.l.d(f2);
            e.b.a.p.k.x.a j2 = j(f2);
            this.f9616g -= j2.x(f2) * j2.w();
            g(j2.x(f2), f2.getClass());
            if (Log.isLoggable(j2.v(), 2)) {
                Log.v(j2.v(), "evicted: " + j2.x(f2));
            }
        }
    }

    private <T> e.b.a.p.k.x.a<T> j(T t) {
        return k(t.getClass());
    }

    private <T> e.b.a.p.k.x.a<T> k(Class<T> cls) {
        i iVar = (e.b.a.p.k.x.a<T>) this.f9614e.get(cls);
        if (iVar == null) {
            if (cls.equals(int[].class)) {
                iVar = new i();
            } else if (cls.equals(byte[].class)) {
                iVar = new g();
            } else {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            this.f9614e.put(cls, iVar);
        }
        return iVar;
    }

    @Nullable
    private <T> T l(a aVar) {
        return (T) this.b.a(aVar);
    }

    private <T> T n(a aVar, Class<T> cls) {
        e.b.a.p.k.x.a<T> k2 = k(cls);
        T t = (T) l(aVar);
        if (t != null) {
            this.f9616g -= k2.x(t) * k2.w();
            g(k2.x(t), cls);
        }
        if (t == null) {
            if (Log.isLoggable(k2.v(), 2)) {
                Log.v(k2.v(), "Allocated " + aVar.b + " bytes");
            }
            return k2.newArray(aVar.b);
        }
        return t;
    }

    private NavigableMap<Integer, Integer> o(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.f9613d.get(cls);
        if (navigableMap == null) {
            TreeMap treeMap = new TreeMap();
            this.f9613d.put(cls, treeMap);
            return treeMap;
        }
        return navigableMap;
    }

    private boolean p() {
        int i2 = this.f9616g;
        return i2 == 0 || this.f9615f / i2 >= 2;
    }

    private boolean q(int i2) {
        return i2 <= this.f9615f / 2;
    }

    private boolean r(int i2, Integer num) {
        return num != null && (p() || num.intValue() <= i2 * 8);
    }

    @Override // e.b.a.p.k.x.b
    public synchronized void a(int i2) {
        try {
            if (i2 >= 40) {
                b();
            } else if (i2 >= 20 || i2 == 15) {
                i(this.f9615f / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // e.b.a.p.k.x.b
    public synchronized void b() {
        i(0);
    }

    @Override // e.b.a.p.k.x.b
    public synchronized <T> T c(int i2, Class<T> cls) {
        a e2;
        Integer ceilingKey = o(cls).ceilingKey(Integer.valueOf(i2));
        if (r(i2, ceilingKey)) {
            e2 = this.f9612c.e(ceilingKey.intValue(), cls);
        } else {
            e2 = this.f9612c.e(i2, cls);
        }
        return (T) n(e2, cls);
    }

    @Override // e.b.a.p.k.x.b
    public synchronized <T> T d(int i2, Class<T> cls) {
        return (T) n(this.f9612c.e(i2, cls), cls);
    }

    @Override // e.b.a.p.k.x.b
    public synchronized <T> void e(T t) {
        Class<?> cls = t.getClass();
        e.b.a.p.k.x.a<T> k2 = k(cls);
        int x = k2.x(t);
        int w = k2.w() * x;
        if (q(w)) {
            a e2 = this.f9612c.e(x, cls);
            this.b.d(e2, t);
            NavigableMap<Integer, Integer> o = o(cls);
            Integer num = (Integer) o.get(Integer.valueOf(e2.b));
            Integer valueOf = Integer.valueOf(e2.b);
            int i2 = 1;
            if (num != null) {
                i2 = 1 + num.intValue();
            }
            o.put(valueOf, Integer.valueOf(i2));
            this.f9616g += w;
            h();
        }
    }

    @Override // e.b.a.p.k.x.b
    @Deprecated
    public <T> void f(T t, Class<T> cls) {
        e(t);
    }

    public int m() {
        int i2 = 0;
        for (Class<?> cls : this.f9613d.keySet()) {
            for (Integer num : this.f9613d.get(cls).keySet()) {
                i2 += num.intValue() * ((Integer) this.f9613d.get(cls).get(num)).intValue() * k(cls).w();
            }
        }
        return i2;
    }

    public j(int i2) {
        this.b = new h<>();
        this.f9612c = new b();
        this.f9613d = new HashMap();
        this.f9614e = new HashMap();
        this.f9615f = i2;
    }
}
