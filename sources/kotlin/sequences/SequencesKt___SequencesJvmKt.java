package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import h.g2.f;
import h.j0;
import h.k2.g;
import h.k2.u.l;
import h.q2.m;
import h.s0;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001aA\u0010\u0005\u001a\u0002H\u0006\"\u0010\b\u0000\u0010\u0006*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0007\"\u0004\b\u0001\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\b\u001a\u0002H\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004¢\u0006\u0002\u0010\t\u001a5\u0010\n\u001a\u00020\u000b\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\u000b0\u000eH\u0087\bø\u0001\u0000¢\u0006\u0002\b\u000f\u001a5\u0010\n\u001a\u00020\u0010\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\u00100\u000eH\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0011\u001a&\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\f0\u0013\"\u000e\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u0014*\b\u0012\u0004\u0012\u0002H\f0\u0001\u001a8\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\f0\u0013\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00012\u001a\u0010\u0015\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\f0\u0016j\n\u0012\u0006\b\u0000\u0012\u0002H\f`\u0017\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, d2 = {"filterIsInstance", "Lkotlin/sequences/Sequence;", "R", "klass", "Ljava/lang/Class;", "filterIsInstanceTo", "C", "", "destination", "(Lkotlin/sequences/Sequence;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "sumOf", "Ljava/math/BigDecimal;", ExifInterface.GPS_DIRECTION_TRUE, "selector", "Lkotlin/Function1;", "sumOfBigDecimal", "Ljava/math/BigInteger;", "sumOfBigInteger", "toSortedSet", "Ljava/util/SortedSet;", "", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/sequences/SequencesKt")
/* loaded from: classes4.dex */
public class SequencesKt___SequencesJvmKt extends SequencesKt__SequencesKt {
    @g(name = "sumOfBigInteger")
    @j0
    @s0(version = "1.4")
    @f
    private static final <T> BigInteger A(m<? extends T> mVar, l<? super T, ? extends BigInteger> lVar) {
        BigInteger valueOf = BigInteger.valueOf(0);
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            valueOf = valueOf.add(lVar.invoke((T) it.next()));
        }
        return valueOf;
    }

    @d
    public static final <T extends Comparable<? super T>> SortedSet<T> B(@d m<? extends T> mVar) {
        return (SortedSet) SequencesKt___SequencesKt.T2(mVar, new TreeSet());
    }

    @d
    public static final <T> SortedSet<T> C(@d m<? extends T> mVar, @d Comparator<? super T> comparator) {
        return (SortedSet) SequencesKt___SequencesKt.T2(mVar, new TreeSet(comparator));
    }

    @d
    public static final <R> m<R> x(@d m<?> mVar, @d Class<R> cls) {
        m<R> i0 = SequencesKt___SequencesKt.i0(mVar, new SequencesKt___SequencesJvmKt$filterIsInstance$1(cls));
        Objects.requireNonNull(i0, "null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
        return i0;
    }

    @d
    public static final <C extends Collection<? super R>, R> C y(@d m<?> mVar, @d C c2, @d Class<R> cls) {
        for (Object obj : mVar) {
            if (cls.isInstance(obj)) {
                c2.add(obj);
            }
        }
        return c2;
    }

    @g(name = "sumOfBigDecimal")
    @j0
    @s0(version = "1.4")
    @f
    private static final <T> BigDecimal z(m<? extends T> mVar, l<? super T, ? extends BigDecimal> lVar) {
        BigDecimal valueOf = BigDecimal.valueOf(0);
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            valueOf = valueOf.add(lVar.invoke((T) it.next()));
        }
        return valueOf;
    }
}
