package h.a2;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.android.tpush.common.MessageKey;
import h.t1;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.EmptySet;

@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0005\u001aN\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u001f\b\u0001\u0010\u0005\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001aF\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u001f\b\u0001\u0010\u0005\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a\u0012\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001\"\u0004\b\u0000\u0010\u000b\u001a\u001f\u0010\f\u001a\u0012\u0012\u0004\u0012\u0002H\u000b0\rj\b\u0012\u0004\u0012\u0002H\u000b`\u000e\"\u0004\b\u0000\u0010\u000bH\u0087\b\u001a5\u0010\f\u001a\u0012\u0012\u0004\u0012\u0002H\u000b0\rj\b\u0012\u0004\u0012\u0002H\u000b`\u000e\"\u0004\b\u0000\u0010\u000b2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u000b0\u0010\"\u0002H\u000b¢\u0006\u0002\u0010\u0011\u001a\u001f\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u0002H\u000b0\u0013j\b\u0012\u0004\u0012\u0002H\u000b`\u0014\"\u0004\b\u0000\u0010\u000bH\u0087\b\u001a5\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u0002H\u000b0\u0013j\b\u0012\u0004\u0012\u0002H\u000b`\u0014\"\u0004\b\u0000\u0010\u000b2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u000b0\u0010\"\u0002H\u000b¢\u0006\u0002\u0010\u0015\u001a\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0007\"\u0004\b\u0000\u0010\u000bH\u0087\b\u001a+\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0007\"\u0004\b\u0000\u0010\u000b2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u000b0\u0010\"\u0002H\u000b¢\u0006\u0002\u0010\u0017\u001a\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001\"\u0004\b\u0000\u0010\u000bH\u0087\b\u001a+\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001\"\u0004\b\u0000\u0010\u000b2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u000b0\u0010\"\u0002H\u000b¢\u0006\u0002\u0010\u0017\u001a'\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001\"\b\b\u0000\u0010\u000b*\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u0001H\u000bH\u0007¢\u0006\u0002\u0010\u001c\u001a5\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001\"\b\b\u0000\u0010\u000b*\u00020\u001a2\u0016\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u000b0\u0010\"\u0004\u0018\u0001H\u000bH\u0007¢\u0006\u0002\u0010\u0017\u001a\u001e\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u0001H\u0000\u001a!\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001\"\u0004\b\u0000\u0010\u000b*\n\u0012\u0004\u0012\u0002H\u000b\u0018\u00010\u0001H\u0087\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001f"}, d2 = {"buildSet", "", ExifInterface.LONGITUDE_EAST, "capacity", "", "builderAction", "Lkotlin/Function1;", "", "", "Lkotlin/ExtensionFunctionType;", "emptySet", ExifInterface.GPS_DIRECTION_TRUE, "hashSetOf", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", MessageKey.CUSTOM_LAYOUT_ELEMENTS, "", "([Ljava/lang/Object;)Ljava/util/HashSet;", "linkedSetOf", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "([Ljava/lang/Object;)Ljava/util/LinkedHashSet;", "mutableSetOf", "([Ljava/lang/Object;)Ljava/util/Set;", "setOf", "setOfNotNull", "", "element", "(Ljava/lang/Object;)Ljava/util/Set;", "optimizeReadOnlySet", "orEmpty", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/collections/SetsKt")
/* loaded from: classes3.dex */
public class d1 extends c1 {
    @h.o
    @h.g2.f
    @h.s0(version = "1.3")
    private static final <E> Set<E> i(int i2, @h.b h.k2.u.l<? super Set<E>, t1> lVar) {
        Set e2 = c1.e(i2);
        lVar.invoke(e2);
        return c1.a(e2);
    }

    @h.o
    @h.g2.f
    @h.s0(version = "1.3")
    private static final <E> Set<E> j(@h.b h.k2.u.l<? super Set<E>, t1> lVar) {
        Set d2 = c1.d();
        lVar.invoke(d2);
        return c1.a(d2);
    }

    @k.e.a.d
    public static final <T> Set<T> k() {
        return EmptySet.INSTANCE;
    }

    @h.g2.f
    @h.s0(version = "1.1")
    private static final <T> HashSet<T> l() {
        return new HashSet<>();
    }

    @k.e.a.d
    public static final <T> HashSet<T> m(@k.e.a.d T... tArr) {
        return (HashSet) ArraysKt___ArraysKt.Jx(tArr, new HashSet(s0.j(tArr.length)));
    }

    @h.g2.f
    @h.s0(version = "1.1")
    private static final <T> LinkedHashSet<T> n() {
        return new LinkedHashSet<>();
    }

    @k.e.a.d
    public static final <T> LinkedHashSet<T> o(@k.e.a.d T... tArr) {
        return (LinkedHashSet) ArraysKt___ArraysKt.Jx(tArr, new LinkedHashSet(s0.j(tArr.length)));
    }

    @h.g2.f
    @h.s0(version = "1.1")
    private static final <T> Set<T> p() {
        return new LinkedHashSet();
    }

    @k.e.a.d
    public static final <T> Set<T> q(@k.e.a.d T... tArr) {
        return (Set) ArraysKt___ArraysKt.Jx(tArr, new LinkedHashSet(s0.j(tArr.length)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @k.e.a.d
    public static final <T> Set<T> r(@k.e.a.d Set<? extends T> set) {
        int size = set.size();
        if (size != 0) {
            return size != 1 ? set : c1.f(set.iterator().next());
        }
        return k();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.g2.f
    private static final <T> Set<T> s(Set<? extends T> set) {
        return set != 0 ? set : k();
    }

    @h.g2.f
    private static final <T> Set<T> t() {
        return k();
    }

    @k.e.a.d
    public static final <T> Set<T> u(@k.e.a.d T... tArr) {
        return tArr.length > 0 ? ArraysKt___ArraysKt.Gy(tArr) : k();
    }

    @h.s0(version = "1.4")
    @k.e.a.d
    public static final <T> Set<T> v(@k.e.a.e T t) {
        return t != null ? c1.f(t) : k();
    }

    @h.s0(version = "1.4")
    @k.e.a.d
    public static final <T> Set<T> w(@k.e.a.d T... tArr) {
        return (Set) ArraysKt___ArraysKt.ra(tArr, new LinkedHashSet());
    }
}
