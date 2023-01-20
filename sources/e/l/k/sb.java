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
import kotlin.Pair;

/* loaded from: classes2.dex */
public abstract class sb extends ViewDataBinding {
    @Bindable
    public Pair<String, String> a;

    public sb(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static sb a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static sb b(@NonNull View view, @Nullable Object obj) {
        return (sb) ViewDataBinding.bind(obj, view, R.layout.item_pop_filter);
    }

    @NonNull
    public static sb d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static sb e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static sb f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (sb) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_pop_filter, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static sb g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (sb) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_pop_filter, null, false, obj);
    }

    @Nullable
    public Pair<String, String> c() {
        return this.a;
    }

    public abstract void h(@Nullable Pair<String, String> pair);
}
