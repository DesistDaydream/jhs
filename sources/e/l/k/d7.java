package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.eth.model.NLive;
import com.jihuanshe.R;
import com.jihuanshe.model.FailProductInfo;
import com.jihuanshe.model.SoldProductInfo;
import com.jihuanshe.model.WarehouseProductInfo;
import com.jihuanshe.ui.page.entrepot.MineStorehouseFragment;
import com.jihuanshe.viewmodel.entrepot.MineStorehouseViewModel;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class d7 extends c7 {
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12501m = null;
    @Nullable
    private static final SparseIntArray n;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final ConstraintLayout f12502j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final ImageView f12503k;

    /* renamed from: l  reason: collision with root package name */
    private long f12504l;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        n = sparseIntArray;
        sparseIntArray.put(R.id.ll_tab, 8);
    }

    public d7(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, f12501m, n));
    }

    private boolean k(NLive<List<WarehouseProductInfo>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12504l |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean l(NLive<List<FailProductInfo>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12504l |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean m(NLive<List<SoldProductInfo>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12504l |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean n(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12504l |= 1;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01ab  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 872
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.d7.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12504l != 0;
        }
    }

    @Override // e.l.k.c7
    public void i(@Nullable MineStorehouseFragment mineStorehouseFragment) {
        this.f12412h = mineStorehouseFragment;
        synchronized (this) {
            this.f12504l |= 16;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12504l = 64L;
        }
        requestRebind();
    }

    @Override // e.l.k.c7
    public void j(@Nullable MineStorehouseViewModel mineStorehouseViewModel) {
        this.f12413i = mineStorehouseViewModel;
        synchronized (this) {
            this.f12504l |= 32;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return false;
                    }
                    return l((NLive) obj, i3);
                }
                return m((NLive) obj, i3);
            }
            return k((NLive) obj, i3);
        }
        return n((e.n.l) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((MineStorehouseFragment) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((MineStorehouseViewModel) obj);
        }
        return true;
    }

    private d7(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (ListView) objArr[5], (ListView) objArr[6], (ListView) objArr[7], (LinearLayout) objArr[8], (TextView) objArr[1], (TextView) objArr[2], (TextView) objArr[4]);
        this.f12504l = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        this.f12407c.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12502j = constraintLayout;
        constraintLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[3];
        this.f12503k = imageView;
        imageView.setTag(null);
        this.f12409e.setTag(null);
        this.f12410f.setTag(null);
        this.f12411g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
