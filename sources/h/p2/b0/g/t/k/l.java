package h.p2.b0.g.t.k;

import h.p2.b0.g.t.c.r;
import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* loaded from: classes3.dex */
public final class l {
    @k.e.a.d
    public static final CallableMemberDescriptor a(@k.e.a.d Collection<? extends CallableMemberDescriptor> collection) {
        Integer d2;
        collection.isEmpty();
        CallableMemberDescriptor callableMemberDescriptor = null;
        for (CallableMemberDescriptor callableMemberDescriptor2 : collection) {
            if (callableMemberDescriptor == null || ((d2 = r.d(callableMemberDescriptor.getVisibility(), callableMemberDescriptor2.getVisibility())) != null && d2.intValue() < 0)) {
                callableMemberDescriptor = callableMemberDescriptor2;
            }
        }
        return callableMemberDescriptor;
    }
}
