package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.b2.b;
import h.k2.u.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "K", "", AdvanceSetting.NETWORK_TYPE, "invoke", "(Ljava/lang/Object;)I"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class CollectionsKt__CollectionsKt$binarySearchBy$1 extends Lambda implements l<T, Integer> {
    public final /* synthetic */ Comparable $key;
    public final /* synthetic */ l $selector;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollectionsKt__CollectionsKt$binarySearchBy$1(l lVar, Comparable comparable) {
        super(1);
        this.$selector = lVar;
        this.$key = comparable;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Type inference failed for: r2v3, types: [int, java.lang.Integer] */
    @Override // h.k2.u.l
    public final Integer invoke(T t) {
        return b.g((Comparable) this.$selector.invoke(t), this.$key);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ Integer invoke(Object obj) {
        return Integer.valueOf(invoke((CollectionsKt__CollectionsKt$binarySearchBy$1) obj));
    }
}
