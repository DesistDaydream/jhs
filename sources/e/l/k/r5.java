package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.ui.dialog.SellerCancelReasonDialog;

/* loaded from: classes2.dex */
public class r5 extends q5 {
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13458i = null;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static final SparseIntArray f13459j = null;
    @NonNull
    private final LinearLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final TextView f13460c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final TextView f13461d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final TextView f13462e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final TextView f13463f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final TextView f13464g;

    /* renamed from: h  reason: collision with root package name */
    private long f13465h;

    public r5(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f13458i, f13459j));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.f13465h;
            this.f13465h = 0L;
        }
        SellerCancelReasonDialog sellerCancelReasonDialog = this.a;
        e.t.j.h.g gVar = null;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 != 0 && sellerCancelReasonDialog != null) {
            gVar = sellerCancelReasonDialog.getOnChoose();
        }
        if (i2 != 0) {
            e.t.j.g.e0.F(this.f13460c, gVar);
            e.t.j.g.e0.F(this.f13461d, gVar);
            e.t.j.g.e0.F(this.f13462e, gVar);
            e.t.j.g.e0.F(this.f13463f, gVar);
            e.t.j.g.e0.F(this.f13464g, gVar);
        }
    }

    @Override // e.l.k.q5
    public void h(@Nullable SellerCancelReasonDialog sellerCancelReasonDialog) {
        this.a = sellerCancelReasonDialog;
        synchronized (this) {
            this.f13465h |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13465h != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13465h = 2L;
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
            h((SellerCancelReasonDialog) obj);
            return true;
        }
        return false;
    }

    private r5(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f13465h = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.b = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f13460c = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.f13461d = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[3];
        this.f13462e = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[4];
        this.f13463f = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[5];
        this.f13464g = textView5;
        textView5.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
