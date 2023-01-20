package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import kotlin.Pair;

/* loaded from: classes2.dex */
public class hd extends gd {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12805f = null;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f12806g = null;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final FrameLayout f12807c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final TextView f12808d;

    /* renamed from: e  reason: collision with root package name */
    private long f12809e;

    public hd(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f12805f, f12806g));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.f12809e;
            this.f12809e = 0L;
        }
        Pair<String, String> pair = this.b;
        String str = null;
        int i2 = ((j2 & 5) > 0L ? 1 : ((j2 & 5) == 0L ? 0 : -1));
        if (i2 != 0 && pair != null) {
            str = pair.getFirst();
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.f12808d, str);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12809e != 0;
        }
    }

    @Override // e.l.k.gd
    public void i(@Nullable Pair<String, String> pair) {
        this.b = pair;
        synchronized (this) {
            this.f12809e |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12809e = 4L;
        }
        requestRebind();
    }

    @Override // e.l.k.gd
    public void j(@Nullable e.l.g.w0 w0Var) {
        this.a = w0Var;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (8 == i2) {
            i((Pair) obj);
        } else if (10 != i2) {
            return false;
        } else {
            j((e.l.g.w0) obj);
        }
        return true;
    }

    private hd(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f12809e = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f12807c = frameLayout;
        frameLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f12808d = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
