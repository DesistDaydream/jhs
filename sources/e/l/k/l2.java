package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.eth.model.NLive;
import com.jihuanshe.R;
import com.jihuanshe.model.ExpressData;
import com.jihuanshe.model.OrderDetailInfo;
import com.jihuanshe.ui.page.order.SellerOrderDetailActivity;
import com.jihuanshe.ui.widget.NoScrollListView;
import com.jihuanshe.viewmodel.order.SellerOrderDetailViewModel;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class l2 extends k2 {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts d1 = null;
    @Nullable
    private static final SparseIntArray e1;
    @NonNull
    private final TextView G0;
    @NonNull
    private final TextView H0;
    @NonNull
    private final ConstraintLayout I;
    @NonNull
    private final TextView I0;
    @NonNull
    private final LinearLayout J;
    @NonNull
    private final LinearLayout J0;
    @NonNull
    private final LinearLayout K;
    @NonNull
    private final TextView K0;
    @NonNull
    private final TextView L;
    @NonNull
    private final LinearLayout L0;
    @NonNull
    private final TextView M;
    @NonNull
    private final TextView M0;
    @NonNull
    private final LinearLayout N;
    @NonNull
    private final TextView N0;
    @NonNull
    private final LinearLayout O;
    @NonNull
    private final TextView O0;
    @NonNull
    private final TextView P;
    @NonNull
    private final TextView P0;
    @NonNull
    private final LinearLayout Q;
    @NonNull
    private final TextView Q0;
    @NonNull
    private final LinearLayout R;
    @NonNull
    private final LinearLayout R0;
    @NonNull
    private final TextView S;
    @NonNull
    private final TextView S0;
    @NonNull
    private final LinearLayout T;
    @NonNull
    private final TextView T0;
    @NonNull
    private final TextView U;
    @NonNull
    private final TextView U0;
    @NonNull
    private final TextView V;
    @NonNull
    private final LinearLayout V0;
    @NonNull
    private final TextView W;
    @NonNull
    private final TextView W0;
    @NonNull
    private final TextView X;
    @NonNull
    private final TextView X0;
    @NonNull
    private final TextView Y;
    @NonNull
    private final LinearLayout Y0;
    @NonNull
    private final ConstraintLayout Z;
    @NonNull
    private final TextView Z0;
    @NonNull
    private final ConstraintLayout a0;
    @NonNull
    private final LinearLayout a1;
    @NonNull
    private final TextView b0;
    private long b1;
    @NonNull
    private final TextView c0;
    private long c1;
    @NonNull
    private final TextView d0;
    @NonNull
    private final TextView e0;
    @NonNull
    private final TextView f0;
    @NonNull
    private final TextView g0;
    @NonNull
    private final TextView h0;
    @NonNull
    private final TextView i0;
    @NonNull
    private final TextView j0;
    @NonNull
    private final TextView k0;
    @NonNull
    private final TextView l0;
    @NonNull
    private final LinearLayout m0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        e1 = sparseIntArray;
        sparseIntArray.put(R.id.title, 65);
        sparseIntArray.put(R.id.sellerNameTv, 66);
        sparseIntArray.put(R.id.orderNumTv, 67);
        sparseIntArray.put(R.id.orderTimeTv, 68);
        sparseIntArray.put(R.id.sellerRemark, 69);
        sparseIntArray.put(R.id.sendTitle, 70);
        sparseIntArray.put(R.id.rb1, 71);
        sparseIntArray.put(R.id.rb2, 72);
        sparseIntArray.put(R.id.expressTitle, 73);
        sparseIntArray.put(R.id.expressNumber, 74);
        sparseIntArray.put(R.id.expressEt, 75);
        sparseIntArray.put(R.id.infoLayout, 76);
        sparseIntArray.put(R.id.locationIv, 77);
        sparseIntArray.put(R.id.arrowIv1, 78);
        sparseIntArray.put(R.id.expressTv, 79);
        sparseIntArray.put(R.id.expressContent, 80);
        sparseIntArray.put(R.id.productInfoLayout, 81);
        sparseIntArray.put(R.id.titleTv, 82);
        sparseIntArray.put(R.id.divider, 83);
    }

    public l2(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 84, d1, e1));
    }

    private boolean k(NLive<List<ExpressData>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.b1 |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean l(e.n.p pVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.b1 |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean m(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.b1 |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean n(NLive<OrderDetailInfo> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.b1 |= 32;
            }
            return true;
        }
        return false;
    }

    private boolean o(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.b1 |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean p(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.b1 |= 16;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0461  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x048e  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x0746  */
    /* JADX WARN: Removed duplicated region for block: B:431:0x092b  */
    /* JADX WARN: Removed duplicated region for block: B:432:0x0946  */
    /* JADX WARN: Removed duplicated region for block: B:435:0x0951  */
    /* JADX WARN: Removed duplicated region for block: B:446:0x0967  */
    /* JADX WARN: Removed duplicated region for block: B:449:0x0970  */
    /* JADX WARN: Removed duplicated region for block: B:452:0x0985  */
    /* JADX WARN: Removed duplicated region for block: B:455:0x0990  */
    /* JADX WARN: Removed duplicated region for block: B:458:0x09f7  */
    /* JADX WARN: Removed duplicated region for block: B:461:0x0ac7  */
    /* JADX WARN: Removed duplicated region for block: B:464:0x0ad5  */
    /* JADX WARN: Removed duplicated region for block: B:467:0x0af0  */
    /* JADX WARN: Removed duplicated region for block: B:469:0x0b00  */
    /* JADX WARN: Removed duplicated region for block: B:472:0x0bae  */
    /* JADX WARN: Removed duplicated region for block: B:475:0x0bd9  */
    /* JADX WARN: Removed duplicated region for block: B:478:0x0be6  */
    /* JADX WARN: Removed duplicated region for block: B:481:0x0bf3  */
    /* JADX WARN: Removed duplicated region for block: B:484:0x0c09  */
    /* JADX WARN: Removed duplicated region for block: B:491:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0266  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 3094
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.l2.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.b1 == 0 && this.c1 == 0) {
                return false;
            }
            return true;
        }
    }

    @Override // e.l.k.k2
    public void i(@Nullable SellerOrderDetailActivity sellerOrderDetailActivity) {
        this.G = sellerOrderDetailActivity;
        synchronized (this) {
            this.b1 |= 64;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.b1 = 256L;
            this.c1 = 0L;
        }
        requestRebind();
    }

    @Override // e.l.k.k2
    public void j(@Nullable SellerOrderDetailViewModel sellerOrderDetailViewModel) {
        this.H = sellerOrderDetailViewModel;
        synchronized (this) {
            this.b1 |= 128;
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
                            if (i2 != 5) {
                                return false;
                            }
                            return n((NLive) obj, i3);
                        }
                        return p((e.n.l) obj, i3);
                    }
                    return m((e.n.l) obj, i3);
                }
                return k((NLive) obj, i3);
            }
            return l((e.n.p) obj, i3);
        }
        return o((e.n.i) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((SellerOrderDetailActivity) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((SellerOrderDetailViewModel) obj);
        }
        return true;
    }

    private l2(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (ImageView) objArr[78], (View) objArr[83], (FrameLayout) objArr[80], (EditText) objArr[75], (ConstraintLayout) objArr[33], (ListView) objArr[36], (TextView) objArr[74], (TextView) objArr[73], (TextView) objArr[79], (TextView) objArr[37], (ConstraintLayout) objArr[76], (ImageView) objArr[77], (TextView) objArr[30], (TextView) objArr[35], (TextView) objArr[67], (TextView) objArr[68], (TextView) objArr[31], (ConstraintLayout) objArr[81], (RadioButton) objArr[71], (RadioButton) objArr[72], (NoScrollListView) objArr[39], (TextView) objArr[66], (TextView) objArr[69], (TextView) objArr[24], (TextView) objArr[70], (TextView) objArr[65], (TextView) objArr[29], (TextView) objArr[82], (TextView) objArr[38], (TextView) objArr[40], (TextView) objArr[42], (RadioGroup) objArr[26]);
        this.b1 = -1L;
        this.c1 = -1L;
        this.f12990e.setTag(null);
        this.f12991f.setTag(null);
        this.f12995j.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.I = constraintLayout;
        constraintLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[1];
        this.J = linearLayout;
        linearLayout.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[10];
        this.K = linearLayout2;
        linearLayout2.setTag(null);
        TextView textView = (TextView) objArr[11];
        this.L = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[12];
        this.M = textView2;
        textView2.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) objArr[13];
        this.N = linearLayout3;
        linearLayout3.setTag(null);
        LinearLayout linearLayout4 = (LinearLayout) objArr[14];
        this.O = linearLayout4;
        linearLayout4.setTag(null);
        TextView textView3 = (TextView) objArr[15];
        this.P = textView3;
        textView3.setTag(null);
        LinearLayout linearLayout5 = (LinearLayout) objArr[16];
        this.Q = linearLayout5;
        linearLayout5.setTag(null);
        LinearLayout linearLayout6 = (LinearLayout) objArr[17];
        this.R = linearLayout6;
        linearLayout6.setTag(null);
        TextView textView4 = (TextView) objArr[18];
        this.S = textView4;
        textView4.setTag(null);
        LinearLayout linearLayout7 = (LinearLayout) objArr[19];
        this.T = linearLayout7;
        linearLayout7.setTag(null);
        TextView textView5 = (TextView) objArr[2];
        this.U = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) objArr[20];
        this.V = textView6;
        textView6.setTag(null);
        TextView textView7 = (TextView) objArr[21];
        this.W = textView7;
        textView7.setTag(null);
        TextView textView8 = (TextView) objArr[22];
        this.X = textView8;
        textView8.setTag(null);
        TextView textView9 = (TextView) objArr[23];
        this.Y = textView9;
        textView9.setTag(null);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) objArr[25];
        this.Z = constraintLayout2;
        constraintLayout2.setTag(null);
        ConstraintLayout constraintLayout3 = (ConstraintLayout) objArr[27];
        this.a0 = constraintLayout3;
        constraintLayout3.setTag(null);
        TextView textView10 = (TextView) objArr[28];
        this.b0 = textView10;
        textView10.setTag(null);
        TextView textView11 = (TextView) objArr[3];
        this.c0 = textView11;
        textView11.setTag(null);
        TextView textView12 = (TextView) objArr[32];
        this.d0 = textView12;
        textView12.setTag(null);
        TextView textView13 = (TextView) objArr[34];
        this.e0 = textView13;
        textView13.setTag(null);
        TextView textView14 = (TextView) objArr[4];
        this.f0 = textView14;
        textView14.setTag(null);
        TextView textView15 = (TextView) objArr[41];
        this.g0 = textView15;
        textView15.setTag(null);
        TextView textView16 = (TextView) objArr[43];
        this.h0 = textView16;
        textView16.setTag(null);
        TextView textView17 = (TextView) objArr[44];
        this.i0 = textView17;
        textView17.setTag(null);
        TextView textView18 = (TextView) objArr[45];
        this.j0 = textView18;
        textView18.setTag(null);
        TextView textView19 = (TextView) objArr[46];
        this.k0 = textView19;
        textView19.setTag(null);
        TextView textView20 = (TextView) objArr[47];
        this.l0 = textView20;
        textView20.setTag(null);
        LinearLayout linearLayout8 = (LinearLayout) objArr[48];
        this.m0 = linearLayout8;
        linearLayout8.setTag(null);
        TextView textView21 = (TextView) objArr[49];
        this.G0 = textView21;
        textView21.setTag(null);
        TextView textView22 = (TextView) objArr[5];
        this.H0 = textView22;
        textView22.setTag(null);
        TextView textView23 = (TextView) objArr[50];
        this.I0 = textView23;
        textView23.setTag(null);
        LinearLayout linearLayout9 = (LinearLayout) objArr[51];
        this.J0 = linearLayout9;
        linearLayout9.setTag(null);
        TextView textView24 = (TextView) objArr[52];
        this.K0 = textView24;
        textView24.setTag(null);
        LinearLayout linearLayout10 = (LinearLayout) objArr[53];
        this.L0 = linearLayout10;
        linearLayout10.setTag(null);
        TextView textView25 = (TextView) objArr[54];
        this.M0 = textView25;
        textView25.setTag(null);
        TextView textView26 = (TextView) objArr[55];
        this.N0 = textView26;
        textView26.setTag(null);
        TextView textView27 = (TextView) objArr[56];
        this.O0 = textView27;
        textView27.setTag(null);
        TextView textView28 = (TextView) objArr[57];
        this.P0 = textView28;
        textView28.setTag(null);
        TextView textView29 = (TextView) objArr[58];
        this.Q0 = textView29;
        textView29.setTag(null);
        LinearLayout linearLayout11 = (LinearLayout) objArr[59];
        this.R0 = linearLayout11;
        linearLayout11.setTag(null);
        TextView textView30 = (TextView) objArr[6];
        this.S0 = textView30;
        textView30.setTag(null);
        TextView textView31 = (TextView) objArr[60];
        this.T0 = textView31;
        textView31.setTag(null);
        TextView textView32 = (TextView) objArr[61];
        this.U0 = textView32;
        textView32.setTag(null);
        LinearLayout linearLayout12 = (LinearLayout) objArr[62];
        this.V0 = linearLayout12;
        linearLayout12.setTag(null);
        TextView textView33 = (TextView) objArr[63];
        this.W0 = textView33;
        textView33.setTag(null);
        TextView textView34 = (TextView) objArr[64];
        this.X0 = textView34;
        textView34.setTag(null);
        LinearLayout linearLayout13 = (LinearLayout) objArr[7];
        this.Y0 = linearLayout13;
        linearLayout13.setTag(null);
        TextView textView35 = (TextView) objArr[8];
        this.Z0 = textView35;
        textView35.setTag(null);
        LinearLayout linearLayout14 = (LinearLayout) objArr[9];
        this.a1 = linearLayout14;
        linearLayout14.setTag(null);
        this.f12998m.setTag(null);
        this.n.setTag(null);
        this.q.setTag(null);
        this.u.setTag(null);
        this.x.setTag(null);
        this.A.setTag(null);
        this.C.setTag(null);
        this.D.setTag(null);
        this.E.setTag(null);
        this.F.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
