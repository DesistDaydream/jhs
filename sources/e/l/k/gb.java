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
import com.jihuanshe.model.GameCard;

/* loaded from: classes2.dex */
public abstract class gb extends ViewDataBinding {
    @Bindable
    public GameCard a;

    public gb(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static gb a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static gb b(@NonNull View view, @Nullable Object obj) {
        return (gb) ViewDataBinding.bind(obj, view, R.layout.item_on_sell);
    }

    @NonNull
    public static gb d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static gb e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static gb f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (gb) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_on_sell, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static gb g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (gb) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_on_sell, null, false, obj);
    }

    @Nullable
    public GameCard c() {
        return this.a;
    }

    public abstract void h(@Nullable GameCard gameCard);
}
