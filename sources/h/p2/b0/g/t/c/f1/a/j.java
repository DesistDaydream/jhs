package h.p2.b0.g.t.c.f1.a;

import h.k2.v.f0;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* loaded from: classes3.dex */
public final class j implements h.p2.b0.g.t.l.b.l {
    @k.e.a.d
    public static final j b = new j();

    private j() {
    }

    @Override // h.p2.b0.g.t.l.b.l
    public void a(@k.e.a.d CallableMemberDescriptor callableMemberDescriptor) {
        throw new IllegalStateException(f0.C("Cannot infer visibility for ", callableMemberDescriptor));
    }

    @Override // h.p2.b0.g.t.l.b.l
    public void b(@k.e.a.d h.p2.b0.g.t.c.d dVar, @k.e.a.d List<String> list) {
        throw new IllegalStateException("Incomplete hierarchy for class " + dVar.getName() + ", unresolved classes " + list);
    }
}
