package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.detail.CardPackListActivity;
import com.jihuanshe.ui.widget.FilterTextView;
import com.jihuanshe.ui.widget.RarityFilterBtn;
import com.jihuanshe.viewmodel.detail.CardPackListViewModel;

/* loaded from: classes2.dex */
public abstract class cf extends ViewDataBinding {
    @NonNull
    public final FilterTextView a;
    @NonNull
    public final LinearLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final RarityFilterBtn f12455c;
    @Bindable

    /* renamed from: d  reason: collision with root package name */
    public CardPackListActivity f12456d;
    @Bindable

    /* renamed from: e  reason: collision with root package name */
    public CardPackListViewModel f12457e;

    public cf(Object obj, View view, int i2, FilterTextView filterTextView, LinearLayout linearLayout, RarityFilterBtn rarityFilterBtn) {
        super(obj, view, i2);
        this.a = filterTextView;
        this.b = linearLayout;
        this.f12455c = rarityFilterBtn;
    }

    public static cf a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static cf b(@NonNull View view, @Nullable Object obj) {
        return (cf) ViewDataBinding.bind(obj, view, R.layout.view_filter_bar_card_pack);
    }

    @NonNull
    public static cf e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static cf f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static cf g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (cf) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_filter_bar_card_pack, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static cf h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (cf) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_filter_bar_card_pack, null, false, obj);
    }

    @Nullable
    public CardPackListViewModel c() {
        return this.f12457e;
    }

    @Nullable
    public CardPackListActivity d() {
        return this.f12456d;
    }

    public abstract void i(@Nullable CardPackListViewModel cardPackListViewModel);

    public abstract void j(@Nullable CardPackListActivity cardPackListActivity);
}
