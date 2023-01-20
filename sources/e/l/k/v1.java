package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.RankTypeInfo;
import com.jihuanshe.ui.page.rank.RankActivity;
import com.jihuanshe.ui.widget.GameFilterBtn;
import com.jihuanshe.ui.widget.RankIndicatorView;
import com.jihuanshe.viewmodel.rank.RankViewModel;
import com.vector.network.image.NImageView;
import com.vector.view.pager.ViewPager;

/* loaded from: classes2.dex */
public class v1 extends u1 {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p = null;
    @Nullable
    private static final SparseIntArray q;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final ConstraintLayout f13731k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private final TextView f13732l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    private final TextView f13733m;
    @NonNull
    private final TextView n;
    private long o;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        q = sparseIntArray;
        sparseIntArray.put(R.id.clDesc, 11);
    }

    public v1(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 12, p, q));
    }

    private boolean k(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.o |= 64;
            }
            return true;
        }
        return false;
    }

    private boolean l(e.n.f<RankTypeInfo> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.o |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean m(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.o |= 32;
            }
            return true;
        }
        return false;
    }

    private boolean n(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.o |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean o(e.n.f<e.t.k.a.c.h.c> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.o |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean p(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.o |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean q(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.o |= 8;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:140:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x015a  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 719
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.v1.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.o != 0;
        }
    }

    @Override // e.l.k.u1
    public void i(@Nullable RankActivity rankActivity) {
        this.f13671i = rankActivity;
        synchronized (this) {
            this.o |= 128;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.o = 512L;
        }
        requestRebind();
    }

    @Override // e.l.k.u1
    public void j(@Nullable RankViewModel rankViewModel) {
        this.f13672j = rankViewModel;
        synchronized (this) {
            this.o |= 256;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return p((e.n.l) obj, i3);
            case 1:
                return o((e.n.f) obj, i3);
            case 2:
                return n((e.n.l) obj, i3);
            case 3:
                return q((e.n.l) obj, i3);
            case 4:
                return l((e.n.f) obj, i3);
            case 5:
                return m((e.n.l) obj, i3);
            case 6:
                return k((e.n.l) obj, i3);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((RankActivity) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((RankViewModel) obj);
        }
        return true;
    }

    private v1(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 7, (LinearLayout) objArr[4], (ConstraintLayout) objArr[11], (GameFilterBtn) objArr[10], (LinearLayout) objArr[1], (NImageView) objArr[5], (ViewPager) objArr[3], (RankIndicatorView) objArr[2], (TextView) objArr[6]);
        this.o = -1L;
        this.a.setTag(null);
        this.f13665c.setTag(null);
        this.f13666d.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13731k = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[7];
        this.f13732l = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[8];
        this.f13733m = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[9];
        this.n = textView3;
        textView3.setTag(null);
        this.f13667e.setTag(null);
        this.f13668f.setTag(null);
        this.f13669g.setTag(null);
        this.f13670h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
