package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.model.Rarity;
import com.jihuanshe.ui.widget.FilterInfoBtn;
import com.jihuanshe.ui.widget.RarityFilterBtn;
import com.jihuanshe.viewmodel.user.SellerDetailViewModel;
import com.vector.databinding.adapter.TextViewBinding;
import java.util.List;

/* loaded from: classes2.dex */
public class jf extends Cif {
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12962i = null;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static final SparseIntArray f12963j = null;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final LinearLayout f12964g;

    /* renamed from: h  reason: collision with root package name */
    private long f12965h;

    public jf(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f12962i, f12963j));
    }

    private boolean i(e.n.f<List<e.l.s.a>> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12965h |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean j(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12965h |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean k(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12965h |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean l(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12965h |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean m(e.n.f<List<Rarity>> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12965h |= 2;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.t.j.h.g gVar;
        Integer num;
        h.k2.u.l<e.l.s.a, h.t1> lVar;
        h.k2.u.l<List<Rarity>, h.t1> lVar2;
        List<e.l.s.a> list;
        e.t.j.h.g gVar2;
        List<Rarity> list2;
        int i2;
        int i3;
        boolean z;
        boolean z2;
        int i4;
        Integer num2;
        h.k2.u.l<e.l.s.a, h.t1> lVar3;
        e.t.j.h.g gVar3;
        List<Rarity> list3;
        h.k2.u.l<List<Rarity>, h.t1> lVar4;
        long j3;
        int i5;
        e.n.f<List<Rarity>> fVar;
        e.n.l lVar5;
        e.n.f<List<e.l.s.a>> fVar2;
        synchronized (this) {
            j2 = this.f12965h;
            this.f12965h = 0L;
        }
        SellerDetailViewModel sellerDetailViewModel = this.f12902f;
        if ((127 & j2) != 0) {
            if ((j2 & 113) != 0) {
                if (sellerDetailViewModel != null) {
                    lVar5 = sellerDetailViewModel.f();
                    lVar3 = sellerDetailViewModel.p();
                    fVar2 = sellerDetailViewModel.K();
                } else {
                    lVar5 = null;
                    lVar3 = null;
                    fVar2 = null;
                }
                updateLiveDataRegistration(0, lVar5);
                updateLiveDataRegistration(4, fVar2);
                num2 = lVar5 != null ? lVar5.getValue() : null;
                list = fVar2 != null ? fVar2.getValue() : null;
            } else {
                num2 = null;
                lVar3 = null;
                list = null;
            }
            if ((j2 & 96) == 0 || sellerDetailViewModel == null) {
                gVar2 = null;
                gVar3 = null;
            } else {
                gVar2 = sellerDetailViewModel.D0(1);
                gVar3 = sellerDetailViewModel.D0(0);
            }
            if ((j2 & 98) != 0) {
                if (sellerDetailViewModel != null) {
                    lVar4 = sellerDetailViewModel.i0();
                    fVar = sellerDetailViewModel.H();
                } else {
                    fVar = null;
                    lVar4 = null;
                }
                updateLiveDataRegistration(1, fVar);
                list3 = fVar != null ? fVar.getValue() : null;
            } else {
                list3 = null;
                lVar4 = null;
            }
            int i6 = ((j2 & 100) > 0L ? 1 : ((j2 & 100) == 0L ? 0 : -1));
            if (i6 != 0) {
                e.n.l M0 = sellerDetailViewModel != null ? sellerDetailViewModel.M0() : null;
                updateLiveDataRegistration(2, M0);
                int safeUnbox = ViewDataBinding.safeUnbox(M0 != null ? M0.getValue() : null);
                z2 = safeUnbox == 0;
                z = safeUnbox != 0;
                if (i6 != 0) {
                    j2 |= z2 ? 4096L : 2048L;
                }
                if ((j2 & 100) != 0) {
                    j2 |= z ? 1024L : 512L;
                }
                i4 = z2 ? 14 : 13;
                i5 = z ? 14 : 13;
                j3 = 104;
            } else {
                z = false;
                z2 = false;
                j3 = 104;
                i5 = 0;
                i4 = 0;
            }
            int i7 = ((j2 & j3) > 0L ? 1 : ((j2 & j3) == 0L ? 0 : -1));
            if (i7 != 0) {
                e.n.i b1 = sellerDetailViewModel != null ? sellerDetailViewModel.b1() : null;
                updateLiveDataRegistration(3, b1);
                boolean safeUnbox2 = ViewDataBinding.safeUnbox(b1 != null ? b1.getValue() : null);
                if (i7 != 0) {
                    j2 |= safeUnbox2 ? 256L : 128L;
                }
                i2 = safeUnbox2 ? 8 : 0;
                lVar = lVar3;
                list2 = list3;
                lVar2 = lVar4;
                i3 = i5;
            } else {
                lVar = lVar3;
                list2 = list3;
                lVar2 = lVar4;
                i3 = i5;
                i2 = 0;
            }
            num = num2;
            gVar = gVar3;
        } else {
            gVar = null;
            num = null;
            lVar = null;
            lVar2 = null;
            list = null;
            gVar2 = null;
            list2 = null;
            i2 = 0;
            i3 = 0;
            z = false;
            z2 = false;
            i4 = 0;
        }
        if ((j2 & 64) != 0) {
            TextViewBinding.a(this.a, true);
            TextViewBinding.a(this.f12901e, true);
        }
        if ((j2 & 100) != 0) {
            TextViewBinding.l(this.a, Integer.valueOf(i3));
            e.t.j.g.e0.K(this.a, z);
            TextViewBinding.l(this.f12901e, Integer.valueOf(i4));
            e.t.j.g.e0.K(this.f12901e, z2);
        }
        if ((96 & j2) != 0) {
            e.t.j.g.e0.F(this.a, gVar2);
            e.t.j.g.e0.F(this.f12901e, gVar);
        }
        if ((113 & j2) != 0) {
            e.l.i.l.c(this.b, list, num, lVar);
        }
        if ((104 & j2) != 0) {
            this.f12964g.setVisibility(i2);
        }
        if ((j2 & 98) != 0) {
            e.l.i.y.a(this.f12900d, lVar2, list2);
        }
    }

    @Override // e.l.k.Cif
    public void h(@Nullable SellerDetailViewModel sellerDetailViewModel) {
        this.f12902f = sellerDetailViewModel;
        synchronized (this) {
            this.f12965h |= 32;
        }
        notifyPropertyChanged(6);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12965h != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12965h = 64L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            return false;
                        }
                        return i((e.n.f) obj, i3);
                    }
                    return k((e.n.i) obj, i3);
                }
                return l((e.n.l) obj, i3);
            }
            return m((e.n.f) obj, i3);
        }
        return j((e.n.l) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (6 == i2) {
            h((SellerDetailViewModel) obj);
            return true;
        }
        return false;
    }

    private jf(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (TextView) objArr[3], (FilterInfoBtn) objArr[4], (LinearLayout) objArr[0], (RarityFilterBtn) objArr[5], (TextView) objArr[2]);
        this.f12965h = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        this.f12899c.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[1];
        this.f12964g = linearLayout;
        linearLayout.setTag(null);
        this.f12900d.setTag(null);
        this.f12901e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
