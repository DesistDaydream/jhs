package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.widget.ReviewPopupWindow;

/* loaded from: classes2.dex */
public abstract class se extends ViewDataBinding {
    @NonNull
    public final TextView a;
    @Bindable
    public ReviewPopupWindow b;

    public se(Object obj, View view, int i2, TextView textView) {
        super(obj, view, i2);
        this.a = textView;
    }

    public static se a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static se b(@NonNull View view, @Nullable Object obj) {
        return (se) ViewDataBinding.bind(obj, view, R.layout.pop_review);
    }

    @NonNull
    public static se d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static se e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static se f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (se) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pop_review, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static se g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (se) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pop_review, null, false, obj);
    }

    @Nullable
    public ReviewPopupWindow c() {
        return this.b;
    }

    public abstract void h(@Nullable ReviewPopupWindow reviewPopupWindow);
}
