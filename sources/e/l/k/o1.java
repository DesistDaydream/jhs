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
import com.jihuanshe.ui.page.order.OrderConfirmActivity;
import com.jihuanshe.ui.widget.NoScrollListView;
import com.jihuanshe.viewmodel.order.OrderConfirmViewModel;

/* loaded from: classes2.dex */
public abstract class o1 extends ViewDataBinding {
    @NonNull
    public final ImageView a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final View f13235c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final View f13236d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final EditText f13237e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ConstraintLayout f13238f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final ConstraintLayout f13239g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final ImageView f13240h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final TextView f13241i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final TextView f13242j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final ConstraintLayout f13243k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final TextView f13244l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    public final NoScrollListView f13245m;
    @NonNull
    public final TextView n;
    @NonNull
    public final LinearLayout o;
    @NonNull
    public final TextView p;
    @NonNull
    public final TextView q;
    @Bindable
    public OrderConfirmActivity r;
    @Bindable
    public OrderConfirmViewModel s;

    public o1(Object obj, View view, int i2, ImageView imageView, TextView textView, View view2, View view3, EditText editText, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView2, TextView textView2, TextView textView3, ConstraintLayout constraintLayout3, TextView textView4, NoScrollListView noScrollListView, TextView textView5, LinearLayout linearLayout, TextView textView6, TextView textView7) {
        super(obj, view, i2);
        this.a = imageView;
        this.b = textView;
        this.f13235c = view2;
        this.f13236d = view3;
        this.f13237e = editText;
        this.f13238f = constraintLayout;
        this.f13239g = constraintLayout2;
        this.f13240h = imageView2;
        this.f13241i = textView2;
        this.f13242j = textView3;
        this.f13243k = constraintLayout3;
        this.f13244l = textView4;
        this.f13245m = noScrollListView;
        this.n = textView5;
        this.o = linearLayout;
        this.p = textView6;
        this.q = textView7;
    }

    public static o1 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static o1 b(@NonNull View view, @Nullable Object obj) {
        return (o1) ViewDataBinding.bind(obj, view, R.layout.activity_order_confirm);
    }

    @NonNull
    public static o1 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static o1 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static o1 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (o1) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_order_confirm, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static o1 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (o1) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_order_confirm, null, false, obj);
    }

    @Nullable
    public OrderConfirmActivity c() {
        return this.r;
    }

    @Nullable
    public OrderConfirmViewModel d() {
        return this.s;
    }

    public abstract void i(@Nullable OrderConfirmActivity orderConfirmActivity);

    public abstract void j(@Nullable OrderConfirmViewModel orderConfirmViewModel);
}
