package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.jihuanshe.R;
import com.jihuanshe.binding.RecyclerViewBinding;
import com.jihuanshe.model.CardProductNew;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.ui.dialog.CardProductDialogFragment;
import com.jihuanshe.ui.widget.MaxHeightRecyclerView;
import com.jihuanshe.ui.widget.NumberView;
import com.vector.util.LayoutManagers;
import java.util.List;

/* loaded from: classes2.dex */
public class z4 extends y4 {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts o;
    @Nullable
    private static final SparseIntArray p;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final FrameLayout f14043j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final ConstraintLayout f14044k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private final TextView f14045l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    private final TextView f14046m;
    private long n;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(12);
        o = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"view_product_header"}, new int[]{7}, new int[]{R.layout.view_product_header});
        SparseIntArray sparseIntArray = new SparseIntArray();
        p = sparseIntArray;
        sparseIntArray.put(R.id.divider, 8);
        sparseIntArray.put(R.id.productTitle, 9);
        sparseIntArray.put(R.id.xingIv, 10);
        sparseIntArray.put(R.id.number, 11);
    }

    public z4(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 12, o, p));
    }

    private boolean i(gg ggVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.n |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean j(e.n.f<CardProductNew> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.n |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean k(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.n |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean l(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.n |= 8;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        long j3;
        e.t.j.h.g gVar;
        e.t.j.h.g gVar2;
        e.l.q.b.b.a.e eVar;
        CardProductNew cardProductNew;
        String str;
        Integer num;
        Integer num2;
        e.t.j.h.l lVar;
        e.t.j.h.g gVar3;
        e.l.g.o0 o0Var;
        List<GameCard> list;
        LayoutManagers.a aVar;
        e.l.h.j.b.f.b bVar;
        e.t.j.h.m mVar;
        e.l.h.j.b.f.b bVar2;
        e.l.g.o0 o0Var2;
        List<GameCard> list2;
        LayoutManagers.a aVar2;
        e.n.l lVar2;
        e.n.l lVar3;
        e.n.f<CardProductNew> fVar;
        synchronized (this) {
            j2 = this.n;
            this.n = 0L;
        }
        CardProductDialogFragment cardProductDialogFragment = this.f13956i;
        if ((62 & j2) != 0) {
            if ((j2 & 52) != 0) {
                if (cardProductDialogFragment != null) {
                    bVar2 = cardProductDialogFragment.H();
                    o0Var2 = cardProductDialogFragment.E();
                    fVar = cardProductDialogFragment.F();
                    aVar2 = cardProductDialogFragment.I();
                } else {
                    bVar2 = null;
                    o0Var2 = null;
                    fVar = null;
                    aVar2 = null;
                }
                updateLiveDataRegistration(2, fVar);
                cardProductNew = fVar != null ? fVar.getValue() : null;
                if (cardProductNew != null) {
                    str = cardProductNew.getCardVersionDefaultImage();
                    list2 = cardProductNew.getProducts();
                } else {
                    str = null;
                    list2 = null;
                }
            } else {
                bVar2 = null;
                o0Var2 = null;
                cardProductNew = null;
                str = null;
                list2 = null;
                aVar2 = null;
            }
            if ((j2 & 58) != 0) {
                if (cardProductDialogFragment != null) {
                    lVar3 = cardProductDialogFragment.G();
                    lVar2 = cardProductDialogFragment.J();
                } else {
                    lVar2 = null;
                    lVar3 = null;
                }
                updateLiveDataRegistration(1, lVar3);
                updateLiveDataRegistration(3, lVar2);
                num2 = lVar3 != null ? lVar3.getValue() : null;
                num = lVar2 != null ? lVar2.getValue() : null;
            } else {
                num = null;
                num2 = null;
            }
            if ((j2 & 48) == 0 || cardProductDialogFragment == null) {
                bVar = bVar2;
                o0Var = o0Var2;
                list = list2;
                aVar = aVar2;
                gVar = null;
                gVar2 = null;
                eVar = null;
                lVar = null;
                gVar3 = null;
                j3 = 58;
            } else {
                lVar = cardProductDialogFragment.M();
                e.t.j.h.g L = cardProductDialogFragment.L();
                e.t.j.h.g N = cardProductDialogFragment.N();
                e.l.q.b.b.a.e P = cardProductDialogFragment.P();
                gVar = cardProductDialogFragment.O();
                bVar = bVar2;
                o0Var = o0Var2;
                gVar2 = L;
                eVar = P;
                j3 = 58;
                list = list2;
                gVar3 = N;
                aVar = aVar2;
            }
        } else {
            j3 = 58;
            gVar = null;
            gVar2 = null;
            eVar = null;
            cardProductNew = null;
            str = null;
            num = null;
            num2 = null;
            lVar = null;
            gVar3 = null;
            o0Var = null;
            list = null;
            aVar = null;
            bVar = null;
        }
        if ((j2 & j3) != 0) {
            mVar = null;
            e.l.i.s.a(this.a, num2, num, null, Boolean.FALSE);
        } else {
            mVar = null;
        }
        if ((48 & j2) != 0) {
            e.t.j.g.e0.F(this.b, gVar2);
            this.f13951d.k(eVar);
            RecyclerViewBinding.f(this.f13952e, lVar, mVar);
            e.t.j.g.e0.F(this.f14045l, gVar);
            e.t.j.g.e0.F(this.f14046m, gVar3);
        }
        if ((52 & j2) != 0) {
            this.f13951d.j(str);
            this.f13951d.l(cardProductNew);
            RecyclerViewBinding.b(this.f13952e, o0Var, list, aVar, null, null, null, bVar);
        }
        if ((j2 & 32) != 0) {
            RecyclerViewBinding.e(this.f13952e, null);
        }
        ViewDataBinding.executeBindingsOn(this.f13951d);
    }

    @Override // e.l.k.y4
    public void h(@Nullable CardProductDialogFragment cardProductDialogFragment) {
        this.f13956i = cardProductDialogFragment;
        synchronized (this) {
            this.n |= 16;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.n != 0) {
                return true;
            }
            return this.f13951d.hasPendingBindings();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.n = 32L;
        }
        this.f13951d.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return false;
                    }
                    return l((e.n.l) obj, i3);
                }
                return j((e.n.f) obj, i3);
            }
            return k((e.n.l) obj, i3);
        }
        return i((gg) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f13951d.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            h((CardProductDialogFragment) obj);
            return true;
        }
        return false;
    }

    private z4(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (NumberView) objArr[5], (ImageView) objArr[2], (View) objArr[8], (gg) objArr[7], (MaxHeightRecyclerView) objArr[4], (TextView) objArr[11], (TextView) objArr[9], (TextView) objArr[10]);
        this.n = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        setContainedBinding(this.f13951d);
        this.f13952e.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f14043j = frameLayout;
        frameLayout.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[1];
        this.f14044k = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.f14045l = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[6];
        this.f14046m = textView2;
        textView2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
