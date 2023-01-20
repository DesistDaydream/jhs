package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.SearchUser;
import com.jihuanshe.ui.page.search.fragments.global.SearchUserFragment;
import com.jihuanshe.viewmodel.search.globals.SearchUserViewModel;
import com.vector.databinding.adapter.ListViewBinding;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class b8 extends a8 {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12347f = null;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f12348g = null;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final FrameLayout f12349d;

    /* renamed from: e  reason: collision with root package name */
    private long f12350e;

    public b8(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f12347f, f12348g));
    }

    private boolean k(e.n.f<List<SearchUser>> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12350e |= 1;
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
        e.l.g.c1.b bVar2;
        List<SearchUser> list;
        synchronized (this) {
            j2 = this.f12350e;
            this.f12350e = 0L;
        }
        SearchUserFragment searchUserFragment = this.b;
        SearchUserViewModel searchUserViewModel = this.f12274c;
        int i2 = ((15 & j2) > 0L ? 1 : ((15 & j2) == 0L ? 0 : -1));
        if (i2 != 0) {
            if ((j2 & 10) == 0 || searchUserFragment == null) {
                bVar = null;
                lVar = null;
                aVar = null;
                pVar = null;
            } else {
                bVar = searchUserFragment.h0();
                lVar = searchUserFragment.k0();
                aVar = searchUserFragment.i0();
                pVar = searchUserFragment.l0();
            }
            e.l.g.c1.b g0 = searchUserFragment != null ? searchUserFragment.g0() : null;
            e.n.f<List<SearchUser>> q0 = searchUserViewModel != null ? searchUserViewModel.q0() : null;
            updateLiveDataRegistration(0, q0);
            if (q0 != null) {
                bVar2 = g0;
                list = q0.getValue();
            } else {
                bVar2 = g0;
                list = null;
            }
        } else {
            bVar = null;
            lVar = null;
            aVar = null;
            pVar = null;
            bVar2 = null;
            list = null;
        }
        if ((j2 & 8) != 0) {
            ListViewBinding.e(this.a, null);
            e.l.i.f0.j(this.a, 12, null);
        }
        if ((j2 & 10) != 0) {
            ListViewBinding.c(this.a, bVar);
            ListViewBinding.m(this.a, pVar);
            ListViewBinding.l(this.a, lVar, null, null);
            ListViewBinding.g(this.a, aVar, false);
        }
        if (i2 != 0) {
            ListViewBinding.a(this.a, bVar2, null, list, null, null, Integer.valueOf((int) R.layout.view_common_empty), null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12350e != 0;
        }
    }

    @Override // e.l.k.a8
    public void i(@Nullable SearchUserFragment searchUserFragment) {
        this.b = searchUserFragment;
        synchronized (this) {
            this.f12350e |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12350e = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.a8
    public void j(@Nullable SearchUserViewModel searchUserViewModel) {
        this.f12274c = searchUserViewModel;
        synchronized (this) {
            this.f12350e |= 4;
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
            i((SearchUserFragment) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((SearchUserViewModel) obj);
        }
        return true;
    }

    private b8(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ListView) objArr[1]);
        this.f12350e = -1L;
        this.a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f12349d = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
