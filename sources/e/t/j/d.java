package e.t.j;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.vector.R;
import com.vector.view.SideBar;

/* loaded from: classes3.dex */
public abstract class d extends ViewDataBinding {
    @Bindable
    public SideBar a;

    public d(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static d a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static d b(@NonNull View view, @Nullable Object obj) {
        return (d) ViewDataBinding.bind(obj, view, R.layout.layout_side_bar_pop);
    }

    @NonNull
    public static d d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static d e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static d f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (d) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_side_bar_pop, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static d g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (d) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_side_bar_pop, null, false, obj);
    }

    @Nullable
    public SideBar c() {
        return this.a;
    }

    public abstract void h(@Nullable SideBar sideBar);
}
