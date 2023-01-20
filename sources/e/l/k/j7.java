package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.RecentPhoto;
import com.jihuanshe.ui.page.photo.RecentPhotoFragment;
import com.jihuanshe.viewmodel.photo.RecentPhotoViewModel;
import com.vector.databinding.adapter.ListViewBinding;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class j7 extends i7 {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12939f = null;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f12940g = null;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final FrameLayout f12941d;

    /* renamed from: e  reason: collision with root package name */
    private long f12942e;

    public j7(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f12939f, f12940g));
    }

    private boolean k(e.n.f<List<RecentPhoto>> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12942e |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.l.h.j.b.f.a aVar;
        e.t.j.h.l lVar;
        LayoutManagers.a aVar2;
        e.t.j.h.p pVar;
        e.l.g.n0 n0Var;
        List<RecentPhoto> list;
        synchronized (this) {
            j2 = this.f12942e;
            this.f12942e = 0L;
        }
        RecentPhotoFragment recentPhotoFragment = this.b;
        RecentPhotoViewModel recentPhotoViewModel = this.f12861c;
        int i2 = ((15 & j2) > 0L ? 1 : ((15 & j2) == 0L ? 0 : -1));
        if (i2 != 0) {
            if ((j2 & 10) == 0 || recentPhotoFragment == null) {
                aVar = null;
                lVar = null;
                aVar2 = null;
                pVar = null;
            } else {
                aVar = recentPhotoFragment.f0();
                lVar = recentPhotoFragment.i0();
                aVar2 = recentPhotoFragment.h0();
                pVar = recentPhotoFragment.j0();
            }
            e.l.g.n0 e0 = recentPhotoFragment != null ? recentPhotoFragment.e0() : null;
            e.n.f<List<RecentPhoto>> q0 = recentPhotoViewModel != null ? recentPhotoViewModel.q0() : null;
            updateLiveDataRegistration(0, q0);
            if (q0 != null) {
                n0Var = e0;
                list = q0.getValue();
            } else {
                n0Var = e0;
                list = null;
            }
        } else {
            aVar = null;
            lVar = null;
            aVar2 = null;
            pVar = null;
            n0Var = null;
            list = null;
        }
        if ((10 & j2) != 0) {
            ListViewBinding.c(this.a, aVar);
            ListViewBinding.m(this.a, pVar);
            ListViewBinding.l(this.a, lVar, null, null);
            ListViewBinding.g(this.a, aVar2, false);
        }
        if (i2 != 0) {
            ListViewBinding.a(this.a, n0Var, null, list, null, null, Integer.valueOf((int) R.layout.view_common_empty), null);
        }
        if ((j2 & 8) != 0) {
            e.l.i.f0.j(this.a, 12, null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12942e != 0;
        }
    }

    @Override // e.l.k.i7
    public void i(@Nullable RecentPhotoFragment recentPhotoFragment) {
        this.b = recentPhotoFragment;
        synchronized (this) {
            this.f12942e |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12942e = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.i7
    public void j(@Nullable RecentPhotoViewModel recentPhotoViewModel) {
        this.f12861c = recentPhotoViewModel;
        synchronized (this) {
            this.f12942e |= 4;
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
            i((RecentPhotoFragment) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((RecentPhotoViewModel) obj);
        }
        return true;
    }

    private j7(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ListView) objArr[1]);
        this.f12942e = -1L;
        this.a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f12941d = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
