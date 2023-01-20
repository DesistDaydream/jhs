package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.eth.model.NLive;
import com.jihuanshe.R;
import com.jihuanshe.model.User;
import com.jihuanshe.ui.page.user.FollowActivity;
import com.jihuanshe.viewmodel.user.FollowViewModel;
import com.vector.databinding.adapter.EditTextBinding;
import com.vector.databinding.adapter.ListViewBinding;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class x0 extends w0 {
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13886i = null;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static final SparseIntArray f13887j;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final LinearLayout f13888f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final TextView f13889g;

    /* renamed from: h  reason: collision with root package name */
    private long f13890h;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13887j = sparseIntArray;
        sparseIntArray.put(R.id.searchLayout, 4);
    }

    public x0(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f13886i, f13887j));
    }

    private boolean k(NLive<List<User>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13890h |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.t.j.h.p pVar;
        e.t.j.h.g gVar;
        e.l.h.j.b.f.b bVar;
        e.t.j.h.l lVar;
        e.t.j.h.h hVar;
        LayoutManagers.a aVar;
        e.l.g.w wVar;
        List<User> list;
        e.t.j.h.p pVar2;
        e.t.j.h.g gVar2;
        synchronized (this) {
            j2 = this.f13890h;
            this.f13890h = 0L;
        }
        FollowActivity followActivity = this.f13795d;
        FollowViewModel followViewModel = this.f13796e;
        int i2 = ((15 & j2) > 0L ? 1 : ((15 & j2) == 0L ? 0 : -1));
        if (i2 != 0) {
            if ((j2 & 10) == 0 || followActivity == null) {
                bVar = null;
                lVar = null;
                hVar = null;
                aVar = null;
                pVar2 = null;
                gVar2 = null;
            } else {
                bVar = followActivity.X();
                lVar = followActivity.e0();
                hVar = followActivity.d0();
                aVar = followActivity.a0();
                pVar2 = followActivity.f0();
                gVar2 = followActivity.c0();
            }
            e.l.g.w W = followActivity != null ? followActivity.W() : null;
            NLive<List<User>> q0 = followViewModel != null ? followViewModel.q0() : null;
            updateLiveDataRegistration(0, q0);
            if (q0 != null) {
                wVar = W;
                list = q0.getValue();
            } else {
                wVar = W;
                list = null;
            }
            pVar = pVar2;
            gVar = gVar2;
        } else {
            pVar = null;
            gVar = null;
            bVar = null;
            lVar = null;
            hVar = null;
            aVar = null;
            wVar = null;
            list = null;
        }
        if ((j2 & 8) != 0) {
            ListViewBinding.y(this.a, true);
            ListViewBinding.d(this.a, false);
            ListView listView = this.a;
            ListViewBinding.k(listView, listView.getResources().getString(R.string.common_no_more));
            e.l.i.f0.j(this.a, 12, null);
        }
        if ((j2 & 10) != 0) {
            ListViewBinding.c(this.a, bVar);
            ListViewBinding.m(this.a, pVar);
            ListViewBinding.l(this.a, lVar, null, null);
            ListViewBinding.g(this.a, aVar, false);
            e.t.j.g.e0.F(this.f13889g, gVar);
            EditTextBinding.c(this.b, hVar);
        }
        if (i2 != 0) {
            ListViewBinding.a(this.a, wVar, null, list, null, null, null, null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13890h != 0;
        }
    }

    @Override // e.l.k.w0
    public void i(@Nullable FollowActivity followActivity) {
        this.f13795d = followActivity;
        synchronized (this) {
            this.f13890h |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13890h = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.w0
    public void j(@Nullable FollowViewModel followViewModel) {
        this.f13796e = followViewModel;
        synchronized (this) {
            this.f13890h |= 4;
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
            i((FollowActivity) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((FollowViewModel) obj);
        }
        return true;
    }

    private x0(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ListView) objArr[3], (EditText) objArr[1], (LinearLayout) objArr[4]);
        this.f13890h = -1L;
        this.a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f13888f = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f13889g = textView;
        textView.setTag(null);
        this.b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
