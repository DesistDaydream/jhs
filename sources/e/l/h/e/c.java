package e.l.h.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.base.R;
import com.jihuanshe.base.ui.widget.ToastDialog;

/* loaded from: classes2.dex */
public abstract class c extends ViewDataBinding {
    @NonNull
    public final TextView a;
    @Bindable
    public ToastDialog b;

    public c(Object obj, View view, int i2, TextView textView) {
        super(obj, view, i2);
        this.a = textView;
    }

    public static c a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static c b(@NonNull View view, @Nullable Object obj) {
        return (c) ViewDataBinding.bind(obj, view, R.layout.layout_toast);
    }

    @NonNull
    public static c d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static c e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static c f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (c) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_toast, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static c g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (c) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_toast, null, false, obj);
    }

    @Nullable
    public ToastDialog c() {
        return this.b;
    }

    public abstract void h(@Nullable ToastDialog toastDialog);
}
