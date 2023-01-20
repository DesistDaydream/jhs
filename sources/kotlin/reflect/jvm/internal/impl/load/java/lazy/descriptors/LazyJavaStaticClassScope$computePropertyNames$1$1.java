package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import h.k2.u.l;
import h.p2.b0.g.t.g.f;
import java.util.Collection;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: classes3.dex */
public final class LazyJavaStaticClassScope$computePropertyNames$1$1 extends Lambda implements l<MemberScope, Collection<? extends f>> {
    public static final LazyJavaStaticClassScope$computePropertyNames$1$1 INSTANCE = new LazyJavaStaticClassScope$computePropertyNames$1$1();

    public LazyJavaStaticClassScope$computePropertyNames$1$1() {
        super(1);
    }

    @Override // h.k2.u.l
    @d
    public final Collection<f> invoke(@d MemberScope memberScope) {
        return memberScope.d();
    }
}
