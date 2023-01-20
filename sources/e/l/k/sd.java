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
import com.jihuanshe.model.WantCard;
import com.jihuanshe.ui.widget.CardImageView;

/* loaded from: classes2.dex */
public abstract class sd extends ViewDataBinding {
    @NonNull
    public final CardImageView a;
    @NonNull
    public final LinearLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f13572c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f13573d;
    @Bindable

    /* renamed from: e  reason: collision with root package name */
    public WantCard f13574e;
    @Bindable

    /* renamed from: f  reason: collision with root package name */
    public e.t.r.a.h f13575f;

    public sd(Object obj, View view, int i2, CardImageView cardImageView, LinearLayout linearLayout, TextView textView, TextView textView2) {
        super(obj, view, i2);
        this.a = cardImageView;
        this.b = linearLayout;
        this.f13572c = textView;
        this.f13573d = textView2;
    }

    public static sd a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static sd b(@NonNull View view, @Nullable Object obj) {
        return (sd) ViewDataBinding.bind(obj, view, R.layout.item_want_card_new);
    }

    @NonNull
    public static sd e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static sd f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static sd g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (sd) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_want_card_new, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static sd h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (sd) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_want_card_new, null, false, obj);
    }

    @Nullable
    public WantCard c() {
        return this.f13574e;
    }

    @Nullable
    public e.t.r.a.h d() {
        return this.f13575f;
    }

    public abstract void i(@Nullable WantCard wantCard);

    public abstract void j(@Nullable e.t.r.a.h hVar);
}
