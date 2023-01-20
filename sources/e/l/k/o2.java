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
import com.jihuanshe.ui.page.user.ShopCarActivity;
import com.jihuanshe.viewmodel.user.ShopCarViewModel;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class o2 extends ViewDataBinding {
    @NonNull
    public final ListView a;
    @Bindable
    public ShopCarActivity b;
    @Bindable

    /* renamed from: c  reason: collision with root package name */
    public ShopCarViewModel f13246c;

    public o2(Object obj, View view, int i2, ListView listView) {
        super(obj, view, i2);
        this.a = listView;
    }

    public static o2 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static o2 b(@NonNull View view, @Nullable Object obj) {
        return (o2) ViewDataBinding.bind(obj, view, R.layout.activity_shop_car);
    }

    @NonNull
    public static o2 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static o2 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static o2 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (o2) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_shop_car, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static o2 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (o2) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_shop_car, null, false, obj);
    }

    @Nullable
    public ShopCarActivity c() {
        return this.b;
    }

    @Nullable
    public ShopCarViewModel d() {
        return this.f13246c;
    }

    public abstract void i(@Nullable ShopCarActivity shopCarActivity);

    public abstract void j(@Nullable ShopCarViewModel shopCarViewModel);
}
