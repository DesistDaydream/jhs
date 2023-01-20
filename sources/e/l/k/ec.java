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
import com.jihuanshe.model.RankCardInfo;
import com.jihuanshe.ui.widget.ScoreView;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class ec extends ViewDataBinding {
    @NonNull
    public final ConstraintLayout a;
    @NonNull
    public final NImageView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ScoreView f12578c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f12579d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final ScoreView f12580e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f12581f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextView f12582g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TextView f12583h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final TextView f12584i;
    @Bindable

    /* renamed from: j  reason: collision with root package name */
    public e.l.g.p0 f12585j;
    @Bindable

    /* renamed from: k  reason: collision with root package name */
    public RankCardInfo f12586k;

    public ec(Object obj, View view, int i2, ConstraintLayout constraintLayout, NImageView nImageView, ScoreView scoreView, TextView textView, ScoreView scoreView2, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, i2);
        this.a = constraintLayout;
        this.b = nImageView;
        this.f12578c = scoreView;
        this.f12579d = textView;
        this.f12580e = scoreView2;
        this.f12581f = textView2;
        this.f12582g = textView3;
        this.f12583h = textView4;
        this.f12584i = textView5;
    }

    public static ec a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ec b(@NonNull View view, @Nullable Object obj) {
        return (ec) ViewDataBinding.bind(obj, view, R.layout.item_rank_pack);
    }

    @NonNull
    public static ec e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ec f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ec g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ec) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_rank_pack, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ec h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ec) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_rank_pack, null, false, obj);
    }

    @Nullable
    public e.l.g.p0 c() {
        return this.f12585j;
    }

    @Nullable
    public RankCardInfo d() {
        return this.f12586k;
    }

    public abstract void i(@Nullable e.l.g.p0 p0Var);

    public abstract void j(@Nullable RankCardInfo rankCardInfo);
}
