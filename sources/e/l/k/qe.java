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
import com.jihuanshe.ui.widget.PhonePopupWindow;

/* loaded from: classes2.dex */
public abstract class qe extends ViewDataBinding {
    @Bindable
    public PhonePopupWindow a;

    public qe(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static qe a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static qe b(@NonNull View view, @Nullable Object obj) {
        return (qe) ViewDataBinding.bind(obj, view, R.layout.pop_phone_bar);
    }

    @NonNull
    public static qe d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static qe e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static qe f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (qe) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pop_phone_bar, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static qe g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (qe) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pop_phone_bar, null, false, obj);
    }

    @Nullable
    public PhonePopupWindow c() {
        return this.a;
    }

    public abstract void h(@Nullable PhonePopupWindow phonePopupWindow);
}
