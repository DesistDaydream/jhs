package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.login.LoginActivity;
import com.jihuanshe.ui.widget.VerifyView;
import com.jihuanshe.viewmodel.login.LoginViewModel;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class g1 extends ViewDataBinding {
    @NonNull
    public final NImageView a;
    @NonNull
    public final LinearLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f12686c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final EditText f12687d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f12688e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f12689f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextView f12690g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final ImageView f12691h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final TextView f12692i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final TextView f12693j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final TextView f12694k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final VerifyView f12695l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    public final LinearLayout f12696m;
    @NonNull
    public final TextView n;
    @NonNull
    public final ImageView o;
    @NonNull
    public final EditText p;
    @NonNull
    public final EditText q;
    @NonNull
    public final TextView r;
    @NonNull
    public final LinearLayout s;
    @NonNull
    public final TextView t;
    @NonNull
    public final TextView u;
    @NonNull
    public final TextView v;
    @NonNull
    public final ImageView w;
    @Bindable
    public LoginActivity x;
    @Bindable
    public LoginViewModel y;

    public g1(Object obj, View view, int i2, NImageView nImageView, LinearLayout linearLayout, ImageView imageView, EditText editText, TextView textView, TextView textView2, TextView textView3, ImageView imageView2, TextView textView4, TextView textView5, TextView textView6, VerifyView verifyView, LinearLayout linearLayout2, TextView textView7, ImageView imageView3, EditText editText2, EditText editText3, TextView textView8, LinearLayout linearLayout3, TextView textView9, TextView textView10, TextView textView11, ImageView imageView4) {
        super(obj, view, i2);
        this.a = nImageView;
        this.b = linearLayout;
        this.f12686c = imageView;
        this.f12687d = editText;
        this.f12688e = textView;
        this.f12689f = textView2;
        this.f12690g = textView3;
        this.f12691h = imageView2;
        this.f12692i = textView4;
        this.f12693j = textView5;
        this.f12694k = textView6;
        this.f12695l = verifyView;
        this.f12696m = linearLayout2;
        this.n = textView7;
        this.o = imageView3;
        this.p = editText2;
        this.q = editText3;
        this.r = textView8;
        this.s = linearLayout3;
        this.t = textView9;
        this.u = textView10;
        this.v = textView11;
        this.w = imageView4;
    }

    public static g1 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static g1 b(@NonNull View view, @Nullable Object obj) {
        return (g1) ViewDataBinding.bind(obj, view, R.layout.activity_login);
    }

    @NonNull
    public static g1 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static g1 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static g1 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (g1) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_login, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static g1 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (g1) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_login, null, false, obj);
    }

    @Nullable
    public LoginActivity c() {
        return this.x;
    }

    @Nullable
    public LoginViewModel d() {
        return this.y;
    }

    public abstract void i(@Nullable LoginActivity loginActivity);

    public abstract void j(@Nullable LoginViewModel loginViewModel);
}
