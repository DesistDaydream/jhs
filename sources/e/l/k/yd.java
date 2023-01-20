package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.widget.CoinPopupWindow;

/* loaded from: classes2.dex */
public abstract class yd extends ViewDataBinding {
    @Bindable
    public CoinPopupWindow a;

    public yd(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static yd a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static yd b(@NonNull View view, @Nullable Object obj) {
        return (yd) ViewDataBinding.bind(obj, view, R.layout.pop_coin);
    }

    @NonNull
    public static yd d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static yd e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static yd f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (yd) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pop_coin, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static yd g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (yd) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pop_coin, null, false, obj);
    }

    @Nullable
    public CoinPopupWindow c() {
        return this.a;
    }

    public abstract void h(@Nullable CoinPopupWindow coinPopupWindow);
}
