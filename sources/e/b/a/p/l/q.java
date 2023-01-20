package e.b.a.p.l;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import e.b.a.p.j.d;
import e.b.a.p.l.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class q<Model, Data> implements n<Model, Data> {
    private final List<n<Model, Data>> a;
    private final Pools.Pool<List<Throwable>> b;

    /* loaded from: classes.dex */
    public static class a<Data> implements e.b.a.p.j.d<Data>, d.a<Data> {
        private final List<e.b.a.p.j.d<Data>> a;
        private final Pools.Pool<List<Throwable>> b;

        /* renamed from: c  reason: collision with root package name */
        private int f9708c;

        /* renamed from: d  reason: collision with root package name */
        private Priority f9709d;

        /* renamed from: e  reason: collision with root package name */
        private d.a<? super Data> f9710e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        private List<Throwable> f9711f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f9712g;

        public a(@NonNull List<e.b.a.p.j.d<Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            this.b = pool;
            e.b.a.v.l.c(list);
            this.a = list;
            this.f9708c = 0;
        }

        private void e() {
            if (this.f9712g) {
                return;
            }
            if (this.f9708c < this.a.size() - 1) {
                this.f9708c++;
                c(this.f9709d, this.f9710e);
                return;
            }
            e.b.a.v.l.d(this.f9711f);
            this.f9710e.b(new GlideException("Fetch failed", new ArrayList(this.f9711f)));
        }

        @Override // e.b.a.p.j.d
        public void a() {
            List<Throwable> list = this.f9711f;
            if (list != null) {
                this.b.release(list);
            }
            this.f9711f = null;
            for (e.b.a.p.j.d<Data> dVar : this.a) {
                dVar.a();
            }
        }

        @Override // e.b.a.p.j.d.a
        public void b(@NonNull Exception exc) {
            ((List) e.b.a.v.l.d(this.f9711f)).add(exc);
            e();
        }

        @Override // e.b.a.p.j.d
        public void c(@NonNull Priority priority, @NonNull d.a<? super Data> aVar) {
            this.f9709d = priority;
            this.f9710e = aVar;
            this.f9711f = this.b.acquire();
            this.a.get(this.f9708c).c(priority, this);
            if (this.f9712g) {
                cancel();
            }
        }

        @Override // e.b.a.p.j.d
        public void cancel() {
            this.f9712g = true;
            for (e.b.a.p.j.d<Data> dVar : this.a) {
                dVar.cancel();
            }
        }

        @Override // e.b.a.p.j.d.a
        public void d(@Nullable Data data) {
            if (data != null) {
                this.f9710e.d(data);
            } else {
                e();
            }
        }

        @Override // e.b.a.p.j.d
        @NonNull
        public Class<Data> getDataClass() {
            return this.a.get(0).getDataClass();
        }

        @Override // e.b.a.p.j.d
        @NonNull
        public DataSource getDataSource() {
            return this.a.get(0).getDataSource();
        }
    }

    public q(@NonNull List<n<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
        this.a = list;
        this.b = pool;
    }

    @Override // e.b.a.p.l.n
    public boolean a(@NonNull Model model) {
        for (n<Model, Data> nVar : this.a) {
            if (nVar.a(model)) {
                return true;
            }
        }
        return false;
    }

    @Override // e.b.a.p.l.n
    public n.a<Data> b(@NonNull Model model, int i2, int i3, @NonNull e.b.a.p.f fVar) {
        n.a<Data> b;
        int size = this.a.size();
        ArrayList arrayList = new ArrayList(size);
        e.b.a.p.c cVar = null;
        for (int i4 = 0; i4 < size; i4++) {
            n<Model, Data> nVar = this.a.get(i4);
            if (nVar.a(model) && (b = nVar.b(model, i2, i3, fVar)) != null) {
                cVar = b.a;
                arrayList.add(b.f9707c);
            }
        }
        if (arrayList.isEmpty() || cVar == null) {
            return null;
        }
        return new n.a<>(cVar, new a(arrayList, this.b));
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.a.toArray()) + '}';
    }
}
