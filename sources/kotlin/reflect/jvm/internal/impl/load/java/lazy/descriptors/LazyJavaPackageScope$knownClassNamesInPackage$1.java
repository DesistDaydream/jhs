package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import h.k2.u.a;
import h.p2.b0.g.t.e.a.v.e;
import java.util.Set;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class LazyJavaPackageScope$knownClassNamesInPackage$1 extends Lambda implements a<Set<? extends String>> {
    public final /* synthetic */ e $c;
    public final /* synthetic */ LazyJavaPackageScope this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaPackageScope$knownClassNamesInPackage$1(e eVar, LazyJavaPackageScope lazyJavaPackageScope) {
        super(0);
        this.$c = eVar;
        this.this$0 = lazyJavaPackageScope;
    }

    @Override // h.k2.u.a
    @k.e.a.e
    public final Set<? extends String> invoke() {
        return this.$c.a().d().c(this.this$0.D().e());
    }
}
