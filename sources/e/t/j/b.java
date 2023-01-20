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
import e.t.k.a.f.h;

/* loaded from: classes3.dex */
public abstract class b extends ViewDataBinding {
    @Bindable
    public h a;

    public b(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static b a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static b b(@NonNull View view, @Nullable Object obj) {
        return (b) ViewDataBinding.bind(obj, view, R.layout.layout_dialog_loading);
    }

    @NonNull
    public static b d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static b e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static b f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (b) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_dialog_loading, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static b g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (b) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_dialog_loading, null, false, obj);
    }

    @Nullable
    public h c() {
        return this.a;
    }

    public abstract void h(@Nullable h hVar);
}
