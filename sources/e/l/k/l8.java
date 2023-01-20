package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.ui.page.main.shop.ShopFragment;
import com.jihuanshe.viewmodel.main.shop.ShopViewModel;

/* loaded from: classes2.dex */
public class l8 extends k8 {
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13063e = null;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f13064f = null;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final CoordinatorLayout f13065c;

    /* renamed from: d  reason: collision with root package name */
    private long f13066d;

    public l8(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f13063e, f13064f));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f13066d = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13066d != 0;
        }
    }

    @Override // e.l.k.k8
    public void i(@Nullable ShopFragment shopFragment) {
        this.a = shopFragment;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13066d = 4L;
        }
        requestRebind();
    }

    @Override // e.l.k.k8
    public void j(@Nullable ShopViewModel shopViewModel) {
        this.b = shopViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((ShopFragment) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((ShopViewModel) obj);
        }
        return true;
    }

    private l8(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f13066d = -1L;
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) objArr[0];
        this.f13065c = coordinatorLayout;
        coordinatorLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
