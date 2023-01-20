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
import com.jihuanshe.ui.widget.GamePopupWindow;

/* loaded from: classes2.dex */
public abstract class ie extends ViewDataBinding {
    @Bindable
    public GamePopupWindow a;

    public ie(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static ie a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ie b(@NonNull View view, @Nullable Object obj) {
        return (ie) ViewDataBinding.bind(obj, view, R.layout.pop_game_bar);
    }

    @NonNull
    public static ie d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ie e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ie f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ie) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pop_game_bar, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ie g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ie) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pop_game_bar, null, false, obj);
    }

    @Nullable
    public GamePopupWindow c() {
        return this.a;
    }

    public abstract void h(@Nullable GamePopupWindow gamePopupWindow);
}
