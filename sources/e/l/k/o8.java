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
import com.jihuanshe.ui.page.search.fragments.global.SearchProductFragment;
import com.jihuanshe.viewmodel.search.globals.SearchProductViewModel;

/* loaded from: classes2.dex */
public abstract class o8 extends ViewDataBinding {
    @Bindable
    public SearchProductFragment a;
    @Bindable
    public SearchProductViewModel b;

    public o8(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static o8 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static o8 b(@NonNull View view, @Nullable Object obj) {
        return (o8) ViewDataBinding.bind(obj, view, R.layout.header_search_product);
    }

    @NonNull
    public static o8 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static o8 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static o8 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (o8) ViewDataBinding.inflateInternal(layoutInflater, R.layout.header_search_product, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static o8 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (o8) ViewDataBinding.inflateInternal(layoutInflater, R.layout.header_search_product, null, false, obj);
    }

    @Nullable
    public SearchProductFragment c() {
        return this.a;
    }

    @Nullable
    public SearchProductViewModel d() {
        return this.b;
    }

    public abstract void i(@Nullable SearchProductFragment searchProductFragment);

    public abstract void j(@Nullable SearchProductViewModel searchProductViewModel);
}
