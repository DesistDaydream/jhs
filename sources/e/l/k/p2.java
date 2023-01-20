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
import com.jihuanshe.model.ShopCartItem;
import com.jihuanshe.ui.page.user.ShopCarActivity;
import com.jihuanshe.viewmodel.user.ShopCarViewModel;
import com.vector.databinding.adapter.ListViewBinding;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class p2 extends o2 {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13294f = null;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f13295g = null;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final FrameLayout f13296d;

    /* renamed from: e  reason: collision with root package name */
    private long f13297e;

    public p2(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f13294f, f13295g));
    }

    private boolean k(NLive<List<ShopCartItem>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13297e |= 1;
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
        e.l.g.f0 f0Var2;
        List<ShopCartItem> list;
        e.t.j.h.p pVar2;
        synchronized (this) {
            j2 = this.f13297e;
            this.f13297e = 0L;
        }
        ShopCarActivity shopCarActivity = this.b;
        ShopCarViewModel shopCarViewModel = this.f13246c;
        int i2 = ((15 & j2) > 0L ? 1 : ((15 & j2) == 0L ? 0 : -1));
        if (i2 != 0) {
            if ((j2 & 10) == 0 || shopCarActivity == null) {
                f0Var = null;
                bVar = null;
                lVar = null;
                aVar = null;
                pVar2 = null;
            } else {
                f0Var = shopCarActivity.d0();
                bVar = shopCarActivity.Y();
                lVar = shopCarActivity.b0();
                aVar = shopCarActivity.Z();
                pVar2 = shopCarActivity.c0();
            }
            e.l.g.f0 X = shopCarActivity != null ? shopCarActivity.X() : null;
            NLive<List<ShopCartItem>> t0 = shopCarViewModel != null ? shopCarViewModel.t0() : null;
            updateLiveDataRegistration(0, t0);
            if (t0 != null) {
                f0Var2 = X;
                list = t0.getValue();
            } else {
                f0Var2 = X;
                list = null;
            }
            pVar = pVar2;
        } else {
            pVar = null;
            f0Var = null;
            bVar = null;
            lVar = null;
            aVar = null;
            f0Var2 = null;
            list = null;
        }
        if ((10 & j2) != 0) {
            ListViewBinding.c(this.a, bVar);
            ListViewBinding.q(this.a, f0Var);
            ListViewBinding.m(this.a, pVar);
            ListViewBinding.l(this.a, lVar, null, null);
            ListViewBinding.g(this.a, aVar, false);
        }
        if ((j2 & 8) != 0) {
            ListViewBinding.y(this.a, true);
            ListView listView = this.a;
            ListViewBinding.k(listView, listView.getResources().getString(R.string.common_no_more));
            e.l.i.f0.j(this.a, 14, null);
        }
        if (i2 != 0) {
            ListViewBinding.a(this.a, f0Var2, null, list, null, null, Integer.valueOf((int) R.layout.view_common_empty), null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13297e != 0;
        }
    }

    @Override // e.l.k.o2
    public void i(@Nullable ShopCarActivity shopCarActivity) {
        this.b = shopCarActivity;
        synchronized (this) {
            this.f13297e |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13297e = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.o2
    public void j(@Nullable ShopCarViewModel shopCarViewModel) {
        this.f13246c = shopCarViewModel;
        synchronized (this) {
            this.f13297e |= 4;
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
            i((ShopCarActivity) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((ShopCarViewModel) obj);
        }
        return true;
    }

    private p2(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ListView) objArr[1]);
        this.f13297e = -1L;
        this.a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f13296d = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
