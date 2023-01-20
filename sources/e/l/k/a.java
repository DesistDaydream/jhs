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
import com.jihuanshe.ui.page.user.AboutActivity;

/* loaded from: classes2.dex */
public abstract class a extends ViewDataBinding {
    @Bindable
    public AboutActivity a;

    public a(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static a a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static a b(@NonNull View view, @Nullable Object obj) {
        return (a) ViewDataBinding.bind(obj, view, R.layout.activity_about);
    }

    @NonNull
    public static a d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static a e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static a f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (a) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_about, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static a g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (a) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_about, null, false, obj);
    }

    @Nullable
    public AboutActivity c() {
        return this.a;
    }

    public abstract void h(@Nullable AboutActivity aboutActivity);
}
