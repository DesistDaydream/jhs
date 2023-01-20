package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.eth.model.NLive;
import com.jihuanshe.adapter.AddressAdapter;
import com.jihuanshe.binding.RecyclerViewBinding;
import com.jihuanshe.model.UserAddress;
import com.jihuanshe.ui.page.order.AddressActivity;
import com.vector.util.LayoutManagers;
import java.util.List;

/* loaded from: classes2.dex */
public class l extends k {
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13031g = null;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f13032h = null;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final FrameLayout f13033c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final RecyclerView f13034d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final TextView f13035e;

    /* renamed from: f  reason: collision with root package name */
    private long f13036f;

    public l(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f13031g, f13032h));
    }

    private boolean k(NLive<List<UserAddress>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13036f |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.t.j.h.g gVar;
        e.t.j.h.l lVar;
        AddressAdapter addressAdapter;
        List<UserAddress> list;
        LayoutManagers.a aVar;
        e.l.h.j.b.f.b bVar;
        e.l.h.j.b.f.b bVar2;
        AddressAdapter addressAdapter2;
        LayoutManagers.a aVar2;
        synchronized (this) {
            j2 = this.f13036f;
            this.f13036f = 0L;
        }
        AddressActivity addressActivity = this.a;
        e.l.s.j.a aVar3 = this.b;
        int i2 = ((15 & j2) > 0L ? 1 : ((15 & j2) == 0L ? 0 : -1));
        if (i2 != 0) {
            if (addressActivity != null) {
                bVar2 = addressActivity.X();
                addressAdapter2 = addressActivity.W();
                aVar2 = addressActivity.Y();
            } else {
                bVar2 = null;
                addressAdapter2 = null;
                aVar2 = null;
            }
            NLive<List<UserAddress>> q0 = aVar3 != null ? aVar3.q0() : null;
            updateLiveDataRegistration(0, q0);
            List<UserAddress> value = q0 != null ? q0.getValue() : null;
            if ((j2 & 10) == 0 || addressActivity == null) {
                list = value;
                bVar = bVar2;
                addressAdapter = addressAdapter2;
                gVar = null;
                lVar = null;
                aVar = aVar2;
            } else {
                e.t.j.h.l b0 = addressActivity.b0();
                gVar = addressActivity.a0();
                list = value;
                bVar = bVar2;
                aVar = aVar2;
                lVar = b0;
                addressAdapter = addressAdapter2;
            }
        } else {
            gVar = null;
            lVar = null;
            addressAdapter = null;
            list = null;
            aVar = null;
            bVar = null;
        }
        if (i2 != 0) {
            RecyclerViewBinding.b(this.f13034d, addressAdapter, list, aVar, null, null, null, bVar);
        }
        if ((j2 & 10) != 0) {
            RecyclerViewBinding.f(this.f13034d, lVar, null);
            e.t.j.g.e0.F(this.f13035e, gVar);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13036f != 0;
        }
    }

    @Override // e.l.k.k
    public void i(@Nullable AddressActivity addressActivity) {
        this.a = addressActivity;
        synchronized (this) {
            this.f13036f |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13036f = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.k
    public void j(@Nullable e.l.s.j.a aVar) {
        this.b = aVar;
        synchronized (this) {
            this.f13036f |= 4;
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
            i((AddressActivity) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((e.l.s.j.a) obj);
        }
        return true;
    }

    private l(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1);
        this.f13036f = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f13033c = frameLayout;
        frameLayout.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[1];
        this.f13034d = recyclerView;
        recyclerView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f13035e = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
