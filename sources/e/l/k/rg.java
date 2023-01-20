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
import com.jihuanshe.R;
import com.jihuanshe.model.User;
import com.jihuanshe.ui.widget.UserBar;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public class rg extends qg {
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13517g = null;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f13518h;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final ConstraintLayout f13519e;

    /* renamed from: f  reason: collision with root package name */
    private long f13520f;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13518h = sparseIntArray;
        sparseIntArray.put(R.id.backIv, 3);
    }

    public rg(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f13517g, f13518h));
    }

    private boolean i(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13520f |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean j(e.n.f<User> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13520f |= 2;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 197
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.rg.executeBindings():void");
    }

    @Override // e.l.k.qg
    public void h(@Nullable UserBar userBar) {
        this.f13451d = userBar;
        synchronized (this) {
            this.f13520f |= 4;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13520f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13520f = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            if (i2 != 1) {
                return false;
            }
            return j((e.n.f) obj, i3);
        }
        return i((e.n.i) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            h((UserBar) obj);
            return true;
        }
        return false;
    }

    private rg(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (ImageView) objArr[3], (NImageView) objArr[1], (TextView) objArr[2]);
        this.f13520f = -1L;
        this.b.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13519e = constraintLayout;
        constraintLayout.setTag(null);
        this.f13450c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
