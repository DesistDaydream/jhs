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
public abstract class gd extends ViewDataBinding {
    @Bindable
    public e.l.g.w0 a;
    @Bindable
    public Pair<String, String> b;

    public gd(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static gd a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static gd b(@NonNull View view, @Nullable Object obj) {
        return (gd) ViewDataBinding.bind(obj, view, R.layout.item_sort);
    }

    @NonNull
    public static gd e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static gd f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static gd g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (gd) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_sort, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static gd h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (gd) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_sort, null, false, obj);
    }

    @Nullable
    public Pair<String, String> c() {
        return this.b;
    }

    @Nullable
    public e.l.g.w0 d() {
        return this.a;
    }

    public abstract void i(@Nullable Pair<String, String> pair);

    public abstract void j(@Nullable e.l.g.w0 w0Var);
}
