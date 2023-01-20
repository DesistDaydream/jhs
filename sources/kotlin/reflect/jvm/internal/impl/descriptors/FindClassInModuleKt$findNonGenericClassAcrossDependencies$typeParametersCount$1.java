package kotlin.reflect.jvm.internal.impl.descriptors;

import h.k2.u.l;
import h.k2.v.n0;
import h.p2.b0.g.t.g.b;
import h.p2.h;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.FunctionReference;

/* loaded from: classes3.dex */
public /* synthetic */ class FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1 extends FunctionReference implements l<b, b> {
    public static final FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1 INSTANCE = new FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1();

    public FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1() {
        super(1);
    }

    @Override // kotlin.jvm.internal.CallableReference, h.p2.c
    @d
    public final String getName() {
        return "getOuterClassId";
    }

    @Override // kotlin.jvm.internal.CallableReference
    @d
    public final h getOwner() {
        return n0.d(b.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    @d
    public final String getSignature() {
        return "getOuterClassId()Lorg/jetbrains/kotlin/name/ClassId;";
    }

    @Override // h.k2.u.l
    @e
    public final b invoke(@d b bVar) {
        return bVar.g();
    }
}
