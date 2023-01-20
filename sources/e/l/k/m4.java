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
import com.jihuanshe.base.wheelview.WheelDatePicker;
import com.jihuanshe.ui.dialog.DateOfBirthDialog;

/* loaded from: classes2.dex */
public abstract class m4 extends ViewDataBinding {
    @NonNull
    public final WheelDatePicker a;
    @NonNull
    public final TextView b;
    @Bindable

    /* renamed from: c  reason: collision with root package name */
    public DateOfBirthDialog f13113c;

    public m4(Object obj, View view, int i2, WheelDatePicker wheelDatePicker, TextView textView) {
        super(obj, view, i2);
        this.a = wheelDatePicker;
        this.b = textView;
    }

    public static m4 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static m4 b(@NonNull View view, @Nullable Object obj) {
        return (m4) ViewDataBinding.bind(obj, view, R.layout.dialog_date_of_birth);
    }

    @NonNull
    public static m4 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static m4 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static m4 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (m4) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_date_of_birth, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static m4 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (m4) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_date_of_birth, null, false, obj);
    }

    @Nullable
    public DateOfBirthDialog c() {
        return this.f13113c;
    }

    public abstract void h(@Nullable DateOfBirthDialog dateOfBirthDialog);
}
