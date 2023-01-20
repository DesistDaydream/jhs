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
import com.jihuanshe.model.BankDetail;

/* loaded from: classes2.dex */
public abstract class c9 extends ViewDataBinding {
    @Bindable
    public BankDetail a;

    public c9(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static c9 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static c9 b(@NonNull View view, @Nullable Object obj) {
        return (c9) ViewDataBinding.bind(obj, view, R.layout.item_bank);
    }

    @NonNull
    public static c9 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static c9 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static c9 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (c9) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_bank, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static c9 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (c9) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_bank, null, false, obj);
    }

    @Nullable
    public BankDetail c() {
        return this.a;
    }

    public abstract void h(@Nullable BankDetail bankDetail);
}
