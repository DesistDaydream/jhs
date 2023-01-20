package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.ui.dialog.UseDialog;

/* loaded from: classes2.dex */
public class h4 extends g4 {
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12770h = null;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static final SparseIntArray f12771i = null;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final ConstraintLayout f12772f;

    /* renamed from: g  reason: collision with root package name */
    private long f12773g;

    public h4(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f12770h, f12771i));
    }

    private boolean i(e.n.p pVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12773g |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean j(e.n.p pVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12773g |= 32;
            }
            return true;
        }
        return false;
    }

    private boolean k(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12773g |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean l(e.n.p pVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12773g |= 64;
            }
            return true;
        }
        return false;
    }

    private boolean m(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12773g |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean n(e.n.p pVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12773g |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean o(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12773g |= 16;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0130  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 448
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.h4.executeBindings():void");
    }

    @Override // e.l.k.g4
    public void h(@Nullable UseDialog useDialog) {
        this.f12710e = useDialog;
        synchronized (this) {
            this.f12773g |= 128;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12773g != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12773g = 256L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return i((e.n.p) obj, i3);
            case 1:
                return k((e.n.i) obj, i3);
            case 2:
                return m((e.n.i) obj, i3);
            case 3:
                return n((e.n.p) obj, i3);
            case 4:
                return o((e.n.i) obj, i3);
            case 5:
                return j((e.n.p) obj, i3);
            case 6:
                return l((e.n.p) obj, i3);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            h((UseDialog) obj);
            return true;
        }
        return false;
    }

    private h4(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 7, (TextView) objArr[2], (TextView) objArr[3], (TextView) objArr[4], (TextView) objArr[1]);
        this.f12773g = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        this.f12708c.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12772f = constraintLayout;
        constraintLayout.setTag(null);
        this.f12709d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
