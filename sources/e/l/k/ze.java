package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.CardPackage;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public class ze extends ye {
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f14076l = null;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private static final SparseIntArray f14077m;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final ConstraintLayout f14078h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final TextView f14079i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final TextView f14080j;

    /* renamed from: k  reason: collision with root package name */
    private long f14081k;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f14077m = sparseIntArray;
        sparseIntArray.put(R.id.cl, 5);
        sparseIntArray.put(R.id.fl, 6);
        sparseIntArray.put(R.id.viewLine, 7);
    }

    public ze(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f14076l, f14077m));
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 179
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.ze.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14081k != 0;
        }
    }

    @Override // e.l.k.ye
    public void i(@Nullable CardPackage cardPackage) {
        this.f14006f = cardPackage;
        synchronized (this) {
            this.f14081k |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14081k = 4L;
        }
        requestRebind();
    }

    @Override // e.l.k.ye
    public void j(@Nullable e.t.r.a.h hVar) {
        this.f14007g = hVar;
        synchronized (this) {
            this.f14081k |= 2;
        }
        notifyPropertyChanged(17);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (8 == i2) {
            i((CardPackage) obj);
        } else if (17 != i2) {
            return false;
        } else {
            j((e.t.r.a.h) obj);
        }
        return true;
    }

    private ze(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[5], (FrameLayout) objArr[6], (NImageView) objArr[1], (TextView) objArr[3], (LinearLayout) objArr[7]);
        this.f14081k = -1L;
        this.f14003c.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f14078h = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f14079i = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[4];
        this.f14080j = textView2;
        textView2.setTag(null);
        this.f14004d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
