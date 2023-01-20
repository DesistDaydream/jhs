package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.ui.widget.CardImageView;

/* loaded from: classes2.dex */
public abstract class oa extends ViewDataBinding {
    @NonNull
    public final ConstraintLayout a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CardImageView f13261c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f13262d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f13263e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f13264f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextView f13265g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TextView f13266h;
    @Bindable

    /* renamed from: i  reason: collision with root package name */
    public e.l.g.f f13267i;
    @Bindable

    /* renamed from: j  reason: collision with root package name */
    public GameCard f13268j;

    public oa(Object obj, View view, int i2, ConstraintLayout constraintLayout, TextView textView, CardImageView cardImageView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(obj, view, i2);
        this.a = constraintLayout;
        this.b = textView;
        this.f13261c = cardImageView;
        this.f13262d = textView2;
        this.f13263e = textView3;
        this.f13264f = textView4;
        this.f13265g = textView5;
        this.f13266h = textView6;
    }

    public static oa a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static oa b(@NonNull View view, @Nullable Object obj) {
        return (oa) ViewDataBinding.bind(obj, view, R.layout.item_game_card2);
    }

    @NonNull
    public static oa e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static oa f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static oa g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (oa) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_game_card2, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static oa h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (oa) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_game_card2, null, false, obj);
    }

    @Nullable
    public e.l.g.f c() {
        return this.f13267i;
    }

    @Nullable
    public GameCard d() {
        return this.f13268j;
    }

    public abstract void i(@Nullable e.l.g.f fVar);

    public abstract void j(@Nullable GameCard gameCard);
}
