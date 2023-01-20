package h.p2.b0.g.t.n;

import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: classes3.dex */
public final class p extends u implements h.p2.b0.g.t.n.g1.d {
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final h.p2.b0.g.t.c.b1.e f15596d;

    public p(@k.e.a.d h.p2.b0.g.t.b.f fVar, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar) {
        super(fVar.H(), fVar.I());
        this.f15596d = eVar;
    }

    @Override // h.p2.b0.g.t.n.u, h.p2.b0.g.t.n.z
    public boolean J0() {
        return false;
    }

    @Override // h.p2.b0.g.t.n.u
    @k.e.a.d
    public f0 P0() {
        return R0();
    }

    @Override // h.p2.b0.g.t.n.u
    @k.e.a.d
    public String S0(@k.e.a.d DescriptorRenderer descriptorRenderer, @k.e.a.d h.p2.b0.g.t.j.b bVar) {
        return "dynamic";
    }

    @Override // h.p2.b0.g.t.n.c1
    @k.e.a.d
    /* renamed from: T0 */
    public p M0(boolean z) {
        return this;
    }

    @Override // h.p2.b0.g.t.n.c1
    @k.e.a.d
    /* renamed from: U0 */
    public p N0(@k.e.a.d h.p2.b0.g.t.n.e1.h hVar) {
        return this;
    }

    @Override // h.p2.b0.g.t.n.c1
    @k.e.a.d
    /* renamed from: V0 */
    public p O0(@k.e.a.d h.p2.b0.g.t.c.b1.e eVar) {
        return new p(TypeUtilsKt.h(P0()), eVar);
    }

    @Override // h.p2.b0.g.t.n.u, h.p2.b0.g.t.c.b1.a
    @k.e.a.d
    public h.p2.b0.g.t.c.b1.e getAnnotations() {
        return this.f15596d;
    }
}
