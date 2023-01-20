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
import com.jihuanshe.model.User;
import com.jihuanshe.ui.page.user.FansActivity;
import com.jihuanshe.viewmodel.user.FansViewModel;
import com.vector.databinding.adapter.ListViewBinding;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class v0 extends u0 {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13727f = null;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f13728g = null;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final FrameLayout f13729d;

    /* renamed from: e  reason: collision with root package name */
    private long f13730e;

    public v0(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f13727f, f13728g));
    }

    private boolean k(NLive<List<User>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13730e |= 1;
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
        e.l.g.w wVar;
        List<User> list;
        synchronized (this) {
            j2 = this.f13730e;
            this.f13730e = 0L;
        }
        FansActivity fansActivity = this.b;
        FansViewModel fansViewModel = this.f13664c;
        int i2 = ((15 & j2) > 0L ? 1 : ((15 & j2) == 0L ? 0 : -1));
        if (i2 != 0) {
            if ((j2 & 10) == 0 || fansActivity == null) {
                bVar = null;
                lVar = null;
                aVar = null;
                pVar = null;
            } else {
                bVar = fansActivity.Y();
                lVar = fansActivity.b0();
                aVar = fansActivity.Z();
                pVar = fansActivity.c0();
            }
            e.l.g.w X = fansActivity != null ? fansActivity.X() : null;
            NLive<List<User>> r0 = fansViewModel != null ? fansViewModel.r0() : null;
            updateLiveDataRegistration(0, r0);
            if (r0 != null) {
                wVar = X;
                list = r0.getValue();
            } else {
                wVar = X;
                list = null;
            }
        } else {
            bVar = null;
            lVar = null;
            aVar = null;
            pVar = null;
            wVar = null;
            list = null;
        }
        if ((j2 & 8) != 0) {
            ListViewBinding.y(this.a, true);
            ListViewBinding.d(this.a, false);
            ListView listView = this.a;
            ListViewBinding.k(listView, listView.getResources().getString(R.string.common_no_more));
            e.l.i.f0.j(this.a, 12, null);
        }
        if ((j2 & 10) != 0) {
            ListViewBinding.c(this.a, bVar);
            ListViewBinding.m(this.a, pVar);
            ListViewBinding.l(this.a, lVar, null, null);
            ListViewBinding.g(this.a, aVar, false);
        }
        if (i2 != 0) {
            ListViewBinding.a(this.a, wVar, null, list, null, null, null, null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13730e != 0;
        }
    }

    @Override // e.l.k.u0
    public void i(@Nullable FansActivity fansActivity) {
        this.b = fansActivity;
        synchronized (this) {
            this.f13730e |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13730e = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.u0
    public void j(@Nullable FansViewModel fansViewModel) {
        this.f13664c = fansViewModel;
        synchronized (this) {
            this.f13730e |= 4;
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
            i((FansActivity) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((FansViewModel) obj);
        }
        return true;
    }

    private v0(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ListView) objArr[1]);
        this.f13730e = -1L;
        this.a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f13729d = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
