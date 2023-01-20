package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.user.MineEntrepotActivity;
import com.jihuanshe.viewmodel.user.MineEntrepotViewModel;

/* loaded from: classes2.dex */
public abstract class k1 extends ViewDataBinding {
    @NonNull
    public final View A;
    @NonNull
    public final TextView B;
    @Bindable
    public MineEntrepotActivity C;
    @Bindable
    public MineEntrepotViewModel D;
    @NonNull
    public final ConstraintLayout a;
    @NonNull
    public final ConstraintLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ConstraintLayout f12977c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ConstraintLayout f12978d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final ConstraintLayout f12979e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ConstraintLayout f12980f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final ConstraintLayout f12981g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final ImageView f12982h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final LinearLayout f12983i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final LinearLayout f12984j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final LinearLayout f12985k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final LinearLayout f12986l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    public final LinearLayout f12987m;
    @NonNull
    public final LinearLayout n;
    @NonNull
    public final LinearLayout o;
    @NonNull
    public final NestedScrollView p;
    @NonNull
    public final TextView q;
    @NonNull
    public final TextView r;
    @NonNull
    public final TextView s;
    @NonNull
    public final TextView t;
    @NonNull
    public final TextView u;
    @NonNull
    public final TextView v;
    @NonNull
    public final View w;
    @NonNull
    public final View x;
    @NonNull
    public final View y;
    @NonNull
    public final View z;

    public k1(Object obj, View view, int i2, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, NestedScrollView nestedScrollView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, View view2, View view3, View view4, View view5, View view6, TextView textView7) {
        super(obj, view, i2);
        this.a = constraintLayout;
        this.b = constraintLayout2;
        this.f12977c = constraintLayout3;
        this.f12978d = constraintLayout4;
        this.f12979e = constraintLayout5;
        this.f12980f = constraintLayout6;
        this.f12981g = constraintLayout7;
        this.f12982h = imageView;
        this.f12983i = linearLayout;
        this.f12984j = linearLayout2;
        this.f12985k = linearLayout3;
        this.f12986l = linearLayout4;
        this.f12987m = linearLayout5;
        this.n = linearLayout6;
        this.o = linearLayout7;
        this.p = nestedScrollView;
        this.q = textView;
        this.r = textView2;
        this.s = textView3;
        this.t = textView4;
        this.u = textView5;
        this.v = textView6;
        this.w = view2;
        this.x = view3;
        this.y = view4;
        this.z = view5;
        this.A = view6;
        this.B = textView7;
    }

    public static k1 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static k1 b(@NonNull View view, @Nullable Object obj) {
        return (k1) ViewDataBinding.bind(obj, view, R.layout.activity_mine_entrepot);
    }

    @NonNull
    public static k1 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static k1 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static k1 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (k1) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_mine_entrepot, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static k1 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (k1) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_mine_entrepot, null, false, obj);
    }

    @Nullable
    public MineEntrepotActivity c() {
        return this.C;
    }

    @Nullable
    public MineEntrepotViewModel d() {
        return this.D;
    }

    public abstract void i(@Nullable MineEntrepotActivity mineEntrepotActivity);

    public abstract void j(@Nullable MineEntrepotViewModel mineEntrepotViewModel);
}
