package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import h.k2.u.a;
import h.p2.b0.g.t.n.e1.h;
import h.p2.b0.g.t.n.z;
import java.util.Collection;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;

/* loaded from: classes3.dex */
public final class DeserializedClassDescriptor$DeserializedClassMemberScope$refinedSupertypes$1 extends Lambda implements a<Collection<? extends z>> {
    public final /* synthetic */ DeserializedClassDescriptor.DeserializedClassMemberScope this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedClassDescriptor$DeserializedClassMemberScope$refinedSupertypes$1(DeserializedClassDescriptor.DeserializedClassMemberScope deserializedClassMemberScope) {
        super(0);
        this.this$0 = deserializedClassMemberScope;
    }

    @Override // h.k2.u.a
    @d
    public final Collection<? extends z> invoke() {
        h hVar;
        DeserializedClassDescriptor D;
        hVar = this.this$0.f16815g;
        D = this.this$0.D();
        return hVar.f(D);
    }
}
