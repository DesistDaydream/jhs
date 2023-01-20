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
import com.jihuanshe.adapter.AddressAdapter;
import com.jihuanshe.model.UserAddress;

/* loaded from: classes2.dex */
public abstract class q8 extends ViewDataBinding {
    @Bindable
    public AddressAdapter a;
    @Bindable
    public UserAddress b;

    public q8(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static q8 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static q8 b(@NonNull View view, @Nullable Object obj) {
        return (q8) ViewDataBinding.bind(obj, view, R.layout.item_address);
    }

    @NonNull
    public static q8 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static q8 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static q8 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (q8) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_address, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static q8 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (q8) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_address, null, false, obj);
    }

    @Nullable
    public UserAddress c() {
        return this.b;
    }

    @Nullable
    public AddressAdapter d() {
        return this.a;
    }

    public abstract void i(@Nullable UserAddress userAddress);

    public abstract void j(@Nullable AddressAdapter addressAdapter);
}
