package kotlin.reflect.jvm.internal.impl.types;

import h.a2.t;
import h.k2.v.f0;
import h.p2.b0.g.t.c.b0;
import h.p2.b0.g.t.c.f;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.r0;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.k.c;
import h.p2.b0.g.t.m.h;
import h.p2.b0.g.t.m.m;
import h.p2.b0.g.t.n.q0;
import h.p2.b0.g.t.n.s;
import h.w;
import h.z;
import java.util.Collection;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* loaded from: classes3.dex */
public abstract class AbstractTypeConstructor implements q0 {
    private int a;
    @d
    private final h<a> b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f16868c;

    /* loaded from: classes3.dex */
    public final class ModuleViewTypeConstructor implements q0 {
        @d
        private final h.p2.b0.g.t.n.e1.h a;
        @d
        private final w b;

        public ModuleViewTypeConstructor(@d h.p2.b0.g.t.n.e1.h hVar) {
            this.a = hVar;
            this.b = z.b(LazyThreadSafetyMode.PUBLICATION, new AbstractTypeConstructor$ModuleViewTypeConstructor$refinedSupertypes$2(this, AbstractTypeConstructor.this));
        }

        private final List<h.p2.b0.g.t.n.z> f() {
            return (List) this.b.getValue();
        }

        @Override // h.p2.b0.g.t.n.q0
        @d
        public q0 a(@d h.p2.b0.g.t.n.e1.h hVar) {
            return AbstractTypeConstructor.this.a(hVar);
        }

        @Override // h.p2.b0.g.t.n.q0
        @d
        public f c() {
            return AbstractTypeConstructor.this.c();
        }

        @Override // h.p2.b0.g.t.n.q0
        public boolean d() {
            return AbstractTypeConstructor.this.d();
        }

        public boolean equals(@e Object obj) {
            return AbstractTypeConstructor.this.equals(obj);
        }

        @Override // h.p2.b0.g.t.n.q0
        @d
        /* renamed from: g */
        public List<h.p2.b0.g.t.n.z> j() {
            return f();
        }

        @Override // h.p2.b0.g.t.n.q0
        @d
        public List<t0> getParameters() {
            return AbstractTypeConstructor.this.getParameters();
        }

        public int hashCode() {
            return AbstractTypeConstructor.this.hashCode();
        }

        @Override // h.p2.b0.g.t.n.q0
        @d
        public h.p2.b0.g.t.b.f k() {
            return AbstractTypeConstructor.this.k();
        }

        @d
        public String toString() {
            return AbstractTypeConstructor.this.toString();
        }
    }

    /* loaded from: classes3.dex */
    public static final class a {
        @d
        private final Collection<h.p2.b0.g.t.n.z> a;
        @d
        private List<? extends h.p2.b0.g.t.n.z> b = t.k(s.f15604c);

        /* JADX WARN: Multi-variable type inference failed */
        public a(@d Collection<? extends h.p2.b0.g.t.n.z> collection) {
            this.a = collection;
        }

        @d
        public final Collection<h.p2.b0.g.t.n.z> a() {
            return this.a;
        }

        @d
        public final List<h.p2.b0.g.t.n.z> b() {
            return this.b;
        }

        public final void c(@d List<? extends h.p2.b0.g.t.n.z> list) {
            this.b = list;
        }
    }

    public AbstractTypeConstructor(@d m mVar) {
        this.b = mVar.f(new AbstractTypeConstructor$supertypes$1(this), AbstractTypeConstructor$supertypes$2.INSTANCE, new AbstractTypeConstructor$supertypes$3(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection<h.p2.b0.g.t.n.z> g(q0 q0Var, boolean z) {
        AbstractTypeConstructor abstractTypeConstructor = q0Var instanceof AbstractTypeConstructor ? (AbstractTypeConstructor) q0Var : null;
        List q4 = abstractTypeConstructor != null ? CollectionsKt___CollectionsKt.q4(abstractTypeConstructor.b.invoke().a(), abstractTypeConstructor.l(z)) : null;
        return q4 == null ? q0Var.j() : q4;
    }

    private final boolean p(f fVar) {
        return (s.r(fVar) || c.E(fVar)) ? false : true;
    }

    @Override // h.p2.b0.g.t.n.q0
    @d
    public q0 a(@d h.p2.b0.g.t.n.e1.h hVar) {
        return new ModuleViewTypeConstructor(hVar);
    }

    @Override // h.p2.b0.g.t.n.q0
    @d
    public abstract f c();

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof q0) && obj.hashCode() == hashCode()) {
            q0 q0Var = (q0) obj;
            if (q0Var.getParameters().size() != getParameters().size()) {
                return false;
            }
            f c2 = c();
            f c3 = q0Var.c();
            if (c3 != null && p(c2) && p(c3)) {
                return q(c3);
            }
            return false;
        }
        return false;
    }

    public final boolean f(@d f fVar, @d f fVar2) {
        if (f0.g(fVar.getName(), fVar2.getName())) {
            k b = fVar.b();
            for (k b2 = fVar2.b(); b != null && b2 != null; b2 = b2.b()) {
                if (b instanceof h.p2.b0.g.t.c.z) {
                    return b2 instanceof h.p2.b0.g.t.c.z;
                }
                if (b2 instanceof h.p2.b0.g.t.c.z) {
                    return false;
                }
                if (b instanceof b0) {
                    return (b2 instanceof b0) && f0.g(((b0) b).e(), ((b0) b2).e());
                } else if ((b2 instanceof b0) || !f0.g(b.getName(), b2.getName())) {
                    return false;
                } else {
                    b = b.b();
                }
            }
            return true;
        }
        return false;
    }

    @d
    public abstract Collection<h.p2.b0.g.t.n.z> h();

    public int hashCode() {
        int identityHashCode;
        int i2 = this.a;
        if (i2 != 0) {
            return i2;
        }
        f c2 = c();
        if (p(c2)) {
            identityHashCode = c.m(c2).hashCode();
        } else {
            identityHashCode = System.identityHashCode(this);
        }
        this.a = identityHashCode;
        return identityHashCode;
    }

    @e
    public h.p2.b0.g.t.n.z i() {
        return null;
    }

    @d
    public Collection<h.p2.b0.g.t.n.z> l(boolean z) {
        return CollectionsKt__CollectionsKt.E();
    }

    public boolean m() {
        return this.f16868c;
    }

    @d
    public abstract r0 n();

    @Override // h.p2.b0.g.t.n.q0
    @d
    /* renamed from: o */
    public List<h.p2.b0.g.t.n.z> j() {
        return this.b.invoke().b();
    }

    public abstract boolean q(@d f fVar);

    @d
    public List<h.p2.b0.g.t.n.z> r(@d List<h.p2.b0.g.t.n.z> list) {
        return list;
    }

    public void s(@d h.p2.b0.g.t.n.z zVar) {
    }

    public void t(@d h.p2.b0.g.t.n.z zVar) {
    }
}
