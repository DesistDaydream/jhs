package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.BankDetail;
import com.jihuanshe.ui.page.user.ShopOwnerConfirmActivity;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public class r2 extends q2 {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts K = null;
    @Nullable
    private static final SparseIntArray L;
    @NonNull
    private final ScrollView A;
    @NonNull
    private final TextView B;
    @NonNull
    private final NImageView C;
    @NonNull
    private final TextView D;
    @NonNull
    private final NImageView E;
    @NonNull
    private final TextView F;
    @NonNull
    private final LinearLayout G;
    @NonNull
    private final TextView H;
    @NonNull
    private final NImageView I;
    private long J;
    @NonNull
    private final FrameLayout z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        L = sparseIntArray;
        sparseIntArray.put(R.id.tipsTv, 18);
        sparseIntArray.put(R.id.ownerInfoTitle, 19);
        sparseIntArray.put(R.id.nameTitle, 20);
        sparseIntArray.put(R.id.phoneTitle, 21);
        sparseIntArray.put(R.id.mailTitle, 22);
        sparseIntArray.put(R.id.nameEt, 23);
        sparseIntArray.put(R.id.phoneEt, 24);
        sparseIntArray.put(R.id.mailEt, 25);
        sparseIntArray.put(R.id.bankTitle, 26);
        sparseIntArray.put(R.id.useBankTitle, 27);
        sparseIntArray.put(R.id.useBankBranchTitle, 28);
        sparseIntArray.put(R.id.useBankAccountTitle, 29);
        sparseIntArray.put(R.id.useBankAccountEt, 30);
        sparseIntArray.put(R.id.licenseImgTv, 31);
        sparseIntArray.put(R.id.foreImgTv, 32);
    }

    public r2(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 33, K, L));
    }

    private boolean k(e.n.f<String> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.J |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean l(e.n.f<BankDetail> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.J |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean m(e.n.p pVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.J |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean n(e.n.f<String> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.J |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean o(e.n.p pVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.J |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean p(e.n.p pVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.J |= 64;
            }
            return true;
        }
        return false;
    }

    private boolean q(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.J |= 32;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0174  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 916
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.r2.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.J != 0;
        }
    }

    @Override // e.l.k.q2
    public void i(@Nullable ShopOwnerConfirmActivity shopOwnerConfirmActivity) {
        this.x = shopOwnerConfirmActivity;
        synchronized (this) {
            this.J |= 128;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.J = 512L;
        }
        requestRebind();
    }

    @Override // e.l.k.q2
    public void j(@Nullable e.l.s.o.b bVar) {
        this.y = bVar;
        synchronized (this) {
            this.J |= 256;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return o((e.n.p) obj, i3);
            case 1:
                return k((e.n.f) obj, i3);
            case 2:
                return l((e.n.f) obj, i3);
            case 3:
                return n((e.n.f) obj, i3);
            case 4:
                return m((e.n.p) obj, i3);
            case 5:
                return q((e.n.i) obj, i3);
            case 6:
                return p((e.n.p) obj, i3);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((ShopOwnerConfirmActivity) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((e.l.s.o.b) obj);
        }
        return true;
    }

    private r2(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 7, (TextView) objArr[26], (CheckBox) objArr[15], (TextView) objArr[32], (FrameLayout) objArr[9], (FrameLayout) objArr[12], (TextView) objArr[31], (FrameLayout) objArr[6], (EditText) objArr[25], (TextView) objArr[22], (EditText) objArr[23], (TextView) objArr[20], (TextView) objArr[19], (EditText) objArr[24], (TextView) objArr[21], (TextView) objArr[18], (EditText) objArr[30], (TextView) objArr[29], (TextView) objArr[28], (EditText) objArr[5], (TextView) objArr[4], (TextView) objArr[2], (TextView) objArr[27], (TextView) objArr[3]);
        this.J = -1L;
        this.b.setTag(null);
        this.f13398d.setTag(null);
        this.f13399e.setTag(null);
        this.f13401g.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.z = frameLayout;
        frameLayout.setTag(null);
        ScrollView scrollView = (ScrollView) objArr[1];
        this.A = scrollView;
        scrollView.setTag(null);
        TextView textView = (TextView) objArr[10];
        this.B = textView;
        textView.setTag(null);
        NImageView nImageView = (NImageView) objArr[11];
        this.C = nImageView;
        nImageView.setTag(null);
        TextView textView2 = (TextView) objArr[13];
        this.D = textView2;
        textView2.setTag(null);
        NImageView nImageView2 = (NImageView) objArr[14];
        this.E = nImageView2;
        nImageView2.setTag(null);
        TextView textView3 = (TextView) objArr[16];
        this.F = textView3;
        textView3.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[17];
        this.G = linearLayout;
        linearLayout.setTag(null);
        TextView textView4 = (TextView) objArr[7];
        this.H = textView4;
        textView4.setTag(null);
        NImageView nImageView3 = (NImageView) objArr[8];
        this.I = nImageView3;
        nImageView3.setTag(null);
        this.s.setTag(null);
        this.t.setTag(null);
        this.u.setTag(null);
        this.w.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
