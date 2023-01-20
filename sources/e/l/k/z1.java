package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.eth.model.NLive;
import com.jihuanshe.R;
import com.jihuanshe.model.ReviewListInfo;
import com.jihuanshe.model.ReviewMineInfo;
import com.jihuanshe.ui.page.detail.ReviewListActivity;
import com.jihuanshe.ui.widget.FilterTextView;
import com.jihuanshe.ui.widget.StarRatingBar;
import com.jihuanshe.viewmodel.detail.ReviewListViewModel;
import com.vector.view.scrollable.ListView;
import java.util.List;
import kotlin.Pair;

/* loaded from: classes2.dex */
public class z1 extends y1 {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts u = null;
    @Nullable
    private static final SparseIntArray v;
    @NonNull
    private final ConstraintLayout q;
    @NonNull
    private final ConstraintLayout r;
    @NonNull
    private final ImageView s;
    private long t;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        v = sparseIntArray;
        sparseIntArray.put(R.id.coordinatorView, 12);
        sparseIntArray.put(R.id.minView, 13);
        sparseIntArray.put(R.id.llBar, 14);
        sparseIntArray.put(R.id.tv, 15);
        sparseIntArray.put(R.id.lineView, 16);
    }

    public z1(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 17, u, v));
    }

    private boolean k(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.t |= 64;
            }
            return true;
        }
        return false;
    }

    private boolean l(NLive<List<ReviewListInfo>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.t |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean m(NLive<ReviewMineInfo> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.t |= 32;
            }
            return true;
        }
        return false;
    }

    private boolean n(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.t |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean o(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.t |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean p(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.t |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean q(e.n.f<List<Pair<String, String>>> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.t |= 1;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01c5, code lost:
        if (r5 != false) goto L163;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:189:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x019c  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 954
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.z1.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.t != 0;
        }
    }

    @Override // e.l.k.y1
    public void i(@Nullable ReviewListActivity reviewListActivity) {
        this.o = reviewListActivity;
        synchronized (this) {
            this.t |= 128;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.t = 512L;
        }
        requestRebind();
    }

    @Override // e.l.k.y1
    public void j(@Nullable ReviewListViewModel reviewListViewModel) {
        this.p = reviewListViewModel;
        synchronized (this) {
            this.t |= 256;
        }
        notifyPropertyChanged(21);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return q((e.n.f) obj, i3);
            case 1:
                return n((e.n.i) obj, i3);
            case 2:
                return l((NLive) obj, i3);
            case 3:
                return p((e.n.i) obj, i3);
            case 4:
                return o((e.n.i) obj, i3);
            case 5:
                return m((NLive) obj, i3);
            case 6:
                return k((e.n.l) obj, i3);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((ReviewListActivity) obj);
        } else if (21 != i2) {
            return false;
        } else {
            j((ReviewListViewModel) obj);
        }
        return true;
    }

    private z1(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 7, (TextView) objArr[6], (ConstraintLayout) objArr[9], (CoordinatorLayout) objArr[12], (EditText) objArr[11], (FilterTextView) objArr[7], (View) objArr[16], (ListView) objArr[8], (LinearLayout) objArr[14], (LinearLayout) objArr[10], (ConstraintLayout) objArr[13], (StarRatingBar) objArr[2], (TextView) objArr[5], (TextView) objArr[15], (TextView) objArr[4]);
        this.t = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        this.f13938d.setTag(null);
        this.f13939e.setTag(null);
        this.f13941g.setTag(null);
        this.f13943i.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.q = constraintLayout;
        constraintLayout.setTag(null);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) objArr[1];
        this.r = constraintLayout2;
        constraintLayout2.setTag(null);
        ImageView imageView = (ImageView) objArr[3];
        this.s = imageView;
        imageView.setTag(null);
        this.f13945k.setTag(null);
        this.f13946l.setTag(null);
        this.n.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
