package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import h.k2.u.a;
import h.p2.b0.g.t.c.d;
import java.util.Collection;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class DeserializedClassDescriptor$sealedSubclasses$1 extends Lambda implements a<Collection<? extends d>> {
    public final /* synthetic */ DeserializedClassDescriptor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedClassDescriptor$sealedSubclasses$1(DeserializedClassDescriptor deserializedClassDescriptor) {
        super(0);
        this.this$0 = deserializedClassDescriptor;
    }

    @Override // h.k2.u.a
    @k.e.a.d
    public final Collection<? extends d> invoke() {
        Collection<? extends d> R0;
        R0 = this.this$0.R0();
        return R0;
    }
}
