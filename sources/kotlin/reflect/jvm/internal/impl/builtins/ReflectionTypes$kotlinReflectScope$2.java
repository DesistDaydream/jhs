package kotlin.reflect.jvm.internal.impl.builtins;

import h.k2.u.a;
import h.p2.b0.g.t.b.g;
import h.p2.b0.g.t.c.z;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: classes3.dex */
public final class ReflectionTypes$kotlinReflectScope$2 extends Lambda implements a<MemberScope> {
    public final /* synthetic */ z $module;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReflectionTypes$kotlinReflectScope$2(z zVar) {
        super(0);
        this.$module = zVar;
    }

    @Override // h.k2.u.a
    @d
    public final MemberScope invoke() {
        return this.$module.j0(g.f15033k).q();
    }
}
