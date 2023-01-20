package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import h.k2.u.l;
import h.p2.b0.g.t.e.a.x.q;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class LazyJavaClassMemberScope$computeMemberIndex$1 extends Lambda implements l<q, Boolean> {
    public static final LazyJavaClassMemberScope$computeMemberIndex$1 INSTANCE = new LazyJavaClassMemberScope$computeMemberIndex$1();

    public LazyJavaClassMemberScope$computeMemberIndex$1() {
        super(1);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ Boolean invoke(q qVar) {
        return Boolean.valueOf(invoke2(qVar));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(@d q qVar) {
        return !qVar.Q();
    }
}
