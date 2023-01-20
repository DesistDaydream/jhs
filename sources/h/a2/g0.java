package h.a2;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0000\u001a0\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00030\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u0005H\u0007\u001aZ\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\t\"\u0004\b\u0002\u0010\b*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\u00072\u001e\u0010\n\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\f\u0012\u0004\u0012\u0002H\b0\u000bH\u0081\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"eachCount", "", "K", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/collections/Grouping;", "mapValuesInPlace", "", "R", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "f", "Lkotlin/Function1;", "", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/collections/GroupingKt")
/* loaded from: classes3.dex */
public class g0 {
    @h.s0(version = "1.1")
    @k.e.a.d
    public static final <T, K> Map<K, Integer> a(@k.e.a.d e0<T, ? extends K> e0Var) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> b = e0Var.b();
        while (b.hasNext()) {
            K a = e0Var.a(b.next());
            Object obj = linkedHashMap.get(a);
            if (obj == null && !linkedHashMap.containsKey(a)) {
                obj = new Ref.IntRef();
            }
            Ref.IntRef intRef = (Ref.IntRef) obj;
            intRef.element++;
            linkedHashMap.put(a, intRef);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Objects.requireNonNull(entry, "null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K, R>");
            h.k2.v.t0.m(entry).setValue(Integer.valueOf(((Ref.IntRef) entry.getValue()).element));
        }
        return h.k2.v.t0.k(linkedHashMap);
    }

    @h.p0
    @h.g2.f
    private static final <K, V, R> Map<K, R> b(Map<K, V> map, h.k2.u.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Objects.requireNonNull(entry, "null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K, R>");
            h.k2.v.t0.m(entry).setValue(lVar.invoke(entry));
        }
        Objects.requireNonNull(map, "null cannot be cast to non-null type kotlin.collections.MutableMap<K, R>");
        return h.k2.v.t0.k(map);
    }
}