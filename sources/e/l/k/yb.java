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
public abstract class yb extends ViewDataBinding {
    @Bindable
    public e.l.g.y a;
    @Bindable
    public Game b;

    public yb(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static yb a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static yb b(@NonNull View view, @Nullable Object obj) {
        return (yb) ViewDataBinding.bind(obj, view, R.layout.item_pop_game_filter);
    }

    @NonNull
    public static yb e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static yb f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static yb g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (yb) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_pop_game_filter, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static yb h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (yb) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_pop_game_filter, null, false, obj);
    }

    @Nullable
    public e.l.g.y c() {
        return this.a;
    }

    @Nullable
    public Game d() {
        return this.b;
    }

    public abstract void i(@Nullable e.l.g.y yVar);

    public abstract void j(@Nullable Game game);
}
