package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.d;
import h.k2.u.p;
import h.k2.u.q;
import h.r0;
import h.t1;
import i.b.v3.c0.i;
import i.b.v3.f;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.flow.internal.AbortFlowException;

@d(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1", f = "Limit.kt", i = {0, 0, 0}, l = {154}, m = "invokeSuspend", n = {"$this$flow", "$this$collectWhile$iv", "collector$iv"}, s = {"L$0", "L$1", "L$2"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Li/b/v3/f;", "Lh/t1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class FlowKt__LimitKt$transformWhile$1 extends SuspendLambda implements p<f<? super R>, c<? super t1>, Object> {
    public final /* synthetic */ Flow $this_transformWhile;
    public final /* synthetic */ q $transform;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    private f p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__LimitKt$transformWhile$1(Flow flow, q qVar, c cVar) {
        super(2, cVar);
        this.$this_transformWhile = flow;
        this.$transform = qVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
        FlowKt__LimitKt$transformWhile$1 flowKt__LimitKt$transformWhile$1 = new FlowKt__LimitKt$transformWhile$1(this.$this_transformWhile, this.$transform, cVar);
        flowKt__LimitKt$transformWhile$1.p$ = (f) obj;
        return flowKt__LimitKt$transformWhile$1;
    }

    @Override // h.k2.u.p
    public final Object invoke(Object obj, c<? super t1> cVar) {
        return ((FlowKt__LimitKt$transformWhile$1) create(obj, cVar)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1;
        Object h2 = b.h();
        int i2 = this.label;
        if (i2 == 0) {
            r0.n(obj);
            f fVar = this.p$;
            Flow flow = this.$this_transformWhile;
            FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$12 = new FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1(this, fVar);
            try {
                this.L$0 = fVar;
                this.L$1 = flow;
                this.L$2 = flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$12;
                this.label = 1;
                if (flow.e(flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$12, this) == h2) {
                    return h2;
                }
            } catch (AbortFlowException e2) {
                e = e2;
                flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 = flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$12;
                i.b(e, flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1);
                return t1.a;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 = (FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1) this.L$2;
            Flow flow2 = (Flow) this.L$1;
            f fVar2 = (f) this.L$0;
            try {
                r0.n(obj);
            } catch (AbortFlowException e3) {
                e = e3;
                i.b(e, flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1);
                return t1.a;
            }
        }
        return t1.a;
    }
}
