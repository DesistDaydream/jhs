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
import com.jihuanshe.ui.page.entrepot.ConsignmentOrderFragment;
import com.jihuanshe.viewmodel.entrepot.ConsignmentOrderChildViewModel;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class m6 extends ViewDataBinding {
    @NonNull
    public final ListView a;
    @Bindable
    public ConsignmentOrderFragment b;
    @Bindable

    /* renamed from: c  reason: collision with root package name */
    public ConsignmentOrderChildViewModel f13117c;

    public m6(Object obj, View view, int i2, ListView listView) {
        super(obj, view, i2);
        this.a = listView;
    }

    public static m6 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static m6 b(@NonNull View view, @Nullable Object obj) {
        return (m6) ViewDataBinding.bind(obj, view, R.layout.fragment_consignment_order);
    }

    @NonNull
    public static m6 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static m6 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static m6 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (m6) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_consignment_order, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static m6 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (m6) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_consignment_order, null, false, obj);
    }

    @Nullable
    public ConsignmentOrderFragment c() {
        return this.b;
    }

    @Nullable
    public ConsignmentOrderChildViewModel d() {
        return this.f13117c;
    }

    public abstract void i(@Nullable ConsignmentOrderFragment consignmentOrderFragment);

    public abstract void j(@Nullable ConsignmentOrderChildViewModel consignmentOrderChildViewModel);
}
