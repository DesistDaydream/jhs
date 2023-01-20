package e.t.k.a.c;

import androidx.databinding.ViewDataBinding;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.qcloud.tuicore.TUIConstants;
import h.k2.v.u;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H&J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u001d\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\rH&¢\u0006\u0002\u0010\u000eJ#\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/vector/design/ui/adapter/AdapterEx;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/vector/design/ui/adapter/MultiAdapterEx;", TUIConstants.TUIChat.OWNER, "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;)V", "getLayoutId", "", "viewType", "onBindBinding", "", "item", "binding", "Landroidx/databinding/ViewDataBinding;", "(Ljava/lang/Object;Landroidx/databinding/ViewDataBinding;)V", "(ILjava/lang/Object;Landroidx/databinding/ViewDataBinding;)V", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class a<T> extends f<T> {
    public a() {
        this(null, 1, null);
    }

    public a(@k.e.a.e LifecycleOwner lifecycleOwner) {
        super(lifecycleOwner);
    }

    @Override // e.t.k.a.c.f
    public final int h(int i2) {
        return t();
    }

    @Override // e.t.k.a.c.f
    public final void n(int i2, T t, @k.e.a.d ViewDataBinding viewDataBinding) {
        u(t, viewDataBinding);
    }

    public abstract int t();

    public abstract void u(T t, @k.e.a.d ViewDataBinding viewDataBinding);

    public /* synthetic */ a(LifecycleOwner lifecycleOwner, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : lifecycleOwner);
    }
}
