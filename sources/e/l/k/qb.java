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
import com.jihuanshe.model.CardVersionInfo;
import com.jihuanshe.ui.widget.CardImageView;
import com.jihuanshe.ui.widget.ScoreView;

/* loaded from: classes2.dex */
public abstract class qb extends ViewDataBinding {
    @NonNull
    public final CardImageView a;
    @NonNull
    public final ScoreView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f13431c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f13432d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f13433e;
    @Bindable

    /* renamed from: f  reason: collision with root package name */
    public e.l.g.l f13434f;
    @Bindable

    /* renamed from: g  reason: collision with root package name */
    public CardVersionInfo f13435g;
    @Bindable

    /* renamed from: h  reason: collision with root package name */
    public e.t.r.a.h f13436h;

    public qb(Object obj, View view, int i2, CardImageView cardImageView, ScoreView scoreView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i2);
        this.a = cardImageView;
        this.b = scoreView;
        this.f13431c = textView;
        this.f13432d = textView2;
        this.f13433e = textView3;
    }

    public static qb a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static qb b(@NonNull View view, @Nullable Object obj) {
        return (qb) ViewDataBinding.bind(obj, view, R.layout.item_pack_card_list);
    }

    @NonNull
    public static qb f(@NonNull LayoutInflater layoutInflater) {
        return i(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static qb g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return h(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static qb h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (qb) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_pack_card_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static qb i(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (qb) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_pack_card_list, null, false, obj);
    }

    @Nullable
    public e.l.g.l c() {
        return this.f13434f;
    }

    @Nullable
    public CardVersionInfo d() {
        return this.f13435g;
    }

    @Nullable
    public e.t.r.a.h e() {
        return this.f13436h;
    }

    public abstract void j(@Nullable e.l.g.l lVar);

    public abstract void k(@Nullable CardVersionInfo cardVersionInfo);

    public abstract void l(@Nullable e.t.r.a.h hVar);
}
