package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.ApplyForItem;
import com.jihuanshe.ui.page.entrepot.ApplyForActivity;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class u8 extends ViewDataBinding {
    @NonNull
    public final NImageView a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f13705c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f13706d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f13707e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f13708f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextView f13709g;
    @Bindable

    /* renamed from: h  reason: collision with root package name */
    public ApplyForActivity f13710h;
    @Bindable

    /* renamed from: i  reason: collision with root package name */
    public ApplyForItem f13711i;

    public u8(Object obj, View view, int i2, NImageView nImageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(obj, view, i2);
        this.a = nImageView;
        this.b = textView;
        this.f13705c = textView2;
        this.f13706d = textView3;
        this.f13707e = textView4;
        this.f13708f = textView5;
        this.f13709g = textView6;
    }

    public static u8 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static u8 b(@NonNull View view, @Nullable Object obj) {
        return (u8) ViewDataBinding.bind(obj, view, R.layout.item_apply_for);
    }

    @NonNull
    public static u8 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static u8 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static u8 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (u8) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_apply_for, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static u8 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (u8) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_apply_for, null, false, obj);
    }

    @Nullable
    public ApplyForItem c() {
        return this.f13711i;
    }

    @Nullable
    public ApplyForActivity getActivity() {
        return this.f13710h;
    }

    public abstract void h(@Nullable ApplyForActivity applyForActivity);

    public abstract void i(@Nullable ApplyForItem applyForItem);
}
