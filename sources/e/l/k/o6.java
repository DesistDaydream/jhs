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
import com.jihuanshe.ui.page.user.wish.DesireFragment;
import com.jihuanshe.ui.widget.GameFilterBtn;
import com.vector.view.pager.ViewPager;

/* loaded from: classes2.dex */
public abstract class o6 extends ViewDataBinding {
    @NonNull
    public final GameFilterBtn a;
    @NonNull
    public final ConstraintLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final SlideIndicatorView f13249c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ViewPager f13250d;
    @Bindable

    /* renamed from: e  reason: collision with root package name */
    public DesireFragment f13251e;

    public o6(Object obj, View view, int i2, GameFilterBtn gameFilterBtn, ConstraintLayout constraintLayout, SlideIndicatorView slideIndicatorView, ViewPager viewPager) {
        super(obj, view, i2);
        this.a = gameFilterBtn;
        this.b = constraintLayout;
        this.f13249c = slideIndicatorView;
        this.f13250d = viewPager;
    }

    public static o6 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static o6 b(@NonNull View view, @Nullable Object obj) {
        return (o6) ViewDataBinding.bind(obj, view, R.layout.fragment_desire);
    }

    @NonNull
    public static o6 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static o6 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static o6 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (o6) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_desire, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static o6 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (o6) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_desire, null, false, obj);
    }

    @Nullable
    public DesireFragment c() {
        return this.f13251e;
    }

    public abstract void h(@Nullable DesireFragment desireFragment);
}
