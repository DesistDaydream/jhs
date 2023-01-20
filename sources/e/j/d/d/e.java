package e.j.d.d;

import e.j.a.b.c.r.a0;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public final class e<T> {
    private final Set<Class<? super T>> a;
    private final Set<o> b;

    /* renamed from: c  reason: collision with root package name */
    private final int f11205c;

    /* renamed from: d  reason: collision with root package name */
    private final int f11206d;

    /* renamed from: e  reason: collision with root package name */
    private final h<T> f11207e;

    /* renamed from: f  reason: collision with root package name */
    private final Set<Class<?>> f11208f;

    @e.j.a.b.c.m.a
    /* loaded from: classes2.dex */
    public static class b<T> {
        private final Set<Class<? super T>> a;
        private final Set<o> b;

        /* renamed from: c  reason: collision with root package name */
        private int f11209c;

        /* renamed from: d  reason: collision with root package name */
        private int f11210d;

        /* renamed from: e  reason: collision with root package name */
        private h<T> f11211e;

        /* renamed from: f  reason: collision with root package name */
        private Set<Class<?>> f11212f;

        /* JADX INFO: Access modifiers changed from: private */
        public b<T> g() {
            this.f11210d = 1;
            return this;
        }

        private b<T> i(int i2) {
            a0.r(this.f11209c == 0, "Instantiation type has already been set.");
            this.f11209c = i2;
            return this;
        }

        private void j(Class<?> cls) {
            a0.b(!this.a.contains(cls), "Components are not allowed to depend on interfaces they themselves provide.");
        }

        @e.j.a.b.c.m.a
        public b<T> b(o oVar) {
            a0.l(oVar, "Null dependency");
            j(oVar.a());
            this.b.add(oVar);
            return this;
        }

        @e.j.a.b.c.m.a
        public b<T> c() {
            return i(1);
        }

        @e.j.a.b.c.m.a
        public e<T> d() {
            a0.r(this.f11211e != null, "Missing required property: factory.");
            return new e<>(new HashSet(this.a), new HashSet(this.b), this.f11209c, this.f11210d, this.f11211e, this.f11212f);
        }

        @e.j.a.b.c.m.a
        public b<T> e() {
            return i(2);
        }

        @e.j.a.b.c.m.a
        public b<T> f(h<T> hVar) {
            this.f11211e = (h) a0.l(hVar, "Null factory");
            return this;
        }

        @e.j.a.b.c.m.a
        public b<T> h(Class<?> cls) {
            this.f11212f.add(cls);
            return this;
        }

        @SafeVarargs
        private b(Class<T> cls, Class<? super T>... clsArr) {
            HashSet hashSet = new HashSet();
            this.a = hashSet;
            this.b = new HashSet();
            this.f11209c = 0;
            this.f11210d = 0;
            this.f11212f = new HashSet();
            a0.l(cls, "Null interface");
            hashSet.add(cls);
            for (Class<? super T> cls2 : clsArr) {
                a0.l(cls2, "Null interface");
            }
            Collections.addAll(this.a, clsArr);
        }
    }

    @e.j.a.b.c.m.a
    public static <T> b<T> a(Class<T> cls) {
        return new b<>(cls, new Class[0]);
    }

    @e.j.a.b.c.m.a
    @SafeVarargs
    public static <T> b<T> b(Class<T> cls, Class<? super T>... clsArr) {
        return new b<>(cls, clsArr);
    }

    @e.j.a.b.c.m.a
    public static <T> e<T> g(T t, Class<T> cls) {
        return h(cls).f(d.b(t)).d();
    }

    @e.j.a.b.c.m.a
    public static <T> b<T> h(Class<T> cls) {
        return a(cls).g();
    }

    public static /* synthetic */ Object m(Object obj, f fVar) {
        return obj;
    }

    public static /* synthetic */ Object n(Object obj, f fVar) {
        return obj;
    }

    public static /* synthetic */ Object o(Object obj, f fVar) {
        return obj;
    }

    @e.j.a.b.c.m.a
    @Deprecated
    public static <T> e<T> p(Class<T> cls, T t) {
        return a(cls).f(e.j.d.d.b.b(t)).d();
    }

    @e.j.a.b.c.m.a
    @SafeVarargs
    public static <T> e<T> q(T t, Class<T> cls, Class<? super T>... clsArr) {
        return b(cls, clsArr).f(c.b(t)).d();
    }

    public Set<o> c() {
        return this.b;
    }

    public h<T> d() {
        return this.f11207e;
    }

    public Set<Class<? super T>> e() {
        return this.a;
    }

    public Set<Class<?>> f() {
        return this.f11208f;
    }

    public boolean i() {
        return this.f11205c == 1;
    }

    public boolean j() {
        return this.f11205c == 2;
    }

    public boolean k() {
        return this.f11205c == 0;
    }

    public boolean l() {
        return this.f11206d == 0;
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.a.toArray()) + ">{" + this.f11205c + ", type=" + this.f11206d + ", deps=" + Arrays.toString(this.b.toArray()) + "}";
    }

    private e(Set<Class<? super T>> set, Set<o> set2, int i2, int i3, h<T> hVar, Set<Class<?>> set3) {
        this.a = Collections.unmodifiableSet(set);
        this.b = Collections.unmodifiableSet(set2);
        this.f11205c = i2;
        this.f11206d = i3;
        this.f11207e = hVar;
        this.f11208f = Collections.unmodifiableSet(set3);
    }
}
