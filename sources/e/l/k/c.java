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
import com.jihuanshe.ui.page.user.AccountManagerActivity;

/* loaded from: classes2.dex */
public abstract class c extends ViewDataBinding {
    @Bindable
    public AccountManagerActivity a;

    public c(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static c a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static c b(@NonNull View view, @Nullable Object obj) {
        return (c) ViewDataBinding.bind(obj, view, R.layout.activity_account_manager);
    }

    @NonNull
    public static c d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static c e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static c f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (c) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_account_manager, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static c g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (c) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_account_manager, null, false, obj);
    }

    @Nullable
    public AccountManagerActivity c() {
        return this.a;
    }

    public abstract void h(@Nullable AccountManagerActivity accountManagerActivity);
}
