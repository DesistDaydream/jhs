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
import com.jihuanshe.ui.page.search.fragments.global.GlobalSearchProductFragment;
import com.jihuanshe.ui.widget.GameFilterBtn;
import com.jihuanshe.ui.widget.RarityFilterBtn;
import com.vector.view.pager.ViewPager;

/* loaded from: classes2.dex */
public abstract class u6 extends ViewDataBinding {
    @NonNull
    public final GameFilterBtn a;
    @NonNull
    public final ConstraintLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final RarityFilterBtn f13697c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final SlideIndicatorView f13698d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final ViewPager f13699e;
    @Bindable

    /* renamed from: f  reason: collision with root package name */
    public GlobalSearchProductFragment f13700f;
    @Bindable

    /* renamed from: g  reason: collision with root package name */
    public e.l.s.m.d.a f13701g;

    public u6(Object obj, View view, int i2, GameFilterBtn gameFilterBtn, ConstraintLayout constraintLayout, RarityFilterBtn rarityFilterBtn, SlideIndicatorView slideIndicatorView, ViewPager viewPager) {
        super(obj, view, i2);
        this.a = gameFilterBtn;
        this.b = constraintLayout;
        this.f13697c = rarityFilterBtn;
        this.f13698d = slideIndicatorView;
        this.f13699e = viewPager;
    }

    public static u6 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static u6 b(@NonNull View view, @Nullable Object obj) {
        return (u6) ViewDataBinding.bind(obj, view, R.layout.fragment_global_search_product);
    }

    @NonNull
    public static u6 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static u6 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static u6 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (u6) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_global_search_product, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static u6 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (u6) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_global_search_product, null, false, obj);
    }

    @Nullable
    public GlobalSearchProductFragment c() {
        return this.f13700f;
    }

    @Nullable
    public e.l.s.m.d.a d() {
        return this.f13701g;
    }

    public abstract void i(@Nullable GlobalSearchProductFragment globalSearchProductFragment);

    public abstract void j(@Nullable e.l.s.m.d.a aVar);
}
