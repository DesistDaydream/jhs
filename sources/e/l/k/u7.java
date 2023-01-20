package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.base.ui.widget.SlideIndicatorView;
import com.jihuanshe.ui.page.entrepot.SearchMyStorehouseFragment;
import com.vector.view.pager.ViewPager;

/* loaded from: classes2.dex */
public abstract class u7 extends ViewDataBinding {
    @NonNull
    public final LinearLayout a;
    @NonNull
    public final SlideIndicatorView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ViewPager f13702c;
    @Bindable

    /* renamed from: d  reason: collision with root package name */
    public SearchMyStorehouseFragment f13703d;
    @Bindable

    /* renamed from: e  reason: collision with root package name */
    public e.l.s.h.b f13704e;

    public u7(Object obj, View view, int i2, LinearLayout linearLayout, SlideIndicatorView slideIndicatorView, ViewPager viewPager) {
        super(obj, view, i2);
        this.a = linearLayout;
        this.b = slideIndicatorView;
        this.f13702c = viewPager;
    }

    public static u7 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static u7 b(@NonNull View view, @Nullable Object obj) {
        return (u7) ViewDataBinding.bind(obj, view, R.layout.fragment_search_my_storehouse);
    }

    @NonNull
    public static u7 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static u7 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static u7 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (u7) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_search_my_storehouse, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static u7 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (u7) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_search_my_storehouse, null, false, obj);
    }

    @Nullable
    public SearchMyStorehouseFragment c() {
        return this.f13703d;
    }

    @Nullable
    public e.l.s.h.b d() {
        return this.f13704e;
    }

    public abstract void i(@Nullable SearchMyStorehouseFragment searchMyStorehouseFragment);

    public abstract void j(@Nullable e.l.s.h.b bVar);
}
