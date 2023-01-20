package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.CardPackage;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class ye extends ViewDataBinding {
    @NonNull
    public final ConstraintLayout a;
    @NonNull
    public final FrameLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final NImageView f14003c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f14004d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f14005e;
    @Bindable

    /* renamed from: f  reason: collision with root package name */
    public CardPackage f14006f;
    @Bindable

    /* renamed from: g  reason: collision with root package name */
    public e.t.r.a.h f14007g;

    public ye(Object obj, View view, int i2, ConstraintLayout constraintLayout, FrameLayout frameLayout, NImageView nImageView, TextView textView, LinearLayout linearLayout) {
        super(obj, view, i2);
        this.a = constraintLayout;
        this.b = frameLayout;
        this.f14003c = nImageView;
        this.f14004d = textView;
        this.f14005e = linearLayout;
    }

    public static ye a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ye b(@NonNull View view, @Nullable Object obj) {
        return (ye) ViewDataBinding.bind(obj, view, R.layout.view_card_package_first);
    }

    @NonNull
    public static ye e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ye f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ye g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ye) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_card_package_first, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ye h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ye) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_card_package_first, null, false, obj);
    }

    @Nullable
    public CardPackage c() {
        return this.f14006f;
    }

    @Nullable
    public e.t.r.a.h d() {
        return this.f14007g;
    }

    public abstract void i(@Nullable CardPackage cardPackage);

    public abstract void j(@Nullable e.t.r.a.h hVar);
}
