package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.eth.model.NLive;
import com.jihuanshe.R;
import com.jihuanshe.model.WantCard;
import com.jihuanshe.ui.page.user.WantCardListActivity;
import com.jihuanshe.viewmodel.user.WantCardListViewModel;
import com.vector.databinding.adapter.ListViewBinding;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class d3 extends c3 {
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12482i = null;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static final SparseIntArray f12483j;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final ConstraintLayout f12484e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final ConstraintLayout f12485f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final ConstraintLayout f12486g;

    /* renamed from: h  reason: collision with root package name */
    private long f12487h;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f12483j = sparseIntArray;
        sparseIntArray.put(R.id.shopCard, 4);
    }

    public d3(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f12482i, f12483j));
    }

    private boolean k(NLive<List<WantCard>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12487h |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.t.j.h.p pVar;
        e.t.j.h.g gVar;
        e.l.h.j.b.f.a aVar;
        e.t.j.h.l lVar;
        e.t.j.h.g gVar2;
        LayoutManagers.a aVar2;
        e.l.g.a1 a1Var;
        List<WantCard> list;
        e.t.j.h.p pVar2;
        e.t.j.h.g gVar3;
        synchronized (this) {
            j2 = this.f12487h;
            this.f12487h = 0L;
        }
        WantCardListActivity wantCardListActivity = this.f12394c;
        WantCardListViewModel wantCardListViewModel = this.f12395d;
        int i2 = ((15 & j2) > 0L ? 1 : ((15 & j2) == 0L ? 0 : -1));
        if (i2 != 0) {
            if ((j2 & 10) == 0 || wantCardListActivity == null) {
                aVar = null;
                lVar = null;
                gVar2 = null;
                aVar2 = null;
                pVar2 = null;
                gVar3 = null;
            } else {
                aVar = wantCardListActivity.Y();
                lVar = wantCardListActivity.c0();
                gVar2 = wantCardListActivity.e0();
                aVar2 = wantCardListActivity.Z();
                pVar2 = wantCardListActivity.d0();
                gVar3 = wantCardListActivity.b0();
            }
            e.l.g.a1 X = wantCardListActivity != null ? wantCardListActivity.X() : null;
            NLive<List<WantCard>> v0 = wantCardListViewModel != null ? wantCardListViewModel.v0() : null;
            updateLiveDataRegistration(0, v0);
            if (v0 != null) {
                a1Var = X;
                list = v0.getValue();
            } else {
                a1Var = X;
                list = null;
            }
            pVar = pVar2;
            gVar = gVar3;
        } else {
            pVar = null;
            gVar = null;
            aVar = null;
            lVar = null;
            gVar2 = null;
            aVar2 = null;
            a1Var = null;
            list = null;
        }
        if ((10 & j2) != 0) {
            ListViewBinding.c(this.a, aVar);
            ListViewBinding.m(this.a, pVar);
            ListViewBinding.l(this.a, lVar, null, null);
            ListViewBinding.g(this.a, aVar2, false);
            e.t.j.g.e0.F(this.f12485f, gVar);
            e.t.j.g.e0.F(this.f12486g, gVar2);
        }
        if ((j2 & 8) != 0) {
            ListViewBinding.d(this.a, false);
            e.l.i.f0.j(this.a, 7, null);
        }
        if (i2 != 0) {
            ListViewBinding.a(this.a, a1Var, null, list, null, null, null, null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12487h != 0;
        }
    }

    @Override // e.l.k.c3
    public void i(@Nullable WantCardListActivity wantCardListActivity) {
        this.f12394c = wantCardListActivity;
        synchronized (this) {
            this.f12487h |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12487h = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.c3
    public void j(@Nullable WantCardListViewModel wantCardListViewModel) {
        this.f12395d = wantCardListViewModel;
        synchronized (this) {
            this.f12487h |= 4;
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
            i((WantCardListActivity) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((WantCardListViewModel) obj);
        }
        return true;
    }

    private d3(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ListView) objArr[1], (LinearLayout) objArr[4]);
        this.f12487h = -1L;
        this.a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12484e = constraintLayout;
        constraintLayout.setTag(null);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) objArr[2];
        this.f12485f = constraintLayout2;
        constraintLayout2.setTag(null);
        ConstraintLayout constraintLayout3 = (ConstraintLayout) objArr[3];
        this.f12486g = constraintLayout3;
        constraintLayout3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
