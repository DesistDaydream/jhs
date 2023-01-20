package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.jihuanshe.R;
import com.jihuanshe.binding.RecyclerViewBinding;
import com.jihuanshe.ui.dialog.ReportDialog;
import com.vector.util.LayoutManagers;
import java.util.List;

/* loaded from: classes2.dex */
public class p5 extends o5 {
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13313i = null;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static final SparseIntArray f13314j;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final ConstraintLayout f13315e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final TextView f13316f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final TextView f13317g;

    /* renamed from: h  reason: collision with root package name */
    private long f13318h;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13314j = sparseIntArray;
        sparseIntArray.put(R.id.top, 4);
        sparseIntArray.put(R.id.bottom, 5);
    }

    public p5(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f13313i, f13314j));
    }

    private boolean i(e.n.f<List<String>> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13318h |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.t.j.h.l lVar;
        e.t.j.h.g gVar;
        e.t.j.h.g gVar2;
        e.l.g.q0 q0Var;
        List<String> list;
        LayoutManagers.a aVar;
        LayoutManagers.a aVar2;
        e.l.g.q0 q0Var2;
        e.n.f<List<String>> fVar;
        synchronized (this) {
            j2 = this.f13318h;
            this.f13318h = 0L;
        }
        ReportDialog reportDialog = this.f13248d;
        int i2 = ((7 & j2) > 0L ? 1 : ((7 & j2) == 0L ? 0 : -1));
        if (i2 != 0) {
            if ((j2 & 6) == 0 || reportDialog == null) {
                lVar = null;
                gVar = null;
                gVar2 = null;
            } else {
                lVar = reportDialog.getOnItemClick();
                gVar = reportDialog.getOnClickCancel();
                gVar2 = reportDialog.getOnClickConfirm();
            }
            if (reportDialog != null) {
                q0Var2 = reportDialog.getAdapter();
                fVar = reportDialog.getReason();
                aVar2 = reportDialog.getLayoutManager();
            } else {
                aVar2 = null;
                q0Var2 = null;
                fVar = null;
            }
            updateLiveDataRegistration(0, fVar);
            if (fVar != null) {
                aVar = aVar2;
                q0Var = q0Var2;
                list = fVar.getValue();
            } else {
                aVar = aVar2;
                list = null;
                q0Var = q0Var2;
            }
        } else {
            lVar = null;
            gVar = null;
            gVar2 = null;
            q0Var = null;
            list = null;
            aVar = null;
        }
        if ((j2 & 6) != 0) {
            e.t.j.g.e0.F(this.f13316f, gVar);
            e.t.j.g.e0.F(this.f13317g, gVar2);
            RecyclerViewBinding.f(this.b, lVar, null);
        }
        if (i2 != 0) {
            RecyclerViewBinding.b(this.b, q0Var, list, aVar, null, null, null, null);
        }
    }

    @Override // e.l.k.o5
    public void h(@Nullable ReportDialog reportDialog) {
        this.f13248d = reportDialog;
        synchronized (this) {
            this.f13318h |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13318h != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13318h = 4L;
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
            h((ReportDialog) obj);
            return true;
        }
        return false;
    }

    private p5(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (FrameLayout) objArr[5], (RecyclerView) objArr[1], (View) objArr[4]);
        this.f13318h = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13315e = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f13316f = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[3];
        this.f13317g = textView2;
        textView2.setTag(null);
        this.b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
