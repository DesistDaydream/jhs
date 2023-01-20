package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.base.ui.widget.SlideIndicatorView;
import com.jihuanshe.model.Rarity;
import com.jihuanshe.ui.page.search.fragments.global.GlobalSearchProductFragment;
import com.jihuanshe.ui.widget.GameFilterBtn;
import com.jihuanshe.ui.widget.RarityFilterBtn;
import com.vector.view.pager.ViewPager;
import java.util.List;

/* loaded from: classes2.dex */
public class v6 extends u6 {
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13748j = null;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private static final SparseIntArray f13749k;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final RelativeLayout f13750h;

    /* renamed from: i  reason: collision with root package name */
    private long f13751i;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13749k = sparseIntArray;
        sparseIntArray.put(R.id.indicator, 5);
    }

    public v6(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f13748j, f13749k));
    }

    private boolean k(e.n.f<List<Rarity>> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13751i |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean l(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13751i |= 1;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a2  */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v5 */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 353
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.v6.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13751i != 0;
        }
    }

    @Override // e.l.k.u6
    public void i(@Nullable GlobalSearchProductFragment globalSearchProductFragment) {
        this.f13700f = globalSearchProductFragment;
        synchronized (this) {
            this.f13751i |= 4;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13751i = 16L;
        }
        requestRebind();
    }

    @Override // e.l.k.u6
    public void j(@Nullable e.l.s.m.d.a aVar) {
        this.f13701g = aVar;
        synchronized (this) {
            this.f13751i |= 8;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            if (i2 != 1) {
                return false;
            }
            return k((e.n.f) obj, i3);
        }
        return l((e.n.i) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((GlobalSearchProductFragment) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((e.l.s.m.d.a) obj);
        }
        return true;
    }

    private v6(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (GameFilterBtn) objArr[3], (ConstraintLayout) objArr[5], (RarityFilterBtn) objArr[4], (SlideIndicatorView) objArr[2], (ViewPager) objArr[1]);
        this.f13751i = -1L;
        this.a.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f13750h = relativeLayout;
        relativeLayout.setTag(null);
        this.f13697c.setTag(null);
        this.f13698d.setTag(null);
        this.f13699e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
