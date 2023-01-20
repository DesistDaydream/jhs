package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import h.a2.t;
import h.k2.u.a;
import h.p2.b0.g.t.c.b1.e;
import h.p2.b0.g.t.c.z;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUtilKt;

/* loaded from: classes3.dex */
public final class JvmBuiltInsCustomizer$notConsideredDeprecation$2 extends Lambda implements a<e> {
    public final /* synthetic */ JvmBuiltInsCustomizer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmBuiltInsCustomizer$notConsideredDeprecation$2(JvmBuiltInsCustomizer jvmBuiltInsCustomizer) {
        super(0);
        this.this$0 = jvmBuiltInsCustomizer;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final e invoke() {
        z zVar;
        zVar = this.this$0.a;
        return e.w0.a(t.k(AnnotationUtilKt.b(zVar.k(), "This member is not fully supported by Kotlin compiler, so it may be absent or have different signature in next major version", null, null, 6, null)));
    }
}
