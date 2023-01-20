package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.ui.page.user.AboutActivity;

/* loaded from: classes2.dex */
public class b extends a {
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12305j = null;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private static final SparseIntArray f12306k = null;
    @NonNull
    private final ConstraintLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final TextView f12307c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final TextView f12308d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final TextView f12309e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final TextView f12310f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final TextView f12311g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final TextView f12312h;

    /* renamed from: i  reason: collision with root package name */
    private long f12313i;

    public b(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f12305j, f12306k));
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
            j2 = this.f12313i;
            this.f12313i = 0L;
        }
        AboutActivity aboutActivity = this.a;
        e.t.j.h.g gVar6 = null;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 == 0 || aboutActivity == null) {
            gVar = null;
            gVar2 = null;
            gVar3 = null;
            gVar4 = null;
            gVar5 = null;
        } else {
            e.t.j.h.g W = aboutActivity.W();
            e.t.j.h.g Y = aboutActivity.Y();
            gVar2 = aboutActivity.a0();
            e.t.j.h.g b0 = aboutActivity.b0();
            gVar4 = aboutActivity.Z();
            gVar5 = aboutActivity.X();
            gVar3 = Y;
            gVar = W;
            gVar6 = b0;
        }
        if (i2 != 0) {
            e.t.j.g.e0.F(this.f12307c, gVar6);
            e.t.j.g.e0.F(this.f12308d, gVar5);
            e.t.j.g.e0.F(this.f12309e, gVar);
            e.t.j.g.e0.F(this.f12310f, gVar2);
            e.t.j.g.e0.F(this.f12311g, gVar4);
            e.t.j.g.e0.F(this.f12312h, gVar3);
        }
    }

    @Override // e.l.k.a
    public void h(@Nullable AboutActivity aboutActivity) {
        this.a = aboutActivity;
        synchronized (this) {
            this.f12313i |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12313i != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12313i = 2L;
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
            h((AboutActivity) obj);
            return true;
        }
        return false;
    }

    private b(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f12313i = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.b = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f12307c = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.f12308d = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[3];
        this.f12309e = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[4];
        this.f12310f = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[5];
        this.f12311g = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) objArr[6];
        this.f12312h = textView6;
        textView6.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
