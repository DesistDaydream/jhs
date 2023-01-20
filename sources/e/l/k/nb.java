package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jihuanshe.R;
import com.jihuanshe.model.OrderReturnInfo;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public class nb extends mb {
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13208k = null;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private static final SparseIntArray f13209l = null;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final ConstraintLayout f13210h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final ImageView f13211i;

    /* renamed from: j  reason: collision with root package name */
    private long f13212j;

    public nb(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f13208k, f13209l));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        boolean z;
        synchronized (this) {
            j2 = this.f13212j;
            this.f13212j = 0L;
        }
        OrderReturnInfo orderReturnInfo = this.f13135g;
        String str9 = null;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 != 0) {
            if (orderReturnInfo != null) {
                str9 = orderReturnInfo.getCardVersionNumber();
                str7 = orderReturnInfo.getCardVersionImageUrl();
                str3 = orderReturnInfo.getQuantityContent();
                str8 = orderReturnInfo.getLocation();
                str5 = orderReturnInfo.getCardName();
                str6 = orderReturnInfo.getCardVersionRarity();
                z = orderReturnInfo.isFail();
            } else {
                str7 = null;
                str3 = null;
                str8 = null;
                str5 = null;
                str6 = null;
                z = false;
            }
            if (i2 != 0) {
                j2 |= z ? 8L : 4L;
            }
            r10 = z ? 0 : 8;
            str4 = str7;
            str2 = str9;
            str = str8;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
        }
        if ((j2 & 3) != 0) {
            this.f13211i.setVisibility(r10);
            NImageView nImageView = this.a;
            e.t.j.g.y.a(nImageView, str4, null, null, null, null, AppCompatResources.getDrawable(nImageView.getContext(), R.drawable.bg_err_image), null, null, null, null, null, null, Boolean.FALSE, null, null, null);
            TextViewBindingAdapter.setText(this.b, str);
            TextViewBindingAdapter.setText(this.f13131c, str3);
            TextViewBindingAdapter.setText(this.f13132d, str2);
            TextViewBindingAdapter.setText(this.f13133e, str6);
            TextViewBindingAdapter.setText(this.f13134f, str5);
        }
    }

    @Override // e.l.k.mb
    public void h(@Nullable OrderReturnInfo orderReturnInfo) {
        this.f13135g = orderReturnInfo;
        synchronized (this) {
            this.f13212j |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13212j != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13212j = 2L;
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
            h((OrderReturnInfo) obj);
            return true;
        }
        return false;
    }

    private nb(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (NImageView) objArr[1], (TextView) objArr[5], (TextView) objArr[7], (TextView) objArr[3], (TextView) objArr[4], (TextView) objArr[2]);
        this.f13212j = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13210h = constraintLayout;
        constraintLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[6];
        this.f13211i = imageView;
        imageView.setTag(null);
        this.a.setTag(null);
        this.b.setTag(null);
        this.f13131c.setTag(null);
        this.f13132d.setTag(null);
        this.f13133e.setTag(null);
        this.f13134f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
