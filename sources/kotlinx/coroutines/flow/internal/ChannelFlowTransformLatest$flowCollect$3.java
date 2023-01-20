package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.d;
import h.k2.u.p;
import h.r0;
import h.t1;
import i.b.n0;
import i.b.v3.f;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;

@d(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3", f = "Merge.kt", i = {0, 0, 0}, l = {101}, m = "invokeSuspend", n = {"$this$flowScope", "previousFlow", "$this$collect$iv"}, s = {"L$0", "L$1", "L$2"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Li/b/n0;", "Lh/t1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class ChannelFlowTransformLatest$flowCollect$3 extends SuspendLambda implements p<n0, c<? super t1>, Object> {
    public final /* synthetic */ f $collector;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    private n0 p$;
    public final /* synthetic */ ChannelFlowTransformLatest this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelFlowTransformLatest$flowCollect$3(ChannelFlowTransformLatest channelFlowTransformLatest, f fVar, c cVar) {
        super(2, cVar);
        this.this$0 = channelFlowTransformLatest;
        this.$collector = fVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
        ChannelFlowTransformLatest$flowCollect$3 channelFlowTransformLatest$flowCollect$3 = new ChannelFlowTransformLatest$flowCollect$3(this.this$0, this.$collector, cVar);
        channelFlowTransformLatest$flowCollect$3.p$ = (n0) obj;
        return channelFlowTransformLatest$flowCollect$3;
    }

    @Override // h.k2.u.p
    public final Object invoke(n0 n0Var, c<? super t1> cVar) {
        return ((ChannelFlowTransformLatest$flowCollect$3) create(n0Var, cVar)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        Object h2 = b.h();
        int i2 = this.label;
        if (i2 == 0) {
            r0.n(obj);
            n0 n0Var = this.p$;
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = null;
            Flow<S> flow = this.this$0.f16975d;
            ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1 channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1 = new ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1(this, n0Var, objectRef);
            this.L$0 = n0Var;
            this.L$1 = objectRef;
            this.L$2 = flow;
            this.label = 1;
            if (flow.e(channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1, this) == h2) {
                return h2;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            Flow flow2 = (Flow) this.L$2;
            Ref.ObjectRef objectRef2 = (Ref.ObjectRef) this.L$1;
            n0 n0Var2 = (n0) this.L$0;
            r0.n(obj);
        }
        return t1.a;
    }
}
