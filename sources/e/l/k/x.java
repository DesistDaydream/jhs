package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.eth.model.NLive;
import com.jihuanshe.R;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.model.Rarity;
import com.jihuanshe.ui.page.shop.ChooseCardActivity;
import com.jihuanshe.ui.widget.RarityFilterBtn;
import com.jihuanshe.viewmodel.shop.ChooseCardViewModel;
import com.vector.databinding.adapter.EditTextBinding;
import com.vector.databinding.adapter.ListViewBinding;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class x extends w {
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13880k = null;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private static final SparseIntArray f13881l;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final ConstraintLayout f13882g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final TextView f13883h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final RarityFilterBtn f13884i;

    /* renamed from: j  reason: collision with root package name */
    private long f13885j;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13881l = sparseIntArray;
        sparseIntArray.put(R.id.searchView, 5);
        sparseIntArray.put(R.id.filterBar, 6);
    }

    public x(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f13880k, f13881l));
    }

    private boolean k(NLive<List<GameCard>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13885j |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean l(e.n.f<List<Rarity>> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13885j |= 1;
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
        e.t.j.h.h hVar;
        e.t.j.h.g gVar;
        LayoutManagers.a aVar;
        e.t.j.h.p pVar;
        e.l.g.j jVar;
        List<GameCard> list2;
        LayoutManagers.a aVar2;
        e.t.j.h.p pVar2;
        e.t.j.h.h hVar2;
        e.t.j.h.g gVar2;
        List<GameCard> list3;
        e.l.g.j jVar2;
        synchronized (this) {
            j2 = this.f13885j;
            this.f13885j = 0L;
        }
        ChooseCardActivity chooseCardActivity = this.f13792e;
        ChooseCardViewModel chooseCardViewModel = this.f13793f;
        if ((31 & j2) != 0) {
            if ((j2 & 20) == 0 || chooseCardActivity == null) {
                bVar = null;
                lVar2 = null;
                aVar2 = null;
                pVar2 = null;
                hVar2 = null;
                gVar2 = null;
            } else {
                bVar = chooseCardActivity.b0();
                lVar2 = chooseCardActivity.j0();
                aVar2 = chooseCardActivity.e0();
                pVar2 = chooseCardActivity.k0();
                hVar2 = chooseCardActivity.h0();
                gVar2 = chooseCardActivity.g0();
            }
            if ((j2 & 30) != 0) {
                jVar2 = chooseCardActivity != null ? chooseCardActivity.Y() : null;
                NLive<List<GameCard>> G0 = chooseCardViewModel != null ? chooseCardViewModel.G0() : null;
                updateLiveDataRegistration(1, G0);
                list3 = G0 != null ? G0.getValue() : null;
            } else {
                list3 = null;
                jVar2 = null;
            }
            if ((j2 & 29) != 0) {
                lVar = chooseCardActivity != null ? chooseCardActivity.i0() : null;
                e.n.f<List<Rarity>> J0 = chooseCardViewModel != null ? chooseCardViewModel.J0() : null;
                updateLiveDataRegistration(0, J0);
                if (J0 != null) {
                    list = J0.getValue();
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
            hVar = hVar2;
            gVar = gVar2;
            jVar = jVar2;
        } else {
            lVar = null;
            list = null;
            bVar = null;
            lVar2 = null;
            hVar = null;
            gVar = null;
            aVar = null;
            pVar = null;
            jVar = null;
            list2 = null;
        }
        if ((20 & j2) != 0) {
            ListViewBinding.c(this.b, bVar);
            ListViewBinding.m(this.b, pVar);
            ListViewBinding.l(this.b, lVar2, null, null);
            ListViewBinding.g(this.b, aVar, false);
            e.t.j.g.e0.F(this.f13883h, gVar);
            EditTextBinding.c(this.f13790c, hVar);
        }
        if ((16 & j2) != 0) {
            ListViewBinding.d(this.b, false);
        }
        if ((30 & j2) != 0) {
            ListViewBinding.a(this.b, jVar, null, list2, null, null, null, null);
        }
        if ((j2 & 29) != 0) {
            e.l.i.y.a(this.f13884i, lVar, list);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13885j != 0;
        }
    }

    @Override // e.l.k.w
    public void i(@Nullable ChooseCardActivity chooseCardActivity) {
        this.f13792e = chooseCardActivity;
        synchronized (this) {
            this.f13885j |= 4;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13885j = 16L;
        }
        requestRebind();
    }

    @Override // e.l.k.w
    public void j(@Nullable ChooseCardViewModel chooseCardViewModel) {
        this.f13793f = chooseCardViewModel;
        synchronized (this) {
            this.f13885j |= 8;
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
            i((ChooseCardActivity) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((ChooseCardViewModel) obj);
        }
        return true;
    }

    private x(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (ConstraintLayout) objArr[6], (ListView) objArr[4], (EditText) objArr[1], (LinearLayout) objArr[5]);
        this.f13885j = -1L;
        this.b.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13882g = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f13883h = textView;
        textView.setTag(null);
        RarityFilterBtn rarityFilterBtn = (RarityFilterBtn) objArr[3];
        this.f13884i = rarityFilterBtn;
        rarityFilterBtn.setTag(null);
        this.f13790c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
