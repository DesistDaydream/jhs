package h.a2;

import androidx.exifinterface.media.ExifInterface;
import com.caverock.androidsvg.SVG;
import h.t1;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0001\u001a?\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u001d\u0010\b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000bH\u0081\bø\u0001\u0000\u001a7\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u001d\u0010\b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000bH\u0081\bø\u0001\u0000\u001a\u0011\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0081\b\u001a\u0011\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0081\b\u001a\"\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00112\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0081\b¢\u0006\u0002\u0010\u0015\u001a4\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0011\"\u0004\b\u0000\u0010\u00162\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0011H\u0081\b¢\u0006\u0002\u0010\u0018\u001a\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\"\u0004\b\u0000\u0010\u0002H\u0001\u001a\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0001\u001a\u001f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0001\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u001b\u001a\u0002H\u0016¢\u0006\u0002\u0010\u001c\u001a1\u0010\u001d\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00120\u0011\"\u0004\b\u0000\u0010\u0016*\n\u0012\u0006\b\u0001\u0012\u0002H\u00160\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0000¢\u0006\u0002\u0010 \u001a\u001e\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0001\"\u0004\b\u0000\u0010\u0016*\b\u0012\u0004\u0012\u0002H\u00160\"H\u0007\u001a&\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0001\"\u0004\b\u0000\u0010\u0016*\b\u0012\u0004\u0012\u0002H\u00160\"2\u0006\u0010#\u001a\u00020$H\u0007\u001a\u001f\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0001\"\u0004\b\u0000\u0010\u0016*\b\u0012\u0004\u0012\u0002H\u00160&H\u0087\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006'"}, d2 = {"build", "", ExifInterface.LONGITUDE_EAST, "builder", "", "buildListInternal", "capacity", "", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "checkCountOverflow", "count", "checkIndexOverflow", "index", "copyToArrayImpl", "", "", "collection", "", "(Ljava/util/Collection;)[Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, "array", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "createListBuilder", "listOf", "element", "(Ljava/lang/Object;)Ljava/util/List;", "copyToArrayOfAny", "isVarargs", "", "([Ljava/lang/Object;Z)[Ljava/lang/Object;", "shuffled", "", "random", "Ljava/util/Random;", "toList", "Ljava/util/Enumeration;", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes3.dex */
public class t {
    @h.p0
    @h.o
    @h.s0(version = "1.3")
    @k.e.a.d
    public static final <E> List<E> a(@k.e.a.d List<E> list) {
        return ((h.a2.o1.b) list).s();
    }

    @h.p0
    @h.o
    @h.s0(version = "1.3")
    @h.g2.f
    private static final <E> List<E> b(int i2, h.k2.u.l<? super List<E>, t1> lVar) {
        List j2 = j(i2);
        lVar.invoke(j2);
        return a(j2);
    }

    @h.p0
    @h.o
    @h.s0(version = "1.3")
    @h.g2.f
    private static final <E> List<E> c(h.k2.u.l<? super List<E>, t1> lVar) {
        List i2 = i();
        lVar.invoke(i2);
        return a(i2);
    }

    @h.p0
    @h.g2.f
    @h.s0(version = "1.3")
    private static final int d(int i2) {
        if (i2 < 0) {
            if (h.g2.l.a(1, 3, 0)) {
                CollectionsKt__CollectionsKt.V();
            } else {
                throw new ArithmeticException("Count overflow has happened.");
            }
        }
        return i2;
    }

    @h.p0
    @h.g2.f
    @h.s0(version = "1.3")
    private static final int e(int i2) {
        if (i2 < 0) {
            if (h.g2.l.a(1, 3, 0)) {
                CollectionsKt__CollectionsKt.W();
            } else {
                throw new ArithmeticException("Index overflow has happened.");
            }
        }
        return i2;
    }

    @h.g2.f
    private static final Object[] f(Collection<?> collection) {
        return h.k2.v.t.a(collection);
    }

    @h.g2.f
    private static final <T> T[] g(Collection<?> collection, T[] tArr) {
        Objects.requireNonNull(tArr, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        T[] tArr2 = (T[]) h.k2.v.t.b(collection, tArr);
        Objects.requireNonNull(tArr2, "null cannot be cast to non-null type kotlin.Array<T>");
        return tArr2;
    }

    @k.e.a.d
    public static final <T> Object[] h(@k.e.a.d T[] tArr, boolean z) {
        return (z && h.k2.v.f0.g(tArr.getClass(), Object[].class)) ? tArr : Arrays.copyOf(tArr, tArr.length, Object[].class);
    }

    @h.p0
    @h.o
    @h.s0(version = "1.3")
    @k.e.a.d
    public static final <E> List<E> i() {
        return new h.a2.o1.b();
    }

    @h.p0
    @h.o
    @h.s0(version = "1.3")
    @k.e.a.d
    public static final <E> List<E> j(int i2) {
        return new h.a2.o1.b(i2);
    }

    @k.e.a.d
    public static final <T> List<T> k(T t) {
        return Collections.singletonList(t);
    }

    @h.s0(version = SVG.f2474i)
    @k.e.a.d
    public static final <T> List<T> l(@k.e.a.d Iterable<? extends T> iterable) {
        List<T> K5 = CollectionsKt___CollectionsKt.K5(iterable);
        Collections.shuffle(K5);
        return K5;
    }

    @h.s0(version = SVG.f2474i)
    @k.e.a.d
    public static final <T> List<T> m(@k.e.a.d Iterable<? extends T> iterable, @k.e.a.d Random random) {
        List<T> K5 = CollectionsKt___CollectionsKt.K5(iterable);
        Collections.shuffle(K5, random);
        return K5;
    }

    @h.g2.f
    private static final <T> List<T> n(Enumeration<T> enumeration) {
        return Collections.list(enumeration);
    }
}
