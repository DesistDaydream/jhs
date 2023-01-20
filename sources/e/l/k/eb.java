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
import com.jihuanshe.model.SoldProductInfo;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class eb extends ViewDataBinding {
    @NonNull
    public final NImageView a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f12572c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f12573d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f12574e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f12575f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextView f12576g;
    @Bindable

    /* renamed from: h  reason: collision with root package name */
    public SoldProductInfo f12577h;

    public eb(Object obj, View view, int i2, NImageView nImageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(obj, view, i2);
        this.a = nImageView;
        this.b = textView;
        this.f12572c = textView2;
        this.f12573d = textView3;
        this.f12574e = textView4;
        this.f12575f = textView5;
        this.f12576g = textView6;
    }

    public static eb a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static eb b(@NonNull View view, @Nullable Object obj) {
        return (eb) ViewDataBinding.bind(obj, view, R.layout.item_mine_storehouse_sold);
    }

    @NonNull
    public static eb d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static eb e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static eb f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (eb) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_mine_storehouse_sold, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static eb g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (eb) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_mine_storehouse_sold, null, false, obj);
    }

    @Nullable
    public SoldProductInfo c() {
        return this.f12577h;
    }

    public abstract void h(@Nullable SoldProductInfo soldProductInfo);
}
