package h.a2;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.android.tpush.common.MessageKey;
import h.x1;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.RandomAccess;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.sequences.SequencesKt___SequencesKt;

@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001f\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\t\u001a-\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005¢\u0006\u0002\u0010\u0006\u001a&\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\u001a&\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\u001a9\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010\r\u001a\u00020\u0001H\u0002¢\u0006\u0002\b\u000e\u001a9\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010\r\u001a\u00020\u0001H\u0002¢\u0006\u0002\b\u000e\u001a(\u0010\u0010\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\u0006\u0010\u0012\u001a\u0002H\u0002H\u0087\n¢\u0006\u0002\u0010\u0013\u001a.\u0010\u0010\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0087\n¢\u0006\u0002\u0010\u0014\u001a)\u0010\u0010\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0087\n\u001a)\u0010\u0010\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0087\n\u001a(\u0010\u0015\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\u0006\u0010\u0012\u001a\u0002H\u0002H\u0087\n¢\u0006\u0002\u0010\u0013\u001a.\u0010\u0015\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0087\n¢\u0006\u0002\u0010\u0014\u001a)\u0010\u0015\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0087\n\u001a)\u0010\u0015\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0087\n\u001a-\u0010\u0016\u001a\u00020\u0001\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\u0017*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u0006\u0010\u0012\u001a\u0002H\u0002H\u0087\b¢\u0006\u0002\u0010\u0018\u001a&\u0010\u0016\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0087\b¢\u0006\u0002\u0010\u001b\u001a-\u0010\u001c\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005¢\u0006\u0002\u0010\u0006\u001a&\u0010\u001c\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\u001a&\u0010\u001c\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\u001a.\u0010\u001c\u001a\u00020\u0001\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\u0017*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u001dH\u0087\b\u001a*\u0010\u001c\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\f\u001a*\u0010\u001c\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\f\u001a\u001d\u0010\u001e\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000fH\u0007¢\u0006\u0002\u0010\u001f\u001a\u001f\u0010 \u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000fH\u0007¢\u0006\u0002\u0010\u001f\u001a\u001d\u0010!\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000fH\u0007¢\u0006\u0002\u0010\u001f\u001a\u001f\u0010\"\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000fH\u0007¢\u0006\u0002\u0010\u001f\u001a-\u0010#\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005¢\u0006\u0002\u0010\u0006\u001a&\u0010#\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\u001a&\u0010#\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\u001a.\u0010#\u001a\u00020\u0001\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\u0017*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u001dH\u0087\b\u001a*\u0010#\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\f\u001a*\u0010#\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\f\u001a\u0015\u0010$\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0003H\u0002¢\u0006\u0002\b%¨\u0006&"}, d2 = {"addAll", "", ExifInterface.GPS_DIRECTION_TRUE, "", MessageKey.CUSTOM_LAYOUT_ELEMENTS, "", "(Ljava/util/Collection;[Ljava/lang/Object;)Z", "", "Lkotlin/sequences/Sequence;", "filterInPlace", "", "predicate", "Lkotlin/Function1;", "predicateResultToRemove", "filterInPlace$CollectionsKt__MutableCollectionsKt", "", "minusAssign", "", "element", "(Ljava/util/Collection;Ljava/lang/Object;)V", "(Ljava/util/Collection;[Ljava/lang/Object;)V", "plusAssign", "remove", "Lkotlin/internal/OnlyInputTypes;", "(Ljava/util/Collection;Ljava/lang/Object;)Z", "index", "", "(Ljava/util/List;I)Ljava/lang/Object;", "removeAll", "", "removeFirst", "(Ljava/util/List;)Ljava/lang/Object;", "removeFirstOrNull", "removeLast", "removeLastOrNull", "retainAll", "retainNothing", "retainNothing$CollectionsKt__MutableCollectionsKt", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes3.dex */
public class y extends x {
    /* JADX WARN: Multi-variable type inference failed */
    @h.g2.f
    private static final <T> void A0(Collection<? super T> collection, T t) {
        collection.add(t);
    }

    @h.g2.f
    private static final <T> void B0(Collection<? super T> collection, h.q2.m<? extends T> mVar) {
        r0(collection, mVar);
    }

    @h.g2.f
    private static final <T> void C0(Collection<? super T> collection, T[] tArr) {
        s0(collection, tArr);
    }

    @h.g2.f
    @h.i(level = DeprecationLevel.ERROR, message = "Use removeAt(index) instead.", replaceWith = @h.q0(expression = "removeAt(index)", imports = {}))
    private static final <T> T D0(List<T> list, int i2) {
        return list.remove(i2);
    }

    @h.g2.f
    private static final <T> boolean E0(Collection<? extends T> collection, T t) {
        Objects.requireNonNull(collection, "null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        return h.k2.v.t0.a(collection).remove(t);
    }

    public static final <T> boolean F0(@k.e.a.d Iterable<? extends T> iterable, @k.e.a.d h.k2.u.l<? super T, Boolean> lVar) {
        return t0(iterable, lVar, true);
    }

    public static final <T> boolean G0(@k.e.a.d Collection<? super T> collection, @k.e.a.d Iterable<? extends T> iterable) {
        return h.k2.v.t0.a(collection).removeAll(u.b0(iterable, collection));
    }

    @h.g2.f
    private static final <T> boolean H0(Collection<? extends T> collection, Collection<? extends T> collection2) {
        Objects.requireNonNull(collection, "null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        return h.k2.v.t0.a(collection).removeAll(collection2);
    }

    public static final <T> boolean I0(@k.e.a.d Collection<? super T> collection, @k.e.a.d h.q2.m<? extends T> mVar) {
        HashSet U2 = SequencesKt___SequencesKt.U2(mVar);
        return (U2.isEmpty() ^ true) && collection.removeAll(U2);
    }

    public static final <T> boolean J0(@k.e.a.d Collection<? super T> collection, @k.e.a.d T[] tArr) {
        return ((tArr.length == 0) ^ true) && collection.removeAll(ArraysKt___ArraysKt.Ux(tArr));
    }

    public static final <T> boolean K0(@k.e.a.d List<T> list, @k.e.a.d h.k2.u.l<? super T, Boolean> lVar) {
        return u0(list, lVar, true);
    }

    @x1(markerClass = {h.o.class})
    @h.s0(version = "1.4")
    public static final <T> T L0(@k.e.a.d List<T> list) {
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(0);
    }

    @x1(markerClass = {h.o.class})
    @k.e.a.e
    @h.s0(version = "1.4")
    public static final <T> T M0(@k.e.a.d List<T> list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(0);
    }

    @x1(markerClass = {h.o.class})
    @h.s0(version = "1.4")
    public static final <T> T N0(@k.e.a.d List<T> list) {
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(CollectionsKt__CollectionsKt.G(list));
    }

    @x1(markerClass = {h.o.class})
    @k.e.a.e
    @h.s0(version = "1.4")
    public static final <T> T O0(@k.e.a.d List<T> list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(CollectionsKt__CollectionsKt.G(list));
    }

    public static final <T> boolean P0(@k.e.a.d Iterable<? extends T> iterable, @k.e.a.d h.k2.u.l<? super T, Boolean> lVar) {
        return t0(iterable, lVar, false);
    }

    public static final <T> boolean Q0(@k.e.a.d Collection<? super T> collection, @k.e.a.d Iterable<? extends T> iterable) {
        return h.k2.v.t0.a(collection).retainAll(u.b0(iterable, collection));
    }

    @h.g2.f
    private static final <T> boolean R0(Collection<? extends T> collection, Collection<? extends T> collection2) {
        Objects.requireNonNull(collection, "null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        return h.k2.v.t0.a(collection).retainAll(collection2);
    }

    public static final <T> boolean S0(@k.e.a.d Collection<? super T> collection, @k.e.a.d h.q2.m<? extends T> mVar) {
        HashSet U2 = SequencesKt___SequencesKt.U2(mVar);
        if (!U2.isEmpty()) {
            return collection.retainAll(U2);
        }
        return V0(collection);
    }

    public static final <T> boolean T0(@k.e.a.d Collection<? super T> collection, @k.e.a.d T[] tArr) {
        if (!(tArr.length == 0)) {
            return collection.retainAll(ArraysKt___ArraysKt.Ux(tArr));
        }
        return V0(collection);
    }

    public static final <T> boolean U0(@k.e.a.d List<T> list, @k.e.a.d h.k2.u.l<? super T, Boolean> lVar) {
        return u0(list, lVar, false);
    }

    private static final boolean V0(Collection<?> collection) {
        boolean z = !collection.isEmpty();
        collection.clear();
        return z;
    }

    public static final <T> boolean q0(@k.e.a.d Collection<? super T> collection, @k.e.a.d Iterable<? extends T> iterable) {
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean z = false;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (collection.add((T) it.next())) {
                z = true;
            }
        }
        return z;
    }

    public static final <T> boolean r0(@k.e.a.d Collection<? super T> collection, @k.e.a.d h.q2.m<? extends T> mVar) {
        Iterator<? extends T> it = mVar.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.add((T) it.next())) {
                z = true;
            }
        }
        return z;
    }

    public static final <T> boolean s0(@k.e.a.d Collection<? super T> collection, @k.e.a.d T[] tArr) {
        return collection.addAll(n.t(tArr));
    }

    private static final <T> boolean t0(Iterable<? extends T> iterable, h.k2.u.l<? super T, Boolean> lVar, boolean z) {
        Iterator<? extends T> it = iterable.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (lVar.invoke((T) it.next()).booleanValue() == z) {
                it.remove();
                z2 = true;
            }
        }
        return z2;
    }

    private static final <T> boolean u0(List<T> list, h.k2.u.l<? super T, Boolean> lVar, boolean z) {
        int i2;
        if (!(list instanceof RandomAccess)) {
            Objects.requireNonNull(list, "null cannot be cast to non-null type kotlin.collections.MutableIterable<T>");
            return t0(h.k2.v.t0.c(list), lVar, z);
        }
        int G = CollectionsKt__CollectionsKt.G(list);
        if (G >= 0) {
            int i3 = 0;
            i2 = 0;
            while (true) {
                T t = list.get(i3);
                if (lVar.invoke(t).booleanValue() != z) {
                    if (i2 != i3) {
                        list.set(i2, t);
                    }
                    i2++;
                }
                if (i3 == G) {
                    break;
                }
                i3++;
            }
        } else {
            i2 = 0;
        }
        if (i2 >= list.size()) {
            return false;
        }
        int G2 = CollectionsKt__CollectionsKt.G(list);
        if (G2 < i2) {
            return true;
        }
        while (true) {
            list.remove(G2);
            if (G2 == i2) {
                return true;
            }
            G2--;
        }
    }

    @h.g2.f
    private static final <T> void v0(Collection<? super T> collection, Iterable<? extends T> iterable) {
        G0(collection, iterable);
    }

    @h.g2.f
    private static final <T> void w0(Collection<? super T> collection, T t) {
        collection.remove(t);
    }

    @h.g2.f
    private static final <T> void x0(Collection<? super T> collection, h.q2.m<? extends T> mVar) {
        I0(collection, mVar);
    }

    @h.g2.f
    private static final <T> void y0(Collection<? super T> collection, T[] tArr) {
        J0(collection, tArr);
    }

    @h.g2.f
    private static final <T> void z0(Collection<? super T> collection, Iterable<? extends T> iterable) {
        q0(collection, iterable);
    }
}
