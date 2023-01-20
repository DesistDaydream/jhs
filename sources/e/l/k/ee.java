package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.widget.FilterPopupWindow;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class ee extends ViewDataBinding {
    @NonNull
    public final ConstraintLayout a;
    @NonNull
    public final ListView b;
    @NonNull

    /* renamed from: c */
    public final View f12594c;
    @Bindable

    /* renamed from: d */
    public FilterPopupWindow f12595d;

    public ee(Object obj, View view, int i2, ConstraintLayout constraintLayout, ListView listView, View view2) {
        super(obj, view, i2);
        this.a = constraintLayout;
        this.b = listView;
        this.f12594c = view2;
    }

    public static ee a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ee b(@NonNull View view, @Nullable Object obj) {
        return (ee) ViewDataBinding.bind(obj, view, R.layout.pop_filter);
    }

    @NonNull
    public static ee d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ee e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ee f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ee) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pop_filter, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ee g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ee) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pop_filter, null, false, obj);
    }

    @Nullable
    public FilterPopupWindow c() {
        return this.f12595d;
    }

    public abstract void h(@Nullable FilterPopupWindow filterPopupWindow);
}
