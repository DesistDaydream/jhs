package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import h.k2.u.a;
import h.p2.b0.g.t.c.b1.c;
import h.p2.b0.g.t.i.n;
import h.p2.b0.g.t.l.b.i;
import h.p2.b0.g.t.l.b.s;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class MemberDeserializer$getReceiverParameterAnnotations$1 extends Lambda implements a<List<? extends c>> {
    public final /* synthetic */ AnnotatedCallableKind $kind;
    public final /* synthetic */ n $proto;
    public final /* synthetic */ MemberDeserializer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberDeserializer$getReceiverParameterAnnotations$1(MemberDeserializer memberDeserializer, n nVar, AnnotatedCallableKind annotatedCallableKind) {
        super(0);
        this.this$0 = memberDeserializer;
        this.$proto = nVar;
        this.$kind = annotatedCallableKind;
    }

    @Override // h.k2.u.a
    @d
    public final List<? extends c> invoke() {
        i iVar;
        s c2;
        i iVar2;
        List<c> i2;
        MemberDeserializer memberDeserializer = this.this$0;
        iVar = memberDeserializer.a;
        c2 = memberDeserializer.c(iVar.e());
        if (c2 == null) {
            i2 = null;
        } else {
            MemberDeserializer memberDeserializer2 = this.this$0;
            n nVar = this.$proto;
            AnnotatedCallableKind annotatedCallableKind = this.$kind;
            iVar2 = memberDeserializer2.a;
            i2 = iVar2.c().d().i(c2, nVar, annotatedCallableKind);
        }
        return i2 != null ? i2 : CollectionsKt__CollectionsKt.E();
    }
}
