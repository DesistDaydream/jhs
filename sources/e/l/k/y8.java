package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
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
public abstract class y8 extends ViewDataBinding {
    @NonNull
    public final CheckBox a;
    @NonNull
    public final NImageView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f13971c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f13972d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f13973e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f13974f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextView f13975g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TextView f13976h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final TextView f13977i;
    @Bindable

    /* renamed from: j  reason: collision with root package name */
    public ApplyForReturnActivity f13978j;
    @Bindable

    /* renamed from: k  reason: collision with root package name */
    public ReturnCardInfo f13979k;

    public y8(Object obj, View view, int i2, CheckBox checkBox, NImageView nImageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        super(obj, view, i2);
        this.a = checkBox;
        this.b = nImageView;
        this.f13971c = textView;
        this.f13972d = textView2;
        this.f13973e = textView3;
        this.f13974f = textView4;
        this.f13975g = textView5;
        this.f13976h = textView6;
        this.f13977i = textView7;
    }

    public static y8 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static y8 b(@NonNull View view, @Nullable Object obj) {
        return (y8) ViewDataBinding.bind(obj, view, R.layout.item_apply_for_return_part);
    }

    @NonNull
    public static y8 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static y8 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static y8 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (y8) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_apply_for_return_part, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static y8 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (y8) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_apply_for_return_part, null, false, obj);
    }

    @Nullable
    public ReturnCardInfo c() {
        return this.f13979k;
    }

    @Nullable
    public ApplyForReturnActivity getActivity() {
        return this.f13978j;
    }

    public abstract void h(@Nullable ApplyForReturnActivity applyForReturnActivity);

    public abstract void i(@Nullable ReturnCardInfo returnCardInfo);
}
