package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.eth.model.NLive;
import com.jihuanshe.model.RankCardInfo;
import com.jihuanshe.ui.page.rank.RankListFragment;
import com.jihuanshe.viewmodel.rank.RankListViewModel;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class h7 extends g7 {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12779f = null;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f12780g = null;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final ConstraintLayout f12781d;

    /* renamed from: e  reason: collision with root package name */
    private long f12782e;

    public h7(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f12779f, f12780g));
    }

    private boolean k(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12782e |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean l(NLive<List<RankCardInfo>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12782e |= 2;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.h7.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12782e != 0;
        }
    }

    @Override // e.l.k.g7
    public void i(@Nullable RankListFragment rankListFragment) {
        this.b = rankListFragment;
        synchronized (this) {
            this.f12782e |= 4;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12782e = 16L;
        }
        requestRebind();
    }

    @Override // e.l.k.g7
    public void j(@Nullable RankListViewModel rankListViewModel) {
        this.f12725c = rankListViewModel;
        synchronized (this) {
            this.f12782e |= 8;
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
            return l((NLive) obj, i3);
        }
        return k((e.n.l) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((RankListFragment) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((RankListViewModel) obj);
        }
        return true;
    }

    private h7(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (ListView) objArr[1]);
        this.f12782e = -1L;
        this.a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12781d = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
