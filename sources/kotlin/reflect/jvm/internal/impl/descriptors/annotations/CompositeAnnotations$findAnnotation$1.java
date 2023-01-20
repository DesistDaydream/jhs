package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import h.k2.u.l;
import h.p2.b0.g.t.c.b1.c;
import h.p2.b0.g.t.c.b1.e;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class CompositeAnnotations$findAnnotation$1 extends Lambda implements l<e, c> {
    public final /* synthetic */ h.p2.b0.g.t.g.c $fqName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CompositeAnnotations$findAnnotation$1(h.p2.b0.g.t.g.c cVar) {
        super(1);
        this.$fqName = cVar;
    }

    @Override // h.k2.u.l
    @k.e.a.e
    public final c invoke(@d e eVar) {
        return eVar.c(this.$fqName);
    }
}
