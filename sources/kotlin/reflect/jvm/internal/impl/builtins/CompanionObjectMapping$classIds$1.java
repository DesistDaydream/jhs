package kotlin.reflect.jvm.internal.impl.builtins;

import h.k2.u.l;
import h.k2.v.n0;
import h.p2.b0.g.t.b.g;
import h.p2.b0.g.t.g.c;
import h.p2.h;
import k.e.a.d;
import kotlin.jvm.internal.FunctionReference;

/* loaded from: classes3.dex */
public /* synthetic */ class CompanionObjectMapping$classIds$1 extends FunctionReference implements l<PrimitiveType, c> {
    public CompanionObjectMapping$classIds$1(g gVar) {
        super(1, gVar);
    }

    @Override // kotlin.jvm.internal.CallableReference, h.p2.c
    @d
    public final String getName() {
        return "getPrimitiveFqName";
    }

    @Override // kotlin.jvm.internal.CallableReference
    @d
    public final h getOwner() {
        return n0.d(g.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    @d
    public final String getSignature() {
        return "getPrimitiveFqName(Lorg/jetbrains/kotlin/builtins/PrimitiveType;)Lorg/jetbrains/kotlin/name/FqName;";
    }

    @Override // h.k2.u.l
    @d
    public final c invoke(@d PrimitiveType primitiveType) {
        return g.c(primitiveType);
    }
}
