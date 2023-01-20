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
import com.jihuanshe.ui.widget.GamesPopupWindow;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class ke extends ViewDataBinding {
    @NonNull
    public final ListView a;
    @Bindable
    public GamesPopupWindow b;

    public ke(Object obj, View view, int i2, ListView listView) {
        super(obj, view, i2);
        this.a = listView;
    }

    public static ke a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ke b(@NonNull View view, @Nullable Object obj) {
        return (ke) ViewDataBinding.bind(obj, view, R.layout.pop_games_bar);
    }

    @NonNull
    public static ke d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ke e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ke f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ke) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pop_games_bar, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ke g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ke) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pop_games_bar, null, false, obj);
    }

    @Nullable
    public GamesPopupWindow c() {
        return this.b;
    }

    public abstract void h(@Nullable GamesPopupWindow gamesPopupWindow);
}
