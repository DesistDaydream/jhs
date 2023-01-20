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
import com.jihuanshe.ui.dialog.TipDialog;

/* loaded from: classes2.dex */
public abstract class y5 extends ViewDataBinding {
    @NonNull
    public final TextView a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final View f13957c;
    @Bindable

    /* renamed from: d  reason: collision with root package name */
    public TipDialog f13958d;

    public y5(Object obj, View view, int i2, TextView textView, TextView textView2, View view2) {
        super(obj, view, i2);
        this.a = textView;
        this.b = textView2;
        this.f13957c = view2;
    }

    public static y5 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static y5 b(@NonNull View view, @Nullable Object obj) {
        return (y5) ViewDataBinding.bind(obj, view, R.layout.dialog_tips);
    }

    @NonNull
    public static y5 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static y5 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static y5 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (y5) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_tips, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static y5 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (y5) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_tips, null, false, obj);
    }

    @Nullable
    public TipDialog c() {
        return this.f13958d;
    }

    public abstract void h(@Nullable TipDialog tipDialog);
}
