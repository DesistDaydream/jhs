package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import h.k2.u.a;
import h.p2.b0.g.t.g.f;
import java.util.Set;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;

/* loaded from: classes3.dex */
public final class DeserializedClassDescriptor$EnumEntryClassDescriptors$enumMemberNames$1 extends Lambda implements a<Set<? extends f>> {
    public final /* synthetic */ DeserializedClassDescriptor.EnumEntryClassDescriptors this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedClassDescriptor$EnumEntryClassDescriptors$enumMemberNames$1(DeserializedClassDescriptor.EnumEntryClassDescriptors enumEntryClassDescriptors) {
        super(0);
        this.this$0 = enumEntryClassDescriptors;
    }

    @Override // h.k2.u.a
    @d
    public final Set<? extends f> invoke() {
        Set<? extends f> e2;
        e2 = this.this$0.e();
        return e2;
    }
}
