package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;

/* loaded from: classes2.dex */
public class bc extends ac {
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12362d = null;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private static final SparseIntArray f12363e = null;
    @NonNull
    private final TextView b;

    /* renamed from: c  reason: collision with root package name */
    private long f12364c;

    public bc(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f12362d, f12363e));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.f12364c;
            this.f12364c = 0L;
        }
        String str = this.a;
        if ((j2 & 3) != 0) {
            TextViewBindingAdapter.setText(this.b, str);
        }
    }

    @Override // e.l.k.ac
    public void h(@Nullable String str) {
        this.a = str;
        synchronized (this) {
            this.f12364c |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12364c != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12364c = 2L;
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
            h((String) obj);
            return true;
        }
        return false;
    }

    private bc(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f12364c = -1L;
        TextView textView = (TextView) objArr[0];
        this.b = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
