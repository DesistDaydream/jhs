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
import com.jihuanshe.ui.page.order.SellerOrderListFragment;
import com.jihuanshe.viewmodel.order.SellerOrderListViewModel;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class e8 extends ViewDataBinding {
    @NonNull
    public final ListView a;
    @Bindable
    public SellerOrderListFragment b;
    @Bindable

    /* renamed from: c  reason: collision with root package name */
    public SellerOrderListViewModel f12567c;

    public e8(Object obj, View view, int i2, ListView listView) {
        super(obj, view, i2);
        this.a = listView;
    }

    public static e8 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static e8 b(@NonNull View view, @Nullable Object obj) {
        return (e8) ViewDataBinding.bind(obj, view, R.layout.fragment_seller_order_list);
    }

    @NonNull
    public static e8 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static e8 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static e8 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (e8) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_seller_order_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static e8 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (e8) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_seller_order_list, null, false, obj);
    }

    @Nullable
    public SellerOrderListFragment c() {
        return this.b;
    }

    @Nullable
    public SellerOrderListViewModel d() {
        return this.f12567c;
    }

    public abstract void i(@Nullable SellerOrderListFragment sellerOrderListFragment);

    public abstract void j(@Nullable SellerOrderListViewModel sellerOrderListViewModel);
}
