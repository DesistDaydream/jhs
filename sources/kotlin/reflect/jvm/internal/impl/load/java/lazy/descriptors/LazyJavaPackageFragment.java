package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import h.k2.v.f0;
import h.k2.v.n0;
import h.p2.b0.g.t.c.d1.w;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.e.a.v.e;
import h.p2.b0.g.t.e.a.x.g;
import h.p2.b0.g.t.e.a.x.u;
import h.p2.b0.g.t.e.b.m;
import h.p2.b0.g.t.g.c;
import h.p2.b0.g.t.m.h;
import h.p2.b0.g.t.m.l;
import h.p2.n;
import java.util.List;
import java.util.Map;
import k.e.a.d;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;

/* loaded from: classes3.dex */
public final class LazyJavaPackageFragment extends w {

    /* renamed from: m  reason: collision with root package name */
    public static final /* synthetic */ n<Object>[] f16528m = {n0.r(new PropertyReference1Impl(n0.d(LazyJavaPackageFragment.class), "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;")), n0.r(new PropertyReference1Impl(n0.d(LazyJavaPackageFragment.class), "partToFacade", "getPartToFacade()Ljava/util/HashMap;"))};
    @d

    /* renamed from: f  reason: collision with root package name */
    private final u f16529f;
    @d

    /* renamed from: g  reason: collision with root package name */
    private final e f16530g;
    @d

    /* renamed from: h  reason: collision with root package name */
    private final h f16531h;
    @d

    /* renamed from: i  reason: collision with root package name */
    private final JvmPackageScope f16532i;
    @d

    /* renamed from: j  reason: collision with root package name */
    private final h<List<c>> f16533j;
    @d

    /* renamed from: k  reason: collision with root package name */
    private final h.p2.b0.g.t.c.b1.e f16534k;
    @d

    /* renamed from: l  reason: collision with root package name */
    private final h f16535l;

    public LazyJavaPackageFragment(@d e eVar, @d u uVar) {
        super(eVar.d(), uVar.e());
        this.f16529f = uVar;
        e d2 = ContextKt.d(eVar, this, null, 0, 6, null);
        this.f16530g = d2;
        this.f16531h = d2.e().c(new LazyJavaPackageFragment$binaryClasses$2(this));
        this.f16532i = new JvmPackageScope(d2, uVar, this);
        this.f16533j = d2.e().b(new LazyJavaPackageFragment$subPackages$1(this), CollectionsKt__CollectionsKt.E());
        this.f16534k = d2.a().i().a() ? h.p2.b0.g.t.c.b1.e.w0.b() : h.p2.b0.g.t.e.a.v.d.a(d2, uVar);
        this.f16535l = d2.e().c(new LazyJavaPackageFragment$partToFacade$2(this));
    }

    @k.e.a.e
    public final h.p2.b0.g.t.c.d H0(@d g gVar) {
        return this.f16532i.k().P(gVar);
    }

    @d
    public final Map<String, m> I0() {
        return (Map) l.a(this.f16531h, this, f16528m[0]);
    }

    @Override // h.p2.b0.g.t.c.b0
    @d
    /* renamed from: J0 */
    public JvmPackageScope q() {
        return this.f16532i;
    }

    @d
    public final List<c> K0() {
        return this.f16533j.invoke();
    }

    @Override // h.p2.b0.g.t.c.b1.b, h.p2.b0.g.t.c.b1.a
    @d
    public h.p2.b0.g.t.c.b1.e getAnnotations() {
        return this.f16534k;
    }

    @Override // h.p2.b0.g.t.c.d1.w, h.p2.b0.g.t.c.d1.j, h.p2.b0.g.t.c.n
    @d
    public o0 getSource() {
        return new h.p2.b0.g.t.e.b.n(this);
    }

    @Override // h.p2.b0.g.t.c.d1.w, h.p2.b0.g.t.c.d1.i
    @d
    public String toString() {
        return f0.C("Lazy Java package fragment: ", e());
    }
}
