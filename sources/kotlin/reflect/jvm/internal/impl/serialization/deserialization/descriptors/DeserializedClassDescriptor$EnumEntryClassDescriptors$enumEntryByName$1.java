package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import h.k2.u.l;
import h.p2.b0.g.t.c.d;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.g.f;
import h.p2.b0.g.t.l.b.x.b;
import h.p2.b0.g.t.m.h;
import h.p2.b0.g.t.m.m;
import java.util.Map;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;

/* loaded from: classes3.dex */
public final class DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1 extends Lambda implements l<f, d> {
    public final /* synthetic */ DeserializedClassDescriptor.EnumEntryClassDescriptors this$0;
    public final /* synthetic */ DeserializedClassDescriptor this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1(DeserializedClassDescriptor.EnumEntryClassDescriptors enumEntryClassDescriptors, DeserializedClassDescriptor deserializedClassDescriptor) {
        super(1);
        this.this$0 = enumEntryClassDescriptors;
        this.this$1 = deserializedClassDescriptor;
    }

    @Override // h.k2.u.l
    @e
    public final d invoke(@k.e.a.d f fVar) {
        Map map;
        h hVar;
        map = this.this$0.a;
        ProtoBuf.EnumEntry enumEntry = (ProtoBuf.EnumEntry) map.get(fVar);
        if (enumEntry == null) {
            return null;
        }
        DeserializedClassDescriptor deserializedClassDescriptor = this.this$1;
        DeserializedClassDescriptor.EnumEntryClassDescriptors enumEntryClassDescriptors = this.this$0;
        m h2 = deserializedClassDescriptor.S0().h();
        hVar = enumEntryClassDescriptors.f16821c;
        return h.p2.b0.g.t.c.d1.m.H0(h2, deserializedClassDescriptor, fVar, hVar, new b(deserializedClassDescriptor.S0().h(), new DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1$1$1(deserializedClassDescriptor, enumEntry)), o0.a);
    }
}
