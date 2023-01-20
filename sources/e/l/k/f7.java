package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.eth.model.NLive;
import com.jihuanshe.R;
import com.jihuanshe.model.OrderInfo;
import com.jihuanshe.ui.page.order.OrderListFragment;
import com.jihuanshe.viewmodel.order.OrderListChildViewModel;
import com.vector.databinding.adapter.ListViewBinding;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class f7 extends e7 {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12634f = null;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f12635g = null;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final FrameLayout f12636d;

    /* renamed from: e  reason: collision with root package name */
    private long f12637e;

    public f7(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f12634f, f12635g));
    }

    private boolean k(NLive<List<OrderInfo>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12637e |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.t.j.h.p pVar;
        e.t.j.h.f0 f0Var;
        e.l.h.j.b.f.b bVar;
        e.t.j.h.l lVar;
        LayoutManagers.a aVar;
        e.l.g.k0 k0Var;
        List<OrderInfo> list;
        e.t.j.h.p pVar2;
        synchronized (this) {
            j2 = this.f12637e;
            this.f12637e = 0L;
        }
        OrderListFragment orderListFragment = this.b;
        OrderListChildViewModel orderListChildViewModel = this.f12566c;
        int i2 = ((15 & j2) > 0L ? 1 : ((15 & j2) == 0L ? 0 : -1));
        if (i2 != 0) {
            if ((j2 & 10) == 0 || orderListFragment == null) {
                f0Var = null;
                bVar = null;
                lVar = null;
                aVar = null;
                pVar2 = null;
            } else {
                f0Var = orderListFragment.k0();
                bVar = orderListFragment.f0();
                lVar = orderListFragment.i0();
                aVar = orderListFragment.g0();
                pVar2 = orderListFragment.j0();
            }
            e.l.g.k0 e0 = orderListFragment != null ? orderListFragment.e0() : null;
            NLive<List<OrderInfo>> r0 = orderListChildViewModel != null ? orderListChildViewModel.r0() : null;
            updateLiveDataRegistration(0, r0);
            if (r0 != null) {
                k0Var = e0;
                list = r0.getValue();
            } else {
                k0Var = e0;
                list = null;
            }
            pVar = pVar2;
        } else {
            pVar = null;
            f0Var = null;
            bVar = null;
            lVar = null;
            aVar = null;
            k0Var = null;
            list = null;
        }
        if ((10 & j2) != 0) {
            ListViewBinding.c(this.a, bVar);
            ListViewBinding.m(this.a, pVar);
            ListViewBinding.q(this.a, f0Var);
            ListViewBinding.l(this.a, lVar, null, null);
            ListViewBinding.g(this.a, aVar, false);
        }
        if ((j2 & 8) != 0) {
            ListViewBinding.y(this.a, true);
            ListView listView = this.a;
            ListViewBinding.k(listView, listView.getResources().getString(R.string.common_no_more));
            e.l.i.f0.j(this.a, 19, null);
        }
        if (i2 != 0) {
            ListViewBinding.a(this.a, k0Var, null, list, null, null, Integer.valueOf((int) R.layout.view_common_empty), null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12637e != 0;
        }
    }

    @Override // e.l.k.e7
    public void i(@Nullable OrderListFragment orderListFragment) {
        this.b = orderListFragment;
        synchronized (this) {
            this.f12637e |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12637e = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.e7
    public void j(@Nullable OrderListChildViewModel orderListChildViewModel) {
        this.f12566c = orderListChildViewModel;
        synchronized (this) {
            this.f12637e |= 4;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return k((NLive) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((OrderListFragment) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((OrderListChildViewModel) obj);
        }
        return true;
    }

    private f7(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ListView) objArr[1]);
        this.f12637e = -1L;
        this.a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f12636d = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
