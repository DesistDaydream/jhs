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

/* loaded from: classes2.dex */
public abstract class ub extends ViewDataBinding {
    @Bindable
    public e.l.s.a a;

    public ub(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static ub a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ub b(@NonNull View view, @Nullable Object obj) {
        return (ub) ViewDataBinding.bind(obj, view, R.layout.item_pop_filter_info);
    }

    @NonNull
    public static ub d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ub e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ub f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ub) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_pop_filter_info, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ub g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ub) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_pop_filter_info, null, false, obj);
    }

    @Nullable
    public e.l.s.a c() {
        return this.a;
    }

    public abstract void h(@Nullable e.l.s.a aVar);
}
