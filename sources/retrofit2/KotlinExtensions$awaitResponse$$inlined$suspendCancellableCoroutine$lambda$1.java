package retrofit2;

import androidx.exifinterface.media.ExifInterface;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import l.d;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "L;", AdvanceSetting.NETWORK_TYPE, "Lh/t1;", "invoke", "(L;)V", "kotlin/Throwable", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class KotlinExtensions$awaitResponse$$inlined$suspendCancellableCoroutine$lambda$1 extends Lambda implements l<Throwable, t1> {
    public final /* synthetic */ d $this_awaitResponse$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinExtensions$awaitResponse$$inlined$suspendCancellableCoroutine$lambda$1(d dVar) {
        super(1);
        this.$this_awaitResponse$inlined = dVar;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Throwable th) {
        invoke2(th);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e Throwable th) {
        this.$this_awaitResponse$inlined.cancel();
    }
}
