package h.p2.b0.g.t.b;

import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* loaded from: classes3.dex */
public final class b {
    public static final boolean a(@k.e.a.d CompanionObjectMapping companionObjectMapping, @k.e.a.d h.p2.b0.g.t.c.d dVar) {
        if (h.p2.b0.g.t.k.c.x(dVar)) {
            Set<h.p2.b0.g.t.g.b> b = companionObjectMapping.b();
            h.p2.b0.g.t.g.b h2 = DescriptorUtilsKt.h(dVar);
            if (CollectionsKt___CollectionsKt.J1(b, h2 == null ? null : h2.g())) {
                return true;
            }
        }
        return false;
    }
}
