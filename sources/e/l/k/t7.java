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
import com.jihuanshe.model.GameCard;
import com.jihuanshe.ui.page.entrepot.SearchHouseProductFragment;
import com.jihuanshe.viewmodel.entrepot.SearchHouseProductViewModel;
import com.vector.databinding.adapter.ListViewBinding;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class t7 extends s7 {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13617f = null;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f13618g = null;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final FrameLayout f13619d;

    /* renamed from: e  reason: collision with root package name */
    private long f13620e;

    public t7(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f13617f, f13618g));
    }

    private boolean k(NLive<List<GameCard>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13620e |= 1;
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
        e.l.g.u0 u0Var;
        List<GameCard> list;
        synchronized (this) {
            j2 = this.f13620e;
            this.f13620e = 0L;
        }
        SearchHouseProductFragment searchHouseProductFragment = this.b;
        SearchHouseProductViewModel searchHouseProductViewModel = this.f13558c;
        int i2 = ((15 & j2) > 0L ? 1 : ((15 & j2) == 0L ? 0 : -1));
        if (i2 != 0) {
            if ((j2 & 10) == 0 || searchHouseProductFragment == null) {
                aVar = null;
                lVar = null;
                aVar2 = null;
                pVar = null;
            } else {
                aVar = searchHouseProductFragment.f0();
                lVar = searchHouseProductFragment.i0();
                aVar2 = searchHouseProductFragment.g0();
                pVar = searchHouseProductFragment.j0();
            }
            e.l.g.u0 e0 = searchHouseProductFragment != null ? searchHouseProductFragment.e0() : null;
            NLive<List<GameCard>> q0 = searchHouseProductViewModel != null ? searchHouseProductViewModel.q0() : null;
            updateLiveDataRegistration(0, q0);
            if (q0 != null) {
                u0Var = e0;
                list = q0.getValue();
            } else {
                u0Var = e0;
                list = null;
            }
        } else {
            aVar = null;
            lVar = null;
            aVar2 = null;
            pVar = null;
            u0Var = null;
            list = null;
        }
        if ((10 & j2) != 0) {
            ListViewBinding.c(this.a, aVar);
            ListViewBinding.m(this.a, pVar);
            ListViewBinding.l(this.a, lVar, null, null);
            ListViewBinding.g(this.a, aVar2, false);
        }
        if ((j2 & 8) != 0) {
            ListView listView = this.a;
            ListViewBinding.k(listView, listView.getResources().getString(R.string.common_no_more));
            ListViewBinding.y(this.a, true);
            e.l.i.f0.j(this.a, 12, null);
        }
        if (i2 != 0) {
            ListViewBinding.a(this.a, u0Var, null, list, null, null, Integer.valueOf((int) R.layout.view_common_empty), null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13620e != 0;
        }
    }

    @Override // e.l.k.s7
    public void i(@Nullable SearchHouseProductFragment searchHouseProductFragment) {
        this.b = searchHouseProductFragment;
        synchronized (this) {
            this.f13620e |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13620e = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.s7
    public void j(@Nullable SearchHouseProductViewModel searchHouseProductViewModel) {
        this.f13558c = searchHouseProductViewModel;
        synchronized (this) {
            this.f13620e |= 4;
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
            i((SearchHouseProductFragment) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((SearchHouseProductViewModel) obj);
        }
        return true;
    }

    private t7(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ListView) objArr[1]);
        this.f13620e = -1L;
        this.a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f13619d = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
