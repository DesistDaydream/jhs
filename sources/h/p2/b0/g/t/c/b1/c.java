package h.p2.b0.g.t.c.b1;

import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.n.s;
import h.p2.b0.g.t.n.z;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* loaded from: classes3.dex */
public interface c {

    /* loaded from: classes3.dex */
    public static final class a {
        @k.e.a.e
        public static h.p2.b0.g.t.g.c a(@k.e.a.d c cVar) {
            h.p2.b0.g.t.c.d f2 = DescriptorUtilsKt.f(cVar);
            if (f2 == null) {
                return null;
            }
            if (s.r(f2)) {
                f2 = null;
            }
            if (f2 == null) {
                return null;
            }
            return DescriptorUtilsKt.e(f2);
        }
    }

    @k.e.a.d
    Map<h.p2.b0.g.t.g.f, h.p2.b0.g.t.k.n.g<?>> a();

    @k.e.a.e
    h.p2.b0.g.t.g.c e();

    @k.e.a.d
    o0 getSource();

    @k.e.a.d
    z getType();
}
