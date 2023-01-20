package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.model.Banner;
import com.jihuanshe.ui.page.user.SellerDetailActivity;
import com.jihuanshe.viewmodel.user.SellerDetailViewModel;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public class fg extends eg {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12668f = null;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f12669g = null;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final ConstraintLayout f12670c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final NImageView f12671d;

    /* renamed from: e  reason: collision with root package name */
    private long f12672e;

    public fg(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f12668f, f12669g));
    }

    private boolean k(e.n.f<Banner> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12672e |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean l(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12672e |= 2;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.fg.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12672e != 0;
        }
    }

    @Override // e.l.k.eg
    public void i(@Nullable SellerDetailActivity sellerDetailActivity) {
        this.a = sellerDetailActivity;
        synchronized (this) {
            this.f12672e |= 4;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12672e = 16L;
        }
        requestRebind();
    }

    @Override // e.l.k.eg
    public void j(@Nullable SellerDetailViewModel sellerDetailViewModel) {
        this.b = sellerDetailViewModel;
        synchronized (this) {
            this.f12672e |= 8;
        }
        notifyPropertyChanged(21);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            if (i2 != 1) {
                return false;
            }
            return l((e.n.i) obj, i3);
        }
        return k((e.n.f) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((SellerDetailActivity) obj);
        } else if (21 != i2) {
            return false;
        } else {
            j((SellerDetailViewModel) obj);
        }
        return true;
    }

    private fg(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2);
        this.f12672e = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12670c = constraintLayout;
        constraintLayout.setTag(null);
        NImageView nImageView = (NImageView) objArr[1];
        this.f12671d = nImageView;
        nImageView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
