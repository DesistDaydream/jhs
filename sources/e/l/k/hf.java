package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.Rarity;
import com.jihuanshe.ui.page.main.shop.ShopFragment;
import com.jihuanshe.ui.widget.FilterTextView;
import com.jihuanshe.ui.widget.RarityFilterBtn;
import com.jihuanshe.viewmodel.main.shop.ShopViewModel;
import java.util.List;
import kotlin.Pair;

/* loaded from: classes2.dex */
public class hf extends gf {
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12814m = null;
    @Nullable
    private static final SparseIntArray n;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final ConstraintLayout f12815i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final LinearLayout f12816j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final LinearLayout f12817k;

    /* renamed from: l  reason: collision with root package name */
    private long f12818l;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        n = sparseIntArray;
        sparseIntArray.put(R.id.llBar, 7);
    }

    public hf(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f12814m, n));
    }

    private boolean m(e.n.f<List<Pair<String, String>>> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12818l |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean n(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12818l |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean o(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12818l |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean p(e.n.f<List<Rarity>> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12818l |= 2;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:139:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0135  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 582
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.hf.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12818l != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12818l = 128L;
        }
        requestRebind();
    }

    @Override // e.l.k.gf
    public void j(@Nullable e.l.s.c cVar) {
        this.f12750h = cVar;
        synchronized (this) {
            this.f12818l |= 32;
        }
        notifyPropertyChanged(6);
        super.requestRebind();
    }

    @Override // e.l.k.gf
    public void k(@Nullable ShopFragment shopFragment) {
        this.f12748f = shopFragment;
        synchronized (this) {
            this.f12818l |= 16;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // e.l.k.gf
    public void l(@Nullable ShopViewModel shopViewModel) {
        this.f12749g = shopViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return false;
                    }
                    return n((e.n.i) obj, i3);
                }
                return m((e.n.f) obj, i3);
            }
            return p((e.n.f) obj, i3);
        }
        return o((e.n.l) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            k((ShopFragment) obj);
        } else if (6 == i2) {
            j((e.l.s.c) obj);
        } else if (21 != i2) {
            return false;
        } else {
            l((ShopViewModel) obj);
        }
        return true;
    }

    private hf(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (TextView) objArr[4], (FilterTextView) objArr[5], (LinearLayout) objArr[7], (RarityFilterBtn) objArr[6], (TextView) objArr[3]);
        this.f12818l = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12815i = constraintLayout;
        constraintLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[1];
        this.f12816j = linearLayout;
        linearLayout.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[2];
        this.f12817k = linearLayout2;
        linearLayout2.setTag(null);
        this.f12746d.setTag(null);
        this.f12747e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
