package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.TipDialog;

/* loaded from: classes2.dex */
public class z5 extends y5 {
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f14047g = null;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f14048h;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final ConstraintLayout f14049e;

    /* renamed from: f  reason: collision with root package name */
    private long f14050f;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f14048h = sparseIntArray;
        sparseIntArray.put(R.id.view2, 3);
    }

    public z5(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f14047g, f14048h));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        String str;
        synchronized (this) {
            j2 = this.f14050f;
            this.f14050f = 0L;
        }
        TipDialog tipDialog = this.f13958d;
        e.t.j.h.g gVar = null;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 == 0 || tipDialog == null) {
            str = null;
        } else {
            String content = tipDialog.getContent();
            gVar = tipDialog.getOnClickCancel();
            str = content;
        }
        if (i2 != 0) {
            e.t.j.g.e0.F(this.a, gVar);
            TextViewBindingAdapter.setText(this.b, str);
        }
    }

    @Override // e.l.k.y5
    public void h(@Nullable TipDialog tipDialog) {
        this.f13958d = tipDialog;
        synchronized (this) {
            this.f14050f |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14050f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14050f = 2L;
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
            h((TipDialog) obj);
            return true;
        }
        return false;
    }

    private z5(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[2], (TextView) objArr[1], (View) objArr[3]);
        this.f14050f = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f14049e = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
