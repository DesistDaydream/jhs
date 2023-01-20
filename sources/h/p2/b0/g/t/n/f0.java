package h.p2.b0.g.t.n;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.Iterator;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;

/* loaded from: classes3.dex */
public abstract class f0 extends c1 implements h.p2.b0.g.t.n.g1.i, h.p2.b0.g.t.n.g1.k {
    public f0() {
        super(null);
    }

    @k.e.a.d
    public abstract f0 P0(boolean z);

    @k.e.a.d
    public abstract f0 Q0(@k.e.a.d h.p2.b0.g.t.c.b1.e eVar);

    @k.e.a.d
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<h.p2.b0.g.t.c.b1.c> it = getAnnotations().iterator();
        while (it.hasNext()) {
            h.t2.r.j0(sb, "[", DescriptorRenderer.u(DescriptorRenderer.f16753j, it.next(), null, 2, null), "] ");
        }
        sb.append(I0());
        if (!H0().isEmpty()) {
            CollectionsKt___CollectionsKt.X2(H0(), sb, ", ", SimpleComparison.LESS_THAN_OPERATION, SimpleComparison.GREATER_THAN_OPERATION, 0, null, null, 112, null);
        }
        if (J0()) {
            sb.append("?");
        }
        return sb.toString();
    }
}
