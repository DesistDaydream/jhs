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
public abstract class qa extends ViewDataBinding {
    @NonNull
    public final CardImageView a;
    @NonNull
    public final LinearLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f13425c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f13426d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f13427e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f13428f;
    @Bindable

    /* renamed from: g  reason: collision with root package name */
    public e.l.g.g f13429g;
    @Bindable

    /* renamed from: h  reason: collision with root package name */
    public GameCard f13430h;

    public qa(Object obj, View view, int i2, CardImageView cardImageView, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i2);
        this.a = cardImageView;
        this.b = linearLayout;
        this.f13425c = linearLayout2;
        this.f13426d = textView;
        this.f13427e = textView2;
        this.f13428f = textView3;
    }

    public static qa a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static qa b(@NonNull View view, @Nullable Object obj) {
        return (qa) ViewDataBinding.bind(obj, view, R.layout.item_game_card);
    }

    @NonNull
    public static qa e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static qa f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static qa g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (qa) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_game_card, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static qa h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (qa) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_game_card, null, false, obj);
    }

    @Nullable
    public e.l.g.g c() {
        return this.f13429g;
    }

    @Nullable
    public GameCard d() {
        return this.f13430h;
    }

    public abstract void i(@Nullable e.l.g.g gVar);

    public abstract void j(@Nullable GameCard gameCard);
}
