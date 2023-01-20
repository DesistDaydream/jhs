package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.PermissionDescDialog;

/* loaded from: classes2.dex */
public abstract class i5 extends ViewDataBinding {
    @NonNull
    public final ImageView a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f12857c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f12858d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f12859e;
    @Bindable

    /* renamed from: f  reason: collision with root package name */
    public PermissionDescDialog f12860f;

    public i5(Object obj, View view, int i2, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i2);
        this.a = imageView;
        this.b = textView;
        this.f12857c = textView2;
        this.f12858d = textView3;
        this.f12859e = textView4;
    }

    public static i5 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static i5 b(@NonNull View view, @Nullable Object obj) {
        return (i5) ViewDataBinding.bind(obj, view, R.layout.dialog_permission_request_layout);
    }

    @NonNull
    public static i5 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static i5 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static i5 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (i5) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_permission_request_layout, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static i5 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (i5) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_permission_request_layout, null, false, obj);
    }

    @Nullable
    public PermissionDescDialog c() {
        return this.f12860f;
    }

    public abstract void h(@Nullable PermissionDescDialog permissionDescDialog);
}
