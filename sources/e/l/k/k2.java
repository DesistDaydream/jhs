package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.order.SellerOrderDetailActivity;
import com.jihuanshe.ui.widget.NoScrollListView;
import com.jihuanshe.viewmodel.order.SellerOrderDetailViewModel;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class k2 extends ViewDataBinding {
    @NonNull
    public final TextView A;
    @NonNull
    public final TextView B;
    @NonNull
    public final TextView C;
    @NonNull
    public final TextView D;
    @NonNull
    public final TextView E;
    @NonNull
    public final RadioGroup F;
    @Bindable
    public SellerOrderDetailActivity G;
    @Bindable
    public SellerOrderDetailViewModel H;
    @NonNull
    public final ImageView a;
    @NonNull
    public final View b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final FrameLayout f12988c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final EditText f12989d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final ConstraintLayout f12990e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ListView f12991f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextView f12992g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TextView f12993h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final TextView f12994i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final TextView f12995j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final ConstraintLayout f12996k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final ImageView f12997l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    public final TextView f12998m;
    @NonNull
    public final TextView n;
    @NonNull
    public final TextView o;
    @NonNull
    public final TextView p;
    @NonNull
    public final TextView q;
    @NonNull
    public final ConstraintLayout r;
    @NonNull
    public final RadioButton s;
    @NonNull
    public final RadioButton t;
    @NonNull
    public final NoScrollListView u;
    @NonNull
    public final TextView v;
    @NonNull
    public final TextView w;
    @NonNull
    public final TextView x;
    @NonNull
    public final TextView y;
    @NonNull
    public final TextView z;

    public k2(Object obj, View view, int i2, ImageView imageView, View view2, FrameLayout frameLayout, EditText editText, ConstraintLayout constraintLayout, ListView listView, TextView textView, TextView textView2, TextView textView3, TextView textView4, ConstraintLayout constraintLayout2, ImageView imageView2, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, ConstraintLayout constraintLayout3, RadioButton radioButton, RadioButton radioButton2, NoScrollListView noScrollListView, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, RadioGroup radioGroup) {
        super(obj, view, i2);
        this.a = imageView;
        this.b = view2;
        this.f12988c = frameLayout;
        this.f12989d = editText;
        this.f12990e = constraintLayout;
        this.f12991f = listView;
        this.f12992g = textView;
        this.f12993h = textView2;
        this.f12994i = textView3;
        this.f12995j = textView4;
        this.f12996k = constraintLayout2;
        this.f12997l = imageView2;
        this.f12998m = textView5;
        this.n = textView6;
        this.o = textView7;
        this.p = textView8;
        this.q = textView9;
        this.r = constraintLayout3;
        this.s = radioButton;
        this.t = radioButton2;
        this.u = noScrollListView;
        this.v = textView10;
        this.w = textView11;
        this.x = textView12;
        this.y = textView13;
        this.z = textView14;
        this.A = textView15;
        this.B = textView16;
        this.C = textView17;
        this.D = textView18;
        this.E = textView19;
        this.F = radioGroup;
    }

    public static k2 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static k2 b(@NonNull View view, @Nullable Object obj) {
        return (k2) ViewDataBinding.bind(obj, view, R.layout.activity_seller_order_detail);
    }

    @NonNull
    public static k2 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static k2 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static k2 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (k2) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_seller_order_detail, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static k2 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (k2) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_seller_order_detail, null, false, obj);
    }

    @Nullable
    public SellerOrderDetailActivity c() {
        return this.G;
    }

    @Nullable
    public SellerOrderDetailViewModel d() {
        return this.H;
    }

    public abstract void i(@Nullable SellerOrderDetailActivity sellerOrderDetailActivity);

    public abstract void j(@Nullable SellerOrderDetailViewModel sellerOrderDetailViewModel);
}
