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
import com.jihuanshe.ui.widget.ConditionPopupWindow;

/* loaded from: classes2.dex */
public abstract class ae extends ViewDataBinding {
    @Bindable
    public ConditionPopupWindow a;

    public ae(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static ae a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ae b(@NonNull View view, @Nullable Object obj) {
        return (ae) ViewDataBinding.bind(obj, view, R.layout.pop_condition);
    }

    @NonNull
    public static ae d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ae e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ae f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ae) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pop_condition, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ae g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ae) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pop_condition, null, false, obj);
    }

    @Nullable
    public ConditionPopupWindow c() {
        return this.a;
    }

    public abstract void h(@Nullable ConditionPopupWindow conditionPopupWindow);
}
