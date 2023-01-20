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
import com.jihuanshe.ui.dialog.BuyerCancelReasonDialog;

/* loaded from: classes2.dex */
public abstract class o3 extends ViewDataBinding {
    @Bindable
    public BuyerCancelReasonDialog a;

    public o3(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static o3 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static o3 b(@NonNull View view, @Nullable Object obj) {
        return (o3) ViewDataBinding.bind(obj, view, R.layout.dialog_buyer_cancel_reason);
    }

    @NonNull
    public static o3 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static o3 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static o3 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (o3) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_buyer_cancel_reason, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static o3 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (o3) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_buyer_cancel_reason, null, false, obj);
    }

    @Nullable
    public BuyerCancelReasonDialog c() {
        return this.a;
    }

    public abstract void h(@Nullable BuyerCancelReasonDialog buyerCancelReasonDialog);
}
