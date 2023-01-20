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
public abstract class ac extends ViewDataBinding {
    @Bindable
    public String a;

    public ac(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static ac a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ac b(@NonNull View view, @Nullable Object obj) {
        return (ac) ViewDataBinding.bind(obj, view, R.layout.item_pop_list);
    }

    @NonNull
    public static ac d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ac e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ac f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ac) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_pop_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ac g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ac) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_pop_list, null, false, obj);
    }

    @Nullable
    public String c() {
        return this.a;
    }

    public abstract void h(@Nullable String str);
}
