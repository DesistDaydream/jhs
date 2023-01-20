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
import com.jihuanshe.model.FailProductInfo;
import com.jihuanshe.ui.page.entrepot.SearchChildNoPassFragment;
import com.jihuanshe.viewmodel.entrepot.SearchChildNoPassViewModel;
import com.vector.databinding.adapter.ListViewBinding;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class r7 extends q7 {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13468f = null;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f13469g = null;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final FrameLayout f13470d;

    /* renamed from: e  reason: collision with root package name */
    private long f13471e;

    public r7(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f13468f, f13469g));
    }

    private boolean k(NLive<List<FailProductInfo>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13471e |= 1;
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
        e.l.g.g0 g0Var;
        List<FailProductInfo> list;
        synchronized (this) {
            j2 = this.f13471e;
            this.f13471e = 0L;
        }
        SearchChildNoPassFragment searchChildNoPassFragment = this.b;
        SearchChildNoPassViewModel searchChildNoPassViewModel = this.f13424c;
        int i2 = ((15 & j2) > 0L ? 1 : ((15 & j2) == 0L ? 0 : -1));
        if (i2 != 0) {
            if ((j2 & 10) == 0 || searchChildNoPassFragment == null) {
                bVar = null;
                lVar = null;
                aVar = null;
                pVar = null;
            } else {
                bVar = searchChildNoPassFragment.f0();
                lVar = searchChildNoPassFragment.i0();
                aVar = searchChildNoPassFragment.g0();
                pVar = searchChildNoPassFragment.j0();
            }
            e.l.g.g0 e0 = searchChildNoPassFragment != null ? searchChildNoPassFragment.e0() : null;
            NLive<List<FailProductInfo>> r0 = searchChildNoPassViewModel != null ? searchChildNoPassViewModel.r0() : null;
            updateLiveDataRegistration(0, r0);
            if (r0 != null) {
                g0Var = e0;
                list = r0.getValue();
            } else {
                g0Var = e0;
                list = null;
            }
        } else {
            bVar = null;
            lVar = null;
            aVar = null;
            pVar = null;
            g0Var = null;
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
            ListViewBinding.a(this.a, g0Var, null, list, null, null, Integer.valueOf((int) R.layout.view_common_empty), null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13471e != 0;
        }
    }

    @Override // e.l.k.q7
    public void i(@Nullable SearchChildNoPassFragment searchChildNoPassFragment) {
        this.b = searchChildNoPassFragment;
        synchronized (this) {
            this.f13471e |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13471e = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.q7
    public void j(@Nullable SearchChildNoPassViewModel searchChildNoPassViewModel) {
        this.f13424c = searchChildNoPassViewModel;
        synchronized (this) {
            this.f13471e |= 4;
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
            i((SearchChildNoPassFragment) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((SearchChildNoPassViewModel) obj);
        }
        return true;
    }

    private r7(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ListView) objArr[1]);
        this.f13471e = -1L;
        this.a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f13470d = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
