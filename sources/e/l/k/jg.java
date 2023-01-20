package e.l.k;

import android.text.TextWatcher;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jihuanshe.R;
import com.jihuanshe.model.CardProductNew;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.ui.widget.NumberView;
import com.vector.databinding.adapter.EditTextBinding;

/* loaded from: classes2.dex */
public class jg extends ig {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts t = null;
    @Nullable
    private static final SparseIntArray u;
    @NonNull
    private final ConstraintLayout r;
    private long s;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        u = sparseIntArray;
        sparseIntArray.put(R.id.starPriceTv, 6);
        sparseIntArray.put(R.id.priceTitleTv, 7);
        sparseIntArray.put(R.id.yuanTv, 8);
        sparseIntArray.put(R.id.priceInfoLayout, 9);
        sparseIntArray.put(R.id.minPriceTv, 10);
        sparseIntArray.put(R.id.avgPriceTv, 11);
        sparseIntArray.put(R.id.starCountTv, 12);
        sparseIntArray.put(R.id.countTitleTv, 13);
        sparseIntArray.put(R.id.descTitleTv, 14);
    }

    public jg(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 15, t, u));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        String str;
        String str2;
        String str3;
        TextWatcher textWatcher;
        int i2;
        synchronized (this) {
            j2 = this.s;
            this.s = 0L;
        }
        CardProductNew cardProductNew = this.o;
        GameCard gameCard = this.p;
        e.l.q.b.b.a.d dVar = this.q;
        int i3 = ((9 & j2) > 0L ? 1 : ((9 & j2) == 0L ? 0 : -1));
        if (i3 == 0 || cardProductNew == null) {
            str = null;
            str2 = null;
        } else {
            str2 = cardProductNew.getMin();
            str = cardProductNew.getAvf();
        }
        int i4 = ((10 & j2) > 0L ? 1 : ((10 & j2) == 0L ? 0 : -1));
        CharSequence price2 = (i4 == 0 || gameCard == null) ? null : gameCard.getPrice2();
        int i5 = 0;
        int i6 = ((j2 & 12) > 0L ? 1 : ((j2 & 12) == 0L ? 0 : -1));
        if (i6 == 0 || dVar == null) {
            str3 = null;
            textWatcher = null;
            i2 = 0;
        } else {
            int e2 = dVar.e();
            str3 = dVar.d(true);
            textWatcher = dVar.b();
            i5 = dVar.a(true);
            i2 = e2;
        }
        if (i3 != 0) {
            TextViewBindingAdapter.setText(this.b, str);
            TextViewBindingAdapter.setText(this.f12907g, str2);
        }
        if (i6 != 0) {
            TextViewBindingAdapter.setText(this.f12904d, str3);
            e.l.i.s.a(this.f12908h, Integer.valueOf(i5), Integer.valueOf(i2), null, null);
            EditTextBinding.j(this.f12910j, textWatcher);
        }
        if (i4 != 0) {
            TextViewBindingAdapter.setText(this.f12910j, price2);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.s != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.s = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.ig
    public void j(@Nullable e.l.q.b.b.a.d dVar) {
        this.q = dVar;
        synchronized (this) {
            this.s |= 4;
        }
        notifyPropertyChanged(6);
        super.requestRebind();
    }

    @Override // e.l.k.ig
    public void k(@Nullable CardProductNew cardProductNew) {
        this.o = cardProductNew;
        synchronized (this) {
            this.s |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // e.l.k.ig
    public void l(@Nullable GameCard gameCard) {
        this.p = gameCard;
        synchronized (this) {
            this.s |= 2;
        }
        notifyPropertyChanged(12);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (8 == i2) {
            k((CardProductNew) obj);
        } else if (12 == i2) {
            l((GameCard) obj);
        } else if (6 != i2) {
            return false;
        } else {
            j((e.l.q.b.b.a.d) obj);
        }
        return true;
    }

    private jg(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[11], (TextView) objArr[3], (TextView) objArr[13], (EditText) objArr[5], (TextView) objArr[14], (TextView) objArr[10], (TextView) objArr[2], (NumberView) objArr[4], (ConstraintLayout) objArr[9], (EditText) objArr[1], (TextView) objArr[7], (TextView) objArr[12], (TextView) objArr[6], (TextView) objArr[8]);
        this.s = -1L;
        this.b.setTag(null);
        this.f12904d.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.r = constraintLayout;
        constraintLayout.setTag(null);
        this.f12907g.setTag(null);
        this.f12908h.setTag(null);
        this.f12910j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
