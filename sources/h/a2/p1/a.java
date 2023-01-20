package h.a2.p1;

import androidx.exifinterface.media.ExifInterface;
import com.caverock.androidsvg.SVG;
import h.g2.f;
import h.k2.g;
import h.k2.v.t0;
import h.s0;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;

@g(name = "CollectionsJDK8Kt")
@Metadata(d1 = {"\u0000\u001c\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0010%\n\u0002\b\u0003\u001aA\u0010\u0000\u001a\u0002H\u0001\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\u0003\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\u0006\u0010\u0006\u001a\u0002H\u0001H\u0087\b¢\u0006\u0002\u0010\u0007\u001aH\u0010\b\u001a\u00020\t\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\u0003\"\t\b\u0001\u0010\u0001¢\u0006\u0002\b\u0003*\u0012\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0006\b\u0001\u0012\u0002H\u00010\n2\u0006\u0010\u0005\u001a\u0002H\u00022\u0006\u0010\u000b\u001a\u0002H\u0001H\u0087\b¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"getOrDefault", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "K", "Lkotlin/internal/OnlyInputTypes;", "", "key", "defaultValue", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "", "", "value", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)Z", "kotlin-stdlib-jdk8"}, k = 2, mv = {1, 5, 1}, pn = "kotlin.collections")
/* loaded from: classes3.dex */
public final class a {
    /* JADX WARN: Multi-variable type inference failed */
    @f
    @s0(version = SVG.f2474i)
    private static final <K, V> V a(Map<? extends K, ? extends V> map, K k2, V v) {
        Objects.requireNonNull(map, "null cannot be cast to non-null type kotlin.collections.Map<K, V>");
        return map.getOrDefault(k2, v);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final <K, V> boolean b(Map<? extends K, ? extends V> map, K k2, V v) {
        Objects.requireNonNull(map, "null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        return t0.k(map).remove(k2, v);
    }
}
