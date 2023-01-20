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
import com.jihuanshe.ui.dialog.UseDialog;

/* loaded from: classes2.dex */
public abstract class g4 extends ViewDataBinding {
    @NonNull
    public final TextView a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f12708c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f12709d;
    @Bindable

    /* renamed from: e  reason: collision with root package name */
    public UseDialog f12710e;

    public g4(Object obj, View view, int i2, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i2);
        this.a = textView;
        this.b = textView2;
        this.f12708c = textView3;
        this.f12709d = textView4;
    }

    public static g4 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static g4 b(@NonNull View view, @Nullable Object obj) {
        return (g4) ViewDataBinding.bind(obj, view, R.layout.dialog_common_tips);
    }

    @NonNull
    public static g4 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static g4 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static g4 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (g4) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_common_tips, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static g4 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (g4) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_common_tips, null, false, obj);
    }

    @Nullable
    public UseDialog c() {
        return this.f12710e;
    }

    public abstract void h(@Nullable UseDialog useDialog);
}
