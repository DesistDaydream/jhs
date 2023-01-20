package kotlin.reflect.jvm.internal.impl.load.java.components;

import h.a2.t0;
import h.k2.v.f0;
import h.k2.v.n0;
import h.p2.b0.g.t.c.b1.c;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.e.a.u.f;
import h.p2.b0.g.t.e.a.x.a;
import h.p2.b0.g.t.e.a.x.b;
import h.p2.b0.g.t.k.n.g;
import h.p2.b0.g.t.m.h;
import h.p2.b0.g.t.m.l;
import h.p2.n;
import java.util.Collection;
import java.util.Map;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.PropertyReference1Impl;

/* loaded from: classes3.dex */
public class JavaAnnotationDescriptor implements c, f {

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ n<Object>[] f16491f = {n0.r(new PropertyReference1Impl(n0.d(JavaAnnotationDescriptor.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;"))};
    @d
    private final h.p2.b0.g.t.g.c a;
    @d
    private final o0 b;
    @d

    /* renamed from: c  reason: collision with root package name */
    private final h f16492c;
    @e

    /* renamed from: d  reason: collision with root package name */
    private final b f16493d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f16494e;

    public JavaAnnotationDescriptor(@d h.p2.b0.g.t.e.a.v.e eVar, @e a aVar, @d h.p2.b0.g.t.g.c cVar) {
        Collection<b> u;
        this.a = cVar;
        o0 a = aVar == null ? null : eVar.a().t().a(aVar);
        this.b = a == null ? o0.a : a;
        this.f16492c = eVar.e().c(new JavaAnnotationDescriptor$type$2(eVar, this));
        this.f16493d = (aVar == null || (u = aVar.u()) == null) ? null : (b) CollectionsKt___CollectionsKt.r2(u);
        this.f16494e = f0.g(aVar != null ? Boolean.valueOf(aVar.d()) : null, Boolean.TRUE);
    }

    @Override // h.p2.b0.g.t.c.b1.c
    @d
    public Map<h.p2.b0.g.t.g.f, g<?>> a() {
        return t0.z();
    }

    @e
    public final b b() {
        return this.f16493d;
    }

    @Override // h.p2.b0.g.t.e.a.u.f
    public boolean d() {
        return this.f16494e;
    }

    @Override // h.p2.b0.g.t.c.b1.c
    @d
    public h.p2.b0.g.t.g.c e() {
        return this.a;
    }

    @Override // h.p2.b0.g.t.c.b1.c
    @d
    public o0 getSource() {
        return this.b;
    }

    @Override // h.p2.b0.g.t.c.b1.c
    @d
    public h.p2.b0.g.t.n.f0 getType() {
        return (h.p2.b0.g.t.n.f0) l.a(this.f16492c, this, f16491f[0]);
    }
}
