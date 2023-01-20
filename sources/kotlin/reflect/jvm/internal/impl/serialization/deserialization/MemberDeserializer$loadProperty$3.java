package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import h.k2.u.a;
import h.p2.b0.g.t.k.n.g;
import h.p2.b0.g.t.l.b.i;
import h.p2.b0.g.t.l.b.s;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* loaded from: classes3.dex */
public final class MemberDeserializer$loadProperty$3 extends Lambda implements a<g<?>> {
    public final /* synthetic */ h.p2.b0.g.t.l.b.x.g $property;
    public final /* synthetic */ ProtoBuf.Property $proto;
    public final /* synthetic */ MemberDeserializer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberDeserializer$loadProperty$3(MemberDeserializer memberDeserializer, ProtoBuf.Property property, h.p2.b0.g.t.l.b.x.g gVar) {
        super(0);
        this.this$0 = memberDeserializer;
        this.$proto = property;
        this.$property = gVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @e
    public final g<?> invoke() {
        i iVar;
        s c2;
        i iVar2;
        MemberDeserializer memberDeserializer = this.this$0;
        iVar = memberDeserializer.a;
        c2 = memberDeserializer.c(iVar.e());
        iVar2 = this.this$0.a;
        return iVar2.c().d().g(c2, this.$proto, this.$property.getReturnType());
    }
}
