package kotlin.reflect.jvm.internal.impl.types;

import h.k2.u.l;
import h.p2.b0.g.t.c.b1.e;
import h.p2.b0.g.t.n.e1.h;
import h.p2.b0.g.t.n.f0;
import h.p2.b0.g.t.n.q0;
import h.p2.b0.g.t.n.s0;
import java.util.List;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;

/* loaded from: classes3.dex */
public final class KotlinTypeFactory$simpleType$1 extends Lambda implements l<h, f0> {
    public final /* synthetic */ e $annotations;
    public final /* synthetic */ List<s0> $arguments;
    public final /* synthetic */ q0 $constructor;
    public final /* synthetic */ boolean $nullable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public KotlinTypeFactory$simpleType$1(q0 q0Var, List<? extends s0> list, e eVar, boolean z) {
        super(1);
        this.$constructor = q0Var;
        this.$arguments = list;
        this.$annotations = eVar;
        this.$nullable = z;
    }

    @Override // h.k2.u.l
    @k.e.a.e
    public final f0 invoke(@d h hVar) {
        KotlinTypeFactory.a f2;
        f2 = KotlinTypeFactory.a.f(this.$constructor, hVar, this.$arguments);
        if (f2 == null) {
            return null;
        }
        f0 a = f2.a();
        return a == null ? KotlinTypeFactory.h(this.$annotations, f2.b(), this.$arguments, this.$nullable, hVar) : a;
    }
}
