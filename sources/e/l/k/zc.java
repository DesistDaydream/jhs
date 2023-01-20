package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.ui.widget.CardImageView;

/* loaded from: classes2.dex */
public class zc extends yc {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts n = null;
    @Nullable
    private static final SparseIntArray o;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final ConstraintLayout f14065h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final TextView f14066i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final TextView f14067j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final TextView f14068k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private final TextView f14069l;

    /* renamed from: m  reason: collision with root package name */
    private long f14070m;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        o = sparseIntArray;
        sparseIntArray.put(R.id.ll_vision, 8);
        sparseIntArray.put(R.id.llPrice, 9);
    }

    public zc(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, n, o));
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0156  */
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
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.zc.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14070m != 0;
        }
    }

    @Override // e.l.k.yc
    public void i(@Nullable e.l.g.u0 u0Var) {
        this.f14001f = u0Var;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14070m = 4L;
        }
        requestRebind();
    }

    @Override // e.l.k.yc
    public void j(@Nullable GameCard gameCard) {
        this.f14002g = gameCard;
        synchronized (this) {
            this.f14070m |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (8 == i2) {
            j((GameCard) obj);
        } else if (2 != i2) {
            return false;
        } else {
            i((e.l.g.u0) obj);
        }
        return true;
    }

    private zc(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CardImageView) objArr[1], (LinearLayout) objArr[9], (LinearLayout) objArr[8], (TextView) objArr[2], (TextView) objArr[6]);
        this.f14070m = -1L;
        this.a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f14065h = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.f14066i = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[4];
        this.f14067j = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[5];
        this.f14068k = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[7];
        this.f14069l = textView4;
        textView4.setTag(null);
        this.f13999d.setTag(null);
        this.f14000e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
