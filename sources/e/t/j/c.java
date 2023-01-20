package e.t.j;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import e.t.k.a.f.h;

/* loaded from: classes3.dex */
public class c extends b {
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f14471e = null;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f14472f = null;
    @NonNull
    private final RelativeLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final FrameLayout f14473c;

    /* renamed from: d  reason: collision with root package name */
    private long f14474d;

    public c(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f14471e, f14472f));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f14474d = 0L;
        }
    }

    @Override // e.t.j.b
    public void h(@Nullable h hVar) {
        this.a = hVar;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14474d != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14474d = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (e.t.b.f14443k == i2) {
            h((h) obj);
            return true;
        }
        return false;
    }

    private c(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f14474d = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.b = relativeLayout;
        relativeLayout.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[1];
        this.f14473c = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
