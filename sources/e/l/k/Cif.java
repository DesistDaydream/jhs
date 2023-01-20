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
import com.jihuanshe.ui.widget.FilterInfoBtn;
import com.jihuanshe.ui.widget.RarityFilterBtn;
import com.jihuanshe.viewmodel.user.SellerDetailViewModel;

/* renamed from: e.l.k.if  reason: invalid class name */
/* loaded from: classes2.dex */
public abstract class Cif extends ViewDataBinding {
    @NonNull
    public final TextView a;
    @NonNull
    public final FilterInfoBtn b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f12899c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final RarityFilterBtn f12900d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f12901e;
    @Bindable

    /* renamed from: f  reason: collision with root package name */
    public SellerDetailViewModel f12902f;

    public Cif(Object obj, View view, int i2, TextView textView, FilterInfoBtn filterInfoBtn, LinearLayout linearLayout, RarityFilterBtn rarityFilterBtn, TextView textView2) {
        super(obj, view, i2);
        this.a = textView;
        this.b = filterInfoBtn;
        this.f12899c = linearLayout;
        this.f12900d = rarityFilterBtn;
        this.f12901e = textView2;
    }

    public static Cif a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static Cif b(@NonNull View view, @Nullable Object obj) {
        return (Cif) ViewDataBinding.bind(obj, view, R.layout.view_filter_bar_user_shop);
    }

    @NonNull
    public static Cif d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static Cif e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static Cif f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (Cif) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_filter_bar_user_shop, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static Cif g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (Cif) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_filter_bar_user_shop, null, false, obj);
    }

    @Nullable
    public SellerDetailViewModel c() {
        return this.f12902f;
    }

    public abstract void h(@Nullable SellerDetailViewModel sellerDetailViewModel);
}
