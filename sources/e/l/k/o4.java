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
import com.jihuanshe.ui.dialog.DeleteDialog;

/* loaded from: classes2.dex */
public abstract class o4 extends ViewDataBinding {
    @Bindable
    public DeleteDialog a;

    public o4(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static o4 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static o4 b(@NonNull View view, @Nullable Object obj) {
        return (o4) ViewDataBinding.bind(obj, view, R.layout.dialog_delete);
    }

    @NonNull
    public static o4 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static o4 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static o4 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (o4) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_delete, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static o4 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (o4) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_delete, null, false, obj);
    }

    @Nullable
    public DeleteDialog c() {
        return this.a;
    }

    public abstract void h(@Nullable DeleteDialog deleteDialog);
}
