package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.rank.RankActivity;
import com.jihuanshe.ui.widget.GameFilterBtn;
import com.jihuanshe.ui.widget.RankIndicatorView;
import com.jihuanshe.viewmodel.rank.RankViewModel;
import com.vector.network.image.NImageView;
import com.vector.view.pager.ViewPager;

/* loaded from: classes2.dex */
public abstract class u1 extends ViewDataBinding {
    @NonNull
    public final LinearLayout a;
    @NonNull
    public final ConstraintLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final GameFilterBtn f13665c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f13666d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final NImageView f13667e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ViewPager f13668f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final RankIndicatorView f13669g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TextView f13670h;
    @Bindable

    /* renamed from: i  reason: collision with root package name */
    public RankActivity f13671i;
    @Bindable

    /* renamed from: j  reason: collision with root package name */
    public RankViewModel f13672j;

    public u1(Object obj, View view, int i2, LinearLayout linearLayout, ConstraintLayout constraintLayout, GameFilterBtn gameFilterBtn, LinearLayout linearLayout2, NImageView nImageView, ViewPager viewPager, RankIndicatorView rankIndicatorView, TextView textView) {
        super(obj, view, i2);
        this.a = linearLayout;
        this.b = constraintLayout;
        this.f13665c = gameFilterBtn;
        this.f13666d = linearLayout2;
        this.f13667e = nImageView;
        this.f13668f = viewPager;
        this.f13669g = rankIndicatorView;
        this.f13670h = textView;
    }

    public static u1 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static u1 b(@NonNull View view, @Nullable Object obj) {
        return (u1) ViewDataBinding.bind(obj, view, R.layout.activity_rank);
    }

    @NonNull
    public static u1 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static u1 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static u1 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (u1) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_rank, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static u1 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (u1) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_rank, null, false, obj);
    }

    @Nullable
    public RankActivity c() {
        return this.f13671i;
    }

    @Nullable
    public RankViewModel d() {
        return this.f13672j;
    }

    public abstract void i(@Nullable RankActivity rankActivity);

    public abstract void j(@Nullable RankViewModel rankViewModel);
}
