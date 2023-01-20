package kotlin.reflect.jvm.internal.impl.types;

import h.k2.u.a;
import h.p2.b0.g.t.m.h;
import h.p2.b0.g.t.m.m;
import h.p2.b0.g.t.n.d1;
import h.p2.b0.g.t.n.z;
import k.e.a.d;

/* loaded from: classes3.dex */
public final class LazyWrappedType extends d1 {
    @d
    private final m b;
    @d

    /* renamed from: c  reason: collision with root package name */
    private final a<z> f16871c;
    @d

    /* renamed from: d  reason: collision with root package name */
    private final h<z> f16872d;

    /* JADX WARN: Multi-variable type inference failed */
    public LazyWrappedType(@d m mVar, @d a<? extends z> aVar) {
        this.b = mVar;
        this.f16871c = aVar;
        this.f16872d = mVar.c(aVar);
    }

    @Override // h.p2.b0.g.t.n.d1
    @d
    public z M0() {
        return this.f16872d.invoke();
    }

    @Override // h.p2.b0.g.t.n.d1
    public boolean N0() {
        return this.f16872d.o();
    }

    @Override // h.p2.b0.g.t.n.z
    @d
    /* renamed from: P0 */
    public LazyWrappedType K0(@d h.p2.b0.g.t.n.e1.h hVar) {
        return new LazyWrappedType(this.b, new LazyWrappedType$refine$1(hVar, this));
    }
}
