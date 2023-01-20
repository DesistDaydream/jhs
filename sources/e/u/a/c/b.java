package e.u.a.c;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.xres.address_selector.R;
import com.xres.address_selector.widget.SideBar;

/* loaded from: classes3.dex */
public class b extends a {
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f14722e = null;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f14723f;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final ConstraintLayout f14724c;

    /* renamed from: d  reason: collision with root package name */
    private long f14725d;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f14723f = sparseIntArray;
        sparseIntArray.put(R.id.rvAddress, 1);
        sparseIntArray.put(R.id.mySideBar, 2);
    }

    public b(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f14722e, f14723f));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f14725d = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14725d != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14725d = 1L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        return true;
    }

    private b(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (SideBar) objArr[2], (RecyclerView) objArr[1]);
        this.f14725d = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f14724c = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
