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
import com.jihuanshe.ui.widget.CoinPopupWindow;

/* loaded from: classes2.dex */
public class zd extends yd {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f14071f = null;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f14072g = null;
    @NonNull
    private final LinearLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final TextView f14073c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final TextView f14074d;

    /* renamed from: e  reason: collision with root package name */
    private long f14075e;

    public zd(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f14071f, f14072g));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        String str;
        e.t.j.h.g gVar;
        e.t.j.h.g gVar2;
        int i2;
        synchronized (this) {
            j2 = this.f14075e;
            this.f14075e = 0L;
        }
        CoinPopupWindow coinPopupWindow = this.a;
        e.t.j.h.g gVar3 = null;
        int i3 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i3 != 0) {
            if (coinPopupWindow != null) {
                gVar3 = coinPopupWindow.h(2);
                gVar2 = coinPopupWindow.h(1);
                i2 = coinPopupWindow.c();
            } else {
                gVar2 = null;
                i2 = 0;
            }
            boolean z = i2 == 0;
            if (i3 != 0) {
                j2 |= z ? 8L : 4L;
            }
            str = this.f14074d.getResources().getString(z ? R.string.common_coin : R.string.common_wx_coin);
            gVar = gVar3;
            gVar3 = gVar2;
        } else {
            str = null;
            gVar = null;
        }
        if ((j2 & 3) != 0) {
            e.t.j.g.e0.F(this.f14073c, gVar3);
            TextViewBindingAdapter.setText(this.f14074d, str);
            e.t.j.g.e0.F(this.f14074d, gVar);
        }
    }

    @Override // e.l.k.yd
    public void h(@Nullable CoinPopupWindow coinPopupWindow) {
        this.a = coinPopupWindow;
        synchronized (this) {
            this.f14075e |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14075e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14075e = 2L;
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
            h((CoinPopupWindow) obj);
            return true;
        }
        return false;
    }

    private zd(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f14075e = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.b = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f14073c = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.f14074d = textView2;
        textView2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
