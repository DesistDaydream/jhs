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
public abstract class sc extends ViewDataBinding {
    @NonNull
    public final TextView a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CardImageView f13565c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f13566d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f13567e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f13568f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextView f13569g;
    @Bindable

    /* renamed from: h  reason: collision with root package name */
    public e.l.g.c1.a f13570h;
    @Bindable

    /* renamed from: i  reason: collision with root package name */
    public Product f13571i;

    public sc(Object obj, View view, int i2, TextView textView, TextView textView2, CardImageView cardImageView, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(obj, view, i2);
        this.a = textView;
        this.b = textView2;
        this.f13565c = cardImageView;
        this.f13566d = textView3;
        this.f13567e = textView4;
        this.f13568f = textView5;
        this.f13569g = textView6;
    }

    public static sc a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static sc b(@NonNull View view, @Nullable Object obj) {
        return (sc) ViewDataBinding.bind(obj, view, R.layout.item_search_product);
    }

    @NonNull
    public static sc e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static sc f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static sc g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (sc) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_search_product, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static sc h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (sc) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_search_product, null, false, obj);
    }

    @Nullable
    public Product c() {
        return this.f13571i;
    }

    @Nullable
    public e.l.g.c1.a d() {
        return this.f13570h;
    }

    public abstract void i(@Nullable Product product);

    public abstract void j(@Nullable e.l.g.c1.a aVar);
}
