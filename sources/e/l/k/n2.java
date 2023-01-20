package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentContainerView;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.user.selling.SellingActivity;

/* loaded from: classes2.dex */
public class n2 extends m2 {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13170f = null;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f13171g;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final FrameLayout f13172d;

    /* renamed from: e  reason: collision with root package name */
    private long f13173e;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13171g = sparseIntArray;
        sparseIntArray.put(R.id.container, 1);
    }

    public n2(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f13170f, f13171g));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f13173e = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13173e != 0;
        }
    }

    @Override // e.l.k.m2
    public void i(@Nullable SellingActivity sellingActivity) {
        this.b = sellingActivity;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13173e = 4L;
        }
        requestRebind();
    }

    @Override // e.l.k.m2
    public void j(@Nullable e.l.s.o.d.a aVar) {
        this.f13102c = aVar;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((SellingActivity) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((e.l.s.o.d.a) obj);
        }
        return true;
    }

    private n2(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FragmentContainerView) objArr[1]);
        this.f13173e = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f13172d = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
