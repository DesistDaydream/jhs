package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;

/* loaded from: classes2.dex */
public abstract class mf extends ViewDataBinding {
    @NonNull
    public final TextView a;

    public mf(Object obj, View view, int i2, TextView textView) {
        super(obj, view, i2);
        this.a = textView;
    }

    public static mf a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static mf b(@NonNull View view, @Nullable Object obj) {
        return (mf) ViewDataBinding.bind(obj, view, R.layout.view_game_bar_drop);
    }

    @NonNull
    public static mf c(@NonNull LayoutInflater layoutInflater) {
        return f(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static mf d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return e(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static mf e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (mf) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_game_bar_drop, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static mf f(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (mf) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_game_bar_drop, null, false, obj);
    }
}
