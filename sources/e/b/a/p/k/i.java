package e.b.a.p.k;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DecodeJob;
import e.b.a.p.k.n;
import e.b.a.p.k.y.a;
import e.b.a.p.k.y.j;
import e.b.a.v.p.a;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class i implements k, j.a, n.a {

    /* renamed from: j */
    private static final int f9537j = 150;
    private final p a;
    private final m b;

    /* renamed from: c */
    private final e.b.a.p.k.y.j f9539c;

    /* renamed from: d */
    private final b f9540d;

    /* renamed from: e */
    private final v f9541e;

    /* renamed from: f */
    private final c f9542f;

    /* renamed from: g */
    private final a f9543g;

    /* renamed from: h */
    private final e.b.a.p.k.a f9544h;

    /* renamed from: i */
    private static final String f9536i = "Engine";

    /* renamed from: k */
    private static final boolean f9538k = Log.isLoggable(f9536i, 2);

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class a {
        public final DecodeJob.e a;
        public final Pools.Pool<DecodeJob<?>> b = e.b.a.v.p.a.e(i.f9537j, new C0309a());

        /* renamed from: c */
        private int f9545c;

        /* renamed from: e.b.a.p.k.i$a$a */
        /* loaded from: classes.dex */
        public class C0309a implements a.d<DecodeJob<?>> {
            public C0309a() {
                a.this = r1;
            }

            @Override // e.b.a.v.p.a.d
            /* renamed from: b */
            public DecodeJob<?> a() {
                a aVar = a.this;
                return new DecodeJob<>(aVar.a, aVar.b);
            }
        }

        public a(DecodeJob.e eVar) {
            this.a = eVar;
        }

        public <R> DecodeJob<R> a(e.b.a.e eVar, Object obj, l lVar, e.b.a.p.c cVar, int i2, int i3, Class<?> cls, Class<R> cls2, Priority priority, h hVar, Map<Class<?>, e.b.a.p.i<?>> map, boolean z, boolean z2, boolean z3, e.b.a.p.f fVar, DecodeJob.b<R> bVar) {
            DecodeJob decodeJob = (DecodeJob) e.b.a.v.l.d(this.b.acquire());
            int i4 = this.f9545c;
            this.f9545c = i4 + 1;
            return decodeJob.o(eVar, obj, lVar, cVar, i2, i3, cls, cls2, priority, hVar, map, z, z2, z3, fVar, bVar, i4);
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class b {
        public final e.b.a.p.k.z.a a;
        public final e.b.a.p.k.z.a b;

        /* renamed from: c */
        public final e.b.a.p.k.z.a f9546c;

        /* renamed from: d */
        public final e.b.a.p.k.z.a f9547d;

        /* renamed from: e */
        public final k f9548e;

        /* renamed from: f */
        public final n.a f9549f;

        /* renamed from: g */
        public final Pools.Pool<j<?>> f9550g = e.b.a.v.p.a.e(i.f9537j, new a());

        /* loaded from: classes.dex */
        public class a implements a.d<j<?>> {
            public a() {
                b.this = r1;
            }

            @Override // e.b.a.v.p.a.d
            /* renamed from: b */
            public j<?> a() {
                b bVar = b.this;
                return new j<>(bVar.a, bVar.b, bVar.f9546c, bVar.f9547d, bVar.f9548e, bVar.f9549f, bVar.f9550g);
            }
        }

        public b(e.b.a.p.k.z.a aVar, e.b.a.p.k.z.a aVar2, e.b.a.p.k.z.a aVar3, e.b.a.p.k.z.a aVar4, k kVar, n.a aVar5) {
            this.a = aVar;
            this.b = aVar2;
            this.f9546c = aVar3;
            this.f9547d = aVar4;
            this.f9548e = kVar;
            this.f9549f = aVar5;
        }

        public <R> j<R> a(e.b.a.p.c cVar, boolean z, boolean z2, boolean z3, boolean z4) {
            return ((j) e.b.a.v.l.d(this.f9550g.acquire())).l(cVar, z, z2, z3, z4);
        }

        @VisibleForTesting
        public void b() {
            e.b.a.v.f.c(this.a);
            e.b.a.v.f.c(this.b);
            e.b.a.v.f.c(this.f9546c);
            e.b.a.v.f.c(this.f9547d);
        }
    }

    /* loaded from: classes.dex */
    public static class c implements DecodeJob.e {
        private final a.InterfaceC0310a a;
        private volatile e.b.a.p.k.y.a b;

        public c(a.InterfaceC0310a interfaceC0310a) {
            this.a = interfaceC0310a;
        }

        @Override // com.bumptech.glide.load.engine.DecodeJob.e
        public e.b.a.p.k.y.a a() {
            if (this.b == null) {
                synchronized (this) {
                    if (this.b == null) {
                        this.b = this.a.build();
                    }
                    if (this.b == null) {
                        this.b = new e.b.a.p.k.y.b();
                    }
                }
            }
            return this.b;
        }

        @VisibleForTesting
        public synchronized void b() {
            if (this.b == null) {
                return;
            }
            this.b.clear();
        }
    }

    /* loaded from: classes.dex */
    public class d {
        private final j<?> a;
        private final e.b.a.t.i b;

        public d(e.b.a.t.i iVar, j<?> jVar) {
            i.this = r1;
            this.b = iVar;
            this.a = jVar;
        }

        public void a() {
            synchronized (i.this) {
                this.a.s(this.b);
            }
        }
    }

    public i(e.b.a.p.k.y.j jVar, a.InterfaceC0310a interfaceC0310a, e.b.a.p.k.z.a aVar, e.b.a.p.k.z.a aVar2, e.b.a.p.k.z.a aVar3, e.b.a.p.k.z.a aVar4, boolean z) {
        this(jVar, interfaceC0310a, aVar, aVar2, aVar3, aVar4, null, null, null, null, null, null, z);
    }

    private n<?> f(e.b.a.p.c cVar) {
        s<?> f2 = this.f9539c.f(cVar);
        if (f2 == null) {
            return null;
        }
        if (f2 instanceof n) {
            return (n) f2;
        }
        return new n<>(f2, true, true, cVar, this);
    }

    @Nullable
    private n<?> h(e.b.a.p.c cVar) {
        n<?> e2 = this.f9544h.e(cVar);
        if (e2 != null) {
            e2.a();
        }
        return e2;
    }

    private n<?> i(e.b.a.p.c cVar) {
        n<?> f2 = f(cVar);
        if (f2 != null) {
            f2.a();
            this.f9544h.a(cVar, f2);
        }
        return f2;
    }

    @Nullable
    private n<?> j(l lVar, boolean z, long j2) {
        if (z) {
            n<?> h2 = h(lVar);
            if (h2 != null) {
                if (f9538k) {
                    k("Loaded resource from active resources", j2, lVar);
                }
                return h2;
            }
            n<?> i2 = i(lVar);
            if (i2 != null) {
                if (f9538k) {
                    k("Loaded resource from cache", j2, lVar);
                }
                return i2;
            }
            return null;
        }
        return null;
    }

    private static void k(String str, long j2, e.b.a.p.c cVar) {
        Log.v(f9536i, str + " in " + e.b.a.v.h.a(j2) + "ms, key: " + cVar);
    }

    private <R> d n(e.b.a.e eVar, Object obj, e.b.a.p.c cVar, int i2, int i3, Class<?> cls, Class<R> cls2, Priority priority, h hVar, Map<Class<?>, e.b.a.p.i<?>> map, boolean z, boolean z2, e.b.a.p.f fVar, boolean z3, boolean z4, boolean z5, boolean z6, e.b.a.t.i iVar, Executor executor, l lVar, long j2) {
        j<?> a2 = this.a.a(lVar, z6);
        if (a2 != null) {
            a2.a(iVar, executor);
            if (f9538k) {
                k("Added to existing load", j2, lVar);
            }
            return new d(iVar, a2);
        }
        j<R> a3 = this.f9540d.a(lVar, z3, z4, z5, z6);
        DecodeJob<R> a4 = this.f9543g.a(eVar, obj, lVar, cVar, i2, i3, cls, cls2, priority, hVar, map, z, z2, z6, fVar, a3);
        this.a.d(lVar, a3);
        a3.a(iVar, executor);
        a3.t(a4);
        if (f9538k) {
            k("Started new load", j2, lVar);
        }
        return new d(iVar, a3);
    }

    @Override // e.b.a.p.k.y.j.a
    public void a(@NonNull s<?> sVar) {
        this.f9541e.a(sVar, true);
    }

    @Override // e.b.a.p.k.k
    public synchronized void b(j<?> jVar, e.b.a.p.c cVar, n<?> nVar) {
        if (nVar != null) {
            if (nVar.d()) {
                this.f9544h.a(cVar, nVar);
            }
        }
        this.a.e(cVar, jVar);
    }

    @Override // e.b.a.p.k.k
    public synchronized void c(j<?> jVar, e.b.a.p.c cVar) {
        this.a.e(cVar, jVar);
    }

    @Override // e.b.a.p.k.n.a
    public void d(e.b.a.p.c cVar, n<?> nVar) {
        this.f9544h.d(cVar);
        if (nVar.d()) {
            this.f9539c.d(cVar, nVar);
        } else {
            this.f9541e.a(nVar, false);
        }
    }

    public void e() {
        this.f9542f.a().clear();
    }

    public <R> d g(e.b.a.e eVar, Object obj, e.b.a.p.c cVar, int i2, int i3, Class<?> cls, Class<R> cls2, Priority priority, h hVar, Map<Class<?>, e.b.a.p.i<?>> map, boolean z, boolean z2, e.b.a.p.f fVar, boolean z3, boolean z4, boolean z5, boolean z6, e.b.a.t.i iVar, Executor executor) {
        long b2 = f9538k ? e.b.a.v.h.b() : 0L;
        l a2 = this.b.a(obj, cVar, i2, i3, map, cls, cls2, fVar);
        synchronized (this) {
            n<?> j2 = j(a2, z3, b2);
            if (j2 == null) {
                return n(eVar, obj, cVar, i2, i3, cls, cls2, priority, hVar, map, z, z2, fVar, z3, z4, z5, z6, iVar, executor, a2, b2);
            }
            iVar.b(j2, DataSource.MEMORY_CACHE, false);
            return null;
        }
    }

    public void l(s<?> sVar) {
        if (sVar instanceof n) {
            ((n) sVar).e();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    @VisibleForTesting
    public void m() {
        this.f9540d.b();
        this.f9542f.b();
        this.f9544h.h();
    }

    @VisibleForTesting
    public i(e.b.a.p.k.y.j jVar, a.InterfaceC0310a interfaceC0310a, e.b.a.p.k.z.a aVar, e.b.a.p.k.z.a aVar2, e.b.a.p.k.z.a aVar3, e.b.a.p.k.z.a aVar4, p pVar, m mVar, e.b.a.p.k.a aVar5, b bVar, a aVar6, v vVar, boolean z) {
        this.f9539c = jVar;
        c cVar = new c(interfaceC0310a);
        this.f9542f = cVar;
        e.b.a.p.k.a aVar7 = aVar5 == null ? new e.b.a.p.k.a(z) : aVar5;
        this.f9544h = aVar7;
        aVar7.g(this);
        this.b = mVar == null ? new m() : mVar;
        this.a = pVar == null ? new p() : pVar;
        this.f9540d = bVar == null ? new b(aVar, aVar2, aVar3, aVar4, this, this) : bVar;
        this.f9543g = aVar6 == null ? new a(cVar) : aVar6;
        this.f9541e = vVar == null ? new v() : vVar;
        jVar.g(this);
    }
}
