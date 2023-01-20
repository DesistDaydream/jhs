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
import com.jihuanshe.ui.page.search.fragments.global.SearchProductFragment;
import com.jihuanshe.viewmodel.search.globals.SearchProductViewModel;

/* loaded from: classes2.dex */
public class p8 extends o8 {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13327f = null;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f13328g = null;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final ConstraintLayout f13329c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final TextView f13330d;

    /* renamed from: e  reason: collision with root package name */
    private long f13331e;

    public p8(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f13327f, f13328g));
    }

    private boolean k(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13331e |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.f13331e;
            this.f13331e = 0L;
        }
        SearchProductFragment searchProductFragment = this.a;
        SearchProductViewModel searchProductViewModel = this.b;
        String str = null;
        e.t.j.h.g n0 = ((j2 & 10) == 0 || searchProductFragment == null) ? null : searchProductFragment.n0();
        int i2 = ((j2 & 13) > 0L ? 1 : ((j2 & 13) == 0L ? 0 : -1));
        if (i2 != 0) {
            e.n.l t0 = searchProductViewModel != null ? searchProductViewModel.t0() : null;
            updateLiveDataRegistration(0, t0);
            boolean z = ViewDataBinding.safeUnbox(t0 != null ? t0.getValue() : null) == 0;
            if (i2 != 0) {
                j2 |= z ? 32L : 16L;
            }
            str = this.f13330d.getResources().getString(z ? R.string.search_mediation : R.string.search_version);
        }
        if ((13 & j2) != 0) {
            TextViewBindingAdapter.setText(this.f13330d, str);
        }
        if ((j2 & 10) != 0) {
            e.t.j.g.e0.F(this.f13330d, n0);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13331e != 0;
        }
    }

    @Override // e.l.k.o8
    public void i(@Nullable SearchProductFragment searchProductFragment) {
        this.a = searchProductFragment;
        synchronized (this) {
            this.f13331e |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13331e = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.o8
    public void j(@Nullable SearchProductViewModel searchProductViewModel) {
        this.b = searchProductViewModel;
        synchronized (this) {
            this.f13331e |= 4;
        }
        notifyPropertyChanged(20);
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
            i((SearchProductFragment) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((SearchProductViewModel) obj);
        }
        return true;
    }

    private p8(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1);
        this.f13331e = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13329c = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f13330d = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
