package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.search.SearchActivity;

/* loaded from: classes2.dex */
public class d2 extends c2 {
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12477k = null;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private static final SparseIntArray f12478l;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final CoordinatorLayout f12479h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final ConstraintLayout f12480i;

    /* renamed from: j  reason: collision with root package name */
    private long f12481j;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f12478l = sparseIntArray;
        sparseIntArray.put(R.id.cl_search, 6);
    }

    public d2(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f12477k, f12478l));
    }

    private boolean k(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12481j |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean l(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12481j |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean m(e.n.p pVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12481j |= 2;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x012e  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 425
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.d2.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12481j != 0;
        }
    }

    @Override // e.l.k.c2
    public void i(@Nullable SearchActivity searchActivity) {
        this.f12392f = searchActivity;
        synchronized (this) {
            this.f12481j |= 8;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12481j = 32L;
        }
        requestRebind();
    }

    @Override // e.l.k.c2
    public void j(@Nullable e.l.s.m.c cVar) {
        this.f12393g = cVar;
        synchronized (this) {
            this.f12481j |= 16;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    return false;
                }
                return k((e.n.i) obj, i3);
            }
            return m((e.n.p) obj, i3);
        }
        return l((e.n.i) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((SearchActivity) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((e.l.s.m.c) obj);
        }
        return true;
    }

    private d2(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (AppBarLayout) objArr[6], (EditText) objArr[2], (FrameLayout) objArr[5], (FrameLayout) objArr[3], (TextView) objArr[4]);
        this.f12481j = -1L;
        this.b.setTag(null);
        this.f12389c.setTag(null);
        this.f12390d.setTag(null);
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) objArr[0];
        this.f12479h = coordinatorLayout;
        coordinatorLayout.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[1];
        this.f12480i = constraintLayout;
        constraintLayout.setTag(null);
        this.f12391e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
