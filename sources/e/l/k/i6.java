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
import com.jihuanshe.ui.page.im.AtMeFragment;
import com.jihuanshe.viewmodel.im.AtMeViewModel;

/* loaded from: classes2.dex */
public abstract class i6 extends ViewDataBinding {
    @Bindable
    public AtMeFragment a;
    @Bindable
    public AtMeViewModel b;

    public i6(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static i6 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static i6 b(@NonNull View view, @Nullable Object obj) {
        return (i6) ViewDataBinding.bind(obj, view, R.layout.fragment_at_me);
    }

    @NonNull
    public static i6 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static i6 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static i6 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (i6) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_at_me, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static i6 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (i6) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_at_me, null, false, obj);
    }

    @Nullable
    public AtMeFragment c() {
        return this.a;
    }

    @Nullable
    public AtMeViewModel d() {
        return this.b;
    }

    public abstract void i(@Nullable AtMeFragment atMeFragment);

    public abstract void j(@Nullable AtMeViewModel atMeViewModel);
}
