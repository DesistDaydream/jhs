package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jihuanshe.R;
import com.jihuanshe.model.GameCard;

/* loaded from: classes2.dex */
public class hb extends gb {
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12793h = null;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static final SparseIntArray f12794i = null;
    @NonNull
    private final LinearLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final TextView f12795c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final TextView f12796d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final TextView f12797e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final TextView f12798f;

    /* renamed from: g  reason: collision with root package name */
    private long f12799g;

    public hb(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f12793h, f12794i));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        String str;
        String str2;
        CharSequence charSequence;
        int i2;
        synchronized (this) {
            j2 = this.f12799g;
            this.f12799g = 0L;
        }
        GameCard gameCard = this.a;
        String str3 = null;
        int i3 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i3 != 0) {
            if (gameCard != null) {
                String conditionStr = gameCard.getConditionStr();
                i2 = gameCard.getQuantity();
                str2 = gameCard.getRemark();
                charSequence = gameCard.getPrice();
                str3 = conditionStr;
            } else {
                str2 = null;
                charSequence = null;
                i2 = 0;
            }
            str = this.f12796d.getResources().getString(R.string.common_number, Integer.valueOf(i2));
        } else {
            str = null;
            str2 = null;
            charSequence = null;
        }
        if (i3 != 0) {
            TextViewBindingAdapter.setText(this.f12795c, str3);
            TextViewBindingAdapter.setText(this.f12796d, str);
            TextViewBindingAdapter.setText(this.f12797e, str2);
            TextViewBindingAdapter.setText(this.f12798f, charSequence);
        }
    }

    @Override // e.l.k.gb
    public void h(@Nullable GameCard gameCard) {
        this.a = gameCard;
        synchronized (this) {
            this.f12799g |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12799g != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12799g = 2L;
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
            h((GameCard) obj);
            return true;
        }
        return false;
    }

    private hb(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f12799g = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.b = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f12795c = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.f12796d = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[3];
        this.f12797e = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[4];
        this.f12798f = textView4;
        textView4.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
