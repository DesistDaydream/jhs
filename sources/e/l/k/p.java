package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.view.PreviewView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.camera.CaptureActivity;
import com.yalantis.ucrop.view.MOverlayView;

/* loaded from: classes2.dex */
public class p extends o {
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13283g = null;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f13284h;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final ConstraintLayout f13285e;

    /* renamed from: f  reason: collision with root package name */
    private long f13286f;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13284h = sparseIntArray;
        sparseIntArray.put(R.id.previewView, 2);
        sparseIntArray.put(R.id.overlayView, 3);
    }

    public p(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f13283g, f13284h));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.f13286f;
            this.f13286f = 0L;
        }
        CaptureActivity captureActivity = this.f13230d;
        e.t.j.h.g gVar = null;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 != 0 && captureActivity != null) {
            gVar = captureActivity.b0();
        }
        if (i2 != 0) {
            e.t.j.g.e0.F(this.f13229c, gVar);
        }
    }

    @Override // e.l.k.o
    public void h(@Nullable CaptureActivity captureActivity) {
        this.f13230d = captureActivity;
        synchronized (this) {
            this.f13286f |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13286f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13286f = 2L;
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
            h((CaptureActivity) obj);
            return true;
        }
        return false;
    }

    private p(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (MOverlayView) objArr[3], (PreviewView) objArr[2], (ImageView) objArr[1]);
        this.f13286f = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13285e = constraintLayout;
        constraintLayout.setTag(null);
        this.f13229c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
