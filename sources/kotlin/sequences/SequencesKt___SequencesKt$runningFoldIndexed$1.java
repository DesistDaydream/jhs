package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import h.e2.c;
import h.e2.k.a.d;
import h.k2.u.p;
import h.k2.u.q;
import h.q2.m;
import h.q2.o;
import h.t1;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;

@d(c = "kotlin.sequences.SequencesKt___SequencesKt$runningFoldIndexed$1", f = "_Sequences.kt", i = {0}, l = {2143, 2148}, m = "invokeSuspend", n = {"$this$sequence"}, s = {"L$0"})
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlin/sequences/SequenceScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes4.dex */
public final class SequencesKt___SequencesKt$runningFoldIndexed$1 extends RestrictedSuspendLambda implements p<o<? super R>, c<? super t1>, Object> {
    public final /* synthetic */ Object $initial;
    public final /* synthetic */ q $operation;
    public final /* synthetic */ m $this_runningFoldIndexed;
    public int I$0;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$runningFoldIndexed$1(m mVar, Object obj, q qVar, c cVar) {
        super(2, cVar);
        this.$this_runningFoldIndexed = mVar;
        this.$initial = obj;
        this.$operation = qVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
        SequencesKt___SequencesKt$runningFoldIndexed$1 sequencesKt___SequencesKt$runningFoldIndexed$1 = new SequencesKt___SequencesKt$runningFoldIndexed$1(this.$this_runningFoldIndexed, this.$initial, this.$operation, cVar);
        sequencesKt___SequencesKt$runningFoldIndexed$1.L$0 = obj;
        return sequencesKt___SequencesKt$runningFoldIndexed$1;
    }

    @Override // h.k2.u.p
    public final Object invoke(Object obj, c<? super t1> cVar) {
        return ((SequencesKt___SequencesKt$runningFoldIndexed$1) create(obj, cVar)).invokeSuspend(t1.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0058  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@k.e.a.d java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = h.e2.j.b.h()
            int r1 = r9.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L30
            if (r1 == r3) goto L28
            if (r1 != r2) goto L20
            int r1 = r9.I$0
            java.lang.Object r3 = r9.L$2
            java.util.Iterator r3 = (java.util.Iterator) r3
            java.lang.Object r4 = r9.L$1
            java.lang.Object r5 = r9.L$0
            h.q2.o r5 = (h.q2.o) r5
            h.r0.n(r10)
            r10 = r1
            r1 = r4
            goto L51
        L20:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L28:
            java.lang.Object r1 = r9.L$0
            h.q2.o r1 = (h.q2.o) r1
            h.r0.n(r10)
            goto L45
        L30:
            h.r0.n(r10)
            java.lang.Object r10 = r9.L$0
            r1 = r10
            h.q2.o r1 = (h.q2.o) r1
            java.lang.Object r10 = r9.$initial
            r9.L$0 = r1
            r9.label = r3
            java.lang.Object r10 = r1.d(r10, r9)
            if (r10 != r0) goto L45
            return r0
        L45:
            r10 = 0
            java.lang.Object r3 = r9.$initial
            h.q2.m r4 = r9.$this_runningFoldIndexed
            java.util.Iterator r4 = r4.iterator()
            r5 = r1
            r1 = r3
            r3 = r4
        L51:
            r4 = r9
        L52:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L81
            java.lang.Object r6 = r3.next()
            h.k2.u.q r7 = r4.$operation
            int r8 = r10 + 1
            if (r10 >= 0) goto L65
            kotlin.collections.CollectionsKt__CollectionsKt.W()
        L65:
            java.lang.Integer r10 = h.e2.k.a.a.f(r10)
            java.lang.Object r10 = r7.invoke(r10, r1, r6)
            r4.L$0 = r5
            r4.L$1 = r10
            r4.L$2 = r3
            r4.I$0 = r8
            r4.label = r2
            java.lang.Object r1 = r5.d(r10, r4)
            if (r1 != r0) goto L7e
            return r0
        L7e:
            r1 = r10
            r10 = r8
            goto L52
        L81:
            h.t1 r10 = h.t1.a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt$runningFoldIndexed$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
