package i.b.v3;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.am;
import i.b.w3.i0;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.SharedFlowImpl;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a7\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a%\u0010\r\u001a\u0004\u0018\u00010\n*\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a-\u0010\u0011\u001a\u00020\u0010*\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a=\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0018\u0010\u0019\"\u001c\u0010\u001e\u001a\u00020\u001a8\u0000@\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u0012\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "replay", "extraBufferCapacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Li/b/v3/k;", am.av, "(IILkotlinx/coroutines/channels/BufferOverflow;)Li/b/v3/k;", "", "", "", "index", "f", "([Ljava/lang/Object;J)Ljava/lang/Object;", "item", "Lh/t1;", "h", "([Ljava/lang/Object;JLjava/lang/Object;)V", "Li/b/v3/p;", "Lkotlin/coroutines/CoroutineContext;", "context", "capacity", "Lkotlinx/coroutines/flow/Flow;", com.huawei.hms.push.e.a, "(Li/b/v3/p;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "Li/b/w3/i0;", "Li/b/w3/i0;", "getNO_VALUE$annotations", "()V", "NO_VALUE", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class r {
    @h.k2.d
    @k.e.a.d
    public static final i0 a = new i0("NO_VALUE");

    @k.e.a.d
    public static final <T> k<T> a(int i2, int i3, @k.e.a.d BufferOverflow bufferOverflow) {
        boolean z = true;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("replay cannot be negative, but was " + i2).toString());
        }
        if (i3 >= 0) {
            if (i2 <= 0 && i3 <= 0 && bufferOverflow != BufferOverflow.SUSPEND) {
                z = false;
            }
            if (z) {
                int i4 = i3 + i2;
                if (i4 < 0) {
                    i4 = Integer.MAX_VALUE;
                }
                return new SharedFlowImpl(i2, i4, bufferOverflow);
            }
            throw new IllegalArgumentException(("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy " + bufferOverflow).toString());
        }
        throw new IllegalArgumentException(("extraBufferCapacity cannot be negative, but was " + i3).toString());
    }

    public static /* synthetic */ k b(int i2, int i3, BufferOverflow bufferOverflow, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = 0;
        }
        if ((i4 & 4) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return a(i2, i3, bufferOverflow);
    }

    @k.e.a.d
    public static final <T> Flow<T> e(@k.e.a.d p<? extends T> pVar, @k.e.a.d CoroutineContext coroutineContext, int i2, @k.e.a.d BufferOverflow bufferOverflow) {
        return ((i2 == 0 || i2 == -3) && bufferOverflow == BufferOverflow.SUSPEND) ? pVar : new i.b.v3.c0.f(pVar, coroutineContext, i2, bufferOverflow);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object f(Object[] objArr, long j2) {
        return objArr[(objArr.length - 1) & ((int) j2)];
    }

    public static /* synthetic */ void g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Object[] objArr, long j2, Object obj) {
        objArr[(objArr.length - 1) & ((int) j2)] = obj;
    }
}
