package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.adapter.LikeAdapter;
import com.jihuanshe.model.InteractData;
import com.jihuanshe.ui.page.im.LikeFragment;
import com.jihuanshe.viewmodel.im.LikeViewModel;
import com.vector.databinding.adapter.ListViewBinding;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class x6 extends w6 {
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13900e = null;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f13901f = null;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final ListView f13902c;

    /* renamed from: d  reason: collision with root package name */
    private long f13903d;

    public x6(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f13900e, f13901f));
    }

    private boolean k(e.n.f<List<InteractData>> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13903d |= 1;
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
        LikeAdapter likeAdapter;
        List<InteractData> list;
        synchronized (this) {
            j2 = this.f13903d;
            this.f13903d = 0L;
        }
        LikeFragment likeFragment = this.a;
        LikeViewModel likeViewModel = this.b;
        int i2 = ((15 & j2) > 0L ? 1 : ((15 & j2) == 0L ? 0 : -1));
        if (i2 != 0) {
            if ((j2 & 10) == 0 || likeFragment == null) {
                bVar = null;
                lVar = null;
                aVar = null;
                pVar = null;
            } else {
                bVar = likeFragment.f0();
                lVar = likeFragment.h0();
                aVar = likeFragment.g0();
                pVar = likeFragment.i0();
            }
            LikeAdapter e0 = likeFragment != null ? likeFragment.e0() : null;
            e.n.f<List<InteractData>> s0 = likeViewModel != null ? likeViewModel.s0() : null;
            updateLiveDataRegistration(0, s0);
            if (s0 != null) {
                likeAdapter = e0;
                list = s0.getValue();
            } else {
                likeAdapter = e0;
                list = null;
            }
        } else {
            bVar = null;
            lVar = null;
            aVar = null;
            pVar = null;
            likeAdapter = null;
            list = null;
        }
        if ((j2 & 10) != 0) {
            ListViewBinding.c(this.f13902c, bVar);
            ListViewBinding.m(this.f13902c, pVar);
            ListViewBinding.l(this.f13902c, lVar, null, null);
            ListViewBinding.g(this.f13902c, aVar, false);
        }
        if (i2 != 0) {
            ListViewBinding.a(this.f13902c, likeAdapter, null, list, null, null, null, null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13903d != 0;
        }
    }

    @Override // e.l.k.w6
    public void i(@Nullable LikeFragment likeFragment) {
        this.a = likeFragment;
        synchronized (this) {
            this.f13903d |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13903d = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.w6
    public void j(@Nullable LikeViewModel likeViewModel) {
        this.b = likeViewModel;
        synchronized (this) {
            this.f13903d |= 4;
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
            i((LikeFragment) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((LikeViewModel) obj);
        }
        return true;
    }

    private x6(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1);
        this.f13903d = -1L;
        ListView listView = (ListView) objArr[0];
        this.f13902c = listView;
        listView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
