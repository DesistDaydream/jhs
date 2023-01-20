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
import com.jihuanshe.model.Game;

/* loaded from: classes2.dex */
public abstract class wb extends ViewDataBinding {
    @Bindable
    public Game a;

    public wb(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static wb a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static wb b(@NonNull View view, @Nullable Object obj) {
        return (wb) ViewDataBinding.bind(obj, view, R.layout.item_pop_game);
    }

    @NonNull
    public static wb d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static wb e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static wb f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (wb) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_pop_game, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static wb g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (wb) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_pop_game, null, false, obj);
    }

    @Nullable
    public Game c() {
        return this.a;
    }

    public abstract void h(@Nullable Game game);
}
