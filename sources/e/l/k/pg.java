package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.donkingliang.labels.LabelsView;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.search.fragments.global.GlobalSearchFragment;
import java.util.List;

/* loaded from: classes2.dex */
public class pg extends og {
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13359l = null;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private static final SparseIntArray f13360m;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final ConstraintLayout f13361i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final TextView f13362j;

    /* renamed from: k  reason: collision with root package name */
    private long f13363k;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13360m = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 6);
    }

    public pg(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f13359l, f13360m));
    }

    private boolean m(e.n.f<List<String>> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13363k |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.t.j.h.g gVar;
        List<String> list;
        LabelsView.c cVar;
        synchronized (this) {
            j2 = this.f13363k;
            this.f13363k = 0L;
        }
        GlobalSearchFragment globalSearchFragment = this.f13280f;
        e.l.q.b.j.b bVar = this.f13281g;
        e.l.s.m.b bVar2 = this.f13282h;
        e.t.j.h.g i0 = ((j2 & 18) == 0 || globalSearchFragment == null) ? null : globalSearchFragment.i0();
        int i2 = 0;
        if ((j2 & 29) != 0) {
            gVar = ((j2 & 20) == 0 || bVar == null) ? null : bVar.a();
            LabelsView.c b = bVar != null ? bVar.b() : null;
            e.n.f<List<String>> x = bVar2 != null ? bVar2.x() : null;
            updateLiveDataRegistration(0, x);
            List<String> value = x != null ? x.getValue() : null;
            int i3 = ((j2 & 24) > 0L ? 1 : ((j2 & 24) == 0L ? 0 : -1));
            if (i3 != 0) {
                boolean e2 = bVar2 != null ? bVar2.e() : false;
                if (i3 != 0) {
                    j2 |= e2 ? 64L : 32L;
                }
                if (e2) {
                    i2 = 8;
                }
            }
            cVar = b;
            list = value;
        } else {
            gVar = null;
            list = null;
            cVar = null;
        }
        if ((j2 & 29) != 0) {
            e.l.i.o.a(this.a, list, 5, cVar, null, null, null, 12);
        }
        if ((j2 & 24) != 0) {
            this.f13362j.setVisibility(i2);
            this.f13277c.setVisibility(i2);
            this.f13279e.setVisibility(i2);
        }
        if ((j2 & 18) != 0) {
            e.t.j.g.e0.F(this.f13362j, i0);
        }
        if ((j2 & 20) != 0) {
            e.t.j.g.e0.F(this.b, gVar);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13363k != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13363k = 16L;
        }
        requestRebind();
    }

    @Override // e.l.k.og
    public void j(@Nullable GlobalSearchFragment globalSearchFragment) {
        this.f13280f = globalSearchFragment;
        synchronized (this) {
            this.f13363k |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // e.l.k.og
    public void k(@Nullable e.l.q.b.j.b bVar) {
        this.f13281g = bVar;
        synchronized (this) {
            this.f13363k |= 4;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    @Override // e.l.k.og
    public void l(@Nullable e.l.s.m.b bVar) {
        this.f13282h = bVar;
        synchronized (this) {
            this.f13363k |= 8;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return m((e.n.f) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            j((GlobalSearchFragment) obj);
        } else if (19 == i2) {
            k((e.l.q.b.j.b) obj);
        } else if (20 != i2) {
            return false;
        } else {
            l((e.l.s.m.b) obj);
        }
        return true;
    }

    private pg(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (LabelsView) objArr[2], (TextView) objArr[1], (TextView) objArr[4], (TextView) objArr[6], (TextView) objArr[3]);
        this.f13363k = -1L;
        this.a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13361i = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[5];
        this.f13362j = textView;
        textView.setTag(null);
        this.b.setTag(null);
        this.f13277c.setTag(null);
        this.f13279e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
