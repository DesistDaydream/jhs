package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.base.ui.widget.SlideIndicatorView;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.Product;
import com.jihuanshe.ui.page.shop.SellCalendarActivity;
import com.jihuanshe.ui.widget.GameFilterBtn;
import com.jihuanshe.viewmodel.shop.SellCalendarViewModel;
import com.vector.view.pager.ViewPager;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class f2 extends e2 {
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12614m = null;
    @Nullable
    private static final SparseIntArray n;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final ConstraintLayout f12615h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final View f12616i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final ImageView f12617j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final GameFilterBtn f12618k;

    /* renamed from: l  reason: collision with root package name */
    private long f12619l;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        n = sparseIntArray;
        sparseIntArray.put(R.id.topView, 7);
        sparseIntArray.put(R.id.titleBar, 8);
    }

    public f2(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, f12614m, n));
    }

    private boolean k(e.n.f<List<Product>> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12619l |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean l(e.n.f<List<Game>> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12619l |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean m(e.n.f<e.t.k.a.c.h.c> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12619l |= 2;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fe  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 504
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.f2.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12619l != 0;
        }
    }

    @Override // e.l.k.e2
    public void i(@Nullable SellCalendarActivity sellCalendarActivity) {
        this.f12551f = sellCalendarActivity;
        synchronized (this) {
            this.f12619l |= 8;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12619l = 32L;
        }
        requestRebind();
    }

    @Override // e.l.k.e2
    public void j(@Nullable SellCalendarViewModel sellCalendarViewModel) {
        this.f12552g = sellCalendarViewModel;
        synchronized (this) {
            this.f12619l |= 16;
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
                return l((e.n.f) obj, i3);
            }
            return m((e.n.f) obj, i3);
        }
        return k((e.n.f) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((SellCalendarActivity) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((SellCalendarViewModel) obj);
        }
        return true;
    }

    private f2(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (SlideIndicatorView) objArr[3], (ListView) objArr[6], (FrameLayout) objArr[8], (LinearLayout) objArr[7], (ViewPager) objArr[5]);
        this.f12619l = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12615h = constraintLayout;
        constraintLayout.setTag(null);
        View view2 = (View) objArr[1];
        this.f12616i = view2;
        view2.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.f12617j = imageView;
        imageView.setTag(null);
        GameFilterBtn gameFilterBtn = (GameFilterBtn) objArr[4];
        this.f12618k = gameFilterBtn;
        gameFilterBtn.setTag(null);
        this.f12550e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
