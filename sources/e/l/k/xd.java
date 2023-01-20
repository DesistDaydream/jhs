package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.model.Product;
import com.jihuanshe.ui.widget.CardImageView;
import com.jihuanshe.ui.widget.ScoreView;

/* loaded from: classes2.dex */
public class xd extends wd {
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13921m = null;
    @Nullable
    private static final SparseIntArray n = null;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final ConstraintLayout f13922j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final ScoreView f13923k;

    /* renamed from: l  reason: collision with root package name */
    private long f13924l;

    public xd(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, f13921m, n));
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 370
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.xd.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13924l != 0;
        }
    }

    @Override // e.l.k.wd
    public void i(@Nullable Product product) {
        this.f13876i = product;
        synchronized (this) {
            this.f13924l |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13924l = 4L;
        }
        requestRebind();
    }

    @Override // e.l.k.wd
    public void j(@Nullable e.l.g.b1 b1Var) {
        this.f13875h = b1Var;
        synchronized (this) {
            this.f13924l |= 2;
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

    private xd(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[2], (TextView) objArr[3], (CardImageView) objArr[1], (TextView) objArr[8], (TextView) objArr[7], (TextView) objArr[6], (TextView) objArr[5]);
        this.f13924l = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        this.f13870c.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13922j = constraintLayout;
        constraintLayout.setTag(null);
        ScoreView scoreView = (ScoreView) objArr[4];
        this.f13923k = scoreView;
        scoreView.setTag(null);
        this.f13871d.setTag(null);
        this.f13872e.setTag(null);
        this.f13873f.setTag(null);
        this.f13874g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
