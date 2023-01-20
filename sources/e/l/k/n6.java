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
import com.jihuanshe.model.CardConsignmentInfo;
import com.jihuanshe.ui.page.entrepot.ConsignmentOrderFragment;
import com.jihuanshe.viewmodel.entrepot.ConsignmentOrderChildViewModel;
import com.vector.databinding.adapter.ListViewBinding;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class n6 extends m6 {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13186f = null;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f13187g = null;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final FrameLayout f13188d;

    /* renamed from: e  reason: collision with root package name */
    private long f13189e;

    public n6(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f13186f, f13187g));
    }

    private boolean k(NLive<List<CardConsignmentInfo>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13189e |= 1;
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
        e.l.g.p pVar2;
        List<CardConsignmentInfo> list;
        e.t.j.h.p pVar3;
        synchronized (this) {
            j2 = this.f13189e;
            this.f13189e = 0L;
        }
        ConsignmentOrderFragment consignmentOrderFragment = this.b;
        ConsignmentOrderChildViewModel consignmentOrderChildViewModel = this.f13117c;
        int i2 = ((15 & j2) > 0L ? 1 : ((15 & j2) == 0L ? 0 : -1));
        if (i2 != 0) {
            if ((j2 & 10) == 0 || consignmentOrderFragment == null) {
                f0Var = null;
                bVar = null;
                lVar = null;
                aVar = null;
                pVar3 = null;
            } else {
                f0Var = consignmentOrderFragment.k0();
                bVar = consignmentOrderFragment.f0();
                lVar = consignmentOrderFragment.i0();
                aVar = consignmentOrderFragment.g0();
                pVar3 = consignmentOrderFragment.j0();
            }
            e.l.g.p e0 = consignmentOrderFragment != null ? consignmentOrderFragment.e0() : null;
            NLive<List<CardConsignmentInfo>> s0 = consignmentOrderChildViewModel != null ? consignmentOrderChildViewModel.s0() : null;
            updateLiveDataRegistration(0, s0);
            if (s0 != null) {
                pVar2 = e0;
                list = s0.getValue();
            } else {
                pVar2 = e0;
                list = null;
            }
            pVar = pVar3;
        } else {
            pVar = null;
            f0Var = null;
            bVar = null;
            lVar = null;
            aVar = null;
            pVar2 = null;
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
            e.l.i.f0.j(this.a, 14, null);
        }
        if (i2 != 0) {
            ListViewBinding.a(this.a, pVar2, null, list, null, null, Integer.valueOf((int) R.layout.view_common_empty), null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13189e != 0;
        }
    }

    @Override // e.l.k.m6
    public void i(@Nullable ConsignmentOrderFragment consignmentOrderFragment) {
        this.b = consignmentOrderFragment;
        synchronized (this) {
            this.f13189e |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13189e = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.m6
    public void j(@Nullable ConsignmentOrderChildViewModel consignmentOrderChildViewModel) {
        this.f13117c = consignmentOrderChildViewModel;
        synchronized (this) {
            this.f13189e |= 4;
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
            i((ConsignmentOrderFragment) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((ConsignmentOrderChildViewModel) obj);
        }
        return true;
    }

    private n6(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ListView) objArr[1]);
        this.f13189e = -1L;
        this.a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f13188d = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
