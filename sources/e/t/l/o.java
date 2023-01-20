package e.t.l;

import androidx.exifinterface.media.ExifInterface;
import com.vector.ext.LazyData;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006¨\u0006\u0007"}, d2 = {"lazyDataOf", "Lcom/vector/ext/LazyData;", ExifInterface.GPS_DIRECTION_TRUE, "mode", "Lkotlin/LazyThreadSafetyMode;", "initializer", "Lkotlin/Function0;", "vector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class o {
    @k.e.a.d
    public static final <T> LazyData<T> a(@k.e.a.d LazyThreadSafetyMode lazyThreadSafetyMode, @k.e.a.d h.k2.u.a<? extends T> aVar) {
        return new LazyData<>(lazyThreadSafetyMode, aVar);
    }

    public static /* synthetic */ LazyData b(LazyThreadSafetyMode lazyThreadSafetyMode, h.k2.u.a aVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        }
        return a(lazyThreadSafetyMode, aVar);
    }
}
