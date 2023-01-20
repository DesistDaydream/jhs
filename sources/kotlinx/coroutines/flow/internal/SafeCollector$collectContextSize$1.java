package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import h.k2.u.p;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "count", "Lkotlin/coroutines/CoroutineContext$a;", "<anonymous parameter 1>", "invoke", "(ILkotlin/coroutines/CoroutineContext$a;)I", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class SafeCollector$collectContextSize$1 extends Lambda implements p<Integer, CoroutineContext.a, Integer> {
    public static final SafeCollector$collectContextSize$1 INSTANCE = new SafeCollector$collectContextSize$1();

    public SafeCollector$collectContextSize$1() {
        super(2);
    }

    public final int invoke(int i2, @d CoroutineContext.a aVar) {
        return i2 + 1;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ Integer invoke(Integer num, CoroutineContext.a aVar) {
        return Integer.valueOf(invoke(num.intValue(), aVar));
    }
}
