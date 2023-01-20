package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.k2.u.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, AdvanceSetting.NETWORK_TYPE, "", "invoke", "(Ljava/lang/Object;)J", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class FlowKt__DelayKt$debounce$2 extends Lambda implements l<T, Long> {
    public final /* synthetic */ long $timeoutMillis;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$debounce$2(long j2) {
        super(1);
        this.$timeoutMillis = j2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Long, long] */
    @Override // h.k2.u.l
    public final Long invoke(T t) {
        return this.$timeoutMillis;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ Long invoke(Object obj) {
        return Long.valueOf(invoke((FlowKt__DelayKt$debounce$2) obj));
    }
}
