package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import h.k2.u.l;
import h.p2.b0.g.t.c.n0;
import h.p2.b0.g.t.g.f;
import h.p2.h;
import java.util.Collection;
import k.e.a.d;
import kotlin.jvm.internal.FunctionReference;

/* loaded from: classes3.dex */
public /* synthetic */ class LazyJavaClassMemberScope$computeNonDeclaredFunctions$4 extends FunctionReference implements l<f, Collection<? extends n0>> {
    public LazyJavaClassMemberScope$computeNonDeclaredFunctions$4(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        super(1, lazyJavaClassMemberScope);
    }

    @Override // kotlin.jvm.internal.CallableReference, h.p2.c
    @d
    public final String getName() {
        return "searchMethodsInSupertypesWithoutBuiltinMagic";
    }

    @Override // kotlin.jvm.internal.CallableReference
    @d
    public final h getOwner() {
        return h.k2.v.n0.d(LazyJavaClassMemberScope.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    @d
    public final String getSignature() {
        return "searchMethodsInSupertypesWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
    }

    @Override // h.k2.u.l
    @d
    public final Collection<n0> invoke(@d f fVar) {
        Collection<n0> J0;
        J0 = ((LazyJavaClassMemberScope) this.receiver).J0(fVar);
        return J0;
    }
}
