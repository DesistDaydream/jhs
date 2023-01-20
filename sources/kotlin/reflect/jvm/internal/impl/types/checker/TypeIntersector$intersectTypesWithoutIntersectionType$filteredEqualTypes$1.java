package kotlin.reflect.jvm.internal.impl.types.checker;

import h.k2.u.p;
import h.k2.v.n0;
import h.p2.b0.g.t.n.z;
import h.p2.h;
import k.e.a.d;
import kotlin.jvm.internal.FunctionReference;

/* loaded from: classes3.dex */
public /* synthetic */ class TypeIntersector$intersectTypesWithoutIntersectionType$filteredEqualTypes$1 extends FunctionReference implements p<z, z, Boolean> {
    public TypeIntersector$intersectTypesWithoutIntersectionType$filteredEqualTypes$1(TypeIntersector typeIntersector) {
        super(2, typeIntersector);
    }

    @Override // kotlin.jvm.internal.CallableReference, h.p2.c
    @d
    public final String getName() {
        return "isStrictSupertype";
    }

    @Override // kotlin.jvm.internal.CallableReference
    @d
    public final h getOwner() {
        return n0.d(TypeIntersector.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    @d
    public final String getSignature() {
        return "isStrictSupertype(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z";
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ Boolean invoke(z zVar, z zVar2) {
        return Boolean.valueOf(invoke2(zVar, zVar2));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(@d z zVar, @d z zVar2) {
        boolean e2;
        e2 = ((TypeIntersector) this.receiver).e(zVar, zVar2);
        return e2;
    }
}
