package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.PosterDialog;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class k5 extends ViewDataBinding {
    @NonNull
    public final ImageView a;
    @NonNull
    public final View b;
    @NonNull

    /* renamed from: c */
    public final NImageView f13001c;
    @Bindable

    /* renamed from: d */
    public PosterDialog f13002d;

    public k5(Object obj, View view, int i2, ImageView imageView, View view2, NImageView nImageView) {
        super(obj, view, i2);
        this.a = imageView;
        this.b = view2;
        this.f13001c = nImageView;
    }

    public static k5 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static k5 b(@NonNull View view, @Nullable Object obj) {
        return (k5) ViewDataBinding.bind(obj, view, R.layout.dialog_poster);
    }

    @NonNull
    public static k5 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static k5 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static k5 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (k5) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_poster, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static k5 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (k5) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_poster, null, false, obj);
    }

    @Nullable
    public PosterDialog c() {
        return this.f13002d;
    }

    public abstract void h(@Nullable PosterDialog posterDialog);
}
