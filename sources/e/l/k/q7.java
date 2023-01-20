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
import com.jihuanshe.ui.page.entrepot.SearchChildNoPassFragment;
import com.jihuanshe.viewmodel.entrepot.SearchChildNoPassViewModel;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class q7 extends ViewDataBinding {
    @NonNull
    public final ListView a;
    @Bindable
    public SearchChildNoPassFragment b;
    @Bindable

    /* renamed from: c  reason: collision with root package name */
    public SearchChildNoPassViewModel f13424c;

    public q7(Object obj, View view, int i2, ListView listView) {
        super(obj, view, i2);
        this.a = listView;
    }

    public static q7 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static q7 b(@NonNull View view, @Nullable Object obj) {
        return (q7) ViewDataBinding.bind(obj, view, R.layout.fragment_search_child_no_pass);
    }

    @NonNull
    public static q7 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static q7 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static q7 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (q7) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_search_child_no_pass, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static q7 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (q7) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_search_child_no_pass, null, false, obj);
    }

    @Nullable
    public SearchChildNoPassFragment c() {
        return this.b;
    }

    @Nullable
    public SearchChildNoPassViewModel d() {
        return this.f13424c;
    }

    public abstract void i(@Nullable SearchChildNoPassFragment searchChildNoPassFragment);

    public abstract void j(@Nullable SearchChildNoPassViewModel searchChildNoPassViewModel);
}
