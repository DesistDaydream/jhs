package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.jihuanshe.R;
import com.jihuanshe.model.CardProductNew;
import com.jihuanshe.ui.page.shop.AddProductActivity;
import com.jihuanshe.ui.widget.MaxHeightRecyclerView;

/* loaded from: classes2.dex */
public class j extends i {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts o;
    @Nullable
    private static final SparseIntArray p;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private final ConstraintLayout f12914l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    private final ConstraintLayout f12915m;
    private long n;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(11);
        o = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"view_product_header"}, new int[]{6}, new int[]{R.layout.view_product_header});
        includedLayouts.setIncludes(1, new String[]{"view_condition_change", "view_product_info_edit"}, new int[]{7, 8}, new int[]{R.layout.view_condition_change, R.layout.view_product_info_edit});
        SparseIntArray sparseIntArray = new SparseIntArray();
        p = sparseIntArray;
        sparseIntArray.put(R.id.divider2, 9);
        sparseIntArray.put(R.id.divider3, 10);
    }

    public j(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, o, p));
    }

    private boolean k(af afVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.n |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean l(gg ggVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.n |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean m(ig igVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.n |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean n(e.n.f<CardProductNew> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.n |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean o(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.n |= 8;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e5  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 349
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.j.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.n != 0) {
                return true;
            }
            return this.f12822e.hasPendingBindings() || this.a.hasPendingBindings() || this.f12823f.hasPendingBindings();
        }
    }

    @Override // e.l.k.i
    public void i(@Nullable AddProductActivity addProductActivity) {
        this.f12827j = addProductActivity;
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
        this.f12822e.invalidateAll();
        this.a.invalidateAll();
        this.f12823f.invalidateAll();
        requestRebind();
    }

    @Override // e.l.k.i
    public void j(@Nullable e.l.s.n.a aVar) {
        this.f12828k = aVar;
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
                        return m((ig) obj, i3);
                    }
                    return o((e.n.i) obj, i3);
                }
                return n((e.n.f) obj, i3);
            }
            return k((af) obj, i3);
        }
        return l((gg) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f12822e.setLifecycleOwner(lifecycleOwner);
        this.a.setLifecycleOwner(lifecycleOwner);
        this.f12823f.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((AddProductActivity) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((e.l.s.n.a) obj);
        }
        return true;
    }

    private j(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (af) objArr[7], (View) objArr[2], (View) objArr[9], (View) objArr[10], (gg) objArr[6], (ig) objArr[8], (MaxHeightRecyclerView) objArr[4], (TextView) objArr[3], (TextView) objArr[5]);
        this.n = -1L;
        setContainedBinding(this.a);
        this.b.setTag(null);
        setContainedBinding(this.f12822e);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12914l = constraintLayout;
        constraintLayout.setTag(null);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) objArr[1];
        this.f12915m = constraintLayout2;
        constraintLayout2.setTag(null);
        setContainedBinding(this.f12823f);
        this.f12824g.setTag(null);
        this.f12825h.setTag(null);
        this.f12826i.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
