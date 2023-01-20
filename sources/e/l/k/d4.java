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
import com.jihuanshe.model.ChooseItem;
import com.jihuanshe.ui.dialog.ChooseDialogNew;
import com.vector.util.LayoutManagers;
import java.util.List;

/* loaded from: classes2.dex */
public class d4 extends c4 {
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12488g = null;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f12489h = null;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final LinearLayout f12490c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final TextView f12491d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final TextView f12492e;

    /* renamed from: f  reason: collision with root package name */
    private long f12493f;

    public d4(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f12488g, f12489h));
    }

    private boolean i(e.n.f<List<ChooseItem>> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12493f |= 1;
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
        e.l.g.n nVar;
        List<ChooseItem> list;
        LayoutManagers.a aVar;
        e.n.f<List<ChooseItem>> fVar;
        e.l.g.n nVar2;
        LayoutManagers.a aVar2;
        synchronized (this) {
            j2 = this.f12493f;
            this.f12493f = 0L;
        }
        ChooseDialogNew chooseDialogNew = this.b;
        int i2 = ((7 & j2) > 0L ? 1 : ((7 & j2) == 0L ? 0 : -1));
        if (i2 != 0) {
            if ((j2 & 6) == 0 || chooseDialogNew == null) {
                lVar = null;
                gVar = null;
                gVar2 = null;
            } else {
                lVar = chooseDialogNew.getOnItemClick();
                gVar = chooseDialogNew.getOnClickCancel();
                gVar2 = chooseDialogNew.getOnClickConfirm();
            }
            if (chooseDialogNew != null) {
                nVar2 = chooseDialogNew.getAdapter();
                aVar2 = chooseDialogNew.getLayoutManager();
                fVar = chooseDialogNew.getDataList();
            } else {
                fVar = null;
                nVar2 = null;
                aVar2 = null;
            }
            updateLiveDataRegistration(0, fVar);
            list = fVar != null ? fVar.getValue() : null;
            nVar = nVar2;
            aVar = aVar2;
        } else {
            lVar = null;
            gVar = null;
            gVar2 = null;
            nVar = null;
            list = null;
            aVar = null;
        }
        if (i2 != 0) {
            RecyclerViewBinding.b(this.a, nVar, list, aVar, null, null, null, null);
        }
        if ((j2 & 6) != 0) {
            RecyclerViewBinding.f(this.a, lVar, null);
            e.t.j.g.e0.F(this.f12491d, gVar);
            e.t.j.g.e0.F(this.f12492e, gVar2);
        }
    }

    @Override // e.l.k.c4
    public void h(@Nullable ChooseDialogNew chooseDialogNew) {
        this.b = chooseDialogNew;
        synchronized (this) {
            this.f12493f |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12493f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12493f = 4L;
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
            h((ChooseDialogNew) obj);
            return true;
        }
        return false;
    }

    private d4(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (RecyclerView) objArr[1]);
        this.f12493f = -1L;
        this.a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f12490c = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f12491d = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[3];
        this.f12492e = textView2;
        textView2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
