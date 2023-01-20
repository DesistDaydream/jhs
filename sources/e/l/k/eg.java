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
import com.jihuanshe.ui.page.user.SellerDetailActivity;
import com.jihuanshe.viewmodel.user.SellerDetailViewModel;

/* loaded from: classes2.dex */
public abstract class eg extends ViewDataBinding {
    @Bindable
    public SellerDetailActivity a;
    @Bindable
    public SellerDetailViewModel b;

    public eg(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static eg a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static eg b(@NonNull View view, @Nullable Object obj) {
        return (eg) ViewDataBinding.bind(obj, view, R.layout.view_header_ware_banner);
    }

    @NonNull
    public static eg e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static eg f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static eg g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (eg) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_header_ware_banner, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static eg h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (eg) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_header_ware_banner, null, false, obj);
    }

    @Nullable
    public SellerDetailActivity c() {
        return this.a;
    }

    @Nullable
    public SellerDetailViewModel d() {
        return this.b;
    }

    public abstract void i(@Nullable SellerDetailActivity sellerDetailActivity);

    public abstract void j(@Nullable SellerDetailViewModel sellerDetailViewModel);
}
