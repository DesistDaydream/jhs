package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.eth.model.NLive;
import com.jihuanshe.model.MatchResult;
import com.jihuanshe.ui.page.user.WantBuyMatchActivity;
import com.jihuanshe.viewmodel.user.WantBuyMatchViewModel;
import com.vector.databinding.adapter.ListViewBinding;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class b3 extends a3 {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12331f = null;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f12332g = null;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final FrameLayout f12333d;

    /* renamed from: e  reason: collision with root package name */
    private long f12334e;

    public b3(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f12331f, f12332g));
    }

    private boolean k(NLive<List<MatchResult>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12334e |= 1;
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
        e.l.g.e0 e0Var;
        List<MatchResult> list;
        View view;
        View view2;
        e.l.g.e0 e0Var2;
        synchronized (this) {
            j2 = this.f12334e;
            this.f12334e = 0L;
        }
        WantBuyMatchActivity wantBuyMatchActivity = this.b;
        WantBuyMatchViewModel wantBuyMatchViewModel = this.f12252c;
        int i2 = ((15 & j2) > 0L ? 1 : ((15 & j2) == 0L ? 0 : -1));
        if (i2 != 0) {
            if ((j2 & 10) == 0 || wantBuyMatchActivity == null) {
                bVar = null;
                lVar = null;
                aVar = null;
            } else {
                bVar = wantBuyMatchActivity.X();
                lVar = wantBuyMatchActivity.c0();
                aVar = wantBuyMatchActivity.Z();
            }
            if (wantBuyMatchActivity != null) {
                e0Var2 = wantBuyMatchActivity.W();
                view2 = wantBuyMatchActivity.Y();
            } else {
                view2 = null;
                e0Var2 = null;
            }
            NLive<List<MatchResult>> q0 = wantBuyMatchViewModel != null ? wantBuyMatchViewModel.q0() : null;
            updateLiveDataRegistration(0, q0);
            if (q0 != null) {
                view = view2;
                list = q0.getValue();
            } else {
                view = view2;
                list = null;
            }
            e0Var = e0Var2;
        } else {
            bVar = null;
            lVar = null;
            aVar = null;
            e0Var = null;
            list = null;
            view = null;
        }
        if ((8 & j2) != 0) {
            ListViewBinding.d(this.a, false);
        }
        if ((j2 & 10) != 0) {
            ListViewBinding.c(this.a, bVar);
            ListViewBinding.l(this.a, lVar, null, null);
            ListViewBinding.g(this.a, aVar, false);
        }
        if (i2 != 0) {
            ListViewBinding.a(this.a, e0Var, null, list, view, null, null, null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12334e != 0;
        }
    }

    @Override // e.l.k.a3
    public void i(@Nullable WantBuyMatchActivity wantBuyMatchActivity) {
        this.b = wantBuyMatchActivity;
        synchronized (this) {
            this.f12334e |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12334e = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.a3
    public void j(@Nullable WantBuyMatchViewModel wantBuyMatchViewModel) {
        this.f12252c = wantBuyMatchViewModel;
        synchronized (this) {
            this.f12334e |= 4;
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
            i((WantBuyMatchActivity) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((WantBuyMatchViewModel) obj);
        }
        return true;
    }

    private b3(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ListView) objArr[1]);
        this.f12334e = -1L;
        this.a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f12333d = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
