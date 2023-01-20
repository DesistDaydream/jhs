package i.b.v3.c0;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.am;
import i.b.x1;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;

@x1
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002J3\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Li/b/v3/c0/k;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", am.av, "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public interface k<T> extends Flow<T> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Flow a(k kVar, CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    coroutineContext = EmptyCoroutineContext.INSTANCE;
                }
                if ((i3 & 2) != 0) {
                    i2 = -3;
                }
                if ((i3 & 4) != 0) {
                    bufferOverflow = BufferOverflow.SUSPEND;
                }
                return kVar.a(coroutineContext, i2, bufferOverflow);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fuse");
        }
    }

    @k.e.a.d
    Flow<T> a(@k.e.a.d CoroutineContext coroutineContext, int i2, @k.e.a.d BufferOverflow bufferOverflow);
}
