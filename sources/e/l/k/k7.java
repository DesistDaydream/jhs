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
import com.jihuanshe.ui.page.im.ReplyMeFragment;
import com.jihuanshe.viewmodel.im.ReplyMeViewModel;

/* loaded from: classes2.dex */
public abstract class k7 extends ViewDataBinding {
    @Bindable
    public ReplyMeFragment a;
    @Bindable
    public ReplyMeViewModel b;

    public k7(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static k7 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static k7 b(@NonNull View view, @Nullable Object obj) {
        return (k7) ViewDataBinding.bind(obj, view, R.layout.fragment_reply_me);
    }

    @NonNull
    public static k7 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static k7 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static k7 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (k7) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_reply_me, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static k7 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (k7) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_reply_me, null, false, obj);
    }

    @Nullable
    public ReplyMeFragment c() {
        return this.a;
    }

    @Nullable
    public ReplyMeViewModel d() {
        return this.b;
    }

    public abstract void i(@Nullable ReplyMeFragment replyMeFragment);

    public abstract void j(@Nullable ReplyMeViewModel replyMeViewModel);
}
