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
import com.jihuanshe.ui.page.main.MainActivity;
import com.jihuanshe.ui.widget.bottomtab.BottomTabLayout;
import com.vector.view.pager.ViewPager;

/* loaded from: classes2.dex */
public abstract class i1 extends ViewDataBinding {
    @NonNull
    public final BottomTabLayout a;
    @NonNull
    public final View b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ViewPager f12832c;
    @Bindable

    /* renamed from: d  reason: collision with root package name */
    public MainActivity f12833d;
    @Bindable

    /* renamed from: e  reason: collision with root package name */
    public e.l.s.i.a f12834e;

    public i1(Object obj, View view, int i2, BottomTabLayout bottomTabLayout, View view2, ViewPager viewPager) {
        super(obj, view, i2);
        this.a = bottomTabLayout;
        this.b = view2;
        this.f12832c = viewPager;
    }

    public static i1 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static i1 b(@NonNull View view, @Nullable Object obj) {
        return (i1) ViewDataBinding.bind(obj, view, R.layout.activity_main);
    }

    @NonNull
    public static i1 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static i1 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static i1 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (i1) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_main, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static i1 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (i1) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_main, null, false, obj);
    }

    @Nullable
    public MainActivity c() {
        return this.f12833d;
    }

    @Nullable
    public e.l.s.i.a d() {
        return this.f12834e;
    }

    public abstract void i(@Nullable MainActivity mainActivity);

    public abstract void j(@Nullable e.l.s.i.a aVar);
}
