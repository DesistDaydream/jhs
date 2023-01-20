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
import com.jihuanshe.ui.widget.WantBuyPopupWindow;

/* loaded from: classes2.dex */
public abstract class ue extends ViewDataBinding {
    @Bindable
    public WantBuyPopupWindow a;

    public ue(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static ue a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ue b(@NonNull View view, @Nullable Object obj) {
        return (ue) ViewDataBinding.bind(obj, view, R.layout.pop_want_buy);
    }

    @NonNull
    public static ue d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ue e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ue f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ue) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pop_want_buy, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ue g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ue) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pop_want_buy, null, false, obj);
    }

    @Nullable
    public WantBuyPopupWindow c() {
        return this.a;
    }

    public abstract void h(@Nullable WantBuyPopupWindow wantBuyPopupWindow);
}
