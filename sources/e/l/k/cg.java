package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.entrepot.MineStorehouseFragment;
import com.jihuanshe.viewmodel.entrepot.MineStorehouseViewModel;

/* loaded from: classes2.dex */
public abstract class cg extends ViewDataBinding {
    @NonNull
    public final TextView a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f12458c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f12459d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f12460e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f12461f;
    @Bindable

    /* renamed from: g  reason: collision with root package name */
    public MineStorehouseFragment f12462g;
    @Bindable

    /* renamed from: h  reason: collision with root package name */
    public MineStorehouseViewModel f12463h;

    public cg(Object obj, View view, int i2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(obj, view, i2);
        this.a = textView;
        this.b = textView2;
        this.f12458c = textView3;
        this.f12459d = textView4;
        this.f12460e = textView5;
        this.f12461f = textView6;
    }

    public static cg a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static cg b(@NonNull View view, @Nullable Object obj) {
        return (cg) ViewDataBinding.bind(obj, view, R.layout.view_header_storehouse_left);
    }

    @NonNull
    public static cg e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static cg f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static cg g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (cg) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_header_storehouse_left, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static cg h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (cg) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_header_storehouse_left, null, false, obj);
    }

    @Nullable
    public MineStorehouseFragment c() {
        return this.f12462g;
    }

    @Nullable
    public MineStorehouseViewModel d() {
        return this.f12463h;
    }

    public abstract void i(@Nullable MineStorehouseFragment mineStorehouseFragment);

    public abstract void j(@Nullable MineStorehouseViewModel mineStorehouseViewModel);
}
