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
import com.jihuanshe.model.OrderInfo;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class ib extends ViewDataBinding {
    @NonNull
    public final NImageView a;
    @NonNull
    public final NImageView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final View f12881c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f12882d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f12883e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f12884f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f12885g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TextView f12886h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final TextView f12887i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final TextView f12888j;
    @Bindable

    /* renamed from: k  reason: collision with root package name */
    public e.l.g.k0 f12889k;
    @Bindable

    /* renamed from: l  reason: collision with root package name */
    public OrderInfo f12890l;

    public ib(Object obj, View view, int i2, NImageView nImageView, NImageView nImageView2, View view2, TextView textView, TextView textView2, TextView textView3, ImageView imageView, TextView textView4, TextView textView5, TextView textView6) {
        super(obj, view, i2);
        this.a = nImageView;
        this.b = nImageView2;
        this.f12881c = view2;
        this.f12882d = textView;
        this.f12883e = textView2;
        this.f12884f = textView3;
        this.f12885g = imageView;
        this.f12886h = textView4;
        this.f12887i = textView5;
        this.f12888j = textView6;
    }

    public static ib a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ib b(@NonNull View view, @Nullable Object obj) {
        return (ib) ViewDataBinding.bind(obj, view, R.layout.item_order);
    }

    @NonNull
    public static ib e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ib f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ib g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ib) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_order, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ib h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ib) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_order, null, false, obj);
    }

    @Nullable
    public e.l.g.k0 c() {
        return this.f12889k;
    }

    @Nullable
    public OrderInfo d() {
        return this.f12890l;
    }

    public abstract void i(@Nullable e.l.g.k0 k0Var);

    public abstract void j(@Nullable OrderInfo orderInfo);
}
