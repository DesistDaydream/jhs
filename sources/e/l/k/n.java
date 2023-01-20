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
import com.jihuanshe.adapter.BlackListAdapter;
import com.jihuanshe.model.BanUser;
import com.jihuanshe.ui.page.user.BlackListActivity;
import com.jihuanshe.viewmodel.user.BlackListViewModel;
import com.vector.databinding.adapter.ListViewBinding;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class n extends m {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13151f = null;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f13152g = null;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final FrameLayout f13153d;

    /* renamed from: e  reason: collision with root package name */
    private long f13154e;

    public n(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f13151f, f13152g));
    }

    private boolean k(NLive<List<BanUser>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13154e |= 1;
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
        BlackListAdapter blackListAdapter;
        List<BanUser> list;
        synchronized (this) {
            j2 = this.f13154e;
            this.f13154e = 0L;
        }
        BlackListActivity blackListActivity = this.b;
        BlackListViewModel blackListViewModel = this.f13096c;
        int i2 = ((15 & j2) > 0L ? 1 : ((15 & j2) == 0L ? 0 : -1));
        if (i2 != 0) {
            if ((j2 & 10) == 0 || blackListActivity == null) {
                bVar = null;
                lVar = null;
                aVar = null;
                pVar = null;
            } else {
                bVar = blackListActivity.X();
                lVar = blackListActivity.a0();
                aVar = blackListActivity.Y();
                pVar = blackListActivity.b0();
            }
            BlackListAdapter W = blackListActivity != null ? blackListActivity.W() : null;
            NLive<List<BanUser>> q0 = blackListViewModel != null ? blackListViewModel.q0() : null;
            updateLiveDataRegistration(0, q0);
            if (q0 != null) {
                blackListAdapter = W;
                list = q0.getValue();
            } else {
                blackListAdapter = W;
                list = null;
            }
        } else {
            bVar = null;
            lVar = null;
            aVar = null;
            pVar = null;
            blackListAdapter = null;
            list = null;
        }
        if ((j2 & 8) != 0) {
            ListViewBinding.y(this.a, true);
            ListViewBinding.d(this.a, false);
            ListView listView = this.a;
            ListViewBinding.k(listView, listView.getResources().getString(R.string.common_no_more));
        }
        if ((j2 & 10) != 0) {
            ListViewBinding.c(this.a, bVar);
            ListViewBinding.m(this.a, pVar);
            ListViewBinding.l(this.a, lVar, null, null);
            ListViewBinding.g(this.a, aVar, false);
        }
        if (i2 != 0) {
            ListViewBinding.a(this.a, blackListAdapter, null, list, null, null, null, null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13154e != 0;
        }
    }

    @Override // e.l.k.m
    public void i(@Nullable BlackListActivity blackListActivity) {
        this.b = blackListActivity;
        synchronized (this) {
            this.f13154e |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13154e = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.m
    public void j(@Nullable BlackListViewModel blackListViewModel) {
        this.f13096c = blackListViewModel;
        synchronized (this) {
            this.f13154e |= 4;
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
            i((BlackListActivity) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((BlackListViewModel) obj);
        }
        return true;
    }

    private n(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ListView) objArr[1]);
        this.f13154e = -1L;
        this.a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f13153d = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
