package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import h.k2.u.l;
import h.k2.v.n0;
import h.p2.b0.g.t.c.v0;
import h.p2.h;
import k.e.a.d;
import kotlin.jvm.internal.FunctionReference;

/* loaded from: classes3.dex */
public /* synthetic */ class DescriptorUtilsKt$declaresOrInheritsDefaultValue$2 extends FunctionReference implements l<v0, Boolean> {
    public static final DescriptorUtilsKt$declaresOrInheritsDefaultValue$2 INSTANCE = new DescriptorUtilsKt$declaresOrInheritsDefaultValue$2();

    public DescriptorUtilsKt$declaresOrInheritsDefaultValue$2() {
        super(1);
    }

    @Override // kotlin.jvm.internal.CallableReference, h.p2.c
    @d
    public final String getName() {
        return "declaresDefaultValue";
    }

    @Override // kotlin.jvm.internal.CallableReference
    @d
    public final h getOwner() {
        return n0.d(v0.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    @d
    public final String getSignature() {
        return "declaresDefaultValue()Z";
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ Boolean invoke(v0 v0Var) {
        return Boolean.valueOf(invoke2(v0Var));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(@d v0 v0Var) {
        return v0Var.x0();
    }
}
