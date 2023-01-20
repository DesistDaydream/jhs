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
import com.jihuanshe.model.ReturnCardInfo;
import com.jihuanshe.ui.page.entrepot.ApplyForReturnActivity;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class w8 extends ViewDataBinding {
    @NonNull
    public final NImageView a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f13841c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f13842d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f13843e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f13844f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextView f13845g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TextView f13846h;
    @Bindable

    /* renamed from: i  reason: collision with root package name */
    public ApplyForReturnActivity f13847i;
    @Bindable

    /* renamed from: j  reason: collision with root package name */
    public ReturnCardInfo f13848j;

    public w8(Object obj, View view, int i2, NImageView nImageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        super(obj, view, i2);
        this.a = nImageView;
        this.b = textView;
        this.f13841c = textView2;
        this.f13842d = textView3;
        this.f13843e = textView4;
        this.f13844f = textView5;
        this.f13845g = textView6;
        this.f13846h = textView7;
    }

    public static w8 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static w8 b(@NonNull View view, @Nullable Object obj) {
        return (w8) ViewDataBinding.bind(obj, view, R.layout.item_apply_for_return);
    }

    @NonNull
    public static w8 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static w8 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static w8 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (w8) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_apply_for_return, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static w8 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (w8) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_apply_for_return, null, false, obj);
    }

    @Nullable
    public ReturnCardInfo c() {
        return this.f13848j;
    }

    @Nullable
    public ApplyForReturnActivity getActivity() {
        return this.f13847i;
    }

    public abstract void h(@Nullable ApplyForReturnActivity applyForReturnActivity);

    public abstract void i(@Nullable ReturnCardInfo returnCardInfo);
}
