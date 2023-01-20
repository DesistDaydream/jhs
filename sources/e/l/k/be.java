package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.ui.widget.ConditionPopupWindow;

/* loaded from: classes2.dex */
public class be extends ae {
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12366h = null;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static final SparseIntArray f12367i = null;
    @NonNull
    private final LinearLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final TextView f12368c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final TextView f12369d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final TextView f12370e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final TextView f12371f;

    /* renamed from: g  reason: collision with root package name */
    private long f12372g;

    public be(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f12366h, f12367i));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.t.j.h.g gVar;
        e.t.j.h.g gVar2;
        e.t.j.h.g gVar3;
        synchronized (this) {
            j2 = this.f12372g;
            this.f12372g = 0L;
        }
        ConditionPopupWindow conditionPopupWindow = this.a;
        e.t.j.h.g gVar4 = null;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 == 0 || conditionPopupWindow == null) {
            gVar = null;
            gVar2 = null;
            gVar3 = null;
        } else {
            e.t.j.h.g g2 = conditionPopupWindow.g(2);
            e.t.j.h.g g3 = conditionPopupWindow.g(4);
            gVar2 = conditionPopupWindow.g(3);
            gVar3 = g3;
            gVar = g2;
            gVar4 = conditionPopupWindow.g(1);
        }
        if (i2 != 0) {
            e.t.j.g.e0.F(this.f12368c, gVar4);
            e.t.j.g.e0.F(this.f12369d, gVar);
            e.t.j.g.e0.F(this.f12370e, gVar2);
            e.t.j.g.e0.F(this.f12371f, gVar3);
        }
    }

    @Override // e.l.k.ae
    public void h(@Nullable ConditionPopupWindow conditionPopupWindow) {
        this.a = conditionPopupWindow;
        synchronized (this) {
            this.f12372g |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12372g != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12372g = 2L;
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
            h((ConditionPopupWindow) obj);
            return true;
        }
        return false;
    }

    private be(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f12372g = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.b = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f12368c = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.f12369d = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[3];
        this.f12370e = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[4];
        this.f12371f = textView4;
        textView4.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
