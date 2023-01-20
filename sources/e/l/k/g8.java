package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.base.ui.widget.SlideIndicatorView;
import com.jihuanshe.ui.page.user.selling.SellingFragment;
import com.jihuanshe.ui.widget.FilterTextView;
import com.jihuanshe.ui.widget.RarityFilterBtn;
import com.vector.view.pager.ViewPager;

/* loaded from: classes2.dex */
public abstract class g8 extends ViewDataBinding {
    @NonNull
    public final View a;
    @NonNull
    public final FrameLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final FilterTextView f12726c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final SlideIndicatorView f12727d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final View f12728e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final RarityFilterBtn f12729f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final ViewPager f12730g;
    @Bindable

    /* renamed from: h  reason: collision with root package name */
    public SellingFragment f12731h;
    @Bindable

    /* renamed from: i  reason: collision with root package name */
    public e.l.s.o.d.a f12732i;

    public g8(Object obj, View view, int i2, View view2, FrameLayout frameLayout, FilterTextView filterTextView, SlideIndicatorView slideIndicatorView, View view3, RarityFilterBtn rarityFilterBtn, ViewPager viewPager) {
        super(obj, view, i2);
        this.a = view2;
        this.b = frameLayout;
        this.f12726c = filterTextView;
        this.f12727d = slideIndicatorView;
        this.f12728e = view3;
        this.f12729f = rarityFilterBtn;
        this.f12730g = viewPager;
    }

    public static g8 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static g8 b(@NonNull View view, @Nullable Object obj) {
        return (g8) ViewDataBinding.bind(obj, view, R.layout.fragment_selling);
    }

    @NonNull
    public static g8 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static g8 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static g8 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (g8) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_selling, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static g8 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (g8) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_selling, null, false, obj);
    }

    @Nullable
    public SellingFragment c() {
        return this.f12731h;
    }

    @Nullable
    public e.l.s.o.d.a d() {
        return this.f12732i;
    }

    public abstract void i(@Nullable SellingFragment sellingFragment);

    public abstract void j(@Nullable e.l.s.o.d.a aVar);
}
