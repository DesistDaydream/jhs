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
import com.jihuanshe.model.CardConsignmentInfo;
import com.jihuanshe.ui.page.entrepot.ConsignmentOrderFragment;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class g9 extends ViewDataBinding {
    @NonNull
    public final NImageView a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f12733c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f12734d;
    @Bindable

    /* renamed from: e  reason: collision with root package name */
    public ConsignmentOrderFragment f12735e;
    @Bindable

    /* renamed from: f  reason: collision with root package name */
    public CardConsignmentInfo f12736f;

    public g9(Object obj, View view, int i2, NImageView nImageView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i2);
        this.a = nImageView;
        this.b = textView;
        this.f12733c = textView2;
        this.f12734d = textView3;
    }

    public static g9 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static g9 b(@NonNull View view, @Nullable Object obj) {
        return (g9) ViewDataBinding.bind(obj, view, R.layout.item_card_con);
    }

    @NonNull
    public static g9 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static g9 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static g9 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (g9) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_card_con, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static g9 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (g9) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_card_con, null, false, obj);
    }

    @Nullable
    public ConsignmentOrderFragment c() {
        return this.f12735e;
    }

    @Nullable
    public CardConsignmentInfo d() {
        return this.f12736f;
    }

    public abstract void i(@Nullable ConsignmentOrderFragment consignmentOrderFragment);

    public abstract void j(@Nullable CardConsignmentInfo cardConsignmentInfo);
}
