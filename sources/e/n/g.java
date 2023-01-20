package e.n;

import androidx.exifinterface.media.ExifInterface;
import h.k2.v.u;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002H\u00010\u0003j\b\u0012\u0004\u0012\u0002H\u0001`\u00040\u0002B#\u0012\u001c\b\u0002\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0004¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u000eJ\u001e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\b2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012J\u0016\u0010\u000f\u001a\u00020\f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012J\u0006\u0010\u0013\u001a\u00020\fJ\u0018\u0010\u0014\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0015\u001a\u00020\bH\u0086\u0002¢\u0006\u0002\u0010\u0016J\u0006\u0010\u0017\u001a\u00020\bJ\u0019\u0010\u0018\u001a\u00020\f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012H\u0086\u0002J\u0016\u0010\u0019\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u000eJ\u0019\u0010\u0019\u001a\u00020\f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012H\u0086\u0002J\u0016\u0010\u001a\u001a\u00020\f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012J\u0006\u0010\u001b\u001a\u00020\u001cR\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/live/LiveArray;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/live/Live;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "default", "(Ljava/util/ArrayList;)V", "lastIndex", "", "getLastIndex", "()I", "add", "", "element", "(Ljava/lang/Object;)V", "addAll", "position", "other", "", "clear", "get", "index", "(I)Ljava/lang/Object;", "getSize", "minusAssign", "plusAssign", "removeAll", "removeLast", "", "live_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class g<T> extends f<ArrayList<T>> {
    public g() {
        this(null, 1, null);
    }

    public g(@k.e.a.e ArrayList<T> arrayList) {
        super(arrayList);
    }

    public final void A(T t) {
        s(t);
    }

    public final void B(@k.e.a.e List<? extends T> list) {
        u(list);
    }

    public final void C(@k.e.a.e List<? extends T> list) {
        if (list == null) {
            return;
        }
        ArrayList arrayList = (ArrayList) getValue();
        if (arrayList != null) {
            arrayList.removeAll(list);
        }
        n();
    }

    public final boolean D() {
        ArrayList arrayList = (ArrayList) getValue();
        if (arrayList != null && arrayList.size() == 0) {
            return false;
        }
        ArrayList arrayList2 = (ArrayList) getValue();
        if (arrayList2 != null) {
            arrayList2.remove(x());
        }
        n();
        return true;
    }

    public final void s(T t) {
        ArrayList arrayList = (ArrayList) getValue();
        if (arrayList != null) {
            arrayList.add(t);
        }
        n();
    }

    public final void t(int i2, @k.e.a.e List<? extends T> list) {
        if (list == null) {
            return;
        }
        ArrayList arrayList = (ArrayList) getValue();
        if (arrayList != null) {
            arrayList.addAll(i2, list);
        }
        n();
    }

    public final void u(@k.e.a.e List<? extends T> list) {
        if (list == null) {
            return;
        }
        ArrayList arrayList = (ArrayList) getValue();
        if (arrayList != null) {
            arrayList.addAll(list);
        }
        n();
    }

    public final void v() {
        ArrayList arrayList = (ArrayList) getValue();
        if (arrayList != null) {
            arrayList.clear();
        }
        n();
    }

    @k.e.a.e
    public final T w(int i2) {
        ArrayList arrayList = (ArrayList) getValue();
        if (arrayList == null) {
            return null;
        }
        return (T) CollectionsKt___CollectionsKt.J2(arrayList, i2);
    }

    public final int x() {
        ArrayList arrayList = (ArrayList) getValue();
        if (arrayList == null) {
            return 0;
        }
        return CollectionsKt__CollectionsKt.G(arrayList);
    }

    public final int y() {
        ArrayList arrayList = (ArrayList) getValue();
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final void z(@k.e.a.e List<? extends T> list) {
        C(list);
    }

    public /* synthetic */ g(ArrayList arrayList, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : arrayList);
    }
}
