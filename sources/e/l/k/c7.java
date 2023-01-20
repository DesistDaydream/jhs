package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.entrepot.MineStorehouseFragment;
import com.jihuanshe.viewmodel.entrepot.MineStorehouseViewModel;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class c7 extends ViewDataBinding {
    @NonNull
    public final ListView a;
    @NonNull
    public final ListView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ListView f12407c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f12408d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f12409e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f12410f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextView f12411g;
    @Bindable

    /* renamed from: h  reason: collision with root package name */
    public MineStorehouseFragment f12412h;
    @Bindable

    /* renamed from: i  reason: collision with root package name */
    public MineStorehouseViewModel f12413i;

    public c7(Object obj, View view, int i2, ListView listView, ListView listView2, ListView listView3, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i2);
        this.a = listView;
        this.b = listView2;
        this.f12407c = listView3;
        this.f12408d = linearLayout;
        this.f12409e = textView;
        this.f12410f = textView2;
        this.f12411g = textView3;
    }

    public static c7 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static c7 b(@NonNull View view, @Nullable Object obj) {
        return (c7) ViewDataBinding.bind(obj, view, R.layout.fragment_mine_storehouse);
    }

    @NonNull
    public static c7 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static c7 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static c7 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (c7) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_mine_storehouse, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static c7 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (c7) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_mine_storehouse, null, false, obj);
    }

    @Nullable
    public MineStorehouseFragment c() {
        return this.f12412h;
    }

    @Nullable
    public MineStorehouseViewModel d() {
        return this.f12413i;
    }

    public abstract void i(@Nullable MineStorehouseFragment mineStorehouseFragment);

    public abstract void j(@Nullable MineStorehouseViewModel mineStorehouseViewModel);
}
