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
import com.jihuanshe.adapter.AtMeAdapter;
import com.jihuanshe.model.InteractData;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class a9 extends ViewDataBinding {
    @NonNull
    public final NImageView a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f12275c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final FrameLayout f12276d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final View f12277e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final View f12278f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextView f12279g;
    @Bindable

    /* renamed from: h  reason: collision with root package name */
    public AtMeAdapter f12280h;
    @Bindable

    /* renamed from: i  reason: collision with root package name */
    public InteractData f12281i;
    @Bindable

    /* renamed from: j  reason: collision with root package name */
    public Integer f12282j;

    public a9(Object obj, View view, int i2, NImageView nImageView, TextView textView, TextView textView2, FrameLayout frameLayout, View view2, View view3, TextView textView3) {
        super(obj, view, i2);
        this.a = nImageView;
        this.b = textView;
        this.f12275c = textView2;
        this.f12276d = frameLayout;
        this.f12277e = view2;
        this.f12278f = view3;
        this.f12279g = textView3;
    }

    public static a9 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static a9 b(@NonNull View view, @Nullable Object obj) {
        return (a9) ViewDataBinding.bind(obj, view, R.layout.item_at_me);
    }

    @NonNull
    public static a9 f(@NonNull LayoutInflater layoutInflater) {
        return i(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static a9 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return h(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static a9 h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (a9) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_at_me, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static a9 i(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (a9) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_at_me, null, false, obj);
    }

    @Nullable
    public AtMeAdapter c() {
        return this.f12280h;
    }

    @Nullable
    public InteractData d() {
        return this.f12281i;
    }

    @Nullable
    public Integer e() {
        return this.f12282j;
    }

    public abstract void j(@Nullable AtMeAdapter atMeAdapter);

    public abstract void k(@Nullable InteractData interactData);

    public abstract void l(@Nullable Integer num);
}
