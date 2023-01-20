package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import h.k2.u.a;
import h.p2.b0.g.t.e.a.v.e;
import h.p2.b0.g.t.e.b.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: classes3.dex */
public final class JvmPackageScope$kotlinScopes$2 extends Lambda implements a<MemberScope[]> {
    public final /* synthetic */ JvmPackageScope this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmPackageScope$kotlinScopes$2(JvmPackageScope jvmPackageScope) {
        super(0);
        this.this$0 = jvmPackageScope;
    }

    @Override // h.k2.u.a
    @d
    public final MemberScope[] invoke() {
        LazyJavaPackageFragment lazyJavaPackageFragment;
        e eVar;
        LazyJavaPackageFragment lazyJavaPackageFragment2;
        lazyJavaPackageFragment = this.this$0.f16512c;
        Collection<m> values = lazyJavaPackageFragment.I0().values();
        JvmPackageScope jvmPackageScope = this.this$0;
        ArrayList arrayList = new ArrayList();
        for (m mVar : values) {
            eVar = jvmPackageScope.b;
            DeserializedDescriptorResolver b = eVar.a().b();
            lazyJavaPackageFragment2 = jvmPackageScope.f16512c;
            MemberScope c2 = b.c(lazyJavaPackageFragment2, mVar);
            if (c2 != null) {
                arrayList.add(c2);
            }
        }
        Object[] array = h.p2.b0.g.t.o.k.a.b(arrayList).toArray(new MemberScope[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (MemberScope[]) array;
    }
}
