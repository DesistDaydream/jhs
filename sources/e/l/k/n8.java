package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.Product;
import com.jihuanshe.ui.page.user.wish.WishListFragment;
import com.jihuanshe.viewmodel.user.wish.WishListViewModel;
import com.vector.databinding.adapter.ListViewBinding;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class n8 extends m8 {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13194f = null;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f13195g = null;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final FrameLayout f13196d;

    /* renamed from: e  reason: collision with root package name */
    private long f13197e;

    public n8(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f13194f, f13195g));
    }

    private boolean k(e.n.f<List<Product>> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13197e |= 1;
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
        e.l.g.b1 b1Var;
        List<Product> list;
        synchronized (this) {
            j2 = this.f13197e;
            this.f13197e = 0L;
        }
        WishListFragment wishListFragment = this.b;
        WishListViewModel wishListViewModel = this.f13121c;
        int i2 = ((15 & j2) > 0L ? 1 : ((15 & j2) == 0L ? 0 : -1));
        if (i2 != 0) {
            if ((j2 & 10) == 0 || wishListFragment == null) {
                bVar = null;
                lVar = null;
                aVar = null;
                pVar = null;
            } else {
                bVar = wishListFragment.h0();
                lVar = wishListFragment.n0();
                aVar = wishListFragment.k0();
                pVar = wishListFragment.o0();
            }
            e.l.g.b1 g0 = wishListFragment != null ? wishListFragment.g0() : null;
            e.n.f<List<Product>> r0 = wishListViewModel != null ? wishListViewModel.r0() : null;
            updateLiveDataRegistration(0, r0);
            if (r0 != null) {
                b1Var = g0;
                list = r0.getValue();
            } else {
                b1Var = g0;
                list = null;
            }
        } else {
            bVar = null;
            lVar = null;
            aVar = null;
            pVar = null;
            b1Var = null;
            list = null;
        }
        if ((10 & j2) != 0) {
            ListViewBinding.c(this.a, bVar);
            ListViewBinding.m(this.a, pVar);
            ListViewBinding.l(this.a, lVar, null, null);
            ListViewBinding.g(this.a, aVar, false);
        }
        if ((j2 & 8) != 0) {
            ListViewBinding.d(this.a, false);
            ListViewBinding.e(this.a, null);
            e.l.i.f0.j(this.a, 12, null);
        }
        if (i2 != 0) {
            ListViewBinding.a(this.a, b1Var, null, list, null, null, Integer.valueOf((int) R.layout.view_common_empty), null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13197e != 0;
        }
    }

    @Override // e.l.k.m8
    public void i(@Nullable WishListFragment wishListFragment) {
        this.b = wishListFragment;
        synchronized (this) {
            this.f13197e |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13197e = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.m8
    public void j(@Nullable WishListViewModel wishListViewModel) {
        this.f13121c = wishListViewModel;
        synchronized (this) {
            this.f13197e |= 4;
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
            i((WishListFragment) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((WishListViewModel) obj);
        }
        return true;
    }

    private n8(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ListView) objArr[1]);
        this.f13197e = -1L;
        this.a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f13196d = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
