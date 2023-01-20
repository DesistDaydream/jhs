package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.google.android.material.button.MaterialButton;
import com.jihuanshe.R;
import com.jihuanshe.model.OrderDetailInfo;
import com.jihuanshe.ui.dialog.ChangePriceDialog;

/* loaded from: classes2.dex */
public class b4 extends a4 {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts n = null;
    @Nullable
    private static final SparseIntArray o;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final ConstraintLayout f12335j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final TextView f12336k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private final MaterialButton f12337l;

    /* renamed from: m  reason: collision with root package name */
    private long f12338m;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        o = sparseIntArray;
        sparseIntArray.put(R.id.priceTtile, 7);
        sparseIntArray.put(R.id.shippingTitle, 8);
        sparseIntArray.put(R.id.divider, 9);
        sparseIntArray.put(R.id.ll_tips, 10);
    }

    public b4(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, n, o));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        CharSequence charSequence;
        String str;
        e.t.j.h.g gVar;
        e.t.j.h.g gVar2;
        String str2;
        String str3;
        e.t.j.h.g gVar3;
        OrderDetailInfo orderDetailInfo;
        synchronized (this) {
            j2 = this.f12338m;
            this.f12338m = 0L;
        }
        ChangePriceDialog changePriceDialog = this.f12259i;
        e.t.j.h.g gVar4 = null;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 != 0) {
            if (changePriceDialog != null) {
                gVar3 = changePriceDialog.getOnClickClose();
                orderDetailInfo = changePriceDialog.getOrder();
                gVar = changePriceDialog.getOnClickTip();
                gVar2 = changePriceDialog.getOnClickSave();
                str3 = changePriceDialog.getPriceEtTextStr();
                str2 = changePriceDialog.getShippingEtTextStr();
            } else {
                gVar3 = null;
                orderDetailInfo = null;
                gVar = null;
                gVar2 = null;
                str2 = null;
                str3 = null;
            }
            if (orderDetailInfo != null) {
                CharSequence orderPriceStrBySeller2 = orderDetailInfo.getOrderPriceStrBySeller2();
                str = orderDetailInfo.getServiceCharge2();
                gVar4 = gVar3;
                charSequence = orderPriceStrBySeller2;
            } else {
                str = null;
                gVar4 = gVar3;
                charSequence = null;
            }
        } else {
            charSequence = null;
            str = null;
            gVar = null;
            gVar2 = null;
            str2 = null;
            str3 = null;
        }
        if (i2 != 0) {
            e.t.j.g.e0.F(this.a, gVar4);
            TextViewBindingAdapter.setText(this.f12336k, charSequence);
            e.t.j.g.e0.F(this.f12337l, gVar2);
            TextViewBindingAdapter.setText(this.f12254d, str3);
            TextViewBindingAdapter.setText(this.f12256f, str2);
            TextViewBindingAdapter.setText(this.f12258h, str);
            e.t.j.g.e0.F(this.f12258h, gVar);
        }
    }

    @Override // e.l.k.a4
    public void h(@Nullable ChangePriceDialog changePriceDialog) {
        this.f12259i = changePriceDialog;
        synchronized (this) {
            this.f12338m |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12338m != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12338m = 2L;
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
            h((ChangePriceDialog) obj);
            return true;
        }
        return false;
    }

    private b4(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (View) objArr[9], (LinearLayout) objArr[10], (EditText) objArr[2], (TextView) objArr[7], (EditText) objArr[3], (TextView) objArr[8], (TextView) objArr[4]);
        this.f12338m = -1L;
        this.a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12335j = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[5];
        this.f12336k = textView;
        textView.setTag(null);
        MaterialButton materialButton = (MaterialButton) objArr[6];
        this.f12337l = materialButton;
        materialButton.setTag(null);
        this.f12254d.setTag(null);
        this.f12256f.setTag(null);
        this.f12258h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
