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
import com.jihuanshe.ui.dialog.SoldOutCardDialog;
import com.jihuanshe.ui.widget.CardImageView;

/* loaded from: classes2.dex */
public class x5 extends w5 {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts M = null;
    @Nullable
    private static final SparseIntArray N;
    @NonNull
    private final ConstraintLayout A;
    @NonNull
    private final TextView B;
    @NonNull
    private final ImageView C;
    @NonNull
    private final ImageView D;
    @NonNull
    private final TextView E;
    @NonNull
    private final TextView F;
    @NonNull
    private final ImageView G;
    @NonNull
    private final TextView H;
    @NonNull
    private final TextView I;
    @NonNull
    private final TextView J;
    @NonNull
    private final TextView K;
    private long L;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        N = sparseIntArray;
        sparseIntArray.put(R.id.divider, 21);
        sparseIntArray.put(R.id.rarityTitle, 22);
        sparseIntArray.put(R.id.divider2, 23);
        sparseIntArray.put(R.id.countTitle, 24);
        sparseIntArray.put(R.id.countDesc, 25);
        sparseIntArray.put(R.id.adder, 26);
        sparseIntArray.put(R.id.divider3, 27);
        sparseIntArray.put(R.id.priceTitle, 28);
        sparseIntArray.put(R.id.minPriceTv, 29);
        sparseIntArray.put(R.id.avgPriceTv, 30);
        sparseIntArray.put(R.id.yuanTv, 31);
        sparseIntArray.put(R.id.divider4, 32);
        sparseIntArray.put(R.id.remarkTv, 33);
        sparseIntArray.put(R.id.divider5, 34);
        sparseIntArray.put(R.id.ll, 35);
    }

    public x5(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 36, M, N));
    }

    private boolean i(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.L |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean j(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.L |= 2;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x016c  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 688
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.x5.executeBindings():void");
    }

    @Override // e.l.k.w5
    public void h(@Nullable SoldOutCardDialog soldOutCardDialog) {
        this.z = soldOutCardDialog;
        synchronized (this) {
            this.L |= 4;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.L != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.L = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            if (i2 != 1) {
                return false;
            }
            return j((e.n.l) obj, i3);
        }
        return i((e.n.l) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            h((SoldOutCardDialog) obj);
            return true;
        }
        return false;
    }

    private x5(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (LinearLayout) objArr[26], (TextView) objArr[30], (TextView) objArr[25], (TextView) objArr[24], (CardImageView) objArr[3], (View) objArr[21], (View) objArr[23], (View) objArr[27], (View) objArr[32], (View) objArr[34], (LinearLayout) objArr[35], (TextView) objArr[29], (EditText) objArr[13], (EditText) objArr[17], (TextView) objArr[28], (TextView) objArr[8], (TextView) objArr[9], (TextView) objArr[10], (TextView) objArr[11], (TextView) objArr[22], (EditText) objArr[18], (TextView) objArr[33], (SwitchMaterial) objArr[19], (TextView) objArr[20], (TextView) objArr[31]);
        this.L = -1L;
        this.f13831e.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.A = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.B = textView;
        textView.setTag(null);
        ImageView imageView = (ImageView) objArr[12];
        this.C = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) objArr[14];
        this.D = imageView2;
        imageView2.setTag(null);
        TextView textView2 = (TextView) objArr[15];
        this.E = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[16];
        this.F = textView3;
        textView3.setTag(null);
        ImageView imageView3 = (ImageView) objArr[2];
        this.G = imageView3;
        imageView3.setTag(null);
        TextView textView4 = (TextView) objArr[4];
        this.H = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[5];
        this.I = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) objArr[6];
        this.J = textView6;
        textView6.setTag(null);
        TextView textView7 = (TextView) objArr[7];
        this.K = textView7;
        textView7.setTag(null);
        this.f13839m.setTag(null);
        this.n.setTag(null);
        this.p.setTag(null);
        this.q.setTag(null);
        this.r.setTag(null);
        this.s.setTag(null);
        this.u.setTag(null);
        this.w.setTag(null);
        this.x.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
