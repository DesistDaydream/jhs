package h.a2;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007¢\u0006\u0002\b\u0004\u001a\u001d\u0010\u0005\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\b\u001a\u001d\u0010\t\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\n¨\u0006\u000b"}, d2 = {"asReversed", "", ExifInterface.GPS_DIRECTION_TRUE, "", "asReversedMutable", "reverseElementIndex", "", "index", "reverseElementIndex$CollectionsKt__ReversedViewsKt", "reversePositionIndex", "reversePositionIndex$CollectionsKt__ReversedViewsKt", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes3.dex */
public class z extends y {
    @k.e.a.d
    public static final <T> List<T> Y0(@k.e.a.d List<? extends T> list) {
        return new z0(list);
    }

    @h.k2.g(name = "asReversedMutable")
    @k.e.a.d
    public static final <T> List<T> Z0(@k.e.a.d List<T> list) {
        return new y0(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int a1(List<?> list, int i2) {
        int G = CollectionsKt__CollectionsKt.G(list);
        if (i2 < 0 || G < i2) {
            throw new IndexOutOfBoundsException("Element index " + i2 + " must be in range [" + new h.o2.k(0, CollectionsKt__CollectionsKt.G(list)) + "].");
        }
        return CollectionsKt__CollectionsKt.G(list) - i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int b1(List<?> list, int i2) {
        int size = list.size();
        if (i2 < 0 || size < i2) {
            throw new IndexOutOfBoundsException("Position index " + i2 + " must be in range [" + new h.o2.k(0, list.size()) + "].");
        }
        return list.size() - i2;
    }
}
