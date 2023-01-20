package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.eth.model.NLive;
import com.jihuanshe.R;
import com.jihuanshe.binding.RecyclerViewBinding;
import com.jihuanshe.model.BankDetail;
import com.jihuanshe.ui.page.shop.SearchBankActivity;
import com.vector.util.LayoutManagers;
import java.util.List;

/* loaded from: classes2.dex */
public class b2 extends a2 {
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12327k = null;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private static final SparseIntArray f12328l;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final ConstraintLayout f12329i;

    /* renamed from: j  reason: collision with root package name */
    private long f12330j;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f12328l = sparseIntArray;
        sparseIntArray.put(R.id.nameTv, 3);
        sparseIntArray.put(R.id.subNameTv, 4);
        sparseIntArray.put(R.id.bankNameEt, 5);
        sparseIntArray.put(R.id.bankSubNameEt, 6);
    }

    public b2(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f12327k, f12328l));
    }

    private boolean k(NLive<List<BankDetail>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12330j |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.l.g.d dVar;
        List<BankDetail> list;
        LayoutManagers.a aVar;
        e.l.h.j.b.f.b bVar;
        e.l.h.j.b.f.b bVar2;
        e.l.g.d dVar2;
        LayoutManagers.a aVar2;
        synchronized (this) {
            j2 = this.f12330j;
            this.f12330j = 0L;
        }
        SearchBankActivity searchBankActivity = this.f12250g;
        e.l.s.n.b bVar3 = this.f12251h;
        e.t.j.h.g gVar = null;
        int i2 = ((15 & j2) > 0L ? 1 : ((15 & j2) == 0L ? 0 : -1));
        if (i2 != 0) {
            if (searchBankActivity != null) {
                bVar2 = searchBankActivity.X();
                dVar2 = searchBankActivity.W();
                aVar2 = searchBankActivity.a0();
            } else {
                bVar2 = null;
                dVar2 = null;
                aVar2 = null;
            }
            NLive<List<BankDetail>> p0 = bVar3 != null ? bVar3.p0() : null;
            updateLiveDataRegistration(0, p0);
            List<BankDetail> value = p0 != null ? p0.getValue() : null;
            if ((j2 & 10) != 0 && searchBankActivity != null) {
                gVar = searchBankActivity.b0();
            }
            list = value;
            bVar = bVar2;
            dVar = dVar2;
            aVar = aVar2;
        } else {
            dVar = null;
            list = null;
            aVar = null;
            bVar = null;
        }
        if (i2 != 0) {
            RecyclerViewBinding.b(this.f12247d, dVar, list, aVar, null, null, null, bVar);
        }
        if ((j2 & 10) != 0) {
            e.t.j.g.e0.F(this.f12248e, gVar);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12330j != 0;
        }
    }

    @Override // e.l.k.a2
    public void i(@Nullable SearchBankActivity searchBankActivity) {
        this.f12250g = searchBankActivity;
        synchronized (this) {
            this.f12330j |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12330j = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.a2
    public void j(@Nullable e.l.s.n.b bVar) {
        this.f12251h = bVar;
        synchronized (this) {
            this.f12330j |= 4;
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
            i((SearchBankActivity) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((e.l.s.n.b) obj);
        }
        return true;
    }

    private b2(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (EditText) objArr[5], (EditText) objArr[6], (TextView) objArr[3], (RecyclerView) objArr[2], (TextView) objArr[1], (TextView) objArr[4]);
        this.f12330j = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12329i = constraintLayout;
        constraintLayout.setTag(null);
        this.f12247d.setTag(null);
        this.f12248e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
