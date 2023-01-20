package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.adapter.AtMeAdapter;
import com.jihuanshe.model.InteractData;
import com.jihuanshe.ui.page.im.AtMeFragment;
import com.jihuanshe.viewmodel.im.AtMeViewModel;
import com.vector.databinding.adapter.ListViewBinding;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class j6 extends i6 {
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12935e = null;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f12936f = null;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final ListView f12937c;

    /* renamed from: d  reason: collision with root package name */
    private long f12938d;

    public j6(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f12935e, f12936f));
    }

    private boolean k(e.n.f<List<InteractData>> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12938d |= 1;
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
        AtMeAdapter atMeAdapter;
        List<InteractData> list;
        synchronized (this) {
            j2 = this.f12938d;
            this.f12938d = 0L;
        }
        AtMeFragment atMeFragment = this.a;
        AtMeViewModel atMeViewModel = this.b;
        int i2 = ((15 & j2) > 0L ? 1 : ((15 & j2) == 0L ? 0 : -1));
        if (i2 != 0) {
            if ((j2 & 10) == 0 || atMeFragment == null) {
                bVar = null;
                lVar = null;
                aVar = null;
                pVar = null;
            } else {
                bVar = atMeFragment.f0();
                lVar = atMeFragment.i0();
                aVar = atMeFragment.g0();
                pVar = atMeFragment.h0();
            }
            AtMeAdapter e0 = atMeFragment != null ? atMeFragment.e0() : null;
            e.n.f<List<InteractData>> s0 = atMeViewModel != null ? atMeViewModel.s0() : null;
            updateLiveDataRegistration(0, s0);
            if (s0 != null) {
                atMeAdapter = e0;
                list = s0.getValue();
            } else {
                atMeAdapter = e0;
                list = null;
            }
        } else {
            bVar = null;
            lVar = null;
            aVar = null;
            pVar = null;
            atMeAdapter = null;
            list = null;
        }
        if ((j2 & 10) != 0) {
            ListViewBinding.c(this.f12937c, bVar);
            ListViewBinding.m(this.f12937c, pVar);
            ListViewBinding.l(this.f12937c, lVar, null, null);
            ListViewBinding.g(this.f12937c, aVar, false);
        }
        if (i2 != 0) {
            ListViewBinding.a(this.f12937c, atMeAdapter, null, list, null, null, null, null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12938d != 0;
        }
    }

    @Override // e.l.k.i6
    public void i(@Nullable AtMeFragment atMeFragment) {
        this.a = atMeFragment;
        synchronized (this) {
            this.f12938d |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12938d = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.i6
    public void j(@Nullable AtMeViewModel atMeViewModel) {
        this.b = atMeViewModel;
        synchronized (this) {
            this.f12938d |= 4;
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
            i((AtMeFragment) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((AtMeViewModel) obj);
        }
        return true;
    }

    private j6(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1);
        this.f12938d = -1L;
        ListView listView = (ListView) objArr[0];
        this.f12937c = listView;
        listView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
