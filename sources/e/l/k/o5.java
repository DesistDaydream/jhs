package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.ReportDialog;

/* loaded from: classes2.dex */
public abstract class o5 extends ViewDataBinding {
    @NonNull
    public final FrameLayout a;
    @NonNull
    public final RecyclerView b;
    @NonNull

    /* renamed from: c */
    public final View f13247c;
    @Bindable

    /* renamed from: d */
    public ReportDialog f13248d;

    public o5(Object obj, View view, int i2, FrameLayout frameLayout, RecyclerView recyclerView, View view2) {
        super(obj, view, i2);
        this.a = frameLayout;
        this.b = recyclerView;
        this.f13247c = view2;
    }

    public static o5 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static o5 b(@NonNull View view, @Nullable Object obj) {
        return (o5) ViewDataBinding.bind(obj, view, R.layout.dialog_report);
    }

    @NonNull
    public static o5 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static o5 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static o5 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (o5) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_report, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static o5 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (o5) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_report, null, false, obj);
    }

    @Nullable
    public ReportDialog c() {
        return this.f13248d;
    }

    public abstract void h(@Nullable ReportDialog reportDialog);
}
