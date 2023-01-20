package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.GameCard;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class i9 extends ViewDataBinding {
    @NonNull
    public final NImageView a;
    @NonNull
    public final NImageView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f12870c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f12871d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f12872e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f12873f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextView f12874g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TextView f12875h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final TextView f12876i;
    @Bindable

    /* renamed from: j  reason: collision with root package name */
    public GameCard f12877j;
    @Bindable

    /* renamed from: k  reason: collision with root package name */
    public e.t.r.a.h f12878k;

    public i9(Object obj, View view, int i2, NImageView nImageView, NImageView nImageView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        super(obj, view, i2);
        this.a = nImageView;
        this.b = nImageView2;
        this.f12870c = textView;
        this.f12871d = textView2;
        this.f12872e = textView3;
        this.f12873f = textView4;
        this.f12874g = textView5;
        this.f12875h = textView6;
        this.f12876i = textView7;
    }

    public static i9 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static i9 b(@NonNull View view, @Nullable Object obj) {
        return (i9) ViewDataBinding.bind(obj, view, R.layout.item_card_detail);
    }

    @NonNull
    public static i9 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static i9 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static i9 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (i9) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_card_detail, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static i9 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (i9) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_card_detail, null, false, obj);
    }

    @Nullable
    public GameCard c() {
        return this.f12877j;
    }

    @Nullable
    public e.t.r.a.h d() {
        return this.f12878k;
    }

    public abstract void i(@Nullable GameCard gameCard);

    public abstract void j(@Nullable e.t.r.a.h hVar);
}
