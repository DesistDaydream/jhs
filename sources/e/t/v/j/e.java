package e.t.v.j;

import androidx.exifinterface.media.ExifInterface;
import h.k2.v.f0;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\u001a3\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0002*\u0010\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"findKeyByValue", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "value", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", "vector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class e {
    @k.e.a.e
    public static final <K, V> K a(@k.e.a.e Map<K, ? extends V> map, V v) {
        if (map != null && map.containsValue(v)) {
            for (Map.Entry<K, ? extends V> entry : map.entrySet()) {
                if (f0.g(entry.getValue(), v)) {
                    return entry.getKey();
                }
            }
            return null;
        }
        return null;
    }
}
