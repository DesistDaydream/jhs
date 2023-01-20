package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import h.e2.c;
import h.e2.j.b;
import h.k2.u.p;
import h.k2.u.q;
import h.r0;
import h.t1;
import i.b.n0;
import i.b.v3.f;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Li/b/n0;", "Lh/t1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/ChannelFlowTransformLatest$flowCollect$3$1$2", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1$lambda$1 extends SuspendLambda implements p<n0, c<? super t1>, Object> {
    public final /* synthetic */ Object $value;
    public Object L$0;
    public int label;
    private n0 p$;
    public final /* synthetic */ ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1$lambda$1(Object obj, c cVar, ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1 channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1) {
        super(2, cVar);
        this.$value = obj;
        this.this$0 = channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @d
    public final c<t1> create(@e Object obj, @d c<?> cVar) {
        ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1$lambda$1 channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1$lambda$1 = new ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1$lambda$1(this.$value, cVar, this.this$0);
        channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1$lambda$1.p$ = (n0) obj;
        return channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1$lambda$1;
    }

    @Override // h.k2.u.p
    public final Object invoke(n0 n0Var, c<? super t1> cVar) {
        return ((ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1$lambda$1) create(n0Var, cVar)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@d Object obj) {
        q qVar;
        Object h2 = b.h();
        int i2 = this.label;
        if (i2 == 0) {
            r0.n(obj);
            n0 n0Var = this.p$;
            qVar = this.this$0.a.this$0.f16976e;
            f fVar = this.this$0.a.$collector;
            Object obj2 = this.$value;
            this.L$0 = n0Var;
            this.label = 1;
            if (qVar.invoke(fVar, obj2, this) == h2) {
                return h2;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            n0 n0Var2 = (n0) this.L$0;
            r0.n(obj);
        }
        return t1.a;
    }
}
