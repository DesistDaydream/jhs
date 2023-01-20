package i.b.v3.c0;

import androidx.exifinterface.media.ExifInterface;
import com.qiniu.android.collect.ReportItem;
import h.k2.v.t0;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.UndispatchedContextCollector;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a%\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a-\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\t\u001a]\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00028\u00012\b\b\u0002\u0010\u000e\u001a\u00020\r2\"\u0010\u0011\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000fH\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "b", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Li/b/v3/f;", "Lkotlin/coroutines/CoroutineContext;", "emitContext", com.huawei.hms.push.e.a, "(Li/b/v3/f;Lkotlin/coroutines/CoroutineContext;)Li/b/v3/f;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "newContext", "value", "", "countOrElement", "Lkotlin/Function2;", "Lh/e2/c;", ReportItem.LogTypeBlock, "c", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Ljava/lang/Object;Lh/k2/u/p;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class e {
    @k.e.a.d
    public static final <T> ChannelFlow<T> b(@k.e.a.d Flow<? extends T> flow) {
        ChannelFlow<T> channelFlow = (ChannelFlow) (!(flow instanceof ChannelFlow) ? null : flow);
        return channelFlow != null ? channelFlow : new f(flow, null, 0, null, 14, null);
    }

    @k.e.a.e
    public static final <T, V> Object c(@k.e.a.d CoroutineContext coroutineContext, V v, @k.e.a.d Object obj, @k.e.a.d h.k2.u.p<? super V, ? super h.e2.c<? super T>, ? extends Object> pVar, @k.e.a.d h.e2.c<? super T> cVar) {
        Object c2 = ThreadContextKt.c(coroutineContext, obj);
        try {
            p pVar2 = new p(cVar, coroutineContext);
            if (pVar != null) {
                Object invoke = ((h.k2.u.p) t0.q(pVar, 2)).invoke(v, pVar2);
                ThreadContextKt.a(coroutineContext, c2);
                if (invoke == h.e2.j.b.h()) {
                    h.e2.k.a.f.c(cVar);
                }
                return invoke;
            }
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th) {
            ThreadContextKt.a(coroutineContext, c2);
            throw th;
        }
    }

    public static /* synthetic */ Object d(CoroutineContext coroutineContext, Object obj, Object obj2, h.k2.u.p pVar, h.e2.c cVar, int i2, Object obj3) {
        if ((i2 & 4) != 0) {
            obj2 = ThreadContextKt.b(coroutineContext);
        }
        return c(coroutineContext, obj, obj2, pVar, cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> i.b.v3.f<T> e(i.b.v3.f<? super T> fVar, CoroutineContext coroutineContext) {
        return ((fVar instanceof o) || (fVar instanceof m)) ? fVar : new UndispatchedContextCollector(fVar, coroutineContext);
    }
}
