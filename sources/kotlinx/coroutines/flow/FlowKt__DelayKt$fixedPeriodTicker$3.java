package kotlinx.coroutines.flow;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import h.e2.c;
import h.e2.k.a.d;
import h.k2.u.p;
import h.t1;
import i.b.t3.w;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@d(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$fixedPeriodTicker$3", f = "Delay.kt", i = {0, 1, 2}, l = {TypedValues.Attributes.TYPE_PATH_ROTATE, TypedValues.Attributes.TYPE_PIVOT_TARGET, 319}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$0"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Li/b/t3/w;", "Lh/t1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class FlowKt__DelayKt$fixedPeriodTicker$3 extends SuspendLambda implements p<w<? super t1>, c<? super t1>, Object> {
    public final /* synthetic */ long $delayMillis;
    public final /* synthetic */ long $initialDelayMillis;
    public Object L$0;
    public int label;
    private w p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$fixedPeriodTicker$3(long j2, long j3, c cVar) {
        super(2, cVar);
        this.$initialDelayMillis = j2;
        this.$delayMillis = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
        FlowKt__DelayKt$fixedPeriodTicker$3 flowKt__DelayKt$fixedPeriodTicker$3 = new FlowKt__DelayKt$fixedPeriodTicker$3(this.$initialDelayMillis, this.$delayMillis, cVar);
        flowKt__DelayKt$fixedPeriodTicker$3.p$ = (w) obj;
        return flowKt__DelayKt$fixedPeriodTicker$3;
    }

    @Override // h.k2.u.p
    public final Object invoke(w<? super t1> wVar, c<? super t1> cVar) {
        return ((FlowKt__DelayKt$fixedPeriodTicker$3) create(wVar, cVar)).invokeSuspend(t1.a);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005a A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0058 -> B:15:0x003d). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@k.e.a.d java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = h.e2.j.b.h()
            int r1 = r7.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L2a
            if (r1 == r4) goto L11
            if (r1 == r3) goto L21
            if (r1 != r2) goto L19
        L11:
            java.lang.Object r1 = r7.L$0
            i.b.t3.w r1 = (i.b.t3.w) r1
            h.r0.n(r8)
            goto L3c
        L19:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L21:
            java.lang.Object r1 = r7.L$0
            i.b.t3.w r1 = (i.b.t3.w) r1
            h.r0.n(r8)
            r8 = r7
            goto L4e
        L2a:
            h.r0.n(r8)
            i.b.t3.w r1 = r7.p$
            long r5 = r7.$initialDelayMillis
            r7.L$0 = r1
            r7.label = r4
            java.lang.Object r8 = i.b.w0.b(r5, r7)
            if (r8 != r0) goto L3c
            return r0
        L3c:
            r8 = r7
        L3d:
            i.b.t3.c0 r4 = r1.getChannel()
            h.t1 r5 = h.t1.a
            r8.L$0 = r1
            r8.label = r3
            java.lang.Object r4 = r4.N(r5, r8)
            if (r4 != r0) goto L4e
            return r0
        L4e:
            long r4 = r8.$delayMillis
            r8.L$0 = r1
            r8.label = r2
            java.lang.Object r4 = i.b.w0.b(r4, r8)
            if (r4 != r0) goto L3d
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$fixedPeriodTicker$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
