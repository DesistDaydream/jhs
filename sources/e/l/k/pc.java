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
import com.jihuanshe.model.WarehouseProductInfo;
import com.jihuanshe.ui.page.entrepot.SearchChildCheckFragment;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public class pc extends oc {
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13343l = null;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private static final SparseIntArray f13344m = null;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final ConstraintLayout f13345j;

    /* renamed from: k  reason: collision with root package name */
    private long f13346k;

    public pc(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f13343l, f13344m));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        String str;
        String str2;
        String str3;
        CharSequence charSequence;
        String str4;
        String str5;
        synchronized (this) {
            j2 = this.f13346k;
            this.f13346k = 0L;
        }
        WarehouseProductInfo warehouseProductInfo = this.f13276i;
        String str6 = null;
        int i2 = ((j2 & 5) > 0L ? 1 : ((j2 & 5) == 0L ? 0 : -1));
        if (i2 == 0 || warehouseProductInfo == null) {
            str = null;
            str2 = null;
            str3 = null;
            charSequence = null;
            str4 = null;
            str5 = null;
        } else {
            String cardVersionNumber = warehouseProductInfo.getCardVersionNumber();
            String cardVersionImageUrl = warehouseProductInfo.getCardVersionImageUrl();
            str3 = warehouseProductInfo.getQuantityContent();
            charSequence = warehouseProductInfo.getCardPrice();
            String location = warehouseProductInfo.getLocation();
            str4 = warehouseProductInfo.getCardName();
            str5 = cardVersionImageUrl;
            str2 = warehouseProductInfo.getCardVersionRarity();
            str = cardVersionNumber;
            str6 = location;
        }
        if (i2 != 0) {
            NImageView nImageView = this.a;
            e.t.j.g.y.a(nImageView, str5, null, null, null, null, AppCompatResources.getDrawable(nImageView.getContext(), R.drawable.bg_err_image), null, null, null, null, null, null, null, null, null, null);
            TextViewBindingAdapter.setText(this.b, str6);
            TextViewBindingAdapter.setText(this.f13270c, charSequence);
            TextViewBindingAdapter.setText(this.f13271d, str3);
            TextViewBindingAdapter.setText(this.f13272e, str);
            TextViewBindingAdapter.setText(this.f13273f, str2);
            TextViewBindingAdapter.setText(this.f13274g, str4);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13346k != 0;
        }
    }

    @Override // e.l.k.oc
    public void i(@Nullable SearchChildCheckFragment searchChildCheckFragment) {
        this.f13275h = searchChildCheckFragment;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13346k = 4L;
        }
        requestRebind();
    }

    @Override // e.l.k.oc
    public void j(@Nullable WarehouseProductInfo warehouseProductInfo) {
        this.f13276i = warehouseProductInfo;
        synchronized (this) {
            this.f13346k |= 1;
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
            j((WarehouseProductInfo) obj);
        } else if (5 != i2) {
            return false;
        } else {
            i((SearchChildCheckFragment) obj);
        }
        return true;
    }

    private pc(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (NImageView) objArr[1], (TextView) objArr[6], (TextView) objArr[3], (TextView) objArr[7], (TextView) objArr[4], (TextView) objArr[5], (TextView) objArr[2]);
        this.f13346k = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13345j = constraintLayout;
        constraintLayout.setTag(null);
        this.a.setTag(null);
        this.b.setTag(null);
        this.f13270c.setTag(null);
        this.f13271d.setTag(null);
        this.f13272e.setTag(null);
        this.f13273f.setTag(null);
        this.f13274g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
