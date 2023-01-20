package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.d;
import h.k2.u.p;
import h.q2.m;
import h.q2.o;
import h.r0;
import h.t1;
import java.util.Iterator;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;

@d(c = "kotlin.sequences.SequencesKt___SequencesKt$zipWithNext$2", f = "_Sequences.kt", i = {0}, l = {2690}, m = "invokeSuspend", n = {"next"}, s = {"L$2"})
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlin/sequences/SequenceScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes4.dex */
public final class SequencesKt___SequencesKt$zipWithNext$2 extends RestrictedSuspendLambda implements p<o<? super R>, c<? super t1>, Object> {
    public final /* synthetic */ m $this_zipWithNext;
    public final /* synthetic */ p $transform;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$zipWithNext$2(m mVar, p pVar, c cVar) {
        super(2, cVar);
        this.$this_zipWithNext = mVar;
        this.$transform = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
        SequencesKt___SequencesKt$zipWithNext$2 sequencesKt___SequencesKt$zipWithNext$2 = new SequencesKt___SequencesKt$zipWithNext$2(this.$this_zipWithNext, this.$transform, cVar);
        sequencesKt___SequencesKt$zipWithNext$2.L$0 = obj;
        return sequencesKt___SequencesKt$zipWithNext$2;
    }

    @Override // h.k2.u.p
    public final Object invoke(Object obj, c<? super t1> cVar) {
        return ((SequencesKt___SequencesKt$zipWithNext$2) create(obj, cVar)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        o oVar;
        Object next;
        Iterator it;
        Object h2 = b.h();
        int i2 = this.label;
        if (i2 == 0) {
            r0.n(obj);
            o oVar2 = (o) this.L$0;
            Iterator it2 = this.$this_zipWithNext.iterator();
            if (!it2.hasNext()) {
                return t1.a;
            }
            oVar = oVar2;
            next = it2.next();
            it = it2;
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            Object obj2 = this.L$2;
            it = (Iterator) this.L$1;
            oVar = (o) this.L$0;
            r0.n(obj);
            next = obj2;
        }
        while (it.hasNext()) {
            Object next2 = it.next();
            Object invoke = this.$transform.invoke(next, next2);
            this.L$0 = oVar;
            this.L$1 = it;
            this.L$2 = next2;
            this.label = 1;
            if (oVar.d(invoke, this) == h2) {
                return h2;
            }
            next = next2;
        }
        return t1.a;
    }
}
