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
public class ba extends aa {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12354f = null;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f12355g = null;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final TextView f12356d;

    /* renamed from: e  reason: collision with root package name */
    private long f12357e;

    public ba(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f12354f, f12355g));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.f12357e;
            this.f12357e = 0L;
        }
        String str = this.b;
        Integer num = this.f12283c;
        e.l.g.r rVar = this.a;
        int i2 = ((9 & j2) > 0L ? 1 : ((9 & j2) == 0L ? 0 : -1));
        boolean z = false;
        int i3 = ((j2 & 14) > 0L ? 1 : ((j2 & 14) == 0L ? 0 : -1));
        if (i3 != 0) {
            if ((rVar != null ? rVar.v() : 0) == ViewDataBinding.safeUnbox(num)) {
                z = true;
            }
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.f12356d, str);
        }
        if (i3 != 0) {
            e.t.j.g.e0.K(this.f12356d, z);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12357e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12357e = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.aa
    public void j(@Nullable String str) {
        this.b = str;
        synchronized (this) {
            this.f12357e |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // e.l.k.aa
    public void k(@Nullable e.l.g.r rVar) {
        this.a = rVar;
        synchronized (this) {
            this.f12357e |= 4;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // e.l.k.aa
    public void l(@Nullable Integer num) {
        this.f12283c = num;
        synchronized (this) {
            this.f12357e |= 2;
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
            j((String) obj);
        } else if (11 == i2) {
            l((Integer) obj);
        } else if (10 != i2) {
            return false;
        } else {
            k((e.l.g.r) obj);
        }
        return true;
    }

    private ba(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f12357e = -1L;
        TextView textView = (TextView) objArr[0];
        this.f12356d = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
