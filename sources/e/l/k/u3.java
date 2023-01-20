package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.CardDetailDialog;
import com.jihuanshe.ui.widget.CardImageView;
import com.jihuanshe.ui.widget.FlexLayout;

/* loaded from: classes2.dex */
public abstract class u3 extends ViewDataBinding {
    @NonNull
    public final ImageView a;
    @NonNull
    public final FlexLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CardImageView f13684c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f13685d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final ScrollView f13686e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f13687f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextView f13688g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TextView f13689h;
    @Bindable

    /* renamed from: i  reason: collision with root package name */
    public CardDetailDialog f13690i;

    public u3(Object obj, View view, int i2, ImageView imageView, FlexLayout flexLayout, CardImageView cardImageView, TextView textView, ScrollView scrollView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i2);
        this.a = imageView;
        this.b = flexLayout;
        this.f13684c = cardImageView;
        this.f13685d = textView;
        this.f13686e = scrollView;
        this.f13687f = textView2;
        this.f13688g = textView3;
        this.f13689h = textView4;
    }

    public static u3 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static u3 b(@NonNull View view, @Nullable Object obj) {
        return (u3) ViewDataBinding.bind(obj, view, R.layout.dialog_card_detail);
    }

    @NonNull
    public static u3 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static u3 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static u3 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (u3) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_card_detail, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static u3 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (u3) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_card_detail, null, false, obj);
    }

    @Nullable
    public CardDetailDialog c() {
        return this.f13690i;
    }

    public abstract void h(@Nullable CardDetailDialog cardDetailDialog);
}
