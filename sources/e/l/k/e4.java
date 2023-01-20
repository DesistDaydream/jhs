package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.donkingliang.labels.LabelsView;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.CommonReportDialog;

/* loaded from: classes2.dex */
public abstract class e4 extends ViewDataBinding {
    @NonNull
    public final EditText a;
    @NonNull
    public final LabelsView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f12553c;
    @Bindable

    /* renamed from: d  reason: collision with root package name */
    public CommonReportDialog f12554d;

    public e4(Object obj, View view, int i2, EditText editText, LabelsView labelsView, TextView textView) {
        super(obj, view, i2);
        this.a = editText;
        this.b = labelsView;
        this.f12553c = textView;
    }

    public static e4 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static e4 b(@NonNull View view, @Nullable Object obj) {
        return (e4) ViewDataBinding.bind(obj, view, R.layout.dialog_common_report);
    }

    @NonNull
    public static e4 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static e4 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static e4 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (e4) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_common_report, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static e4 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (e4) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_common_report, null, false, obj);
    }

    @Nullable
    public CommonReportDialog c() {
        return this.f12554d;
    }

    public abstract void h(@Nullable CommonReportDialog commonReportDialog);
}
