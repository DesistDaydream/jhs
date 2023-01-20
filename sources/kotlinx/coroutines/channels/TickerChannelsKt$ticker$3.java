package kotlinx.coroutines.channels;

import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.d;
import h.k2.u.p;
import h.r0;
import h.t1;
import i.b.t3.c0;
import i.b.t3.f0;
import i.b.t3.w;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@d(c = "kotlinx.coroutines.channels.TickerChannelsKt$ticker$3", f = "TickerChannels.kt", i = {0, 1}, l = {72, 73}, m = "invokeSuspend", n = {"$this$produce", "$this$produce"}, s = {"L$0", "L$0"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Li/b/t3/w;", "Lh/t1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class TickerChannelsKt$ticker$3 extends SuspendLambda implements p<w<? super t1>, c<? super t1>, Object> {
    public final /* synthetic */ long $delayMillis;
    public final /* synthetic */ long $initialDelayMillis;
    public final /* synthetic */ TickerMode $mode;
    public Object L$0;
    public int label;
    private w p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TickerChannelsKt$ticker$3(TickerMode tickerMode, long j2, long j3, c cVar) {
        super(2, cVar);
        this.$mode = tickerMode;
        this.$delayMillis = j2;
        this.$initialDelayMillis = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
        TickerChannelsKt$ticker$3 tickerChannelsKt$ticker$3 = new TickerChannelsKt$ticker$3(this.$mode, this.$delayMillis, this.$initialDelayMillis, cVar);
        tickerChannelsKt$ticker$3.p$ = (w) obj;
        return tickerChannelsKt$ticker$3;
    }

    @Override // h.k2.u.p
    public final Object invoke(w<? super t1> wVar, c<? super t1> cVar) {
        return ((TickerChannelsKt$ticker$3) create(wVar, cVar)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        Object h2 = b.h();
        int i2 = this.label;
        if (i2 == 0) {
            r0.n(obj);
            w wVar = this.p$;
            int i3 = f0.a[this.$mode.ordinal()];
            if (i3 == 1) {
                long j2 = this.$delayMillis;
                long j3 = this.$initialDelayMillis;
                c0 channel = wVar.getChannel();
                this.L$0 = wVar;
                this.label = 1;
                if (TickerChannelsKt.b(j2, j3, channel, this) == h2) {
                    return h2;
                }
            } else if (i3 == 2) {
                long j4 = this.$delayMillis;
                long j5 = this.$initialDelayMillis;
                c0 channel2 = wVar.getChannel();
                this.L$0 = wVar;
                this.label = 2;
                if (TickerChannelsKt.a(j4, j5, channel2, this) == h2) {
                    return h2;
                }
            }
        } else if (i2 != 1 && i2 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            w wVar2 = (w) this.L$0;
            r0.n(obj);
        }
        return t1.a;
    }
}
