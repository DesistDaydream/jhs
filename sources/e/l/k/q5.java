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
import com.jihuanshe.ui.dialog.SellerCancelReasonDialog;

/* loaded from: classes2.dex */
public abstract class q5 extends ViewDataBinding {
    @Bindable
    public SellerCancelReasonDialog a;

    public q5(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static q5 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static q5 b(@NonNull View view, @Nullable Object obj) {
        return (q5) ViewDataBinding.bind(obj, view, R.layout.dialog_seller_cancel_reason);
    }

    @NonNull
    public static q5 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static q5 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static q5 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (q5) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_seller_cancel_reason, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static q5 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (q5) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_seller_cancel_reason, null, false, obj);
    }

    @Nullable
    public SellerCancelReasonDialog c() {
        return this.a;
    }

    public abstract void h(@Nullable SellerCancelReasonDialog sellerCancelReasonDialog);
}
