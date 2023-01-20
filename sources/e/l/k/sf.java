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
import com.jihuanshe.ui.page.main.shop.ShopFragment;
import com.jihuanshe.ui.widget.StarRatingBar;
import com.jihuanshe.viewmodel.main.shop.ShopViewModel;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class sf extends ViewDataBinding {
    @NonNull
    public final NImageView a;
    @NonNull
    public final ConstraintLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f13576c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final StarRatingBar f13577d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f13578e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f13579f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextView f13580g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TextView f13581h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final TextView f13582i;
    @Bindable

    /* renamed from: j  reason: collision with root package name */
    public ShopFragment f13583j;
    @Bindable

    /* renamed from: k  reason: collision with root package name */
    public ShopViewModel f13584k;

    public sf(Object obj, View view, int i2, NImageView nImageView, ConstraintLayout constraintLayout, LinearLayout linearLayout, StarRatingBar starRatingBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, i2);
        this.a = nImageView;
        this.b = constraintLayout;
        this.f13576c = linearLayout;
        this.f13577d = starRatingBar;
        this.f13578e = textView;
        this.f13579f = textView2;
        this.f13580g = textView3;
        this.f13581h = textView4;
        this.f13582i = textView5;
    }

    public static sf a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static sf b(@NonNull View view, @Nullable Object obj) {
        return (sf) ViewDataBinding.bind(obj, view, R.layout.view_header_banner);
    }

    @NonNull
    public static sf e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static sf f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static sf g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (sf) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_header_banner, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static sf h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (sf) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_header_banner, null, false, obj);
    }

    @Nullable
    public ShopFragment c() {
        return this.f13583j;
    }

    @Nullable
    public ShopViewModel d() {
        return this.f13584k;
    }

    public abstract void i(@Nullable ShopFragment shopFragment);

    public abstract void j(@Nullable ShopViewModel shopViewModel);
}
