package h;

import androidx.exifinterface.media.ExifInterface;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SafePublicationLazyImpl;
import kotlin.SynchronizedLazyImpl;
import kotlin.UnsafeLazyImpl;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a(\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004¨\u0006\t"}, d2 = {"lazy", "Lkotlin/Lazy;", ExifInterface.GPS_DIRECTION_TRUE, "initializer", "Lkotlin/Function0;", "lock", "", "mode", "Lkotlin/LazyThreadSafetyMode;", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/LazyKt")
/* loaded from: classes3.dex */
public class z {
    @k.e.a.d
    public static final <T> w<T> a(@k.e.a.e Object obj, @k.e.a.d h.k2.u.a<? extends T> aVar) {
        return new SynchronizedLazyImpl(aVar, obj);
    }

    @k.e.a.d
    public static final <T> w<T> b(@k.e.a.d LazyThreadSafetyMode lazyThreadSafetyMode, @k.e.a.d h.k2.u.a<? extends T> aVar) {
        int i2 = x.a[lazyThreadSafetyMode.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return new UnsafeLazyImpl(aVar);
                }
                throw new NoWhenBranchMatchedException();
            }
            return new SafePublicationLazyImpl(aVar);
        }
        return new SynchronizedLazyImpl(aVar, null, 2, null);
    }

    @k.e.a.d
    public static final <T> w<T> c(@k.e.a.d h.k2.u.a<? extends T> aVar) {
        return new SynchronizedLazyImpl(aVar, null, 2, null);
    }
}
