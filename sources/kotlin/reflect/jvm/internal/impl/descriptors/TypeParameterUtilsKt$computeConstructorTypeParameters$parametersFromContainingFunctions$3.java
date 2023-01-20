package kotlin.reflect.jvm.internal.impl.descriptors;

import h.k2.u.l;
import h.p2.b0.g.t.c.a;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.t0;
import h.q2.m;
import k.e.a.d;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$3 extends Lambda implements l<k, m<? extends t0>> {
    public static final TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$3 INSTANCE = new TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$3();

    public TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$3() {
        super(1);
    }

    @Override // h.k2.u.l
    @d
    public final m<t0> invoke(@d k kVar) {
        return CollectionsKt___CollectionsKt.n1(((a) kVar).getTypeParameters());
    }
}
