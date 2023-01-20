package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import h.k2.u.a;
import h.p2.b0.g.t.c.b1.c;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* loaded from: classes3.dex */
public final class DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1$1$1 extends Lambda implements a<List<? extends c>> {
    public final /* synthetic */ ProtoBuf.EnumEntry $proto;
    public final /* synthetic */ DeserializedClassDescriptor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1$1$1(DeserializedClassDescriptor deserializedClassDescriptor, ProtoBuf.EnumEntry enumEntry) {
        super(0);
        this.this$0 = deserializedClassDescriptor;
        this.$proto = enumEntry;
    }

    @Override // h.k2.u.a
    @d
    public final List<? extends c> invoke() {
        return CollectionsKt___CollectionsKt.I5(this.this$0.S0().c().d().d(this.this$0.X0(), this.$proto));
    }
}
