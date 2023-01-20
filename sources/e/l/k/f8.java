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
import com.jihuanshe.model.SellerOrderInfo;
import com.jihuanshe.ui.page.order.SellerOrderListFragment;
import com.jihuanshe.viewmodel.order.SellerOrderListViewModel;
import com.vector.databinding.adapter.ListViewBinding;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class f8 extends e8 {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12638f = null;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f12639g = null;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final FrameLayout f12640d;

    /* renamed from: e  reason: collision with root package name */
    private long f12641e;

    public f8(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f12638f, f12639g));
    }

    private boolean k(NLive<List<SellerOrderInfo>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12641e |= 1;
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
        e.l.g.v0 v0Var;
        List<SellerOrderInfo> list;
        e.t.j.h.p pVar2;
        synchronized (this) {
            j2 = this.f12641e;
            this.f12641e = 0L;
        }
        SellerOrderListFragment sellerOrderListFragment = this.b;
        SellerOrderListViewModel sellerOrderListViewModel = this.f12567c;
        int i2 = ((15 & j2) > 0L ? 1 : ((15 & j2) == 0L ? 0 : -1));
        if (i2 != 0) {
            if ((j2 & 10) == 0 || sellerOrderListFragment == null) {
                f0Var = null;
                bVar = null;
                lVar = null;
                aVar = null;
                pVar2 = null;
            } else {
                f0Var = sellerOrderListFragment.k0();
                bVar = sellerOrderListFragment.f0();
                lVar = sellerOrderListFragment.i0();
                aVar = sellerOrderListFragment.g0();
                pVar2 = sellerOrderListFragment.j0();
            }
            e.l.g.v0 e0 = sellerOrderListFragment != null ? sellerOrderListFragment.e0() : null;
            NLive<List<SellerOrderInfo>> r0 = sellerOrderListViewModel != null ? sellerOrderListViewModel.r0() : null;
            updateLiveDataRegistration(0, r0);
            if (r0 != null) {
                v0Var = e0;
                list = r0.getValue();
            } else {
                v0Var = e0;
                list = null;
            }
            pVar = pVar2;
        } else {
            pVar = null;
            f0Var = null;
            bVar = null;
            lVar = null;
            aVar = null;
            v0Var = null;
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
            ListViewBinding.a(this.a, v0Var, null, list, null, null, Integer.valueOf((int) R.layout.view_common_empty), null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12641e != 0;
        }
    }

    @Override // e.l.k.e8
    public void i(@Nullable SellerOrderListFragment sellerOrderListFragment) {
        this.b = sellerOrderListFragment;
        synchronized (this) {
            this.f12641e |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12641e = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.e8
    public void j(@Nullable SellerOrderListViewModel sellerOrderListViewModel) {
        this.f12567c = sellerOrderListViewModel;
        synchronized (this) {
            this.f12641e |= 4;
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
            i((SellerOrderListFragment) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((SellerOrderListViewModel) obj);
        }
        return true;
    }

    private f8(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ListView) objArr[1]);
        this.f12641e = -1L;
        this.a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f12640d = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
