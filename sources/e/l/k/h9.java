package e.l.k;

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
import com.jihuanshe.R;
import com.jihuanshe.model.CardConsignmentInfo;
import com.jihuanshe.ui.page.entrepot.ConsignmentOrderFragment;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public class h9 extends g9 {
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12787i = null;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static final SparseIntArray f12788j = null;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final ConstraintLayout f12789g;

    /* renamed from: h  reason: collision with root package name */
    private long f12790h;

    public h9(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f12787i, f12788j));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        String str;
        String str2;
        String str3;
        synchronized (this) {
            j2 = this.f12790h;
            this.f12790h = 0L;
        }
        CardConsignmentInfo cardConsignmentInfo = this.f12736f;
        String str4 = null;
        int i2 = ((j2 & 5) > 0L ? 1 : ((j2 & 5) == 0L ? 0 : -1));
        if (i2 == 0 || cardConsignmentInfo == null) {
            str = null;
            str2 = null;
            str3 = null;
        } else {
            String uuidStr = cardConsignmentInfo.getUuidStr();
            String createdAt = cardConsignmentInfo.getCreatedAt();
            String orderImage = cardConsignmentInfo.getOrderImage();
            str = cardConsignmentInfo.getOrderName();
            str3 = orderImage;
            str4 = createdAt;
            str2 = uuidStr;
        }
        if (i2 != 0) {
            NImageView nImageView = this.a;
            e.t.j.g.y.a(nImageView, str3, null, null, null, null, AppCompatResources.getDrawable(nImageView.getContext(), R.drawable.bg_err_image), null, null, null, null, null, null, null, null, null, null);
            TextViewBindingAdapter.setText(this.b, str4);
            TextViewBindingAdapter.setText(this.f12733c, str);
            TextViewBindingAdapter.setText(this.f12734d, str2);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12790h != 0;
        }
    }

    @Override // e.l.k.g9
    public void i(@Nullable ConsignmentOrderFragment consignmentOrderFragment) {
        this.f12735e = consignmentOrderFragment;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12790h = 4L;
        }
        requestRebind();
    }

    @Override // e.l.k.g9
    public void j(@Nullable CardConsignmentInfo cardConsignmentInfo) {
        this.f12736f = cardConsignmentInfo;
        synchronized (this) {
            this.f12790h |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (8 == i2) {
            j((CardConsignmentInfo) obj);
        } else if (5 != i2) {
            return false;
        } else {
            i((ConsignmentOrderFragment) obj);
        }
        return true;
    }

    private h9(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (NImageView) objArr[1], (TextView) objArr[3], (TextView) objArr[2], (TextView) objArr[4]);
        this.f12790h = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12789g = constraintLayout;
        constraintLayout.setTag(null);
        this.a.setTag(null);
        this.b.setTag(null);
        this.f12733c.setTag(null);
        this.f12734d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
