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
import com.jihuanshe.ui.page.user.WantBuyMatchActivity;
import com.jihuanshe.viewmodel.user.WantBuyMatchViewModel;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class a3 extends ViewDataBinding {
    @NonNull
    public final ListView a;
    @Bindable
    public WantBuyMatchActivity b;
    @Bindable

    /* renamed from: c  reason: collision with root package name */
    public WantBuyMatchViewModel f12252c;

    public a3(Object obj, View view, int i2, ListView listView) {
        super(obj, view, i2);
        this.a = listView;
    }

    public static a3 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static a3 b(@NonNull View view, @Nullable Object obj) {
        return (a3) ViewDataBinding.bind(obj, view, R.layout.activity_want_buy_match);
    }

    @NonNull
    public static a3 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static a3 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static a3 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (a3) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_want_buy_match, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static a3 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (a3) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_want_buy_match, null, false, obj);
    }

    @Nullable
    public WantBuyMatchActivity c() {
        return this.b;
    }

    @Nullable
    public WantBuyMatchViewModel d() {
        return this.f12252c;
    }

    public abstract void i(@Nullable WantBuyMatchActivity wantBuyMatchActivity);

    public abstract void j(@Nullable WantBuyMatchViewModel wantBuyMatchViewModel);
}
