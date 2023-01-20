package e.b.a.v.p;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class a {
    private static final String a = "FactoryPools";
    private static final int b = 20;

    /* renamed from: c  reason: collision with root package name */
    private static final g<Object> f9955c = new C0326a();

    /* renamed from: e.b.a.v.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0326a implements g<Object> {
        @Override // e.b.a.v.p.a.g
        public void a(@NonNull Object obj) {
        }
    }

    /* loaded from: classes.dex */
    public class b implements d<List<T>> {
        @Override // e.b.a.v.p.a.d
        @NonNull
        /* renamed from: b */
        public List<T> a() {
            return new ArrayList();
        }
    }

    /* loaded from: classes.dex */
    public class c implements g<List<T>> {
        @Override // e.b.a.v.p.a.g
        /* renamed from: b */
        public void a(@NonNull List<T> list) {
            list.clear();
        }
    }

    /* loaded from: classes.dex */
    public interface d<T> {
        T a();
    }

    /* loaded from: classes.dex */
    public static final class e<T> implements Pools.Pool<T> {
        private final d<T> a;
        private final g<T> b;

        /* renamed from: c  reason: collision with root package name */
        private final Pools.Pool<T> f9956c;

        public e(@NonNull Pools.Pool<T> pool, @NonNull d<T> dVar, @NonNull g<T> gVar) {
            this.f9956c = pool;
            this.a = dVar;
            this.b = gVar;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            T acquire = this.f9956c.acquire();
            if (acquire == null) {
                acquire = this.a.a();
                if (Log.isLoggable(a.a, 2)) {
                    Log.v(a.a, "Created new " + acquire.getClass());
                }
            }
            if (acquire instanceof f) {
                ((f) acquire).d().b(false);
            }
            return acquire;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(@NonNull T t) {
            if (t instanceof f) {
                ((f) t).d().b(true);
            }
            this.b.a(t);
            return this.f9956c.release(t);
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        @NonNull
        e.b.a.v.p.c d();
    }

    /* loaded from: classes.dex */
    public interface g<T> {
        void a(@NonNull T t);
    }

    private a() {
    }

    @NonNull
    private static <T extends f> Pools.Pool<T> a(@NonNull Pools.Pool<T> pool, @NonNull d<T> dVar) {
        return b(pool, dVar, c());
    }

    @NonNull
    private static <T> Pools.Pool<T> b(@NonNull Pools.Pool<T> pool, @NonNull d<T> dVar, @NonNull g<T> gVar) {
        return new e(pool, dVar, gVar);
    }

    @NonNull
    private static <T> g<T> c() {
        return (g<T>) f9955c;
    }

    @NonNull
    public static <T extends f> Pools.Pool<T> d(int i2, @NonNull d<T> dVar) {
        return a(new Pools.SimplePool(i2), dVar);
    }

    @NonNull
    public static <T extends f> Pools.Pool<T> e(int i2, @NonNull d<T> dVar) {
        return a(new Pools.SynchronizedPool(i2), dVar);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> f() {
        return g(20);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> g(int i2) {
        return b(new Pools.SynchronizedPool(i2), new b(), new c());
    }
}
