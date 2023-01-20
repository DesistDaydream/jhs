package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.ui.dialog.MediationDialog;

/* loaded from: classes2.dex */
public class b7 extends a7 {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12343f = null;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f12344g = null;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final FrameLayout f12345d;

    /* renamed from: e  reason: collision with root package name */
    private long f12346e;

    public b7(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f12343f, f12344g));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.t.j.h.g gVar;
        synchronized (this) {
            j2 = this.f12346e;
            this.f12346e = 0L;
        }
        MediationDialog mediationDialog = this.f12273c;
        e.t.j.h.g gVar2 = null;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 == 0 || mediationDialog == null) {
            gVar = null;
        } else {
            gVar2 = mediationDialog.C();
            gVar = mediationDialog.D();
        }
        if (i2 != 0) {
            e.t.j.g.e0.F(this.a, gVar2);
            e.t.j.g.e0.F(this.b, gVar);
        }
    }

    @Override // e.l.k.a7
    public void h(@Nullable MediationDialog mediationDialog) {
        this.f12273c = mediationDialog;
        synchronized (this) {
            this.f12346e |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12346e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12346e = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            h((MediationDialog) obj);
            return true;
        }
        return false;
    }

    private b7(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[1], (TextView) objArr[2]);
        this.f12346e = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f12345d = frameLayout;
        frameLayout.setTag(null);
        this.a.setTag(null);
        this.b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
