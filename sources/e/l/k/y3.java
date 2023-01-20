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
import com.jihuanshe.ui.dialog.CardPackListDialog;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class y3 extends ViewDataBinding {
    @NonNull
    public final ListView a;
    @NonNull
    public final TextView b;
    @Bindable

    /* renamed from: c  reason: collision with root package name */
    public CardPackListDialog f13949c;

    public y3(Object obj, View view, int i2, ListView listView, TextView textView) {
        super(obj, view, i2);
        this.a = listView;
        this.b = textView;
    }

    public static y3 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static y3 b(@NonNull View view, @Nullable Object obj) {
        return (y3) ViewDataBinding.bind(obj, view, R.layout.dialog_card_pack_list);
    }

    @NonNull
    public static y3 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static y3 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static y3 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (y3) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_card_pack_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static y3 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (y3) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_card_pack_list, null, false, obj);
    }

    @Nullable
    public CardPackListDialog c() {
        return this.f13949c;
    }

    public abstract void h(@Nullable CardPackListDialog cardPackListDialog);
}
