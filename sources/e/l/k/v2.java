package e.l.k;

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
import com.jihuanshe.model.WareCache;
import com.jihuanshe.ui.page.entrepot.SubmitOrderActivity;
import com.jihuanshe.viewmodel.entrepot.SubmitOrderViewModel;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public class v2 extends u2 {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts F = null;
    @Nullable
    private static final SparseIntArray G;
    @NonNull
    private final ImageView A;
    @NonNull
    private final FrameLayout B;
    @NonNull
    private final CheckBox C;
    @NonNull
    private final LinearLayout D;
    private long E;
    @NonNull
    private final ConstraintLayout z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        G = sparseIntArray;
        sparseIntArray.put(R.id.cl_top, 13);
        sparseIntArray.put(R.id.tv_title, 14);
        sparseIntArray.put(R.id.tv_address_title, 15);
        sparseIntArray.put(R.id.tv_recipient_title, 16);
        sparseIntArray.put(R.id.tv_phone_title, 17);
        sparseIntArray.put(R.id.cl_bot, 18);
        sparseIntArray.put(R.id.tv_Logistics_title, 19);
        sparseIntArray.put(R.id.ll_top, 20);
        sparseIntArray.put(R.id.tv_express_title, 21);
        sparseIntArray.put(R.id.ll_center, 22);
        sparseIntArray.put(R.id.tv_express_num, 23);
        sparseIntArray.put(R.id.ll_bot, 24);
        sparseIntArray.put(R.id.tv_photo, 25);
        sparseIntArray.put(R.id.iv, 26);
        sparseIntArray.put(R.id.tv, 27);
    }

    public v2(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 28, F, G));
    }

    private boolean k(e.n.f<WareCache> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.E |= 1;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 319
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.v2.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.E != 0;
        }
    }

    @Override // e.l.k.u2
    public void i(@Nullable SubmitOrderActivity submitOrderActivity) {
        this.x = submitOrderActivity;
        synchronized (this) {
            this.E |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.E = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.u2
    public void j(@Nullable SubmitOrderViewModel submitOrderViewModel) {
        this.y = submitOrderViewModel;
        synchronized (this) {
            this.E |= 4;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return k((e.n.f) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((SubmitOrderActivity) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((SubmitOrderViewModel) obj);
        }
        return true;
    }

    private v2(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ConstraintLayout) objArr[18], (ConstraintLayout) objArr[13], (NImageView) objArr[9], (EditText) objArr[6], (ImageView) objArr[26], (ConstraintLayout) objArr[7], (LinearLayout) objArr[24], (LinearLayout) objArr[22], (LinearLayout) objArr[20], (TextView) objArr[27], (TextView) objArr[2], (TextView) objArr[15], (TextView) objArr[23], (TextView) objArr[21], (TextView) objArr[19], (TextView) objArr[4], (TextView) objArr[17], (TextView) objArr[25], (TextView) objArr[3], (TextView) objArr[16], (TextView) objArr[5], (TextView) objArr[12], (TextView) objArr[14]);
        this.E = -1L;
        this.f13673c.setTag(null);
        this.f13674d.setTag(null);
        this.f13676f.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.z = constraintLayout;
        constraintLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.A = imageView;
        imageView.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[10];
        this.B = frameLayout;
        frameLayout.setTag(null);
        CheckBox checkBox = (CheckBox) objArr[11];
        this.C = checkBox;
        checkBox.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[8];
        this.D = linearLayout;
        linearLayout.setTag(null);
        this.f13681k.setTag(null);
        this.p.setTag(null);
        this.s.setTag(null);
        this.u.setTag(null);
        this.v.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
