package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.k2.u.l;
import java.util.Map;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010&\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0003 \u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, AdvanceSetting.NETWORK_TYPE, "", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class AbstractMap$toString$1 extends Lambda implements l<Map.Entry<? extends K, ? extends V>, CharSequence> {
    public final /* synthetic */ AbstractMap this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractMap$toString$1(AbstractMap abstractMap) {
        super(1);
        this.this$0 = abstractMap;
    }

    @Override // h.k2.u.l
    @d
    public final CharSequence invoke(@d Map.Entry<? extends K, ? extends V> entry) {
        String l2;
        l2 = this.this$0.l(entry);
        return l2;
    }
}
