package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import h.k2.u.l;
import h.p2.b0.g.t.b.f;
import h.p2.b0.g.t.c.z;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes3.dex */
public final class AnnotationUtilKt$createDeprecatedAnnotation$replaceWithAnnotation$1 extends Lambda implements l<z, h.p2.b0.g.t.n.z> {
    public final /* synthetic */ f $this_createDeprecatedAnnotation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnotationUtilKt$createDeprecatedAnnotation$replaceWithAnnotation$1(f fVar) {
        super(1);
        this.$this_createDeprecatedAnnotation = fVar;
    }

    @Override // h.k2.u.l
    @d
    public final h.p2.b0.g.t.n.z invoke(@d z zVar) {
        return zVar.k().l(Variance.INVARIANT, this.$this_createDeprecatedAnnotation.V());
    }
}
