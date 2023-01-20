package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.eth.model.NLive;
import com.jihuanshe.model.Category;
import com.jihuanshe.ui.page.shop.AddCardActivity;
import com.jihuanshe.viewmodel.shop.AddCardViewModel;
import java.util.List;

/* loaded from: classes2.dex */
public class h extends g {
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12761g = null;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f12762h = null;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final ConstraintLayout f12763e;

    /* renamed from: f  reason: collision with root package name */
    private long f12764f;

    public h(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f12761g, f12762h));
    }

    private boolean k(NLive<List<Category>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12764f |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean l(NLive<List<Object>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12764f |= 2;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.h.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12764f != 0;
        }
    }

    @Override // e.l.k.g
    public void i(@Nullable AddCardActivity addCardActivity) {
        this.f12673c = addCardActivity;
        synchronized (this) {
            this.f12764f |= 4;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12764f = 16L;
        }
        requestRebind();
    }

    @Override // e.l.k.g
    public void j(@Nullable AddCardViewModel addCardViewModel) {
        this.f12674d = addCardViewModel;
        synchronized (this) {
            this.f12764f |= 8;
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
            return l((NLive) obj, i3);
        }
        return k((NLive) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((AddCardActivity) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((AddCardViewModel) obj);
        }
        return true;
    }

    private h(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (RecyclerView) objArr[1], (RecyclerView) objArr[2]);
        this.f12764f = -1L;
        this.a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12763e = constraintLayout;
        constraintLayout.setTag(null);
        this.b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
