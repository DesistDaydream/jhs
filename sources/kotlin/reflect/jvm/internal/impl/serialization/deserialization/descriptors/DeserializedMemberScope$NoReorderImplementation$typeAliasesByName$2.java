package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import h.a2.u;
import h.k2.u.a;
import h.o2.q;
import h.p2.b0.g.t.c.s0;
import h.p2.b0.g.t.g.f;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;

/* loaded from: classes3.dex */
public final class DeserializedMemberScope$NoReorderImplementation$typeAliasesByName$2 extends Lambda implements a<Map<f, ? extends s0>> {
    public final /* synthetic */ DeserializedMemberScope.NoReorderImplementation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedMemberScope$NoReorderImplementation$typeAliasesByName$2(DeserializedMemberScope.NoReorderImplementation noReorderImplementation) {
        super(0);
        this.this$0 = noReorderImplementation;
    }

    @Override // h.k2.u.a
    @d
    public final Map<f, ? extends s0> invoke() {
        List C;
        C = this.this$0.C();
        LinkedHashMap linkedHashMap = new LinkedHashMap(q.n(h.a2.s0.j(u.Y(C, 10)), 16));
        for (Object obj : C) {
            linkedHashMap.put(((s0) obj).getName(), obj);
        }
        return linkedHashMap;
    }
}
