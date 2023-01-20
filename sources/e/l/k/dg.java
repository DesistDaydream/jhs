package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.eth.model.NLive;
import com.jihuanshe.R;
import com.jihuanshe.model.CardConsignmentInfo;
import com.jihuanshe.ui.page.entrepot.MineStorehouseFragment;
import com.jihuanshe.viewmodel.entrepot.MineStorehouseViewModel;
import java.util.List;

/* loaded from: classes2.dex */
public class dg extends cg {
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12523l = null;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private static final SparseIntArray f12524m;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final ConstraintLayout f12525i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final ConstraintLayout f12526j;

    /* renamed from: k  reason: collision with root package name */
    private long f12527k;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f12524m = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 6);
        sparseIntArray.put(R.id.tv_num, 7);
    }

    public dg(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f12523l, f12524m));
    }

    private boolean k(NLive<List<CardConsignmentInfo>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12527k |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        String str;
        String str2;
        CardConsignmentInfo cardConsignmentInfo;
        int i2;
        String str3;
        synchronized (this) {
            j2 = this.f12527k;
            this.f12527k = 0L;
        }
        MineStorehouseFragment mineStorehouseFragment = this.f12462g;
        MineStorehouseViewModel mineStorehouseViewModel = this.f12463h;
        String str4 = null;
        e.t.j.h.g p0 = ((j2 & 10) == 0 || mineStorehouseFragment == null) ? null : mineStorehouseFragment.p0();
        int i3 = ((j2 & 13) > 0L ? 1 : ((j2 & 13) == 0L ? 0 : -1));
        if (i3 != 0) {
            NLive<List<CardConsignmentInfo>> t0 = mineStorehouseViewModel != null ? mineStorehouseViewModel.t0() : null;
            updateLiveDataRegistration(0, t0);
            List<CardConsignmentInfo> value = t0 != null ? t0.getValue() : null;
            if (value != null) {
                cardConsignmentInfo = (CardConsignmentInfo) ViewDataBinding.getFromList(value, 0);
                i2 = value.size();
            } else {
                cardConsignmentInfo = null;
                i2 = 0;
            }
            if (cardConsignmentInfo != null) {
                str4 = cardConsignmentInfo.getUuid();
                str3 = cardConsignmentInfo.getExpressName();
                str2 = cardConsignmentInfo.getExpressNumber();
            } else {
                str2 = null;
                str3 = null;
            }
            boolean z = i2 == 0;
            if (i3 != 0) {
                j2 |= z ? 32L : 16L;
            }
            r14 = z ? 8 : 0;
            str = str4;
            str4 = str3;
        } else {
            str = null;
            str2 = null;
        }
        if ((13 & j2) != 0) {
            this.f12526j.setVisibility(r14);
            TextViewBindingAdapter.setText(this.b, str4);
            TextViewBindingAdapter.setText(this.f12458c, str2);
            TextViewBindingAdapter.setText(this.f12460e, str);
        }
        if ((j2 & 10) != 0) {
            e.t.j.g.e0.F(this.a, p0);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12527k != 0;
        }
    }

    @Override // e.l.k.cg
    public void i(@Nullable MineStorehouseFragment mineStorehouseFragment) {
        this.f12462g = mineStorehouseFragment;
        synchronized (this) {
            this.f12527k |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12527k = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.cg
    public void j(@Nullable MineStorehouseViewModel mineStorehouseViewModel) {
        this.f12463h = mineStorehouseViewModel;
        synchronized (this) {
            this.f12527k |= 4;
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
            i((MineStorehouseFragment) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((MineStorehouseViewModel) obj);
        }
        return true;
    }

    private dg(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[5], (TextView) objArr[3], (TextView) objArr[4], (TextView) objArr[7], (TextView) objArr[2], (TextView) objArr[6]);
        this.f12527k = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12525i = constraintLayout;
        constraintLayout.setTag(null);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) objArr[1];
        this.f12526j = constraintLayout2;
        constraintLayout2.setTag(null);
        this.a.setTag(null);
        this.b.setTag(null);
        this.f12458c.setTag(null);
        this.f12460e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
