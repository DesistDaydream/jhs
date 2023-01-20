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
import com.jihuanshe.ui.page.main.shop.ShopFragment;
import com.jihuanshe.viewmodel.main.shop.ShopViewModel;

/* loaded from: classes2.dex */
public abstract class k8 extends ViewDataBinding {
    @Bindable
    public ShopFragment a;
    @Bindable
    public ShopViewModel b;

    public k8(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static k8 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static k8 b(@NonNull View view, @Nullable Object obj) {
        return (k8) ViewDataBinding.bind(obj, view, R.layout.fragment_shop_copy);
    }

    @NonNull
    public static k8 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static k8 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static k8 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (k8) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_shop_copy, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static k8 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (k8) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_shop_copy, null, false, obj);
    }

    @Nullable
    public ShopFragment c() {
        return this.a;
    }

    @Nullable
    public ShopViewModel d() {
        return this.b;
    }

    public abstract void i(@Nullable ShopFragment shopFragment);

    public abstract void j(@Nullable ShopViewModel shopViewModel);
}
