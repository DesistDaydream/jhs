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
import com.jihuanshe.ui.widget.FilterInfoPopupWindow;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class ge extends ViewDataBinding {
    @NonNull
    public final ConstraintLayout a;
    @NonNull
    public final ListView b;
    @NonNull

    /* renamed from: c */
    public final View f12743c;
    @Bindable

    /* renamed from: d */
    public FilterInfoPopupWindow f12744d;

    public ge(Object obj, View view, int i2, ConstraintLayout constraintLayout, ListView listView, View view2) {
        super(obj, view, i2);
        this.a = constraintLayout;
        this.b = listView;
        this.f12743c = view2;
    }

    public static ge a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ge b(@NonNull View view, @Nullable Object obj) {
        return (ge) ViewDataBinding.bind(obj, view, R.layout.pop_filter_info);
    }

    @NonNull
    public static ge d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ge e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ge f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ge) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pop_filter_info, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ge g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ge) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pop_filter_info, null, false, obj);
    }

    @Nullable
    public FilterInfoPopupWindow c() {
        return this.f12744d;
    }

    public abstract void h(@Nullable FilterInfoPopupWindow filterInfoPopupWindow);
}
