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
public abstract class id extends ViewDataBinding {
    public id(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static id a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static id b(@NonNull View view, @Nullable Object obj) {
        return (id) ViewDataBinding.bind(obj, view, R.layout.item_star);
    }

    @NonNull
    public static id c(@NonNull LayoutInflater layoutInflater) {
        return f(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static id d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return e(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static id e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (id) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_star, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static id f(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (id) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_star, null, false, obj);
    }
}
