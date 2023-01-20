package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.d;
import h.k2.u.p;
import h.r0;
import h.t1;
import i.b.v3.f;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@d(c = "kotlinx.coroutines.flow.internal.ChannelFlowOperator$collectWithContextUndispatched$2", f = "ChannelFlow.kt", i = {0}, l = {164}, m = "invokeSuspend", n = {AdvanceSetting.NETWORK_TYPE}, s = {"L$0"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "Li/b/v3/f;", AdvanceSetting.NETWORK_TYPE, "Lh/t1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class ChannelFlowOperator$collectWithContextUndispatched$2 extends SuspendLambda implements p<f<? super T>, c<? super t1>, Object> {
    public Object L$0;
    public int label;
    private f p$0;
    public final /* synthetic */ ChannelFlowOperator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelFlowOperator$collectWithContextUndispatched$2(ChannelFlowOperator channelFlowOperator, c cVar) {
        super(2, cVar);
        this.this$0 = channelFlowOperator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
        ChannelFlowOperator$collectWithContextUndispatched$2 channelFlowOperator$collectWithContextUndispatched$2 = new ChannelFlowOperator$collectWithContextUndispatched$2(this.this$0, cVar);
        channelFlowOperator$collectWithContextUndispatched$2.p$0 = (f) obj;
        return channelFlowOperator$collectWithContextUndispatched$2;
    }

    @Override // h.k2.u.p
    public final Object invoke(Object obj, c<? super t1> cVar) {
        return ((ChannelFlowOperator$collectWithContextUndispatched$2) create(obj, cVar)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        Object h2 = b.h();
        int i2 = this.label;
        if (i2 == 0) {
            r0.n(obj);
            f fVar = this.p$0;
            ChannelFlowOperator channelFlowOperator = this.this$0;
            this.L$0 = fVar;
            this.label = 1;
            if (channelFlowOperator.t(fVar, this) == h2) {
                return h2;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            f fVar2 = (f) this.L$0;
            r0.n(obj);
        }
        return t1.a;
    }
}
