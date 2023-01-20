package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import com.meizu.cloud.pushsdk.constants.PushConstants;
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

@d(c = "kotlin.sequences.SequencesKt___SequencesKt$runningReduceIndexed$1", f = "_Sequences.kt", i = {0, 0, 0}, l = {PushConstants.DELAY_NOTIFICATION, 2206}, m = "invokeSuspend", n = {"$this$sequence", "iterator", "accumulator"}, s = {"L$0", "L$1", "L$2"})
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u0002H\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/SequenceScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes4.dex */
public final class SequencesKt___SequencesKt$runningReduceIndexed$1 extends RestrictedSuspendLambda implements p<o<? super S>, c<? super t1>, Object> {
    public final /* synthetic */ q $operation;
    public final /* synthetic */ m $this_runningReduceIndexed;
    public int I$0;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$runningReduceIndexed$1(m mVar, q qVar, c cVar) {
        super(2, cVar);
        this.$this_runningReduceIndexed = mVar;
        this.$operation = qVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
        SequencesKt___SequencesKt$runningReduceIndexed$1 sequencesKt___SequencesKt$runningReduceIndexed$1 = new SequencesKt___SequencesKt$runningReduceIndexed$1(this.$this_runningReduceIndexed, this.$operation, cVar);
        sequencesKt___SequencesKt$runningReduceIndexed$1.L$0 = obj;
        return sequencesKt___SequencesKt$runningReduceIndexed$1;
    }

    @Override // h.k2.u.p
    public final Object invoke(Object obj, c<? super t1> cVar) {
        return ((SequencesKt___SequencesKt$runningReduceIndexed$1) create(obj, cVar)).invokeSuspend(t1.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@k.e.a.d java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = h.e2.j.b.h()
            int r1 = r10.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L38
            if (r1 == r3) goto L2a
            if (r1 != r2) goto L22
            int r1 = r10.I$0
            java.lang.Object r3 = r10.L$2
            java.lang.Object r4 = r10.L$1
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r5 = r10.L$0
            h.q2.o r5 = (h.q2.o) r5
            h.r0.n(r11)
            r11 = r10
            r9 = r3
            r3 = r1
            r1 = r9
            goto L60
        L22:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L2a:
            java.lang.Object r1 = r10.L$2
            java.lang.Object r4 = r10.L$1
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r5 = r10.L$0
            h.q2.o r5 = (h.q2.o) r5
            h.r0.n(r11)
            goto L5f
        L38:
            h.r0.n(r11)
            java.lang.Object r11 = r10.L$0
            r5 = r11
            h.q2.o r5 = (h.q2.o) r5
            h.q2.m r11 = r10.$this_runningReduceIndexed
            java.util.Iterator r4 = r11.iterator()
            boolean r11 = r4.hasNext()
            if (r11 == 0) goto L8f
            java.lang.Object r1 = r4.next()
            r10.L$0 = r5
            r10.L$1 = r4
            r10.L$2 = r1
            r10.label = r3
            java.lang.Object r11 = r5.d(r1, r10)
            if (r11 != r0) goto L5f
            return r0
        L5f:
            r11 = r10
        L60:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L8f
            h.k2.u.q r6 = r11.$operation
            int r7 = r3 + 1
            if (r3 >= 0) goto L6f
            kotlin.collections.CollectionsKt__CollectionsKt.W()
        L6f:
            java.lang.Integer r3 = h.e2.k.a.a.f(r3)
            java.lang.Object r8 = r4.next()
            java.lang.Object r3 = r6.invoke(r3, r1, r8)
            r11.L$0 = r5
            r11.L$1 = r4
            r11.L$2 = r3
            r11.I$0 = r7
            r11.label = r2
            java.lang.Object r1 = r5.d(r3, r11)
            if (r1 != r0) goto L8c
            return r0
        L8c:
            r1 = r3
            r3 = r7
            goto L60
        L8f:
            h.t1 r11 = h.t1.a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt$runningReduceIndexed$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
