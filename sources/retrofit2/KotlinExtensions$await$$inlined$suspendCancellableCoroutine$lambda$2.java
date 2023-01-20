package retrofit2;

import androidx.exifinterface.media.ExifInterface;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import l.d;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "", AdvanceSetting.NETWORK_TYPE, "Lh/t1;", "invoke", "(Ljava/lang/Throwable;)V", "retrofit2/KotlinExtensions$await$4$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2 extends Lambda implements l<Throwable, t1> {
    public final /* synthetic */ d $this_await$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2(d dVar) {
        super(1);
        this.$this_await$inlined = dVar;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Throwable th) {
        invoke2(th);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e Throwable th) {
        this.$this_await$inlined.cancel();
    }
}
