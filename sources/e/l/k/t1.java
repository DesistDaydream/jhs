package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.base.ui.widget.SlideIndicatorView;
import com.jihuanshe.ui.page.order.OrderListActivity;
import com.jihuanshe.viewmodel.order.OrderListViewModel;
import com.vector.design.ui.adapter.pager.FragPagerAdapter;
import com.vector.view.pager.ViewPager;
import java.util.List;

/* loaded from: classes2.dex */
public class t1 extends s1 {
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13588g = null;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f13589h = null;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final ConstraintLayout f13590e;

    /* renamed from: f  reason: collision with root package name */
    private long f13591f;

    public t1(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f13588g, f13589h));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        FragPagerAdapter fragPagerAdapter;
        e.t.k.a.c.h.c cVar;
        synchronized (this) {
            j2 = this.f13591f;
            this.f13591f = 0L;
        }
        OrderListActivity orderListActivity = this.f13540c;
        OrderListViewModel orderListViewModel = this.f13541d;
        List<String> list = null;
        int i2 = ((7 & j2) > 0L ? 1 : ((7 & j2) == 0L ? 0 : -1));
        if (i2 != 0) {
            FragPagerAdapter X = orderListActivity != null ? orderListActivity.X() : null;
            e.t.k.a.c.h.c p0 = orderListViewModel != null ? orderListViewModel.p0() : null;
            if ((j2 & 6) != 0 && p0 != null) {
                list = p0.g();
            }
            fragPagerAdapter = X;
            cVar = p0;
        } else {
            fragPagerAdapter = null;
            cVar = null;
        }
        if ((j2 & 6) != 0) {
            e.l.h.c.a.b(this.a, list);
        }
        if ((j2 & 4) != 0) {
            e.l.h.c.a.a(this.a, R.id.viewPager, 0, 0, 11, 11, null, null, null, null, Integer.valueOf(ViewDataBinding.getColorFromResource(this.a, R.color.black)), Integer.valueOf(ViewDataBinding.getColorFromResource(this.a, R.color.common_color_1)), null, null, Boolean.TRUE, null, null, null, null, null);
            e.t.j.g.f0.i(this.b, 0);
            e.t.j.g.f0.r(this.b, false);
            e.t.j.g.f0.h(this.b, 0, Boolean.FALSE);
        }
        if (i2 != 0) {
            e.t.j.g.f0.j(this.b, null, fragPagerAdapter, cVar, null, null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13591f != 0;
        }
    }

    @Override // e.l.k.s1
    public void i(@Nullable OrderListActivity orderListActivity) {
        this.f13540c = orderListActivity;
        synchronized (this) {
            this.f13591f |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13591f = 4L;
        }
        requestRebind();
    }

    @Override // e.l.k.s1
    public void j(@Nullable OrderListViewModel orderListViewModel) {
        this.f13541d = orderListViewModel;
        synchronized (this) {
            this.f13591f |= 2;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((OrderListActivity) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((OrderListViewModel) obj);
        }
        return true;
    }

    private t1(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (SlideIndicatorView) objArr[1], (ViewPager) objArr[2]);
        this.f13591f = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13590e = constraintLayout;
        constraintLayout.setTag(null);
        this.a.setTag(null);
        this.b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
