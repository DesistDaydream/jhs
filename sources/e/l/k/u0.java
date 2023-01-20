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
import com.jihuanshe.ui.page.user.FansActivity;
import com.jihuanshe.viewmodel.user.FansViewModel;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class u0 extends ViewDataBinding {
    @NonNull
    public final ListView a;
    @Bindable
    public FansActivity b;
    @Bindable

    /* renamed from: c  reason: collision with root package name */
    public FansViewModel f13664c;

    public u0(Object obj, View view, int i2, ListView listView) {
        super(obj, view, i2);
        this.a = listView;
    }

    public static u0 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static u0 b(@NonNull View view, @Nullable Object obj) {
        return (u0) ViewDataBinding.bind(obj, view, R.layout.activity_fans);
    }

    @NonNull
    public static u0 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static u0 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static u0 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (u0) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_fans, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static u0 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (u0) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_fans, null, false, obj);
    }

    @Nullable
    public FansActivity c() {
        return this.b;
    }

    @Nullable
    public FansViewModel d() {
        return this.f13664c;
    }

    public abstract void i(@Nullable FansActivity fansActivity);

    public abstract void j(@Nullable FansViewModel fansViewModel);
}
