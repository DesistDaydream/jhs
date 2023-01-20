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
import com.jihuanshe.ui.page.user.CoinActivity;
import com.jihuanshe.viewmodel.user.CoinViewModel;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class c0 extends ViewDataBinding {
    @NonNull
    public final ListView a;
    @Bindable
    public CoinActivity b;
    @Bindable

    /* renamed from: c  reason: collision with root package name */
    public CoinViewModel f12382c;

    public c0(Object obj, View view, int i2, ListView listView) {
        super(obj, view, i2);
        this.a = listView;
    }

    public static c0 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static c0 b(@NonNull View view, @Nullable Object obj) {
        return (c0) ViewDataBinding.bind(obj, view, R.layout.activity_coin);
    }

    @NonNull
    public static c0 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static c0 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static c0 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (c0) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_coin, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static c0 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (c0) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_coin, null, false, obj);
    }

    @Nullable
    public CoinActivity c() {
        return this.b;
    }

    @Nullable
    public CoinViewModel d() {
        return this.f12382c;
    }

    public abstract void i(@Nullable CoinActivity coinActivity);

    public abstract void j(@Nullable CoinViewModel coinViewModel);
}
