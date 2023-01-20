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
import com.jihuanshe.adapter.ShopCarAdapter;
import com.jihuanshe.model.CardProduct;
import com.jihuanshe.ui.page.user.SellerDetailActivity;
import com.jihuanshe.ui.widget.CardImageView;

/* loaded from: classes2.dex */
public abstract class cd extends ViewDataBinding {
    @NonNull
    public final LinearLayout a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ConstraintLayout f12444c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f12445d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f12446e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final CardImageView f12447f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextView f12448g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TextView f12449h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final TextView f12450i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final TextView f12451j;
    @Bindable

    /* renamed from: k  reason: collision with root package name */
    public SellerDetailActivity f12452k;
    @Bindable

    /* renamed from: l  reason: collision with root package name */
    public CardProduct f12453l;
    @Bindable

    /* renamed from: m  reason: collision with root package name */
    public ShopCarAdapter f12454m;

    public cd(Object obj, View view, int i2, LinearLayout linearLayout, TextView textView, ConstraintLayout constraintLayout, TextView textView2, TextView textView3, CardImageView cardImageView, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        super(obj, view, i2);
        this.a = linearLayout;
        this.b = textView;
        this.f12444c = constraintLayout;
        this.f12445d = textView2;
        this.f12446e = textView3;
        this.f12447f = cardImageView;
        this.f12448g = textView4;
        this.f12449h = textView5;
        this.f12450i = textView6;
        this.f12451j = textView7;
    }

    public static cd a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static cd b(@NonNull View view, @Nullable Object obj) {
        return (cd) ViewDataBinding.bind(obj, view, R.layout.item_shop_card);
    }

    @NonNull
    public static cd f(@NonNull LayoutInflater layoutInflater) {
        return i(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static cd g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return h(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static cd h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (cd) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_shop_card, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static cd i(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (cd) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_shop_card, null, false, obj);
    }

    @Nullable
    public ShopCarAdapter c() {
        return this.f12454m;
    }

    @Nullable
    public CardProduct d() {
        return this.f12453l;
    }

    @Nullable
    public SellerDetailActivity e() {
        return this.f12452k;
    }

    public abstract void j(@Nullable ShopCarAdapter shopCarAdapter);

    public abstract void k(@Nullable CardProduct cardProduct);

    public abstract void l(@Nullable SellerDetailActivity sellerDetailActivity);
}
