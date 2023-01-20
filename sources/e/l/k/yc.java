package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.ui.widget.CardImageView;

/* loaded from: classes2.dex */
public abstract class yc extends ViewDataBinding {
    @NonNull
    public final CardImageView a;
    @NonNull
    public final LinearLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f13998c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f13999d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f14000e;
    @Bindable

    /* renamed from: f  reason: collision with root package name */
    public e.l.g.u0 f14001f;
    @Bindable

    /* renamed from: g  reason: collision with root package name */
    public GameCard f14002g;

    public yc(Object obj, View view, int i2, CardImageView cardImageView, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2) {
        super(obj, view, i2);
        this.a = cardImageView;
        this.b = linearLayout;
        this.f13998c = linearLayout2;
        this.f13999d = textView;
        this.f14000e = textView2;
    }

    public static yc a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static yc b(@NonNull View view, @Nullable Object obj) {
        return (yc) ViewDataBinding.bind(obj, view, R.layout.item_seller_detail_card);
    }

    @NonNull
    public static yc e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static yc f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static yc g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (yc) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_seller_detail_card, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static yc h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (yc) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_seller_detail_card, null, false, obj);
    }

    @Nullable
    public e.l.g.u0 c() {
        return this.f14001f;
    }

    @Nullable
    public GameCard d() {
        return this.f14002g;
    }

    public abstract void i(@Nullable e.l.g.u0 u0Var);

    public abstract void j(@Nullable GameCard gameCard);
}
