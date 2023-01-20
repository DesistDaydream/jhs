package e.b.a.p.k;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import e.b.a.p.j.d;
import e.b.a.p.k.e;
import e.b.a.p.l.n;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class w implements e, e.a {

    /* renamed from: h  reason: collision with root package name */
    private static final String f9599h = "SourceGenerator";
    private final f<?> a;
    private final e.a b;

    /* renamed from: c  reason: collision with root package name */
    private int f9600c;

    /* renamed from: d  reason: collision with root package name */
    private b f9601d;

    /* renamed from: e  reason: collision with root package name */
    private Object f9602e;

    /* renamed from: f  reason: collision with root package name */
    private volatile n.a<?> f9603f;

    /* renamed from: g  reason: collision with root package name */
    private c f9604g;

    /* loaded from: classes.dex */
    public class a implements d.a<Object> {
        public final /* synthetic */ n.a a;

        public a(n.a aVar) {
            this.a = aVar;
        }

        @Override // e.b.a.p.j.d.a
        public void b(@NonNull Exception exc) {
            if (w.this.g(this.a)) {
                w.this.i(this.a, exc);
            }
        }

        @Override // e.b.a.p.j.d.a
        public void d(@Nullable Object obj) {
            if (w.this.g(this.a)) {
                w.this.h(this.a, obj);
            }
        }
    }

    public w(f<?> fVar, e.a aVar) {
        this.a = fVar;
        this.b = aVar;
    }

    private void d(Object obj) {
        long b = e.b.a.v.h.b();
        try {
            e.b.a.p.a<X> p = this.a.p(obj);
            d dVar = new d(p, obj, this.a.k());
            this.f9604g = new c(this.f9603f.a, this.a.o());
            this.a.d().a(this.f9604g, dVar);
            if (Log.isLoggable(f9599h, 2)) {
                Log.v(f9599h, "Finished encoding source to cache, key: " + this.f9604g + ", data: " + obj + ", encoder: " + p + ", duration: " + e.b.a.v.h.a(b));
            }
            this.f9603f.f9707c.a();
            this.f9601d = new b(Collections.singletonList(this.f9603f.a), this.a, this);
        } catch (Throwable th) {
            this.f9603f.f9707c.a();
            throw th;
        }
    }

    private boolean f() {
        return this.f9600c < this.a.g().size();
    }

    private void j(n.a<?> aVar) {
        this.f9603f.f9707c.c(this.a.l(), new a(aVar));
    }

    @Override // e.b.a.p.k.e.a
    public void a(e.b.a.p.c cVar, Exception exc, e.b.a.p.j.d<?> dVar, DataSource dataSource) {
        this.b.a(cVar, exc, dVar, this.f9603f.f9707c.getDataSource());
    }

    @Override // e.b.a.p.k.e.a
    public void b() {
        throw new UnsupportedOperationException();
    }

    @Override // e.b.a.p.k.e
    public boolean c() {
        Object obj = this.f9602e;
        if (obj != null) {
            this.f9602e = null;
            d(obj);
        }
        b bVar = this.f9601d;
        if (bVar == null || !bVar.c()) {
            this.f9601d = null;
            this.f9603f = null;
            boolean z = false;
            while (!z && f()) {
                List<n.a<?>> g2 = this.a.g();
                int i2 = this.f9600c;
                this.f9600c = i2 + 1;
                this.f9603f = g2.get(i2);
                if (this.f9603f != null && (this.a.e().c(this.f9603f.f9707c.getDataSource()) || this.a.t(this.f9603f.f9707c.getDataClass()))) {
                    j(this.f9603f);
                    z = true;
                }
            }
            return z;
        }
        return true;
    }

    @Override // e.b.a.p.k.e
    public void cancel() {
        n.a<?> aVar = this.f9603f;
        if (aVar != null) {
            aVar.f9707c.cancel();
        }
    }

    @Override // e.b.a.p.k.e.a
    public void e(e.b.a.p.c cVar, Object obj, e.b.a.p.j.d<?> dVar, DataSource dataSource, e.b.a.p.c cVar2) {
        this.b.e(cVar, obj, dVar, this.f9603f.f9707c.getDataSource(), cVar);
    }

    public boolean g(n.a<?> aVar) {
        n.a<?> aVar2 = this.f9603f;
        return aVar2 != null && aVar2 == aVar;
    }

    public void h(n.a<?> aVar, Object obj) {
        h e2 = this.a.e();
        if (obj != null && e2.c(aVar.f9707c.getDataSource())) {
            this.f9602e = obj;
            this.b.b();
            return;
        }
        e.a aVar2 = this.b;
        e.b.a.p.c cVar = aVar.a;
        e.b.a.p.j.d<?> dVar = aVar.f9707c;
        aVar2.e(cVar, obj, dVar, dVar.getDataSource(), this.f9604g);
    }

    public void i(n.a<?> aVar, @NonNull Exception exc) {
        e.a aVar2 = this.b;
        c cVar = this.f9604g;
        e.b.a.p.j.d<?> dVar = aVar.f9707c;
        aVar2.a(cVar, exc, dVar, dVar.getDataSource());
    }
}
