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
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class w7 extends ViewDataBinding {
    @NonNull
    public final ListView a;
    @Bindable
    public SearchProductFragment b;
    @Bindable

    /* renamed from: c  reason: collision with root package name */
    public SearchProductViewModel f13840c;

    public w7(Object obj, View view, int i2, ListView listView) {
        super(obj, view, i2);
        this.a = listView;
    }

    public static w7 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static w7 b(@NonNull View view, @Nullable Object obj) {
        return (w7) ViewDataBinding.bind(obj, view, R.layout.fragment_search_product);
    }

    @NonNull
    public static w7 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static w7 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static w7 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (w7) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_search_product, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static w7 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (w7) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_search_product, null, false, obj);
    }

    @Nullable
    public SearchProductFragment c() {
        return this.b;
    }

    @Nullable
    public SearchProductViewModel d() {
        return this.f13840c;
    }

    public abstract void i(@Nullable SearchProductFragment searchProductFragment);

    public abstract void j(@Nullable SearchProductViewModel searchProductViewModel);
}
