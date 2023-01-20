package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.MatchResult;
import com.jihuanshe.ui.widget.CardImageView;
import com.jihuanshe.ui.widget.RankImageView;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class ya extends ViewDataBinding {
    @NonNull
    public final NImageView a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CardImageView f13987c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final RankImageView f13988d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f13989e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f13990f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextView f13991g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TextView f13992h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final TextView f13993i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final ImageView f13994j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final TextView f13995k;
    @Bindable

    /* renamed from: l  reason: collision with root package name */
    public MatchResult f13996l;
    @Bindable

    /* renamed from: m  reason: collision with root package name */
    public e.l.g.e0 f13997m;

    public ya(Object obj, View view, int i2, NImageView nImageView, TextView textView, CardImageView cardImageView, RankImageView rankImageView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, ImageView imageView, TextView textView7) {
        super(obj, view, i2);
        this.a = nImageView;
        this.b = textView;
        this.f13987c = cardImageView;
        this.f13988d = rankImageView;
        this.f13989e = textView2;
        this.f13990f = textView3;
        this.f13991g = textView4;
        this.f13992h = textView5;
        this.f13993i = textView6;
        this.f13994j = imageView;
        this.f13995k = textView7;
    }

    public static ya a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ya b(@NonNull View view, @Nullable Object obj) {
        return (ya) ViewDataBinding.bind(obj, view, R.layout.item_match);
    }

    @NonNull
    public static ya e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ya f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ya g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ya) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_match, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ya h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ya) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_match, null, false, obj);
    }

    @Nullable
    public e.l.g.e0 c() {
        return this.f13997m;
    }

    @Nullable
    public MatchResult d() {
        return this.f13996l;
    }

    public abstract void i(@Nullable e.l.g.e0 e0Var);

    public abstract void j(@Nullable MatchResult matchResult);
}
