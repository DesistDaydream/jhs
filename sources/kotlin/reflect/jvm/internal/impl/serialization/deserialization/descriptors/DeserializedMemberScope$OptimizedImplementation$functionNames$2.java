package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import h.a2.e1;
import h.k2.u.a;
import h.p2.b0.g.t.g.f;
import java.util.Map;
import java.util.Set;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;

/* loaded from: classes3.dex */
public final class DeserializedMemberScope$OptimizedImplementation$functionNames$2 extends Lambda implements a<Set<? extends f>> {
    public final /* synthetic */ DeserializedMemberScope.OptimizedImplementation this$0;
    public final /* synthetic */ DeserializedMemberScope this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedMemberScope$OptimizedImplementation$functionNames$2(DeserializedMemberScope.OptimizedImplementation optimizedImplementation, DeserializedMemberScope deserializedMemberScope) {
        super(0);
        this.this$0 = optimizedImplementation;
        this.this$1 = deserializedMemberScope;
    }

    @Override // h.k2.u.a
    @d
    public final Set<? extends f> invoke() {
        Map map;
        map = this.this$0.a;
        return e1.C(map.keySet(), this.this$1.v());
    }
}
