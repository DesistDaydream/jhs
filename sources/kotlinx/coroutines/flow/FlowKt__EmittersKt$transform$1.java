package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.d;
import h.k2.u.p;
import h.k2.u.q;
import h.k2.v.c0;
import h.r0;
import h.t1;
import i.b.v3.f;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@d(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1", f = "Emitters.kt", i = {0, 0}, l = {215}, m = "invokeSuspend", n = {"$this$flow", "$this$collect$iv"}, s = {"L$0", "L$1"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Li/b/v3/f;", "Lh/t1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class FlowKt__EmittersKt$transform$1 extends SuspendLambda implements p<f<? super R>, c<? super t1>, Object> {
    public final /* synthetic */ Flow $this_transform;
    public final /* synthetic */ q $transform;
    public Object L$0;
    public Object L$1;
    public int label;
    private f p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__EmittersKt$transform$1(Flow flow, q qVar, c cVar) {
        super(2, cVar);
        this.$this_transform = flow;
        this.$transform = qVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
        FlowKt__EmittersKt$transform$1 flowKt__EmittersKt$transform$1 = new FlowKt__EmittersKt$transform$1(this.$this_transform, this.$transform, cVar);
        flowKt__EmittersKt$transform$1.p$ = (f) obj;
        return flowKt__EmittersKt$transform$1;
    }

    @Override // h.k2.u.p
    public final Object invoke(Object obj, c<? super t1> cVar) {
        return ((FlowKt__EmittersKt$transform$1) create(obj, cVar)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        Object h2 = b.h();
        int i2 = this.label;
        if (i2 == 0) {
            r0.n(obj);
            f fVar = this.p$;
            Flow flow = this.$this_transform;
            FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1 flowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1 = new FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1(this, fVar);
            this.L$0 = fVar;
            this.L$1 = flow;
            this.label = 1;
            if (flow.e(flowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1, this) == h2) {
                return h2;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            Flow flow2 = (Flow) this.L$1;
            f fVar2 = (f) this.L$0;
            r0.n(obj);
        }
        return t1.a;
    }

    @e
    public final Object invokeSuspend$$forInline(@k.e.a.d Object obj) {
        f fVar = this.p$;
        Flow flow = this.$this_transform;
        FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1 flowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1 = new FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1(this, fVar);
        c0.e(0);
        flow.e(flowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1, this);
        c0.e(2);
        c0.e(1);
        return t1.a;
    }
}
