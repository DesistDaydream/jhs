package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import h.k2.u.l;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.g.f;
import java.util.Collection;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: classes3.dex */
public final class LazyJavaStaticClassScope$computeNonDeclaredProperties$propertiesFromSupertypes$1 extends Lambda implements l<MemberScope, Collection<? extends j0>> {
    public final /* synthetic */ f $name;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaStaticClassScope$computeNonDeclaredProperties$propertiesFromSupertypes$1(f fVar) {
        super(1);
        this.$name = fVar;
    }

    @Override // h.k2.u.l
    @d
    public final Collection<? extends j0> invoke(@d MemberScope memberScope) {
        return memberScope.c(this.$name, NoLookupLocation.WHEN_GET_SUPER_MEMBERS);
    }
}
