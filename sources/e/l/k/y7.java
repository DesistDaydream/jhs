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
import com.jihuanshe.ui.page.entrepot.SearchSoldFragment;
import com.jihuanshe.viewmodel.entrepot.SearchSoldViewModel;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class y7 extends ViewDataBinding {
    @NonNull
    public final ListView a;
    @Bindable
    public SearchSoldFragment b;
    @Bindable

    /* renamed from: c  reason: collision with root package name */
    public SearchSoldViewModel f13970c;

    public y7(Object obj, View view, int i2, ListView listView) {
        super(obj, view, i2);
        this.a = listView;
    }

    public static y7 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static y7 b(@NonNull View view, @Nullable Object obj) {
        return (y7) ViewDataBinding.bind(obj, view, R.layout.fragment_search_sold);
    }

    @NonNull
    public static y7 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static y7 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static y7 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (y7) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_search_sold, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static y7 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (y7) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_search_sold, null, false, obj);
    }

    @Nullable
    public SearchSoldFragment c() {
        return this.b;
    }

    @Nullable
    public SearchSoldViewModel d() {
        return this.f13970c;
    }

    public abstract void i(@Nullable SearchSoldFragment searchSoldFragment);

    public abstract void j(@Nullable SearchSoldViewModel searchSoldViewModel);
}
