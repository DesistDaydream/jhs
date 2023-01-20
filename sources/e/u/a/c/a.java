package e.u.a.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.xres.address_selector.R;
import com.xres.address_selector.widget.SideBar;

/* loaded from: classes3.dex */
public abstract class a extends ViewDataBinding {
    @NonNull
    public final SideBar a;
    @NonNull
    public final RecyclerView b;

    public a(Object obj, View view, int i2, SideBar sideBar, RecyclerView recyclerView) {
        super(obj, view, i2);
        this.a = sideBar;
        this.b = recyclerView;
    }

    public static a a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static a b(@NonNull View view, @Nullable Object obj) {
        return (a) ViewDataBinding.bind(obj, view, R.layout.fragment_address);
    }

    @NonNull
    public static a c(@NonNull LayoutInflater layoutInflater) {
        return f(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static a d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return e(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static a e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (a) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_address, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static a f(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (a) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_address, null, false, obj);
    }
}
