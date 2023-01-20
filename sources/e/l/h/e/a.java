package e.l.h.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.base.R;
import com.jihuanshe.base.ui.activity.GlobalToastActivity;

/* loaded from: classes2.dex */
public abstract class a extends ViewDataBinding {
    @NonNull
    public final TextView a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c */
    public final View f12087c;
    @Bindable

    /* renamed from: d */
    public GlobalToastActivity f12088d;

    public a(Object obj, View view, int i2, TextView textView, TextView textView2, View view2) {
        super(obj, view, i2);
        this.a = textView;
        this.b = textView2;
        this.f12087c = view2;
    }

    public static a a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static a b(@NonNull View view, @Nullable Object obj) {
        return (a) ViewDataBinding.bind(obj, view, R.layout.dialog_global_tips);
    }

    @NonNull
    public static a d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static a e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static a f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (a) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_global_tips, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static a g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (a) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_global_tips, null, false, obj);
    }

    @Nullable
    public GlobalToastActivity c() {
        return this.f12088d;
    }

    public abstract void h(@Nullable GlobalToastActivity globalToastActivity);
}
