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
import com.jihuanshe.ui.page.search.fragments.wantcard.SearchWantCardListFragment;
import com.jihuanshe.viewmodel.user.WantCardListViewModel;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class c8 extends ViewDataBinding {
    @NonNull
    public final ListView a;
    @Bindable
    public SearchWantCardListFragment b;
    @Bindable

    /* renamed from: c  reason: collision with root package name */
    public WantCardListViewModel f12414c;

    public c8(Object obj, View view, int i2, ListView listView) {
        super(obj, view, i2);
        this.a = listView;
    }

    public static c8 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static c8 b(@NonNull View view, @Nullable Object obj) {
        return (c8) ViewDataBinding.bind(obj, view, R.layout.fragment_search_want_card_list);
    }

    @NonNull
    public static c8 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static c8 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static c8 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (c8) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_search_want_card_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static c8 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (c8) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_search_want_card_list, null, false, obj);
    }

    @Nullable
    public SearchWantCardListFragment c() {
        return this.b;
    }

    @Nullable
    public WantCardListViewModel d() {
        return this.f12414c;
    }

    public abstract void i(@Nullable SearchWantCardListFragment searchWantCardListFragment);

    public abstract void j(@Nullable WantCardListViewModel wantCardListViewModel);
}
