package kotlinx.coroutines.debug.internal;

import androidx.exifinterface.media.ExifInterface;
import h.k2.u.p;
import java.util.Map;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.debug.internal.ConcurrentWeakMap;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010'\n\u0002\b\u0003\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00028\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "k", "v", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map$Entry;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class ConcurrentWeakMap$entries$1 extends Lambda implements p<K, V, Map.Entry<K, V>> {
    public static final ConcurrentWeakMap$entries$1 INSTANCE = new ConcurrentWeakMap$entries$1();

    public ConcurrentWeakMap$entries$1() {
        super(2);
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((ConcurrentWeakMap$entries$1) obj, obj2);
    }

    @Override // h.k2.u.p
    @d
    public final Map.Entry<K, V> invoke(@d K k2, @d V v) {
        return new ConcurrentWeakMap.b(k2, v);
    }
}
