package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import h.a2.e1;
import h.k2.u.a;
import h.p2.b0.g.t.g.f;
import java.util.Set;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;

/* loaded from: classes3.dex */
public final class DeserializedMemberScope$classifierNamesLazy$2 extends Lambda implements a<Set<? extends f>> {
    public final /* synthetic */ DeserializedMemberScope this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedMemberScope$classifierNamesLazy$2(DeserializedMemberScope deserializedMemberScope) {
        super(0);
        this.this$0 = deserializedMemberScope;
    }

    @Override // h.k2.u.a
    @e
    public final Set<? extends f> invoke() {
        DeserializedMemberScope.a aVar;
        Set<f> u = this.this$0.u();
        if (u == null) {
            return null;
        }
        Set<f> s = this.this$0.s();
        aVar = this.this$0.f16824c;
        return e1.C(e1.C(s, aVar.e()), u);
    }
}
