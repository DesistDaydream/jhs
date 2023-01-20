package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.base.ui.widget.SlideIndicatorView;
import com.jihuanshe.ui.page.entrepot.SearchMyStorehouseFragment;
import com.vector.view.pager.ViewPager;

/* loaded from: classes2.dex */
public class v7 extends u7 {
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13752h = null;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static final SparseIntArray f13753i = null;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final ConstraintLayout f13754f;

    /* renamed from: g  reason: collision with root package name */
    private long f13755g;

    public v7(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f13752h, f13753i));
    }

    private boolean k(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13755g |= 1;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.v7.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13755g != 0;
        }
    }

    @Override // e.l.k.u7
    public void i(@Nullable SearchMyStorehouseFragment searchMyStorehouseFragment) {
        this.f13703d = searchMyStorehouseFragment;
        synchronized (this) {
            this.f13755g |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13755g = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.u7
    public void j(@Nullable e.l.s.h.b bVar) {
        this.f13704e = bVar;
        synchronized (this) {
            this.f13755g |= 4;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return k((e.n.i) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((SearchMyStorehouseFragment) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((e.l.s.h.b) obj);
        }
        return true;
    }

    private v7(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (LinearLayout) objArr[1], (SlideIndicatorView) objArr[2], (ViewPager) objArr[3]);
        this.f13755g = -1L;
        this.a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13754f = constraintLayout;
        constraintLayout.setTag(null);
        this.b.setTag(null);
        this.f13702c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
