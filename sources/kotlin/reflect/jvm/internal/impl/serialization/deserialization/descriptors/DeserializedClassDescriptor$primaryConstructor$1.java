package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import h.k2.u.a;
import h.p2.b0.g.t.c.c;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class DeserializedClassDescriptor$primaryConstructor$1 extends Lambda implements a<c> {
    public final /* synthetic */ DeserializedClassDescriptor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedClassDescriptor$primaryConstructor$1(DeserializedClassDescriptor deserializedClassDescriptor) {
        super(0);
        this.this$0 = deserializedClassDescriptor;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @e
    public final c invoke() {
        c P0;
        P0 = this.this$0.P0();
        return P0;
    }
}
