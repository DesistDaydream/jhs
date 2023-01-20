package e.l.k;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.BuyerCancelReasonDialog;

/* loaded from: classes2.dex */
public class p3 extends o3 {
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13298k = null;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private static final SparseIntArray f13299l = null;
    @NonNull
    private final LinearLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final TextView f13300c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final TextView f13301d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final TextView f13302e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final TextView f13303f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final TextView f13304g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final TextView f13305h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final TextView f13306i;

    /* renamed from: j  reason: collision with root package name */
    private long f13307j;

    public p3(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f13298k, f13299l));
    }

    private boolean i(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13307j |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        long j3;
        e.t.j.h.g gVar;
        e.t.j.h.g gVar2;
        e.t.j.h.g gVar3;
        e.t.j.h.g gVar4;
        e.t.j.h.g gVar5;
        e.t.j.h.g gVar6;
        Drawable drawable;
        e.t.j.h.g gVar7;
        Drawable drawable2;
        Drawable drawable3;
        Drawable drawable4;
        Drawable drawable5;
        long j4;
        e.t.j.h.g gVar8;
        e.t.j.h.g gVar9;
        e.t.j.h.g gVar10;
        e.t.j.h.g gVar11;
        e.t.j.h.g gVar12;
        e.t.j.h.g gVar13;
        synchronized (this) {
            j2 = this.f13307j;
            this.f13307j = 0L;
        }
        BuyerCancelReasonDialog buyerCancelReasonDialog = this.a;
        int i2 = ((j2 & 7) > 0L ? 1 : ((j2 & 7) == 0L ? 0 : -1));
        if (i2 != 0) {
            if ((j2 & 6) == 0 || buyerCancelReasonDialog == null) {
                gVar4 = null;
                gVar8 = null;
                gVar9 = null;
                gVar10 = null;
                gVar11 = null;
                gVar12 = null;
                gVar13 = null;
            } else {
                gVar4 = buyerCancelReasonDialog.C(2);
                gVar8 = buyerCancelReasonDialog.C(1);
                gVar9 = buyerCancelReasonDialog.C(5);
                gVar10 = buyerCancelReasonDialog.C(4);
                gVar11 = buyerCancelReasonDialog.getOnChoose();
                gVar12 = buyerCancelReasonDialog.C(3);
                gVar13 = buyerCancelReasonDialog.getOnClickCancel();
            }
            e.n.l reasonStr = buyerCancelReasonDialog != null ? buyerCancelReasonDialog.getReasonStr() : null;
            updateLiveDataRegistration(0, reasonStr);
            int safeUnbox = ViewDataBinding.safeUnbox(reasonStr != null ? reasonStr.getValue() : null);
            boolean z = safeUnbox == 2;
            boolean z2 = safeUnbox == 4;
            boolean z3 = safeUnbox == 1;
            boolean z4 = safeUnbox == 3;
            boolean z5 = safeUnbox == 5;
            if (i2 != 0) {
                j2 |= z ? 16L : 8L;
            }
            if ((j2 & 7) != 0) {
                j2 |= z2 ? 64L : 32L;
            }
            if ((j2 & 7) != 0) {
                j2 |= z3 ? 256L : 128L;
            }
            if ((j2 & 7) != 0) {
                j2 |= z4 ? 4096L : 2048L;
            }
            if ((j2 & 7) != 0) {
                j2 |= z5 ? 1024L : 512L;
            }
            Drawable drawable6 = z ? AppCompatResources.getDrawable(this.f13301d.getContext(), R.drawable.ripple_f8f8f8) : AppCompatResources.getDrawable(this.f13301d.getContext(), R.drawable.ripple_default);
            Context context = this.f13303f.getContext();
            Drawable drawable7 = z2 ? AppCompatResources.getDrawable(context, R.drawable.ripple_f8f8f8) : AppCompatResources.getDrawable(context, R.drawable.ripple_default);
            Context context2 = this.f13300c.getContext();
            Drawable drawable8 = z3 ? AppCompatResources.getDrawable(context2, R.drawable.ripple_f8f8f8) : AppCompatResources.getDrawable(context2, R.drawable.ripple_default);
            Context context3 = this.f13302e.getContext();
            Drawable drawable9 = z4 ? AppCompatResources.getDrawable(context3, R.drawable.ripple_f8f8f8) : AppCompatResources.getDrawable(context3, R.drawable.ripple_default);
            drawable5 = z5 ? AppCompatResources.getDrawable(this.f13304g.getContext(), R.drawable.ripple_f8f8f8) : AppCompatResources.getDrawable(this.f13304g.getContext(), R.drawable.ripple_default);
            drawable4 = drawable7;
            drawable = drawable8;
            drawable3 = drawable9;
            gVar3 = gVar9;
            gVar2 = gVar10;
            gVar6 = gVar11;
            gVar = gVar12;
            j3 = 6;
            drawable2 = drawable6;
            gVar7 = gVar8;
            gVar5 = gVar13;
        } else {
            j3 = 6;
            gVar = null;
            gVar2 = null;
            gVar3 = null;
            gVar4 = null;
            gVar5 = null;
            gVar6 = null;
            drawable = null;
            gVar7 = null;
            drawable2 = null;
            drawable3 = null;
            drawable4 = null;
            drawable5 = null;
        }
        if ((j2 & j3) != 0) {
            e.t.j.g.e0.F(this.f13300c, gVar7);
            e.t.j.g.e0.F(this.f13301d, gVar4);
            e.t.j.g.e0.F(this.f13302e, gVar);
            e.t.j.g.e0.F(this.f13303f, gVar2);
            e.t.j.g.e0.F(this.f13304g, gVar3);
            e.t.j.g.e0.F(this.f13305h, gVar5);
            e.t.j.g.e0.F(this.f13306i, gVar6);
            j4 = 7;
        } else {
            j4 = 7;
        }
        if ((j2 & j4) != 0) {
            ViewBindingAdapter.setBackground(this.f13300c, drawable);
            ViewBindingAdapter.setBackground(this.f13301d, drawable2);
            ViewBindingAdapter.setBackground(this.f13302e, drawable3);
            ViewBindingAdapter.setBackground(this.f13303f, drawable4);
            ViewBindingAdapter.setBackground(this.f13304g, drawable5);
        }
    }

    @Override // e.l.k.o3
    public void h(@Nullable BuyerCancelReasonDialog buyerCancelReasonDialog) {
        this.a = buyerCancelReasonDialog;
        synchronized (this) {
            this.f13307j |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13307j != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13307j = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return i((e.n.l) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            h((BuyerCancelReasonDialog) obj);
            return true;
        }
        return false;
    }

    private p3(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1);
        this.f13307j = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.b = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f13300c = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.f13301d = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[3];
        this.f13302e = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[4];
        this.f13303f = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[5];
        this.f13304g = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) objArr[6];
        this.f13305h = textView6;
        textView6.setTag(null);
        TextView textView7 = (TextView) objArr[7];
        this.f13306i = textView7;
        textView7.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
