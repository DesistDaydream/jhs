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
import com.jihuanshe.ui.page.user.wish.WishListFragment;
import com.jihuanshe.viewmodel.user.wish.WishListViewModel;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class m8 extends ViewDataBinding {
    @NonNull
    public final ListView a;
    @Bindable
    public WishListFragment b;
    @Bindable

    /* renamed from: c  reason: collision with root package name */
    public WishListViewModel f13121c;

    public m8(Object obj, View view, int i2, ListView listView) {
        super(obj, view, i2);
        this.a = listView;
    }

    public static m8 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static m8 b(@NonNull View view, @Nullable Object obj) {
        return (m8) ViewDataBinding.bind(obj, view, R.layout.fragment_wish_list);
    }

    @NonNull
    public static m8 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static m8 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static m8 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (m8) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_wish_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static m8 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (m8) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_wish_list, null, false, obj);
    }

    @Nullable
    public WishListFragment c() {
        return this.b;
    }

    @Nullable
    public WishListViewModel d() {
        return this.f13121c;
    }

    public abstract void i(@Nullable WishListFragment wishListFragment);

    public abstract void j(@Nullable WishListViewModel wishListViewModel);
}
