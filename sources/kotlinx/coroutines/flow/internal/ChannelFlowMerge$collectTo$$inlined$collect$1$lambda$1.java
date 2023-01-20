package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import h.e2.c;
import h.e2.j.b;
import h.k2.u.p;
import h.r0;
import h.t1;
import i.b.n0;
import i.b.v3.c0.o;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.flow.Flow;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Li/b/n0;", "Lh/t1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/ChannelFlowMerge$collectTo$2$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class ChannelFlowMerge$collectTo$$inlined$collect$1$lambda$1 extends SuspendLambda implements p<n0, c<? super t1>, Object> {
    public final /* synthetic */ Flow $inner;
    public Object L$0;
    public int label;
    private n0 p$;
    public final /* synthetic */ ChannelFlowMerge$collectTo$$inlined$collect$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelFlowMerge$collectTo$$inlined$collect$1$lambda$1(Flow flow, c cVar, ChannelFlowMerge$collectTo$$inlined$collect$1 channelFlowMerge$collectTo$$inlined$collect$1) {
        super(2, cVar);
        this.$inner = flow;
        this.this$0 = channelFlowMerge$collectTo$$inlined$collect$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @d
    public final c<t1> create(@e Object obj, @d c<?> cVar) {
        ChannelFlowMerge$collectTo$$inlined$collect$1$lambda$1 channelFlowMerge$collectTo$$inlined$collect$1$lambda$1 = new ChannelFlowMerge$collectTo$$inlined$collect$1$lambda$1(this.$inner, cVar, this.this$0);
        channelFlowMerge$collectTo$$inlined$collect$1$lambda$1.p$ = (n0) obj;
        return channelFlowMerge$collectTo$$inlined$collect$1$lambda$1;
    }

    @Override // h.k2.u.p
    public final Object invoke(n0 n0Var, c<? super t1> cVar) {
        return ((ChannelFlowMerge$collectTo$$inlined$collect$1$lambda$1) create(n0Var, cVar)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@d Object obj) {
        Object h2 = b.h();
        int i2 = this.label;
        try {
            if (i2 == 0) {
                r0.n(obj);
                n0 n0Var = this.p$;
                Flow flow = this.$inner;
                o oVar = this.this$0.f16974d;
                this.L$0 = n0Var;
                this.label = 1;
                if (flow.e(oVar, this) == h2) {
                    return h2;
                }
            } else if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                n0 n0Var2 = (n0) this.L$0;
                r0.n(obj);
            }
            this.this$0.b.release();
            return t1.a;
        } catch (Throwable th) {
            this.this$0.b.release();
            throw th;
        }
    }
}
