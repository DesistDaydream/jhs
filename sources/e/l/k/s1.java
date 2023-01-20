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
import com.jihuanshe.base.ui.widget.SlideIndicatorView;
import com.jihuanshe.ui.page.order.OrderListActivity;
import com.jihuanshe.viewmodel.order.OrderListViewModel;
import com.vector.view.pager.ViewPager;

/* loaded from: classes2.dex */
public abstract class s1 extends ViewDataBinding {
    @NonNull
    public final SlideIndicatorView a;
    @NonNull
    public final ViewPager b;
    @Bindable

    /* renamed from: c  reason: collision with root package name */
    public OrderListActivity f13540c;
    @Bindable

    /* renamed from: d  reason: collision with root package name */
    public OrderListViewModel f13541d;

    public s1(Object obj, View view, int i2, SlideIndicatorView slideIndicatorView, ViewPager viewPager) {
        super(obj, view, i2);
        this.a = slideIndicatorView;
        this.b = viewPager;
    }

    public static s1 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static s1 b(@NonNull View view, @Nullable Object obj) {
        return (s1) ViewDataBinding.bind(obj, view, R.layout.activity_order_list);
    }

    @NonNull
    public static s1 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static s1 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static s1 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (s1) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_order_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static s1 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (s1) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_order_list, null, false, obj);
    }

    @Nullable
    public OrderListActivity c() {
        return this.f13540c;
    }

    @Nullable
    public OrderListViewModel d() {
        return this.f13541d;
    }

    public abstract void i(@Nullable OrderListActivity orderListActivity);

    public abstract void j(@Nullable OrderListViewModel orderListViewModel);
}
