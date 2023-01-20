package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import h.k2.u.a;
import h.p2.b0.g.t.c.b1.c;
import h.p2.b0.g.t.i.n;
import h.p2.b0.g.t.l.b.i;
import h.p2.b0.g.t.l.b.s;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class MemberDeserializer$getAnnotations$1 extends Lambda implements a<List<? extends c>> {
    public final /* synthetic */ AnnotatedCallableKind $kind;
    public final /* synthetic */ n $proto;
    public final /* synthetic */ MemberDeserializer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberDeserializer$getAnnotations$1(MemberDeserializer memberDeserializer, n nVar, AnnotatedCallableKind annotatedCallableKind) {
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
        List<? extends c> I5;
        MemberDeserializer memberDeserializer = this.this$0;
        iVar = memberDeserializer.a;
        c2 = memberDeserializer.c(iVar.e());
        if (c2 == null) {
            I5 = null;
        } else {
            MemberDeserializer memberDeserializer2 = this.this$0;
            n nVar = this.$proto;
            AnnotatedCallableKind annotatedCallableKind = this.$kind;
            iVar2 = memberDeserializer2.a;
            I5 = CollectionsKt___CollectionsKt.I5(iVar2.c().d().e(c2, nVar, annotatedCallableKind));
        }
        return I5 != null ? I5 : CollectionsKt__CollectionsKt.E();
    }
}
