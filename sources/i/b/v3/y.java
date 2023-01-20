package i.b.v3;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.am;
import i.b.q0;
import i.b.w3.i0;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowImpl;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a!\u0010\b\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00050\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\b\u0010\t\u001a=\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0011\u0010\u0012\"\u001c\u0010\u0017\u001a\u00020\u00138\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u0012\u0004\b\u0015\u0010\u0016\"\u001c\u0010\u001a\u001a\u00020\u00138\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0014\u0012\u0004\b\u0019\u0010\u0016¨\u0006\u001b"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "value", "Li/b/v3/l;", am.av, "(Ljava/lang/Object;)Li/b/v3/l;", "", "delta", "Lh/t1;", "g", "(Li/b/v3/l;I)V", "Li/b/v3/x;", "Lkotlin/coroutines/CoroutineContext;", "context", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/Flow;", e.j.a.b.c.f.f10128d, "(Li/b/v3/x;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "Li/b/w3/i0;", "Li/b/w3/i0;", "getNONE$annotations", "()V", "NONE", "b", "getPENDING$annotations", "PENDING", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class y {
    private static final i0 a = new i0("NONE");
    private static final i0 b = new i0("PENDING");

    @k.e.a.d
    public static final <T> l<T> a(T t) {
        if (t == null) {
            t = (T) i.b.v3.c0.n.a;
        }
        return new StateFlowImpl(t);
    }

    @k.e.a.d
    public static final <T> Flow<T> d(@k.e.a.d x<? extends T> xVar, @k.e.a.d CoroutineContext coroutineContext, int i2, @k.e.a.d BufferOverflow bufferOverflow) {
        if (q0.b()) {
            if (!(i2 != -1)) {
                throw new AssertionError();
            }
        }
        return (((i2 < 0 || 1 < i2) && i2 != -2) || bufferOverflow != BufferOverflow.DROP_OLDEST) ? r.e(xVar, coroutineContext, i2, bufferOverflow) : xVar;
    }

    private static /* synthetic */ void e() {
    }

    private static /* synthetic */ void f() {
    }

    public static final void g(@k.e.a.d l<Integer> lVar, int i2) {
        int intValue;
        do {
            intValue = lVar.getValue().intValue();
        } while (!lVar.f(Integer.valueOf(intValue), Integer.valueOf(intValue + i2)));
    }
}
