package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import h.k2.u.a;
import h.p2.b0.g.t.c.k;
import java.util.Collection;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;

/* loaded from: classes3.dex */
public final class DeserializedClassDescriptor$DeserializedClassMemberScope$allDescriptors$1 extends Lambda implements a<Collection<? extends k>> {
    public final /* synthetic */ DeserializedClassDescriptor.DeserializedClassMemberScope this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedClassDescriptor$DeserializedClassMemberScope$allDescriptors$1(DeserializedClassDescriptor.DeserializedClassMemberScope deserializedClassMemberScope) {
        super(0);
        this.this$0 = deserializedClassMemberScope;
    }

    @Override // h.k2.u.a
    @d
    public final Collection<? extends k> invoke() {
        return this.this$0.l(h.p2.b0.g.t.k.r.d.o, MemberScope.a.a(), NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
    }
}
