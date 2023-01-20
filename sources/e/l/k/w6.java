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
import com.jihuanshe.ui.page.im.LikeFragment;
import com.jihuanshe.viewmodel.im.LikeViewModel;

/* loaded from: classes2.dex */
public abstract class w6 extends ViewDataBinding {
    @Bindable
    public LikeFragment a;
    @Bindable
    public LikeViewModel b;

    public w6(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static w6 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static w6 b(@NonNull View view, @Nullable Object obj) {
        return (w6) ViewDataBinding.bind(obj, view, R.layout.fragment_like);
    }

    @NonNull
    public static w6 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static w6 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static w6 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (w6) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_like, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static w6 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (w6) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_like, null, false, obj);
    }

    @Nullable
    public LikeFragment c() {
        return this.a;
    }

    @Nullable
    public LikeViewModel d() {
        return this.b;
    }

    public abstract void i(@Nullable LikeFragment likeFragment);

    public abstract void j(@Nullable LikeViewModel likeViewModel);
}
