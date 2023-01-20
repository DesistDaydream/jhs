package h.p2.b0.g;

import androidx.exifinterface.media.ExifInterface;
import h.k2.v.f0;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.KClassImpl;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0005\u001a\u00020\u0006H\u0000\u001a&\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\b\b\u0000\u0010\t*\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000bH\u0000\"*\u0010\u0000\u001a\u001e\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00040\u00040\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"K_CLASS_CACHE", "Lkotlin/reflect/jvm/internal/pcollections/HashPMap;", "", "kotlin.jvm.PlatformType", "", "clearKClassCache", "", "getOrCreateKotlinClass", "Lkotlin/reflect/jvm/internal/KClassImpl;", ExifInterface.GPS_DIRECTION_TRUE, "jClass", "Ljava/lang/Class;", "kotlin-reflection"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class e {
    private static h.p2.b0.g.u.b<String, Object> a = h.p2.b0.g.u.b.c();

    public static final void a() {
        a = h.p2.b0.g.u.b.c();
    }

    @k.e.a.d
    public static final <T> KClassImpl<T> b(@k.e.a.d Class<T> cls) {
        String name = cls.getName();
        Object d2 = a.d(name);
        if (d2 instanceof WeakReference) {
            KClassImpl<T> kClassImpl = (KClassImpl) ((WeakReference) d2).get();
            if (f0.g(kClassImpl != null ? kClassImpl.d() : null, cls)) {
                return kClassImpl;
            }
        } else if (d2 != null) {
            for (WeakReference weakReference : (WeakReference[]) d2) {
                KClassImpl<T> kClassImpl2 = (KClassImpl) weakReference.get();
                if (f0.g(kClassImpl2 != null ? kClassImpl2.d() : null, cls)) {
                    return kClassImpl2;
                }
            }
            int length = ((Object[]) d2).length;
            WeakReference[] weakReferenceArr = new WeakReference[length + 1];
            System.arraycopy(d2, 0, weakReferenceArr, 0, length);
            KClassImpl<T> kClassImpl3 = new KClassImpl<>(cls);
            weakReferenceArr[length] = new WeakReference(kClassImpl3);
            a = a.h(name, weakReferenceArr);
            return kClassImpl3;
        }
        KClassImpl<T> kClassImpl4 = new KClassImpl<>(cls);
        a = a.h(name, new WeakReference(kClassImpl4));
        return kClassImpl4;
    }
}
