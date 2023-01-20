package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jihuanshe.model.IllegalData;

/* loaded from: classes2.dex */
public class ta extends sa {
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13630g = null;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f13631h = null;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final ConstraintLayout f13632e;

    /* renamed from: f  reason: collision with root package name */
    private long f13633f;

    public ta(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f13630g, f13631h));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        String str;
        String str2;
        synchronized (this) {
            j2 = this.f13633f;
            this.f13633f = 0L;
        }
        IllegalData illegalData = this.f13564d;
        String str3 = null;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 == 0 || illegalData == null) {
            str = null;
            str2 = null;
        } else {
            String time = illegalData.getTime();
            str = illegalData.getReason();
            str3 = illegalData.getAction();
            str2 = time;
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.a, str3);
            TextViewBindingAdapter.setText(this.b, str);
            TextViewBindingAdapter.setText(this.f13563c, str2);
        }
    }

    @Override // e.l.k.sa
    public void h(@Nullable IllegalData illegalData) {
        this.f13564d = illegalData;
        synchronized (this) {
            this.f13633f |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13633f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13633f = 2L;
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
            h((IllegalData) obj);
            return true;
        }
        return false;
    }

    private ta(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[1], (TextView) objArr[2], (TextView) objArr[3]);
        this.f13633f = -1L;
        this.a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13632e = constraintLayout;
        constraintLayout.setTag(null);
        this.b.setTag(null);
        this.f13563c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
