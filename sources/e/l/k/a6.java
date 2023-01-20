package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.WaitCheckDialog;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class a6 extends ViewDataBinding {
    @NonNull
    public final NImageView a;
    @NonNull
    public final View b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final View f12262c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ConstraintLayout f12263d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f12264e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final EditText f12265f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextView f12266g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TextView f12267h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final TextView f12268i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final TextView f12269j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final TextView f12270k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final TextView f12271l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    public final TextView f12272m;
    @NonNull
    public final TextView n;
    @NonNull
    public final TextView o;
    @NonNull
    public final TextView p;
    @NonNull
    public final TextView q;
    @Bindable
    public WaitCheckDialog r;

    public a6(Object obj, View view, int i2, NImageView nImageView, View view2, View view3, ConstraintLayout constraintLayout, LinearLayout linearLayout, EditText editText, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11) {
        super(obj, view, i2);
        this.a = nImageView;
        this.b = view2;
        this.f12262c = view3;
        this.f12263d = constraintLayout;
        this.f12264e = linearLayout;
        this.f12265f = editText;
        this.f12266g = textView;
        this.f12267h = textView2;
        this.f12268i = textView3;
        this.f12269j = textView4;
        this.f12270k = textView5;
        this.f12271l = textView6;
        this.f12272m = textView7;
        this.n = textView8;
        this.o = textView9;
        this.p = textView10;
        this.q = textView11;
    }

    public static a6 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static a6 b(@NonNull View view, @Nullable Object obj) {
        return (a6) ViewDataBinding.bind(obj, view, R.layout.dialog_wait_check);
    }

    @NonNull
    public static a6 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static a6 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static a6 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (a6) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_wait_check, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static a6 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (a6) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_wait_check, null, false, obj);
    }

    @Nullable
    public WaitCheckDialog c() {
        return this.r;
    }

    public abstract void h(@Nullable WaitCheckDialog waitCheckDialog);
}
