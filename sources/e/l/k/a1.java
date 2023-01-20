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
import com.jihuanshe.ui.page.user.IllegalListActivity;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class a1 extends ViewDataBinding {
    @NonNull
    public final ListView a;
    @Bindable
    public IllegalListActivity b;
    @Bindable

    /* renamed from: c  reason: collision with root package name */
    public e.l.s.o.a f12245c;

    public a1(Object obj, View view, int i2, ListView listView) {
        super(obj, view, i2);
        this.a = listView;
    }

    public static a1 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static a1 b(@NonNull View view, @Nullable Object obj) {
        return (a1) ViewDataBinding.bind(obj, view, R.layout.activity_illegal_list);
    }

    @NonNull
    public static a1 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static a1 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static a1 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (a1) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_illegal_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static a1 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (a1) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_illegal_list, null, false, obj);
    }

    @Nullable
    public IllegalListActivity c() {
        return this.b;
    }

    @Nullable
    public e.l.s.o.a d() {
        return this.f12245c;
    }

    public abstract void i(@Nullable IllegalListActivity illegalListActivity);

    public abstract void j(@Nullable e.l.s.o.a aVar);
}
