package e.l.k;

import android.graphics.Bitmap;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
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
import com.caverock.androidsvg.SVG;
import com.eth.model.NLive;
import com.jihuanshe.R;
import com.jihuanshe.model.BankDetail;
import com.jihuanshe.model.ConfirmState;
import com.jihuanshe.model.UseBank;
import com.jihuanshe.ui.page.shop.SellerConfirmActivity;
import com.jihuanshe.viewmodel.shop.SellerConfirmViewModel;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public class h2 extends g2 {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts i0 = null;
    @Nullable
    private static final SparseIntArray j0;
    @NonNull
    private final FrameLayout O;
    @NonNull
    private final NImageView P;
    @NonNull
    private final TextView Q;
    @NonNull
    private final LinearLayout R;
    @NonNull
    private final LinearLayout S;
    @NonNull
    private final LinearLayout T;
    @NonNull
    private final LinearLayout U;
    @NonNull
    private final TextView V;
    @NonNull
    private final LinearLayout W;
    @NonNull
    private final TextView X;
    @NonNull
    private final TextView Y;
    @NonNull
    private final ConstraintLayout Z;
    @NonNull
    private final TextView a0;
    @NonNull
    private final TextView b0;
    @NonNull
    private final LinearLayout c0;
    @NonNull
    private final ImageView d0;
    @NonNull
    private final TextView e0;
    @NonNull
    private final NImageView f0;
    @NonNull
    private final TextView g0;
    private long h0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        j0 = sparseIntArray;
        sparseIntArray.put(R.id.tipsTv, 34);
        sparseIntArray.put(R.id.userInfoTitle, 35);
        sparseIntArray.put(R.id.nameTitle, 36);
        sparseIntArray.put(R.id.phoneTitle, 37);
        sparseIntArray.put(R.id.codeTitle, 38);
        sparseIntArray.put(R.id.dateStartTitle, 39);
        sparseIntArray.put(R.id.dateTitle, 40);
        sparseIntArray.put(R.id.nameEt, 41);
        sparseIntArray.put(R.id.phoneEt, 42);
        sparseIntArray.put(R.id.codeEt, 43);
        sparseIntArray.put(R.id.rb1, 44);
        sparseIntArray.put(R.id.rb2, 45);
        sparseIntArray.put(R.id.foreImgTv, 46);
        sparseIntArray.put(R.id.bankTitle, 47);
        sparseIntArray.put(R.id.useBankTitle, 48);
        sparseIntArray.put(R.id.useBankLocationTitle, 49);
        sparseIntArray.put(R.id.useBankAccountTitle, 50);
        sparseIntArray.put(R.id.useBankAccountEt, 51);
        sparseIntArray.put(R.id.bankTitle2, 52);
        sparseIntArray.put(R.id.useBankTitle2, 53);
        sparseIntArray.put(R.id.useBankLocationTitle2, 54);
        sparseIntArray.put(R.id.useBankAccountTitle2, 55);
        sparseIntArray.put(R.id.useBankAccountEt2, 56);
    }

    public h2(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 57, i0, j0));
    }

    private boolean k(e.n.f<String> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.h0 |= 64;
            }
            return true;
        }
        return false;
    }

    private boolean l(e.n.f<Integer> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.h0 |= 1024;
            }
            return true;
        }
        return false;
    }

    private boolean m(e.n.f<BankDetail> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.h0 |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean n(e.n.p pVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.h0 |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean o(e.n.f<String> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.h0 |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean p(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.h0 |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean q(e.n.p pVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.h0 |= 256;
            }
            return true;
        }
        return false;
    }

    private boolean r(e.n.f<Bitmap> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.h0 |= 512;
            }
            return true;
        }
        return false;
    }

    private boolean s(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.h0 |= 32;
            }
            return true;
        }
        return false;
    }

    private boolean t(NLive<ConfirmState> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.h0 |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean u(NLive<UseBank> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.h0 |= 128;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0198  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 1518
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.h2.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.h0 != 0;
        }
    }

    @Override // e.l.k.g2
    public void i(@Nullable SellerConfirmActivity sellerConfirmActivity) {
        this.M = sellerConfirmActivity;
        synchronized (this) {
            this.h0 |= 2048;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.h0 = SVG.A;
        }
        requestRebind();
    }

    @Override // e.l.k.g2
    public void j(@Nullable SellerConfirmViewModel sellerConfirmViewModel) {
        this.N = sellerConfirmViewModel;
        synchronized (this) {
            this.h0 |= 4096;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return t((NLive) obj, i3);
            case 1:
                return m((e.n.f) obj, i3);
            case 2:
                return p((e.n.i) obj, i3);
            case 3:
                return o((e.n.f) obj, i3);
            case 4:
                return n((e.n.p) obj, i3);
            case 5:
                return s((e.n.i) obj, i3);
            case 6:
                return k((e.n.f) obj, i3);
            case 7:
                return u((NLive) obj, i3);
            case 8:
                return q((e.n.p) obj, i3);
            case 9:
                return r((e.n.f) obj, i3);
            case 10:
                return l((e.n.f) obj, i3);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((SellerConfirmActivity) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((SellerConfirmViewModel) obj);
        }
        return true;
    }

    private h2(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 11, (TextView) objArr[47], (TextView) objArr[52], (CheckBox) objArr[15], (EditText) objArr[43], (TextView) objArr[38], (TextView) objArr[4], (TextView) objArr[2], (TextView) objArr[39], (TextView) objArr[40], (TextView) objArr[46], (FrameLayout) objArr[5], (FrameLayout) objArr[8], (EditText) objArr[41], (TextView) objArr[36], (FrameLayout) objArr[1], (EditText) objArr[42], (TextView) objArr[37], (RadioButton) objArr[44], (RadioButton) objArr[45], (TextView) objArr[34], (RadioGroup) objArr[3], (EditText) objArr[51], (EditText) objArr[56], (TextView) objArr[50], (TextView) objArr[55], (TextView) objArr[14], (TextView) objArr[29], (TextView) objArr[49], (TextView) objArr[54], (TextView) objArr[13], (TextView) objArr[28], (TextView) objArr[11], (TextView) objArr[26], (TextView) objArr[48], (TextView) objArr[53], (TextView) objArr[12], (TextView) objArr[27], (TextView) objArr[35]);
        this.h0 = -1L;
        this.f12697c.setTag(null);
        this.f12700f.setTag(null);
        this.f12701g.setTag(null);
        this.f12705k.setTag(null);
        this.f12706l.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.O = frameLayout;
        frameLayout.setTag(null);
        NImageView nImageView = (NImageView) objArr[10];
        this.P = nImageView;
        nImageView.setTag(null);
        TextView textView = (TextView) objArr[16];
        this.Q = textView;
        textView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[17];
        this.R = linearLayout;
        linearLayout.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[18];
        this.S = linearLayout2;
        linearLayout2.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) objArr[19];
        this.T = linearLayout3;
        linearLayout3.setTag(null);
        LinearLayout linearLayout4 = (LinearLayout) objArr[20];
        this.U = linearLayout4;
        linearLayout4.setTag(null);
        TextView textView2 = (TextView) objArr[21];
        this.V = textView2;
        textView2.setTag(null);
        LinearLayout linearLayout5 = (LinearLayout) objArr[22];
        this.W = linearLayout5;
        linearLayout5.setTag(null);
        TextView textView3 = (TextView) objArr[23];
        this.X = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[24];
        this.Y = textView4;
        textView4.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[25];
        this.Z = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView5 = (TextView) objArr[30];
        this.a0 = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) objArr[31];
        this.b0 = textView6;
        textView6.setTag(null);
        LinearLayout linearLayout6 = (LinearLayout) objArr[32];
        this.c0 = linearLayout6;
        linearLayout6.setTag(null);
        ImageView imageView = (ImageView) objArr[33];
        this.d0 = imageView;
        imageView.setTag(null);
        TextView textView7 = (TextView) objArr[6];
        this.e0 = textView7;
        textView7.setTag(null);
        NImageView nImageView2 = (NImageView) objArr[7];
        this.f0 = nImageView2;
        nImageView2.setTag(null);
        TextView textView8 = (TextView) objArr[9];
        this.g0 = textView8;
        textView8.setTag(null);
        this.o.setTag(null);
        this.u.setTag(null);
        this.z.setTag(null);
        this.A.setTag(null);
        this.D.setTag(null);
        this.E.setTag(null);
        this.F.setTag(null);
        this.G.setTag(null);
        this.J.setTag(null);
        this.K.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
