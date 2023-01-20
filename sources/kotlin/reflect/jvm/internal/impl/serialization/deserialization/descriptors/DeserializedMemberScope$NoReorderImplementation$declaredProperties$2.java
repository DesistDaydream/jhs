package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import h.k2.u.a;
import h.p2.b0.g.t.c.j0;
import java.util.List;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;

/* loaded from: classes3.dex */
public final class DeserializedMemberScope$NoReorderImplementation$declaredProperties$2 extends Lambda implements a<List<? extends j0>> {
    public final /* synthetic */ DeserializedMemberScope.NoReorderImplementation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedMemberScope$NoReorderImplementation$declaredProperties$2(DeserializedMemberScope.NoReorderImplementation noReorderImplementation) {
        super(0);
        this.this$0 = noReorderImplementation;
    }

    @Override // h.k2.u.a
    @d
    public final List<? extends j0> invoke() {
        List<? extends j0> y;
        y = this.this$0.y();
        return y;
    }
}
