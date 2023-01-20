package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.eth.model.NLive;
import com.jihuanshe.R;
import com.jihuanshe.model.OrderReturnDetail;
import com.jihuanshe.model.OrderReturnInfo;
import com.jihuanshe.ui.page.entrepot.SubmitOrderReturnActivity;
import com.jihuanshe.viewmodel.entrepot.SubmitOrderReturnViewModel;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class x2 extends w2 {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts x = null;
    @Nullable
    private static final SparseIntArray y;
    @NonNull
    private final ConstraintLayout s;
    @NonNull
    private final TextView t;
    @NonNull
    private final TextView u;
    @NonNull
    private final TextView v;
    private long w;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        y = sparseIntArray;
        sparseIntArray.put(R.id.cl_address, 11);
        sparseIntArray.put(R.id.tv_address_title, 12);
        sparseIntArray.put(R.id.iv_location, 13);
        sparseIntArray.put(R.id.tv_title, 14);
        sparseIntArray.put(R.id.tv_num, 15);
        sparseIntArray.put(R.id.tv_time, 16);
        sparseIntArray.put(R.id.cl, 17);
        sparseIntArray.put(R.id.tv, 18);
        sparseIntArray.put(R.id.tvShippingTip, 19);
    }

    public x2(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 20, x, y));
    }

    private boolean k(NLive<List<OrderReturnInfo>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.w |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean l(NLive<OrderReturnDetail> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.w |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean m(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.w |= 2;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.x2.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.w != 0;
        }
    }

    @Override // e.l.k.w2
    public void i(@Nullable SubmitOrderReturnActivity submitOrderReturnActivity) {
        this.q = submitOrderReturnActivity;
        synchronized (this) {
            this.w |= 8;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.w = 32L;
        }
        requestRebind();
    }

    @Override // e.l.k.w2
    public void j(@Nullable SubmitOrderReturnViewModel submitOrderReturnViewModel) {
        this.r = submitOrderReturnViewModel;
        synchronized (this) {
            this.w |= 16;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    return false;
                }
                return k((NLive) obj, i3);
            }
            return m((e.n.l) obj, i3);
        }
        return l((NLive) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((SubmitOrderReturnActivity) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((SubmitOrderReturnViewModel) obj);
        }
        return true;
    }

    private x2(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (ConstraintLayout) objArr[17], (ConstraintLayout) objArr[11], (ImageView) objArr[13], (ListView) objArr[7], (TextView) objArr[18], (TextView) objArr[3], (TextView) objArr[12], (TextView) objArr[1], (TextView) objArr[6], (TextView) objArr[15], (TextView) objArr[2], (TextView) objArr[9], (TextView) objArr[19], (TextView) objArr[10], (TextView) objArr[16], (TextView) objArr[14]);
        this.w = -1L;
        this.f13805d.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.s = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.t = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[5];
        this.u = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[8];
        this.v = textView3;
        textView3.setTag(null);
        this.f13807f.setTag(null);
        this.f13809h.setTag(null);
        this.f13810i.setTag(null);
        this.f13812k.setTag(null);
        this.f13813l.setTag(null);
        this.n.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
