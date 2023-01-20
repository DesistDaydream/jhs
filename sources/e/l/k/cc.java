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
import com.jihuanshe.model.RankCardInfo;
import com.jihuanshe.ui.widget.CardImageView;
import com.jihuanshe.ui.widget.ScoreView;

/* loaded from: classes2.dex */
public abstract class cc extends ViewDataBinding {
    @NonNull
    public final CardImageView a;
    @NonNull
    public final ScoreView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f12434c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f12435d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final ScoreView f12436e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f12437f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextView f12438g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TextView f12439h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final TextView f12440i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final TextView f12441j;
    @Bindable

    /* renamed from: k  reason: collision with root package name */
    public e.l.g.p0 f12442k;
    @Bindable

    /* renamed from: l  reason: collision with root package name */
    public RankCardInfo f12443l;

    public cc(Object obj, View view, int i2, CardImageView cardImageView, ScoreView scoreView, TextView textView, TextView textView2, ScoreView scoreView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        super(obj, view, i2);
        this.a = cardImageView;
        this.b = scoreView;
        this.f12434c = textView;
        this.f12435d = textView2;
        this.f12436e = scoreView2;
        this.f12437f = textView3;
        this.f12438g = textView4;
        this.f12439h = textView5;
        this.f12440i = textView6;
        this.f12441j = textView7;
    }

    public static cc a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static cc b(@NonNull View view, @Nullable Object obj) {
        return (cc) ViewDataBinding.bind(obj, view, R.layout.item_rank_card);
    }

    @NonNull
    public static cc e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static cc f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static cc g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (cc) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_rank_card, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static cc h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (cc) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_rank_card, null, false, obj);
    }

    @Nullable
    public e.l.g.p0 c() {
        return this.f12442k;
    }

    @Nullable
    public RankCardInfo d() {
        return this.f12443l;
    }

    public abstract void i(@Nullable e.l.g.p0 p0Var);

    public abstract void j(@Nullable RankCardInfo rankCardInfo);
}
