package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.base.ui.widget.SlideIndicatorView;
import com.jihuanshe.ui.page.entrepot.StorehouseActivity;
import com.jihuanshe.viewmodel.entrepot.StorehouseViewModel;
import com.vector.view.pager.ViewPager;

/* loaded from: classes2.dex */
public abstract class m1 extends ViewDataBinding {
    @NonNull
    public final ConstraintLayout a;
    @NonNull
    public final SlideIndicatorView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ViewPager f13099c;
    @Bindable

    /* renamed from: d  reason: collision with root package name */
    public StorehouseActivity f13100d;
    @Bindable

    /* renamed from: e  reason: collision with root package name */
    public StorehouseViewModel f13101e;

    public m1(Object obj, View view, int i2, ConstraintLayout constraintLayout, SlideIndicatorView slideIndicatorView, ViewPager viewPager) {
        super(obj, view, i2);
        this.a = constraintLayout;
        this.b = slideIndicatorView;
        this.f13099c = viewPager;
    }

    public static m1 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static m1 b(@NonNull View view, @Nullable Object obj) {
        return (m1) ViewDataBinding.bind(obj, view, R.layout.activity_mine_storehouse);
    }

    @NonNull
    public static m1 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static m1 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static m1 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (m1) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_mine_storehouse, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static m1 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (m1) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_mine_storehouse, null, false, obj);
    }

    @Nullable
    public StorehouseActivity c() {
        return this.f13100d;
    }

    @Nullable
    public StorehouseViewModel d() {
        return this.f13101e;
    }

    public abstract void i(@Nullable StorehouseActivity storehouseActivity);

    public abstract void j(@Nullable StorehouseViewModel storehouseViewModel);
}
