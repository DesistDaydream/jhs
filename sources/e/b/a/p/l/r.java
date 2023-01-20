package e.b.a.p.l;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import e.b.a.p.l.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class r {

    /* renamed from: e  reason: collision with root package name */
    private static final c f9713e = new c();

    /* renamed from: f  reason: collision with root package name */
    private static final n<Object, Object> f9714f = new a();
    private final List<b<?, ?>> a;
    private final c b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<b<?, ?>> f9715c;

    /* renamed from: d  reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f9716d;

    /* loaded from: classes.dex */
    public static class a implements n<Object, Object> {
        @Override // e.b.a.p.l.n
        public boolean a(@NonNull Object obj) {
            return false;
        }

        @Override // e.b.a.p.l.n
        @Nullable
        public n.a<Object> b(@NonNull Object obj, int i2, int i3, @NonNull e.b.a.p.f fVar) {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static class b<Model, Data> {
        private final Class<Model> a;
        public final Class<Data> b;

        /* renamed from: c  reason: collision with root package name */
        public final o<? extends Model, ? extends Data> f9717c;

        public b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
            this.a = cls;
            this.b = cls2;
            this.f9717c = oVar;
        }

        public boolean a(@NonNull Class<?> cls) {
            return this.a.isAssignableFrom(cls);
        }

        public boolean b(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return a(cls) && this.b.isAssignableFrom(cls2);
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        @NonNull
        public <Model, Data> q<Model, Data> a(@NonNull List<n<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            return new q<>(list, pool);
        }
    }

    public r(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(pool, f9713e);
    }

    private <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar, boolean z) {
        b<?, ?> bVar = new b<>(cls, cls2, oVar);
        List<b<?, ?>> list = this.a;
        list.add(z ? list.size() : 0, bVar);
    }

    @NonNull
    private <Model, Data> n<Model, Data> c(@NonNull b<?, ?> bVar) {
        return (n) e.b.a.v.l.d(bVar.f9717c.c(this));
    }

    @NonNull
    private static <Model, Data> n<Model, Data> f() {
        return (n<Model, Data>) f9714f;
    }

    @NonNull
    private <Model, Data> o<Model, Data> h(@NonNull b<?, ?> bVar) {
        return (o<Model, Data>) bVar.f9717c;
    }

    public synchronized <Model, Data> void b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        a(cls, cls2, oVar, true);
    }

    @NonNull
    public synchronized <Model, Data> n<Model, Data> d(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (b<?, ?> bVar : this.a) {
                if (this.f9715c.contains(bVar)) {
                    z = true;
                } else if (bVar.b(cls, cls2)) {
                    this.f9715c.add(bVar);
                    arrayList.add(c(bVar));
                    this.f9715c.remove(bVar);
                }
            }
            if (arrayList.size() > 1) {
                return this.b.a(arrayList, this.f9716d);
            } else if (arrayList.size() == 1) {
                return (n) arrayList.get(0);
            } else if (z) {
                return f();
            } else {
                throw new Registry.NoModelLoaderAvailableException((Class<?>) cls, (Class<?>) cls2);
            }
        } catch (Throwable th) {
            this.f9715c.clear();
            throw th;
        }
    }

    @NonNull
    public synchronized <Model> List<n<Model, ?>> e(@NonNull Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b<?, ?> bVar : this.a) {
                if (!this.f9715c.contains(bVar) && bVar.a(cls)) {
                    this.f9715c.add(bVar);
                    arrayList.add(c(bVar));
                    this.f9715c.remove(bVar);
                }
            }
        } catch (Throwable th) {
            this.f9715c.clear();
            throw th;
        }
        return arrayList;
    }

    @NonNull
    public synchronized List<Class<?>> g(@NonNull Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b<?, ?> bVar : this.a) {
            if (!arrayList.contains(bVar.b) && bVar.a(cls)) {
                arrayList.add(bVar.b);
            }
        }
        return arrayList;
    }

    public synchronized <Model, Data> void i(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        a(cls, cls2, oVar, false);
    }

    @NonNull
    public synchronized <Model, Data> List<o<? extends Model, ? extends Data>> j(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<b<?, ?>> it = this.a.iterator();
        while (it.hasNext()) {
            b<?, ?> next = it.next();
            if (next.b(cls, cls2)) {
                it.remove();
                arrayList.add(h(next));
            }
        }
        return arrayList;
    }

    @NonNull
    public synchronized <Model, Data> List<o<? extends Model, ? extends Data>> k(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        List<o<? extends Model, ? extends Data>> j2;
        j2 = j(cls, cls2);
        b(cls, cls2, oVar);
        return j2;
    }

    @VisibleForTesting
    public r(@NonNull Pools.Pool<List<Throwable>> pool, @NonNull c cVar) {
        this.a = new ArrayList();
        this.f9715c = new HashSet();
        this.f9716d = pool;
        this.b = cVar;
    }
}
