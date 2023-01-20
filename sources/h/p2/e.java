package h.p2;

import androidx.exifinterface.media.ExifInterface;
import h.s0;
import h.x1;
import java.util.Objects;
import kotlin.Metadata;

@h.k2.g(name = "KClasses")
@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a+\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0002\u0010\u0005\u001a-\u0010\u0006\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0007"}, d2 = {"cast", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/reflect/KClass;", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Ljava/lang/Object;", "safeCast", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class e {
    /* JADX WARN: Multi-variable type inference failed */
    @s0(version = "1.4")
    @h.g2.g
    @x1(markerClass = {h.o.class})
    @k.e.a.d
    public static final <T> T a(@k.e.a.d d<T> dVar, @k.e.a.e Object obj) {
        if (dVar.C(obj)) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type T");
            return obj;
        }
        throw new ClassCastException("Value cannot be cast to " + dVar.D());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @s0(version = "1.4")
    @h.g2.g
    @x1(markerClass = {h.o.class})
    @k.e.a.e
    public static final <T> T b(@k.e.a.d d<T> dVar, @k.e.a.e Object obj) {
        if (dVar.C(obj)) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type T");
            return obj;
        }
        return null;
    }
}
