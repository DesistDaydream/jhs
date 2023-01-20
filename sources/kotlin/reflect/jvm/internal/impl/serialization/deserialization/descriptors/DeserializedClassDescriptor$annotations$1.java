package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import h.k2.u.a;
import h.p2.b0.g.t.c.b1.c;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class DeserializedClassDescriptor$annotations$1 extends Lambda implements a<List<? extends c>> {
    public final /* synthetic */ DeserializedClassDescriptor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedClassDescriptor$annotations$1(DeserializedClassDescriptor deserializedClassDescriptor) {
        super(0);
        this.this$0 = deserializedClassDescriptor;
    }

    @Override // h.k2.u.a
    @d
    public final List<? extends c> invoke() {
        return CollectionsKt___CollectionsKt.I5(this.this$0.S0().c().d().b(this.this$0.X0()));
    }
}
