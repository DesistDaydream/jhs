package h.a2;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.android.tpush.common.MessageKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a.\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u0087\bø\u0001\u0000\u001a \u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\b\u001a\u00020\u0007H\u0001\u001a\u001f\u0010\t\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0001¢\u0006\u0002\u0010\n\u001a\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0000\u001a,\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0000\u001a\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0010\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0001\u001a\u001d\u0010\u0011\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\fH\u0002¢\u0006\u0002\b\u0013\u001a@\u0010\u0014\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00160\u00100\u0015\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0016*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00160\u00150\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0017"}, d2 = {"Iterable", "", ExifInterface.GPS_DIRECTION_TRUE, "iterator", "Lkotlin/Function0;", "", "collectionSizeOrDefault", "", "default", "collectionSizeOrNull", "(Ljava/lang/Iterable;)Ljava/lang/Integer;", "convertToSetForSetOperation", "", "convertToSetForSetOperationWith", MessageKey.MSG_SOURCE, "flatten", "", "safeToConvertToSet", "", "safeToConvertToSet$CollectionsKt__IterablesKt", "unzip", "Lkotlin/Pair;", "R", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes3.dex */
public class u extends CollectionsKt__CollectionsKt {

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¨\u0006\u0004"}, d2 = {"kotlin/collections/CollectionsKt__IterablesKt$Iterable$1", "", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class a implements Iterable<T>, h.k2.v.x0.a {
        public final /* synthetic */ h.k2.u.a a;

        public a(h.k2.u.a aVar) {
            this.a = aVar;
        }

        @Override // java.lang.Iterable
        @k.e.a.d
        public Iterator<T> iterator() {
            return (Iterator) this.a.invoke();
        }
    }

    @h.g2.f
    private static final <T> Iterable<T> X(h.k2.u.a<? extends Iterator<? extends T>> aVar) {
        return new a(aVar);
    }

    @h.p0
    public static final <T> int Y(@k.e.a.d Iterable<? extends T> iterable, int i2) {
        return iterable instanceof Collection ? ((Collection) iterable).size() : i2;
    }

    @h.p0
    @k.e.a.e
    public static final <T> Integer Z(@k.e.a.d Iterable<? extends T> iterable) {
        if (iterable instanceof Collection) {
            return Integer.valueOf(((Collection) iterable).size());
        }
        return null;
    }

    @k.e.a.d
    public static final <T> Collection<T> a0(@k.e.a.d Iterable<? extends T> iterable) {
        if (iterable instanceof Set) {
            return (Collection) iterable;
        }
        if (iterable instanceof Collection) {
            Collection<T> collection = (Collection) iterable;
            return d0(collection) ? CollectionsKt___CollectionsKt.G5(iterable) : collection;
        }
        return CollectionsKt___CollectionsKt.G5(iterable);
    }

    @k.e.a.d
    public static final <T> Collection<T> b0(@k.e.a.d Iterable<? extends T> iterable, @k.e.a.d Iterable<? extends T> iterable2) {
        if (iterable instanceof Set) {
            return (Collection) iterable;
        }
        if (iterable instanceof Collection) {
            if (!(iterable2 instanceof Collection) || ((Collection) iterable2).size() >= 2) {
                Collection<T> collection = (Collection) iterable;
                return d0(collection) ? CollectionsKt___CollectionsKt.G5(iterable) : collection;
            }
            return (Collection) iterable;
        }
        return CollectionsKt___CollectionsKt.G5(iterable);
    }

    @k.e.a.d
    public static final <T> List<T> c0(@k.e.a.d Iterable<? extends Iterable<? extends T>> iterable) {
        ArrayList arrayList = new ArrayList();
        for (Iterable<? extends T> iterable2 : iterable) {
            y.q0(arrayList, iterable2);
        }
        return arrayList;
    }

    private static final <T> boolean d0(Collection<? extends T> collection) {
        return collection.size() > 2 && (collection instanceof ArrayList);
    }

    @k.e.a.d
    public static final <T, R> Pair<List<T>, List<R>> e0(@k.e.a.d Iterable<? extends Pair<? extends T, ? extends R>> iterable) {
        int Y = Y(iterable, 10);
        ArrayList arrayList = new ArrayList(Y);
        ArrayList arrayList2 = new ArrayList(Y);
        for (Pair<? extends T, ? extends R> pair : iterable) {
            arrayList.add(pair.getFirst());
            arrayList2.add(pair.getSecond());
        }
        return h.z0.a(arrayList, arrayList2);
    }
}
