package kotlin.reflect.jvm.internal.impl.load.java.components;

import h.k2.v.n0;
import h.p2.b0.g.t.b.g;
import h.p2.b0.g.t.e.a.v.e;
import h.p2.b0.g.t.e.a.x.a;
import h.p2.b0.g.t.g.f;
import h.p2.b0.g.t.m.h;
import h.p2.b0.g.t.m.l;
import h.p2.n;
import java.util.Map;
import k.e.a.d;
import kotlin.jvm.internal.PropertyReference1Impl;

/* loaded from: classes3.dex */
public final class JavaRetentionAnnotationDescriptor extends JavaAnnotationDescriptor {

    /* renamed from: h  reason: collision with root package name */
    public static final /* synthetic */ n<Object>[] f16498h = {n0.r(new PropertyReference1Impl(n0.d(JavaRetentionAnnotationDescriptor.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    @d

    /* renamed from: g  reason: collision with root package name */
    private final h f16499g;

    public JavaRetentionAnnotationDescriptor(@d a aVar, @d e eVar) {
        super(eVar, aVar, g.a.I);
        this.f16499g = eVar.e().c(new JavaRetentionAnnotationDescriptor$allValueArguments$2(this));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor, h.p2.b0.g.t.c.b1.c
    @d
    public Map<f, h.p2.b0.g.t.k.n.g<?>> a() {
        return (Map) l.a(this.f16499g, this, f16498h[0]);
    }
}
