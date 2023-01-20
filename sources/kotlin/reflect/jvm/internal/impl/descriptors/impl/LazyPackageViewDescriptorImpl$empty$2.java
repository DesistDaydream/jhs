package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import h.k2.u.a;
import h.p2.b0.g.t.c.d0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class LazyPackageViewDescriptorImpl$empty$2 extends Lambda implements a<Boolean> {
    public final /* synthetic */ LazyPackageViewDescriptorImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyPackageViewDescriptorImpl$empty$2(LazyPackageViewDescriptorImpl lazyPackageViewDescriptorImpl) {
        super(0);
        this.this$0 = lazyPackageViewDescriptorImpl;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, java.lang.Boolean] */
    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Boolean invoke2() {
        return d0.b(this.this$0.y0().M0(), this.this$0.e());
    }
}
