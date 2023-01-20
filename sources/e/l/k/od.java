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
import com.jihuanshe.model.RecentPhoto;

/* loaded from: classes2.dex */
public abstract class od extends ViewDataBinding {
    @Bindable
    public RecentPhoto a;

    public od(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static od a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static od b(@NonNull View view, @Nullable Object obj) {
        return (od) ViewDataBinding.bind(obj, view, R.layout.item_view_photo);
    }

    @NonNull
    public static od d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static od e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static od f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (od) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_view_photo, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static od g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (od) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_view_photo, null, false, obj);
    }

    @Nullable
    public RecentPhoto c() {
        return this.a;
    }

    public abstract void h(@Nullable RecentPhoto recentPhoto);
}
