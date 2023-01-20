package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.ui.widget.WantBuyPopupWindow;

/* loaded from: classes2.dex */
public class ve extends ue {
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13779g = null;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f13780h = null;
    @NonNull
    private final LinearLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final TextView f13781c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final TextView f13782d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final TextView f13783e;

    /* renamed from: f  reason: collision with root package name */
    private long f13784f;

    public ve(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f13779g, f13780h));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.t.j.h.g gVar;
        e.t.j.h.g gVar2;
        synchronized (this) {
            j2 = this.f13784f;
            this.f13784f = 0L;
        }
        WantBuyPopupWindow wantBuyPopupWindow = this.a;
        e.t.j.h.g gVar3 = null;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 == 0 || wantBuyPopupWindow == null) {
            gVar = null;
            gVar2 = null;
        } else {
            e.t.j.h.g g2 = wantBuyPopupWindow.g(2);
            gVar2 = wantBuyPopupWindow.g(3);
            gVar = g2;
            gVar3 = wantBuyPopupWindow.g(1);
        }
        if (i2 != 0) {
            e.t.j.g.e0.F(this.f13781c, gVar3);
            e.t.j.g.e0.F(this.f13782d, gVar);
            e.t.j.g.e0.F(this.f13783e, gVar2);
        }
    }

    @Override // e.l.k.ue
    public void h(@Nullable WantBuyPopupWindow wantBuyPopupWindow) {
        this.a = wantBuyPopupWindow;
        synchronized (this) {
            this.f13784f |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13784f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13784f = 2L;
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
            h((WantBuyPopupWindow) obj);
            return true;
        }
        return false;
    }

    private ve(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f13784f = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.b = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f13781c = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.f13782d = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[3];
        this.f13783e = textView3;
        textView3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
