package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.ui.dialog.HomeWantSellDialog;

/* loaded from: classes2.dex */
public class b5 extends a5 {
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12339g = null;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f12340h = null;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final ConstraintLayout f12341e;

    /* renamed from: f  reason: collision with root package name */
    private long f12342f;

    public b5(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f12339g, f12340h));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.t.j.h.g gVar;
        e.t.j.h.g gVar2;
        synchronized (this) {
            j2 = this.f12342f;
            this.f12342f = 0L;
        }
        HomeWantSellDialog homeWantSellDialog = this.f12261d;
        e.t.j.h.g gVar3 = null;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 == 0 || homeWantSellDialog == null) {
            gVar = null;
            gVar2 = null;
        } else {
            gVar3 = homeWantSellDialog.getOnClickClose();
            gVar = homeWantSellDialog.getOnClickSell();
            gVar2 = homeWantSellDialog.getOnClickHouse();
        }
        if (i2 != 0) {
            e.t.j.g.e0.F(this.a, gVar3);
            e.t.j.g.e0.F(this.b, gVar);
            e.t.j.g.e0.F(this.f12260c, gVar2);
        }
    }

    @Override // e.l.k.a5
    public void h(@Nullable HomeWantSellDialog homeWantSellDialog) {
        this.f12261d = homeWantSellDialog;
        synchronized (this) {
            this.f12342f |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12342f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12342f = 2L;
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
            h((HomeWantSellDialog) obj);
            return true;
        }
        return false;
    }

    private b5(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (LinearLayout) objArr[2], (LinearLayout) objArr[3]);
        this.f12342f = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12341e = constraintLayout;
        constraintLayout.setTag(null);
        this.f12260c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
