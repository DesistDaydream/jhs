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
public abstract class ua extends ViewDataBinding {
    @Bindable
    public Category a;
    @Bindable
    public Boolean b;

    public ua(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static ua a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ua b(@NonNull View view, @Nullable Object obj) {
        return (ua) ViewDataBinding.bind(obj, view, R.layout.item_kind);
    }

    @NonNull
    public static ua e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ua f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ua g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ua) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_kind, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ua h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ua) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_kind, null, false, obj);
    }

    @Nullable
    public Category c() {
        return this.a;
    }

    @Nullable
    public Boolean d() {
        return this.b;
    }

    public abstract void i(@Nullable Category category);

    public abstract void j(@Nullable Boolean bool);
}
