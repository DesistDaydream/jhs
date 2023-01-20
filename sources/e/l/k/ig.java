package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.CardProductNew;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.ui.widget.NumberView;

/* loaded from: classes2.dex */
public abstract class ig extends ViewDataBinding {
    @NonNull
    public final TextView a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f12903c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final EditText f12904d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f12905e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f12906f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextView f12907g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final NumberView f12908h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final ConstraintLayout f12909i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final EditText f12910j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final TextView f12911k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final TextView f12912l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    public final TextView f12913m;
    @NonNull
    public final TextView n;
    @Bindable
    public CardProductNew o;
    @Bindable
    public GameCard p;
    @Bindable
    public e.l.q.b.b.a.d q;

    public ig(Object obj, View view, int i2, TextView textView, TextView textView2, TextView textView3, EditText editText, TextView textView4, TextView textView5, TextView textView6, NumberView numberView, ConstraintLayout constraintLayout, EditText editText2, TextView textView7, TextView textView8, TextView textView9, TextView textView10) {
        super(obj, view, i2);
        this.a = textView;
        this.b = textView2;
        this.f12903c = textView3;
        this.f12904d = editText;
        this.f12905e = textView4;
        this.f12906f = textView5;
        this.f12907g = textView6;
        this.f12908h = numberView;
        this.f12909i = constraintLayout;
        this.f12910j = editText2;
        this.f12911k = textView7;
        this.f12912l = textView8;
        this.f12913m = textView9;
        this.n = textView10;
    }

    public static ig a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ig b(@NonNull View view, @Nullable Object obj) {
        return (ig) ViewDataBinding.bind(obj, view, R.layout.view_product_info_edit);
    }

    @NonNull
    public static ig f(@NonNull LayoutInflater layoutInflater) {
        return i(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ig g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return h(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ig h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ig) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_product_info_edit, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ig i(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ig) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_product_info_edit, null, false, obj);
    }

    @Nullable
    public e.l.q.b.b.a.d c() {
        return this.q;
    }

    @Nullable
    public CardProductNew d() {
        return this.o;
    }

    @Nullable
    public GameCard e() {
        return this.p;
    }

    public abstract void j(@Nullable e.l.q.b.b.a.d dVar);

    public abstract void k(@Nullable CardProductNew cardProductNew);

    public abstract void l(@Nullable GameCard gameCard);
}
