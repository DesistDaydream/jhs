package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import h.k2.u.l;
import h.p2.b0.g.t.c.d;
import h.p2.b0.g.t.e.a.v.j.a;
import h.p2.b0.g.t.g.b;
import h.p2.b0.g.t.n.e1.h;
import h.p2.b0.g.t.n.f0;
import k.e.a.e;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* loaded from: classes3.dex */
public final class RawSubstitution$eraseInflexibleBasedOnClassDescriptor$2 extends Lambda implements l<h, f0> {
    public final /* synthetic */ a $attr;
    public final /* synthetic */ d $declaration;
    public final /* synthetic */ f0 $type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RawSubstitution$eraseInflexibleBasedOnClassDescriptor$2(d dVar, f0 f0Var, a aVar) {
        super(1);
        this.$declaration = dVar;
        this.$type = f0Var;
        this.$attr = aVar;
    }

    @Override // h.k2.u.l
    @e
    public final f0 invoke(@k.e.a.d h hVar) {
        d a;
        Pair k2;
        d dVar = this.$declaration;
        if (!(dVar instanceof d)) {
            dVar = null;
        }
        b h2 = dVar == null ? null : DescriptorUtilsKt.h(dVar);
        if (h2 == null || (a = hVar.a(h2)) == null || h.k2.v.f0.g(a, this.$declaration)) {
            return null;
        }
        k2 = RawSubstitution.f16552c.k(this.$type, a, this.$attr);
        return (f0) k2.getFirst();
    }
}
