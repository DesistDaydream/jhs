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
import com.eth.model.NLive;
import com.jihuanshe.model.User;
import com.jihuanshe.ui.page.user.CoinActivity;
import com.jihuanshe.viewmodel.user.CoinViewModel;

/* loaded from: classes2.dex */
public class vf extends uf {
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13785g = null;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f13786h = null;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final LinearLayout f13787d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final TextView f13788e;

    /* renamed from: f  reason: collision with root package name */
    private long f13789f;

    public vf(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f13785g, f13786h));
    }

    private boolean k(NLive<User> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13789f |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.f13789f;
            this.f13789f = 0L;
        }
        CoinActivity coinActivity = this.b;
        CoinViewModel coinViewModel = this.f13725c;
        CharSequence charSequence = null;
        int i2 = ((10 & j2) > 0L ? 1 : ((10 & j2) == 0L ? 0 : -1));
        e.t.j.h.g f0 = (i2 == 0 || coinActivity == null) ? null : coinActivity.f0();
        int i3 = ((j2 & 13) > 0L ? 1 : ((j2 & 13) == 0L ? 0 : -1));
        if (i3 != 0) {
            NLive<User> u0 = coinViewModel != null ? coinViewModel.u0() : null;
            updateLiveDataRegistration(0, u0);
            User value = u0 != null ? u0.getValue() : null;
            if (value != null) {
                charSequence = value.getBalanceStr();
            }
        }
        if (i2 != 0) {
            e.t.j.g.e0.F(this.f13788e, f0);
        }
        if (i3 != 0) {
            TextViewBindingAdapter.setText(this.a, charSequence);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13789f != 0;
        }
    }

    @Override // e.l.k.uf
    public void i(@Nullable CoinActivity coinActivity) {
        this.b = coinActivity;
        synchronized (this) {
            this.f13789f |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13789f = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.uf
    public void j(@Nullable CoinViewModel coinViewModel) {
        this.f13725c = coinViewModel;
        synchronized (this) {
            this.f13789f |= 4;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return k((NLive) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((CoinActivity) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((CoinViewModel) obj);
        }
        return true;
    }

    private vf(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[1]);
        this.f13789f = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f13787d = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f13788e = textView;
        textView.setTag(null);
        this.a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
