package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jihuanshe.model.BankDetail;

/* loaded from: classes2.dex */
public class d9 extends c9 {
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12509d = null;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private static final SparseIntArray f12510e = null;
    @NonNull
    private final TextView b;

    /* renamed from: c  reason: collision with root package name */
    private long f12511c;

    public d9(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f12509d, f12510e));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.f12511c;
            this.f12511c = 0L;
        }
        String str = null;
        BankDetail bankDetail = this.a;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 != 0 && bankDetail != null) {
            str = bankDetail.getName();
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.b, str);
        }
    }

    @Override // e.l.k.c9
    public void h(@Nullable BankDetail bankDetail) {
        this.a = bankDetail;
        synchronized (this) {
            this.f12511c |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12511c != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12511c = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (8 == i2) {
            h((BankDetail) obj);
            return true;
        }
        return false;
    }

    private d9(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f12511c = -1L;
        TextView textView = (TextView) objArr[0];
        this.b = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
