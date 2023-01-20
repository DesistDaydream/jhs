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
import com.jihuanshe.ui.page.user.WantBuyMatchActivity;

/* loaded from: classes2.dex */
public abstract class wf extends ViewDataBinding {
    @Bindable
    public WantBuyMatchActivity a;

    public wf(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static wf a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static wf b(@NonNull View view, @Nullable Object obj) {
        return (wf) ViewDataBinding.bind(obj, view, R.layout.view_header_match);
    }

    @NonNull
    public static wf d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static wf e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static wf f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (wf) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_header_match, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static wf g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (wf) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_header_match, null, false, obj);
    }

    @Nullable
    public WantBuyMatchActivity c() {
        return this.a;
    }

    public abstract void h(@Nullable WantBuyMatchActivity wantBuyMatchActivity);
}
