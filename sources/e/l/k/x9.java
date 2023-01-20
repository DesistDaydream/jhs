package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jihuanshe.R;
import com.jihuanshe.model.CoinLog;

/* loaded from: classes2.dex */
public class x9 extends w9 {
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13910h = null;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static final SparseIntArray f13911i;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final ConstraintLayout f13912f;

    /* renamed from: g  reason: collision with root package name */
    private long f13913g;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13911i = sparseIntArray;
        sparseIntArray.put(R.id.withDrawTv, 4);
    }

    public x9(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f13910h, f13911i));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        String str;
        String str2;
        synchronized (this) {
            j2 = this.f13913g;
            this.f13913g = 0L;
        }
        CoinLog coinLog = this.f13851e;
        CharSequence charSequence = null;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 == 0 || coinLog == null) {
            str = null;
            str2 = null;
        } else {
            String time = coinLog.getTime();
            CharSequence moneyStr = coinLog.getMoneyStr();
            str2 = coinLog.getStatusText();
            charSequence = moneyStr;
            str = time;
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.a, charSequence);
            TextViewBindingAdapter.setText(this.b, str2);
            TextViewBindingAdapter.setText(this.f13849c, str);
        }
    }

    @Override // e.l.k.w9
    public void h(@Nullable CoinLog coinLog) {
        this.f13851e = coinLog;
        synchronized (this) {
            this.f13913g |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13913g != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13913g = 2L;
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
            h((CoinLog) obj);
            return true;
        }
        return false;
    }

    private x9(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[3], (TextView) objArr[1], (TextView) objArr[2], (TextView) objArr[4]);
        this.f13913g = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13912f = constraintLayout;
        constraintLayout.setTag(null);
        this.a.setTag(null);
        this.b.setTag(null);
        this.f13849c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
