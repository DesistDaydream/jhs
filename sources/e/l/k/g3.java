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
import com.jihuanshe.ui.dialog.AddressDialog2;
import com.xres.address_selector.widget.address_selector.AddressSelectorView2;

/* loaded from: classes2.dex */
public abstract class g3 extends ViewDataBinding {
    @NonNull
    public final AddressSelectorView2 a;
    @Bindable
    public AddressDialog2 b;

    public g3(Object obj, View view, int i2, AddressSelectorView2 addressSelectorView2) {
        super(obj, view, i2);
        this.a = addressSelectorView2;
    }

    public static g3 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static g3 b(@NonNull View view, @Nullable Object obj) {
        return (g3) ViewDataBinding.bind(obj, view, R.layout.dialog_address2);
    }

    @NonNull
    public static g3 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static g3 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static g3 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (g3) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_address2, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static g3 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (g3) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_address2, null, false, obj);
    }

    @Nullable
    public AddressDialog2 c() {
        return this.b;
    }

    public abstract void h(@Nullable AddressDialog2 addressDialog2);
}
