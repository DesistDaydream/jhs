package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.ui.page.user.HelpActivity;

/* loaded from: classes2.dex */
public class z0 extends y0 {
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f14024j = null;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private static final SparseIntArray f14025k = null;
    @NonNull
    private final ConstraintLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final TextView f14026c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final TextView f14027d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final TextView f14028e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final TextView f14029f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final TextView f14030g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final TextView f14031h;

    /* renamed from: i  reason: collision with root package name */
    private long f14032i;

    public z0(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f14024j, f14025k));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.t.j.h.g gVar;
        e.t.j.h.g gVar2;
        e.t.j.h.g gVar3;
        e.t.j.h.g gVar4;
        e.t.j.h.g gVar5;
        synchronized (this) {
            j2 = this.f14032i;
            this.f14032i = 0L;
        }
        HelpActivity helpActivity = this.a;
        e.t.j.h.g gVar6 = null;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 == 0 || helpActivity == null) {
            gVar = null;
            gVar2 = null;
            gVar3 = null;
            gVar4 = null;
            gVar5 = null;
        } else {
            e.t.j.h.g a0 = helpActivity.a0();
            e.t.j.h.g Z = helpActivity.Z();
            e.t.j.h.g b0 = helpActivity.b0();
            gVar3 = helpActivity.W();
            gVar4 = helpActivity.X();
            gVar5 = helpActivity.Y();
            gVar2 = Z;
            gVar = a0;
            gVar6 = b0;
        }
        if (i2 != 0) {
            e.t.j.g.e0.F(this.f14026c, gVar6);
            e.t.j.g.e0.F(this.f14027d, gVar5);
            e.t.j.g.e0.F(this.f14028e, gVar);
            e.t.j.g.e0.F(this.f14029f, gVar3);
            e.t.j.g.e0.F(this.f14030g, gVar2);
            e.t.j.g.e0.F(this.f14031h, gVar4);
        }
    }

    @Override // e.l.k.y0
    public void h(@Nullable HelpActivity helpActivity) {
        this.a = helpActivity;
        synchronized (this) {
            this.f14032i |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14032i != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14032i = 2L;
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
            h((HelpActivity) obj);
            return true;
        }
        return false;
    }

    private z0(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f14032i = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.b = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f14026c = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.f14027d = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[3];
        this.f14028e = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[4];
        this.f14029f = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[5];
        this.f14030g = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) objArr[6];
        this.f14031h = textView6;
        textView6.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
