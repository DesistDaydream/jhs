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
import com.jihuanshe.model.WarehouseProductInfo;
import com.jihuanshe.ui.page.entrepot.SearchChildCheckFragment;
import com.jihuanshe.viewmodel.entrepot.SearchChildCheckViewModel;
import com.vector.databinding.adapter.ListViewBinding;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class p7 extends o7 {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13323f = null;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f13324g = null;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final FrameLayout f13325d;

    /* renamed from: e  reason: collision with root package name */
    private long f13326e;

    public p7(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f13323f, f13324g));
    }

    private boolean k(NLive<List<WarehouseProductInfo>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13326e |= 1;
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
        e.l.g.s0 s0Var;
        List<WarehouseProductInfo> list;
        e.t.j.h.p pVar2;
        synchronized (this) {
            j2 = this.f13326e;
            this.f13326e = 0L;
        }
        SearchChildCheckFragment searchChildCheckFragment = this.b;
        SearchChildCheckViewModel searchChildCheckViewModel = this.f13252c;
        int i2 = ((15 & j2) > 0L ? 1 : ((15 & j2) == 0L ? 0 : -1));
        if (i2 != 0) {
            if ((j2 & 10) == 0 || searchChildCheckFragment == null) {
                f0Var = null;
                bVar = null;
                lVar = null;
                aVar = null;
                pVar2 = null;
            } else {
                f0Var = searchChildCheckFragment.m0();
                bVar = searchChildCheckFragment.h0();
                lVar = searchChildCheckFragment.k0();
                aVar = searchChildCheckFragment.i0();
                pVar2 = searchChildCheckFragment.l0();
            }
            e.l.g.s0 f0 = searchChildCheckFragment != null ? searchChildCheckFragment.f0() : null;
            NLive<List<WarehouseProductInfo>> q0 = searchChildCheckViewModel != null ? searchChildCheckViewModel.q0() : null;
            updateLiveDataRegistration(0, q0);
            if (q0 != null) {
                s0Var = f0;
                list = q0.getValue();
            } else {
                s0Var = f0;
                list = null;
            }
            pVar = pVar2;
        } else {
            pVar = null;
            f0Var = null;
            bVar = null;
            lVar = null;
            aVar = null;
            s0Var = null;
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
            ListView listView = this.a;
            ListViewBinding.k(listView, listView.getResources().getString(R.string.common_no_more));
            ListViewBinding.y(this.a, true);
            e.l.i.f0.j(this.a, 12, null);
        }
        if (i2 != 0) {
            ListViewBinding.a(this.a, s0Var, null, list, null, null, Integer.valueOf((int) R.layout.view_common_empty), null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13326e != 0;
        }
    }

    @Override // e.l.k.o7
    public void i(@Nullable SearchChildCheckFragment searchChildCheckFragment) {
        this.b = searchChildCheckFragment;
        synchronized (this) {
            this.f13326e |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13326e = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.o7
    public void j(@Nullable SearchChildCheckViewModel searchChildCheckViewModel) {
        this.f13252c = searchChildCheckViewModel;
        synchronized (this) {
            this.f13326e |= 4;
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
            i((SearchChildCheckFragment) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((SearchChildCheckViewModel) obj);
        }
        return true;
    }

    private p7(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ListView) objArr[1]);
        this.f13326e = -1L;
        this.a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f13325d = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
