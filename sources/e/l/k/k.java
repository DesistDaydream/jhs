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
import com.jihuanshe.ui.page.order.AddressActivity;

/* loaded from: classes2.dex */
public abstract class k extends ViewDataBinding {
    @Bindable
    public AddressActivity a;
    @Bindable
    public e.l.s.j.a b;

    public k(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static k a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static k b(@NonNull View view, @Nullable Object obj) {
        return (k) ViewDataBinding.bind(obj, view, R.layout.activity_address);
    }

    @NonNull
    public static k e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static k f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static k g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (k) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_address, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static k h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (k) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_address, null, false, obj);
    }

    @Nullable
    public AddressActivity c() {
        return this.a;
    }

    @Nullable
    public e.l.s.j.a d() {
        return this.b;
    }

    public abstract void i(@Nullable AddressActivity addressActivity);

    public abstract void j(@Nullable e.l.s.j.a aVar);
}
