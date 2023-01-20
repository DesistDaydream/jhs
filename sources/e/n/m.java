package e.n;

import androidx.exifinterface.media.ExifInterface;
import h.k2.v.u;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0017\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0000¢\u0006\u0002\u0010\rJ\u001b\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00028\u0000¢\u0006\u0002\u0010\u000fJ\u001e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00072\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012J\u0016\u0010\u0010\u001a\u00020\u000b2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012J\u0006\u0010\u0013\u001a\u00020\u000bJ\u0018\u0010\u0014\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0015\u001a\u00020\u0007H\u0086\u0002¢\u0006\u0002\u0010\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\rJ\u0019\u0010\u0019\u001a\u00020\u000b2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012H\u0086\u0002J\u0016\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\rJ\u0019\u0010\u001a\u001a\u00020\u000b2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012H\u0086\u0002J\u0013\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0000¢\u0006\u0002\u0010\rJ\u0016\u0010\u001c\u001a\u00020\u000b2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012J\u000e\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0007J\u0006\u0010\u001e\u001a\u00020\u0007R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/live/LiveList;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/live/Live;", "", "default", "(Ljava/util/List;)V", "lastIndex", "", "getLastIndex", "()I", "add", "", "element", "(Ljava/lang/Object;)V", "position", "(ILjava/lang/Object;)V", "addAll", "other", "", "clear", "get", "index", "(I)Ljava/lang/Object;", "isEmpty", "", "minusAssign", "plusAssign", "remove", "removeAll", "removeAt", "size", "live_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class m<T> extends f<List<T>> {
    public m() {
        this(null, 1, null);
    }

    public m(@k.e.a.e List<T> list) {
        super(list);
    }

    public final void A(T t) {
        E(t);
    }

    public final void B(@k.e.a.e List<? extends T> list) {
        F(list);
    }

    public final void C(T t) {
        t(t);
    }

    public final void D(@k.e.a.e List<? extends T> list) {
        v(list);
    }

    public final void E(T t) {
        List list = (List) getValue();
        if (list != null) {
            list.remove(t);
        }
        n();
    }

    public final void F(@k.e.a.e List<? extends T> list) {
        if (list == null) {
            return;
        }
        List list2 = (List) getValue();
        if (list2 != null) {
            list2.removeAll(list);
        }
        n();
    }

    public final void G(int i2) {
        List list = (List) getValue();
        if (list != null) {
            list.remove(i2);
        }
        n();
    }

    public final int H() {
        List list = (List) getValue();
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final void s(int i2, T t) {
        List list = (List) getValue();
        if (list != null) {
            list.add(i2, t);
        }
        n();
    }

    public final void t(T t) {
        List list = (List) getValue();
        if (list != null) {
            list.add(t);
        }
        n();
    }

    public final void u(int i2, @k.e.a.e List<? extends T> list) {
        if (list == null) {
            return;
        }
        List list2 = (List) getValue();
        if (list2 != null) {
            list2.addAll(i2, list);
        }
        n();
    }

    public final void v(@k.e.a.e List<? extends T> list) {
        if (list == null) {
            return;
        }
        List list2 = (List) getValue();
        if (list2 != null) {
            list2.addAll(list);
        }
        n();
    }

    public final void w() {
        List list = (List) getValue();
        if (list != null) {
            list.clear();
        }
        n();
    }

    @k.e.a.e
    public final T x(int i2) {
        List list = (List) getValue();
        if (list == null) {
            return null;
        }
        return (T) CollectionsKt___CollectionsKt.J2(list, i2);
    }

    public final int y() {
        List list = (List) getValue();
        if (list == null) {
            return 0;
        }
        return CollectionsKt__CollectionsKt.G(list);
    }

    public final boolean z() {
        List list = (List) getValue();
        if (list == null) {
            return false;
        }
        return list.isEmpty();
    }

    public /* synthetic */ m(List list, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : list);
    }
}
