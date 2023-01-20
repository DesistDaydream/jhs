package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.adapter.OrderProductAdapter;
import com.jihuanshe.model.CardProduct;
import com.jihuanshe.ui.widget.CardImageView;

/* loaded from: classes2.dex */
public abstract class kb extends ViewDataBinding {
    @NonNull
    public final ConstraintLayout a;
    @NonNull
    public final CardImageView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f13018c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f13019d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f13020e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f13021f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextView f13022g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TextView f13023h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final TextView f13024i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final TextView f13025j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final TextView f13026k;
    @Bindable

    /* renamed from: l  reason: collision with root package name */
    public OrderProductAdapter f13027l;
    @Bindable

    /* renamed from: m  reason: collision with root package name */
    public CardProduct f13028m;

    public kb(Object obj, View view, int i2, ConstraintLayout constraintLayout, CardImageView cardImageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
        super(obj, view, i2);
        this.a = constraintLayout;
        this.b = cardImageView;
        this.f13018c = textView;
        this.f13019d = textView2;
        this.f13020e = textView3;
        this.f13021f = textView4;
        this.f13022g = textView5;
        this.f13023h = textView6;
        this.f13024i = textView7;
        this.f13025j = textView8;
        this.f13026k = textView9;
    }

    public static kb a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static kb b(@NonNull View view, @Nullable Object obj) {
        return (kb) ViewDataBinding.bind(obj, view, R.layout.item_order_product);
    }

    @NonNull
    public static kb e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static kb f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static kb g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (kb) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_order_product, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static kb h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (kb) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_order_product, null, false, obj);
    }

    @Nullable
    public OrderProductAdapter c() {
        return this.f13027l;
    }

    @Nullable
    public CardProduct d() {
        return this.f13028m;
    }

    public abstract void i(@Nullable OrderProductAdapter orderProductAdapter);

    public abstract void j(@Nullable CardProduct cardProduct);
}
