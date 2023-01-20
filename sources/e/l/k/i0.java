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
import com.jihuanshe.ui.page.entrepot.ConsignmentOrderActivity;
import com.jihuanshe.viewmodel.entrepot.ConsignmentOrderViewModel;
import com.vector.view.pager.ViewPager;

/* loaded from: classes2.dex */
public abstract class i0 extends ViewDataBinding {
    @NonNull
    public final ConstraintLayout a;
    @NonNull
    public final SlideIndicatorView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ViewPager f12829c;
    @Bindable

    /* renamed from: d  reason: collision with root package name */
    public ConsignmentOrderActivity f12830d;
    @Bindable

    /* renamed from: e  reason: collision with root package name */
    public ConsignmentOrderViewModel f12831e;

    public i0(Object obj, View view, int i2, ConstraintLayout constraintLayout, SlideIndicatorView slideIndicatorView, ViewPager viewPager) {
        super(obj, view, i2);
        this.a = constraintLayout;
        this.b = slideIndicatorView;
        this.f12829c = viewPager;
    }

    public static i0 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static i0 b(@NonNull View view, @Nullable Object obj) {
        return (i0) ViewDataBinding.bind(obj, view, R.layout.activity_consignment_order);
    }

    @NonNull
    public static i0 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static i0 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static i0 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (i0) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_consignment_order, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static i0 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (i0) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_consignment_order, null, false, obj);
    }

    @Nullable
    public ConsignmentOrderActivity c() {
        return this.f12830d;
    }

    @Nullable
    public ConsignmentOrderViewModel d() {
        return this.f12831e;
    }

    public abstract void i(@Nullable ConsignmentOrderActivity consignmentOrderActivity);

    public abstract void j(@Nullable ConsignmentOrderViewModel consignmentOrderViewModel);
}
