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
import com.jihuanshe.ui.dialog.WantBuyDialog;

/* loaded from: classes2.dex */
public abstract class c6 extends ViewDataBinding {
    @Bindable
    public WantBuyDialog a;

    public c6(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static c6 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static c6 b(@NonNull View view, @Nullable Object obj) {
        return (c6) ViewDataBinding.bind(obj, view, R.layout.dialog_want_buy);
    }

    @NonNull
    public static c6 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static c6 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static c6 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (c6) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_want_buy, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static c6 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (c6) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_want_buy, null, false, obj);
    }

    @Nullable
    public WantBuyDialog c() {
        return this.a;
    }

    public abstract void h(@Nullable WantBuyDialog wantBuyDialog);
}
