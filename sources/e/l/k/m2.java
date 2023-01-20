package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentContainerView;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.user.selling.SellingActivity;

/* loaded from: classes2.dex */
public abstract class m2 extends ViewDataBinding {
    @NonNull
    public final FragmentContainerView a;
    @Bindable
    public SellingActivity b;
    @Bindable

    /* renamed from: c  reason: collision with root package name */
    public e.l.s.o.d.a f13102c;

    public m2(Object obj, View view, int i2, FragmentContainerView fragmentContainerView) {
        super(obj, view, i2);
        this.a = fragmentContainerView;
    }

    public static m2 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static m2 b(@NonNull View view, @Nullable Object obj) {
        return (m2) ViewDataBinding.bind(obj, view, R.layout.activity_selling);
    }

    @NonNull
    public static m2 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static m2 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static m2 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (m2) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_selling, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static m2 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (m2) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_selling, null, false, obj);
    }

    @Nullable
    public SellingActivity c() {
        return this.b;
    }

    @Nullable
    public e.l.s.o.d.a d() {
        return this.f13102c;
    }

    public abstract void i(@Nullable SellingActivity sellingActivity);

    public abstract void j(@Nullable e.l.s.o.d.a aVar);
}
