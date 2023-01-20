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
import com.jihuanshe.model.IllegalData;

/* loaded from: classes2.dex */
public abstract class sa extends ViewDataBinding {
    @NonNull
    public final TextView a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f13563c;
    @Bindable

    /* renamed from: d  reason: collision with root package name */
    public IllegalData f13564d;

    public sa(Object obj, View view, int i2, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i2);
        this.a = textView;
        this.b = textView2;
        this.f13563c = textView3;
    }

    public static sa a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static sa b(@NonNull View view, @Nullable Object obj) {
        return (sa) ViewDataBinding.bind(obj, view, R.layout.item_illegal);
    }

    @NonNull
    public static sa d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static sa e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static sa f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (sa) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_illegal, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static sa g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (sa) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_illegal, null, false, obj);
    }

    @Nullable
    public IllegalData c() {
        return this.f13564d;
    }

    public abstract void h(@Nullable IllegalData illegalData);
}
