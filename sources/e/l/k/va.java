package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jihuanshe.R;
import com.jihuanshe.model.Category;
import com.vector.databinding.adapter.TextViewBinding;

/* loaded from: classes2.dex */
public class va extends ua {
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13764e = null;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f13765f = null;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final TextView f13766c;

    /* renamed from: d  reason: collision with root package name */
    private long f13767d;

    public va(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f13764e, f13765f));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.f13767d;
            this.f13767d = 0L;
        }
        String str = null;
        Category category = this.a;
        int i2 = 0;
        Boolean bool = this.b;
        if ((j2 & 5) != 0 && category != null) {
            str = category.getName();
        }
        int i3 = ((j2 & 6) > 0L ? 1 : ((j2 & 6) == 0L ? 0 : -1));
        if (i3 != 0) {
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (i3 != 0) {
                j2 |= safeUnbox ? 16L : 8L;
            }
            i2 = ViewDataBinding.getColorFromResource(this.f13766c, safeUnbox ? R.color.common_color_1 : R.color.black);
        }
        if ((6 & j2) != 0) {
            TextViewBinding.j(this.f13766c, i2);
        }
        if ((j2 & 5) != 0) {
            TextViewBindingAdapter.setText(this.f13766c, str);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13767d != 0;
        }
    }

    @Override // e.l.k.ua
    public void i(@Nullable Category category) {
        this.a = category;
        synchronized (this) {
            this.f13767d |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13767d = 4L;
        }
        requestRebind();
    }

    @Override // e.l.k.ua
    public void j(@Nullable Boolean bool) {
        this.b = bool;
        synchronized (this) {
            this.f13767d |= 2;
        }
        notifyPropertyChanged(16);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (8 == i2) {
            i((Category) obj);
        } else if (16 != i2) {
            return false;
        } else {
            j((Boolean) obj);
        }
        return true;
    }

    private va(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f13767d = -1L;
        TextView textView = (TextView) objArr[0];
        this.f13766c = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
