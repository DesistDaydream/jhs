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
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.jihuanshe.R;
import com.jihuanshe.model.PendingProduct;
import com.jihuanshe.ui.dialog.AddCardConsignmentDialog;
import com.jihuanshe.ui.widget.CardImageView;

/* loaded from: classes2.dex */
public class h6 extends g6 {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts X = null;
    @Nullable
    private static final SparseIntArray Y;
    @NonNull
    private final ConstraintLayout E;
    @NonNull
    private final TextView F;
    @NonNull
    private final TextView G;
    @NonNull
    private final LinearLayout H;
    @NonNull
    private final ImageView I;
    @NonNull
    private final ImageView J;
    @NonNull
    private final ImageView K;
    @NonNull
    private final LinearLayout L;
    @NonNull
    private final TextView M;
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
    private long W;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        Y = sparseIntArray;
        sparseIntArray.put(R.id.divider, 34);
        sparseIntArray.put(R.id.versionTitle, 35);
        sparseIntArray.put(R.id.ll_price, 36);
        sparseIntArray.put(R.id.priceTitle, 37);
        sparseIntArray.put(R.id.yuanTv, 38);
        sparseIntArray.put(R.id.tv_avg_title, 39);
        sparseIntArray.put(R.id.tv_min_title, 40);
        sparseIntArray.put(R.id.tv_num_title, 41);
        sparseIntArray.put(R.id.tv_condition_title, 42);
        sparseIntArray.put(R.id.tv_condition_desc, 43);
        sparseIntArray.put(R.id.ll_tip, 44);
        sparseIntArray.put(R.id.divider2, 45);
        sparseIntArray.put(R.id.tv_exist_title, 46);
    }

    public h6(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 47, X, Y));
    }

    private boolean i(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.W |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean j(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.W |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean k(e.n.f<PendingProduct> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.W |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean l(e.n.f<PendingProduct> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.W |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean m(e.n.f<PendingProduct> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.W |= 8;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x04aa  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x04ba  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x04c3  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x04e8  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0500  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0509  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x05e7  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x060c  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0630  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x063c  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0660  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x066e  */
    /* JADX WARN: Removed duplicated region for block: B:275:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01cc  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 1664
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.h6.executeBindings():void");
    }

    @Override // e.l.k.g6
    public void h(@Nullable AddCardConsignmentDialog addCardConsignmentDialog) {
        this.D = addCardConsignmentDialog;
        synchronized (this) {
            this.W |= 32;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.W != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.W = 64L;
        }
        requestRebind();
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
                        return j((e.n.l) obj, i3);
                    }
                    return m((e.n.f) obj, i3);
                }
                return l((e.n.f) obj, i3);
            }
            return k((e.n.f) obj, i3);
        }
        return i((e.n.l) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            h((AddCardConsignmentDialog) obj);
            return true;
        }
        return false;
    }

    private h6(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (CardImageView) objArr[3], (View) objArr[34], (View) objArr[45], (LinearLayout) objArr[24], (LinearLayout) objArr[30], (LinearLayout) objArr[23], (LinearLayout) objArr[27], (ConstraintLayout) objArr[36], (LinearLayout) objArr[44], (LinearLayout) objArr[8], (EditText) objArr[18], (EditText) objArr[12], (TextView) objArr[37], (SwitchMaterial) objArr[22], (TextView) objArr[33], (TextView) objArr[9], (TextView) objArr[13], (TextView) objArr[39], (TextView) objArr[43], (TextView) objArr[42], (TextView) objArr[46], (TextView) objArr[10], (TextView) objArr[11], (TextView) objArr[14], (TextView) objArr[40], (TextView) objArr[41], (TextView) objArr[20], (TextView) objArr[35], (TextView) objArr[38]);
        this.W = -1L;
        this.a.setTag(null);
        this.f12715d.setTag(null);
        this.f12716e.setTag(null);
        this.f12717f.setTag(null);
        this.f12718g.setTag(null);
        this.f12721j.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.E = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.F = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[15];
        this.G = textView2;
        textView2.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[16];
        this.H = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[17];
        this.I = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) objArr[19];
        this.J = imageView2;
        imageView2.setTag(null);
        ImageView imageView3 = (ImageView) objArr[2];
        this.K = imageView3;
        imageView3.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[21];
        this.L = linearLayout2;
        linearLayout2.setTag(null);
        TextView textView3 = (TextView) objArr[25];
        this.M = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[26];
        this.N = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[28];
        this.O = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) objArr[29];
        this.P = textView6;
        textView6.setTag(null);
        TextView textView7 = (TextView) objArr[31];
        this.Q = textView7;
        textView7.setTag(null);
        TextView textView8 = (TextView) objArr[32];
        this.R = textView8;
        textView8.setTag(null);
        TextView textView9 = (TextView) objArr[4];
        this.S = textView9;
        textView9.setTag(null);
        TextView textView10 = (TextView) objArr[5];
        this.T = textView10;
        textView10.setTag(null);
        TextView textView11 = (TextView) objArr[6];
        this.U = textView11;
        textView11.setTag(null);
        TextView textView12 = (TextView) objArr[7];
        this.V = textView12;
        textView12.setTag(null);
        this.f12722k.setTag(null);
        this.f12723l.setTag(null);
        this.n.setTag(null);
        this.o.setTag(null);
        this.p.setTag(null);
        this.q.setTag(null);
        this.v.setTag(null);
        this.w.setTag(null);
        this.x.setTag(null);
        this.A.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
