package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.widget.InteractPopupWindow;

/* loaded from: classes2.dex */
public class ne extends me {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13217f = null;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f13218g;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final RelativeLayout f13219c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final TextView f13220d;

    /* renamed from: e  reason: collision with root package name */
    private long f13221e;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13218g = sparseIntArray;
        sparseIntArray.put(R.id.list, 2);
    }

    public ne(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f13217f, f13218g));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.f13221e;
            this.f13221e = 0L;
        }
        InteractPopupWindow interactPopupWindow = this.b;
        e.t.j.h.g gVar = null;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 != 0 && interactPopupWindow != null) {
            gVar = interactPopupWindow.c();
        }
        if (i2 != 0) {
            e.t.j.g.e0.F(this.f13220d, gVar);
        }
    }

    @Override // e.l.k.me
    public void h(@Nullable InteractPopupWindow interactPopupWindow) {
        this.b = interactPopupWindow;
        synchronized (this) {
            this.f13221e |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13221e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13221e = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            h((InteractPopupWindow) obj);
            return true;
        }
        return false;
    }

    private ne(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[2]);
        this.f13221e = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f13219c = relativeLayout;
        relativeLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f13220d = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
