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
public abstract class of extends ViewDataBinding {
    @NonNull
    public final TextView a;

    public of(Object obj, View view, int i2, TextView textView) {
        super(obj, view, i2);
        this.a = textView;
    }

    public static of a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static of b(@NonNull View view, @Nullable Object obj) {
        return (of) ViewDataBinding.bind(obj, view, R.layout.view_game_drop_box);
    }

    @NonNull
    public static of c(@NonNull LayoutInflater layoutInflater) {
        return f(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static of d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return e(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static of e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (of) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_game_drop_box, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static of f(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (of) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_game_drop_box, null, false, obj);
    }
}
