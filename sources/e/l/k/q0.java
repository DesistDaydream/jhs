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
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.entrepot.ApplyForReturnActivity;
import com.jihuanshe.viewmodel.entrepot.ApplyForReturnViewModel;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class q0 extends ViewDataBinding {
    @Bindable
    public ApplyForReturnActivity A;
    @Bindable
    public ApplyForReturnViewModel B;
    @NonNull
    public final ImageView a;
    @NonNull
    public final ListView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ConstraintLayout f13375c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ConstraintLayout f13376d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f13377e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final View f13378f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final View f13379g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final ListView f13380h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final LinearLayout f13381i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final LinearLayout f13382j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final LinearLayout f13383k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final LinearLayout f13384l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    public final TextView f13385m;
    @NonNull
    public final TextView n;
    @NonNull
    public final TextView o;
    @NonNull
    public final TextView p;
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
    public final TextView w;
    @NonNull
    public final TextView x;
    @NonNull
    public final TextView y;
    @NonNull
    public final TextView z;

    public q0(Object obj, View view, int i2, ImageView imageView, ListView listView, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView2, View view2, View view3, ListView listView2, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14) {
        super(obj, view, i2);
        this.a = imageView;
        this.b = listView;
        this.f13375c = constraintLayout;
        this.f13376d = constraintLayout2;
        this.f13377e = imageView2;
        this.f13378f = view2;
        this.f13379g = view3;
        this.f13380h = listView2;
        this.f13381i = linearLayout;
        this.f13382j = linearLayout2;
        this.f13383k = linearLayout3;
        this.f13384l = linearLayout4;
        this.f13385m = textView;
        this.n = textView2;
        this.o = textView3;
        this.p = textView4;
        this.q = textView5;
        this.r = textView6;
        this.s = textView7;
        this.t = textView8;
        this.u = textView9;
        this.v = textView10;
        this.w = textView11;
        this.x = textView12;
        this.y = textView13;
        this.z = textView14;
    }

    public static q0 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static q0 b(@NonNull View view, @Nullable Object obj) {
        return (q0) ViewDataBinding.bind(obj, view, R.layout.activity_entrepot_apply_for_return);
    }

    @NonNull
    public static q0 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static q0 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static q0 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (q0) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_entrepot_apply_for_return, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static q0 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (q0) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_entrepot_apply_for_return, null, false, obj);
    }

    @Nullable
    public ApplyForReturnActivity c() {
        return this.A;
    }

    @Nullable
    public ApplyForReturnViewModel d() {
        return this.B;
    }

    public abstract void i(@Nullable ApplyForReturnActivity applyForReturnActivity);

    public abstract void j(@Nullable ApplyForReturnViewModel applyForReturnViewModel);
}
