package kotlin.reflect.jvm.internal.impl.descriptors;

import h.k2.u.l;
import h.p2.b0.g.t.c.a;
import h.p2.b0.g.t.c.k;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$1 extends Lambda implements l<k, Boolean> {
    public static final TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$1 INSTANCE = new TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$1();

    public TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$1() {
        super(1);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ Boolean invoke(k kVar) {
        return Boolean.valueOf(invoke2(kVar));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(@d k kVar) {
        return kVar instanceof a;
    }
}
