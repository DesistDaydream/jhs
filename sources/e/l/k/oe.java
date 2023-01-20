package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.widget.OnePopupWindow;

/* loaded from: classes2.dex */
public abstract class oe extends ViewDataBinding {
    @NonNull
    public final LinearLayout a;
    @Bindable
    public OnePopupWindow b;

    public oe(Object obj, View view, int i2, LinearLayout linearLayout) {
        super(obj, view, i2);
        this.a = linearLayout;
    }

    public static oe a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static oe b(@NonNull View view, @Nullable Object obj) {
        return (oe) ViewDataBinding.bind(obj, view, R.layout.pop_one);
    }

    @NonNull
    public static oe d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static oe e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static oe f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (oe) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pop_one, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static oe g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (oe) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pop_one, null, false, obj);
    }

    @Nullable
    public OnePopupWindow c() {
        return this.b;
    }

    public abstract void h(@Nullable OnePopupWindow onePopupWindow);
}
