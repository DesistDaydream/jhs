package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.ChooseDialogNew;

/* loaded from: classes2.dex */
public abstract class c4 extends ViewDataBinding {
    @NonNull
    public final RecyclerView a;
    @Bindable
    public ChooseDialogNew b;

    public c4(Object obj, View view, int i2, RecyclerView recyclerView) {
        super(obj, view, i2);
        this.a = recyclerView;
    }

    public static c4 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static c4 b(@NonNull View view, @Nullable Object obj) {
        return (c4) ViewDataBinding.bind(obj, view, R.layout.dialog_choose_new);
    }

    @NonNull
    public static c4 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static c4 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static c4 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (c4) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_choose_new, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static c4 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (c4) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_choose_new, null, false, obj);
    }

    @Nullable
    public ChooseDialogNew c() {
        return this.b;
    }

    public abstract void h(@Nullable ChooseDialogNew chooseDialogNew);
}
