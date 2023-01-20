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
import com.jihuanshe.ui.page.search.fragments.global.GlobalSearchFragment;
import com.vector.view.pager.ViewPager;

/* loaded from: classes2.dex */
public abstract class s6 extends ViewDataBinding {
    @NonNull
    public final SlideIndicatorView a;
    @NonNull
    public final ViewPager b;
    @Bindable

    /* renamed from: c  reason: collision with root package name */
    public GlobalSearchFragment f13556c;
    @Bindable

    /* renamed from: d  reason: collision with root package name */
    public e.l.s.m.d.b f13557d;

    public s6(Object obj, View view, int i2, SlideIndicatorView slideIndicatorView, ViewPager viewPager) {
        super(obj, view, i2);
        this.a = slideIndicatorView;
        this.b = viewPager;
    }

    public static s6 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static s6 b(@NonNull View view, @Nullable Object obj) {
        return (s6) ViewDataBinding.bind(obj, view, R.layout.fragment_global_search);
    }

    @NonNull
    public static s6 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static s6 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static s6 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (s6) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_global_search, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static s6 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (s6) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_global_search, null, false, obj);
    }

    @Nullable
    public GlobalSearchFragment c() {
        return this.f13556c;
    }

    @Nullable
    public e.l.s.m.d.b d() {
        return this.f13557d;
    }

    public abstract void i(@Nullable GlobalSearchFragment globalSearchFragment);

    public abstract void j(@Nullable e.l.s.m.d.b bVar);
}
