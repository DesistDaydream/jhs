package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.Product;
import com.jihuanshe.ui.page.search.fragments.global.SearchProductFragment;
import com.jihuanshe.viewmodel.search.globals.SearchProductViewModel;
import com.vector.databinding.adapter.ListViewBinding;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class x7 extends w7 {
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13904e = null;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f13905f = null;

    /* renamed from: d  reason: collision with root package name */
    private long f13906d;

    public x7(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f13904e, f13905f));
    }

    private boolean k(e.n.f<List<Product>> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13906d |= 1;
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
        e.l.g.c1.a aVar2;
        List<Product> list;
        View view;
        View view2;
        e.l.g.c1.a aVar3;
        synchronized (this) {
            j2 = this.f13906d;
            this.f13906d = 0L;
        }
        SearchProductFragment searchProductFragment = this.b;
        SearchProductViewModel searchProductViewModel = this.f13840c;
        int i2 = ((15 & j2) > 0L ? 1 : ((15 & j2) == 0L ? 0 : -1));
        if (i2 != 0) {
            if ((j2 & 10) == 0 || searchProductFragment == null) {
                bVar = null;
                lVar = null;
                aVar = null;
                pVar = null;
            } else {
                bVar = searchProductFragment.i0();
                lVar = searchProductFragment.o0();
                aVar = searchProductFragment.l0();
                pVar = searchProductFragment.p0();
            }
            if (searchProductFragment != null) {
                aVar3 = searchProductFragment.h0();
                view2 = searchProductFragment.j0();
            } else {
                view2 = null;
                aVar3 = null;
            }
            e.n.f<List<Product>> q0 = searchProductViewModel != null ? searchProductViewModel.q0() : null;
            updateLiveDataRegistration(0, q0);
            if (q0 != null) {
                view = view2;
                list = q0.getValue();
            } else {
                view = view2;
                list = null;
            }
            aVar2 = aVar3;
        } else {
            bVar = null;
            lVar = null;
            aVar = null;
            pVar = null;
            aVar2 = null;
            list = null;
            view = null;
        }
        if ((j2 & 10) != 0) {
            ListViewBinding.c(this.a, bVar);
            ListViewBinding.m(this.a, pVar);
            ListViewBinding.l(this.a, lVar, null, null);
            ListViewBinding.g(this.a, aVar, false);
        }
        if (i2 != 0) {
            ListViewBinding.a(this.a, aVar2, null, list, view, null, Integer.valueOf((int) R.layout.view_common_empty), null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13906d != 0;
        }
    }

    @Override // e.l.k.w7
    public void i(@Nullable SearchProductFragment searchProductFragment) {
        this.b = searchProductFragment;
        synchronized (this) {
            this.f13906d |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13906d = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.w7
    public void j(@Nullable SearchProductViewModel searchProductViewModel) {
        this.f13840c = searchProductViewModel;
        synchronized (this) {
            this.f13906d |= 4;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return k((e.n.f) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((SearchProductFragment) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((SearchProductViewModel) obj);
        }
        return true;
    }

    private x7(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ListView) objArr[0]);
        this.f13906d = -1L;
        this.a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
