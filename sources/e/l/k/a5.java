package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.HomeWantSellDialog;

/* loaded from: classes2.dex */
public abstract class a5 extends ViewDataBinding {
    @NonNull
    public final ImageView a;
    @NonNull
    public final LinearLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f12260c;
    @Bindable

    /* renamed from: d  reason: collision with root package name */
    public HomeWantSellDialog f12261d;

    public a5(Object obj, View view, int i2, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2) {
        super(obj, view, i2);
        this.a = imageView;
        this.b = linearLayout;
        this.f12260c = linearLayout2;
    }

    public static a5 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static a5 b(@NonNull View view, @Nullable Object obj) {
        return (a5) ViewDataBinding.bind(obj, view, R.layout.dialog_home_want_sell);
    }

    @NonNull
    public static a5 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static a5 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static a5 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (a5) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_home_want_sell, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static a5 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (a5) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_home_want_sell, null, false, obj);
    }

    @Nullable
    public HomeWantSellDialog c() {
        return this.f12261d;
    }

    public abstract void h(@Nullable HomeWantSellDialog homeWantSellDialog);
}
