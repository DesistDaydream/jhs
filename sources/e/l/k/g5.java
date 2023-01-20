package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.NoticeDialog;

/* loaded from: classes2.dex */
public abstract class g5 extends ViewDataBinding {
    @NonNull
    public final TextView a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ScrollView f12711c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f12712d;
    @Bindable

    /* renamed from: e  reason: collision with root package name */
    public NoticeDialog f12713e;

    public g5(Object obj, View view, int i2, TextView textView, TextView textView2, ScrollView scrollView, TextView textView3) {
        super(obj, view, i2);
        this.a = textView;
        this.b = textView2;
        this.f12711c = scrollView;
        this.f12712d = textView3;
    }

    public static g5 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static g5 b(@NonNull View view, @Nullable Object obj) {
        return (g5) ViewDataBinding.bind(obj, view, R.layout.dialog_notice);
    }

    @NonNull
    public static g5 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static g5 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static g5 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (g5) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_notice, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static g5 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (g5) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_notice, null, false, obj);
    }

    @Nullable
    public NoticeDialog c() {
        return this.f12713e;
    }

    public abstract void h(@Nullable NoticeDialog noticeDialog);
}
