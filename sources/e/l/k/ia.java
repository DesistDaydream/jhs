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
import com.jihuanshe.model.ExpressData;

/* loaded from: classes2.dex */
public abstract class ia extends ViewDataBinding {
    @NonNull
    public final View a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f12879c;
    @Bindable

    /* renamed from: d  reason: collision with root package name */
    public ExpressData f12880d;

    public ia(Object obj, View view, int i2, View view2, TextView textView, TextView textView2) {
        super(obj, view, i2);
        this.a = view2;
        this.b = textView;
        this.f12879c = textView2;
    }

    public static ia a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ia b(@NonNull View view, @Nullable Object obj) {
        return (ia) ViewDataBinding.bind(obj, view, R.layout.item_express);
    }

    @NonNull
    public static ia d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ia e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ia f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ia) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_express, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ia g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ia) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_express, null, false, obj);
    }

    @Nullable
    public ExpressData c() {
        return this.f12880d;
    }

    public abstract void h(@Nullable ExpressData expressData);
}
