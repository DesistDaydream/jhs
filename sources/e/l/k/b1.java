package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.eth.model.NLive;
import com.jihuanshe.R;
import com.jihuanshe.model.IllegalData;
import com.jihuanshe.ui.page.user.IllegalListActivity;
import com.vector.databinding.adapter.ListViewBinding;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class b1 extends a1 {
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12322g = null;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f12323h = null;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final FrameLayout f12324d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final TextView f12325e;

    /* renamed from: f  reason: collision with root package name */
    private long f12326f;

    public b1(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f12322g, f12323h));
    }

    private boolean k(NLive<List<IllegalData>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12326f |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.t.j.h.f0 f0Var;
        e.l.h.j.b.f.b bVar;
        LayoutManagers.a aVar;
        e.t.j.h.g gVar;
        e.l.g.a0 a0Var;
        List<IllegalData> list;
        synchronized (this) {
            j2 = this.f12326f;
            this.f12326f = 0L;
        }
        IllegalListActivity illegalListActivity = this.b;
        e.l.s.o.a aVar2 = this.f12245c;
        int i2 = ((15 & j2) > 0L ? 1 : ((15 & j2) == 0L ? 0 : -1));
        if (i2 != 0) {
            if ((j2 & 10) == 0 || illegalListActivity == null) {
                f0Var = null;
                bVar = null;
                aVar = null;
                gVar = null;
            } else {
                f0Var = illegalListActivity.b0();
                bVar = illegalListActivity.X();
                aVar = illegalListActivity.Y();
                gVar = illegalListActivity.a0();
            }
            e.l.g.a0 W = illegalListActivity != null ? illegalListActivity.W() : null;
            NLive<List<IllegalData>> q0 = aVar2 != null ? aVar2.q0() : null;
            updateLiveDataRegistration(0, q0);
            if (q0 != null) {
                a0Var = W;
                list = q0.getValue();
            } else {
                a0Var = W;
                list = null;
            }
        } else {
            f0Var = null;
            bVar = null;
            aVar = null;
            gVar = null;
            a0Var = null;
            list = null;
        }
        if ((10 & j2) != 0) {
            ListViewBinding.c(this.a, bVar);
            ListViewBinding.q(this.a, f0Var);
            ListViewBinding.g(this.a, aVar, false);
            e.t.j.g.e0.F(this.f12325e, gVar);
        }
        if (i2 != 0) {
            ListViewBinding.a(this.a, a0Var, null, list, null, null, Integer.valueOf((int) R.layout.view_common_empty), null);
        }
        if ((j2 & 8) != 0) {
            e.l.i.f0.j(this.a, 12, null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12326f != 0;
        }
    }

    @Override // e.l.k.a1
    public void i(@Nullable IllegalListActivity illegalListActivity) {
        this.b = illegalListActivity;
        synchronized (this) {
            this.f12326f |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12326f = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.a1
    public void j(@Nullable e.l.s.o.a aVar) {
        this.f12245c = aVar;
        synchronized (this) {
            this.f12326f |= 4;
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
            i((IllegalListActivity) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((e.l.s.o.a) obj);
        }
        return true;
    }

    private b1(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ListView) objArr[1]);
        this.f12326f = -1L;
        this.a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f12324d = frameLayout;
        frameLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f12325e = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
