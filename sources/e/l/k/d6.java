package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.model.WantBuyList;
import com.jihuanshe.ui.dialog.WantBuyDialog;
import com.jihuanshe.ui.page.user.WantBuyActivity;

/* loaded from: classes2.dex */
public class d6 extends c6 {
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12494h = null;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static final SparseIntArray f12495i = null;
    @NonNull
    private final LinearLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final TextView f12496c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final TextView f12497d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final TextView f12498e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final TextView f12499f;

    /* renamed from: g  reason: collision with root package name */
    private long f12500g;

    public d6(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f12494h, f12495i));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.t.j.h.g gVar;
        e.t.j.h.g gVar2;
        e.t.j.h.g gVar3;
        WantBuyList wantBuyList;
        e.t.j.h.g gVar4;
        WantBuyActivity wantBuyActivity;
        synchronized (this) {
            j2 = this.f12500g;
            this.f12500g = 0L;
        }
        WantBuyDialog wantBuyDialog = this.a;
        e.t.j.h.g gVar5 = null;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 != 0) {
            if (wantBuyDialog != null) {
                wantBuyList = wantBuyDialog.getItem();
                gVar4 = wantBuyDialog.getOnClickCancel();
                wantBuyActivity = wantBuyDialog.getActivity();
            } else {
                wantBuyList = null;
                gVar4 = null;
                wantBuyActivity = null;
            }
            if (wantBuyActivity != null) {
                e.t.j.h.g delete = wantBuyActivity.delete(wantBuyList);
                e.t.j.h.g o0 = wantBuyActivity.o0(wantBuyList);
                gVar = wantBuyActivity.s0(wantBuyList);
                gVar3 = gVar4;
                gVar2 = delete;
                gVar5 = o0;
            } else {
                gVar3 = gVar4;
                gVar = null;
                gVar2 = null;
            }
        } else {
            gVar = null;
            gVar2 = null;
            gVar3 = null;
        }
        if (i2 != 0) {
            e.t.j.g.e0.F(this.f12496c, gVar5);
            e.t.j.g.e0.F(this.f12497d, gVar);
            e.t.j.g.e0.F(this.f12498e, gVar2);
            e.t.j.g.e0.F(this.f12499f, gVar3);
        }
    }

    @Override // e.l.k.c6
    public void h(@Nullable WantBuyDialog wantBuyDialog) {
        this.a = wantBuyDialog;
        synchronized (this) {
            this.f12500g |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12500g != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12500g = 2L;
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
            h((WantBuyDialog) obj);
            return true;
        }
        return false;
    }

    private d6(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f12500g = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.b = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f12496c = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.f12497d = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[3];
        this.f12498e = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[4];
        this.f12499f = textView4;
        textView4.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
