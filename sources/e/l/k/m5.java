package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.PrivateDialog;

/* loaded from: classes2.dex */
public abstract class m5 extends ViewDataBinding {
    @NonNull
    public final TextView a;
    @NonNull
    public final ScrollView b;
    @NonNull

    /* renamed from: c */
    public final TextView f13114c;
    @NonNull

    /* renamed from: d */
    public final TextView f13115d;
    @Bindable

    /* renamed from: e */
    public PrivateDialog f13116e;

    public m5(Object obj, View view, int i2, TextView textView, ScrollView scrollView, TextView textView2, TextView textView3) {
        super(obj, view, i2);
        this.a = textView;
        this.b = scrollView;
        this.f13114c = textView2;
        this.f13115d = textView3;
    }

    public static m5 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static m5 b(@NonNull View view, @Nullable Object obj) {
        return (m5) ViewDataBinding.bind(obj, view, R.layout.dialog_private);
    }

    @NonNull
    public static m5 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static m5 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static m5 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (m5) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_private, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static m5 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (m5) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_private, null, false, obj);
    }

    @Nullable
    public PrivateDialog c() {
        return this.f13116e;
    }

    public abstract void h(@Nullable PrivateDialog privateDialog);
}
