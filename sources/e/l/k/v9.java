package e.l.k;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.jihuanshe.R;
import com.jihuanshe.model.ChooseItem;

/* loaded from: classes2.dex */
public class v9 extends u9 {
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13760e = null;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f13761f = null;
    @NonNull
    private final ConstraintLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final TextView f13762c;

    /* renamed from: d  reason: collision with root package name */
    private long f13763d;

    public v9(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f13760e, f13761f));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        String str;
        int i2;
        synchronized (this) {
            j2 = this.f13763d;
            this.f13763d = 0L;
        }
        ChooseItem chooseItem = this.a;
        Drawable drawable = null;
        String str2 = null;
        int i3 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i3 != 0) {
            if (chooseItem != null) {
                str2 = chooseItem.getName();
                i2 = chooseItem.getState();
            } else {
                i2 = 0;
            }
            boolean z = i2 == 1;
            if (i3 != 0) {
                j2 |= z ? 8L : 4L;
            }
            String str3 = str2;
            drawable = AppCompatResources.getDrawable(this.f13762c.getContext(), z ? R.drawable.ripple_f8f8f8 : R.drawable.ripple_default);
            str = str3;
        } else {
            str = null;
        }
        if ((j2 & 3) != 0) {
            ViewBindingAdapter.setBackground(this.f13762c, drawable);
            TextViewBindingAdapter.setText(this.f13762c, str);
        }
    }

    @Override // e.l.k.u9
    public void h(@Nullable ChooseItem chooseItem) {
        this.a = chooseItem;
        synchronized (this) {
            this.f13763d |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13763d != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13763d = 2L;
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
            h((ChooseItem) obj);
            return true;
        }
        return false;
    }

    private v9(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f13763d = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.b = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f13762c = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
