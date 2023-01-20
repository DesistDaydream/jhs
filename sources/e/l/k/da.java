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
import com.jihuanshe.model.GameCard;
import com.jihuanshe.ui.widget.CardImageView;
import com.jihuanshe.ui.widget.PriceTextView;

/* loaded from: classes2.dex */
public class da extends ca {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts q = null;
    @Nullable
    private static final SparseIntArray r = null;
    @NonNull
    private final ConstraintLayout n;
    @NonNull
    private final TextView o;
    private long p;

    public da(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 12, q, r));
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:210:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01a1  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 824
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.da.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.p != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.p = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.ca
    public void j(@Nullable e.l.g.o0 o0Var) {
        this.f12423k = o0Var;
        synchronized (this) {
            this.p |= 4;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // e.l.k.ca
    public void k(@Nullable GameCard gameCard) {
        this.f12424l = gameCard;
        synchronized (this) {
            this.p |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // e.l.k.ca
    public void l(@Nullable Integer num) {
        this.f12425m = num;
        synchronized (this) {
            this.p |= 2;
        }
        notifyPropertyChanged(11);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (8 == i2) {
            k((GameCard) obj);
        } else if (11 == i2) {
            l((Integer) obj);
        } else if (2 != i2) {
            return false;
        } else {
            j((e.l.g.o0) obj);
        }
        return true;
    }

    private da(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (TextView) objArr[7], (TextView) objArr[10], (CardImageView) objArr[2], (ImageView) objArr[4], (View) objArr[8], (ImageView) objArr[5], (TextView) objArr[3], (PriceTextView) objArr[6], (TextView) objArr[9]);
        this.p = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        this.f12415c.setTag(null);
        this.f12416d.setTag(null);
        this.f12417e.setTag(null);
        this.f12418f.setTag(null);
        this.f12419g.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.n = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[11];
        this.o = textView;
        textView.setTag(null);
        this.f12420h.setTag(null);
        this.f12421i.setTag(null);
        this.f12422j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
