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
public abstract class q6 extends ViewDataBinding {
    public q6(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static q6 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static q6 b(@NonNull View view, @Nullable Object obj) {
        return (q6) ViewDataBinding.bind(obj, view, R.layout.fragment_empty);
    }

    @NonNull
    public static q6 c(@NonNull LayoutInflater layoutInflater) {
        return f(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static q6 d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return e(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static q6 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (q6) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_empty, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static q6 f(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (q6) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_empty, null, false, obj);
    }
}
