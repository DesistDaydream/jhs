package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.google.android.material.button.MaterialButton;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.user.SellerDetailActivity;
import com.jihuanshe.ui.widget.CopyTextView;
import com.jihuanshe.ui.widget.MinConstraintLayout;
import com.jihuanshe.viewmodel.user.SellerDetailViewModel;
import com.vector.network.image.NImageView;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class i2 extends ViewDataBinding {
    @NonNull
    public final TextView A;
    @NonNull
    public final LinearLayout B;
    @NonNull
    public final ConstraintLayout C;
    @NonNull
    public final ConstraintLayout D;
    @NonNull
    public final LinearLayout E;
    @NonNull
    public final RecyclerView F;
    @NonNull
    public final CopyTextView G;
    @Bindable
    public SellerDetailActivity H;
    @Bindable
    public SellerDetailViewModel I;
    @NonNull
    public final ConstraintLayout a;
    @NonNull
    public final CoordinatorLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f12835c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ExpandableTextView f12836d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final View f12837e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f12838f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextView f12839g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final MaterialButton f12840h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final NImageView f12841i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final TextView f12842j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final View f12843k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final ListView f12844l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    public final ListView f12845m;
    @NonNull
    public final LinearLayout n;
    @NonNull
    public final LinearLayout o;
    @NonNull
    public final LinearLayout p;
    @NonNull
    public final LinearLayout q;
    @NonNull
    public final LinearLayout r;
    @NonNull
    public final LinearLayout s;
    @NonNull
    public final TextView t;
    @NonNull
    public final MaterialButton u;
    @NonNull
    public final ConstraintLayout v;
    @NonNull
    public final MinConstraintLayout w;
    @NonNull
    public final CopyTextView x;
    @NonNull
    public final TextView y;
    @NonNull
    public final TextView z;

    public i2(Object obj, View view, int i2, ConstraintLayout constraintLayout, CoordinatorLayout coordinatorLayout, TextView textView, ExpandableTextView expandableTextView, View view2, LinearLayout linearLayout, TextView textView2, MaterialButton materialButton, NImageView nImageView, TextView textView3, View view3, ListView listView, ListView listView2, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, TextView textView4, MaterialButton materialButton2, ConstraintLayout constraintLayout2, MinConstraintLayout minConstraintLayout, CopyTextView copyTextView, TextView textView5, TextView textView6, TextView textView7, LinearLayout linearLayout8, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, LinearLayout linearLayout9, RecyclerView recyclerView, CopyTextView copyTextView2) {
        super(obj, view, i2);
        this.a = constraintLayout;
        this.b = coordinatorLayout;
        this.f12835c = textView;
        this.f12836d = expandableTextView;
        this.f12837e = view2;
        this.f12838f = linearLayout;
        this.f12839g = textView2;
        this.f12840h = materialButton;
        this.f12841i = nImageView;
        this.f12842j = textView3;
        this.f12843k = view3;
        this.f12844l = listView;
        this.f12845m = listView2;
        this.n = linearLayout2;
        this.o = linearLayout3;
        this.p = linearLayout4;
        this.q = linearLayout5;
        this.r = linearLayout6;
        this.s = linearLayout7;
        this.t = textView4;
        this.u = materialButton2;
        this.v = constraintLayout2;
        this.w = minConstraintLayout;
        this.x = copyTextView;
        this.y = textView5;
        this.z = textView6;
        this.A = textView7;
        this.B = linearLayout8;
        this.C = constraintLayout3;
        this.D = constraintLayout4;
        this.E = linearLayout9;
        this.F = recyclerView;
        this.G = copyTextView2;
    }

    public static i2 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static i2 b(@NonNull View view, @Nullable Object obj) {
        return (i2) ViewDataBinding.bind(obj, view, R.layout.activity_seller_detail);
    }

    @NonNull
    public static i2 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static i2 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static i2 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (i2) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_seller_detail, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static i2 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (i2) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_seller_detail, null, false, obj);
    }

    @Nullable
    public SellerDetailActivity c() {
        return this.H;
    }

    @Nullable
    public SellerDetailViewModel d() {
        return this.I;
    }

    public abstract void i(@Nullable SellerDetailActivity sellerDetailActivity);

    public abstract void j(@Nullable SellerDetailViewModel sellerDetailViewModel);
}
