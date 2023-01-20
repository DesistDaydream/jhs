package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.base.ui.widget.SlideIndicatorView;
import com.jihuanshe.ui.page.shop.SellCalendarActivity;
import com.jihuanshe.viewmodel.shop.SellCalendarViewModel;
import com.vector.view.pager.ViewPager;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class e2 extends ViewDataBinding {
    @NonNull
    public final SlideIndicatorView a;
    @NonNull
    public final ListView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final FrameLayout f12548c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f12549d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final ViewPager f12550e;
    @Bindable

    /* renamed from: f  reason: collision with root package name */
    public SellCalendarActivity f12551f;
    @Bindable

    /* renamed from: g  reason: collision with root package name */
    public SellCalendarViewModel f12552g;

    public e2(Object obj, View view, int i2, SlideIndicatorView slideIndicatorView, ListView listView, FrameLayout frameLayout, LinearLayout linearLayout, ViewPager viewPager) {
        super(obj, view, i2);
        this.a = slideIndicatorView;
        this.b = listView;
        this.f12548c = frameLayout;
        this.f12549d = linearLayout;
        this.f12550e = viewPager;
    }

    public static e2 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static e2 b(@NonNull View view, @Nullable Object obj) {
        return (e2) ViewDataBinding.bind(obj, view, R.layout.activity_sell_calendar);
    }

    @NonNull
    public static e2 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static e2 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static e2 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (e2) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_sell_calendar, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static e2 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (e2) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_sell_calendar, null, false, obj);
    }

    @Nullable
    public SellCalendarActivity c() {
        return this.f12551f;
    }

    @Nullable
    public SellCalendarViewModel d() {
        return this.f12552g;
    }

    public abstract void i(@Nullable SellCalendarActivity sellCalendarActivity);

    public abstract void j(@Nullable SellCalendarViewModel sellCalendarViewModel);
}
