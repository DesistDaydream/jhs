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
public class ra extends qa {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts o = null;
    @Nullable
    private static final SparseIntArray p;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final ConstraintLayout f13488i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final TextView f13489j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final TextView f13490k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private final TextView f13491l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    private final TextView f13492m;
    private long n;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p = sparseIntArray;
        sparseIntArray.put(R.id.ll_vision, 9);
        sparseIntArray.put(R.id.llPrice, 10);
    }

    public ra(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, o, p));
    }

    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x015d  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 439
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.ra.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.n != 0;
        }
    }

    @Override // e.l.k.qa
    public void i(@Nullable e.l.g.g gVar) {
        this.f13429g = gVar;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.n = 4L;
        }
        requestRebind();
    }

    @Override // e.l.k.qa
    public void j(@Nullable GameCard gameCard) {
        this.f13430h = gameCard;
        synchronized (this) {
            this.n |= 1;
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
            i((e.l.g.g) obj);
        }
        return true;
    }

    private ra(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CardImageView) objArr[1], (LinearLayout) objArr[10], (LinearLayout) objArr[9], (TextView) objArr[2], (TextView) objArr[8], (TextView) objArr[5]);
        this.n = -1L;
        this.a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13488i = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.f13489j = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[4];
        this.f13490k = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[6];
        this.f13491l = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[7];
        this.f13492m = textView4;
        textView4.setTag(null);
        this.f13426d.setTag(null);
        this.f13427e.setTag(null);
        this.f13428f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
