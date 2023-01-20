package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.user.CloseAccountActivity;

/* loaded from: classes2.dex */
public class b0 extends a0 {
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12314j = null;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private static final SparseIntArray f12315k;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final ConstraintLayout f12316d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final TextView f12317e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final TextView f12318f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final FrameLayout f12319g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final TextView f12320h;

    /* renamed from: i  reason: collision with root package name */
    private long f12321i;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f12315k = sparseIntArray;
        sparseIntArray.put(R.id.regularTv, 6);
    }

    public b0(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f12314j, f12315k));
    }

    private boolean i(e.n.p pVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12321i |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean j(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12321i |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean k(e.n.p pVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12321i |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean l(e.n.p pVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12321i |= 8;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0071 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009d  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.b0.executeBindings():void");
    }

    @Override // e.l.k.a0
    public void h(@Nullable CloseAccountActivity closeAccountActivity) {
        this.f12244c = closeAccountActivity;
        synchronized (this) {
            this.f12321i |= 16;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12321i != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12321i = 32L;
        }
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
                    return l((e.n.p) obj, i3);
                }
                return i((e.n.p) obj, i3);
            }
            return j((e.n.i) obj, i3);
        }
        return k((e.n.p) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            h((CloseAccountActivity) obj);
            return true;
        }
        return false;
    }

    private b0(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (TextView) objArr[3], (TextView) objArr[6]);
        this.f12321i = -1L;
        this.a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12316d = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f12317e = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.f12318f = textView2;
        textView2.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[4];
        this.f12319g = frameLayout;
        frameLayout.setTag(null);
        TextView textView3 = (TextView) objArr[5];
        this.f12320h = textView3;
        textView3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
