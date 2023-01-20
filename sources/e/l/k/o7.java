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
import com.jihuanshe.ui.page.entrepot.SearchChildCheckFragment;
import com.jihuanshe.viewmodel.entrepot.SearchChildCheckViewModel;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class o7 extends ViewDataBinding {
    @NonNull
    public final ListView a;
    @Bindable
    public SearchChildCheckFragment b;
    @Bindable

    /* renamed from: c  reason: collision with root package name */
    public SearchChildCheckViewModel f13252c;

    public o7(Object obj, View view, int i2, ListView listView) {
        super(obj, view, i2);
        this.a = listView;
    }

    public static o7 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static o7 b(@NonNull View view, @Nullable Object obj) {
        return (o7) ViewDataBinding.bind(obj, view, R.layout.fragment_search_child_check);
    }

    @NonNull
    public static o7 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static o7 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static o7 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (o7) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_search_child_check, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static o7 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (o7) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_search_child_check, null, false, obj);
    }

    @Nullable
    public SearchChildCheckFragment c() {
        return this.b;
    }

    @Nullable
    public SearchChildCheckViewModel d() {
        return this.f13252c;
    }

    public abstract void i(@Nullable SearchChildCheckFragment searchChildCheckFragment);

    public abstract void j(@Nullable SearchChildCheckViewModel searchChildCheckViewModel);
}
