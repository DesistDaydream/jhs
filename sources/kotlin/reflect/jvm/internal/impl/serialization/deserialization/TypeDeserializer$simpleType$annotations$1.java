package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import h.k2.u.a;
import h.p2.b0.g.t.c.b1.c;
import h.p2.b0.g.t.k.n.g;
import h.p2.b0.g.t.l.b.i;
import java.util.List;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* loaded from: classes3.dex */
public final class TypeDeserializer$simpleType$annotations$1 extends Lambda implements a<List<? extends c>> {
    public final /* synthetic */ ProtoBuf.Type $proto;
    public final /* synthetic */ TypeDeserializer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TypeDeserializer$simpleType$annotations$1(TypeDeserializer typeDeserializer, ProtoBuf.Type type) {
        super(0);
        this.this$0 = typeDeserializer;
        this.$proto = type;
    }

    @Override // h.k2.u.a
    @d
    public final List<? extends c> invoke() {
        i iVar;
        i iVar2;
        iVar = this.this$0.a;
        h.p2.b0.g.t.l.b.a<c, g<?>> d2 = iVar.c().d();
        ProtoBuf.Type type = this.$proto;
        iVar2 = this.this$0.a;
        return d2.c(type, iVar2.g());
    }
}
