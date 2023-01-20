package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.ui.widget.CardImageView;

/* loaded from: classes2.dex */
public class pa extends oa {
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13335l = null;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private static final SparseIntArray f13336m = null;

    /* renamed from: k  reason: collision with root package name */
    private long f13337k;

    public pa(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f13335l, f13336m));
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.pa.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13337k != 0;
        }
    }

    @Override // e.l.k.oa
    public void i(@Nullable e.l.g.f fVar) {
        this.f13267i = fVar;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13337k = 4L;
        }
        requestRebind();
    }

    @Override // e.l.k.oa
    public void j(@Nullable GameCard gameCard) {
        this.f13268j = gameCard;
        synchronized (this) {
            this.f13337k |= 1;
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
            i((e.l.g.f) obj);
        }
        return true;
    }

    private pa(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[0], (TextView) objArr[7], (CardImageView) objArr[1], (TextView) objArr[2], (TextView) objArr[3], (TextView) objArr[5], (TextView) objArr[6], (TextView) objArr[4]);
        this.f13337k = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        this.f13261c.setTag(null);
        this.f13262d.setTag(null);
        this.f13263e.setTag(null);
        this.f13264f.setTag(null);
        this.f13265g.setTag(null);
        this.f13266h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
