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
import com.jihuanshe.model.ReturnCardInfo;
import com.jihuanshe.model.UserAddress;
import com.jihuanshe.ui.page.entrepot.ApplyForReturnActivity;
import com.jihuanshe.viewmodel.entrepot.ApplyForReturnViewModel;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class r0 extends q0 {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts F = null;
    @Nullable
    private static final SparseIntArray G;
    @NonNull
    private final ConstraintLayout C;
    @NonNull
    private final TextView D;
    private long E;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        G = sparseIntArray;
        sparseIntArray.put(R.id.cl_top, 16);
        sparseIntArray.put(R.id.tv_title, 17);
        sparseIntArray.put(R.id.tv_title_all, 18);
        sparseIntArray.put(R.id.tv_content_all, 19);
        sparseIntArray.put(R.id.tv_title_part, 20);
        sparseIntArray.put(R.id.tv_content_part, 21);
        sparseIntArray.put(R.id.tv_title_fail, 22);
        sparseIntArray.put(R.id.tv_content_fail, 23);
        sparseIntArray.put(R.id.tv_address_title, 24);
        sparseIntArray.put(R.id.iv_location, 25);
        sparseIntArray.put(R.id.arrowIv1, 26);
        sparseIntArray.put(R.id.line, 27);
    }

    public r0(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 28, F, G));
    }

    private boolean k(NLive<List<ReturnCardInfo>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.E |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean l(e.n.f<UserAddress> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.E |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean m(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.E |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean n(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.E |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean o(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.E |= 16;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:129:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0422  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:218:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 1089
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.r0.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.E != 0;
        }
    }

    @Override // e.l.k.q0
    public void i(@Nullable ApplyForReturnActivity applyForReturnActivity) {
        this.A = applyForReturnActivity;
        synchronized (this) {
            this.E |= 32;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.E = 128L;
        }
        requestRebind();
    }

    @Override // e.l.k.q0
    public void j(@Nullable ApplyForReturnViewModel applyForReturnViewModel) {
        this.B = applyForReturnViewModel;
        synchronized (this) {
            this.E |= 64;
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
                        if (i2 != 4) {
                            return false;
                        }
                        return o((e.n.l) obj, i3);
                    }
                    return k((NLive) obj, i3);
                }
                return m((e.n.l) obj, i3);
            }
            return l((e.n.f) obj, i3);
        }
        return n((e.n.l) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((ApplyForReturnActivity) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((ApplyForReturnViewModel) obj);
        }
        return true;
    }

    private r0(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (ImageView) objArr[26], (ListView) objArr[12], (ConstraintLayout) objArr[4], (ConstraintLayout) objArr[16], (ImageView) objArr[25], (View) objArr[27], (View) objArr[14], (ListView) objArr[13], (LinearLayout) objArr[1], (LinearLayout) objArr[3], (LinearLayout) objArr[2], (LinearLayout) objArr[8], (TextView) objArr[7], (TextView) objArr[24], (TextView) objArr[19], (TextView) objArr[23], (TextView) objArr[21], (TextView) objArr[9], (TextView) objArr[5], (TextView) objArr[10], (TextView) objArr[6], (TextView) objArr[11], (TextView) objArr[17], (TextView) objArr[18], (TextView) objArr[22], (TextView) objArr[20]);
        this.E = -1L;
        this.b.setTag(null);
        this.f13375c.setTag(null);
        this.f13379g.setTag(null);
        this.f13380h.setTag(null);
        this.f13381i.setTag(null);
        this.f13382j.setTag(null);
        this.f13383k.setTag(null);
        this.f13384l.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.C = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[15];
        this.D = textView;
        textView.setTag(null);
        this.f13385m.setTag(null);
        this.r.setTag(null);
        this.s.setTag(null);
        this.t.setTag(null);
        this.u.setTag(null);
        this.v.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
