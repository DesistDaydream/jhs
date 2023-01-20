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
import com.jihuanshe.model.GameCard;
import com.jihuanshe.ui.widget.CardImageView;
import com.jihuanshe.ui.widget.RankImageView;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class k9 extends ViewDataBinding {
    @NonNull
    public final NImageView a;
    @NonNull
    public final CardImageView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final RankImageView f13005c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f13006d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f13007e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f13008f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextView f13009g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final ImageView f13010h;
    @Bindable

    /* renamed from: i  reason: collision with root package name */
    public e.l.g.h f13011i;
    @Bindable

    /* renamed from: j  reason: collision with root package name */
    public GameCard f13012j;
    @Bindable

    /* renamed from: k  reason: collision with root package name */
    public e.t.r.a.h f13013k;

    public k9(Object obj, View view, int i2, NImageView nImageView, CardImageView cardImageView, RankImageView rankImageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, ImageView imageView) {
        super(obj, view, i2);
        this.a = nImageView;
        this.b = cardImageView;
        this.f13005c = rankImageView;
        this.f13006d = textView;
        this.f13007e = textView2;
        this.f13008f = textView3;
        this.f13009g = textView4;
        this.f13010h = imageView;
    }

    public static k9 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static k9 b(@NonNull View view, @Nullable Object obj) {
        return (k9) ViewDataBinding.bind(obj, view, R.layout.item_card_detail_list);
    }

    @NonNull
    public static k9 f(@NonNull LayoutInflater layoutInflater) {
        return i(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static k9 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return h(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static k9 h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (k9) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_card_detail_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static k9 i(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (k9) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_card_detail_list, null, false, obj);
    }

    @Nullable
    public e.l.g.h c() {
        return this.f13011i;
    }

    @Nullable
    public GameCard d() {
        return this.f13012j;
    }

    @Nullable
    public e.t.r.a.h e() {
        return this.f13013k;
    }

    public abstract void j(@Nullable e.l.g.h hVar);

    public abstract void k(@Nullable GameCard gameCard);

    public abstract void l(@Nullable e.t.r.a.h hVar);
}
