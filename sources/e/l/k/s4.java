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
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.EditUserDialog;

/* loaded from: classes2.dex */
public abstract class s4 extends ViewDataBinding {
    @NonNull
    public final EditText a;
    @NonNull
    public final TextView b;
    @Bindable

    /* renamed from: c  reason: collision with root package name */
    public EditUserDialog f13550c;

    public s4(Object obj, View view, int i2, EditText editText, TextView textView) {
        super(obj, view, i2);
        this.a = editText;
        this.b = textView;
    }

    public static s4 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static s4 b(@NonNull View view, @Nullable Object obj) {
        return (s4) ViewDataBinding.bind(obj, view, R.layout.dialog_edit_user);
    }

    @NonNull
    public static s4 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static s4 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static s4 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (s4) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_edit_user, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static s4 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (s4) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_edit_user, null, false, obj);
    }

    @Nullable
    public EditUserDialog c() {
        return this.f13550c;
    }

    public abstract void h(@Nullable EditUserDialog editUserDialog);
}
