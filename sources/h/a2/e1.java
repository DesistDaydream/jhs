package h.a2;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.android.tpush.common.MessageKey;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a,\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0086\u0002¢\u0006\u0002\u0010\u0004\u001a4\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0006H\u0086\u0002¢\u0006\u0002\u0010\u0007\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0086\u0002\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\u0086\u0002\u001a,\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0087\b¢\u0006\u0002\u0010\u0004\u001a,\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0086\u0002¢\u0006\u0002\u0010\u0004\u001a4\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0006H\u0086\u0002¢\u0006\u0002\u0010\u0007\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0086\u0002\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\u0086\u0002\u001a,\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0087\b¢\u0006\u0002\u0010\u0004¨\u0006\r"}, d2 = {"minus", "", ExifInterface.GPS_DIRECTION_TRUE, "element", "(Ljava/util/Set;Ljava/lang/Object;)Ljava/util/Set;", MessageKey.CUSTOM_LAYOUT_ELEMENTS, "", "(Ljava/util/Set;[Ljava/lang/Object;)Ljava/util/Set;", "", "Lkotlin/sequences/Sequence;", "minusElement", "plus", "plusElement", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/collections/SetsKt")
/* loaded from: classes3.dex */
public class e1 extends d1 {
    @k.e.a.d
    public static final <T> Set<T> A(@k.e.a.d Set<? extends T> set, @k.e.a.d T[] tArr) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        y.J0(linkedHashSet, tArr);
        return linkedHashSet;
    }

    @h.g2.f
    private static final <T> Set<T> B(Set<? extends T> set, T t) {
        return y(set, t);
    }

    @k.e.a.d
    public static final <T> Set<T> C(@k.e.a.d Set<? extends T> set, @k.e.a.d Iterable<? extends T> iterable) {
        int size;
        Integer Z = u.Z(iterable);
        if (Z != null) {
            size = set.size() + Z.intValue();
        } else {
            size = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(s0.j(size));
        linkedHashSet.addAll(set);
        y.q0(linkedHashSet, iterable);
        return linkedHashSet;
    }

    @k.e.a.d
    public static final <T> Set<T> D(@k.e.a.d Set<? extends T> set, T t) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(s0.j(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(t);
        return linkedHashSet;
    }

    @k.e.a.d
    public static final <T> Set<T> E(@k.e.a.d Set<? extends T> set, @k.e.a.d h.q2.m<? extends T> mVar) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(s0.j(set.size() * 2));
        linkedHashSet.addAll(set);
        y.r0(linkedHashSet, mVar);
        return linkedHashSet;
    }

    @k.e.a.d
    public static final <T> Set<T> F(@k.e.a.d Set<? extends T> set, @k.e.a.d T[] tArr) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(s0.j(set.size() + tArr.length));
        linkedHashSet.addAll(set);
        y.s0(linkedHashSet, tArr);
        return linkedHashSet;
    }

    @h.g2.f
    private static final <T> Set<T> G(Set<? extends T> set, T t) {
        return D(set, t);
    }

    @k.e.a.d
    public static final <T> Set<T> x(@k.e.a.d Set<? extends T> set, @k.e.a.d Iterable<? extends T> iterable) {
        Collection<?> b0 = u.b0(iterable, set);
        if (b0.isEmpty()) {
            return CollectionsKt___CollectionsKt.N5(set);
        }
        if (b0 instanceof Set) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (T t : set) {
                if (!b0.contains(t)) {
                    linkedHashSet.add(t);
                }
            }
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(set);
        linkedHashSet2.removeAll(b0);
        return linkedHashSet2;
    }

    @k.e.a.d
    public static final <T> Set<T> y(@k.e.a.d Set<? extends T> set, T t) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(s0.j(set.size()));
        boolean z = false;
        for (T t2 : set) {
            boolean z2 = true;
            if (!z && h.k2.v.f0.g(t2, t)) {
                z = true;
                z2 = false;
            }
            if (z2) {
                linkedHashSet.add(t2);
            }
        }
        return linkedHashSet;
    }

    @k.e.a.d
    public static final <T> Set<T> z(@k.e.a.d Set<? extends T> set, @k.e.a.d h.q2.m<? extends T> mVar) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        y.I0(linkedHashSet, mVar);
        return linkedHashSet;
    }
}
