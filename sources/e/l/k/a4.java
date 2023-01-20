package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.ChangePriceDialog;

/* loaded from: classes2.dex */
public abstract class a4 extends ViewDataBinding {
    @NonNull
    public final ImageView a;
    @NonNull
    public final View b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f12253c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final EditText f12254d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f12255e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final EditText f12256f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextView f12257g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TextView f12258h;
    @Bindable

    /* renamed from: i  reason: collision with root package name */
    public ChangePriceDialog f12259i;

    public a4(Object obj, View view, int i2, ImageView imageView, View view2, LinearLayout linearLayout, EditText editText, TextView textView, EditText editText2, TextView textView2, TextView textView3) {
        super(obj, view, i2);
        this.a = imageView;
        this.b = view2;
        this.f12253c = linearLayout;
        this.f12254d = editText;
        this.f12255e = textView;
        this.f12256f = editText2;
        this.f12257g = textView2;
        this.f12258h = textView3;
    }

    public static a4 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static a4 b(@NonNull View view, @Nullable Object obj) {
        return (a4) ViewDataBinding.bind(obj, view, R.layout.dialog_change_price);
    }

    @NonNull
    public static a4 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static a4 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static a4 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (a4) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_change_price, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static a4 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (a4) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_change_price, null, false, obj);
    }

    @Nullable
    public ChangePriceDialog c() {
        return this.f12259i;
    }

    public abstract void h(@Nullable ChangePriceDialog changePriceDialog);
}
