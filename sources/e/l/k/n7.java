package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.eth.model.NLive;
import com.jihuanshe.R;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.model.Rarity;
import com.jihuanshe.ui.page.search.fragments.cardrepo.CardRepoSearchFragment;
import com.jihuanshe.ui.widget.RarityFilterBtn;
import com.jihuanshe.viewmodel.search.cardrepo.CardRepoSearchViewModel;
import com.vector.databinding.adapter.ListViewBinding;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class n7 extends m7 {
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13190h = null;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static final SparseIntArray f13191i;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final ConstraintLayout f13192f;

    /* renamed from: g  reason: collision with root package name */
    private long f13193g;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13191i = sparseIntArray;
        sparseIntArray.put(R.id.filter, 3);
    }

    public n7(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f13190h, f13191i));
    }

    private boolean k(NLive<List<GameCard>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13193g |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean l(e.n.f<List<Rarity>> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13193g |= 1;
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
        e.l.h.j.b.f.b bVar;
        e.t.j.h.l lVar2;
        LayoutManagers.a aVar;
        e.t.j.h.p pVar;
        e.l.g.j jVar;
        List<GameCard> list2;
        boolean z;
        LayoutManagers.a aVar2;
        e.t.j.h.p pVar2;
        List<GameCard> list3;
        e.l.g.j jVar2;
        synchronized (this) {
            j2 = this.f13193g;
            this.f13193g = 0L;
        }
        CardRepoSearchFragment cardRepoSearchFragment = this.f13119d;
        CardRepoSearchViewModel cardRepoSearchViewModel = this.f13120e;
        if ((31 & j2) != 0) {
            if ((j2 & 20) == 0 || cardRepoSearchFragment == null) {
                bVar = null;
                lVar2 = null;
                aVar2 = null;
                pVar2 = null;
            } else {
                bVar = cardRepoSearchFragment.n0();
                lVar2 = cardRepoSearchFragment.s0();
                aVar2 = cardRepoSearchFragment.o0();
                pVar2 = cardRepoSearchFragment.t0();
            }
            if ((j2 & 30) != 0) {
                jVar2 = cardRepoSearchFragment != null ? cardRepoSearchFragment.k0() : null;
                NLive<List<GameCard>> w0 = cardRepoSearchViewModel != null ? cardRepoSearchViewModel.w0() : null;
                updateLiveDataRegistration(1, w0);
                list3 = w0 != null ? w0.getValue() : null;
            } else {
                list3 = null;
                jVar2 = null;
            }
            if ((j2 & 29) != 0) {
                lVar = cardRepoSearchFragment != null ? cardRepoSearchFragment.r0() : null;
                e.n.f<List<Rarity>> z0 = cardRepoSearchViewModel != null ? cardRepoSearchViewModel.z0() : null;
                updateLiveDataRegistration(0, z0);
                if (z0 != null) {
                    list = z0.getValue();
                    list2 = list3;
                } else {
                    list2 = list3;
                    list = null;
                }
            } else {
                list2 = list3;
                lVar = null;
                list = null;
            }
            aVar = aVar2;
            pVar = pVar2;
            jVar = jVar2;
        } else {
            lVar = null;
            list = null;
            bVar = null;
            lVar2 = null;
            aVar = null;
            pVar = null;
            jVar = null;
            list2 = null;
        }
        if ((20 & j2) != 0) {
            ListViewBinding.c(this.b, bVar);
            ListViewBinding.m(this.b, pVar);
            ListViewBinding.l(this.b, lVar2, null, null);
            z = false;
            ListViewBinding.g(this.b, aVar, false);
        } else {
            z = false;
        }
        if ((16 & j2) != 0) {
            ListViewBinding.d(this.b, z);
            e.l.i.f0.j(this.b, 14, null);
        }
        if ((30 & j2) != 0) {
            ListViewBinding.a(this.b, jVar, null, list2, null, null, null, null);
        }
        if ((j2 & 29) != 0) {
            e.l.i.y.a(this.f13118c, lVar, list);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13193g != 0;
        }
    }

    @Override // e.l.k.m7
    public void i(@Nullable CardRepoSearchFragment cardRepoSearchFragment) {
        this.f13119d = cardRepoSearchFragment;
        synchronized (this) {
            this.f13193g |= 4;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13193g = 16L;
        }
        requestRebind();
    }

    @Override // e.l.k.m7
    public void j(@Nullable CardRepoSearchViewModel cardRepoSearchViewModel) {
        this.f13120e = cardRepoSearchViewModel;
        synchronized (this) {
            this.f13193g |= 8;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            if (i2 != 1) {
                return false;
            }
            return k((NLive) obj, i3);
        }
        return l((e.n.f) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((CardRepoSearchFragment) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((CardRepoSearchViewModel) obj);
        }
        return true;
    }

    private n7(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (FrameLayout) objArr[3], (ListView) objArr[2], (RarityFilterBtn) objArr[1]);
        this.f13193g = -1L;
        this.b.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13192f = constraintLayout;
        constraintLayout.setTag(null);
        this.f13118c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
