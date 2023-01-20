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
import com.eth.model.NLive;
import com.jihuanshe.R;
import com.jihuanshe.model.UserAddress;
import com.jihuanshe.ui.page.order.OrderConfirmActivity;
import com.jihuanshe.ui.widget.NoScrollListView;
import com.jihuanshe.viewmodel.order.OrderConfirmViewModel;

/* loaded from: classes2.dex */
public class p1 extends o1 {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts y = null;
    @Nullable
    private static final SparseIntArray z;
    @NonNull
    private final ConstraintLayout t;
    @NonNull
    private final TextView u;
    @NonNull
    private final TextView v;
    @NonNull
    private final TextView w;
    private long x;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        z = sparseIntArray;
        sparseIntArray.put(R.id.locationIv, 10);
        sparseIntArray.put(R.id.arrowIv1, 11);
        sparseIntArray.put(R.id.productInfoLayout, 12);
        sparseIntArray.put(R.id.titleTv, 13);
        sparseIntArray.put(R.id.divider, 14);
        sparseIntArray.put(R.id.extraLayout, 15);
        sparseIntArray.put(R.id.titleTv2, 16);
        sparseIntArray.put(R.id.divider2, 17);
        sparseIntArray.put(R.id.psTv, 18);
        sparseIntArray.put(R.id.et, 19);
        sparseIntArray.put(R.id.shopCard, 20);
    }

    public p1(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 21, y, z));
    }

    private boolean k(NLive<UserAddress> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.x |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean l(e.n.f<e.l.n.c.n> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.x |= 2;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:138:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 519
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.p1.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.x != 0;
        }
    }

    @Override // e.l.k.o1
    public void i(@Nullable OrderConfirmActivity orderConfirmActivity) {
        this.r = orderConfirmActivity;
        synchronized (this) {
            this.x |= 4;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.x = 16L;
        }
        requestRebind();
    }

    @Override // e.l.k.o1
    public void j(@Nullable OrderConfirmViewModel orderConfirmViewModel) {
        this.s = orderConfirmViewModel;
        synchronized (this) {
            this.x |= 8;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            if (i2 != 1) {
                return false;
            }
            return l((e.n.f) obj, i3);
        }
        return k((NLive) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((OrderConfirmActivity) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((OrderConfirmViewModel) obj);
        }
        return true;
    }

    private p1(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (ImageView) objArr[11], (TextView) objArr[7], (View) objArr[14], (View) objArr[17], (EditText) objArr[19], (ConstraintLayout) objArr[15], (ConstraintLayout) objArr[1], (ImageView) objArr[10], (TextView) objArr[2], (TextView) objArr[3], (ConstraintLayout) objArr[12], (TextView) objArr[18], (NoScrollListView) objArr[6], (TextView) objArr[8], (LinearLayout) objArr[20], (TextView) objArr[13], (TextView) objArr[16]);
        this.x = -1L;
        this.b.setTag(null);
        this.f13239g.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.t = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.u = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[5];
        this.v = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[9];
        this.w = textView3;
        textView3.setTag(null);
        this.f13241i.setTag(null);
        this.f13242j.setTag(null);
        this.f13245m.setTag(null);
        this.n.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
