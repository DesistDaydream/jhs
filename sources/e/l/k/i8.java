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
import com.jihuanshe.ui.page.main.shop.ShopFragment;
import com.jihuanshe.ui.widget.CPHorizontalScrollView;
import com.jihuanshe.ui.widget.CustomShopIndicatorView;
import com.jihuanshe.viewmodel.main.shop.ShopViewModel;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class i8 extends ViewDataBinding {
    @NonNull
    public final CPHorizontalScrollView a;
    @NonNull
    public final CustomShopIndicatorView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ListView f12862c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f12863d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f12864e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f12865f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final LinearLayout f12866g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final LinearLayout f12867h;
    @Bindable

    /* renamed from: i  reason: collision with root package name */
    public ShopFragment f12868i;
    @Bindable

    /* renamed from: j  reason: collision with root package name */
    public ShopViewModel f12869j;

    public i8(Object obj, View view, int i2, CPHorizontalScrollView cPHorizontalScrollView, CustomShopIndicatorView customShopIndicatorView, ListView listView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5) {
        super(obj, view, i2);
        this.a = cPHorizontalScrollView;
        this.b = customShopIndicatorView;
        this.f12862c = listView;
        this.f12863d = linearLayout;
        this.f12864e = linearLayout2;
        this.f12865f = linearLayout3;
        this.f12866g = linearLayout4;
        this.f12867h = linearLayout5;
    }

    public static i8 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static i8 b(@NonNull View view, @Nullable Object obj) {
        return (i8) ViewDataBinding.bind(obj, view, R.layout.fragment_shop);
    }

    @NonNull
    public static i8 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static i8 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static i8 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (i8) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_shop, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static i8 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (i8) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_shop, null, false, obj);
    }

    @Nullable
    public ShopFragment c() {
        return this.f12868i;
    }

    @Nullable
    public ShopViewModel d() {
        return this.f12869j;
    }

    public abstract void i(@Nullable ShopFragment shopFragment);

    public abstract void j(@Nullable ShopViewModel shopViewModel);
}
