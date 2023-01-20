package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import h.k2.u.a;
import h.p2.b0.g.t.c.c;
import java.util.Collection;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class DeserializedClassDescriptor$constructors$1 extends Lambda implements a<Collection<? extends c>> {
    public final /* synthetic */ DeserializedClassDescriptor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedClassDescriptor$constructors$1(DeserializedClassDescriptor deserializedClassDescriptor) {
        super(0);
        this.this$0 = deserializedClassDescriptor;
    }

    @Override // h.k2.u.a
    @d
    public final Collection<? extends c> invoke() {
        Collection<? extends c> O0;
        O0 = this.this$0.O0();
        return O0;
    }
}
