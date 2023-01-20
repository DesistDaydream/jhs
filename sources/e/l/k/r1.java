package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
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
import com.jihuanshe.model.ExpressData;
import com.jihuanshe.model.OrderDetailInfo;
import com.jihuanshe.ui.page.order.OrderDetailActivity;
import com.jihuanshe.ui.widget.NoScrollListView;
import com.jihuanshe.viewmodel.order.OrderDetailViewModel;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class r1 extends q1 {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts I0 = null;
    @Nullable
    private static final SparseIntArray J0;
    @NonNull
    private final ConstraintLayout C;
    @NonNull
    private final LinearLayout D;
    @NonNull
    private final LinearLayout E;
    @NonNull
    private final LinearLayout F;
    @NonNull
    private final LinearLayout G;
    @NonNull
    private final LinearLayout G0;
    @NonNull
    private final TextView H;
    private long H0;
    @NonNull
    private final LinearLayout I;
    @NonNull
    private final LinearLayout J;
    @NonNull
    private final TextView K;
    @NonNull
    private final TextView L;
    @NonNull
    private final LinearLayout M;
    @NonNull
    private final TextView N;
    @NonNull
    private final TextView O;
    @NonNull
    private final TextView P;
    @NonNull
    private final TextView Q;
    @NonNull
    private final TextView R;
    @NonNull
    private final TextView S;
    @NonNull
    private final TextView T;
    @NonNull
    private final TextView U;
    @NonNull
    private final TextView V;
    @NonNull
    private final TextView W;
    @NonNull
    private final TextView X;
    @NonNull
    private final LinearLayout Y;
    @NonNull
    private final TextView Z;
    @NonNull
    private final TextView a0;
    @NonNull
    private final LinearLayout b0;
    @NonNull
    private final TextView c0;
    @NonNull
    private final TextView d0;
    @NonNull
    private final LinearLayout e0;
    @NonNull
    private final TextView f0;
    @NonNull
    private final LinearLayout g0;
    @NonNull
    private final TextView h0;
    @NonNull
    private final TextView i0;
    @NonNull
    private final TextView j0;
    @NonNull
    private final TextView k0;
    @NonNull
    private final LinearLayout l0;
    @NonNull
    private final TextView m0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        J0 = sparseIntArray;
        sparseIntArray.put(R.id.title, 49);
        sparseIntArray.put(R.id.sellerNameTv, 50);
        sparseIntArray.put(R.id.orderNumTv, 51);
        sparseIntArray.put(R.id.orderTimeTv, 52);
        sparseIntArray.put(R.id.sellerRemark, 53);
        sparseIntArray.put(R.id.infoLayout, 54);
        sparseIntArray.put(R.id.locationIv, 55);
        sparseIntArray.put(R.id.arrowIv1, 56);
        sparseIntArray.put(R.id.expressTv, 57);
        sparseIntArray.put(R.id.expressContent, 58);
        sparseIntArray.put(R.id.productInfoLayout, 59);
        sparseIntArray.put(R.id.titleTv, 60);
        sparseIntArray.put(R.id.divider, 61);
        sparseIntArray.put(R.id.llShipping, 62);
        sparseIntArray.put(R.id.llProductsPrice, 63);
    }

    public r1(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 64, I0, J0));
    }

    private boolean k(NLive<List<ExpressData>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.H0 |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean l(NLive<OrderDetailInfo> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.H0 |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean m(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.H0 |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean n(e.n.p pVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.H0 |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean o(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.H0 |= 8;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:203:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x058a  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01fd  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 2132
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.r1.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.H0 != 0;
        }
    }

    @Override // e.l.k.q1
    public void i(@Nullable OrderDetailActivity orderDetailActivity) {
        this.A = orderDetailActivity;
        synchronized (this) {
            this.H0 |= 32;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.H0 = 128L;
        }
        requestRebind();
    }

    @Override // e.l.k.q1
    public void j(@Nullable OrderDetailViewModel orderDetailViewModel) {
        this.B = orderDetailViewModel;
        synchronized (this) {
            this.H0 |= 64;
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
                        return l((NLive) obj, i3);
                    }
                    return o((e.n.l) obj, i3);
                }
                return n((e.n.p) obj, i3);
            }
            return k((NLive) obj, i3);
        }
        return m((e.n.i) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((OrderDetailActivity) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((OrderDetailViewModel) obj);
        }
        return true;
    }

    private r1(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (ImageView) objArr[56], (View) objArr[61], (FrameLayout) objArr[58], (ConstraintLayout) objArr[27], (ListView) objArr[30], (TextView) objArr[57], (TextView) objArr[31], (ConstraintLayout) objArr[54], (LinearLayout) objArr[63], (LinearLayout) objArr[62], (ImageView) objArr[55], (TextView) objArr[24], (TextView) objArr[29], (TextView) objArr[51], (TextView) objArr[52], (TextView) objArr[25], (ConstraintLayout) objArr[59], (NoScrollListView) objArr[33], (TextView) objArr[50], (TextView) objArr[53], (TextView) objArr[23], (TextView) objArr[49], (TextView) objArr[60], (TextView) objArr[32], (TextView) objArr[34], (TextView) objArr[36]);
        this.H0 = -1L;
        this.f13387d.setTag(null);
        this.f13388e.setTag(null);
        this.f13390g.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.C = constraintLayout;
        constraintLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[1];
        this.D = linearLayout;
        linearLayout.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[10];
        this.E = linearLayout2;
        linearLayout2.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) objArr[11];
        this.F = linearLayout3;
        linearLayout3.setTag(null);
        LinearLayout linearLayout4 = (LinearLayout) objArr[12];
        this.G = linearLayout4;
        linearLayout4.setTag(null);
        TextView textView = (TextView) objArr[13];
        this.H = textView;
        textView.setTag(null);
        LinearLayout linearLayout5 = (LinearLayout) objArr[14];
        this.I = linearLayout5;
        linearLayout5.setTag(null);
        LinearLayout linearLayout6 = (LinearLayout) objArr[15];
        this.J = linearLayout6;
        linearLayout6.setTag(null);
        TextView textView2 = (TextView) objArr[16];
        this.K = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[17];
        this.L = textView3;
        textView3.setTag(null);
        LinearLayout linearLayout7 = (LinearLayout) objArr[18];
        this.M = linearLayout7;
        linearLayout7.setTag(null);
        TextView textView4 = (TextView) objArr[19];
        this.N = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[2];
        this.O = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) objArr[20];
        this.P = textView6;
        textView6.setTag(null);
        TextView textView7 = (TextView) objArr[21];
        this.Q = textView7;
        textView7.setTag(null);
        TextView textView8 = (TextView) objArr[22];
        this.R = textView8;
        textView8.setTag(null);
        TextView textView9 = (TextView) objArr[26];
        this.S = textView9;
        textView9.setTag(null);
        TextView textView10 = (TextView) objArr[28];
        this.T = textView10;
        textView10.setTag(null);
        TextView textView11 = (TextView) objArr[3];
        this.U = textView11;
        textView11.setTag(null);
        TextView textView12 = (TextView) objArr[35];
        this.V = textView12;
        textView12.setTag(null);
        TextView textView13 = (TextView) objArr[37];
        this.W = textView13;
        textView13.setTag(null);
        TextView textView14 = (TextView) objArr[38];
        this.X = textView14;
        textView14.setTag(null);
        LinearLayout linearLayout8 = (LinearLayout) objArr[39];
        this.Y = linearLayout8;
        linearLayout8.setTag(null);
        TextView textView15 = (TextView) objArr[4];
        this.Z = textView15;
        textView15.setTag(null);
        TextView textView16 = (TextView) objArr[40];
        this.a0 = textView16;
        textView16.setTag(null);
        LinearLayout linearLayout9 = (LinearLayout) objArr[41];
        this.b0 = linearLayout9;
        linearLayout9.setTag(null);
        TextView textView17 = (TextView) objArr[42];
        this.c0 = textView17;
        textView17.setTag(null);
        TextView textView18 = (TextView) objArr[43];
        this.d0 = textView18;
        textView18.setTag(null);
        LinearLayout linearLayout10 = (LinearLayout) objArr[44];
        this.e0 = linearLayout10;
        linearLayout10.setTag(null);
        TextView textView19 = (TextView) objArr[45];
        this.f0 = textView19;
        textView19.setTag(null);
        LinearLayout linearLayout11 = (LinearLayout) objArr[46];
        this.g0 = linearLayout11;
        linearLayout11.setTag(null);
        TextView textView20 = (TextView) objArr[47];
        this.h0 = textView20;
        textView20.setTag(null);
        TextView textView21 = (TextView) objArr[48];
        this.i0 = textView21;
        textView21.setTag(null);
        TextView textView22 = (TextView) objArr[5];
        this.j0 = textView22;
        textView22.setTag(null);
        TextView textView23 = (TextView) objArr[6];
        this.k0 = textView23;
        textView23.setTag(null);
        LinearLayout linearLayout12 = (LinearLayout) objArr[7];
        this.l0 = linearLayout12;
        linearLayout12.setTag(null);
        TextView textView24 = (TextView) objArr[8];
        this.m0 = textView24;
        textView24.setTag(null);
        LinearLayout linearLayout13 = (LinearLayout) objArr[9];
        this.G0 = linearLayout13;
        linearLayout13.setTag(null);
        this.f13395l.setTag(null);
        this.f13396m.setTag(null);
        this.p.setTag(null);
        this.r.setTag(null);
        this.u.setTag(null);
        this.x.setTag(null);
        this.y.setTag(null);
        this.z.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
