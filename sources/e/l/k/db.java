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
import com.jihuanshe.model.FailProductInfo;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public class db extends cb {
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12512m = null;
    @Nullable
    private static final SparseIntArray n = null;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final ConstraintLayout f12513k;

    /* renamed from: l  reason: collision with root package name */
    private long f12514l;

    public db(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, f12512m, n));
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
        String str9;
        String str10;
        synchronized (this) {
            j2 = this.f12514l;
            this.f12514l = 0L;
        }
        FailProductInfo failProductInfo = this.f12433j;
        String str11 = null;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 != 0) {
            if (failProductInfo != null) {
                str2 = failProductInfo.getCardVersionNumber();
                str10 = failProductInfo.getCardVersionImageUrl();
                str3 = failProductInfo.getCardName();
                str11 = failProductInfo.getOrderUuid();
                str4 = failProductInfo.getQuantityContent();
                str5 = failProductInfo.statusCard();
                str6 = failProductInfo.getLocation();
                str7 = failProductInfo.getCardVersionRarity();
                str9 = failProductInfo.getOrderReceivedDate();
            } else {
                str9 = null;
                str2 = null;
                str10 = null;
                str3 = null;
                str4 = null;
                str5 = null;
                str6 = null;
                str7 = null;
            }
            String string = this.f12430g.getResources().getString(R.string.order_num, str11);
            str8 = str10;
            str11 = this.b.getResources().getString(R.string.order_received_date, str9);
            str = string;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            str8 = null;
        }
        if (i2 != 0) {
            NImageView nImageView = this.a;
            e.t.j.g.y.a(nImageView, str8, null, null, null, null, AppCompatResources.getDrawable(nImageView.getContext(), R.drawable.bg_err_image), null, null, null, null, null, null, null, null, null, null);
            TextViewBindingAdapter.setText(this.b, str11);
            TextViewBindingAdapter.setText(this.f12426c, str6);
            TextViewBindingAdapter.setText(this.f12427d, str5);
            TextViewBindingAdapter.setText(this.f12428e, str4);
            TextViewBindingAdapter.setText(this.f12429f, str2);
            TextViewBindingAdapter.setText(this.f12430g, str);
            TextViewBindingAdapter.setText(this.f12431h, str7);
            TextViewBindingAdapter.setText(this.f12432i, str3);
        }
    }

    @Override // e.l.k.cb
    public void h(@Nullable FailProductInfo failProductInfo) {
        this.f12433j = failProductInfo;
        synchronized (this) {
            this.f12514l |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12514l != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12514l = 2L;
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
            h((FailProductInfo) obj);
            return true;
        }
        return false;
    }

    private db(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (NImageView) objArr[1], (TextView) objArr[9], (TextView) objArr[6], (TextView) objArr[3], (TextView) objArr[7], (TextView) objArr[4], (TextView) objArr[8], (TextView) objArr[5], (TextView) objArr[2]);
        this.f12514l = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12513k = constraintLayout;
        constraintLayout.setTag(null);
        this.a.setTag(null);
        this.b.setTag(null);
        this.f12426c.setTag(null);
        this.f12427d.setTag(null);
        this.f12428e.setTag(null);
        this.f12429f.setTag(null);
        this.f12430g.setTag(null);
        this.f12431h.setTag(null);
        this.f12432i.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
