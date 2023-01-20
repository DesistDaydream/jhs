package h.a2;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.android.tpush.common.MessageKey;
import h.t1;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0001\u001a?\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u001d\u0010\b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000bH\u0081\bø\u0001\u0000\u001a7\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u001d\u0010\b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000bH\u0081\bø\u0001\u0000\u001a\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\"\u0004\b\u0000\u0010\u0002H\u0001\u001a\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0001\u001a\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0001\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u000f\u001a\u0002H\u000e¢\u0006\u0002\u0010\u0010\u001a+\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0012\"\u0004\b\u0000\u0010\u000e2\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u000e0\u0014\"\u0002H\u000e¢\u0006\u0002\u0010\u0015\u001aG\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0012\"\u0004\b\u0000\u0010\u000e2\u001a\u0010\u0016\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000e0\u0017j\n\u0012\u0006\b\u0000\u0012\u0002H\u000e`\u00182\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u000e0\u0014\"\u0002H\u000e¢\u0006\u0002\u0010\u0019\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001a"}, d2 = {"build", "", ExifInterface.LONGITUDE_EAST, "builder", "", "buildSetInternal", "capacity", "", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "createSetBuilder", "setOf", ExifInterface.GPS_DIRECTION_TRUE, "element", "(Ljava/lang/Object;)Ljava/util/Set;", "sortedSetOf", "Ljava/util/TreeSet;", MessageKey.CUSTOM_LAYOUT_ELEMENTS, "", "([Ljava/lang/Object;)Ljava/util/TreeSet;", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/util/Comparator;[Ljava/lang/Object;)Ljava/util/TreeSet;", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/collections/SetsKt")
/* loaded from: classes3.dex */
public class c1 {
    @h.p0
    @h.o
    @h.s0(version = "1.3")
    @k.e.a.d
    public static final <E> Set<E> a(@k.e.a.d Set<E> set) {
        return ((h.a2.o1.h) set).d();
    }

    @h.p0
    @h.o
    @h.s0(version = "1.3")
    @h.g2.f
    private static final <E> Set<E> b(int i2, h.k2.u.l<? super Set<E>, t1> lVar) {
        Set e2 = e(i2);
        lVar.invoke(e2);
        return a(e2);
    }

    @h.p0
    @h.o
    @h.s0(version = "1.3")
    @h.g2.f
    private static final <E> Set<E> c(h.k2.u.l<? super Set<E>, t1> lVar) {
        Set d2 = d();
        lVar.invoke(d2);
        return a(d2);
    }

    @h.p0
    @h.o
    @h.s0(version = "1.3")
    @k.e.a.d
    public static final <E> Set<E> d() {
        return new h.a2.o1.h();
    }

    @h.p0
    @h.o
    @h.s0(version = "1.3")
    @k.e.a.d
    public static final <E> Set<E> e(int i2) {
        return new h.a2.o1.h(i2);
    }

    @k.e.a.d
    public static final <T> Set<T> f(T t) {
        return Collections.singleton(t);
    }

    @k.e.a.d
    public static final <T> TreeSet<T> g(@k.e.a.d Comparator<? super T> comparator, @k.e.a.d T... tArr) {
        return (TreeSet) ArraysKt___ArraysKt.Jx(tArr, new TreeSet(comparator));
    }

    @k.e.a.d
    public static final <T> TreeSet<T> h(@k.e.a.d T... tArr) {
        return (TreeSet) ArraysKt___ArraysKt.Jx(tArr, new TreeSet());
    }
}
