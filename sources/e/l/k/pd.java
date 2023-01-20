package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.model.RecentPhoto;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public class pd extends od {
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13347e = null;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f13348f = null;
    @NonNull
    private final ConstraintLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final NImageView f13349c;

    /* renamed from: d  reason: collision with root package name */
    private long f13350d;

    public pd(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f13347e, f13348f));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.f13350d;
            this.f13350d = 0L;
        }
        RecentPhoto recentPhoto = this.a;
        String str = null;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 != 0 && recentPhoto != null) {
            str = recentPhoto.getUrl();
        }
        String str2 = str;
        if (i2 != 0) {
            e.t.j.g.y.a(this.f13349c, str2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
        }
    }

    @Override // e.l.k.od
    public void h(@Nullable RecentPhoto recentPhoto) {
        this.a = recentPhoto;
        synchronized (this) {
            this.f13350d |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13350d != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13350d = 2L;
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
            h((RecentPhoto) obj);
            return true;
        }
        return false;
    }

    private pd(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f13350d = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.b = constraintLayout;
        constraintLayout.setTag(null);
        NImageView nImageView = (NImageView) objArr[1];
        this.f13349c = nImageView;
        nImageView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
