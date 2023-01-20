package h.p2.b0.g.t.n;

import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;

/* loaded from: classes3.dex */
public final class w extends u implements z0 {
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final u f15612d;
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private final z f15613e;

    public w(@k.e.a.d u uVar, @k.e.a.d z zVar) {
        super(uVar.Q0(), uVar.R0());
        this.f15612d = uVar;
        this.f15613e = zVar;
    }

    @Override // h.p2.b0.g.t.n.c1
    @k.e.a.d
    public c1 M0(boolean z) {
        return a1.d(C0().M0(z), f0().L0().M0(z));
    }

    @Override // h.p2.b0.g.t.n.c1
    @k.e.a.d
    public c1 O0(@k.e.a.d h.p2.b0.g.t.c.b1.e eVar) {
        return a1.d(C0().O0(eVar), f0());
    }

    @Override // h.p2.b0.g.t.n.u
    @k.e.a.d
    public f0 P0() {
        return C0().P0();
    }

    @Override // h.p2.b0.g.t.n.u
    @k.e.a.d
    public String S0(@k.e.a.d DescriptorRenderer descriptorRenderer, @k.e.a.d h.p2.b0.g.t.j.b bVar) {
        if (bVar.d()) {
            return descriptorRenderer.y(f0());
        }
        return C0().S0(descriptorRenderer, bVar);
    }

    @Override // h.p2.b0.g.t.n.z0
    @k.e.a.d
    /* renamed from: T0 */
    public u C0() {
        return this.f15612d;
    }

    @Override // h.p2.b0.g.t.n.c1
    @k.e.a.d
    /* renamed from: U0 */
    public w N0(@k.e.a.d h.p2.b0.g.t.n.e1.h hVar) {
        return new w((u) hVar.g(C0()), hVar.g(f0()));
    }

    @Override // h.p2.b0.g.t.n.z0
    @k.e.a.d
    public z f0() {
        return this.f15613e;
    }
}
