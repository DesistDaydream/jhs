package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.order.AddAddressActivity;

/* loaded from: classes2.dex */
public abstract class e extends ViewDataBinding {
    @NonNull
    public final EditText a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final SwitchMaterial f12528c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f12529d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final EditText f12530e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f12531f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final EditText f12532g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final LinearLayout f12533h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final TextView f12534i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final TextView f12535j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final TextView f12536k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final TextView f12537l;
    @Bindable

    /* renamed from: m  reason: collision with root package name */
    public AddAddressActivity f12538m;

    public e(Object obj, View view, int i2, EditText editText, TextView textView, SwitchMaterial switchMaterial, TextView textView2, EditText editText2, TextView textView3, EditText editText3, LinearLayout linearLayout, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        super(obj, view, i2);
        this.a = editText;
        this.b = textView;
        this.f12528c = switchMaterial;
        this.f12529d = textView2;
        this.f12530e = editText2;
        this.f12531f = textView3;
        this.f12532g = editText3;
        this.f12533h = linearLayout;
        this.f12534i = textView4;
        this.f12535j = textView5;
        this.f12536k = textView6;
        this.f12537l = textView7;
    }

    public static e a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static e b(@NonNull View view, @Nullable Object obj) {
        return (e) ViewDataBinding.bind(obj, view, R.layout.activity_add_address);
    }

    @NonNull
    public static e d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static e e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static e f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (e) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_add_address, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static e g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (e) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_add_address, null, false, obj);
    }

    @Nullable
    public AddAddressActivity c() {
        return this.f12538m;
    }

    public abstract void h(@Nullable AddAddressActivity addAddressActivity);
}
