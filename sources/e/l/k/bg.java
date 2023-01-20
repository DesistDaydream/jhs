package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.detail.ReviewListActivity;
import com.jihuanshe.viewmodel.detail.ReviewListViewModel;

/* loaded from: classes2.dex */
public class bg extends ag {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12378f = null;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f12379g = null;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final ConstraintLayout f12380d;

    /* renamed from: e  reason: collision with root package name */
    private long f12381e;

    public bg(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f12378f, f12379g));
    }

    private boolean k(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12381e |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.f12381e;
            this.f12381e = 0L;
        }
        ReviewListViewModel reviewListViewModel = this.f12304c;
        String str = null;
        int i2 = 0;
        int i3 = ((j2 & 13) > 0L ? 1 : ((j2 & 13) == 0L ? 0 : -1));
        if (i3 != 0) {
            e.n.l G0 = reviewListViewModel != null ? reviewListViewModel.G0() : null;
            updateLiveDataRegistration(0, G0);
            Integer value = G0 != null ? G0.getValue() : null;
            boolean z = value == null;
            str = this.a.getResources().getString(R.string.review_total_num, value);
            if (i3 != 0) {
                j2 |= z ? 32L : 16L;
            }
            if (z) {
                i2 = 8;
            }
        }
        if ((j2 & 13) != 0) {
            this.a.setVisibility(i2);
            TextViewBindingAdapter.setText(this.a, str);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12381e != 0;
        }
    }

    @Override // e.l.k.ag
    public void i(@Nullable ReviewListActivity reviewListActivity) {
        this.b = reviewListActivity;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12381e = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.ag
    public void j(@Nullable ReviewListViewModel reviewListViewModel) {
        this.f12304c = reviewListViewModel;
        synchronized (this) {
            this.f12381e |= 4;
        }
        notifyPropertyChanged(21);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return k((e.n.l) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((ReviewListActivity) obj);
        } else if (21 != i2) {
            return false;
        } else {
            j((ReviewListViewModel) obj);
        }
        return true;
    }

    private bg(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[1]);
        this.f12381e = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12380d = constraintLayout;
        constraintLayout.setTag(null);
        this.a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
