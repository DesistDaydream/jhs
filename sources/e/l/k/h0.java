package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.eth.model.NLive;
import com.jihuanshe.R;
import com.jihuanshe.model.ApplyForItem;
import com.jihuanshe.model.CardConsignmentInfo;
import com.jihuanshe.model.ExpressData;
import com.jihuanshe.model.OrderReturnDetail;
import com.jihuanshe.model.OrderReturnInfo;
import com.jihuanshe.ui.page.entrepot.ConOrderDetailsActivity;
import com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel;
import com.vector.view.scrollable.ListView;
import java.util.List;
import kotlin.Pair;

/* loaded from: classes2.dex */
public class h0 extends g0 {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts w = null;
    @Nullable
    private static final SparseIntArray x;
    @NonNull
    private final NestedScrollView o;
    @NonNull
    private final TextView p;
    @NonNull
    private final TextView q;
    @NonNull
    private final TextView r;
    @NonNull
    private final ConstraintLayout s;
    @NonNull
    private final ImageView t;
    @NonNull
    private final TextView u;
    private long v;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        x = sparseIntArray;
        sparseIntArray.put(R.id.tv_express_title, 14);
        sparseIntArray.put(R.id.tv_title, 15);
        sparseIntArray.put(R.id.tv_num, 16);
        sparseIntArray.put(R.id.tv_time, 17);
        sparseIntArray.put(R.id.tv, 18);
    }

    public h0(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 19, w, x));
    }

    private boolean k(NLive<List<ApplyForItem>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.v |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean l(NLive<CardConsignmentInfo> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.v |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean m(NLive<List<OrderReturnInfo>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.v |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean n(NLive<OrderReturnDetail> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.v |= 32;
            }
            return true;
        }
        return false;
    }

    private boolean o(NLive<List<ExpressData>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.v |= 128;
            }
            return true;
        }
        return false;
    }

    private boolean p(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.v |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean q(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.v |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean r(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.v |= 64;
            }
            return true;
        }
        return false;
    }

    private boolean s(NLive<Pair<String, String>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.v |= 256;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x019a  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 1507
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.h0.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.v != 0;
        }
    }

    @Override // e.l.k.g0
    public void i(@Nullable ConOrderDetailsActivity conOrderDetailsActivity) {
        this.f12685m = conOrderDetailsActivity;
        synchronized (this) {
            this.v |= 512;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.v = 2048L;
        }
        requestRebind();
    }

    @Override // e.l.k.g0
    public void j(@Nullable ConOrderDetailsViewModel conOrderDetailsViewModel) {
        this.n = conOrderDetailsViewModel;
        synchronized (this) {
            this.v |= 1024;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return l((NLive) obj, i3);
            case 1:
                return k((NLive) obj, i3);
            case 2:
                return m((NLive) obj, i3);
            case 3:
                return p((e.n.i) obj, i3);
            case 4:
                return q((e.n.i) obj, i3);
            case 5:
                return n((NLive) obj, i3);
            case 6:
                return r((e.n.l) obj, i3);
            case 7:
                return o((NLive) obj, i3);
            case 8:
                return s((NLive) obj, i3);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((ConOrderDetailsActivity) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((ConOrderDetailsViewModel) obj);
        }
        return true;
    }

    private h0(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 9, (ListView) objArr[12], (ListView) objArr[13], (ListView) objArr[7], (TextView) objArr[8], (TextView) objArr[18], (TextView) objArr[4], (TextView) objArr[14], (TextView) objArr[11], (TextView) objArr[16], (TextView) objArr[17], (TextView) objArr[15], (TextView) objArr[5]);
        this.v = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        this.f12675c.setTag(null);
        this.f12676d.setTag(null);
        NestedScrollView nestedScrollView = (NestedScrollView) objArr[0];
        this.o = nestedScrollView;
        nestedScrollView.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.p = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[10];
        this.q = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[2];
        this.r = textView3;
        textView3.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[3];
        this.s = constraintLayout;
        constraintLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[6];
        this.t = imageView;
        imageView.setTag(null);
        TextView textView4 = (TextView) objArr[9];
        this.u = textView4;
        textView4.setTag(null);
        this.f12678f.setTag(null);
        this.f12680h.setTag(null);
        this.f12684l.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
