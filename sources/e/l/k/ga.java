package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;

/* loaded from: classes2.dex */
public abstract class ga extends ViewDataBinding {
    public ga(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static ga a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ga b(@NonNull View view, @Nullable Object obj) {
        return (ga) ViewDataBinding.bind(obj, view, R.layout.item_empty_white);
    }

    @NonNull
    public static ga c(@NonNull LayoutInflater layoutInflater) {
        return f(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ga d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return e(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ga e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ga) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_empty_white, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ga f(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ga) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_empty_white, null, false, obj);
    }
}
