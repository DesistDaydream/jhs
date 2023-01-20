package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import h.k2.u.a;
import h.p2.b0.g.t.c.b0;
import h.p2.b0.g.t.c.d0;
import java.util.List;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class LazyPackageViewDescriptorImpl$fragments$2 extends Lambda implements a<List<? extends b0>> {
    public final /* synthetic */ LazyPackageViewDescriptorImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyPackageViewDescriptorImpl$fragments$2(LazyPackageViewDescriptorImpl lazyPackageViewDescriptorImpl) {
        super(0);
        this.this$0 = lazyPackageViewDescriptorImpl;
    }

    @Override // h.k2.u.a
    @d
    public final List<? extends b0> invoke() {
        return d0.c(this.this$0.y0().M0(), this.this$0.e());
    }
}
