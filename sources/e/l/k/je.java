package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.jihuanshe.binding.RecyclerViewBinding;
import com.jihuanshe.model.Game;
import com.jihuanshe.ui.widget.GamePopupWindow;
import com.vector.util.LayoutManagers;
import java.util.List;

/* loaded from: classes2.dex */
public class je extends ie {
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12958e = null;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f12959f = null;
    @NonNull
    private final LinearLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final RecyclerView f12960c;

    /* renamed from: d  reason: collision with root package name */
    private long f12961d;

    public je(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f12958e, f12959f));
    }

    private boolean i(e.n.f<List<Game>> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12961d |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.t.j.h.l lVar;
        e.l.g.x xVar;
        List<Game> list;
        LayoutManagers.a aVar;
        e.l.g.x xVar2;
        LayoutManagers.a aVar2;
        synchronized (this) {
            j2 = this.f12961d;
            this.f12961d = 0L;
        }
        GamePopupWindow gamePopupWindow = this.a;
        int i2 = ((7 & j2) > 0L ? 1 : ((7 & j2) == 0L ? 0 : -1));
        if (i2 != 0) {
            e.n.f<List<Game>> f2 = e.l.o.a.a.a.a.f();
            updateLiveDataRegistration(0, f2);
            List<Game> value = f2 != null ? f2.getValue() : null;
            if (gamePopupWindow != null) {
                xVar2 = gamePopupWindow.a();
                aVar2 = gamePopupWindow.b();
            } else {
                xVar2 = null;
                aVar2 = null;
            }
            if ((j2 & 6) == 0 || gamePopupWindow == null) {
                list = value;
                xVar = xVar2;
                lVar = null;
            } else {
                lVar = gamePopupWindow.e();
                list = value;
                xVar = xVar2;
            }
            aVar = aVar2;
        } else {
            lVar = null;
            xVar = null;
            list = null;
            aVar = null;
        }
        if (i2 != 0) {
            RecyclerViewBinding.b(this.f12960c, xVar, list, aVar, null, null, null, null);
        }
        if ((j2 & 6) != 0) {
            RecyclerViewBinding.f(this.f12960c, lVar, null);
        }
    }

    @Override // e.l.k.ie
    public void h(@Nullable GamePopupWindow gamePopupWindow) {
        this.a = gamePopupWindow;
        synchronized (this) {
            this.f12961d |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12961d != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12961d = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return i((e.n.f) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            h((GamePopupWindow) obj);
            return true;
        }
        return false;
    }

    private je(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1);
        this.f12961d = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.b = linearLayout;
        linearLayout.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[1];
        this.f12960c = recyclerView;
        recyclerView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
