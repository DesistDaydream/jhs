package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.ShareDialog;

/* loaded from: classes2.dex */
public abstract class s5 extends ViewDataBinding {
    @NonNull
    public final TextView a;
    @NonNull
    public final LinearLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f13551c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f13552d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f13553e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f13554f;
    @Bindable

    /* renamed from: g  reason: collision with root package name */
    public ShareDialog f13555g;

    public s5(Object obj, View view, int i2, TextView textView, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView2, LinearLayout linearLayout3, LinearLayout linearLayout4) {
        super(obj, view, i2);
        this.a = textView;
        this.b = linearLayout;
        this.f13551c = linearLayout2;
        this.f13552d = textView2;
        this.f13553e = linearLayout3;
        this.f13554f = linearLayout4;
    }

    public static s5 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static s5 b(@NonNull View view, @Nullable Object obj) {
        return (s5) ViewDataBinding.bind(obj, view, R.layout.dialog_share);
    }

    @NonNull
    public static s5 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static s5 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static s5 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (s5) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_share, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static s5 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (s5) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_share, null, false, obj);
    }

    @Nullable
    public ShareDialog c() {
        return this.f13555g;
    }

    public abstract void h(@Nullable ShareDialog shareDialog);
}
