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
import com.jihuanshe.ui.dialog.ExpressDialog;
import com.jihuanshe.ui.widget.NoScrollListView;

/* loaded from: classes2.dex */
public abstract class u4 extends ViewDataBinding {
    @NonNull
    public final NoScrollListView a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f13691c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f13692d;
    @Bindable

    /* renamed from: e  reason: collision with root package name */
    public ExpressDialog f13693e;

    public u4(Object obj, View view, int i2, NoScrollListView noScrollListView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i2);
        this.a = noScrollListView;
        this.b = textView;
        this.f13691c = textView2;
        this.f13692d = textView3;
    }

    public static u4 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static u4 b(@NonNull View view, @Nullable Object obj) {
        return (u4) ViewDataBinding.bind(obj, view, R.layout.dialog_express);
    }

    @NonNull
    public static u4 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static u4 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static u4 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (u4) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_express, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static u4 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (u4) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_express, null, false, obj);
    }

    @Nullable
    public ExpressDialog c() {
        return this.f13693e;
    }

    public abstract void h(@Nullable ExpressDialog expressDialog);
}
