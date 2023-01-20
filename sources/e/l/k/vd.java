package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.Product;
import com.jihuanshe.ui.widget.ScoreView;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public class vd extends ud {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts n = null;
    @Nullable
    private static final SparseIntArray o;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final ConstraintLayout f13776k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private final ScoreView f13777l;

    /* renamed from: m  reason: collision with root package name */
    private long f13778m;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        o = sparseIntArray;
        sparseIntArray.put(R.id.top1, 8);
        sparseIntArray.put(R.id.top2, 9);
    }

    public vd(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, n, o));
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ae  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.vd.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13778m != 0;
        }
    }

    @Override // e.l.k.ud
    public void i(@Nullable Product product) {
        this.f13723i = product;
        synchronized (this) {
            this.f13778m |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13778m = 4L;
        }
        requestRebind();
    }

    @Override // e.l.k.ud
    public void j(@Nullable e.l.g.b1 b1Var) {
        this.f13724j = b1Var;
        synchronized (this) {
            this.f13778m |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (8 == i2) {
            i((Product) obj);
        } else if (10 != i2) {
            return false;
        } else {
            j((e.l.g.b1) obj);
        }
        return true;
    }

    private vd(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[2], (TextView) objArr[6], (NImageView) objArr[1], (TextView) objArr[5], (TextView) objArr[7], (TextView) objArr[3], (View) objArr[8], (View) objArr[9]);
        this.f13778m = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        this.f13717c.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13776k = constraintLayout;
        constraintLayout.setTag(null);
        ScoreView scoreView = (ScoreView) objArr[4];
        this.f13777l = scoreView;
        scoreView.setTag(null);
        this.f13718d.setTag(null);
        this.f13719e.setTag(null);
        this.f13720f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
