package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import h.k2.u.a;
import h.p2.b0.g.t.c.b1.c;
import h.p2.b0.g.t.k.n.g;
import h.p2.b0.g.t.l.b.i;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* loaded from: classes3.dex */
public final class DeserializedTypeParameterDescriptor$annotations$1 extends Lambda implements a<List<? extends c>> {
    public final /* synthetic */ DeserializedTypeParameterDescriptor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedTypeParameterDescriptor$annotations$1(DeserializedTypeParameterDescriptor deserializedTypeParameterDescriptor) {
        super(0);
        this.this$0 = deserializedTypeParameterDescriptor;
    }

    @Override // h.k2.u.a
    @d
    public final List<? extends c> invoke() {
        i iVar;
        i iVar2;
        iVar = this.this$0.f16846k;
        h.p2.b0.g.t.l.b.a<c, g<?>> d2 = iVar.c().d();
        ProtoBuf.TypeParameter K0 = this.this$0.K0();
        iVar2 = this.this$0.f16846k;
        return CollectionsKt___CollectionsKt.I5(d2.f(K0, iVar2.g()));
    }
}
