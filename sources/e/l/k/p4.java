package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.ui.dialog.DeleteDialog;

/* loaded from: classes2.dex */
public class p4 extends o4 {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13308f = null;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f13309g = null;
    @NonNull
    private final LinearLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final TextView f13310c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final TextView f13311d;

    /* renamed from: e  reason: collision with root package name */
    private long f13312e;

    public p4(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f13308f, f13309g));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.t.j.h.g gVar;
        synchronized (this) {
            j2 = this.f13312e;
            this.f13312e = 0L;
        }
        DeleteDialog deleteDialog = this.a;
        e.t.j.h.g gVar2 = null;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 == 0 || deleteDialog == null) {
            gVar = null;
        } else {
            gVar2 = deleteDialog.getOnDelete();
            gVar = deleteDialog.getOnCancel();
        }
        if (i2 != 0) {
            e.t.j.g.e0.F(this.f13310c, gVar2);
            e.t.j.g.e0.F(this.f13311d, gVar);
        }
    }

    @Override // e.l.k.o4
    public void h(@Nullable DeleteDialog deleteDialog) {
        this.a = deleteDialog;
        synchronized (this) {
            this.f13312e |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13312e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13312e = 2L;
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
            h((DeleteDialog) obj);
            return true;
        }
        return false;
    }

    private p4(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f13312e = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.b = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f13310c = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.f13311d = textView2;
        textView2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
