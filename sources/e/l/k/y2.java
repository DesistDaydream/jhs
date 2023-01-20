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
import com.jihuanshe.ui.page.user.WantBuyActivity;
import com.jihuanshe.viewmodel.user.WantBuyViewModel;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class y2 extends ViewDataBinding {
    @NonNull
    public final ListView a;
    @Bindable
    public WantBuyActivity b;
    @Bindable

    /* renamed from: c  reason: collision with root package name */
    public WantBuyViewModel f13948c;

    public y2(Object obj, View view, int i2, ListView listView) {
        super(obj, view, i2);
        this.a = listView;
    }

    public static y2 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static y2 b(@NonNull View view, @Nullable Object obj) {
        return (y2) ViewDataBinding.bind(obj, view, R.layout.activity_want_buy);
    }

    @NonNull
    public static y2 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static y2 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static y2 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (y2) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_want_buy, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static y2 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (y2) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_want_buy, null, false, obj);
    }

    @Nullable
    public WantBuyActivity c() {
        return this.b;
    }

    @Nullable
    public WantBuyViewModel d() {
        return this.f13948c;
    }

    public abstract void i(@Nullable WantBuyActivity wantBuyActivity);

    public abstract void j(@Nullable WantBuyViewModel wantBuyViewModel);
}
