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
import com.jihuanshe.ui.dialog.BackGoodReasonDialog;

/* loaded from: classes2.dex */
public abstract class k3 extends ViewDataBinding {
    @Bindable
    public BackGoodReasonDialog a;

    public k3(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static k3 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static k3 b(@NonNull View view, @Nullable Object obj) {
        return (k3) ViewDataBinding.bind(obj, view, R.layout.dialog_back_good_reason);
    }

    @NonNull
    public static k3 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static k3 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static k3 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (k3) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_back_good_reason, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static k3 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (k3) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_back_good_reason, null, false, obj);
    }

    @Nullable
    public BackGoodReasonDialog c() {
        return this.a;
    }

    public abstract void h(@Nullable BackGoodReasonDialog backGoodReasonDialog);
}
