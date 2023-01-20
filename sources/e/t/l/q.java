package e.t.l;

import androidx.exifinterface.media.ExifInterface;
import h.t1;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aZ\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000426\u0010\u0005\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00010\u0006¨\u0006\u000b"}, d2 = {"forEachKV", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "key", "value", "vector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class q {
    public static final <K, V> void a(@k.e.a.d Map<K, ? extends V> map, @k.e.a.d h.k2.u.p<? super K, ? super V, t1> pVar) {
        for (Map.Entry<K, ? extends V> entry : map.entrySet()) {
            pVar.invoke(entry.getKey(), (V) entry.getValue());
        }
    }
}
