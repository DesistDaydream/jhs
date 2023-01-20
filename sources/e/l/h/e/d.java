package e.l.h.e;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jihuanshe.base.ui.widget.ToastDialog;
import com.vector.databinding.adapter.TextViewBinding;

/* loaded from: classes2.dex */
public class d extends c {
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12093e = null;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f12094f = null;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final CardView f12095c;

    /* renamed from: d  reason: collision with root package name */
    private long f12096d;

    public d(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f12093e, f12094f));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        int i2;
        int i3;
        synchronized (this) {
            j2 = this.f12096d;
            this.f12096d = 0L;
        }
        ToastDialog toastDialog = this.b;
        int i4 = 0;
        int i5 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i5 == 0 || toastDialog == null) {
            i2 = 0;
            i3 = 0;
        } else {
            i4 = toastDialog.a();
            i2 = toastDialog.f();
            i3 = toastDialog.e();
        }
        if (i5 != 0) {
            this.f12095c.setCardBackgroundColor(i4);
            TextViewBinding.j(this.a, i3);
            TextViewBindingAdapter.setTextSize(this.a, i2);
        }
    }

    @Override // e.l.h.e.c
    public void h(@Nullable ToastDialog toastDialog) {
        this.b = toastDialog;
        synchronized (this) {
            this.f12096d |= 1;
        }
        notifyPropertyChanged(e.l.h.a.s);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12096d != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12096d = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (e.l.h.a.s == i2) {
            h((ToastDialog) obj);
            return true;
        }
        return false;
    }

    private d(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[1]);
        this.f12096d = -1L;
        CardView cardView = (CardView) objArr[0];
        this.f12095c = cardView;
        cardView.setTag(null);
        this.a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
