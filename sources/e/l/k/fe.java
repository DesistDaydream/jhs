package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.widget.FilterPopupWindow;
import com.vector.databinding.adapter.ListViewBinding;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import java.util.List;
import kotlin.Pair;

/* loaded from: classes2.dex */
public class fe extends ee {
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12658g = null;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f12659h;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final ConstraintLayout f12660e;

    /* renamed from: f  reason: collision with root package name */
    private long f12661f;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f12659h = sparseIntArray;
        sparseIntArray.put(R.id.cl, 3);
    }

    public fe(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f12658g, f12659h));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.t.j.h.g gVar;
        e.t.j.h.l lVar;
        LayoutManagers.a aVar;
        e.l.g.u uVar;
        List<Pair<String, String>> list;
        synchronized (this) {
            j2 = this.f12661f;
            this.f12661f = 0L;
        }
        FilterPopupWindow filterPopupWindow = this.f12595d;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 == 0 || filterPopupWindow == null) {
            gVar = null;
            lVar = null;
            aVar = null;
            uVar = null;
            list = null;
        } else {
            List<Pair<String, String>> e2 = filterPopupWindow.e();
            gVar = filterPopupWindow.k();
            lVar = filterPopupWindow.l();
            e.l.g.u c2 = filterPopupWindow.c();
            aVar = filterPopupWindow.g();
            list = e2;
            uVar = c2;
        }
        if (i2 != 0) {
            ListViewBinding.a(this.b, uVar, null, list, null, null, null, null);
            ListViewBinding.l(this.b, lVar, null, null);
            ListViewBinding.g(this.b, aVar, false);
            e.t.j.g.e0.F(this.f12594c, gVar);
        }
    }

    @Override // e.l.k.ee
    public void h(@Nullable FilterPopupWindow filterPopupWindow) {
        this.f12595d = filterPopupWindow;
        synchronized (this) {
            this.f12661f |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12661f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12661f = 2L;
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
            h((FilterPopupWindow) obj);
            return true;
        }
        return false;
    }

    private fe(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[3], (ListView) objArr[2], (View) objArr[1]);
        this.f12661f = -1L;
        this.b.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12660e = constraintLayout;
        constraintLayout.setTag(null);
        this.f12594c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
