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
import com.jihuanshe.ui.widget.UserBar;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class qg extends ViewDataBinding {
    @NonNull
    public final ImageView a;
    @NonNull
    public final NImageView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f13450c;
    @Bindable

    /* renamed from: d  reason: collision with root package name */
    public UserBar f13451d;

    public qg(Object obj, View view, int i2, ImageView imageView, NImageView nImageView, TextView textView) {
        super(obj, view, i2);
        this.a = imageView;
        this.b = nImageView;
        this.f13450c = textView;
    }

    public static qg a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static qg b(@NonNull View view, @Nullable Object obj) {
        return (qg) ViewDataBinding.bind(obj, view, R.layout.view_user_bar);
    }

    @NonNull
    public static qg d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static qg e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static qg f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (qg) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_user_bar, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static qg g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (qg) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_user_bar, null, false, obj);
    }

    @Nullable
    public UserBar c() {
        return this.f13451d;
    }

    public abstract void h(@Nullable UserBar userBar);
}
