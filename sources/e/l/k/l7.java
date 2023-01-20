package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.adapter.ReplyMeAdapter;
import com.jihuanshe.model.InteractData;
import com.jihuanshe.ui.page.im.ReplyMeFragment;
import com.jihuanshe.viewmodel.im.ReplyMeViewModel;
import com.vector.databinding.adapter.ListViewBinding;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class l7 extends k7 {
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13059e = null;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f13060f = null;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final ListView f13061c;

    /* renamed from: d  reason: collision with root package name */
    private long f13062d;

    public l7(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f13059e, f13060f));
    }

    private boolean k(e.n.f<List<InteractData>> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13062d |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.l.h.j.b.f.b bVar;
        e.t.j.h.l lVar;
        LayoutManagers.a aVar;
        e.t.j.h.p pVar;
        ReplyMeAdapter replyMeAdapter;
        List<InteractData> list;
        synchronized (this) {
            j2 = this.f13062d;
            this.f13062d = 0L;
        }
        ReplyMeFragment replyMeFragment = this.a;
        ReplyMeViewModel replyMeViewModel = this.b;
        int i2 = ((15 & j2) > 0L ? 1 : ((15 & j2) == 0L ? 0 : -1));
        if (i2 != 0) {
            if ((j2 & 10) == 0 || replyMeFragment == null) {
                bVar = null;
                lVar = null;
                aVar = null;
                pVar = null;
            } else {
                bVar = replyMeFragment.f0();
                lVar = replyMeFragment.h0();
                aVar = replyMeFragment.g0();
                pVar = replyMeFragment.i0();
            }
            ReplyMeAdapter e0 = replyMeFragment != null ? replyMeFragment.e0() : null;
            e.n.f<List<InteractData>> s0 = replyMeViewModel != null ? replyMeViewModel.s0() : null;
            updateLiveDataRegistration(0, s0);
            if (s0 != null) {
                replyMeAdapter = e0;
                list = s0.getValue();
            } else {
                replyMeAdapter = e0;
                list = null;
            }
        } else {
            bVar = null;
            lVar = null;
            aVar = null;
            pVar = null;
            replyMeAdapter = null;
            list = null;
        }
        if ((j2 & 10) != 0) {
            ListViewBinding.c(this.f13061c, bVar);
            ListViewBinding.m(this.f13061c, pVar);
            ListViewBinding.l(this.f13061c, lVar, null, null);
            ListViewBinding.g(this.f13061c, aVar, false);
        }
        if (i2 != 0) {
            ListViewBinding.a(this.f13061c, replyMeAdapter, null, list, null, null, null, null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13062d != 0;
        }
    }

    @Override // e.l.k.k7
    public void i(@Nullable ReplyMeFragment replyMeFragment) {
        this.a = replyMeFragment;
        synchronized (this) {
            this.f13062d |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13062d = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.k7
    public void j(@Nullable ReplyMeViewModel replyMeViewModel) {
        this.b = replyMeViewModel;
        synchronized (this) {
            this.f13062d |= 4;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return k((e.n.f) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((ReplyMeFragment) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((ReplyMeViewModel) obj);
        }
        return true;
    }

    private l7(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1);
        this.f13062d = -1L;
        ListView listView = (ListView) objArr[0];
        this.f13061c = listView;
        listView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
