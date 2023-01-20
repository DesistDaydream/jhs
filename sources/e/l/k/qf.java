package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.widget.GameBarSmall;

/* loaded from: classes2.dex */
public abstract class qf extends ViewDataBinding {
    @NonNull
    public final ImageView a;
    @NonNull
    public final TextView b;
    @Bindable

    /* renamed from: c  reason: collision with root package name */
    public GameBarSmall f13449c;

    public qf(Object obj, View view, int i2, ImageView imageView, TextView textView) {
        super(obj, view, i2);
        this.a = imageView;
        this.b = textView;
    }

    public static qf a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static qf b(@NonNull View view, @Nullable Object obj) {
        return (qf) ViewDataBinding.bind(obj, view, R.layout.view_game_drop_box_small);
    }

    @NonNull
    public static qf d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static qf e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static qf f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (qf) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_game_drop_box_small, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static qf g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (qf) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_game_drop_box_small, null, false, obj);
    }

    @Nullable
    public GameBarSmall c() {
        return this.f13449c;
    }

    public abstract void h(@Nullable GameBarSmall gameBarSmall);
}
