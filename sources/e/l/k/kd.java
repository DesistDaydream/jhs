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
import com.jihuanshe.model.Category;

/* loaded from: classes2.dex */
public abstract class kd extends ViewDataBinding {
    @Bindable
    public Category a;
    @Bindable
    public Integer b;

    public kd(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static kd a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static kd b(@NonNull View view, @Nullable Object obj) {
        return (kd) ViewDataBinding.bind(obj, view, R.layout.item_title_kind);
    }

    @NonNull
    public static kd e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static kd f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static kd g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (kd) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_title_kind, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static kd h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (kd) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_title_kind, null, false, obj);
    }

    @Nullable
    public Category c() {
        return this.a;
    }

    @Nullable
    public Integer d() {
        return this.b;
    }

    public abstract void i(@Nullable Category category);

    public abstract void j(@Nullable Integer num);
}
