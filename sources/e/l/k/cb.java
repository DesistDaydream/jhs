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
import com.jihuanshe.model.FailProductInfo;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class cb extends ViewDataBinding {
    @NonNull
    public final NImageView a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f12426c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f12427d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f12428e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f12429f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextView f12430g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TextView f12431h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final TextView f12432i;
    @Bindable

    /* renamed from: j  reason: collision with root package name */
    public FailProductInfo f12433j;

    public cb(Object obj, View view, int i2, NImageView nImageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        super(obj, view, i2);
        this.a = nImageView;
        this.b = textView;
        this.f12426c = textView2;
        this.f12427d = textView3;
        this.f12428e = textView4;
        this.f12429f = textView5;
        this.f12430g = textView6;
        this.f12431h = textView7;
        this.f12432i = textView8;
    }

    public static cb a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static cb b(@NonNull View view, @Nullable Object obj) {
        return (cb) ViewDataBinding.bind(obj, view, R.layout.item_mine_storehouse_fail);
    }

    @NonNull
    public static cb d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static cb e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static cb f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (cb) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_mine_storehouse_fail, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static cb g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (cb) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_mine_storehouse_fail, null, false, obj);
    }

    @Nullable
    public FailProductInfo c() {
        return this.f12433j;
    }

    public abstract void h(@Nullable FailProductInfo failProductInfo);
}
