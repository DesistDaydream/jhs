package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.jihuanshe.R;
import com.jihuanshe.base.ui.widget.SlideIndicatorView;
import com.jihuanshe.model.Rarity;
import com.jihuanshe.ui.page.user.selling.SellingFragment;
import com.jihuanshe.ui.widget.FilterTextView;
import com.jihuanshe.ui.widget.RarityFilterBtn;
import com.vector.view.pager.ViewPager;
import java.util.List;

/* loaded from: classes2.dex */
public class h8 extends g8 {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts n;
    @Nullable
    private static final SparseIntArray o;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final ConstraintLayout f12783j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private final og f12784k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private final SlideIndicatorView f12785l;

    /* renamed from: m  reason: collision with root package name */
    private long f12786m;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(10);
        n = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"view_search_history"}, new int[]{7}, new int[]{R.layout.view_search_history});
        SparseIntArray sparseIntArray = new SparseIntArray();
        o = sparseIntArray;
        sparseIntArray.put(R.id.filterBar, 8);
        sparseIntArray.put(R.id.divider, 9);
    }

    public h8(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, n, o));
    }

    private boolean k(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12786m |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean l(e.n.p pVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12786m |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean m(e.n.f<List<Rarity>> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12786m |= 2;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x017f  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 710
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.h8.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f12786m != 0) {
                return true;
            }
            return this.f12784k.hasPendingBindings();
        }
    }

    @Override // e.l.k.g8
    public void i(@Nullable SellingFragment sellingFragment) {
        this.f12731h = sellingFragment;
        synchronized (this) {
            this.f12786m |= 8;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12786m = 32L;
        }
        this.f12784k.invalidateAll();
        requestRebind();
    }

    @Override // e.l.k.g8
    public void j(@Nullable e.l.s.o.d.a aVar) {
        this.f12732i = aVar;
        synchronized (this) {
            this.f12786m |= 16;
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
                return k((e.n.i) obj, i3);
            }
            return m((e.n.f) obj, i3);
        }
        return l((e.n.p) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f12784k.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((SellingFragment) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((e.l.s.o.d.a) obj);
        }
        return true;
    }

    private h8(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (View) objArr[9], (FrameLayout) objArr[8], (FilterTextView) objArr[4], (SlideIndicatorView) objArr[1], (View) objArr[6], (RarityFilterBtn) objArr[3], (ViewPager) objArr[5]);
        this.f12786m = -1L;
        this.f12726c.setTag(null);
        this.f12727d.setTag(null);
        this.f12728e.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12783j = constraintLayout;
        constraintLayout.setTag(null);
        og ogVar = (og) objArr[7];
        this.f12784k = ogVar;
        setContainedBinding(ogVar);
        SlideIndicatorView slideIndicatorView = (SlideIndicatorView) objArr[2];
        this.f12785l = slideIndicatorView;
        slideIndicatorView.setTag(null);
        this.f12729f.setTag(null);
        this.f12730g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
