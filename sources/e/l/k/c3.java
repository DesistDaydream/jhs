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
import com.jihuanshe.ui.page.user.WantCardListActivity;
import com.jihuanshe.viewmodel.user.WantCardListViewModel;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class c3 extends ViewDataBinding {
    @NonNull
    public final ListView a;
    @NonNull
    public final LinearLayout b;
    @Bindable

    /* renamed from: c  reason: collision with root package name */
    public WantCardListActivity f12394c;
    @Bindable

    /* renamed from: d  reason: collision with root package name */
    public WantCardListViewModel f12395d;

    public c3(Object obj, View view, int i2, ListView listView, LinearLayout linearLayout) {
        super(obj, view, i2);
        this.a = listView;
        this.b = linearLayout;
    }

    public static c3 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static c3 b(@NonNull View view, @Nullable Object obj) {
        return (c3) ViewDataBinding.bind(obj, view, R.layout.activity_want_card_list);
    }

    @NonNull
    public static c3 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static c3 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static c3 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (c3) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_want_card_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static c3 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (c3) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_want_card_list, null, false, obj);
    }

    @Nullable
    public WantCardListActivity c() {
        return this.f12394c;
    }

    @Nullable
    public WantCardListViewModel d() {
        return this.f12395d;
    }

    public abstract void i(@Nullable WantCardListActivity wantCardListActivity);

    public abstract void j(@Nullable WantCardListViewModel wantCardListViewModel);
}
