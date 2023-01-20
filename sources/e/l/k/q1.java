package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
import com.jihuanshe.ui.page.order.OrderDetailActivity;
import com.jihuanshe.ui.widget.NoScrollListView;
import com.jihuanshe.viewmodel.order.OrderDetailViewModel;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class q1 extends ViewDataBinding {
    @Bindable
    public OrderDetailActivity A;
    @Bindable
    public OrderDetailViewModel B;
    @NonNull
    public final ImageView a;
    @NonNull
    public final View b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final FrameLayout f13386c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ConstraintLayout f13387d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final ListView f13388e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f13389f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextView f13390g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final ConstraintLayout f13391h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final LinearLayout f13392i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final LinearLayout f13393j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final ImageView f13394k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final TextView f13395l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    public final TextView f13396m;
    @NonNull
    public final TextView n;
    @NonNull
    public final TextView o;
    @NonNull
    public final TextView p;
    @NonNull
    public final ConstraintLayout q;
    @NonNull
    public final NoScrollListView r;
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

    public q1(Object obj, View view, int i2, ImageView imageView, View view2, FrameLayout frameLayout, ConstraintLayout constraintLayout, ListView listView, TextView textView, TextView textView2, ConstraintLayout constraintLayout2, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, ConstraintLayout constraintLayout3, NoScrollListView noScrollListView, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15) {
        super(obj, view, i2);
        this.a = imageView;
        this.b = view2;
        this.f13386c = frameLayout;
        this.f13387d = constraintLayout;
        this.f13388e = listView;
        this.f13389f = textView;
        this.f13390g = textView2;
        this.f13391h = constraintLayout2;
        this.f13392i = linearLayout;
        this.f13393j = linearLayout2;
        this.f13394k = imageView2;
        this.f13395l = textView3;
        this.f13396m = textView4;
        this.n = textView5;
        this.o = textView6;
        this.p = textView7;
        this.q = constraintLayout3;
        this.r = noScrollListView;
        this.s = textView8;
        this.t = textView9;
        this.u = textView10;
        this.v = textView11;
        this.w = textView12;
        this.x = textView13;
        this.y = textView14;
        this.z = textView15;
    }

    public static q1 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static q1 b(@NonNull View view, @Nullable Object obj) {
        return (q1) ViewDataBinding.bind(obj, view, R.layout.activity_order_detail);
    }

    @NonNull
    public static q1 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static q1 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static q1 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (q1) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_order_detail, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static q1 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (q1) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_order_detail, null, false, obj);
    }

    @Nullable
    public OrderDetailActivity c() {
        return this.A;
    }

    @Nullable
    public OrderDetailViewModel d() {
        return this.B;
    }

    public abstract void i(@Nullable OrderDetailActivity orderDetailActivity);

    public abstract void j(@Nullable OrderDetailViewModel orderDetailViewModel);
}
