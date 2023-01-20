package i.b.t3;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.am;
import h.t1;
import kotlin.Metadata;
import kotlinx.coroutines.channels.BufferOverflow;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aE\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\n\u001a%\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {ExifInterface.LONGITUDE_EAST, "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlin/Function1;", "Lh/t1;", "onUndeliveredElement", "Li/b/t3/l;", "b", "(ILkotlinx/coroutines/channels/BufferOverflow;Lh/k2/u/l;)Li/b/t3/l;", am.av, "(I)Li/b/t3/l;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class n {
    @k.e.a.d
    public static final <E> l<E> b(int i2, @k.e.a.d BufferOverflow bufferOverflow, @k.e.a.e h.k2.u.l<? super E, t1> lVar) {
        if (i2 == -2) {
            return new h(bufferOverflow == BufferOverflow.SUSPEND ? l.z0.a() : 1, bufferOverflow, lVar);
        } else if (i2 == -1) {
            if ((bufferOverflow != BufferOverflow.SUSPEND ? 0 : 1) != 0) {
                return new r(lVar);
            }
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        } else if (i2 == 0) {
            if (bufferOverflow == BufferOverflow.SUSPEND) {
                return new a0(lVar);
            }
            return new h(1, bufferOverflow, lVar);
        } else if (i2 != Integer.MAX_VALUE) {
            if (i2 == 1 && bufferOverflow == BufferOverflow.DROP_OLDEST) {
                return new r(lVar);
            }
            return new h(i2, bufferOverflow, lVar);
        } else {
            return new u(lVar);
        }
    }

    public static /* synthetic */ l c(int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        return d(i2, null, null, 6, null);
    }

    public static /* synthetic */ l d(int i2, BufferOverflow bufferOverflow, h.k2.u.l lVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        if ((i3 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        if ((i3 & 4) != 0) {
            lVar = null;
        }
        return b(i2, bufferOverflow, lVar);
    }
}
