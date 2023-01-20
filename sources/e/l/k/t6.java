package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.jihuanshe.R;
import com.jihuanshe.base.ui.widget.SlideIndicatorView;
import com.jihuanshe.ui.page.search.fragments.global.GlobalSearchFragment;
import com.vector.view.pager.ViewPager;
import java.util.List;

/* loaded from: classes2.dex */
public class t6 extends s6 {
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13612h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static final SparseIntArray f13613i;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final ConstraintLayout f13614e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final og f13615f;

    /* renamed from: g  reason: collision with root package name */
    private long f13616g;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(4);
        f13612h = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"view_search_history"}, new int[]{3}, new int[]{R.layout.view_search_history});
        f13613i = null;
    }

    public t6(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f13612h, f13613i));
    }

    private boolean k(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13616g |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean l(e.n.p pVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13616g |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean m(e.n.f<List<CharSequence>> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13616g |= 2;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ae  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 448
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.t6.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f13616g != 0) {
                return true;
            }
            return this.f13615f.hasPendingBindings();
        }
    }

    @Override // e.l.k.s6
    public void i(@Nullable GlobalSearchFragment globalSearchFragment) {
        this.f13556c = globalSearchFragment;
        synchronized (this) {
            this.f13616g |= 8;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13616g = 32L;
        }
        this.f13615f.invalidateAll();
        requestRebind();
    }

    @Override // e.l.k.s6
    public void j(@Nullable e.l.s.m.d.b bVar) {
        this.f13557d = bVar;
        synchronized (this) {
            this.f13616g |= 16;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    return false;
                }
                return l((e.n.p) obj, i3);
            }
            return m((e.n.f) obj, i3);
        }
        return k((e.n.i) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f13615f.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((GlobalSearchFragment) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((e.l.s.m.d.b) obj);
        }
        return true;
    }

    private t6(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (SlideIndicatorView) objArr[1], (ViewPager) objArr[2]);
        this.f13616g = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13614e = constraintLayout;
        constraintLayout.setTag(null);
        og ogVar = (og) objArr[3];
        this.f13615f = ogVar;
        setContainedBinding(ogVar);
        this.a.setTag(null);
        this.b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
