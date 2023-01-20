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
import com.jihuanshe.ui.dialog.AddressDialog3;
import com.xres.address_selector.widget.address_selector.AddressSelectorView3;

/* loaded from: classes2.dex */
public abstract class i3 extends ViewDataBinding {
    @NonNull
    public final AddressSelectorView3 a;
    @Bindable
    public AddressDialog3 b;

    public i3(Object obj, View view, int i2, AddressSelectorView3 addressSelectorView3) {
        super(obj, view, i2);
        this.a = addressSelectorView3;
    }

    public static i3 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static i3 b(@NonNull View view, @Nullable Object obj) {
        return (i3) ViewDataBinding.bind(obj, view, R.layout.dialog_address3);
    }

    @NonNull
    public static i3 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static i3 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static i3 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (i3) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_address3, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static i3 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (i3) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_address3, null, false, obj);
    }

    @Nullable
    public AddressDialog3 c() {
        return this.b;
    }

    public abstract void h(@Nullable AddressDialog3 addressDialog3);
}
