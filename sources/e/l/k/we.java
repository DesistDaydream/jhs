package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.CardPackage;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class we extends ViewDataBinding {
    @NonNull
    public final NImageView a;
    @NonNull
    public final FrameLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f13877c;
    @Bindable

    /* renamed from: d  reason: collision with root package name */
    public CardPackage f13878d;
    @Bindable

    /* renamed from: e  reason: collision with root package name */
    public e.t.r.a.h f13879e;

    public we(Object obj, View view, int i2, NImageView nImageView, FrameLayout frameLayout, TextView textView) {
        super(obj, view, i2);
        this.a = nImageView;
        this.b = frameLayout;
        this.f13877c = textView;
    }

    public static we a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static we b(@NonNull View view, @Nullable Object obj) {
        return (we) ViewDataBinding.bind(obj, view, R.layout.view_card_package);
    }

    @NonNull
    public static we e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static we f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static we g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (we) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_card_package, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static we h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (we) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_card_package, null, false, obj);
    }

    @Nullable
    public CardPackage c() {
        return this.f13878d;
    }

    @Nullable
    public e.t.r.a.h d() {
        return this.f13879e;
    }

    public abstract void i(@Nullable CardPackage cardPackage);

    public abstract void j(@Nullable e.t.r.a.h hVar);
}
