package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import h.k2.u.l;
import h.p2.b0.g.t.f.z.f;
import h.p2.b0.g.t.l.b.i;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* loaded from: classes3.dex */
public final class TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$1 extends Lambda implements l<ProtoBuf.Type, ProtoBuf.Type> {
    public final /* synthetic */ TypeDeserializer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$1(TypeDeserializer typeDeserializer) {
        super(1);
        this.this$0 = typeDeserializer;
    }

    @Override // h.k2.u.l
    @e
    public final ProtoBuf.Type invoke(@d ProtoBuf.Type type) {
        i iVar;
        iVar = this.this$0.a;
        return f.f(type, iVar.j());
    }
}
