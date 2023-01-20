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
import com.jihuanshe.ui.page.main.shop.ShopFragment;
import com.jihuanshe.ui.widget.FilterTextView;
import com.jihuanshe.ui.widget.RarityFilterBtn;
import com.jihuanshe.viewmodel.main.shop.ShopViewModel;

/* loaded from: classes2.dex */
public abstract class gf extends ViewDataBinding {
    @NonNull
    public final TextView a;
    @NonNull
    public final FilterTextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f12745c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final RarityFilterBtn f12746d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f12747e;
    @Bindable

    /* renamed from: f  reason: collision with root package name */
    public ShopFragment f12748f;
    @Bindable

    /* renamed from: g  reason: collision with root package name */
    public ShopViewModel f12749g;
    @Bindable

    /* renamed from: h  reason: collision with root package name */
    public e.l.s.c f12750h;

    public gf(Object obj, View view, int i2, TextView textView, FilterTextView filterTextView, LinearLayout linearLayout, RarityFilterBtn rarityFilterBtn, TextView textView2) {
        super(obj, view, i2);
        this.a = textView;
        this.b = filterTextView;
        this.f12745c = linearLayout;
        this.f12746d = rarityFilterBtn;
        this.f12747e = textView2;
    }

    public static gf a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static gf b(@NonNull View view, @Nullable Object obj) {
        return (gf) ViewDataBinding.bind(obj, view, R.layout.view_filter_bar_shop_home);
    }

    @NonNull
    public static gf f(@NonNull LayoutInflater layoutInflater) {
        return i(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static gf g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return h(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static gf h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (gf) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_filter_bar_shop_home, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static gf i(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (gf) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_filter_bar_shop_home, null, false, obj);
    }

    @Nullable
    public e.l.s.c c() {
        return this.f12750h;
    }

    @Nullable
    public ShopFragment d() {
        return this.f12748f;
    }

    @Nullable
    public ShopViewModel e() {
        return this.f12749g;
    }

    public abstract void j(@Nullable e.l.s.c cVar);

    public abstract void k(@Nullable ShopFragment shopFragment);

    public abstract void l(@Nullable ShopViewModel shopViewModel);
}
