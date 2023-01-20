package kotlinx.coroutines.channels;

import com.umeng.analytics.pro.am;
import h.t1;
import i.b.b1;
import i.b.q2;
import i.b.t3.y;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a;\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\t\u0010\n\u001a1\u0010\r\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u000bH\u0082@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a1\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u000bH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"", "delayMillis", "initialDelayMillis", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlinx/coroutines/channels/TickerMode;", "mode", "Li/b/t3/y;", "Lh/t1;", "c", "(JJLkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/TickerMode;)Li/b/t3/y;", "Li/b/t3/c0;", "channel", "b", "(JJLi/b/t3/c0;Lh/e2/c;)Ljava/lang/Object;", am.av, "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class TickerChannelsKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0091 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x008f -> B:14:0x0036). Please submit an issue!!! */
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object a(long r8, long r10, @k.e.a.d i.b.t3.c0<? super h.t1> r12, @k.e.a.d h.e2.c<? super h.t1> r13) {
        /*
            boolean r0 = r13 instanceof kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1
            if (r0 == 0) goto L13
            r0 = r13
            kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1 r0 = (kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1 r0 = new kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = h.e2.j.b.h()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L5c
            if (r2 == r5) goto L4f
            if (r2 == r4) goto L43
            if (r2 != r3) goto L3b
            java.lang.Object r8 = r0.L$0
            i.b.t3.c0 r8 = (i.b.t3.c0) r8
            long r9 = r0.J$1
            long r11 = r0.J$0
            h.r0.n(r13)
        L36:
            r6 = r11
            r12 = r8
            r10 = r9
            r8 = r6
            goto L6e
        L3b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L43:
            java.lang.Object r8 = r0.L$0
            i.b.t3.c0 r8 = (i.b.t3.c0) r8
            long r9 = r0.J$1
            long r11 = r0.J$0
            h.r0.n(r13)
            goto L83
        L4f:
            java.lang.Object r8 = r0.L$0
            r12 = r8
            i.b.t3.c0 r12 = (i.b.t3.c0) r12
            long r10 = r0.J$1
            long r8 = r0.J$0
            h.r0.n(r13)
            goto L6e
        L5c:
            h.r0.n(r13)
            r0.J$0 = r8
            r0.J$1 = r10
            r0.L$0 = r12
            r0.label = r5
            java.lang.Object r13 = i.b.w0.b(r10, r0)
            if (r13 != r1) goto L6e
            return r1
        L6e:
            h.t1 r13 = h.t1.a
            r0.J$0 = r8
            r0.J$1 = r10
            r0.L$0 = r12
            r0.label = r4
            java.lang.Object r13 = r12.N(r13, r0)
            if (r13 != r1) goto L7f
            return r1
        L7f:
            r6 = r8
            r8 = r12
            r9 = r10
            r11 = r6
        L83:
            r0.J$0 = r11
            r0.J$1 = r9
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r13 = i.b.w0.b(r11, r0)
            if (r13 != r1) goto L36
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.TickerChannelsKt.a(long, long, i.b.t3.c0, h.e2.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00dd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0172 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0173  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0143 -> B:49:0x0146). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x0173 -> B:50:0x0147). Please submit an issue!!! */
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object b(long r21, long r23, @k.e.a.d i.b.t3.c0<? super h.t1> r25, @k.e.a.d h.e2.c<? super h.t1> r26) {
        /*
            Method dump skipped, instructions count: 382
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.TickerChannelsKt.b(long, long, i.b.t3.c0, h.e2.c):java.lang.Object");
    }

    @q2
    @d
    public static final y<t1> c(long j2, long j3, @d CoroutineContext coroutineContext, @d TickerMode tickerMode) {
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("Expected non-negative delay, but has " + j2 + " ms").toString());
        }
        if (j3 >= 0) {
            return ProduceKt.c(i.b.t1.a, b1.g().plus(coroutineContext), 0, new TickerChannelsKt$ticker$3(tickerMode, j2, j3, null));
        }
        throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j3 + " ms").toString());
    }

    public static /* synthetic */ y d(long j2, long j3, CoroutineContext coroutineContext, TickerMode tickerMode, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j3 = j2;
        }
        if ((i2 & 4) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i2 & 8) != 0) {
            tickerMode = TickerMode.FIXED_PERIOD;
        }
        return c(j2, j3, coroutineContext, tickerMode);
    }
}
