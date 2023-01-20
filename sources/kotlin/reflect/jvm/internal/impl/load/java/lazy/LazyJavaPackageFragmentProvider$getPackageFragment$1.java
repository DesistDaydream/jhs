package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import h.k2.u.a;
import h.p2.b0.g.t.e.a.v.e;
import h.p2.b0.g.t.e.a.x.u;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;

/* loaded from: classes3.dex */
public final class LazyJavaPackageFragmentProvider$getPackageFragment$1 extends Lambda implements a<LazyJavaPackageFragment> {
    public final /* synthetic */ u $jPackage;
    public final /* synthetic */ LazyJavaPackageFragmentProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaPackageFragmentProvider$getPackageFragment$1(LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider, u uVar) {
        super(0);
        this.this$0 = lazyJavaPackageFragmentProvider;
        this.$jPackage = uVar;
    }

    @Override // h.k2.u.a
    @d
    public final LazyJavaPackageFragment invoke() {
        e eVar;
        eVar = this.this$0.a;
        return new LazyJavaPackageFragment(eVar, this.$jPackage);
    }
}
