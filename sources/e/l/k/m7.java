package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.search.fragments.cardrepo.CardRepoSearchFragment;
import com.jihuanshe.ui.widget.RarityFilterBtn;
import com.jihuanshe.viewmodel.search.cardrepo.CardRepoSearchViewModel;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class m7 extends ViewDataBinding {
    @NonNull
    public final FrameLayout a;
    @NonNull
    public final ListView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final RarityFilterBtn f13118c;
    @Bindable

    /* renamed from: d  reason: collision with root package name */
    public CardRepoSearchFragment f13119d;
    @Bindable

    /* renamed from: e  reason: collision with root package name */
    public CardRepoSearchViewModel f13120e;

    public m7(Object obj, View view, int i2, FrameLayout frameLayout, ListView listView, RarityFilterBtn rarityFilterBtn) {
        super(obj, view, i2);
        this.a = frameLayout;
        this.b = listView;
        this.f13118c = rarityFilterBtn;
    }

    public static m7 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static m7 b(@NonNull View view, @Nullable Object obj) {
        return (m7) ViewDataBinding.bind(obj, view, R.layout.fragment_search_card_repo);
    }

    @NonNull
    public static m7 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static m7 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static m7 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (m7) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_search_card_repo, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static m7 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (m7) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_search_card_repo, null, false, obj);
    }

    @Nullable
    public CardRepoSearchFragment c() {
        return this.f13119d;
    }

    @Nullable
    public CardRepoSearchViewModel d() {
        return this.f13120e;
    }

    public abstract void i(@Nullable CardRepoSearchFragment cardRepoSearchFragment);

    public abstract void j(@Nullable CardRepoSearchViewModel cardRepoSearchViewModel);
}
