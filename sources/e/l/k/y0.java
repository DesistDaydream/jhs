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
import com.jihuanshe.ui.page.user.HelpActivity;

/* loaded from: classes2.dex */
public abstract class y0 extends ViewDataBinding {
    @Bindable
    public HelpActivity a;

    public y0(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static y0 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static y0 b(@NonNull View view, @Nullable Object obj) {
        return (y0) ViewDataBinding.bind(obj, view, R.layout.activity_help);
    }

    @NonNull
    public static y0 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static y0 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static y0 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (y0) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_help, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static y0 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (y0) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_help, null, false, obj);
    }

    @Nullable
    public HelpActivity c() {
        return this.a;
    }

    public abstract void h(@Nullable HelpActivity helpActivity);
}
