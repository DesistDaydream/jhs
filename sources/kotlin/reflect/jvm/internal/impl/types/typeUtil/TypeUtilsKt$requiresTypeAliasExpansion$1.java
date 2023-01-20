package kotlin.reflect.jvm.internal.impl.types.typeUtil;

import h.k2.u.l;
import h.p2.b0.g.t.c.f;
import h.p2.b0.g.t.c.s0;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.n.c1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class TypeUtilsKt$requiresTypeAliasExpansion$1 extends Lambda implements l<c1, Boolean> {
    public static final TypeUtilsKt$requiresTypeAliasExpansion$1 INSTANCE = new TypeUtilsKt$requiresTypeAliasExpansion$1();

    public TypeUtilsKt$requiresTypeAliasExpansion$1() {
        super(1);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ Boolean invoke(c1 c1Var) {
        return Boolean.valueOf(invoke2(c1Var));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(@d c1 c1Var) {
        f c2 = c1Var.I0().c();
        if (c2 == null) {
            return false;
        }
        return (c2 instanceof s0) || (c2 instanceof t0);
    }
}
