package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jihuanshe.R;
import com.jihuanshe.base.ui.widget.SlideIndicatorView;
import com.jihuanshe.ui.page.entrepot.ConsignmentOrderActivity;
import com.jihuanshe.viewmodel.entrepot.ConsignmentOrderViewModel;
import com.vector.design.ui.adapter.pager.FragPagerAdapter;
import com.vector.view.pager.ViewPager;
import java.util.List;

/* loaded from: classes2.dex */
public class j0 extends i0 {
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12916i = null;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static final SparseIntArray f12917j;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final ConstraintLayout f12918f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final TextView f12919g;

    /* renamed from: h  reason: collision with root package name */
    private long f12920h;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f12917j = sparseIntArray;
        sparseIntArray.put(R.id.cl_tab, 4);
    }

    public j0(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f12916i, f12917j));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        String str;
        e.t.j.h.g gVar;
        List<String> list;
        FragPagerAdapter fragPagerAdapter;
        e.t.k.a.c.h.c cVar;
        e.t.j.h.g gVar2;
        synchronized (this) {
            j2 = this.f12920h;
            this.f12920h = 0L;
        }
        ConsignmentOrderActivity consignmentOrderActivity = this.f12830d;
        ConsignmentOrderViewModel consignmentOrderViewModel = this.f12831e;
        Integer num = null;
        if ((j2 & 7) != 0) {
            FragPagerAdapter X = consignmentOrderActivity != null ? consignmentOrderActivity.X() : null;
            e.t.k.a.c.h.c p0 = consignmentOrderViewModel != null ? consignmentOrderViewModel.p0() : null;
            list = ((j2 & 6) == 0 || p0 == null) ? null : p0.g();
            int i2 = ((j2 & 5) > 0L ? 1 : ((j2 & 5) == 0L ? 0 : -1));
            if (i2 != 0) {
                if (consignmentOrderActivity != null) {
                    num = consignmentOrderActivity.Z();
                    gVar2 = consignmentOrderActivity.Y();
                } else {
                    gVar2 = null;
                }
                boolean z = ViewDataBinding.safeUnbox(num) == 1;
                if (i2 != 0) {
                    j2 |= z ? 16L : 8L;
                }
                cVar = p0;
                fragPagerAdapter = X;
                gVar = gVar2;
                str = this.f12919g.getResources().getString(z ? R.string.common_apply_for : R.string.common_apply_for_return);
            } else {
                cVar = p0;
                fragPagerAdapter = X;
                str = null;
                gVar = null;
            }
        } else {
            str = null;
            gVar = null;
            list = null;
            fragPagerAdapter = null;
            cVar = null;
        }
        if ((j2 & 5) != 0) {
            TextViewBindingAdapter.setText(this.f12919g, str);
            e.t.j.g.e0.F(this.f12919g, gVar);
        }
        if ((j2 & 6) != 0) {
            e.l.h.c.a.b(this.b, list);
        }
        if ((4 & j2) != 0) {
            e.l.h.c.a.a(this.b, R.id.viewPager, 0, 0, 14, 16, null, null, null, null, Integer.valueOf(ViewDataBinding.getColorFromResource(this.b, R.color.black)), Integer.valueOf(ViewDataBinding.getColorFromResource(this.b, R.color.common_color_1)), null, null, Boolean.TRUE, null, null, null, null, null);
            e.t.j.g.f0.r(this.f12829c, false);
            e.t.j.g.f0.i(this.f12829c, 0);
            e.t.j.g.f0.h(this.f12829c, 0, Boolean.FALSE);
        }
        if ((j2 & 7) != 0) {
            e.t.j.g.f0.j(this.f12829c, null, fragPagerAdapter, cVar, null, null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12920h != 0;
        }
    }

    @Override // e.l.k.i0
    public void i(@Nullable ConsignmentOrderActivity consignmentOrderActivity) {
        this.f12830d = consignmentOrderActivity;
        synchronized (this) {
            this.f12920h |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12920h = 4L;
        }
        requestRebind();
    }

    @Override // e.l.k.i0
    public void j(@Nullable ConsignmentOrderViewModel consignmentOrderViewModel) {
        this.f12831e = consignmentOrderViewModel;
        synchronized (this) {
            this.f12920h |= 2;
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
            i((ConsignmentOrderActivity) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((ConsignmentOrderViewModel) obj);
        }
        return true;
    }

    private j0(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[4], (SlideIndicatorView) objArr[1], (ViewPager) objArr[2]);
        this.f12920h = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12918f = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.f12919g = textView;
        textView.setTag(null);
        this.b.setTag(null);
        this.f12829c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
