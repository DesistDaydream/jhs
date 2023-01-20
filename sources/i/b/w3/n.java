package i.b.w3;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.umeng.analytics.pro.am;
import h.t1;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0080@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0003\u001a\u00028\u0000H\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\t\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006H\u0086\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u001a"}, d2 = {"Li/b/w3/n;", ExifInterface.LONGITUDE_EAST, "", "element", "h", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function1;", "Lh/t1;", "action", "f", "(Ljava/lang/Object;Lh/k2/u/l;)V", "", "toString", "()Ljava/lang/String;", "", TTDownloadField.TT_HASHCODE, "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", am.av, "Ljava/lang/Object;", "holder", "b", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class n<E> {
    private final Object a;

    private /* synthetic */ n(@k.e.a.e Object obj) {
        this.a = obj;
    }

    @k.e.a.d
    public static final /* synthetic */ n a(@k.e.a.e Object obj) {
        return new n(obj);
    }

    @k.e.a.d
    public static Object b(@k.e.a.e Object obj) {
        return obj;
    }

    public static /* synthetic */ Object c(Object obj, int i2, h.k2.v.u uVar) {
        if ((i2 & 1) != 0) {
            obj = null;
        }
        return b(obj);
    }

    public static boolean d(Object obj, @k.e.a.e Object obj2) {
        return (obj2 instanceof n) && h.k2.v.f0.g(obj, ((n) obj2).j());
    }

    public static final boolean e(@k.e.a.e Object obj, @k.e.a.e Object obj2) {
        return h.k2.v.f0.g(obj, obj2);
    }

    public static final void f(Object obj, @k.e.a.d h.k2.u.l<? super E, t1> lVar) {
        if (obj == null) {
            return;
        }
        if (!(obj instanceof ArrayList)) {
            lVar.invoke(obj);
            return;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.collections.ArrayList<E> /* = java.util.ArrayList<E> */");
        ArrayList arrayList = (ArrayList) obj;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            lVar.invoke((Object) arrayList.get(size));
        }
    }

    public static int g(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    @k.e.a.d
    public static final Object h(Object obj, E e2) {
        if (!i.b.q0.b() || (!(e2 instanceof List))) {
            if (obj == null) {
                return b(e2);
            }
            if (obj instanceof ArrayList) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.collections.ArrayList<E> /* = java.util.ArrayList<E> */");
                ((ArrayList) obj).add(e2);
                return b(obj);
            }
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(obj);
            arrayList.add(e2);
            return b(arrayList);
        }
        throw new AssertionError();
    }

    @k.e.a.d
    public static String i(Object obj) {
        return "InlineList(holder=" + obj + ")";
    }

    public boolean equals(Object obj) {
        return d(this.a, obj);
    }

    public int hashCode() {
        return g(this.a);
    }

    @k.e.a.e
    public final /* synthetic */ Object j() {
        return this.a;
    }

    public String toString() {
        return i(this.a);
    }
}
