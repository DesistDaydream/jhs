package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.search.SearchActivity;

/* loaded from: classes2.dex */
public abstract class mg extends ViewDataBinding {
    @NonNull
    public final EditText a;
    @Bindable
    public SearchActivity b;

    public mg(Object obj, View view, int i2, EditText editText) {
        super(obj, view, i2);
        this.a = editText;
    }

    public static mg a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static mg b(@NonNull View view, @Nullable Object obj) {
        return (mg) ViewDataBinding.bind(obj, view, R.layout.view_search_bar);
    }

    @NonNull
    public static mg d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static mg e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static mg f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (mg) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_search_bar, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static mg g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (mg) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_search_bar, null, false, obj);
    }

    @Nullable
    public SearchActivity c() {
        return this.b;
    }

    public abstract void h(@Nullable SearchActivity searchActivity);
}
