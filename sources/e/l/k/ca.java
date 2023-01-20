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
import com.jihuanshe.model.GameCard;
import com.jihuanshe.ui.widget.CardImageView;
import com.jihuanshe.ui.widget.PriceTextView;

/* loaded from: classes2.dex */
public abstract class ca extends ViewDataBinding {
    @NonNull
    public final ImageView a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f12415c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CardImageView f12416d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f12417e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final View f12418f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f12419g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TextView f12420h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final PriceTextView f12421i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final TextView f12422j;
    @Bindable

    /* renamed from: k  reason: collision with root package name */
    public e.l.g.o0 f12423k;
    @Bindable

    /* renamed from: l  reason: collision with root package name */
    public GameCard f12424l;
    @Bindable

    /* renamed from: m  reason: collision with root package name */
    public Integer f12425m;

    public ca(Object obj, View view, int i2, ImageView imageView, TextView textView, TextView textView2, CardImageView cardImageView, ImageView imageView2, View view2, ImageView imageView3, TextView textView3, PriceTextView priceTextView, TextView textView4) {
        super(obj, view, i2);
        this.a = imageView;
        this.b = textView;
        this.f12415c = textView2;
        this.f12416d = cardImageView;
        this.f12417e = imageView2;
        this.f12418f = view2;
        this.f12419g = imageView3;
        this.f12420h = textView3;
        this.f12421i = priceTextView;
        this.f12422j = textView4;
    }

    public static ca a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ca b(@NonNull View view, @Nullable Object obj) {
        return (ca) ViewDataBinding.bind(obj, view, R.layout.item_edit_product);
    }

    @NonNull
    public static ca f(@NonNull LayoutInflater layoutInflater) {
        return i(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ca g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return h(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ca h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ca) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_edit_product, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ca i(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ca) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_edit_product, null, false, obj);
    }

    @Nullable
    public e.l.g.o0 c() {
        return this.f12423k;
    }

    @Nullable
    public GameCard d() {
        return this.f12424l;
    }

    @Nullable
    public Integer e() {
        return this.f12425m;
    }

    public abstract void j(@Nullable e.l.g.o0 o0Var);

    public abstract void k(@Nullable GameCard gameCard);

    public abstract void l(@Nullable Integer num);
}
