package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.ui.widget.ReviewPopupWindow;

/* loaded from: classes2.dex */
public class te extends se {
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13648e = null;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f13649f = null;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final LinearLayout f13650c;

    /* renamed from: d  reason: collision with root package name */
    private long f13651d;

    public te(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f13648e, f13649f));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.f13651d;
            this.f13651d = 0L;
        }
        ReviewPopupWindow reviewPopupWindow = this.b;
        e.t.j.h.g gVar = null;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 != 0 && reviewPopupWindow != null) {
            gVar = reviewPopupWindow.c();
        }
        if (i2 != 0) {
            e.t.j.g.e0.F(this.a, gVar);
        }
    }

    @Override // e.l.k.se
    public void h(@Nullable ReviewPopupWindow reviewPopupWindow) {
        this.b = reviewPopupWindow;
        synchronized (this) {
            this.f13651d |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13651d != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13651d = 2L;
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
            h((ReviewPopupWindow) obj);
            return true;
        }
        return false;
    }

    private te(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[1]);
        this.f13651d = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f13650c = linearLayout;
        linearLayout.setTag(null);
        this.a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
