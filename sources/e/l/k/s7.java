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
import com.jihuanshe.ui.page.entrepot.SearchHouseProductFragment;
import com.jihuanshe.viewmodel.entrepot.SearchHouseProductViewModel;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class s7 extends ViewDataBinding {
    @NonNull
    public final ListView a;
    @Bindable
    public SearchHouseProductFragment b;
    @Bindable

    /* renamed from: c  reason: collision with root package name */
    public SearchHouseProductViewModel f13558c;

    public s7(Object obj, View view, int i2, ListView listView) {
        super(obj, view, i2);
        this.a = listView;
    }

    public static s7 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static s7 b(@NonNull View view, @Nullable Object obj) {
        return (s7) ViewDataBinding.bind(obj, view, R.layout.fragment_search_house_product);
    }

    @NonNull
    public static s7 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static s7 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static s7 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (s7) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_search_house_product, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static s7 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (s7) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_search_house_product, null, false, obj);
    }

    @Nullable
    public SearchHouseProductFragment c() {
        return this.b;
    }

    @Nullable
    public SearchHouseProductViewModel d() {
        return this.f13558c;
    }

    public abstract void i(@Nullable SearchHouseProductFragment searchHouseProductFragment);

    public abstract void j(@Nullable SearchHouseProductViewModel searchHouseProductViewModel);
}
