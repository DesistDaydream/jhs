package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.ui.page.user.WantBuyMatchActivity;

/* loaded from: classes2.dex */
public class xf extends wf {
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13931e = null;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f13932f = null;
    @NonNull
    private final FrameLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final CheckBox f13933c;

    /* renamed from: d  reason: collision with root package name */
    private long f13934d;

    public xf(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f13931e, f13932f));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.f13934d;
            this.f13934d = 0L;
        }
        WantBuyMatchActivity wantBuyMatchActivity = this.a;
        e.t.j.h.e eVar = null;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 != 0 && wantBuyMatchActivity != null) {
            eVar = wantBuyMatchActivity.b0();
        }
        if (i2 != 0) {
            e.t.j.g.s.b(this.f13933c, eVar);
        }
    }

    @Override // e.l.k.wf
    public void h(@Nullable WantBuyMatchActivity wantBuyMatchActivity) {
        this.a = wantBuyMatchActivity;
        synchronized (this) {
            this.f13934d |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13934d != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13934d = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            h((WantBuyMatchActivity) obj);
            return true;
        }
        return false;
    }

    private xf(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f13934d = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.b = frameLayout;
        frameLayout.setTag(null);
        CheckBox checkBox = (CheckBox) objArr[1];
        this.f13933c = checkBox;
        checkBox.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
