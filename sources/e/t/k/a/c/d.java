package e.t.k.a.c;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.qcloud.tuicore.TUIConstants;
import e.t.q.a;
import h.k2.v.u;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00030\u0002*\u0004\b\u0001\u0010\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004B\u0011\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH&J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tJ\u001d\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\u0010H&¢\u0006\u0002\u0010\u0011J%\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0012J\u001d\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u0010H&¢\u0006\u0002\u0010\u0014J%\u0010\u0013\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/vector/design/ui/adapter/GroupAdapterEx;", "GROUP", "Lcom/vector/model/Group;", "CHILD", "Lcom/vector/design/ui/adapter/GroupMultiAdapterEx;", TUIConstants.TUIChat.OWNER, "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;)V", "getChildLayoutId", "", "viewType", "getGroupLayoutId", "onBindChildBinding", "", "item", "binding", "Landroidx/databinding/ViewDataBinding;", "(Ljava/lang/Object;Landroidx/databinding/ViewDataBinding;)V", "(ILjava/lang/Object;Landroidx/databinding/ViewDataBinding;)V", "onBindGroupBinding", "(Lcom/vector/model/Group;Landroidx/databinding/ViewDataBinding;)V", "(ILcom/vector/model/Group;Landroidx/databinding/ViewDataBinding;)V", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class d<GROUP extends e.t.q.a<CHILD>, CHILD> extends e<GROUP, CHILD> {
    public d() {
        this(null, 1, null);
    }

    public /* synthetic */ d(LifecycleOwner lifecycleOwner, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : lifecycleOwner);
    }

    @Override // e.t.k.a.c.e
    public int a(int i2) {
        return h();
    }

    @Override // e.t.k.a.c.e
    public final int d(int i2) {
        return i();
    }

    @Override // e.t.k.a.c.e
    public void e(int i2, CHILD child, @k.e.a.d ViewDataBinding viewDataBinding) {
        j(child, viewDataBinding);
    }

    @Override // e.t.k.a.c.e
    public void f(int i2, @k.e.a.d GROUP group, @k.e.a.d ViewDataBinding viewDataBinding) {
        k(group, viewDataBinding);
    }

    public abstract int h();

    public abstract int i();

    public abstract void j(CHILD child, @k.e.a.d ViewDataBinding viewDataBinding);

    public abstract void k(@k.e.a.d GROUP group, @k.e.a.d ViewDataBinding viewDataBinding);

    public d(@k.e.a.e LifecycleOwner lifecycleOwner) {
        super(lifecycleOwner);
    }
}
