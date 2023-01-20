package h.a2;

import androidx.exifinterface.media.ExifInterface;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;

@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005\u001aA\u0010\u0006\u001a\u0002H\u0007\"\u0010\b\u0000\u0010\u0007*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\b\"\u0004\b\u0001\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\t\u001a\u0002H\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005¢\u0006\u0002\u0010\n\u001a\u0016\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u000e\u001a5\u0010\u000f\u001a\u00020\u0010\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u00032\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u00100\u0012H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0013\u001a5\u0010\u000f\u001a\u00020\u0014\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u00032\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u00140\u0012H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0015\u001a&\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\r0\u0017\"\u000e\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u0018*\b\u0012\u0004\u0012\u0002H\r0\u0003\u001a8\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\r0\u0017\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u00032\u001a\u0010\u0019\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\r0\u001aj\n\u0012\u0006\b\u0000\u0012\u0002H\r`\u001b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001c"}, d2 = {"filterIsInstance", "", "R", "", "klass", "Ljava/lang/Class;", "filterIsInstanceTo", "C", "", "destination", "(Ljava/lang/Iterable;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "reverse", "", ExifInterface.GPS_DIRECTION_TRUE, "", "sumOf", "Ljava/math/BigDecimal;", "selector", "Lkotlin/Function1;", "sumOfBigDecimal", "Ljava/math/BigInteger;", "sumOfBigInteger", "toSortedSet", "Ljava/util/SortedSet;", "", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes3.dex */
public class a0 extends z {
    @k.e.a.d
    public static final <R> List<R> c1(@k.e.a.d Iterable<?> iterable, @k.e.a.d Class<R> cls) {
        return (List) d1(iterable, new ArrayList(), cls);
    }

    @k.e.a.d
    public static final <C extends Collection<? super R>, R> C d1(@k.e.a.d Iterable<?> iterable, @k.e.a.d C c2, @k.e.a.d Class<R> cls) {
        for (Object obj : iterable) {
            if (cls.isInstance(obj)) {
                c2.add(obj);
            }
        }
        return c2;
    }

    public static final <T> void e1(@k.e.a.d List<T> list) {
        Collections.reverse(list);
    }

    @h.k2.g(name = "sumOfBigDecimal")
    @h.j0
    @h.s0(version = "1.4")
    @h.g2.f
    private static final <T> BigDecimal f1(Iterable<? extends T> iterable, h.k2.u.l<? super T, ? extends BigDecimal> lVar) {
        BigDecimal valueOf = BigDecimal.valueOf(0);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            valueOf = valueOf.add(lVar.invoke((T) it.next()));
        }
        return valueOf;
    }

    @h.k2.g(name = "sumOfBigInteger")
    @h.j0
    @h.s0(version = "1.4")
    @h.g2.f
    private static final <T> BigInteger g1(Iterable<? extends T> iterable, h.k2.u.l<? super T, ? extends BigInteger> lVar) {
        BigInteger valueOf = BigInteger.valueOf(0);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            valueOf = valueOf.add(lVar.invoke((T) it.next()));
        }
        return valueOf;
    }

    @k.e.a.d
    public static final <T extends Comparable<? super T>> SortedSet<T> h1(@k.e.a.d Iterable<? extends T> iterable) {
        return (SortedSet) CollectionsKt___CollectionsKt.D5(iterable, new TreeSet());
    }

    @k.e.a.d
    public static final <T> SortedSet<T> i1(@k.e.a.d Iterable<? extends T> iterable, @k.e.a.d Comparator<? super T> comparator) {
        return (SortedSet) CollectionsKt___CollectionsKt.D5(iterable, new TreeSet(comparator));
    }
}
