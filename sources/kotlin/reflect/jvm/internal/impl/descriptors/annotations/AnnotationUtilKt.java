package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import h.a2.t0;
import h.p2.b0.g.t.b.g;
import h.p2.b0.g.t.c.b1.c;
import h.p2.b0.g.t.g.f;
import h.p2.b0.g.t.k.n.a;
import h.p2.b0.g.t.k.n.b;
import h.p2.b0.g.t.k.n.i;
import h.p2.b0.g.t.k.n.t;
import h.z0;
import k.e.a.d;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes3.dex */
public final class AnnotationUtilKt {
    @d
    private static final f a = f.f("message");
    @d
    private static final f b = f.f("replaceWith");
    @d

    /* renamed from: c  reason: collision with root package name */
    private static final f f16446c = f.f("level");
    @d

    /* renamed from: d  reason: collision with root package name */
    private static final f f16447d = f.f("expression");
    @d

    /* renamed from: e  reason: collision with root package name */
    private static final f f16448e = f.f("imports");

    @d
    public static final c a(@d h.p2.b0.g.t.b.f fVar, @d String str, @d String str2, @d String str3) {
        return new BuiltInAnnotationDescriptor(fVar, g.a.y, t0.W(z0.a(a, new t(str)), z0.a(b, new a(new BuiltInAnnotationDescriptor(fVar, g.a.B, t0.W(z0.a(f16447d, new t(str2)), z0.a(f16448e, new b(CollectionsKt__CollectionsKt.E(), new AnnotationUtilKt$createDeprecatedAnnotation$replaceWithAnnotation$1(fVar))))))), z0.a(f16446c, new i(h.p2.b0.g.t.g.b.m(g.a.A), f.f(str3)))));
    }

    public static /* synthetic */ c b(h.p2.b0.g.t.b.f fVar, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = "";
        }
        if ((i2 & 4) != 0) {
            str3 = "WARNING";
        }
        return a(fVar, str, str2, str3);
    }
}
