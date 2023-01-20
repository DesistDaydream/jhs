package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.eth.model.NLive;
import com.google.android.material.button.MaterialButton;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.ui.page.user.selling.SellingChildFragment;
import com.jihuanshe.viewmodel.user.selling.SellingChildViewModel;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class l6 extends k6 {
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13055g = null;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f13056h = null;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final FrameLayout f13057e;

    /* renamed from: f  reason: collision with root package name */
    private long f13058f;

    public l6(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f13055g, f13056h));
    }

    private boolean k(NLive<List<GameCard>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13058f |= 1;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ac, code lost:
        if (androidx.databinding.ViewDataBinding.safeUnbox(r0 != null ? r0.getType() : null) == 1) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 300
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.l6.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13058f != 0;
        }
    }

    @Override // e.l.k.k6
    public void i(@Nullable SellingChildFragment sellingChildFragment) {
        this.f13003c = sellingChildFragment;
        synchronized (this) {
            this.f13058f |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13058f = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.k6
    public void j(@Nullable SellingChildViewModel sellingChildViewModel) {
        this.f13004d = sellingChildViewModel;
        synchronized (this) {
            this.f13058f |= 4;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return k((NLive) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((SellingChildFragment) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((SellingChildViewModel) obj);
        }
        return true;
    }

    private l6(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (MaterialButton) objArr[2], (ListView) objArr[1]);
        this.f13058f = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f13057e = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
