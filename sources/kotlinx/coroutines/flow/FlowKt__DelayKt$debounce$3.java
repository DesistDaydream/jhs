package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import h.k2.u.l;
import h.u2.d;
import i.b.w0;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "emittedItem", "", "invoke", "(Ljava/lang/Object;)J", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class FlowKt__DelayKt$debounce$3 extends Lambda implements l<T, Long> {
    public final /* synthetic */ l $timeout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$debounce$3(l lVar) {
        super(1);
        this.$timeout = lVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Long, long] */
    @Override // h.k2.u.l
    public final Long invoke(T t) {
        return w0.e(((d) this.$timeout.invoke(t)).unbox-impl());
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ Long invoke(Object obj) {
        return Long.valueOf(invoke((FlowKt__DelayKt$debounce$3) obj));
    }
}
