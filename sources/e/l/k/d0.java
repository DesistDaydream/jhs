package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.eth.model.NLive;
import com.google.android.material.button.MaterialButton;
import com.jihuanshe.R;
import com.jihuanshe.model.CoinLog;
import com.jihuanshe.ui.page.user.CoinActivity;
import com.jihuanshe.viewmodel.user.CoinViewModel;
import com.vector.databinding.adapter.ListViewBinding;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class d0 extends c0 {
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12468g = null;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f12469h = null;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final ConstraintLayout f12470d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final MaterialButton f12471e;

    /* renamed from: f  reason: collision with root package name */
    private long f12472f;

    public d0(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f12468g, f12469h));
    }

    private boolean k(NLive<List<CoinLog>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12472f |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.t.j.h.p pVar;
        e.l.h.j.b.f.b bVar;
        e.t.j.h.g gVar;
        LayoutManagers.a aVar;
        e.l.g.o oVar;
        List<CoinLog> list;
        View view;
        e.t.j.h.f0 f0Var;
        e.t.j.h.p pVar2;
        View view2;
        synchronized (this) {
            j2 = this.f12472f;
            this.f12472f = 0L;
        }
        CoinActivity coinActivity = this.b;
        CoinViewModel coinViewModel = this.f12382c;
        e.t.j.h.f0 f0Var2 = null;
        int i2 = ((15 & j2) > 0L ? 1 : ((15 & j2) == 0L ? 0 : -1));
        if (i2 != 0) {
            if ((j2 & 10) == 0 || coinActivity == null) {
                f0Var = null;
                bVar = null;
                gVar = null;
                aVar = null;
                pVar2 = null;
            } else {
                f0Var = coinActivity.i0();
                bVar = coinActivity.Z();
                gVar = coinActivity.g0();
                aVar = coinActivity.b0();
                pVar2 = coinActivity.h0();
            }
            if (coinActivity != null) {
                oVar = coinActivity.Y();
                view2 = coinActivity.a0();
            } else {
                view2 = null;
                oVar = null;
            }
            NLive<List<CoinLog>> r0 = coinViewModel != null ? coinViewModel.r0() : null;
            updateLiveDataRegistration(0, r0);
            view = view2;
            list = r0 != null ? r0.getValue() : null;
            pVar = pVar2;
            f0Var2 = f0Var;
        } else {
            pVar = null;
            bVar = null;
            gVar = null;
            aVar = null;
            oVar = null;
            list = null;
            view = null;
        }
        if ((j2 & 10) != 0) {
            ListViewBinding.q(this.a, f0Var2);
            ListViewBinding.m(this.a, pVar);
            ListViewBinding.c(this.a, bVar);
            ListViewBinding.g(this.a, aVar, false);
            e.t.j.g.e0.F(this.f12471e, gVar);
        }
        if ((j2 & 8) != 0) {
            ListViewBinding.y(this.a, true);
            ListView listView = this.a;
            ListViewBinding.k(listView, listView.getResources().getString(R.string.common_no_more));
        }
        if (i2 != 0) {
            ListViewBinding.a(this.a, oVar, null, list, view, null, Integer.valueOf((int) R.layout.view_coin_empty), null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12472f != 0;
        }
    }

    @Override // e.l.k.c0
    public void i(@Nullable CoinActivity coinActivity) {
        this.b = coinActivity;
        synchronized (this) {
            this.f12472f |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12472f = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.c0
    public void j(@Nullable CoinViewModel coinViewModel) {
        this.f12382c = coinViewModel;
        synchronized (this) {
            this.f12472f |= 4;
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
            i((CoinActivity) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((CoinViewModel) obj);
        }
        return true;
    }

    private d0(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ListView) objArr[1]);
        this.f12472f = -1L;
        this.a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12470d = constraintLayout;
        constraintLayout.setTag(null);
        MaterialButton materialButton = (MaterialButton) objArr[2];
        this.f12471e = materialButton;
        materialButton.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
