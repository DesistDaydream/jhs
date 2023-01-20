package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;

/* loaded from: classes2.dex */
public abstract class kf extends ViewDataBinding {
    @NonNull
    public final AppCompatTextView a;

    public kf(Object obj, View view, int i2, AppCompatTextView appCompatTextView) {
        super(obj, view, i2);
        this.a = appCompatTextView;
    }

    public static kf a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static kf b(@NonNull View view, @Nullable Object obj) {
        return (kf) ViewDataBinding.bind(obj, view, R.layout.view_filter_tv);
    }

    @NonNull
    public static kf c(@NonNull LayoutInflater layoutInflater) {
        return f(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static kf d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return e(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static kf e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (kf) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_filter_tv, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static kf f(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (kf) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_filter_tv, null, false, obj);
    }
}
