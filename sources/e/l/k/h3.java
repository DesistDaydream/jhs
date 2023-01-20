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
import com.jihuanshe.ui.dialog.AddressDialog2;
import com.xres.address_selector.widget.address_selector.AddressSelectorView2;

/* loaded from: classes2.dex */
public class h3 extends g3 {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12765f = null;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f12766g;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final LinearLayout f12767c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final ImageView f12768d;

    /* renamed from: e  reason: collision with root package name */
    private long f12769e;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f12766g = sparseIntArray;
        sparseIntArray.put(R.id.selectView, 2);
    }

    public h3(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f12765f, f12766g));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.f12769e;
            this.f12769e = 0L;
        }
        int i2 = 0;
        e.t.j.h.g gVar = null;
        AddressDialog2 addressDialog2 = this.b;
        int i3 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i3 != 0 && addressDialog2 != null) {
            i2 = addressDialog2.getH();
            gVar = addressDialog2.getOnClose();
        }
        if (i3 != 0) {
            e.t.j.g.e0.u(this.f12767c, i2);
            e.t.j.g.e0.F(this.f12768d, gVar);
        }
    }

    @Override // e.l.k.g3
    public void h(@Nullable AddressDialog2 addressDialog2) {
        this.b = addressDialog2;
        synchronized (this) {
            this.f12769e |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12769e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12769e = 2L;
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
            h((AddressDialog2) obj);
            return true;
        }
        return false;
    }

    private h3(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AddressSelectorView2) objArr[2]);
        this.f12769e = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f12767c = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f12768d = imageView;
        imageView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
