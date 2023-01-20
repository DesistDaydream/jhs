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
import com.jihuanshe.adapter.LikeAdapter;
import com.jihuanshe.model.InteractData;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class wa extends ViewDataBinding {
    @NonNull
    public final NImageView a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final FrameLayout f13852c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final View f13853d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final View f13854e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f13855f;
    @Bindable

    /* renamed from: g  reason: collision with root package name */
    public LikeAdapter f13856g;
    @Bindable

    /* renamed from: h  reason: collision with root package name */
    public InteractData f13857h;
    @Bindable

    /* renamed from: i  reason: collision with root package name */
    public Integer f13858i;

    public wa(Object obj, View view, int i2, NImageView nImageView, TextView textView, FrameLayout frameLayout, View view2, View view3, TextView textView2) {
        super(obj, view, i2);
        this.a = nImageView;
        this.b = textView;
        this.f13852c = frameLayout;
        this.f13853d = view2;
        this.f13854e = view3;
        this.f13855f = textView2;
    }

    public static wa a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static wa b(@NonNull View view, @Nullable Object obj) {
        return (wa) ViewDataBinding.bind(obj, view, R.layout.item_like);
    }

    @NonNull
    public static wa f(@NonNull LayoutInflater layoutInflater) {
        return i(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static wa g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return h(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static wa h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (wa) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_like, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static wa i(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (wa) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_like, null, false, obj);
    }

    @Nullable
    public LikeAdapter c() {
        return this.f13856g;
    }

    @Nullable
    public InteractData d() {
        return this.f13857h;
    }

    @Nullable
    public Integer e() {
        return this.f13858i;
    }

    public abstract void j(@Nullable LikeAdapter likeAdapter);

    public abstract void k(@Nullable InteractData interactData);

    public abstract void l(@Nullable Integer num);
}
