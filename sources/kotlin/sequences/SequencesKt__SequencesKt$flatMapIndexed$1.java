package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.a;
import h.e2.k.a.d;
import h.k2.u.l;
import h.k2.u.p;
import h.q2.m;
import h.q2.o;
import h.r0;
import h.t1;
import java.util.Iterator;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;

@d(c = "kotlin.sequences.SequencesKt__SequencesKt$flatMapIndexed$1", f = "Sequences.kt", i = {}, l = {332}, m = "invokeSuspend", n = {}, s = {})
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "C", "R", "Lkotlin/sequences/SequenceScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes4.dex */
public final class SequencesKt__SequencesKt$flatMapIndexed$1 extends RestrictedSuspendLambda implements p<o<? super R>, c<? super t1>, Object> {
    public final /* synthetic */ l $iterator;
    public final /* synthetic */ m $source;
    public final /* synthetic */ p $transform;
    public int I$0;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SequencesKt__SequencesKt$flatMapIndexed$1(m mVar, p pVar, l lVar, c cVar) {
        super(2, cVar);
        this.$source = mVar;
        this.$transform = pVar;
        this.$iterator = lVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
        SequencesKt__SequencesKt$flatMapIndexed$1 sequencesKt__SequencesKt$flatMapIndexed$1 = new SequencesKt__SequencesKt$flatMapIndexed$1(this.$source, this.$transform, this.$iterator, cVar);
        sequencesKt__SequencesKt$flatMapIndexed$1.L$0 = obj;
        return sequencesKt__SequencesKt$flatMapIndexed$1;
    }

    @Override // h.k2.u.p
    public final Object invoke(Object obj, c<? super t1> cVar) {
        return ((SequencesKt__SequencesKt$flatMapIndexed$1) create(obj, cVar)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        int i2;
        Iterator it;
        o oVar;
        Object h2 = b.h();
        int i3 = this.label;
        if (i3 == 0) {
            r0.n(obj);
            i2 = 0;
            it = this.$source.iterator();
            oVar = (o) this.L$0;
        } else if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            i2 = this.I$0;
            it = (Iterator) this.L$1;
            oVar = (o) this.L$0;
            r0.n(obj);
        }
        while (it.hasNext()) {
            Object next = it.next();
            p pVar = this.$transform;
            int i4 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            Object invoke = pVar.invoke(a.f(i2), next);
            this.L$0 = oVar;
            this.L$1 = it;
            this.I$0 = i4;
            this.label = 1;
            if (oVar.g((Iterator) this.$iterator.invoke(invoke), this) == h2) {
                return h2;
            }
            i2 = i4;
        }
        return t1.a;
    }
}
