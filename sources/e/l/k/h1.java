package e.l.k;

import android.net.Uri;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.login.LoginActivity;
import com.jihuanshe.ui.widget.VerifyView;
import com.jihuanshe.viewmodel.login.LoginViewModel;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public class h1 extends g1 {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts J = null;
    @Nullable
    private static final SparseIntArray K;
    @NonNull
    private final ConstraintLayout A;
    @NonNull
    private final ConstraintLayout B;
    @NonNull
    private final TextView C;
    @NonNull
    private final ConstraintLayout D;
    @NonNull
    private final ConstraintLayout E;
    @NonNull
    private final CheckBox F;
    @NonNull
    private final ConstraintLayout G;
    @NonNull
    private final TextView H;
    private long I;
    @NonNull
    private final FrameLayout z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        K = sparseIntArray;
        sparseIntArray.put(R.id.countryLayout, 17);
        sparseIntArray.put(R.id.phoneLayout, 18);
        sparseIntArray.put(R.id.tv_tip, 19);
        sparseIntArray.put(R.id.iv, 20);
        sparseIntArray.put(R.id.inputTv, 21);
        sparseIntArray.put(R.id.updateTitle, 22);
        sparseIntArray.put(R.id.nameEt, 23);
        sparseIntArray.put(R.id.bindIv, 24);
        sparseIntArray.put(R.id.bindPhoneTv, 25);
        sparseIntArray.put(R.id.bindPhoneSubTv, 26);
        sparseIntArray.put(R.id.bindCountryLayout, 27);
        sparseIntArray.put(R.id.bindPhoneEt, 28);
        sparseIntArray.put(R.id.bindSucIv, 29);
        sparseIntArray.put(R.id.bindSucTv, 30);
        sparseIntArray.put(R.id.bindSucTv2, 31);
    }

    public h1(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 32, J, K));
    }

    private boolean k(e.n.f<Uri> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.I |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean l(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.I |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean m(e.n.p pVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.I |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean n(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.I |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean o(e.n.p pVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.I |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean p(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.I |= 32;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:187:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0186  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 847
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.h1.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.I != 0;
        }
    }

    @Override // e.l.k.g1
    public void i(@Nullable LoginActivity loginActivity) {
        this.x = loginActivity;
        synchronized (this) {
            this.I |= 64;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.I = 256L;
        }
        requestRebind();
    }

    @Override // e.l.k.g1
    public void j(@Nullable LoginViewModel loginViewModel) {
        this.y = loginViewModel;
        synchronized (this) {
            this.I |= 128;
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
                            return p((e.n.l) obj, i3);
                        }
                        return k((e.n.f) obj, i3);
                    }
                    return n((e.n.i) obj, i3);
                }
                return o((e.n.p) obj, i3);
            }
            return l((e.n.i) obj, i3);
        }
        return m((e.n.p) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((LoginActivity) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((LoginViewModel) obj);
        }
        return true;
    }

    private h1(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (NImageView) objArr[11], (LinearLayout) objArr[27], (ImageView) objArr[24], (EditText) objArr[28], (TextView) objArr[26], (TextView) objArr[25], (TextView) objArr[16], (ImageView) objArr[29], (TextView) objArr[30], (TextView) objArr[31], (TextView) objArr[14], (VerifyView) objArr[8], (LinearLayout) objArr[17], (TextView) objArr[21], (ImageView) objArr[20], (EditText) objArr[23], (EditText) objArr[18], (TextView) objArr[7], (LinearLayout) objArr[2], (TextView) objArr[19], (TextView) objArr[4], (TextView) objArr[22], (ImageView) objArr[5]);
        this.I = -1L;
        this.a.setTag(null);
        this.f12690g.setTag(null);
        this.f12694k.setTag(null);
        this.f12695l.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.z = frameLayout;
        frameLayout.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[1];
        this.A = constraintLayout;
        constraintLayout.setTag(null);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) objArr[10];
        this.B = constraintLayout2;
        constraintLayout2.setTag(null);
        TextView textView = (TextView) objArr[12];
        this.C = textView;
        textView.setTag(null);
        ConstraintLayout constraintLayout3 = (ConstraintLayout) objArr[13];
        this.D = constraintLayout3;
        constraintLayout3.setTag(null);
        ConstraintLayout constraintLayout4 = (ConstraintLayout) objArr[15];
        this.E = constraintLayout4;
        constraintLayout4.setTag(null);
        CheckBox checkBox = (CheckBox) objArr[3];
        this.F = checkBox;
        checkBox.setTag(null);
        ConstraintLayout constraintLayout5 = (ConstraintLayout) objArr[6];
        this.G = constraintLayout5;
        constraintLayout5.setTag(null);
        TextView textView2 = (TextView) objArr[9];
        this.H = textView2;
        textView2.setTag(null);
        this.r.setTag(null);
        this.s.setTag(null);
        this.u.setTag(null);
        this.w.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
