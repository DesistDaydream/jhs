package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.user.ShopOwnerConfirmActivity;

/* loaded from: classes2.dex */
public abstract class q2 extends ViewDataBinding {
    @NonNull
    public final TextView a;
    @NonNull
    public final CheckBox b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f13397c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final FrameLayout f13398d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final FrameLayout f13399e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f13400f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final FrameLayout f13401g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final EditText f13402h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final TextView f13403i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final EditText f13404j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final TextView f13405k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final TextView f13406l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    public final EditText f13407m;
    @NonNull
    public final TextView n;
    @NonNull
    public final TextView o;
    @NonNull
    public final EditText p;
    @NonNull
    public final TextView q;
    @NonNull
    public final TextView r;
    @NonNull
    public final EditText s;
    @NonNull
    public final TextView t;
    @NonNull
    public final TextView u;
    @NonNull
    public final TextView v;
    @NonNull
    public final TextView w;
    @Bindable
    public ShopOwnerConfirmActivity x;
    @Bindable
    public e.l.s.o.b y;

    public q2(Object obj, View view, int i2, TextView textView, CheckBox checkBox, TextView textView2, FrameLayout frameLayout, FrameLayout frameLayout2, TextView textView3, FrameLayout frameLayout3, EditText editText, TextView textView4, EditText editText2, TextView textView5, TextView textView6, EditText editText3, TextView textView7, TextView textView8, EditText editText4, TextView textView9, TextView textView10, EditText editText5, TextView textView11, TextView textView12, TextView textView13, TextView textView14) {
        super(obj, view, i2);
        this.a = textView;
        this.b = checkBox;
        this.f13397c = textView2;
        this.f13398d = frameLayout;
        this.f13399e = frameLayout2;
        this.f13400f = textView3;
        this.f13401g = frameLayout3;
        this.f13402h = editText;
        this.f13403i = textView4;
        this.f13404j = editText2;
        this.f13405k = textView5;
        this.f13406l = textView6;
        this.f13407m = editText3;
        this.n = textView7;
        this.o = textView8;
        this.p = editText4;
        this.q = textView9;
        this.r = textView10;
        this.s = editText5;
        this.t = textView11;
        this.u = textView12;
        this.v = textView13;
        this.w = textView14;
    }

    public static q2 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static q2 b(@NonNull View view, @Nullable Object obj) {
        return (q2) ViewDataBinding.bind(obj, view, R.layout.activity_shop_owner_confirm);
    }

    @NonNull
    public static q2 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static q2 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static q2 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (q2) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_shop_owner_confirm, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static q2 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (q2) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_shop_owner_confirm, null, false, obj);
    }

    @Nullable
    public ShopOwnerConfirmActivity c() {
        return this.x;
    }

    @Nullable
    public e.l.s.o.b d() {
        return this.y;
    }

    public abstract void i(@Nullable ShopOwnerConfirmActivity shopOwnerConfirmActivity);

    public abstract void j(@Nullable e.l.s.o.b bVar);
}
