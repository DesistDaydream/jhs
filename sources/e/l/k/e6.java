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
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.AddCardDialog;
import com.jihuanshe.ui.widget.CardImageView;
import com.jihuanshe.ui.widget.NumberView;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class e6 extends ViewDataBinding {
    @Bindable
    public AddCardDialog A;
    @NonNull
    public final NumberView a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f12555c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CardImageView f12556d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final View f12557e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final View f12558f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final View f12559g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final View f12560h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final ListView f12561i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final LinearLayout f12562j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final TextView f12563k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final EditText f12564l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    public final TextView f12565m;
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
    public final EditText s;
    @NonNull
    public final TextView t;
    @NonNull
    public final ImageView u;
    @NonNull
    public final TextView v;
    @NonNull
    public final TextView w;
    @NonNull
    public final LinearLayout x;
    @NonNull
    public final TextView y;
    @NonNull
    public final TextView z;

    public e6(Object obj, View view, int i2, NumberView numberView, TextView textView, TextView textView2, CardImageView cardImageView, View view2, View view3, View view4, View view5, ListView listView, LinearLayout linearLayout, TextView textView3, EditText editText, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, EditText editText2, TextView textView10, ImageView imageView, TextView textView11, TextView textView12, LinearLayout linearLayout2, TextView textView13, TextView textView14) {
        super(obj, view, i2);
        this.a = numberView;
        this.b = textView;
        this.f12555c = textView2;
        this.f12556d = cardImageView;
        this.f12557e = view2;
        this.f12558f = view3;
        this.f12559g = view4;
        this.f12560h = view5;
        this.f12561i = listView;
        this.f12562j = linearLayout;
        this.f12563k = textView3;
        this.f12564l = editText;
        this.f12565m = textView4;
        this.n = textView5;
        this.o = textView6;
        this.p = textView7;
        this.q = textView8;
        this.r = textView9;
        this.s = editText2;
        this.t = textView10;
        this.u = imageView;
        this.v = textView11;
        this.w = textView12;
        this.x = linearLayout2;
        this.y = textView13;
        this.z = textView14;
    }

    public static e6 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static e6 b(@NonNull View view, @Nullable Object obj) {
        return (e6) ViewDataBinding.bind(obj, view, R.layout.dialog_want_card);
    }

    @NonNull
    public static e6 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static e6 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static e6 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (e6) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_want_card, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static e6 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (e6) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_want_card, null, false, obj);
    }

    @Nullable
    public AddCardDialog c() {
        return this.A;
    }

    public abstract void h(@Nullable AddCardDialog addCardDialog);
}
