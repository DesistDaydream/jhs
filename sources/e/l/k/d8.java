package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.eth.model.NLive;
import com.jihuanshe.R;
import com.jihuanshe.model.WantCard;
import com.jihuanshe.ui.page.search.fragments.wantcard.SearchWantCardListFragment;
import com.jihuanshe.viewmodel.user.WantCardListViewModel;
import com.vector.databinding.adapter.ListViewBinding;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class d8 extends c8 {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12505f = null;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f12506g = null;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final ConstraintLayout f12507d;

    /* renamed from: e  reason: collision with root package name */
    private long f12508e;

    public d8(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f12505f, f12506g));
    }

    private boolean k(NLive<List<WantCard>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12508e |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.l.h.j.b.f.a aVar;
        e.t.j.h.l lVar;
        LayoutManagers.a aVar2;
        e.t.j.h.p pVar;
        e.l.g.a1 a1Var;
        List<WantCard> list;
        synchronized (this) {
            j2 = this.f12508e;
            this.f12508e = 0L;
        }
        SearchWantCardListFragment searchWantCardListFragment = this.b;
        WantCardListViewModel wantCardListViewModel = this.f12414c;
        int i2 = ((15 & j2) > 0L ? 1 : ((15 & j2) == 0L ? 0 : -1));
        if (i2 != 0) {
            if ((j2 & 10) == 0 || searchWantCardListFragment == null) {
                aVar = null;
                lVar = null;
                aVar2 = null;
                pVar = null;
            } else {
                aVar = searchWantCardListFragment.h0();
                lVar = searchWantCardListFragment.k0();
                aVar2 = searchWantCardListFragment.j0();
                pVar = searchWantCardListFragment.l0();
            }
            e.l.g.a1 g0 = searchWantCardListFragment != null ? searchWantCardListFragment.g0() : null;
            NLive<List<WantCard>> v0 = wantCardListViewModel != null ? wantCardListViewModel.v0() : null;
            updateLiveDataRegistration(0, v0);
            if (v0 != null) {
                a1Var = g0;
                list = v0.getValue();
            } else {
                a1Var = g0;
                list = null;
            }
        } else {
            aVar = null;
            lVar = null;
            aVar2 = null;
            pVar = null;
            a1Var = null;
            list = null;
        }
        if ((10 & j2) != 0) {
            ListViewBinding.c(this.a, aVar);
            ListViewBinding.m(this.a, pVar);
            ListViewBinding.l(this.a, lVar, null, null);
            ListViewBinding.g(this.a, aVar2, false);
        }
        if ((j2 & 8) != 0) {
            ListViewBinding.d(this.a, false);
            e.l.i.f0.j(this.a, 7, null);
        }
        if (i2 != 0) {
            ListViewBinding.a(this.a, a1Var, null, list, null, null, Integer.valueOf((int) R.layout.view_common_empty), null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12508e != 0;
        }
    }

    @Override // e.l.k.c8
    public void i(@Nullable SearchWantCardListFragment searchWantCardListFragment) {
        this.b = searchWantCardListFragment;
        synchronized (this) {
            this.f12508e |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12508e = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.c8
    public void j(@Nullable WantCardListViewModel wantCardListViewModel) {
        this.f12414c = wantCardListViewModel;
        synchronized (this) {
            this.f12508e |= 4;
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
            i((SearchWantCardListFragment) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((WantCardListViewModel) obj);
        }
        return true;
    }

    private d8(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ListView) objArr[1]);
        this.f12508e = -1L;
        this.a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12507d = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
