package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.base.ui.widget.SlideIndicatorView;
import com.jihuanshe.ui.page.entrepot.StorehouseActivity;
import com.jihuanshe.viewmodel.entrepot.StorehouseViewModel;
import com.vector.design.ui.adapter.pager.FragPagerAdapter;
import com.vector.view.pager.ViewPager;
import java.util.List;

/* loaded from: classes2.dex */
public class n1 extends m1 {
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13164j = null;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private static final SparseIntArray f13165k;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final ConstraintLayout f13166f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final TextView f13167g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final TextView f13168h;

    /* renamed from: i  reason: collision with root package name */
    private long f13169i;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13165k = sparseIntArray;
        sparseIntArray.put(R.id.cl_tab, 5);
    }

    public n1(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f13164j, f13165k));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.t.j.h.g gVar;
        List<String> list;
        FragPagerAdapter fragPagerAdapter;
        e.t.k.a.c.h.c cVar;
        synchronized (this) {
            j2 = this.f13169i;
            this.f13169i = 0L;
        }
        StorehouseActivity storehouseActivity = this.f13100d;
        StorehouseViewModel storehouseViewModel = this.f13101e;
        e.t.j.h.g gVar2 = null;
        int i2 = ((7 & j2) > 0L ? 1 : ((7 & j2) == 0L ? 0 : -1));
        if (i2 != 0) {
            FragPagerAdapter X = storehouseActivity != null ? storehouseActivity.X() : null;
            e.t.k.a.c.h.c r0 = storehouseViewModel != null ? storehouseViewModel.r0() : null;
            list = ((j2 & 6) == 0 || r0 == null) ? null : r0.g();
            if ((j2 & 5) == 0 || storehouseActivity == null) {
                cVar = r0;
                fragPagerAdapter = X;
                gVar = null;
            } else {
                e.t.j.h.g Y = storehouseActivity.Y();
                cVar = r0;
                fragPagerAdapter = X;
                gVar2 = storehouseActivity.Z();
                gVar = Y;
            }
        } else {
            gVar = null;
            list = null;
            fragPagerAdapter = null;
            cVar = null;
        }
        if ((j2 & 5) != 0) {
            e.t.j.g.e0.F(this.f13167g, gVar2);
            e.t.j.g.e0.F(this.f13168h, gVar);
        }
        if ((j2 & 6) != 0) {
            e.l.h.c.a.b(this.b, list);
        }
        if ((j2 & 4) != 0) {
            e.l.h.c.a.a(this.b, R.id.viewPager, 0, 0, 14, 16, null, null, null, null, Integer.valueOf(ViewDataBinding.getColorFromResource(this.b, R.color.black)), Integer.valueOf(ViewDataBinding.getColorFromResource(this.b, R.color.common_color_1)), null, null, Boolean.TRUE, null, null, null, null, null);
            e.t.j.g.f0.r(this.f13099c, false);
            e.t.j.g.f0.i(this.f13099c, 0);
            e.t.j.g.f0.h(this.f13099c, 0, Boolean.FALSE);
        }
        if (i2 != 0) {
            e.t.j.g.f0.j(this.f13099c, null, fragPagerAdapter, cVar, null, null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13169i != 0;
        }
    }

    @Override // e.l.k.m1
    public void i(@Nullable StorehouseActivity storehouseActivity) {
        this.f13100d = storehouseActivity;
        synchronized (this) {
            this.f13169i |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13169i = 4L;
        }
        requestRebind();
    }

    @Override // e.l.k.m1
    public void j(@Nullable StorehouseViewModel storehouseViewModel) {
        this.f13101e = storehouseViewModel;
        synchronized (this) {
            this.f13169i |= 2;
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
            i((StorehouseActivity) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((StorehouseViewModel) obj);
        }
        return true;
    }

    private n1(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[5], (SlideIndicatorView) objArr[1], (ViewPager) objArr[2]);
        this.f13169i = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13166f = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.f13167g = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[4];
        this.f13168h = textView2;
        textView2.setTag(null);
        this.b.setTag(null);
        this.f13099c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
