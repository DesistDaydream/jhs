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
import com.jihuanshe.ui.page.user.CoinActivity;
import com.jihuanshe.viewmodel.user.CoinViewModel;

/* loaded from: classes2.dex */
public abstract class uf extends ViewDataBinding {
    @NonNull
    public final TextView a;
    @Bindable
    public CoinActivity b;
    @Bindable

    /* renamed from: c  reason: collision with root package name */
    public CoinViewModel f13725c;

    public uf(Object obj, View view, int i2, TextView textView) {
        super(obj, view, i2);
        this.a = textView;
    }

    public static uf a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static uf b(@NonNull View view, @Nullable Object obj) {
        return (uf) ViewDataBinding.bind(obj, view, R.layout.view_header_coin);
    }

    @NonNull
    public static uf e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static uf f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static uf g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (uf) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_header_coin, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static uf h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (uf) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_header_coin, null, false, obj);
    }

    @Nullable
    public CoinActivity c() {
        return this.b;
    }

    @Nullable
    public CoinViewModel d() {
        return this.f13725c;
    }

    public abstract void i(@Nullable CoinActivity coinActivity);

    public abstract void j(@Nullable CoinViewModel coinViewModel);
}
