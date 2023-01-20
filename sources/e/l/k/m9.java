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

/* loaded from: classes2.dex */
public abstract class m9 extends ViewDataBinding {
    @NonNull
    public final CardImageView a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f13122c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f13123d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f13124e;
    @Bindable

    /* renamed from: f  reason: collision with root package name */
    public GameCard f13125f;

    public m9(Object obj, View view, int i2, CardImageView cardImageView, TextView textView, ImageView imageView, TextView textView2, TextView textView3) {
        super(obj, view, i2);
        this.a = cardImageView;
        this.b = textView;
        this.f13122c = imageView;
        this.f13123d = textView2;
        this.f13124e = textView3;
    }

    public static m9 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static m9 b(@NonNull View view, @Nullable Object obj) {
        return (m9) ViewDataBinding.bind(obj, view, R.layout.item_card_list);
    }

    @NonNull
    public static m9 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static m9 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static m9 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (m9) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_card_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static m9 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (m9) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_card_list, null, false, obj);
    }

    @Nullable
    public GameCard c() {
        return this.f13125f;
    }

    public abstract void h(@Nullable GameCard gameCard);
}
