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
import com.jihuanshe.ui.dialog.ExpressDetailsDialog;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class w4 extends ViewDataBinding {
    @NonNull
    public final ListView a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f13826c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f13827d;
    @Bindable

    /* renamed from: e  reason: collision with root package name */
    public ExpressDetailsDialog f13828e;

    public w4(Object obj, View view, int i2, ListView listView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i2);
        this.a = listView;
        this.b = textView;
        this.f13826c = textView2;
        this.f13827d = textView3;
    }

    public static w4 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static w4 b(@NonNull View view, @Nullable Object obj) {
        return (w4) ViewDataBinding.bind(obj, view, R.layout.dialog_express_details);
    }

    @NonNull
    public static w4 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static w4 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static w4 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (w4) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_express_details, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static w4 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (w4) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_express_details, null, false, obj);
    }

    @Nullable
    public ExpressDetailsDialog c() {
        return this.f13828e;
    }

    public abstract void h(@Nullable ExpressDetailsDialog expressDetailsDialog);
}
