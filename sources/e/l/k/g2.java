package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.shop.SellerConfirmActivity;
import com.jihuanshe.viewmodel.shop.SellerConfirmViewModel;

/* loaded from: classes2.dex */
public abstract class g2 extends ViewDataBinding {
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
    public final TextView F;
    @NonNull
    public final TextView G;
    @NonNull
    public final TextView H;
    @NonNull
    public final TextView I;
    @NonNull
    public final TextView J;
    @NonNull
    public final TextView K;
    @NonNull
    public final TextView L;
    @Bindable
    public SellerConfirmActivity M;
    @Bindable
    public SellerConfirmViewModel N;
    @NonNull
    public final TextView a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CheckBox f12697c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final EditText f12698d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f12699e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f12700f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextView f12701g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TextView f12702h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final TextView f12703i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final TextView f12704j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final FrameLayout f12705k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final FrameLayout f12706l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    public final EditText f12707m;
    @NonNull
    public final TextView n;
    @NonNull
    public final FrameLayout o;
    @NonNull
    public final EditText p;
    @NonNull
    public final TextView q;
    @NonNull
    public final RadioButton r;
    @NonNull
    public final RadioButton s;
    @NonNull
    public final TextView t;
    @NonNull
    public final RadioGroup u;
    @NonNull
    public final EditText v;
    @NonNull
    public final EditText w;
    @NonNull
    public final TextView x;
    @NonNull
    public final TextView y;
    @NonNull
    public final TextView z;

    public g2(Object obj, View view, int i2, TextView textView, TextView textView2, CheckBox checkBox, EditText editText, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, FrameLayout frameLayout, FrameLayout frameLayout2, EditText editText2, TextView textView9, FrameLayout frameLayout3, EditText editText3, TextView textView10, RadioButton radioButton, RadioButton radioButton2, TextView textView11, RadioGroup radioGroup, EditText editText4, EditText editText5, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, TextView textView20, TextView textView21, TextView textView22, TextView textView23, TextView textView24, TextView textView25, TextView textView26) {
        super(obj, view, i2);
        this.a = textView;
        this.b = textView2;
        this.f12697c = checkBox;
        this.f12698d = editText;
        this.f12699e = textView3;
        this.f12700f = textView4;
        this.f12701g = textView5;
        this.f12702h = textView6;
        this.f12703i = textView7;
        this.f12704j = textView8;
        this.f12705k = frameLayout;
        this.f12706l = frameLayout2;
        this.f12707m = editText2;
        this.n = textView9;
        this.o = frameLayout3;
        this.p = editText3;
        this.q = textView10;
        this.r = radioButton;
        this.s = radioButton2;
        this.t = textView11;
        this.u = radioGroup;
        this.v = editText4;
        this.w = editText5;
        this.x = textView12;
        this.y = textView13;
        this.z = textView14;
        this.A = textView15;
        this.B = textView16;
        this.C = textView17;
        this.D = textView18;
        this.E = textView19;
        this.F = textView20;
        this.G = textView21;
        this.H = textView22;
        this.I = textView23;
        this.J = textView24;
        this.K = textView25;
        this.L = textView26;
    }

    public static g2 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static g2 b(@NonNull View view, @Nullable Object obj) {
        return (g2) ViewDataBinding.bind(obj, view, R.layout.activity_seller_confirm);
    }

    @NonNull
    public static g2 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static g2 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static g2 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (g2) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_seller_confirm, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static g2 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (g2) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_seller_confirm, null, false, obj);
    }

    @Nullable
    public SellerConfirmActivity c() {
        return this.M;
    }

    @Nullable
    public SellerConfirmViewModel d() {
        return this.N;
    }

    public abstract void i(@Nullable SellerConfirmActivity sellerConfirmActivity);

    public abstract void j(@Nullable SellerConfirmViewModel sellerConfirmViewModel);
}
