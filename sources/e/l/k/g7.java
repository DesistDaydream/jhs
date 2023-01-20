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
import com.jihuanshe.ui.page.rank.RankListFragment;
import com.jihuanshe.viewmodel.rank.RankListViewModel;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class g7 extends ViewDataBinding {
    @NonNull
    public final ListView a;
    @Bindable
    public RankListFragment b;
    @Bindable

    /* renamed from: c  reason: collision with root package name */
    public RankListViewModel f12725c;

    public g7(Object obj, View view, int i2, ListView listView) {
        super(obj, view, i2);
        this.a = listView;
    }

    public static g7 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static g7 b(@NonNull View view, @Nullable Object obj) {
        return (g7) ViewDataBinding.bind(obj, view, R.layout.fragment_rank_list);
    }

    @NonNull
    public static g7 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static g7 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static g7 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (g7) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_rank_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static g7 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (g7) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_rank_list, null, false, obj);
    }

    @Nullable
    public RankListFragment c() {
        return this.b;
    }

    @Nullable
    public RankListViewModel d() {
        return this.f12725c;
    }

    public abstract void i(@Nullable RankListFragment rankListFragment);

    public abstract void j(@Nullable RankListViewModel rankListViewModel);
}
