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
import com.jihuanshe.model.CoinLog;

/* loaded from: classes2.dex */
public abstract class w9 extends ViewDataBinding {
    @NonNull
    public final TextView a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f13849c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f13850d;
    @Bindable

    /* renamed from: e  reason: collision with root package name */
    public CoinLog f13851e;

    public w9(Object obj, View view, int i2, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i2);
        this.a = textView;
        this.b = textView2;
        this.f13849c = textView3;
        this.f13850d = textView4;
    }

    public static w9 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static w9 b(@NonNull View view, @Nullable Object obj) {
        return (w9) ViewDataBinding.bind(obj, view, R.layout.item_coin);
    }

    @NonNull
    public static w9 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static w9 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static w9 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (w9) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_coin, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static w9 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (w9) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_coin, null, false, obj);
    }

    @Nullable
    public CoinLog c() {
        return this.f13851e;
    }

    public abstract void h(@Nullable CoinLog coinLog);
}
