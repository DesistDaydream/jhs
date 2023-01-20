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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.entrepot.SubmitOrderActivity;
import com.jihuanshe.viewmodel.entrepot.SubmitOrderViewModel;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class u2 extends ViewDataBinding {
    @NonNull
    public final ConstraintLayout a;
    @NonNull
    public final ConstraintLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final NImageView f13673c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final EditText f13674d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f13675e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ConstraintLayout f13676f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final LinearLayout f13677g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final LinearLayout f13678h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final LinearLayout f13679i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final TextView f13680j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final TextView f13681k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final TextView f13682l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    public final TextView f13683m;
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
    @Bindable
    public SubmitOrderActivity x;
    @Bindable
    public SubmitOrderViewModel y;

    public u2(Object obj, View view, int i2, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, NImageView nImageView, EditText editText, ImageView imageView, ConstraintLayout constraintLayout3, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14) {
        super(obj, view, i2);
        this.a = constraintLayout;
        this.b = constraintLayout2;
        this.f13673c = nImageView;
        this.f13674d = editText;
        this.f13675e = imageView;
        this.f13676f = constraintLayout3;
        this.f13677g = linearLayout;
        this.f13678h = linearLayout2;
        this.f13679i = linearLayout3;
        this.f13680j = textView;
        this.f13681k = textView2;
        this.f13682l = textView3;
        this.f13683m = textView4;
        this.n = textView5;
        this.o = textView6;
        this.p = textView7;
        this.q = textView8;
        this.r = textView9;
        this.s = textView10;
        this.t = textView11;
        this.u = textView12;
        this.v = textView13;
        this.w = textView14;
    }

    public static u2 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static u2 b(@NonNull View view, @Nullable Object obj) {
        return (u2) ViewDataBinding.bind(obj, view, R.layout.activity_submit_order);
    }

    @NonNull
    public static u2 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static u2 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static u2 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (u2) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_submit_order, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static u2 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (u2) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_submit_order, null, false, obj);
    }

    @Nullable
    public SubmitOrderActivity c() {
        return this.x;
    }

    @Nullable
    public SubmitOrderViewModel d() {
        return this.y;
    }

    public abstract void i(@Nullable SubmitOrderActivity submitOrderActivity);

    public abstract void j(@Nullable SubmitOrderViewModel submitOrderViewModel);
}
