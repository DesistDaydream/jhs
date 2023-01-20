package kotlin.reflect.jvm.internal.impl.load.java.components;

import h.a2.s0;
import h.k2.u.a;
import h.p2.b0.g.t.e.a.t.b;
import h.p2.b0.g.t.g.f;
import h.p2.b0.g.t.k.n.t;
import h.z0;
import java.util.Map;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class JavaDeprecatedAnnotationDescriptor$allValueArguments$2 extends Lambda implements a<Map<f, ? extends t>> {
    public static final JavaDeprecatedAnnotationDescriptor$allValueArguments$2 INSTANCE = new JavaDeprecatedAnnotationDescriptor$allValueArguments$2();

    public JavaDeprecatedAnnotationDescriptor$allValueArguments$2() {
        super(0);
    }

    @Override // h.k2.u.a
    @d
    public final Map<f, ? extends t> invoke() {
        return s0.k(z0.a(b.a.b(), new t("Deprecated in Java")));
    }
}
