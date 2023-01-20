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
import com.jihuanshe.ui.page.search.fragments.global.SearchUserFragment;
import com.jihuanshe.viewmodel.search.globals.SearchUserViewModel;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class a8 extends ViewDataBinding {
    @NonNull
    public final ListView a;
    @Bindable
    public SearchUserFragment b;
    @Bindable

    /* renamed from: c  reason: collision with root package name */
    public SearchUserViewModel f12274c;

    public a8(Object obj, View view, int i2, ListView listView) {
        super(obj, view, i2);
        this.a = listView;
    }

    public static a8 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static a8 b(@NonNull View view, @Nullable Object obj) {
        return (a8) ViewDataBinding.bind(obj, view, R.layout.fragment_search_user);
    }

    @NonNull
    public static a8 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static a8 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static a8 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (a8) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_search_user, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static a8 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (a8) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_search_user, null, false, obj);
    }

    @Nullable
    public SearchUserFragment c() {
        return this.b;
    }

    @Nullable
    public SearchUserViewModel d() {
        return this.f12274c;
    }

    public abstract void i(@Nullable SearchUserFragment searchUserFragment);

    public abstract void j(@Nullable SearchUserViewModel searchUserViewModel);
}
