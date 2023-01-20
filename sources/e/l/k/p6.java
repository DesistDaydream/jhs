package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.base.ui.widget.SlideIndicatorView;
import com.jihuanshe.model.Game;
import com.jihuanshe.ui.page.user.wish.DesireFragment;
import com.jihuanshe.ui.widget.GameFilterBtn;
import com.vector.design.ui.adapter.pager.FragPagerAdapter;
import com.vector.view.pager.ViewPager;
import java.util.List;

/* loaded from: classes2.dex */
public class p6 extends o6 {
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13319h = null;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static final SparseIntArray f13320i;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final RelativeLayout f13321f;

    /* renamed from: g  reason: collision with root package name */
    private long f13322g;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13320i = sparseIntArray;
        sparseIntArray.put(R.id.indicator, 4);
    }

    public p6(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f13319h, f13320i));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        h.k2.u.l<Game, h.t1> lVar;
        e.t.j.h.y yVar;
        List<String> list;
        FragPagerAdapter fragPagerAdapter;
        e.t.k.a.c.h.c cVar;
        e.t.k.a.c.h.c cVar2;
        FragPagerAdapter fragPagerAdapter2;
        synchronized (this) {
            j2 = this.f13322g;
            this.f13322g = 0L;
        }
        DesireFragment desireFragment = this.f13251e;
        int i2 = ((3 & j2) > 0L ? 1 : ((3 & j2) == 0L ? 0 : -1));
        if (i2 != 0) {
            if (desireFragment != null) {
                lVar = desireFragment.f0();
                fragPagerAdapter2 = desireFragment.e0();
                yVar = desireFragment.g0();
                cVar2 = desireFragment.h0();
            } else {
                cVar2 = null;
                lVar = null;
                fragPagerAdapter2 = null;
                yVar = null;
            }
            if (cVar2 != null) {
                list = cVar2.g();
                cVar = cVar2;
                fragPagerAdapter = fragPagerAdapter2;
            } else {
                cVar = cVar2;
                fragPagerAdapter = fragPagerAdapter2;
                list = null;
            }
        } else {
            lVar = null;
            yVar = null;
            list = null;
            fragPagerAdapter = null;
            cVar = null;
        }
        if (i2 != 0) {
            e.l.i.n.a(this.a, lVar);
            e.l.h.c.a.b(this.f13249c, list);
            e.t.j.g.f0.j(this.f13250d, null, fragPagerAdapter, cVar, null, null);
            e.t.j.g.f0.p(this.f13250d, null, null, yVar, null);
        }
        if ((j2 & 2) != 0) {
            SlideIndicatorView slideIndicatorView = this.f13249c;
            Integer valueOf = Integer.valueOf(ViewDataBinding.getColorFromResource(this.f13249c, R.color.black));
            Integer valueOf2 = Integer.valueOf(ViewDataBinding.getColorFromResource(this.f13249c, R.color.common_color_1));
            Boolean bool = Boolean.FALSE;
            e.l.h.c.a.a(slideIndicatorView, R.id.viewPager, 0, 0, 13, 14, null, null, null, null, valueOf, valueOf2, null, 10, bool, Boolean.TRUE, null, null, null, null);
            e.t.j.g.f0.i(this.f13250d, 0);
            e.t.j.g.f0.r(this.f13250d, false);
            e.t.j.g.f0.h(this.f13250d, 0, bool);
        }
    }

    @Override // e.l.k.o6
    public void h(@Nullable DesireFragment desireFragment) {
        this.f13251e = desireFragment;
        synchronized (this) {
            this.f13322g |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13322g != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13322g = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            h((DesireFragment) obj);
            return true;
        }
        return false;
    }

    private p6(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (GameFilterBtn) objArr[3], (ConstraintLayout) objArr[4], (SlideIndicatorView) objArr[2], (ViewPager) objArr[1]);
        this.f13322g = -1L;
        this.a.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f13321f = relativeLayout;
        relativeLayout.setTag(null);
        this.f13249c.setTag(null);
        this.f13250d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
