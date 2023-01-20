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
import com.jihuanshe.ui.widget.CopyPopupWindow;

/* loaded from: classes2.dex */
public abstract class ce extends ViewDataBinding {
    @Bindable
    public CopyPopupWindow a;

    public ce(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static ce a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ce b(@NonNull View view, @Nullable Object obj) {
        return (ce) ViewDataBinding.bind(obj, view, R.layout.pop_copy);
    }

    @NonNull
    public static ce d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ce e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ce f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ce) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pop_copy, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ce g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ce) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pop_copy, null, false, obj);
    }

    @Nullable
    public CopyPopupWindow c() {
        return this.a;
    }

    public abstract void h(@Nullable CopyPopupWindow copyPopupWindow);
}
