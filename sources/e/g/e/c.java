package e.g.e;

import androidx.exifinterface.media.ExifInterface;
import com.eth.model.NLive;
import h.k2.u.l;
import h.k2.v.u;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0017\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0016\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\rJ\u0006\u0010\u000e\u001a\u00020\u000bJ\u001a\u0010\u000f\u001a\u00020\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b0\u0011J\u0018\u0010\u0012\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0013\u001a\u00020\u0007H\u0086\u0002¢\u0006\u0002\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\rH\u0086\u0002J\u0019\u0010\u0016\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\rH\u0086\u0002J\u0016\u0010\u0017\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\rR\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/eth/model/NLiveList;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/eth/model/NLive;", "", "default", "(Ljava/util/List;)V", "lastIndex", "", "getLastIndex", "()I", "addAll", "", "other", "", "clear", "forEach", "action", "Lkotlin/Function1;", "get", "index", "(I)Ljava/lang/Object;", "minusAssign", "plusAssign", "removeAll", "eth_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class c<T> extends NLive<List<T>> {
    public c() {
        this(null, 1, null);
    }

    public c(@e List<T> list) {
        super(list);
    }

    public final void A(@k.e.a.d l<? super T, t1> lVar) {
        List<Object> list = (List) getValue();
        if (list == null) {
            return;
        }
        for (Object obj : list) {
            lVar.invoke(obj);
        }
    }

    @e
    public final T B(int i2) {
        List list = (List) getValue();
        if (list == null) {
            return null;
        }
        return (T) CollectionsKt___CollectionsKt.J2(list, i2);
    }

    public final int C() {
        List list = (List) getValue();
        if (list == null) {
            return 0;
        }
        return CollectionsKt__CollectionsKt.G(list);
    }

    public final void D(@e List<? extends T> list) {
        F(list);
    }

    public final void E(@e List<? extends T> list) {
        y(list);
    }

    public final void F(@e List<? extends T> list) {
        if (list == null) {
            return;
        }
        List list2 = (List) getValue();
        if (list2 != null) {
            list2.removeAll(list);
        }
        n();
    }

    public final void y(@e List<? extends T> list) {
        if (list == null) {
            return;
        }
        List list2 = (List) getValue();
        if (list2 != null) {
            list2.addAll(list);
        }
        n();
    }

    public final void z() {
        List list = (List) getValue();
        if (list != null) {
            list.clear();
        }
        n();
    }

    public /* synthetic */ c(List list, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : list);
    }
}
