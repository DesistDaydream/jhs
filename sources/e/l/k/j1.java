package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.main.MainActivity;
import com.jihuanshe.ui.widget.bottomtab.BottomTabLayout;
import com.vector.view.pager.ViewPager;
import java.util.List;

/* loaded from: classes2.dex */
public class j1 extends i1 {
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12921i = null;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static final SparseIntArray f12922j;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final ConstraintLayout f12923f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final TextView f12924g;

    /* renamed from: h  reason: collision with root package name */
    private long f12925h;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f12922j = sparseIntArray;
        sparseIntArray.put(R.id.view, 4);
    }

    public j1(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f12921i, f12922j));
    }

    private boolean k(e.n.f<e.t.k.a.c.h.c> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12925h |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean l(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12925h |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean m(e.n.f<List<e.l.q.c.p0.c>> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12925h |= 2;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        BottomTabLayout.a aVar;
        e.t.j.h.g gVar;
        e.t.j.h.y yVar;
        e.t.k.a.c.h.c cVar;
        List<e.l.q.c.p0.c> list;
        int i2;
        int i3;
        synchronized (this) {
            j2 = this.f12925h;
            this.f12925h = 0L;
        }
        MainActivity mainActivity = this.f12833d;
        e.l.s.i.a aVar2 = this.f12834e;
        if ((j2 & 44) != 0) {
            e.n.f<e.t.k.a.c.h.c> i0 = mainActivity != null ? mainActivity.i0() : null;
            updateLiveDataRegistration(2, i0);
            e.t.k.a.c.h.c value = i0 != null ? i0.getValue() : null;
            if ((j2 & 40) == 0 || mainActivity == null) {
                cVar = value;
                aVar = null;
                gVar = null;
                yVar = null;
            } else {
                gVar = mainActivity.k0();
                yVar = mainActivity.g0();
                aVar = mainActivity.h0();
                cVar = value;
            }
        } else {
            aVar = null;
            gVar = null;
            yVar = null;
            cVar = null;
        }
        if ((51 & j2) != 0) {
            int i4 = ((j2 & 49) > 0L ? 1 : ((j2 & 49) == 0L ? 0 : -1));
            if (i4 != 0) {
                e.n.l p0 = aVar2 != null ? aVar2.p0() : null;
                updateLiveDataRegistration(0, p0);
                i3 = ViewDataBinding.safeUnbox(p0 != null ? p0.getValue() : null);
                boolean z = i3 == 0;
                if (i4 != 0) {
                    j2 |= z ? 128L : 64L;
                }
                i2 = z ? 0 : 8;
            } else {
                i2 = 0;
                i3 = 0;
            }
            if ((j2 & 50) != 0) {
                e.n.f<List<e.l.q.c.p0.c>> r0 = aVar2 != null ? aVar2.r0() : null;
                updateLiveDataRegistration(1, r0);
                if (r0 != null) {
                    list = r0.getValue();
                }
            }
            list = null;
        } else {
            list = null;
            i2 = 0;
            i3 = 0;
        }
        if ((40 & j2) != 0) {
            e.l.i.c.b(this.a, aVar);
            e.t.j.g.e0.F(this.f12924g, gVar);
            e.t.j.g.f0.p(this.f12832c, null, null, yVar, null);
        }
        if ((j2 & 50) != 0) {
            e.l.i.c.a(this.a, list, null);
        }
        if ((j2 & 49) != 0) {
            this.f12924g.setVisibility(i2);
            e.t.j.g.f0.h(this.f12832c, i3, Boolean.FALSE);
        }
        if ((32 & j2) != 0) {
            e.t.j.g.f0.i(this.f12832c, 0);
            e.t.j.g.f0.r(this.f12832c, false);
        }
        if ((j2 & 44) != 0) {
            e.t.j.g.f0.j(this.f12832c, null, null, cVar, null, null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12925h != 0;
        }
    }

    @Override // e.l.k.i1
    public void i(@Nullable MainActivity mainActivity) {
        this.f12833d = mainActivity;
        synchronized (this) {
            this.f12925h |= 8;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12925h = 32L;
        }
        requestRebind();
    }

    @Override // e.l.k.i1
    public void j(@Nullable e.l.s.i.a aVar) {
        this.f12834e = aVar;
        synchronized (this) {
            this.f12925h |= 16;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    return false;
                }
                return k((e.n.f) obj, i3);
            }
            return m((e.n.f) obj, i3);
        }
        return l((e.n.l) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((MainActivity) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((e.l.s.i.a) obj);
        }
        return true;
    }

    private j1(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (BottomTabLayout) objArr[2], (View) objArr[4], (ViewPager) objArr[1]);
        this.f12925h = -1L;
        this.a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12923f = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.f12924g = textView;
        textView.setTag(null);
        this.f12832c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
