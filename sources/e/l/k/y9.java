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
import com.jihuanshe.model.ApplyForItem;
import com.jihuanshe.ui.page.entrepot.ConOrderDetailsActivity;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class y9 extends ViewDataBinding {
    @NonNull
    public final NImageView a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f13980c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f13981d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f13982e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f13983f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextView f13984g;
    @Bindable

    /* renamed from: h  reason: collision with root package name */
    public ConOrderDetailsActivity f13985h;
    @Bindable

    /* renamed from: i  reason: collision with root package name */
    public ApplyForItem f13986i;

    public y9(Object obj, View view, int i2, NImageView nImageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(obj, view, i2);
        this.a = nImageView;
        this.b = textView;
        this.f13980c = textView2;
        this.f13981d = textView3;
        this.f13982e = textView4;
        this.f13983f = textView5;
        this.f13984g = textView6;
    }

    public static y9 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static y9 b(@NonNull View view, @Nullable Object obj) {
        return (y9) ViewDataBinding.bind(obj, view, R.layout.item_con_order_detail);
    }

    @NonNull
    public static y9 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static y9 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static y9 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (y9) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_con_order_detail, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static y9 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (y9) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_con_order_detail, null, false, obj);
    }

    @Nullable
    public ApplyForItem c() {
        return this.f13986i;
    }

    @Nullable
    public ConOrderDetailsActivity getActivity() {
        return this.f13985h;
    }

    public abstract void h(@Nullable ConOrderDetailsActivity conOrderDetailsActivity);

    public abstract void i(@Nullable ApplyForItem applyForItem);
}
