package kotlinx.coroutines.channels;

import h.e2.c;
import h.e2.k.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@d(c = "kotlinx.coroutines.channels.TickerChannelsKt", f = "TickerChannels.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3}, l = {84, 88, 94, 96}, m = "fixedPeriodTicker", n = {"delayMillis", "initialDelayMillis", "channel", "deadline", "delayMillis", "initialDelayMillis", "channel", "deadline", "delayNs", "delayMillis", "initialDelayMillis", "channel", "deadline", "delayNs", "now", "nextDelay", "adjustedDelay", "delayMillis", "initialDelayMillis", "channel", "deadline", "delayNs", "now", "nextDelay"}, s = {"J$0", "J$1", "L$0", "J$2", "J$0", "J$1", "L$0", "J$2", "J$3", "J$0", "J$1", "L$0", "J$2", "J$3", "J$4", "J$5", "J$6", "J$0", "J$1", "L$0", "J$2", "J$3", "J$4", "J$5"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0082@¢\u0006\u0004\b\t\u0010\n"}, d2 = {"", "delayMillis", "initialDelayMillis", "Li/b/t3/c0;", "Lh/t1;", "channel", "Lh/e2/c;", "continuation", "", "fixedPeriodTicker", "(JJLi/b/t3/c0;Lh/e2/c;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class TickerChannelsKt$fixedPeriodTicker$1 extends ContinuationImpl {
    public long J$0;
    public long J$1;
    public long J$2;
    public long J$3;
    public long J$4;
    public long J$5;
    public long J$6;
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;

    public TickerChannelsKt$fixedPeriodTicker$1(c cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return TickerChannelsKt.b(0L, 0L, null, this);
    }
}
