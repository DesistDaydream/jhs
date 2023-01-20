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
import com.jihuanshe.ui.dialog.BaseSideDialog;

/* loaded from: classes2.dex */
public abstract class u5 extends ViewDataBinding {
    @NonNull
    public final TextView a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c */
    public final TextView f13694c;
    @NonNull

    /* renamed from: d */
    public final TextView f13695d;
    @Bindable

    /* renamed from: e */
    public BaseSideDialog f13696e;

    public u5(Object obj, View view, int i2, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i2);
        this.a = textView;
        this.b = textView2;
        this.f13694c = textView3;
        this.f13695d = textView4;
    }

    public static u5 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static u5 b(@NonNull View view, @Nullable Object obj) {
        return (u5) ViewDataBinding.bind(obj, view, R.layout.dialog_side);
    }

    @NonNull
    public static u5 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static u5 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static u5 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (u5) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_side, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static u5 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (u5) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_side, null, false, obj);
    }

    @Nullable
    public BaseSideDialog c() {
        return this.f13696e;
    }

    public abstract void h(@Nullable BaseSideDialog baseSideDialog);
}
