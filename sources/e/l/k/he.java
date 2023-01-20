package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.widget.FilterInfoPopupWindow;
import com.vector.databinding.adapter.ListViewBinding;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class he extends ge {
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12810g = null;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f12811h;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final ConstraintLayout f12812e;

    /* renamed from: f  reason: collision with root package name */
    private long f12813f;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f12811h = sparseIntArray;
        sparseIntArray.put(R.id.cl, 3);
    }

    public he(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f12810g, f12811h));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.t.j.h.g gVar;
        e.t.j.h.l lVar;
        LayoutManagers.a aVar;
        e.l.g.v vVar;
        List<e.l.s.a> list;
        synchronized (this) {
            j2 = this.f12813f;
            this.f12813f = 0L;
        }
        FilterInfoPopupWindow filterInfoPopupWindow = this.f12744d;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 == 0 || filterInfoPopupWindow == null) {
            gVar = null;
            lVar = null;
            aVar = null;
            vVar = null;
            list = null;
        } else {
            List<e.l.s.a> e2 = filterInfoPopupWindow.e();
            gVar = filterInfoPopupWindow.j();
            lVar = filterInfoPopupWindow.k();
            e.l.g.v c2 = filterInfoPopupWindow.c();
            aVar = filterInfoPopupWindow.f();
            list = e2;
            vVar = c2;
        }
        if (i2 != 0) {
            ListViewBinding.a(this.b, vVar, null, list, null, null, null, null);
            ListViewBinding.l(this.b, lVar, null, null);
            ListViewBinding.g(this.b, aVar, false);
            e.t.j.g.e0.F(this.f12743c, gVar);
        }
    }

    @Override // e.l.k.ge
    public void h(@Nullable FilterInfoPopupWindow filterInfoPopupWindow) {
        this.f12744d = filterInfoPopupWindow;
        synchronized (this) {
            this.f12813f |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12813f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12813f = 2L;
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
            h((FilterInfoPopupWindow) obj);
            return true;
        }
        return false;
    }

    private he(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[3], (ListView) objArr[2], (View) objArr[1]);
        this.f12813f = -1L;
        this.b.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12812e = constraintLayout;
        constraintLayout.setTag(null);
        this.f12743c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
