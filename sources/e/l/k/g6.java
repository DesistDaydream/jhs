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
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.AddCardConsignmentDialog;
import com.jihuanshe.ui.widget.CardImageView;

/* loaded from: classes2.dex */
public abstract class g6 extends ViewDataBinding {
    @NonNull
    public final TextView A;
    @NonNull
    public final TextView B;
    @NonNull
    public final TextView C;
    @Bindable
    public AddCardConsignmentDialog D;
    @NonNull
    public final CardImageView a;
    @NonNull
    public final View b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final View f12714c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f12715d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f12716e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f12717f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final LinearLayout f12718g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final ConstraintLayout f12719h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final LinearLayout f12720i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final LinearLayout f12721j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final EditText f12722k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final EditText f12723l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    public final TextView f12724m;
    @NonNull
    public final SwitchMaterial n;
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

    public g6(Object obj, View view, int i2, CardImageView cardImageView, View view2, View view3, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, ConstraintLayout constraintLayout, LinearLayout linearLayout5, LinearLayout linearLayout6, EditText editText, EditText editText2, TextView textView, SwitchMaterial switchMaterial, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16) {
        super(obj, view, i2);
        this.a = cardImageView;
        this.b = view2;
        this.f12714c = view3;
        this.f12715d = linearLayout;
        this.f12716e = linearLayout2;
        this.f12717f = linearLayout3;
        this.f12718g = linearLayout4;
        this.f12719h = constraintLayout;
        this.f12720i = linearLayout5;
        this.f12721j = linearLayout6;
        this.f12722k = editText;
        this.f12723l = editText2;
        this.f12724m = textView;
        this.n = switchMaterial;
        this.o = textView2;
        this.p = textView3;
        this.q = textView4;
        this.r = textView5;
        this.s = textView6;
        this.t = textView7;
        this.u = textView8;
        this.v = textView9;
        this.w = textView10;
        this.x = textView11;
        this.y = textView12;
        this.z = textView13;
        this.A = textView14;
        this.B = textView15;
        this.C = textView16;
    }

    public static g6 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static g6 b(@NonNull View view, @Nullable Object obj) {
        return (g6) ViewDataBinding.bind(obj, view, R.layout.dialog_want_consignment_card);
    }

    @NonNull
    public static g6 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static g6 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static g6 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (g6) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_want_consignment_card, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static g6 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (g6) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_want_consignment_card, null, false, obj);
    }

    @Nullable
    public AddCardConsignmentDialog c() {
        return this.D;
    }

    public abstract void h(@Nullable AddCardConsignmentDialog addCardConsignmentDialog);
}
