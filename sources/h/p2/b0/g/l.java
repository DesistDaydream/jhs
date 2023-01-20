package h.p2.b0.g;

import java.lang.ref.SoftReference;

/* loaded from: classes3.dex */
public class l {

    /* loaded from: classes3.dex */
    public static class a<T> extends c<T> implements h.k2.u.a<T> {
        private final h.k2.u.a<T> b;

        /* renamed from: c  reason: collision with root package name */
        private volatile SoftReference<Object> f14998c;

        public a(@k.e.a.e T t, @k.e.a.d h.k2.u.a<T> aVar) {
            if (aVar == null) {
                d(0);
            }
            this.f14998c = null;
            this.b = aVar;
            if (t != null) {
                this.f14998c = new SoftReference<>(a(t));
            }
        }

        private static /* synthetic */ void d(int i2) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal", "<init>"));
        }

        @Override // h.p2.b0.g.l.c, h.k2.u.a
        public T invoke() {
            Object obj;
            SoftReference<Object> softReference = this.f14998c;
            if (softReference != null && (obj = softReference.get()) != null) {
                return c(obj);
            }
            T invoke = this.b.invoke();
            this.f14998c = new SoftReference<>(a(invoke));
            return invoke;
        }
    }

    /* loaded from: classes3.dex */
    public static class b<T> extends c<T> {
        private final h.k2.u.a<T> b;

        /* renamed from: c  reason: collision with root package name */
        private volatile Object f14999c;

        public b(@k.e.a.d h.k2.u.a<T> aVar) {
            if (aVar == null) {
                d(0);
            }
            this.f14999c = null;
            this.b = aVar;
        }

        private static /* synthetic */ void d(int i2) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazyVal", "<init>"));
        }

        @Override // h.p2.b0.g.l.c, h.k2.u.a
        public T invoke() {
            Object obj = this.f14999c;
            if (obj != null) {
                return c(obj);
            }
            T invoke = this.b.invoke();
            this.f14999c = a(invoke);
            return invoke;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class c<T> {
        private static final Object a = new a();

        /* loaded from: classes3.dex */
        public static class a {
        }

        public Object a(T t) {
            return t == null ? a : t;
        }

        public final T b(Object obj, Object obj2) {
            return invoke();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public T c(Object obj) {
            if (obj == a) {
                return null;
            }
            return obj;
        }

        public abstract T invoke();
    }

    private static /* synthetic */ void a(int i2) {
        Object[] objArr = new Object[3];
        objArr[0] = "initializer";
        objArr[1] = "kotlin/reflect/jvm/internal/ReflectProperties";
        if (i2 == 1 || i2 == 2) {
            objArr[2] = "lazySoft";
        } else {
            objArr[2] = "lazy";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @k.e.a.d
    public static <T> b<T> b(@k.e.a.d h.k2.u.a<T> aVar) {
        if (aVar == null) {
            a(0);
        }
        return new b<>(aVar);
    }

    @k.e.a.d
    public static <T> a<T> c(@k.e.a.e T t, @k.e.a.d h.k2.u.a<T> aVar) {
        if (aVar == null) {
            a(1);
        }
        return new a<>(t, aVar);
    }

    @k.e.a.d
    public static <T> a<T> d(@k.e.a.d h.k2.u.a<T> aVar) {
        if (aVar == null) {
            a(2);
        }
        return c(null, aVar);
    }
}
