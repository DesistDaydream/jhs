package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import h.k2.u.a;
import java.util.Iterator;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class CollectionsKt___CollectionsKt$withIndex$1 extends Lambda implements a<Iterator<? extends T>> {
    public final /* synthetic */ Iterable $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollectionsKt___CollectionsKt$withIndex$1(Iterable iterable) {
        super(0);
        this.$this_withIndex = iterable;
    }

    @Override // h.k2.u.a
    @d
    public final Iterator<T> invoke() {
        return this.$this_withIndex.iterator();
    }
}
