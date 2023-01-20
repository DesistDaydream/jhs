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
import com.jihuanshe.ui.dialog.ListDialog;

/* loaded from: classes2.dex */
public abstract class e5 extends ViewDataBinding {
    @Bindable
    public ListDialog a;

    public e5(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static e5 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static e5 b(@NonNull View view, @Nullable Object obj) {
        return (e5) ViewDataBinding.bind(obj, view, R.layout.dialog_list);
    }

    @NonNull
    public static e5 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static e5 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static e5 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (e5) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static e5 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (e5) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_list, null, false, obj);
    }

    @Nullable
    public ListDialog c() {
        return this.a;
    }

    public abstract void h(@Nullable ListDialog listDialog);
}
