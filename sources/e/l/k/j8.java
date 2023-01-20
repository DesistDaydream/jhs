package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.eth.model.NLive;
import com.jihuanshe.R;
import com.jihuanshe.model.Category;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.ui.page.main.shop.ShopFragment;
import com.jihuanshe.ui.widget.CPHorizontalScrollView;
import com.jihuanshe.ui.widget.CustomShopIndicatorView;
import com.jihuanshe.viewmodel.main.shop.ShopViewModel;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class j8 extends i8 {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts o;
    @Nullable
    private static final SparseIntArray p;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final ConstraintLayout f12943k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private final gf f12944l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    private final ConstraintLayout f12945m;
    private long n;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(11);
        o = includedLayouts;
        includedLayouts.setIncludes(2, new String[]{"view_filter_bar_shop_home"}, new int[]{6}, new int[]{R.layout.view_filter_bar_shop_home});
        SparseIntArray sparseIntArray = new SparseIntArray();
        p = sparseIntArray;
        sparseIntArray.put(R.id.ll_scrollView, 7);
        sparseIntArray.put(R.id.ll_left, 8);
        sparseIntArray.put(R.id.ll_center, 9);
        sparseIntArray.put(R.id.ll_right, 10);
    }

    public j8(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, o, p));
    }

    private boolean k(NLive<List<Category>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.n |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean l(NLive<Category> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.n |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean m(NLive<List<GameCard>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.n |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean n(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.n |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean o(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.n |= 8;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x013c  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 591
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.j8.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.n != 0) {
                return true;
            }
            return this.f12944l.hasPendingBindings();
        }
    }

    @Override // e.l.k.i8
    public void i(@Nullable ShopFragment shopFragment) {
        this.f12868i = shopFragment;
        synchronized (this) {
            this.n |= 32;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.n = 128L;
        }
        this.f12944l.invalidateAll();
        requestRebind();
    }

    @Override // e.l.k.i8
    public void j(@Nullable ShopViewModel shopViewModel) {
        this.f12869j = shopViewModel;
        synchronized (this) {
            this.n |= 64;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
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
                        return n((e.n.i) obj, i3);
                    }
                    return o((e.n.l) obj, i3);
                }
                return k((NLive) obj, i3);
            }
            return l((NLive) obj, i3);
        }
        return m((NLive) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f12944l.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((ShopFragment) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((ShopViewModel) obj);
        }
        return true;
    }

    private j8(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (CPHorizontalScrollView) objArr[4], (CustomShopIndicatorView) objArr[5], (ListView) objArr[1], (LinearLayout) objArr[9], (LinearLayout) objArr[8], (LinearLayout) objArr[2], (LinearLayout) objArr[10], (LinearLayout) objArr[7]);
        this.n = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        this.f12862c.setTag(null);
        this.f12865f.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12943k = constraintLayout;
        constraintLayout.setTag(null);
        gf gfVar = (gf) objArr[6];
        this.f12944l = gfVar;
        setContainedBinding(gfVar);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) objArr[3];
        this.f12945m = constraintLayout2;
        constraintLayout2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
