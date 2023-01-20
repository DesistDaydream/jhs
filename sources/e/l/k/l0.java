package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
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
import com.jihuanshe.ui.page.user.edit.EditPhoneNumberActivity;
import com.jihuanshe.ui.widget.VerifyView;
import com.jihuanshe.viewmodel.user.edit.EditPhoneNumberViewModel;

/* loaded from: classes2.dex */
public class l0 extends k0 {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts s = null;
    @Nullable
    private static final SparseIntArray t;
    @NonNull
    private final FrameLayout n;
    @NonNull
    private final ConstraintLayout o;
    @NonNull
    private final TextView p;
    @NonNull
    private final ConstraintLayout q;
    private long r;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        t = sparseIntArray;
        sparseIntArray.put(R.id.bindIv, 11);
        sparseIntArray.put(R.id.bindSucIv, 12);
        sparseIntArray.put(R.id.bindSucTv, 13);
        sparseIntArray.put(R.id.bindSucTv2, 14);
    }

    public l0(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 15, s, t));
    }

    private boolean k(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.r |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean l(e.n.p pVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.r |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean m(e.n.p pVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.r |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean n(e.n.p pVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.r |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean o(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.r |= 16;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:167:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x016d  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 623
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.l0.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.r != 0;
        }
    }

    @Override // e.l.k.k0
    public void i(@Nullable EditPhoneNumberActivity editPhoneNumberActivity) {
        this.f12975l = editPhoneNumberActivity;
        synchronized (this) {
            this.r |= 32;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.r = 128L;
        }
        requestRebind();
    }

    @Override // e.l.k.k0
    public void j(@Nullable EditPhoneNumberViewModel editPhoneNumberViewModel) {
        this.f12976m = editPhoneNumberViewModel;
        synchronized (this) {
            this.r |= 64;
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
                    return k((e.n.i) obj, i3);
                }
                return l((e.n.p) obj, i3);
            }
            return n((e.n.p) obj, i3);
        }
        return m((e.n.p) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((EditPhoneNumberActivity) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((EditPhoneNumberViewModel) obj);
        }
        return true;
    }

    private l0(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (LinearLayout) objArr[4], (ImageView) objArr[11], (EditText) objArr[5], (TextView) objArr[3], (TextView) objArr[2], (TextView) objArr[10], (ImageView) objArr[12], (TextView) objArr[13], (TextView) objArr[14], (TextView) objArr[8], (VerifyView) objArr[6]);
        this.r = -1L;
        this.a.setTag(null);
        this.f12966c.setTag(null);
        this.f12967d.setTag(null);
        this.f12968e.setTag(null);
        this.f12969f.setTag(null);
        this.f12973j.setTag(null);
        this.f12974k.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.n = frameLayout;
        frameLayout.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[1];
        this.o = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[7];
        this.p = textView;
        textView.setTag(null);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) objArr[9];
        this.q = constraintLayout2;
        constraintLayout2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
