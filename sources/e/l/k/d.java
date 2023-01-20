package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.ui.page.user.AccountManagerActivity;

/* loaded from: classes2.dex */
public class d extends c {
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12464e = null;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f12465f = null;
    @NonNull
    private final ConstraintLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final TextView f12466c;

    /* renamed from: d  reason: collision with root package name */
    private long f12467d;

    public d(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f12464e, f12465f));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.f12467d;
            this.f12467d = 0L;
        }
        e.t.j.h.g gVar = null;
        AccountManagerActivity accountManagerActivity = this.a;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 != 0 && accountManagerActivity != null) {
            gVar = accountManagerActivity.W();
        }
        if (i2 != 0) {
            e.t.j.g.e0.F(this.f12466c, gVar);
        }
    }

    @Override // e.l.k.c
    public void h(@Nullable AccountManagerActivity accountManagerActivity) {
        this.a = accountManagerActivity;
        synchronized (this) {
            this.f12467d |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12467d != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12467d = 2L;
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
            h((AccountManagerActivity) obj);
            return true;
        }
        return false;
    }

    private d(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f12467d = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.b = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f12466c = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
