package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.SoldOutCardDialog;
import com.jihuanshe.ui.widget.CardImageView;

/* loaded from: classes2.dex */
public abstract class w5 extends ViewDataBinding {
    @NonNull
    public final LinearLayout a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f13829c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f13830d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final CardImageView f13831e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final View f13832f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final View f13833g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final View f13834h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final View f13835i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final View f13836j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final LinearLayout f13837k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final TextView f13838l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    public final EditText f13839m;
    @NonNull
    public final EditText n;
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
    public final EditText u;
    @NonNull
    public final TextView v;
    @NonNull
    public final SwitchMaterial w;
    @NonNull
    public final TextView x;
    @NonNull
    public final TextView y;
    @Bindable
    public SoldOutCardDialog z;

    public w5(Object obj, View view, int i2, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, CardImageView cardImageView, View view2, View view3, View view4, View view5, View view6, LinearLayout linearLayout2, TextView textView4, EditText editText, EditText editText2, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, EditText editText3, TextView textView11, SwitchMaterial switchMaterial, TextView textView12, TextView textView13) {
        super(obj, view, i2);
        this.a = linearLayout;
        this.b = textView;
        this.f13829c = textView2;
        this.f13830d = textView3;
        this.f13831e = cardImageView;
        this.f13832f = view2;
        this.f13833g = view3;
        this.f13834h = view4;
        this.f13835i = view5;
        this.f13836j = view6;
        this.f13837k = linearLayout2;
        this.f13838l = textView4;
        this.f13839m = editText;
        this.n = editText2;
        this.o = textView5;
        this.p = textView6;
        this.q = textView7;
        this.r = textView8;
        this.s = textView9;
        this.t = textView10;
        this.u = editText3;
        this.v = textView11;
        this.w = switchMaterial;
        this.x = textView12;
        this.y = textView13;
    }

    public static w5 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static w5 b(@NonNull View view, @Nullable Object obj) {
        return (w5) ViewDataBinding.bind(obj, view, R.layout.dialog_sold_out_card);
    }

    @NonNull
    public static w5 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static w5 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static w5 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (w5) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_sold_out_card, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static w5 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (w5) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_sold_out_card, null, false, obj);
    }

    @Nullable
    public SoldOutCardDialog c() {
        return this.z;
    }

    public abstract void h(@Nullable SoldOutCardDialog soldOutCardDialog);
}
