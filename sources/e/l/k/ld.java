package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jihuanshe.model.Category;

/* loaded from: classes2.dex */
public class ld extends kd {
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13077e = null;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f13078f = null;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final TextView f13079c;

    /* renamed from: d  reason: collision with root package name */
    private long f13080d;

    public ld(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f13077e, f13078f));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.f13080d;
            this.f13080d = 0L;
        }
        String str = null;
        Category category = this.a;
        int i2 = ((j2 & 5) > 0L ? 1 : ((j2 & 5) == 0L ? 0 : -1));
        if (i2 != 0 && category != null) {
            str = category.getName();
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.f13079c, str);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13080d != 0;
        }
    }

    @Override // e.l.k.kd
    public void i(@Nullable Category category) {
        this.a = category;
        synchronized (this) {
            this.f13080d |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13080d = 4L;
        }
        requestRebind();
    }

    @Override // e.l.k.kd
    public void j(@Nullable Integer num) {
        this.b = num;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (8 == i2) {
            i((Category) obj);
        } else if (11 != i2) {
            return false;
        } else {
            j((Integer) obj);
        }
        return true;
    }

    private ld(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f13080d = -1L;
        TextView textView = (TextView) objArr[0];
        this.f13079c = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
