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
import com.jihuanshe.ui.dialog.MediationDialog;

/* loaded from: classes2.dex */
public abstract class a7 extends ViewDataBinding {
    @NonNull
    public final TextView a;
    @NonNull
    public final TextView b;
    @Bindable

    /* renamed from: c */
    public MediationDialog f12273c;

    public a7(Object obj, View view, int i2, TextView textView, TextView textView2) {
        super(obj, view, i2);
        this.a = textView;
        this.b = textView2;
    }

    public static a7 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static a7 b(@NonNull View view, @Nullable Object obj) {
        return (a7) ViewDataBinding.bind(obj, view, R.layout.fragment_mediation);
    }

    @NonNull
    public static a7 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static a7 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static a7 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (a7) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_mediation, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static a7 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (a7) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_mediation, null, false, obj);
    }

    @Nullable
    public MediationDialog c() {
        return this.f12273c;
    }

    public abstract void h(@Nullable MediationDialog mediationDialog);
}
