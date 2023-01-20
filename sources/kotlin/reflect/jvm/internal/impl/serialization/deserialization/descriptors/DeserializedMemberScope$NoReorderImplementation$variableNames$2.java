package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import h.a2.e1;
import h.k2.u.a;
import h.p2.b0.g.t.g.f;
import h.p2.b0.g.t.i.n;
import h.p2.b0.g.t.l.b.q;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;

/* loaded from: classes3.dex */
public final class DeserializedMemberScope$NoReorderImplementation$variableNames$2 extends Lambda implements a<Set<? extends f>> {
    public final /* synthetic */ DeserializedMemberScope.NoReorderImplementation this$0;
    public final /* synthetic */ DeserializedMemberScope this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedMemberScope$NoReorderImplementation$variableNames$2(DeserializedMemberScope.NoReorderImplementation noReorderImplementation, DeserializedMemberScope deserializedMemberScope) {
        super(0);
        this.this$0 = noReorderImplementation;
        this.this$1 = deserializedMemberScope;
    }

    @Override // h.k2.u.a
    @d
    public final Set<? extends f> invoke() {
        List<n> list;
        DeserializedMemberScope.NoReorderImplementation noReorderImplementation = this.this$0;
        list = noReorderImplementation.b;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        DeserializedMemberScope deserializedMemberScope = DeserializedMemberScope.this;
        for (n nVar : list) {
            linkedHashSet.add(q.b(deserializedMemberScope.b.g(), ((ProtoBuf.Property) nVar).getName()));
        }
        return e1.C(linkedHashSet, this.this$1.w());
    }
}
