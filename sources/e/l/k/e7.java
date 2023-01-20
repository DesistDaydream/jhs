package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.order.OrderListFragment;
import com.jihuanshe.viewmodel.order.OrderListChildViewModel;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class e7 extends ViewDataBinding {
    @NonNull
    public final ListView a;
    @Bindable
    public OrderListFragment b;
    @Bindable

    /* renamed from: c  reason: collision with root package name */
    public OrderListChildViewModel f12566c;

    public e7(Object obj, View view, int i2, ListView listView) {
        super(obj, view, i2);
        this.a = listView;
    }

    public static e7 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static e7 b(@NonNull View view, @Nullable Object obj) {
        return (e7) ViewDataBinding.bind(obj, view, R.layout.fragment_order_list);
    }

    @NonNull
    public static e7 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static e7 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static e7 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (e7) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_order_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static e7 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (e7) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_order_list, null, false, obj);
    }

    @Nullable
    public OrderListFragment c() {
        return this.b;
    }

    @Nullable
    public OrderListChildViewModel d() {
        return this.f12566c;
    }

    public abstract void i(@Nullable OrderListFragment orderListFragment);

    public abstract void j(@Nullable OrderListChildViewModel orderListChildViewModel);
}
