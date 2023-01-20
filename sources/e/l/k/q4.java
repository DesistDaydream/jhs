package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.EditProductDialog;

/* loaded from: classes2.dex */
public abstract class q4 extends ViewDataBinding {
    @NonNull
    public final af a;
    @NonNull
    public final SwitchMaterial b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final View f13415c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final View f13416d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final gg f13417e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f13418f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final LinearLayout f13419g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final ig f13420h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final SwitchMaterial f13421i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final TextView f13422j;
    @Bindable

    /* renamed from: k  reason: collision with root package name */
    public EditProductDialog f13423k;

    public q4(Object obj, View view, int i2, af afVar, SwitchMaterial switchMaterial, View view2, View view3, gg ggVar, LinearLayout linearLayout, LinearLayout linearLayout2, ig igVar, SwitchMaterial switchMaterial2, TextView textView) {
        super(obj, view, i2);
        this.a = afVar;
        this.b = switchMaterial;
        this.f13415c = view2;
        this.f13416d = view3;
        this.f13417e = ggVar;
        this.f13418f = linearLayout;
        this.f13419g = linearLayout2;
        this.f13420h = igVar;
        this.f13421i = switchMaterial2;
        this.f13422j = textView;
    }

    public static q4 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static q4 b(@NonNull View view, @Nullable Object obj) {
        return (q4) ViewDataBinding.bind(obj, view, R.layout.dialog_edit_product);
    }

    @NonNull
    public static q4 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static q4 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static q4 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (q4) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_edit_product, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static q4 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (q4) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_edit_product, null, false, obj);
    }

    @Nullable
    public EditProductDialog c() {
        return this.f13423k;
    }

    public abstract void h(@Nullable EditProductDialog editProductDialog);
}
