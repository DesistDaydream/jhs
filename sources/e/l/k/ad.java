package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.SellerOrderInfo;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class ad extends ViewDataBinding {
    @NonNull
    public final NImageView a;
    @NonNull
    public final NImageView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final View f12291c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f12292d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f12293e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f12294f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f12295g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TextView f12296h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final TextView f12297i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final TextView f12298j;
    @Bindable

    /* renamed from: k  reason: collision with root package name */
    public e.l.g.v0 f12299k;
    @Bindable

    /* renamed from: l  reason: collision with root package name */
    public SellerOrderInfo f12300l;

    public ad(Object obj, View view, int i2, NImageView nImageView, NImageView nImageView2, View view2, TextView textView, TextView textView2, TextView textView3, ImageView imageView, TextView textView4, TextView textView5, TextView textView6) {
        super(obj, view, i2);
        this.a = nImageView;
        this.b = nImageView2;
        this.f12291c = view2;
        this.f12292d = textView;
        this.f12293e = textView2;
        this.f12294f = textView3;
        this.f12295g = imageView;
        this.f12296h = textView4;
        this.f12297i = textView5;
        this.f12298j = textView6;
    }

    public static ad a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ad b(@NonNull View view, @Nullable Object obj) {
        return (ad) ViewDataBinding.bind(obj, view, R.layout.item_seller_order);
    }

    @NonNull
    public static ad e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ad f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ad g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ad) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_seller_order, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ad h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ad) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_seller_order, null, false, obj);
    }

    @Nullable
    public e.l.g.v0 c() {
        return this.f12299k;
    }

    @Nullable
    public SellerOrderInfo d() {
        return this.f12300l;
    }

    public abstract void i(@Nullable e.l.g.v0 v0Var);

    public abstract void j(@Nullable SellerOrderInfo sellerOrderInfo);
}
