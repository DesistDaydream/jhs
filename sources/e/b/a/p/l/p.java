package e.b.a.p.l;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class p {
    private final r a;
    private final a b;

    /* loaded from: classes.dex */
    public static class a {
        private final Map<Class<?>, C0318a<?>> a = new HashMap();

        /* renamed from: e.b.a.p.l.p$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0318a<Model> {
            public final List<n<Model, ?>> a;

            public C0318a(List<n<Model, ?>> list) {
                this.a = list;
            }
        }

        public void a() {
            this.a.clear();
        }

        @Nullable
        public <Model> List<n<Model, ?>> b(Class<Model> cls) {
            C0318a<?> c0318a = this.a.get(cls);
            if (c0318a == null) {
                return null;
            }
            return (List<n<Model, ?>>) c0318a.a;
        }

        public <Model> void c(Class<Model> cls, List<n<Model, ?>> list) {
            if (this.a.put(cls, new C0318a<>(list)) == null) {
                return;
            }
            throw new IllegalStateException("Already cached loaders for model: " + cls);
        }
    }

    public p(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(new r(pool));
    }

    @NonNull
    private static <A> Class<A> c(@NonNull A a2) {
        return (Class<A>) a2.getClass();
    }

    @NonNull
    private synchronized <A> List<n<A, ?>> f(@NonNull Class<A> cls) {
        List<n<A, ?>> b;
        b = this.b.b(cls);
        if (b == null) {
            b = Collections.unmodifiableList(this.a.e(cls));
            this.b.c(cls, b);
        }
        return b;
    }

    private <Model, Data> void j(@NonNull List<o<? extends Model, ? extends Data>> list) {
        for (o<? extends Model, ? extends Data> oVar : list) {
            oVar.a();
        }
    }

    public synchronized <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        this.a.b(cls, cls2, oVar);
        this.b.a();
    }

    public synchronized <Model, Data> n<Model, Data> b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        return this.a.d(cls, cls2);
    }

    @NonNull
    public synchronized List<Class<?>> d(@NonNull Class<?> cls) {
        return this.a.g(cls);
    }

    @NonNull
    public <A> List<n<A, ?>> e(@NonNull A a2) {
        List<n<A, ?>> f2 = f(c(a2));
        if (!f2.isEmpty()) {
            int size = f2.size();
            List<n<A, ?>> emptyList = Collections.emptyList();
            boolean z = true;
            for (int i2 = 0; i2 < size; i2++) {
                n<A, ?> nVar = f2.get(i2);
                if (nVar.a(a2)) {
                    if (z) {
                        emptyList = new ArrayList<>(size - i2);
                        z = false;
                    }
                    emptyList.add(nVar);
                }
            }
            if (emptyList.isEmpty()) {
                throw new Registry.NoModelLoaderAvailableException(a2, f2);
            }
            return emptyList;
        }
        throw new Registry.NoModelLoaderAvailableException(a2);
    }

    public synchronized <Model, Data> void g(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        this.a.i(cls, cls2, oVar);
        this.b.a();
    }

    public synchronized <Model, Data> void h(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        j(this.a.j(cls, cls2));
        this.b.a();
    }

    public synchronized <Model, Data> void i(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        j(this.a.k(cls, cls2, oVar));
        this.b.a();
    }

    private p(@NonNull r rVar) {
        this.b = new a();
        this.a = rVar;
    }
}
