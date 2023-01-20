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
import com.jihuanshe.model.CardVersionInfo;
import com.jihuanshe.ui.dialog.CardPackListDialog;
import com.jihuanshe.ui.widget.ScoreView;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class o9 extends ViewDataBinding {
    @NonNull
    public final NImageView a;
    @NonNull
    public final LinearLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ScoreView f13253c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f13254d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f13255e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f13256f;
    @Bindable

    /* renamed from: g  reason: collision with root package name */
    public CardPackListDialog f13257g;
    @Bindable

    /* renamed from: h  reason: collision with root package name */
    public e.l.g.k f13258h;
    @Bindable

    /* renamed from: i  reason: collision with root package name */
    public CardVersionInfo f13259i;
    @Bindable

    /* renamed from: j  reason: collision with root package name */
    public e.t.r.a.h f13260j;

    public o9(Object obj, View view, int i2, NImageView nImageView, LinearLayout linearLayout, ScoreView scoreView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i2);
        this.a = nImageView;
        this.b = linearLayout;
        this.f13253c = scoreView;
        this.f13254d = textView;
        this.f13255e = textView2;
        this.f13256f = textView3;
    }

    public static o9 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static o9 b(@NonNull View view, @Nullable Object obj) {
        return (o9) ViewDataBinding.bind(obj, view, R.layout.item_card_pack_list);
    }

    @NonNull
    public static o9 g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static o9 h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static o9 i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (o9) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_card_pack_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static o9 j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (o9) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_card_pack_list, null, false, obj);
    }

    @Nullable
    public e.l.g.k c() {
        return this.f13258h;
    }

    @Nullable
    public CardPackListDialog d() {
        return this.f13257g;
    }

    @Nullable
    public CardVersionInfo e() {
        return this.f13259i;
    }

    @Nullable
    public e.t.r.a.h f() {
        return this.f13260j;
    }

    public abstract void k(@Nullable e.l.g.k kVar);

    public abstract void l(@Nullable CardPackListDialog cardPackListDialog);

    public abstract void m(@Nullable CardVersionInfo cardVersionInfo);

    public abstract void n(@Nullable e.t.r.a.h hVar);
}
