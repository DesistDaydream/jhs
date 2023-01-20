package e.b.a.p.k;

import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.engine.DecodeJob;
import e.b.a.p.l.n;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class f<Transcode> {
    private final List<n.a<?>> a = new ArrayList();
    private final List<e.b.a.p.c> b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private e.b.a.e f9518c;

    /* renamed from: d  reason: collision with root package name */
    private Object f9519d;

    /* renamed from: e  reason: collision with root package name */
    private int f9520e;

    /* renamed from: f  reason: collision with root package name */
    private int f9521f;

    /* renamed from: g  reason: collision with root package name */
    private Class<?> f9522g;

    /* renamed from: h  reason: collision with root package name */
    private DecodeJob.e f9523h;

    /* renamed from: i  reason: collision with root package name */
    private e.b.a.p.f f9524i;

    /* renamed from: j  reason: collision with root package name */
    private Map<Class<?>, e.b.a.p.i<?>> f9525j;

    /* renamed from: k  reason: collision with root package name */
    private Class<Transcode> f9526k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f9527l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f9528m;
    private e.b.a.p.c n;
    private Priority o;
    private h p;
    private boolean q;
    private boolean r;

    public void a() {
        this.f9518c = null;
        this.f9519d = null;
        this.n = null;
        this.f9522g = null;
        this.f9526k = null;
        this.f9524i = null;
        this.o = null;
        this.f9525j = null;
        this.p = null;
        this.a.clear();
        this.f9527l = false;
        this.b.clear();
        this.f9528m = false;
    }

    public e.b.a.p.k.x.b b() {
        return this.f9518c.b();
    }

    public List<e.b.a.p.c> c() {
        if (!this.f9528m) {
            this.f9528m = true;
            this.b.clear();
            List<n.a<?>> g2 = g();
            int size = g2.size();
            for (int i2 = 0; i2 < size; i2++) {
                n.a<?> aVar = g2.get(i2);
                if (!this.b.contains(aVar.a)) {
                    this.b.add(aVar.a);
                }
                for (int i3 = 0; i3 < aVar.b.size(); i3++) {
                    if (!this.b.contains(aVar.b.get(i3))) {
                        this.b.add(aVar.b.get(i3));
                    }
                }
            }
        }
        return this.b;
    }

    public e.b.a.p.k.y.a d() {
        return this.f9523h.a();
    }

    public h e() {
        return this.p;
    }

    public int f() {
        return this.f9521f;
    }

    public List<n.a<?>> g() {
        if (!this.f9527l) {
            this.f9527l = true;
            this.a.clear();
            List i2 = this.f9518c.i().i(this.f9519d);
            int size = i2.size();
            for (int i3 = 0; i3 < size; i3++) {
                n.a<?> b = ((e.b.a.p.l.n) i2.get(i3)).b(this.f9519d, this.f9520e, this.f9521f, this.f9524i);
                if (b != null) {
                    this.a.add(b);
                }
            }
        }
        return this.a;
    }

    public <Data> q<Data, ?, Transcode> h(Class<Data> cls) {
        return this.f9518c.i().h(cls, this.f9522g, this.f9526k);
    }

    public Class<?> i() {
        return this.f9519d.getClass();
    }

    public List<e.b.a.p.l.n<File, ?>> j(File file) throws Registry.NoModelLoaderAvailableException {
        return this.f9518c.i().i(file);
    }

    public e.b.a.p.f k() {
        return this.f9524i;
    }

    public Priority l() {
        return this.o;
    }

    public List<Class<?>> m() {
        return this.f9518c.i().j(this.f9519d.getClass(), this.f9522g, this.f9526k);
    }

    public <Z> e.b.a.p.h<Z> n(s<Z> sVar) {
        return this.f9518c.i().k(sVar);
    }

    public e.b.a.p.c o() {
        return this.n;
    }

    public <X> e.b.a.p.a<X> p(X x) throws Registry.NoSourceEncoderAvailableException {
        return this.f9518c.i().m(x);
    }

    public Class<?> q() {
        return (Class<Transcode>) this.f9526k;
    }

    public <Z> e.b.a.p.i<Z> r(Class<Z> cls) {
        e.b.a.p.i<Z> iVar = (e.b.a.p.i<Z>) this.f9525j.get(cls);
        if (iVar == null) {
            Iterator<Map.Entry<Class<?>, e.b.a.p.i<?>>> it = this.f9525j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, e.b.a.p.i<?>> next = it.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    iVar = (e.b.a.p.i<Z>) next.getValue();
                    break;
                }
            }
        }
        if (iVar == null) {
            if (this.f9525j.isEmpty() && this.q) {
                throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
            }
            return e.b.a.p.m.c.a();
        }
        return iVar;
    }

    public int s() {
        return this.f9520e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean t(Class<?> cls) {
        return h(cls) != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <R> void u(e.b.a.e eVar, Object obj, e.b.a.p.c cVar, int i2, int i3, h hVar, Class<?> cls, Class<R> cls2, Priority priority, e.b.a.p.f fVar, Map<Class<?>, e.b.a.p.i<?>> map, boolean z, boolean z2, DecodeJob.e eVar2) {
        this.f9518c = eVar;
        this.f9519d = obj;
        this.n = cVar;
        this.f9520e = i2;
        this.f9521f = i3;
        this.p = hVar;
        this.f9522g = cls;
        this.f9523h = eVar2;
        this.f9526k = cls2;
        this.o = priority;
        this.f9524i = fVar;
        this.f9525j = map;
        this.q = z;
        this.r = z2;
    }

    public boolean v(s<?> sVar) {
        return this.f9518c.i().n(sVar);
    }

    public boolean w() {
        return this.r;
    }

    public boolean x(e.b.a.p.c cVar) {
        List<n.a<?>> g2 = g();
        int size = g2.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (g2.get(i2).a.equals(cVar)) {
                return true;
            }
        }
        return false;
    }
}
