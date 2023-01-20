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
import com.jihuanshe.model.WarehouseProductInfo;
import com.jihuanshe.ui.page.entrepot.SearchChildCheckFragment;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class oc extends ViewDataBinding {
    @NonNull
    public final NImageView a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f13270c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f13271d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f13272e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f13273f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextView f13274g;
    @Bindable

    /* renamed from: h  reason: collision with root package name */
    public SearchChildCheckFragment f13275h;
    @Bindable

    /* renamed from: i  reason: collision with root package name */
    public WarehouseProductInfo f13276i;

    public oc(Object obj, View view, int i2, NImageView nImageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(obj, view, i2);
        this.a = nImageView;
        this.b = textView;
        this.f13270c = textView2;
        this.f13271d = textView3;
        this.f13272e = textView4;
        this.f13273f = textView5;
        this.f13274g = textView6;
    }

    public static oc a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static oc b(@NonNull View view, @Nullable Object obj) {
        return (oc) ViewDataBinding.bind(obj, view, R.layout.item_search_child_check);
    }

    @NonNull
    public static oc e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static oc f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static oc g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (oc) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_search_child_check, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static oc h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (oc) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_search_child_check, null, false, obj);
    }

    @Nullable
    public SearchChildCheckFragment c() {
        return this.f13275h;
    }

    @Nullable
    public WarehouseProductInfo d() {
        return this.f13276i;
    }

    public abstract void i(@Nullable SearchChildCheckFragment searchChildCheckFragment);

    public abstract void j(@Nullable WarehouseProductInfo warehouseProductInfo);
}
