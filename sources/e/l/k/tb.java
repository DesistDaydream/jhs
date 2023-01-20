package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import kotlin.Pair;

/* loaded from: classes2.dex */
public class tb extends sb {
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13634d = null;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private static final SparseIntArray f13635e = null;
    @NonNull
    private final TextView b;

    /* renamed from: c  reason: collision with root package name */
    private long f13636c;

    public tb(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f13634d, f13635e));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.f13636c;
            this.f13636c = 0L;
        }
        Pair<String, String> pair = this.a;
        String str = null;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 != 0 && pair != null) {
            str = pair.getFirst();
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.b, str);
        }
    }

    @Override // e.l.k.sb
    public void h(@Nullable Pair<String, String> pair) {
        this.a = pair;
        synchronized (this) {
            this.f13636c |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13636c != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13636c = 2L;
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
            h((Pair) obj);
            return true;
        }
        return false;
    }

    private tb(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f13636c = -1L;
        TextView textView = (TextView) objArr[0];
        this.b = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
