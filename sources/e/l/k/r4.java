package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.jihuanshe.R;
import com.jihuanshe.model.CardProductNew;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.ui.dialog.EditProductDialog;

/* loaded from: classes2.dex */
public class r4 extends q4 {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts r;
    @Nullable
    private static final SparseIntArray s;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private final FrameLayout f13456l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    private final ConstraintLayout f13457m;
    @NonNull
    private final TextView n;
    @NonNull
    private final ImageView o;
    @NonNull
    private final ConstraintLayout p;
    private long q;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(15);
        r = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"view_product_header"}, new int[]{8}, new int[]{R.layout.view_product_header});
        includedLayouts.setIncludes(4, new String[]{"view_condition_change", "view_product_info_edit"}, new int[]{9, 10}, new int[]{R.layout.view_condition_change, R.layout.view_product_info_edit});
        SparseIntArray sparseIntArray = new SparseIntArray();
        s = sparseIntArray;
        sparseIntArray.put(R.id.divider0, 11);
        sparseIntArray.put(R.id.divider5, 12);
        sparseIntArray.put(R.id.ll, 13);
        sparseIntArray.put(R.id.ll2, 14);
    }

    public r4(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 15, r, s));
    }

    private boolean i(af afVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.q |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean j(gg ggVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.q |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean k(e.n.f<CardProductNew> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.q |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean l(e.n.f<GameCard> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.q |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean m(e.n.f<e.l.q.b.b.a.d> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.q |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean n(ig igVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.q |= 32;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x015e  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 376
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.r4.executeBindings():void");
    }

    @Override // e.l.k.q4
    public void h(@Nullable EditProductDialog editProductDialog) {
        this.f13423k = editProductDialog;
        synchronized (this) {
            this.q |= 64;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.q != 0) {
                return true;
            }
            return this.f13417e.hasPendingBindings() || this.a.hasPendingBindings() || this.f13420h.hasPendingBindings();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.q = 128L;
        }
        this.f13417e.invalidateAll();
        this.a.invalidateAll();
        this.f13420h.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 != 5) {
                                return false;
                            }
                            return n((ig) obj, i3);
                        }
                        return l((e.n.f) obj, i3);
                    }
                    return m((e.n.f) obj, i3);
                }
                return i((af) obj, i3);
            }
            return k((e.n.f) obj, i3);
        }
        return j((gg) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f13417e.setLifecycleOwner(lifecycleOwner);
        this.a.setLifecycleOwner(lifecycleOwner);
        this.f13420h.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            h((EditProductDialog) obj);
            return true;
        }
        return false;
    }

    private r4(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (af) objArr[9], (SwitchMaterial) objArr[6], (View) objArr[11], (View) objArr[12], (gg) objArr[8], (LinearLayout) objArr[13], (LinearLayout) objArr[14], (ig) objArr[10], (SwitchMaterial) objArr[5], (TextView) objArr[7]);
        this.q = -1L;
        setContainedBinding(this.a);
        this.b.setTag(null);
        setContainedBinding(this.f13417e);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f13456l = frameLayout;
        frameLayout.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[1];
        this.f13457m = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.n = textView;
        textView.setTag(null);
        ImageView imageView = (ImageView) objArr[3];
        this.o = imageView;
        imageView.setTag(null);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) objArr[4];
        this.p = constraintLayout2;
        constraintLayout2.setTag(null);
        setContainedBinding(this.f13420h);
        this.f13421i.setTag(null);
        this.f13422j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
