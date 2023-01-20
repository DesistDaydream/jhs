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
import com.jihuanshe.model.OrderReturnInfo;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class mb extends ViewDataBinding {
    @NonNull
    public final NImageView a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f13131c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f13132d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f13133e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f13134f;
    @Bindable

    /* renamed from: g  reason: collision with root package name */
    public OrderReturnInfo f13135g;

    public mb(Object obj, View view, int i2, NImageView nImageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, i2);
        this.a = nImageView;
        this.b = textView;
        this.f13131c = textView2;
        this.f13132d = textView3;
        this.f13133e = textView4;
        this.f13134f = textView5;
    }

    public static mb a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static mb b(@NonNull View view, @Nullable Object obj) {
        return (mb) ViewDataBinding.bind(obj, view, R.layout.item_order_return_product);
    }

    @NonNull
    public static mb d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static mb e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static mb f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (mb) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_order_return_product, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static mb g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (mb) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_order_return_product, null, false, obj);
    }

    @Nullable
    public OrderReturnInfo c() {
        return this.f13135g;
    }

    public abstract void h(@Nullable OrderReturnInfo orderReturnInfo);
}
