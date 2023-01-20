package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.AddressDialog3;
import com.xres.address_selector.widget.address_selector.AddressSelectorView3;

/* loaded from: classes2.dex */
public class j3 extends i3 {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12926f = null;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f12927g;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final LinearLayout f12928c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final ImageView f12929d;

    /* renamed from: e  reason: collision with root package name */
    private long f12930e;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f12927g = sparseIntArray;
        sparseIntArray.put(R.id.selectView, 2);
    }

    public j3(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f12926f, f12927g));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.f12930e;
            this.f12930e = 0L;
        }
        int i2 = 0;
        e.t.j.h.g gVar = null;
        AddressDialog3 addressDialog3 = this.b;
        int i3 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i3 != 0 && addressDialog3 != null) {
            i2 = addressDialog3.getH();
            gVar = addressDialog3.getOnClose();
        }
        if (i3 != 0) {
            e.t.j.g.e0.u(this.f12928c, i2);
            e.t.j.g.e0.F(this.f12929d, gVar);
        }
    }

    @Override // e.l.k.i3
    public void h(@Nullable AddressDialog3 addressDialog3) {
        this.b = addressDialog3;
        synchronized (this) {
            this.f12930e |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12930e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12930e = 2L;
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
            h((AddressDialog3) obj);
            return true;
        }
        return false;
    }

    private j3(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AddressSelectorView3) objArr[2]);
        this.f12930e = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f12928c = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f12929d = imageView;
        imageView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
