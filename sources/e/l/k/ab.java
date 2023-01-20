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
import com.jihuanshe.ui.page.entrepot.MineStorehouseFragment;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class ab extends ViewDataBinding {
    @NonNull
    public final NImageView a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f12284c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f12285d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f12286e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f12287f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextView f12288g;
    @Bindable

    /* renamed from: h  reason: collision with root package name */
    public MineStorehouseFragment f12289h;
    @Bindable

    /* renamed from: i  reason: collision with root package name */
    public WarehouseProductInfo f12290i;

    public ab(Object obj, View view, int i2, NImageView nImageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(obj, view, i2);
        this.a = nImageView;
        this.b = textView;
        this.f12284c = textView2;
        this.f12285d = textView3;
        this.f12286e = textView4;
        this.f12287f = textView5;
        this.f12288g = textView6;
    }

    public static ab a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ab b(@NonNull View view, @Nullable Object obj) {
        return (ab) ViewDataBinding.bind(obj, view, R.layout.item_mine_storehouse);
    }

    @NonNull
    public static ab e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ab f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ab g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ab) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_mine_storehouse, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ab h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ab) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_mine_storehouse, null, false, obj);
    }

    @Nullable
    public MineStorehouseFragment c() {
        return this.f12289h;
    }

    @Nullable
    public WarehouseProductInfo d() {
        return this.f12290i;
    }

    public abstract void i(@Nullable MineStorehouseFragment mineStorehouseFragment);

    public abstract void j(@Nullable WarehouseProductInfo warehouseProductInfo);
}
