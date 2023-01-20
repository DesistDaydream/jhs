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
import com.jihuanshe.model.SoldProductInfo;
import com.jihuanshe.ui.page.entrepot.SearchSoldFragment;
import com.jihuanshe.viewmodel.entrepot.SearchSoldViewModel;
import com.vector.databinding.adapter.ListViewBinding;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class z7 extends y7 {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f14051f = null;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f14052g = null;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final FrameLayout f14053d;

    /* renamed from: e  reason: collision with root package name */
    private long f14054e;

    public z7(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f14051f, f14052g));
    }

    private boolean k(NLive<List<SoldProductInfo>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f14054e |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.l.h.j.b.f.b bVar;
        e.t.j.h.l lVar;
        LayoutManagers.a aVar;
        e.t.j.h.p pVar;
        e.l.g.h0 h0Var;
        List<SoldProductInfo> list;
        synchronized (this) {
            j2 = this.f14054e;
            this.f14054e = 0L;
        }
        SearchSoldFragment searchSoldFragment = this.b;
        SearchSoldViewModel searchSoldViewModel = this.f13970c;
        int i2 = ((15 & j2) > 0L ? 1 : ((15 & j2) == 0L ? 0 : -1));
        if (i2 != 0) {
            if ((j2 & 10) == 0 || searchSoldFragment == null) {
                bVar = null;
                lVar = null;
                aVar = null;
                pVar = null;
            } else {
                bVar = searchSoldFragment.f0();
                lVar = searchSoldFragment.i0();
                aVar = searchSoldFragment.g0();
                pVar = searchSoldFragment.j0();
            }
            e.l.g.h0 e0 = searchSoldFragment != null ? searchSoldFragment.e0() : null;
            NLive<List<SoldProductInfo>> r0 = searchSoldViewModel != null ? searchSoldViewModel.r0() : null;
            updateLiveDataRegistration(0, r0);
            if (r0 != null) {
                h0Var = e0;
                list = r0.getValue();
            } else {
                h0Var = e0;
                list = null;
            }
        } else {
            bVar = null;
            lVar = null;
            aVar = null;
            pVar = null;
            h0Var = null;
            list = null;
        }
        if ((10 & j2) != 0) {
            ListViewBinding.c(this.a, bVar);
            ListViewBinding.m(this.a, pVar);
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
            ListViewBinding.a(this.a, h0Var, null, list, null, null, Integer.valueOf((int) R.layout.view_common_empty), null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14054e != 0;
        }
    }

    @Override // e.l.k.y7
    public void i(@Nullable SearchSoldFragment searchSoldFragment) {
        this.b = searchSoldFragment;
        synchronized (this) {
            this.f14054e |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14054e = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.y7
    public void j(@Nullable SearchSoldViewModel searchSoldViewModel) {
        this.f13970c = searchSoldViewModel;
        synchronized (this) {
            this.f14054e |= 4;
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
            i((SearchSoldFragment) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((SearchSoldViewModel) obj);
        }
        return true;
    }

    private z7(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ListView) objArr[1]);
        this.f14054e = -1L;
        this.a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f14053d = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
