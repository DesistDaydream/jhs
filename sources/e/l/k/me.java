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
import com.jihuanshe.ui.widget.InteractPopupWindow;

/* loaded from: classes2.dex */
public abstract class me extends ViewDataBinding {
    @NonNull
    public final LinearLayout a;
    @Bindable
    public InteractPopupWindow b;

    public me(Object obj, View view, int i2, LinearLayout linearLayout) {
        super(obj, view, i2);
        this.a = linearLayout;
    }

    public static me a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static me b(@NonNull View view, @Nullable Object obj) {
        return (me) ViewDataBinding.bind(obj, view, R.layout.pop_interact);
    }

    @NonNull
    public static me d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static me e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static me f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (me) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pop_interact, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static me g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (me) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pop_interact, null, false, obj);
    }

    @Nullable
    public InteractPopupWindow c() {
        return this.b;
    }

    public abstract void h(@Nullable InteractPopupWindow interactPopupWindow);
}
