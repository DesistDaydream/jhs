package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.eth.model.NLive;
import com.jihuanshe.model.WantBuyList;
import com.jihuanshe.ui.page.user.WantBuyActivity;
import com.jihuanshe.viewmodel.user.WantBuyViewModel;
import com.vector.databinding.adapter.ListViewBinding;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class z2 extends y2 {
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f14033g = null;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f14034h = null;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final FrameLayout f14035d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final TextView f14036e;

    /* renamed from: f  reason: collision with root package name */
    private long f14037f;

    public z2(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f14033g, f14034h));
    }

    private boolean k(NLive<List<WantBuyList>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f14037f |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.t.j.h.p pVar;
        e.t.j.h.m mVar;
        e.l.h.j.b.f.b bVar;
        e.t.j.h.l lVar;
        e.t.j.h.g gVar;
        LayoutManagers.a aVar;
        e.l.g.z0 z0Var;
        List<WantBuyList> list;
        e.t.j.h.p pVar2;
        e.t.j.h.m mVar2;
        synchronized (this) {
            j2 = this.f14037f;
            this.f14037f = 0L;
        }
        WantBuyActivity wantBuyActivity = this.b;
        WantBuyViewModel wantBuyViewModel = this.f13948c;
        int i2 = ((15 & j2) > 0L ? 1 : ((15 & j2) == 0L ? 0 : -1));
        if (i2 != 0) {
            if ((j2 & 10) == 0 || wantBuyActivity == null) {
                bVar = null;
                lVar = null;
                gVar = null;
                aVar = null;
                pVar2 = null;
                mVar2 = null;
            } else {
                bVar = wantBuyActivity.e0();
                lVar = wantBuyActivity.j0();
                gVar = wantBuyActivity.i0();
                aVar = wantBuyActivity.g0();
                pVar2 = wantBuyActivity.l0();
                mVar2 = wantBuyActivity.k0();
            }
            e.l.g.z0 d0 = wantBuyActivity != null ? wantBuyActivity.d0() : null;
            NLive<List<WantBuyList>> r0 = wantBuyViewModel != null ? wantBuyViewModel.r0() : null;
            updateLiveDataRegistration(0, r0);
            if (r0 != null) {
                z0Var = d0;
                list = r0.getValue();
            } else {
                z0Var = d0;
                list = null;
            }
            pVar = pVar2;
            mVar = mVar2;
        } else {
            pVar = null;
            mVar = null;
            bVar = null;
            lVar = null;
            gVar = null;
            aVar = null;
            z0Var = null;
            list = null;
        }
        if ((10 & j2) != 0) {
            ListViewBinding.c(this.a, bVar);
            ListViewBinding.m(this.a, pVar);
            ListViewBinding.l(this.a, lVar, null, null);
            ListViewBinding.o(this.a, mVar, null, null);
            ListViewBinding.g(this.a, aVar, false);
            e.t.j.g.e0.F(this.f14036e, gVar);
        }
        if ((j2 & 8) != 0) {
            ListViewBinding.d(this.a, false);
            e.l.i.f0.j(this.a, 14, 100);
        }
        if (i2 != 0) {
            ListViewBinding.a(this.a, z0Var, null, list, null, null, null, null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14037f != 0;
        }
    }

    @Override // e.l.k.y2
    public void i(@Nullable WantBuyActivity wantBuyActivity) {
        this.b = wantBuyActivity;
        synchronized (this) {
            this.f14037f |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14037f = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.y2
    public void j(@Nullable WantBuyViewModel wantBuyViewModel) {
        this.f13948c = wantBuyViewModel;
        synchronized (this) {
            this.f14037f |= 4;
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
            i((WantBuyActivity) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((WantBuyViewModel) obj);
        }
        return true;
    }

    private z2(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ListView) objArr[1]);
        this.f14037f = -1L;
        this.a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f14035d = frameLayout;
        frameLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f14036e = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
