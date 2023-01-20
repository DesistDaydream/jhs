package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.ui.dialog.PermissionDescDialog;

/* loaded from: classes2.dex */
public class j5 extends i5 {
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12931i = null;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static final SparseIntArray f12932j = null;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final ConstraintLayout f12933g;

    /* renamed from: h  reason: collision with root package name */
    private long f12934h;

    public j5(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f12931i, f12932j));
    }

    private boolean i(e.n.p pVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12934h |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean j(e.n.p pVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12934h |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean k(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12934h |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean l(e.n.p pVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12934h |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean m(e.n.p pVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12934h |= 16;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.j5.executeBindings():void");
    }

    @Override // e.l.k.i5
    public void h(@Nullable PermissionDescDialog permissionDescDialog) {
        this.f12860f = permissionDescDialog;
        synchronized (this) {
            this.f12934h |= 32;
        }
        notifyPropertyChanged(4);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12934h != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12934h = 64L;
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
                        return m((e.n.p) obj, i3);
                    }
                    return k((e.n.l) obj, i3);
                }
                return i((e.n.p) obj, i3);
            }
            return j((e.n.p) obj, i3);
        }
        return l((e.n.p) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (4 == i2) {
            h((PermissionDescDialog) obj);
            return true;
        }
        return false;
    }

    private j5(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (ImageView) objArr[2], (TextView) objArr[1], (TextView) objArr[5], (TextView) objArr[3], (TextView) objArr[4]);
        this.f12934h = -1L;
        this.a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12933g = constraintLayout;
        constraintLayout.setTag(null);
        this.b.setTag(null);
        this.f12857c.setTag(null);
        this.f12858d.setTag(null);
        this.f12859e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
