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
import com.jihuanshe.model.ExpressData;

/* loaded from: classes2.dex */
public class ja extends ia {
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12948g = null;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f12949h;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final ConstraintLayout f12950e;

    /* renamed from: f  reason: collision with root package name */
    private long f12951f;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f12949h = sparseIntArray;
        sparseIntArray.put(R.id.dotView, 3);
    }

    public ja(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f12948g, f12949h));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        String str;
        synchronized (this) {
            j2 = this.f12951f;
            this.f12951f = 0L;
        }
        ExpressData expressData = this.f12880d;
        String str2 = null;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 == 0 || expressData == null) {
            str = null;
        } else {
            str2 = expressData.getTime();
            str = expressData.getSection();
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.b, str2);
            TextViewBindingAdapter.setText(this.f12879c, str);
        }
    }

    @Override // e.l.k.ia
    public void h(@Nullable ExpressData expressData) {
        this.f12880d = expressData;
        synchronized (this) {
            this.f12951f |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12951f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12951f = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (8 == i2) {
            h((ExpressData) obj);
            return true;
        }
        return false;
    }

    private ja(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (View) objArr[3], (TextView) objArr[1], (TextView) objArr[2]);
        this.f12951f = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12950e = constraintLayout;
        constraintLayout.setTag(null);
        this.b.setTag(null);
        this.f12879c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
