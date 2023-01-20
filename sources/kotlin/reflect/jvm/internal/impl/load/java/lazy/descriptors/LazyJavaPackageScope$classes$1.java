package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import h.k2.u.l;
import h.k2.v.f0;
import h.p2.b0.g.t.c.d;
import h.p2.b0.g.t.e.a.i;
import h.p2.b0.g.t.e.a.v.e;
import h.p2.b0.g.t.e.a.x.g;
import h.p2.b0.g.t.e.b.k;
import h.p2.b0.g.t.e.b.m;
import h.p2.b0.g.t.g.b;
import h.p2.b0.g.t.g.c;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;

/* loaded from: classes3.dex */
public final class LazyJavaPackageScope$classes$1 extends Lambda implements l<LazyJavaPackageScope.a, d> {
    public final /* synthetic */ e $c;
    public final /* synthetic */ LazyJavaPackageScope this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaPackageScope$classes$1(LazyJavaPackageScope lazyJavaPackageScope, e eVar) {
        super(1);
        this.this$0 = lazyJavaPackageScope;
        this.$c = eVar;
    }

    @Override // h.k2.u.l
    @k.e.a.e
    public final d invoke(@k.e.a.d LazyJavaPackageScope.a aVar) {
        k.a c2;
        LazyJavaPackageScope.b S;
        byte[] b;
        b bVar = new b(this.this$0.D().e(), aVar.b());
        if (aVar.a() != null) {
            c2 = this.$c.a().j().a(aVar.a());
        } else {
            c2 = this.$c.a().j().c(bVar);
        }
        m a = c2 == null ? null : c2.a();
        b b2 = a == null ? null : a.b();
        if (b2 == null || !(b2.l() || b2.k())) {
            S = this.this$0.S(a);
            if (S instanceof LazyJavaPackageScope.b.a) {
                return ((LazyJavaPackageScope.b.a) S).a();
            }
            if (S instanceof LazyJavaPackageScope.b.c) {
                return null;
            }
            if (S instanceof LazyJavaPackageScope.b.C0495b) {
                g a2 = aVar.a();
                if (a2 == null) {
                    i d2 = this.$c.a().d();
                    if (c2 != null) {
                        if (!(c2 instanceof k.a.C0450a)) {
                            c2 = null;
                        }
                        k.a.C0450a c0450a = (k.a.C0450a) c2;
                        if (c0450a != null) {
                            b = c0450a.b();
                            a2 = d2.a(new i.a(bVar, b, null, 4, null));
                        }
                    }
                    b = null;
                    a2 = d2.a(new i.a(bVar, b, null, 4, null));
                }
                g gVar = a2;
                if ((gVar == null ? null : gVar.L()) != LightClassOriginKind.BINARY) {
                    c e2 = gVar == null ? null : gVar.e();
                    if (e2 == null || e2.d() || !f0.g(e2.e(), this.this$0.D().e())) {
                        return null;
                    }
                    LazyJavaClassDescriptor lazyJavaClassDescriptor = new LazyJavaClassDescriptor(this.$c, this.this$0.D(), gVar, null, 8, null);
                    this.$c.a().e().a(lazyJavaClassDescriptor);
                    return lazyJavaClassDescriptor;
                }
                throw new IllegalStateException("Couldn't find kotlin binary class for light class created by kotlin binary file\nJavaClass: " + gVar + "\nClassId: " + bVar + "\nfindKotlinClass(JavaClass) = " + h.p2.b0.g.t.e.b.l.a(this.$c.a().j(), gVar) + "\nfindKotlinClass(ClassId) = " + h.p2.b0.g.t.e.b.l.b(this.$c.a().j(), bVar) + '\n');
            }
            throw new NoWhenBranchMatchedException();
        }
        return null;
    }
}
