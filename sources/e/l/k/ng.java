package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.ui.page.search.SearchActivity;
import com.vector.databinding.adapter.EditTextBinding;

/* loaded from: classes2.dex */
public class ng extends mg {
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13225e = null;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f13226f = null;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final LinearLayout f13227c;

    /* renamed from: d  reason: collision with root package name */
    private long f13228d;

    public ng(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f13225e, f13226f));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.t.j.h.h0 h0Var;
        e.t.j.h.i iVar;
        e.t.j.h.h hVar;
        synchronized (this) {
            j2 = this.f13228d;
            this.f13228d = 0L;
        }
        SearchActivity searchActivity = this.b;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 == 0 || searchActivity == null) {
            h0Var = null;
            iVar = null;
            hVar = null;
        } else {
            h0Var = searchActivity.g0();
            iVar = searchActivity.f0();
            hVar = searchActivity.e0();
        }
        if (i2 != 0) {
            EditTextBinding.c(this.a, hVar);
            e.t.j.g.e0.B(this.a, iVar);
            EditTextBinding.g(this.a, null, h0Var, null);
        }
    }

    @Override // e.l.k.mg
    public void h(@Nullable SearchActivity searchActivity) {
        this.b = searchActivity;
        synchronized (this) {
            this.f13228d |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13228d != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13228d = 2L;
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
            h((SearchActivity) obj);
            return true;
        }
        return false;
    }

    private ng(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (EditText) objArr[1]);
        this.f13228d = -1L;
        this.a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f13227c = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
