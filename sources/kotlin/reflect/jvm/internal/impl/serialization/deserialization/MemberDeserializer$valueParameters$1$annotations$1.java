package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import h.k2.u.a;
import h.p2.b0.g.t.c.b1.c;
import h.p2.b0.g.t.i.n;
import h.p2.b0.g.t.l.b.i;
import h.p2.b0.g.t.l.b.s;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* loaded from: classes3.dex */
public final class MemberDeserializer$valueParameters$1$annotations$1 extends Lambda implements a<List<? extends c>> {
    public final /* synthetic */ n $callable;
    public final /* synthetic */ s $containerOfCallable;
    public final /* synthetic */ int $i;
    public final /* synthetic */ AnnotatedCallableKind $kind;
    public final /* synthetic */ ProtoBuf.ValueParameter $proto;
    public final /* synthetic */ MemberDeserializer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberDeserializer$valueParameters$1$annotations$1(MemberDeserializer memberDeserializer, s sVar, n nVar, AnnotatedCallableKind annotatedCallableKind, int i2, ProtoBuf.ValueParameter valueParameter) {
        super(0);
        this.this$0 = memberDeserializer;
        this.$containerOfCallable = sVar;
        this.$callable = nVar;
        this.$kind = annotatedCallableKind;
        this.$i = i2;
        this.$proto = valueParameter;
    }

    @Override // h.k2.u.a
    @d
    public final List<? extends c> invoke() {
        i iVar;
        iVar = this.this$0.a;
        return CollectionsKt___CollectionsKt.I5(iVar.c().d().a(this.$containerOfCallable, this.$callable, this.$kind, this.$i, this.$proto));
    }
}
