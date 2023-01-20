package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.WarehouseInfo;
import com.jihuanshe.ui.page.user.MineEntrepotActivity;
import com.jihuanshe.viewmodel.user.MineEntrepotViewModel;

/* loaded from: classes2.dex */
public class l1 extends k1 {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts P = null;
    @Nullable
    private static final SparseIntArray Q;
    @NonNull
    private final ConstraintLayout E;
    @NonNull
    private final TextView F;
    @NonNull
    private final TextView G;
    @NonNull
    private final LinearLayout H;
    @NonNull
    private final TextView I;
    @NonNull
    private final TextView J;
    @NonNull
    private final TextView K;
    @NonNull
    private final TextView L;
    @NonNull
    private final TextView M;
    @NonNull
    private final ConstraintLayout N;
    private long O;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        Q = sparseIntArray;
        sparseIntArray.put(R.id.view_flow, 23);
        sparseIntArray.put(R.id.nScrollView, 24);
        sparseIntArray.put(R.id.cl_num, 25);
        sparseIntArray.put(R.id.tvData, 26);
        sparseIntArray.put(R.id.cl_top, 27);
        sparseIntArray.put(R.id.tv_tip, 28);
        sparseIntArray.put(R.id.view_line, 29);
        sparseIntArray.put(R.id.cl_order, 30);
        sparseIntArray.put(R.id.tv_order_tip, 31);
        sparseIntArray.put(R.id.view_order_line, 32);
        sparseIntArray.put(R.id.cl_out_order, 33);
        sparseIntArray.put(R.id.tv_out_order_tip, 34);
        sparseIntArray.put(R.id.view_out_order_line, 35);
        sparseIntArray.put(R.id.tv_explain, 36);
        sparseIntArray.put(R.id.view_line_2, 37);
    }

    public l1(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 38, P, Q));
    }

    private boolean k(e.n.f<Game> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.O |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean l(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.O |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean m(e.n.f<WarehouseInfo> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.O |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean n(e.n.f<CharSequence> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.O |= 1;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x016c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x017a  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 567
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.l1.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.O != 0;
        }
    }

    @Override // e.l.k.k1
    public void i(@Nullable MineEntrepotActivity mineEntrepotActivity) {
        this.C = mineEntrepotActivity;
        synchronized (this) {
            this.O |= 16;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.O = 64L;
        }
        requestRebind();
    }

    @Override // e.l.k.k1
    public void j(@Nullable MineEntrepotViewModel mineEntrepotViewModel) {
        this.D = mineEntrepotViewModel;
        synchronized (this) {
            this.O |= 32;
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
                    return m((e.n.f) obj, i3);
                }
                return k((e.n.f) obj, i3);
            }
            return l((e.n.l) obj, i3);
        }
        return n((e.n.f) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((MineEntrepotActivity) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((MineEntrepotViewModel) obj);
        }
        return true;
    }

    private l1(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (ConstraintLayout) objArr[1], (ConstraintLayout) objArr[14], (ConstraintLayout) objArr[20], (ConstraintLayout) objArr[25], (ConstraintLayout) objArr[30], (ConstraintLayout) objArr[33], (ConstraintLayout) objArr[27], (ImageView) objArr[21], (LinearLayout) objArr[8], (LinearLayout) objArr[7], (LinearLayout) objArr[10], (LinearLayout) objArr[11], (LinearLayout) objArr[12], (LinearLayout) objArr[13], (LinearLayout) objArr[9], (NestedScrollView) objArr[24], (TextView) objArr[15], (TextView) objArr[26], (TextView) objArr[36], (TextView) objArr[31], (TextView) objArr[34], (TextView) objArr[28], (View) objArr[23], (View) objArr[29], (View) objArr[37], (View) objArr[32], (View) objArr[35], (TextView) objArr[6]);
        this.O = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        this.f12977c.setTag(null);
        this.f12982h.setTag(null);
        this.f12983i.setTag(null);
        this.f12984j.setTag(null);
        this.f12985k.setTag(null);
        this.f12986l.setTag(null);
        this.f12987m.setTag(null);
        this.n.setTag(null);
        this.o.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.E = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[16];
        this.F = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[17];
        this.G = textView2;
        textView2.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[18];
        this.H = linearLayout;
        linearLayout.setTag(null);
        TextView textView3 = (TextView) objArr[19];
        this.I = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[2];
        this.J = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[22];
        this.K = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) objArr[3];
        this.L = textView6;
        textView6.setTag(null);
        TextView textView7 = (TextView) objArr[4];
        this.M = textView7;
        textView7.setTag(null);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) objArr[5];
        this.N = constraintLayout2;
        constraintLayout2.setTag(null);
        this.q.setTag(null);
        this.B.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
