package e.t.l;

import androidx.exifinterface.media.ExifInterface;
import com.qiniu.android.collect.ReportItem;
import h.t1;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a&\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005\u001a\u001e\u0010\u0007\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005\u001a*\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\f0\u000b\u001a*\u0010\r\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\f0\u000b\u001aM\u0010\u000e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052-\u0010\n\u001a)\u0012\u001f\u0012\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u000f0\u000f¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00010\u000b¨\u0006\u0014"}, d2 = {"move", "", ExifInterface.LONGITUDE_EAST, "", "from", "", "to", "removeAfter", "index", "removeFirstWhen", ReportItem.LogTypeBlock, "Lkotlin/Function1;", "", "removeWhen", "split", "", "size", "Lkotlin/ParameterName;", "name", "group", "vector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class p {
    public static final <E> void a(@k.e.a.d List<E> list, int i2, int i3) {
        E e2 = list.get(i2);
        if (i2 > i3) {
            list.remove(e2);
            list.add(i3, e2);
        } else if (i3 > i2) {
            list.add(i3, e2);
            list.remove(i2);
        }
    }

    public static final <E> void b(@k.e.a.d List<E> list, int i2) {
        int size = list.size() - 1;
        if (size < 0) {
            return;
        }
        while (true) {
            int i3 = size - 1;
            if (i2 <= size) {
                list.remove(size);
            }
            if (i3 < 0) {
                return;
            }
            size = i3;
        }
    }

    public static final <E> void c(@k.e.a.d List<E> list, @k.e.a.d h.k2.u.l<? super E, Boolean> lVar) {
        int size = list.size();
        if (size <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (lVar.invoke(list.get(i2)).booleanValue()) {
                list.remove(i2);
                return;
            } else if (i3 >= size) {
                return;
            } else {
                i2 = i3;
            }
        }
    }

    public static final <E> void d(@k.e.a.d List<E> list, @k.e.a.d h.k2.u.l<? super E, Boolean> lVar) {
        int size = list.size() - 1;
        if (size < 0) {
            return;
        }
        while (true) {
            int i2 = size - 1;
            if (lVar.invoke(list.get(size)).booleanValue()) {
                list.remove(size);
            }
            if (i2 < 0) {
                return;
            }
            size = i2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.util.List] */
    public static final <E> void e(@k.e.a.d List<? extends E> list, int i2, @k.e.a.d h.k2.u.l<? super List<? extends List<? extends E>>, t1> lVar) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        if (list.size() <= i2) {
            arrayList.add(list);
        } else {
            int size = list.size() % i2;
            loop0: while (true) {
                ArrayList arrayList2 = null;
                for (Object obj : CollectionsKt___CollectionsKt.w5(list, list.size() - size)) {
                    arrayList2 = arrayList2;
                    if (arrayList2 == null) {
                        ArrayList arrayList3 = new ArrayList();
                        arrayList.add(arrayList3);
                        t1 t1Var = t1.a;
                        arrayList2 = arrayList3;
                    }
                    arrayList2.add(obj);
                    if (arrayList2.size() == i2) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        break;
                    }
                }
            }
            arrayList.add(CollectionsKt___CollectionsKt.x5(list, size));
        }
        lVar.invoke(arrayList);
    }
}
