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
import com.jihuanshe.model.SoldProductInfo;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public class fb extends eb {
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12648k = null;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private static final SparseIntArray f12649l = null;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final ConstraintLayout f12650i;

    /* renamed from: j  reason: collision with root package name */
    private long f12651j;

    public fb(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f12648k, f12649l));
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
            j2 = this.f12651j;
            this.f12651j = 0L;
        }
        SoldProductInfo soldProductInfo = this.f12577h;
        String str6 = null;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 == 0 || soldProductInfo == null) {
            str = null;
            str2 = null;
            str3 = null;
            charSequence = null;
            str4 = null;
            str5 = null;
        } else {
            String cardVersionNumber = soldProductInfo.getCardVersionNumber();
            String cardVersionImageUrl = soldProductInfo.getCardVersionImageUrl();
            str3 = soldProductInfo.getQuantityContent();
            charSequence = soldProductInfo.getCardPrice();
            String location = soldProductInfo.getLocation();
            str4 = soldProductInfo.getCardName();
            str5 = cardVersionImageUrl;
            str2 = soldProductInfo.getCardVersionRarity();
            str = cardVersionNumber;
            str6 = location;
        }
        if (i2 != 0) {
            NImageView nImageView = this.a;
            e.t.j.g.y.a(nImageView, str5, null, null, null, null, AppCompatResources.getDrawable(nImageView.getContext(), R.drawable.bg_err_image), null, null, null, null, null, null, null, null, null, null);
            TextViewBindingAdapter.setText(this.b, str6);
            TextViewBindingAdapter.setText(this.f12572c, charSequence);
            TextViewBindingAdapter.setText(this.f12573d, str3);
            TextViewBindingAdapter.setText(this.f12574e, str);
            TextViewBindingAdapter.setText(this.f12575f, str2);
            TextViewBindingAdapter.setText(this.f12576g, str4);
        }
    }

    @Override // e.l.k.eb
    public void h(@Nullable SoldProductInfo soldProductInfo) {
        this.f12577h = soldProductInfo;
        synchronized (this) {
            this.f12651j |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12651j != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12651j = 2L;
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
            h((SoldProductInfo) obj);
            return true;
        }
        return false;
    }

    private fb(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (NImageView) objArr[1], (TextView) objArr[6], (TextView) objArr[3], (TextView) objArr[7], (TextView) objArr[4], (TextView) objArr[5], (TextView) objArr[2]);
        this.f12651j = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12650i = constraintLayout;
        constraintLayout.setTag(null);
        this.a.setTag(null);
        this.b.setTag(null);
        this.f12572c.setTag(null);
        this.f12573d.setTag(null);
        this.f12574e.setTag(null);
        this.f12575f.setTag(null);
        this.f12576g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
