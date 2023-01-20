package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.Converters;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.jihuanshe.R;
import com.jihuanshe.model.CardPackage;

/* loaded from: classes2.dex */
public class pb extends ob {
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13338g = null;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f13339h = null;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final ConstraintLayout f13340d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final TextView f13341e;

    /* renamed from: f  reason: collision with root package name */
    private long f13342f;

    public pb(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f13338g, f13339h));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        String str;
        synchronized (this) {
            j2 = this.f13342f;
            this.f13342f = 0L;
        }
        CardPackage cardPackage = this.b;
        Integer num = this.f13269c;
        String str2 = null;
        if ((j2 & 5) == 0 || cardPackage == null) {
            str = null;
        } else {
            str2 = cardPackage.getAlias();
            str = cardPackage.getName();
        }
        int i2 = ((j2 & 6) > 0L ? 1 : ((j2 & 6) == 0L ? 0 : -1));
        if (i2 != 0) {
            r13 = ViewDataBinding.safeUnbox(num) % 2 == 0 ? 1 : 0;
            if (i2 != 0) {
                j2 |= r13 != 0 ? 16L : 8L;
            }
            r13 = ViewDataBinding.getColorFromResource(this.f13340d, r13 != 0 ? R.color.black_f2f2f4 : R.color.black_f8f8fa);
        }
        if ((6 & j2) != 0) {
            ViewBindingAdapter.setBackground(this.f13340d, Converters.convertColorToDrawable(r13));
        }
        if ((j2 & 5) != 0) {
            TextViewBindingAdapter.setText(this.f13341e, str);
            TextViewBindingAdapter.setText(this.a, str2);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13342f != 0;
        }
    }

    @Override // e.l.k.ob
    public void i(@Nullable CardPackage cardPackage) {
        this.b = cardPackage;
        synchronized (this) {
            this.f13342f |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13342f = 4L;
        }
        requestRebind();
    }

    @Override // e.l.k.ob
    public void j(@Nullable Integer num) {
        this.f13269c = num;
        synchronized (this) {
            this.f13342f |= 2;
        }
        notifyPropertyChanged(11);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (8 == i2) {
            i((CardPackage) obj);
        } else if (11 != i2) {
            return false;
        } else {
            j((Integer) obj);
        }
        return true;
    }

    private pb(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[1]);
        this.f13342f = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13340d = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f13341e = textView;
        textView.setTag(null);
        this.a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
