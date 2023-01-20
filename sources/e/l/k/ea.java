package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;

/* loaded from: classes2.dex */
public abstract class ea extends ViewDataBinding {
    public ea(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static ea a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ea b(@NonNull View view, @Nullable Object obj) {
        return (ea) ViewDataBinding.bind(obj, view, R.layout.item_empty);
    }

    @NonNull
    public static ea c(@NonNull LayoutInflater layoutInflater) {
        return f(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ea d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return e(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ea e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ea) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_empty, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ea f(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ea) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_empty, null, false, obj);
    }
}
