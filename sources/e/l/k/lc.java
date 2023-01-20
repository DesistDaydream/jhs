package e.l.k;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.jihuanshe.R;

/* loaded from: classes2.dex */
public class lc extends kc {
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13073e = null;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f13074f = null;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final TextView f13075c;

    /* renamed from: d  reason: collision with root package name */
    private long f13076d;

    public lc(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f13073e, f13074f));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        Context context;
        int i2;
        synchronized (this) {
            j2 = this.f13076d;
            this.f13076d = 0L;
        }
        Boolean bool = this.a;
        String str = this.b;
        Drawable drawable = null;
        int i3 = ((j2 & 5) > 0L ? 1 : ((j2 & 5) == 0L ? 0 : -1));
        if (i3 != 0) {
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (i3 != 0) {
                j2 |= safeUnbox ? 16L : 8L;
            }
            if (safeUnbox) {
                context = this.f13075c.getContext();
                i2 = R.drawable.ripple_f8f8f8;
            } else {
                context = this.f13075c.getContext();
                i2 = R.drawable.ripple_default;
            }
            drawable = AppCompatResources.getDrawable(context, i2);
        }
        int i4 = ((6 & j2) > 0L ? 1 : ((6 & j2) == 0L ? 0 : -1));
        if ((j2 & 5) != 0) {
            ViewBindingAdapter.setBackground(this.f13075c, drawable);
        }
        if (i4 != 0) {
            TextViewBindingAdapter.setText(this.f13075c, str);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13076d != 0;
        }
    }

    @Override // e.l.k.kc
    public void i(@Nullable String str) {
        this.b = str;
        synchronized (this) {
            this.f13076d |= 2;
        }
        notifyPropertyChanged(9);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13076d = 4L;
        }
        requestRebind();
    }

    @Override // e.l.k.kc
    public void j(@Nullable Boolean bool) {
        this.a = bool;
        synchronized (this) {
            this.f13076d |= 1;
        }
        notifyPropertyChanged(15);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (15 == i2) {
            j((Boolean) obj);
        } else if (9 != i2) {
            return false;
        } else {
            i((String) obj);
        }
        return true;
    }

    private lc(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f13076d = -1L;
        TextView textView = (TextView) objArr[0];
        this.f13075c = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
