package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.entrepot.SubmitOrderReturnActivity;
import com.jihuanshe.viewmodel.entrepot.SubmitOrderReturnViewModel;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class w2 extends ViewDataBinding {
    @NonNull
    public final ConstraintLayout a;
    @NonNull
    public final ConstraintLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f13804c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ListView f13805d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f13806e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f13807f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextView f13808g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TextView f13809h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final TextView f13810i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final TextView f13811j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final TextView f13812k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final TextView f13813l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    public final TextView f13814m;
    @NonNull
    public final TextView n;
    @NonNull
    public final TextView o;
    @NonNull
    public final TextView p;
    @Bindable
    public SubmitOrderReturnActivity q;
    @Bindable
    public SubmitOrderReturnViewModel r;

    public w2(Object obj, View view, int i2, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, ListView listView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12) {
        super(obj, view, i2);
        this.a = constraintLayout;
        this.b = constraintLayout2;
        this.f13804c = imageView;
        this.f13805d = listView;
        this.f13806e = textView;
        this.f13807f = textView2;
        this.f13808g = textView3;
        this.f13809h = textView4;
        this.f13810i = textView5;
        this.f13811j = textView6;
        this.f13812k = textView7;
        this.f13813l = textView8;
        this.f13814m = textView9;
        this.n = textView10;
        this.o = textView11;
        this.p = textView12;
    }

    public static w2 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static w2 b(@NonNull View view, @Nullable Object obj) {
        return (w2) ViewDataBinding.bind(obj, view, R.layout.activity_submit_order_return);
    }

    @NonNull
    public static w2 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static w2 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static w2 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (w2) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_submit_order_return, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static w2 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (w2) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_submit_order_return, null, false, obj);
    }

    @Nullable
    public SubmitOrderReturnActivity c() {
        return this.q;
    }

    @Nullable
    public SubmitOrderReturnViewModel d() {
        return this.r;
    }

    public abstract void i(@Nullable SubmitOrderReturnActivity submitOrderReturnActivity);

    public abstract void j(@Nullable SubmitOrderReturnViewModel submitOrderReturnViewModel);
}
