package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.button.MaterialButton;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.user.selling.SellingChildFragment;
import com.jihuanshe.viewmodel.user.selling.SellingChildViewModel;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class k6 extends ViewDataBinding {
    @NonNull
    public final MaterialButton a;
    @NonNull
    public final ListView b;
    @Bindable

    /* renamed from: c  reason: collision with root package name */
    public SellingChildFragment f13003c;
    @Bindable

    /* renamed from: d  reason: collision with root package name */
    public SellingChildViewModel f13004d;

    public k6(Object obj, View view, int i2, MaterialButton materialButton, ListView listView) {
        super(obj, view, i2);
        this.a = materialButton;
        this.b = listView;
    }

    public static k6 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static k6 b(@NonNull View view, @Nullable Object obj) {
        return (k6) ViewDataBinding.bind(obj, view, R.layout.fragment_child_selling);
    }

    @NonNull
    public static k6 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static k6 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static k6 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (k6) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_child_selling, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static k6 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (k6) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_child_selling, null, false, obj);
    }

    @Nullable
    public SellingChildFragment c() {
        return this.f13003c;
    }

    @Nullable
    public SellingChildViewModel d() {
        return this.f13004d;
    }

    public abstract void i(@Nullable SellingChildFragment sellingChildFragment);

    public abstract void j(@Nullable SellingChildViewModel sellingChildViewModel);
}
