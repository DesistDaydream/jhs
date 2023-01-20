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
import com.jihuanshe.model.ChooseItem;

/* loaded from: classes2.dex */
public abstract class u9 extends ViewDataBinding {
    @Bindable
    public ChooseItem a;

    public u9(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static u9 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static u9 b(@NonNull View view, @Nullable Object obj) {
        return (u9) ViewDataBinding.bind(obj, view, R.layout.item_choose_new);
    }

    @NonNull
    public static u9 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static u9 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static u9 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (u9) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_choose_new, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static u9 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (u9) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_choose_new, null, false, obj);
    }

    @Nullable
    public ChooseItem c() {
        return this.a;
    }

    public abstract void h(@Nullable ChooseItem chooseItem);
}
