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
import com.jihuanshe.ui.page.main.me.MeFragment;
import com.jihuanshe.viewmodel.main.me.MeViewModel;

/* loaded from: classes2.dex */
public abstract class y6 extends ViewDataBinding {
    @NonNull
    public final TextView a;
    @NonNull
    public final View b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f13959c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f13960d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f13961e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ConstraintLayout f13962f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextView f13963g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final ImageView f13964h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final TextView f13965i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final LinearLayout f13966j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final LinearLayout f13967k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final View f13968l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    public final View f13969m;
    @NonNull
    public final ImageView n;
    @NonNull
    public final LinearLayout o;
    @Bindable
    public MeFragment p;
    @Bindable
    public MeViewModel q;

    public y6(Object obj, View view, int i2, TextView textView, View view2, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView2, ConstraintLayout constraintLayout, TextView textView3, ImageView imageView, TextView textView4, LinearLayout linearLayout3, LinearLayout linearLayout4, View view3, View view4, ImageView imageView2, LinearLayout linearLayout5) {
        super(obj, view, i2);
        this.a = textView;
        this.b = view2;
        this.f13959c = linearLayout;
        this.f13960d = linearLayout2;
        this.f13961e = textView2;
        this.f13962f = constraintLayout;
        this.f13963g = textView3;
        this.f13964h = imageView;
        this.f13965i = textView4;
        this.f13966j = linearLayout3;
        this.f13967k = linearLayout4;
        this.f13968l = view3;
        this.f13969m = view4;
        this.n = imageView2;
        this.o = linearLayout5;
    }

    public static y6 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static y6 b(@NonNull View view, @Nullable Object obj) {
        return (y6) ViewDataBinding.bind(obj, view, R.layout.fragment_me);
    }

    @NonNull
    public static y6 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static y6 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static y6 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (y6) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_me, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static y6 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (y6) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_me, null, false, obj);
    }

    @Nullable
    public MeFragment c() {
        return this.p;
    }

    @Nullable
    public MeViewModel d() {
        return this.q;
    }

    public abstract void i(@Nullable MeFragment meFragment);

    public abstract void j(@Nullable MeViewModel meViewModel);
}
