package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import h.a2.u;
import h.k2.v.n0;
import h.p2.b0.g.t.c.b1.c;
import h.p2.b0.g.t.c.v0;
import h.p2.b0.g.t.e.a.p;
import h.p2.b0.g.t.e.a.u.f;
import h.p2.b0.g.t.e.a.v.e;
import h.p2.b0.g.t.e.a.x.a;
import h.p2.b0.g.t.e.a.x.m;
import h.p2.b0.g.t.e.a.x.o;
import h.p2.b0.g.t.e.a.x.x;
import h.p2.b0.g.t.g.b;
import h.p2.b0.g.t.k.n.g;
import h.p2.b0.g.t.k.n.q;
import h.p2.b0.g.t.m.h;
import h.p2.b0.g.t.m.i;
import h.p2.b0.g.t.m.l;
import h.p2.b0.g.t.n.a0;
import h.p2.b0.g.t.n.f0;
import h.p2.b0.g.t.n.s;
import h.p2.n;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import k.e.a.d;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes3.dex */
public final class LazyJavaAnnotationDescriptor implements c, f {

    /* renamed from: i  reason: collision with root package name */
    public static final /* synthetic */ n<Object>[] f16515i = {n0.r(new PropertyReference1Impl(n0.d(LazyJavaAnnotationDescriptor.class), "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;")), n0.r(new PropertyReference1Impl(n0.d(LazyJavaAnnotationDescriptor.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;")), n0.r(new PropertyReference1Impl(n0.d(LazyJavaAnnotationDescriptor.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    @d
    private final e a;
    @d
    private final a b;
    @d

    /* renamed from: c  reason: collision with root package name */
    private final i f16516c;
    @d

    /* renamed from: d  reason: collision with root package name */
    private final h f16517d;
    @d

    /* renamed from: e  reason: collision with root package name */
    private final h.p2.b0.g.t.e.a.w.a f16518e;
    @d

    /* renamed from: f  reason: collision with root package name */
    private final h f16519f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f16520g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f16521h;

    public LazyJavaAnnotationDescriptor(@d e eVar, @d a aVar, boolean z) {
        this.a = eVar;
        this.b = aVar;
        this.f16516c = eVar.e().e(new LazyJavaAnnotationDescriptor$fqName$2(this));
        this.f16517d = eVar.e().c(new LazyJavaAnnotationDescriptor$type$2(this));
        this.f16518e = eVar.a().t().a(aVar);
        this.f16519f = eVar.e().c(new LazyJavaAnnotationDescriptor$allValueArguments$2(this));
        this.f16520g = aVar.d();
        this.f16521h = aVar.G() || z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final h.p2.b0.g.t.c.d h(h.p2.b0.g.t.g.c cVar) {
        return FindClassInModuleKt.c(this.a.d(), b.m(cVar), this.a.a().b().e().q());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final g<?> k(h.p2.b0.g.t.e.a.x.b bVar) {
        if (bVar instanceof o) {
            return ConstantValueFactory.a.c(((o) bVar).getValue());
        }
        if (bVar instanceof m) {
            m mVar = (m) bVar;
            return n(mVar.d(), mVar.e());
        } else if (bVar instanceof h.p2.b0.g.t.e.a.x.e) {
            h.p2.b0.g.t.e.a.x.e eVar = (h.p2.b0.g.t.e.a.x.e) bVar;
            h.p2.b0.g.t.g.f name = eVar.getName();
            if (name == null) {
                name = p.f15244c;
            }
            return m(name, eVar.c());
        } else if (bVar instanceof h.p2.b0.g.t.e.a.x.c) {
            return l(((h.p2.b0.g.t.e.a.x.c) bVar).a());
        } else {
            if (bVar instanceof h.p2.b0.g.t.e.a.x.h) {
                return o(((h.p2.b0.g.t.e.a.x.h) bVar).b());
            }
            return null;
        }
    }

    private final g<?> l(a aVar) {
        return new h.p2.b0.g.t.k.n.a(new LazyJavaAnnotationDescriptor(this.a, aVar, false, 4, null));
    }

    private final g<?> m(h.p2.b0.g.t.g.f fVar, List<? extends h.p2.b0.g.t.e.a.x.b> list) {
        if (a0.a(getType())) {
            return null;
        }
        v0 b = h.p2.b0.g.t.e.a.t.a.b(fVar, DescriptorUtilsKt.f(this));
        f0 type = b != null ? b.getType() : null;
        if (type == null) {
            type = this.a.a().m().k().l(Variance.INVARIANT, s.j("Unknown array element type"));
        }
        ArrayList arrayList = new ArrayList(u.Y(list, 10));
        for (h.p2.b0.g.t.e.a.x.b bVar : list) {
            g<?> k2 = k(bVar);
            if (k2 == null) {
                k2 = new q();
            }
            arrayList.add(k2);
        }
        return ConstantValueFactory.a.b(arrayList, type);
    }

    private final g<?> n(b bVar, h.p2.b0.g.t.g.f fVar) {
        if (bVar == null || fVar == null) {
            return null;
        }
        return new h.p2.b0.g.t.k.n.i(bVar, fVar);
    }

    private final g<?> o(x xVar) {
        return h.p2.b0.g.t.k.n.o.b.a(this.a.g().n(xVar, JavaTypeResolverKt.f(TypeUsage.COMMON, false, null, 3, null)));
    }

    @Override // h.p2.b0.g.t.c.b1.c
    @d
    public Map<h.p2.b0.g.t.g.f, g<?>> a() {
        return (Map) l.a(this.f16519f, this, f16515i[2]);
    }

    @Override // h.p2.b0.g.t.e.a.u.f
    public boolean d() {
        return this.f16520g;
    }

    @Override // h.p2.b0.g.t.c.b1.c
    @k.e.a.e
    public h.p2.b0.g.t.g.c e() {
        return (h.p2.b0.g.t.g.c) l.b(this.f16516c, this, f16515i[0]);
    }

    @Override // h.p2.b0.g.t.c.b1.c
    @d
    /* renamed from: i */
    public h.p2.b0.g.t.e.a.w.a getSource() {
        return this.f16518e;
    }

    public final boolean j() {
        return this.f16521h;
    }

    @d
    public String toString() {
        return DescriptorRenderer.u(DescriptorRenderer.f16750g, this, null, 2, null);
    }

    @Override // h.p2.b0.g.t.c.b1.c
    @d
    public f0 getType() {
        return (f0) l.a(this.f16517d, this, f16515i[1]);
    }

    public /* synthetic */ LazyJavaAnnotationDescriptor(e eVar, a aVar, boolean z, int i2, h.k2.v.u uVar) {
        this(eVar, aVar, (i2 & 4) != 0 ? false : z);
    }
}
