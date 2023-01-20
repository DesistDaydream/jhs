package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;

/* loaded from: classes2.dex */
public abstract class s9 extends ViewDataBinding {
    @Bindable
    public e.l.g.z a;
    @Bindable
    public Boolean b;

    public s9(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static s9 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static s9 b(@NonNull View view, @Nullable Object obj) {
        return (s9) ViewDataBinding.bind(obj, view, R.layout.item_choose);
    }

    @NonNull
    public static s9 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static s9 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static s9 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (s9) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_choose, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static s9 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (s9) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_choose, null, false, obj);
    }

    @Nullable
    public e.l.g.z c() {
        return this.a;
    }

    @Nullable
    public Boolean d() {
        return this.b;
    }

    public abstract void i(@Nullable e.l.g.z zVar);

    public abstract void j(@Nullable Boolean bool);
}
