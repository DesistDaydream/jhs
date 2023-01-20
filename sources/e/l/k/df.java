package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.model.Rarity;
import com.jihuanshe.ui.page.detail.CardPackListActivity;
import com.jihuanshe.ui.widget.FilterTextView;
import com.jihuanshe.ui.widget.RarityFilterBtn;
import com.jihuanshe.viewmodel.detail.CardPackListViewModel;
import java.util.List;
import kotlin.Pair;

/* loaded from: classes2.dex */
public class df extends cf {
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12520g = null;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f12521h = null;

    /* renamed from: f  reason: collision with root package name */
    private long f12522f;

    public df(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f12520g, f12521h));
    }

    private boolean k(e.n.f<List<Pair<String, String>>> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12522f |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean l(e.n.f<List<Rarity>> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12522f |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        h.k2.u.l<List<Rarity>, h.t1> lVar;
        List<Rarity> list;
        h.k2.u.l<Pair<String, String>, h.t1> lVar2;
        h.k2.u.l<Boolean, h.t1> lVar3;
        List<Pair<String, String>> list2;
        synchronized (this) {
            j2 = this.f12522f;
            this.f12522f = 0L;
        }
        CardPackListActivity cardPackListActivity = this.f12456d;
        CardPackListViewModel cardPackListViewModel = this.f12457e;
        if ((31 & j2) != 0) {
            if ((j2 & 30) != 0) {
                if (cardPackListActivity != null) {
                    lVar2 = cardPackListActivity.Y();
                    lVar3 = cardPackListActivity.m0();
                } else {
                    lVar2 = null;
                    lVar3 = null;
                }
                e.n.f<List<Pair<String, String>>> G = cardPackListViewModel != null ? cardPackListViewModel.G() : null;
                updateLiveDataRegistration(1, G);
                list2 = G != null ? G.getValue() : null;
            } else {
                lVar2 = null;
                lVar3 = null;
                list2 = null;
            }
            if ((j2 & 29) != 0) {
                lVar = cardPackListActivity != null ? cardPackListActivity.i0() : null;
                e.n.f<List<Rarity>> i2 = cardPackListViewModel != null ? cardPackListViewModel.i() : null;
                updateLiveDataRegistration(0, i2);
                list = i2 != null ? i2.getValue() : null;
            } else {
                lVar = null;
                list = null;
            }
            r13 = list2;
        } else {
            lVar = null;
            list = null;
            lVar2 = null;
            lVar3 = null;
        }
        if ((30 & j2) != 0) {
            e.l.i.l.a(this.a, r13, lVar2, lVar3);
        }
        if ((j2 & 29) != 0) {
            e.l.i.y.a(this.f12455c, lVar, list);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12522f != 0;
        }
    }

    @Override // e.l.k.cf
    public void i(@Nullable CardPackListViewModel cardPackListViewModel) {
        this.f12457e = cardPackListViewModel;
        synchronized (this) {
            this.f12522f |= 8;
        }
        notifyPropertyChanged(6);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12522f = 16L;
        }
        requestRebind();
    }

    @Override // e.l.k.cf
    public void j(@Nullable CardPackListActivity cardPackListActivity) {
        this.f12456d = cardPackListActivity;
        synchronized (this) {
            this.f12522f |= 4;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            if (i2 != 1) {
                return false;
            }
            return k((e.n.f) obj, i3);
        }
        return l((e.n.f) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            j((CardPackListActivity) obj);
        } else if (6 != i2) {
            return false;
        } else {
            i((CardPackListViewModel) obj);
        }
        return true;
    }

    private df(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (FilterTextView) objArr[1], (LinearLayout) objArr[0], (RarityFilterBtn) objArr[2]);
        this.f12522f = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        this.f12455c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
