package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
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
import com.jihuanshe.model.ReturnCardInfo;
import com.jihuanshe.ui.page.entrepot.ApplyForReturnActivity;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public class z8 extends y8 {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts o = null;
    @Nullable
    private static final SparseIntArray p = null;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private final ConstraintLayout f14055l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    private final ImageView f14056m;
    private long n;

    public z8(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, o, p));
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
        boolean z2;
        int i2;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        boolean z3;
        synchronized (this) {
            j2 = this.n;
            this.n = 0L;
        }
        ReturnCardInfo returnCardInfo = this.f13979k;
        String str15 = null;
        int i3 = ((j2 & 5) > 0L ? 1 : ((j2 & 5) == 0L ? 0 : -1));
        if (i3 != 0) {
            if (returnCardInfo != null) {
                String cardVersionNumber = returnCardInfo.getCardVersionNumber();
                String cardVersionImageUrl = returnCardInfo.getCardVersionImageUrl();
                String cardName = returnCardInfo.getCardName();
                String failType = returnCardInfo.getFailType();
                str11 = returnCardInfo.getCardNameOrigin();
                str12 = returnCardInfo.getQuantityContent();
                str13 = returnCardInfo.statusCard();
                str14 = returnCardInfo.getLocation();
                z3 = returnCardInfo.isChecked();
                str = returnCardInfo.getCardVersionRarity();
                str9 = cardVersionImageUrl;
                str2 = cardVersionNumber;
                str15 = failType;
                str10 = cardName;
            } else {
                str = null;
                str2 = null;
                str9 = null;
                str10 = null;
                str11 = null;
                str12 = null;
                str13 = null;
                str14 = null;
                z3 = false;
            }
            z = str15 == null;
            if (i3 != 0) {
                j2 = z ? j2 | 16 : j2 | 8;
            }
            str6 = str11;
            str4 = str12;
            str5 = str13;
            str8 = str14;
            z2 = z3;
            String str16 = str10;
            str7 = str9;
            str3 = str16;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            str8 = null;
            z = false;
            z2 = false;
        }
        boolean isEmpty = ((8 & j2) == 0 || str15 == null) ? false : str15.isEmpty();
        int i4 = ((j2 & 5) > 0L ? 1 : ((j2 & 5) == 0L ? 0 : -1));
        if (i4 != 0) {
            boolean z4 = z ? true : isEmpty;
            if (i4 != 0) {
                j2 |= z4 ? 64L : 32L;
            }
            i2 = z4 ? 8 : 0;
        } else {
            i2 = 0;
        }
        if ((j2 & 5) != 0) {
            e.t.j.g.s.d(this.a, z2);
            this.f14056m.setVisibility(i2);
            NImageView nImageView = this.b;
            e.t.j.g.y.a(nImageView, str7, null, null, null, null, AppCompatResources.getDrawable(nImageView.getContext(), R.drawable.bg_err_image), null, null, null, null, null, null, Boolean.FALSE, null, null, null);
            TextViewBindingAdapter.setText(this.f13971c, str8);
            TextViewBindingAdapter.setText(this.f13972d, str5);
            TextViewBindingAdapter.setText(this.f13973e, str6);
            TextViewBindingAdapter.setText(this.f13974f, str4);
            TextViewBindingAdapter.setText(this.f13975g, str2);
            TextViewBindingAdapter.setText(this.f13976h, str);
            TextViewBindingAdapter.setText(this.f13977i, str3);
        }
    }

    @Override // e.l.k.y8
    public void h(@Nullable ApplyForReturnActivity applyForReturnActivity) {
        this.f13978j = applyForReturnActivity;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.n != 0;
        }
    }

    @Override // e.l.k.y8
    public void i(@Nullable ReturnCardInfo returnCardInfo) {
        this.f13979k = returnCardInfo;
        synchronized (this) {
            this.n |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.n = 4L;
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
            i((ReturnCardInfo) obj);
            return true;
        } else if (1 == i2) {
            h((ApplyForReturnActivity) obj);
            return true;
        } else {
            return false;
        }
    }

    private z8(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CheckBox) objArr[1], (NImageView) objArr[2], (TextView) objArr[8], (TextView) objArr[5], (TextView) objArr[4], (TextView) objArr[10], (TextView) objArr[6], (TextView) objArr[7], (TextView) objArr[3]);
        this.n = -1L;
        this.a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f14055l = constraintLayout;
        constraintLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[9];
        this.f14056m = imageView;
        imageView.setTag(null);
        this.b.setTag(null);
        this.f13971c.setTag(null);
        this.f13972d.setTag(null);
        this.f13973e.setTag(null);
        this.f13974f.setTag(null);
        this.f13975g.setTag(null);
        this.f13976h.setTag(null);
        this.f13977i.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
