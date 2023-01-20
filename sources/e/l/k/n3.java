package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jihuanshe.R;
import com.jihuanshe.model.OrderDetailInfo;
import com.jihuanshe.ui.dialog.BackProductDialog;

/* loaded from: classes2.dex */
public class n3 extends m3 {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts q = null;
    @Nullable
    private static final SparseIntArray r;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    private final ConstraintLayout f13174m;
    @NonNull
    private final TextView n;
    @NonNull
    private final TextView o;
    private long p;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        r = sparseIntArray;
        sparseIntArray.put(R.id.goodsView, 7);
        sparseIntArray.put(R.id.rb1, 8);
        sparseIntArray.put(R.id.rb2, 9);
        sparseIntArray.put(R.id.refundView, 10);
        sparseIntArray.put(R.id.refundBtn, 11);
        sparseIntArray.put(R.id.reAllBtn, 12);
        sparseIntArray.put(R.id.infoView, 13);
    }

    public n3(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 14, q, r));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.t.j.h.g gVar;
        e.t.j.h.c0 c0Var;
        e.t.j.h.c0 c0Var2;
        String str;
        e.t.j.h.g gVar2;
        e.t.j.h.g gVar3;
        OrderDetailInfo orderDetailInfo;
        synchronized (this) {
            j2 = this.p;
            this.p = 0L;
        }
        BackProductDialog backProductDialog = this.f13112l;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 != 0) {
            if (backProductDialog != null) {
                gVar = backProductDialog.getOnSave();
                c0Var = backProductDialog.getOnCheckedChanged();
                c0Var2 = backProductDialog.getOnCheckedChanged2();
                orderDetailInfo = backProductDialog.getInfo();
                gVar3 = backProductDialog.getOnChooseReason();
                gVar2 = backProductDialog.getOnClickCancel();
            } else {
                gVar = null;
                c0Var = null;
                c0Var2 = null;
                orderDetailInfo = null;
                gVar2 = null;
                gVar3 = null;
            }
            str = this.f13103c.getResources().getString(R.string.shop_price_, Float.valueOf(orderDetailInfo != null ? orderDetailInfo.getOrderPrice() : 0.0f));
        } else {
            gVar = null;
            c0Var = null;
            c0Var2 = null;
            str = null;
            gVar2 = null;
            gVar3 = null;
        }
        if (i2 != 0) {
            e.t.j.g.e0.F(this.n, gVar2);
            e.t.j.g.e0.F(this.o, gVar);
            TextViewBindingAdapter.setText(this.f13103c, str);
            e.t.j.g.e0.F(this.f13107g, gVar3);
            e.t.j.g.b0.e(this.f13109i, c0Var2, null);
            e.t.j.g.b0.e(this.f13111k, c0Var, null);
        }
    }

    @Override // e.l.k.m3
    public void h(@Nullable BackProductDialog backProductDialog) {
        this.f13112l = backProductDialog;
        synchronized (this) {
            this.p |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.p != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.p = 2L;
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
            h((BackProductDialog) obj);
            return true;
        }
        return false;
    }

    private n3(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[7], (LinearLayout) objArr[13], (TextView) objArr[4], (RadioButton) objArr[8], (RadioButton) objArr[9], (RadioButton) objArr[12], (TextView) objArr[3], (RadioButton) objArr[11], (RadioGroup) objArr[2], (LinearLayout) objArr[10], (RadioGroup) objArr[1]);
        this.p = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13174m = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[5];
        this.n = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[6];
        this.o = textView2;
        textView2.setTag(null);
        this.f13103c.setTag(null);
        this.f13107g.setTag(null);
        this.f13109i.setTag(null);
        this.f13111k.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
