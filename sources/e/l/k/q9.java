package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.CardProduct;

/* loaded from: classes2.dex */
public abstract class q9 extends ViewDataBinding {
    @Bindable
    public CardProduct a;
    @Bindable
    public e.l.g.m b;

    public q9(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static q9 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static q9 b(@NonNull View view, @Nullable Object obj) {
        return (q9) ViewDataBinding.bind(obj, view, R.layout.item_card_product);
    }

    @NonNull
    public static q9 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static q9 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static q9 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (q9) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_card_product, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static q9 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (q9) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_card_product, null, false, obj);
    }

    @Nullable
    public CardProduct c() {
        return this.a;
    }

    @Nullable
    public e.l.g.m d() {
        return this.b;
    }

    public abstract void i(@Nullable CardProduct cardProduct);

    public abstract void j(@Nullable e.l.g.m mVar);
}
