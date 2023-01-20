package e.l.h.e;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jihuanshe.base.R;
import com.jihuanshe.base.ui.activity.GlobalToastActivity;
import e.t.j.g.e0;
import e.t.j.h.g;

/* loaded from: classes2.dex */
public class b extends a {
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12089g = null;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f12090h;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final FrameLayout f12091e;

    /* renamed from: f  reason: collision with root package name */
    private long f12092f;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f12090h = sparseIntArray;
        sparseIntArray.put(R.id.view2, 3);
    }

    public b(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f12089g, f12090h));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        String str;
        synchronized (this) {
            j2 = this.f12092f;
            this.f12092f = 0L;
        }
        GlobalToastActivity globalToastActivity = this.f12088d;
        g gVar = null;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 == 0 || globalToastActivity == null) {
            str = null;
        } else {
            String M = globalToastActivity.M();
            gVar = globalToastActivity.N();
            str = M;
        }
        if (i2 != 0) {
            e0.F(this.a, gVar);
            TextViewBindingAdapter.setText(this.b, str);
        }
    }

    @Override // e.l.h.e.a
    public void h(@Nullable GlobalToastActivity globalToastActivity) {
        this.f12088d = globalToastActivity;
        synchronized (this) {
            this.f12092f |= 1;
        }
        notifyPropertyChanged(e.l.h.a.f12069k);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12092f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12092f = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (e.l.h.a.f12069k == i2) {
            h((GlobalToastActivity) obj);
            return true;
        }
        return false;
    }

    private b(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[2], (TextView) objArr[1], (View) objArr[3]);
        this.f12092f = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f12091e = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
