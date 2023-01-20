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
import com.jihuanshe.ui.dialog.CardBaseInfoDetailDialog;
import com.jihuanshe.ui.widget.CardImageView;
import com.jihuanshe.ui.widget.CopyTextView;
import com.jihuanshe.ui.widget.FlexLayout;

/* loaded from: classes2.dex */
public abstract class q3 extends ViewDataBinding {
    @NonNull
    public final ImageView a;
    @NonNull
    public final FlexLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CardImageView f13408c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CopyTextView f13409d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final ScrollView f13410e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final CopyTextView f13411f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final CopyTextView f13412g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TextView f13413h;
    @Bindable

    /* renamed from: i  reason: collision with root package name */
    public CardBaseInfoDetailDialog f13414i;

    public q3(Object obj, View view, int i2, ImageView imageView, FlexLayout flexLayout, CardImageView cardImageView, CopyTextView copyTextView, ScrollView scrollView, CopyTextView copyTextView2, CopyTextView copyTextView3, TextView textView) {
        super(obj, view, i2);
        this.a = imageView;
        this.b = flexLayout;
        this.f13408c = cardImageView;
        this.f13409d = copyTextView;
        this.f13410e = scrollView;
        this.f13411f = copyTextView2;
        this.f13412g = copyTextView3;
        this.f13413h = textView;
    }

    public static q3 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static q3 b(@NonNull View view, @Nullable Object obj) {
        return (q3) ViewDataBinding.bind(obj, view, R.layout.dialog_card_base_info_detail);
    }

    @NonNull
    public static q3 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static q3 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static q3 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (q3) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_card_base_info_detail, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static q3 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (q3) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_card_base_info_detail, null, false, obj);
    }

    @Nullable
    public CardBaseInfoDetailDialog c() {
        return this.f13414i;
    }

    public abstract void h(@Nullable CardBaseInfoDetailDialog cardBaseInfoDetailDialog);
}
