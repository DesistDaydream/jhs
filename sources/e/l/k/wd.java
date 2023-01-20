package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.Product;
import com.jihuanshe.ui.widget.CardImageView;

/* loaded from: classes2.dex */
public abstract class wd extends ViewDataBinding {
    @NonNull
    public final TextView a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CardImageView f13870c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f13871d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f13872e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f13873f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextView f13874g;
    @Bindable

    /* renamed from: h  reason: collision with root package name */
    public e.l.g.b1 f13875h;
    @Bindable

    /* renamed from: i  reason: collision with root package name */
    public Product f13876i;

    public wd(Object obj, View view, int i2, TextView textView, TextView textView2, CardImageView cardImageView, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(obj, view, i2);
        this.a = textView;
        this.b = textView2;
        this.f13870c = cardImageView;
        this.f13871d = textView3;
        this.f13872e = textView4;
        this.f13873f = textView5;
        this.f13874g = textView6;
    }

    public static wd a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static wd b(@NonNull View view, @Nullable Object obj) {
        return (wd) ViewDataBinding.bind(obj, view, R.layout.item_wish_product);
    }

    @NonNull
    public static wd e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static wd f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static wd g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (wd) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_wish_product, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static wd h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (wd) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_wish_product, null, false, obj);
    }

    @Nullable
    public Product c() {
        return this.f13876i;
    }

    @Nullable
    public e.l.g.b1 d() {
        return this.f13875h;
    }

    public abstract void i(@Nullable Product product);

    public abstract void j(@Nullable e.l.g.b1 b1Var);
}
