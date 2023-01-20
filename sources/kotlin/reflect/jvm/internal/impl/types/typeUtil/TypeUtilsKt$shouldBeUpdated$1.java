package kotlin.reflect.jvm.internal.impl.types.typeUtil;

import h.k2.u.l;
import h.p2.b0.g.t.n.a0;
import h.p2.b0.g.t.n.c1;
import h.p2.b0.g.t.n.g1.t;
import h.p2.b0.g.t.n.l0;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class TypeUtilsKt$shouldBeUpdated$1 extends Lambda implements l<c1, Boolean> {
    public static final TypeUtilsKt$shouldBeUpdated$1 INSTANCE = new TypeUtilsKt$shouldBeUpdated$1();

    public TypeUtilsKt$shouldBeUpdated$1() {
        super(1);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ Boolean invoke(c1 c1Var) {
        return Boolean.valueOf(invoke2(c1Var));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(@d c1 c1Var) {
        return (c1Var instanceof l0) || (c1Var.I0() instanceof t) || a0.a(c1Var);
    }
}
