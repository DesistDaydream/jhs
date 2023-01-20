package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.jihuanshe.binding.RecyclerViewBinding;
import com.jihuanshe.ui.dialog.ListDialog;
import com.vector.util.LayoutManagers;
import java.util.List;

/* loaded from: classes2.dex */
public class f5 extends e5 {
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12628g = null;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f12629h = null;
    @NonNull
    private final LinearLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final RecyclerView f12630c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final TextView f12631d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final TextView f12632e;

    /* renamed from: f  reason: collision with root package name */
    private long f12633f;

    public f5(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f12628g, f12629h));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.t.j.h.l lVar;
        e.t.j.h.g gVar;
        e.t.j.h.g gVar2;
        e.l.g.d0 d0Var;
        List<e.l.g.z> list;
        LayoutManagers.a aVar;
        synchronized (this) {
            j2 = this.f12633f;
            this.f12633f = 0L;
        }
        ListDialog listDialog = this.a;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 == 0 || listDialog == null) {
            lVar = null;
            gVar = null;
            gVar2 = null;
            d0Var = null;
            list = null;
            aVar = null;
        } else {
            lVar = listDialog.getOnItemClick();
            e.l.g.d0 adapter = listDialog.getAdapter();
            LayoutManagers.a layoutManager = listDialog.getLayoutManager();
            gVar = listDialog.getOnClickCancel();
            List<e.l.g.z> data = listDialog.getData();
            gVar2 = listDialog.getOnClickConfirm();
            d0Var = adapter;
            aVar = layoutManager;
            list = data;
        }
        if (i2 != 0) {
            RecyclerViewBinding.b(this.f12630c, d0Var, list, aVar, null, null, null, null);
            RecyclerViewBinding.f(this.f12630c, lVar, null);
            e.t.j.g.e0.F(this.f12631d, gVar);
            e.t.j.g.e0.F(this.f12632e, gVar2);
        }
    }

    @Override // e.l.k.e5
    public void h(@Nullable ListDialog listDialog) {
        this.a = listDialog;
        synchronized (this) {
            this.f12633f |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12633f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12633f = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            h((ListDialog) obj);
            return true;
        }
        return false;
    }

    private f5(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f12633f = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.b = linearLayout;
        linearLayout.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[1];
        this.f12630c = recyclerView;
        recyclerView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f12631d = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[3];
        this.f12632e = textView2;
        textView2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
