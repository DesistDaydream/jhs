package kotlin.reflect.jvm.internal.impl.load.java.components;

import h.k2.u.l;
import h.p2.b0.g.t.b.g;
import h.p2.b0.g.t.c.v0;
import h.p2.b0.g.t.c.z;
import h.p2.b0.g.t.e.a.t.a;
import h.p2.b0.g.t.e.a.t.b;
import h.p2.b0.g.t.n.s;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class JavaAnnotationTargetMapper$mapJavaTargetArguments$1 extends Lambda implements l<z, h.p2.b0.g.t.n.z> {
    public static final JavaAnnotationTargetMapper$mapJavaTargetArguments$1 INSTANCE = new JavaAnnotationTargetMapper$mapJavaTargetArguments$1();

    public JavaAnnotationTargetMapper$mapJavaTargetArguments$1() {
        super(1);
    }

    @Override // h.k2.u.l
    @d
    public final h.p2.b0.g.t.n.z invoke(@d z zVar) {
        v0 b = a.b(b.a.d(), zVar.k().o(g.a.F));
        h.p2.b0.g.t.n.z type = b == null ? null : b.getType();
        return type == null ? s.j("Error: AnnotationTarget[]") : type;
    }
}
