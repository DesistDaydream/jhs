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
import com.jihuanshe.ui.page.user.BlackListActivity;
import com.jihuanshe.viewmodel.user.BlackListViewModel;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class m extends ViewDataBinding {
    @NonNull
    public final ListView a;
    @Bindable
    public BlackListActivity b;
    @Bindable

    /* renamed from: c  reason: collision with root package name */
    public BlackListViewModel f13096c;

    public m(Object obj, View view, int i2, ListView listView) {
        super(obj, view, i2);
        this.a = listView;
    }

    public static m a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static m b(@NonNull View view, @Nullable Object obj) {
        return (m) ViewDataBinding.bind(obj, view, R.layout.activity_black_list);
    }

    @NonNull
    public static m e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static m f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static m g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (m) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_black_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static m h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (m) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_black_list, null, false, obj);
    }

    @Nullable
    public BlackListActivity c() {
        return this.b;
    }

    @Nullable
    public BlackListViewModel d() {
        return this.f13096c;
    }

    public abstract void i(@Nullable BlackListActivity blackListActivity);

    public abstract void j(@Nullable BlackListViewModel blackListViewModel);
}
