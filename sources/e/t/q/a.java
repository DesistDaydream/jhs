package e.t.q;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0013\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\f¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0018J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\fR0\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/vector/model/Group;", "CHILD", "", "()V", "value", "", "children", "getChildren", "()Ljava/util/List;", "setChildren", "(Ljava/util/List;)V", "childrenCount", "", "getChildrenCount", "()I", "addChild", "", "child", "(Ljava/lang/Object;)V", "getChildAt", "position", "(I)Ljava/lang/Object;", "removeChild", "", "(Ljava/lang/Object;)Z", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class a<CHILD> {
    @k.e.a.d
    private List<CHILD> a = new ArrayList();

    public final void a(CHILD child) {
        this.a.add(child);
    }

    public final CHILD b(int i2) {
        return this.a.get(i2);
    }

    @k.e.a.d
    public final List<CHILD> c() {
        return this.a;
    }

    public final int d() {
        return this.a.size();
    }

    public final boolean e(int i2) {
        return this.a.remove(i2) != null;
    }

    public final boolean f(CHILD child) {
        return this.a.remove(child);
    }

    public final void g(@k.e.a.d List<CHILD> list) {
        this.a.clear();
        this.a = list;
    }
}
