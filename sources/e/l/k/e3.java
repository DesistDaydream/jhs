package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentContainerView;
import com.jihuanshe.R;

/* loaded from: classes2.dex */
public abstract class e3 extends ViewDataBinding {
    @NonNull
    public final FragmentContainerView a;

    public e3(Object obj, View view, int i2, FragmentContainerView fragmentContainerView) {
        super(obj, view, i2);
        this.a = fragmentContainerView;
    }

    public static e3 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static e3 b(@NonNull View view, @Nullable Object obj) {
        return (e3) ViewDataBinding.bind(obj, view, R.layout.activity_wish_list);
    }

    @NonNull
    public static e3 c(@NonNull LayoutInflater layoutInflater) {
        return f(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static e3 d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return e(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static e3 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (e3) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_wish_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static e3 f(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (e3) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_wish_list, null, false, obj);
    }
}
