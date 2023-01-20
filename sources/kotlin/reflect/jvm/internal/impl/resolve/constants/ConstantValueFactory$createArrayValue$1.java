package kotlin.reflect.jvm.internal.impl.resolve.constants;

import h.k2.u.l;
import h.p2.b0.g.t.c.z;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class ConstantValueFactory$createArrayValue$1 extends Lambda implements l<z, h.p2.b0.g.t.n.z> {
    public final /* synthetic */ h.p2.b0.g.t.n.z $type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstantValueFactory$createArrayValue$1(h.p2.b0.g.t.n.z zVar) {
        super(1);
        this.$type = zVar;
    }

    @Override // h.k2.u.l
    @d
    public final h.p2.b0.g.t.n.z invoke(@d z zVar) {
        return this.$type;
    }
}
