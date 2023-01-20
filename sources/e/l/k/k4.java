package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.CreateListDialog;

/* loaded from: classes2.dex */
public abstract class k4 extends ViewDataBinding {
    @NonNull
    public final EditText a;
    @NonNull
    public final ImageView b;
    @NonNull

    /* renamed from: c */
    public final TextView f12999c;
    @Bindable

    /* renamed from: d */
    public CreateListDialog f13000d;

    public k4(Object obj, View view, int i2, EditText editText, ImageView imageView, TextView textView) {
        super(obj, view, i2);
        this.a = editText;
        this.b = imageView;
        this.f12999c = textView;
    }

    public static k4 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static k4 b(@NonNull View view, @Nullable Object obj) {
        return (k4) ViewDataBinding.bind(obj, view, R.layout.dialog_create_list);
    }

    @NonNull
    public static k4 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static k4 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static k4 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (k4) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_create_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static k4 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (k4) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_create_list, null, false, obj);
    }

    @Nullable
    public CreateListDialog c() {
        return this.f13000d;
    }

    public abstract void h(@Nullable CreateListDialog createListDialog);
}
