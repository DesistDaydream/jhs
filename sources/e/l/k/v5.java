package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.jihuanshe.ui.dialog.BaseSideDialog;
import com.jihuanshe.ui.widget.LabelsViewNew;
import java.util.List;

/* loaded from: classes2.dex */
public class v5 extends u5 {
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13743i = null;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static final SparseIntArray f13744j = null;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final ConstraintLayout f13745f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final LabelsViewNew f13746g;

    /* renamed from: h  reason: collision with root package name */
    private long f13747h;

    public v5(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f13743i, f13744j));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        String str;
        e.t.j.h.g gVar;
        String str2;
        List<String> list;
        LabelsViewNew.e eVar;
        List<Integer> list2;
        int i2;
        boolean z;
        int i3;
        e.t.j.h.g gVar2;
        LabelsViewNew.e eVar2;
        List<Integer> list3;
        boolean z2;
        int i4;
        synchronized (this) {
            j2 = this.f13747h;
            this.f13747h = 0L;
        }
        BaseSideDialog baseSideDialog = this.f13696e;
        e.t.j.h.g gVar3 = null;
        List<String> list4 = null;
        int i5 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i5 != 0) {
            if (baseSideDialog != null) {
                list4 = baseSideDialog.getLocalData();
                str = baseSideDialog.getSubTitleText();
                z = baseSideDialog.getFirstMatch();
                gVar = baseSideDialog.getOnClickReset();
                str2 = baseSideDialog.getTitleText();
                eVar2 = baseSideDialog.getOnStateChanged();
                z2 = baseSideDialog.getNeedResetButton();
                list3 = baseSideDialog.getInitIndexs();
                i4 = baseSideDialog.getStatusBarHeight();
                i3 = baseSideDialog.getSelectType();
                gVar2 = baseSideDialog.getOnClickConfirm();
            } else {
                gVar2 = null;
                str = null;
                gVar = null;
                str2 = null;
                eVar2 = null;
                list3 = null;
                z = false;
                z2 = false;
                i4 = 0;
                i3 = 0;
            }
            if (i5 != 0) {
                j2 |= z2 ? 8L : 4L;
            }
            list = list4;
            eVar = eVar2;
            list2 = list3;
            gVar3 = gVar2;
            i2 = z2 ? 0 : 8;
            r10 = i4;
        } else {
            str = null;
            gVar = null;
            str2 = null;
            list = null;
            eVar = null;
            list2 = null;
            i2 = 0;
            z = false;
            i3 = 0;
        }
        if ((3 & j2) != 0) {
            e.t.j.g.e0.F(this.a, gVar3);
            TextViewBindingAdapter.setText(this.b, str2);
            ViewBindingAdapter.setPaddingTop(this.f13745f, r10);
            e.l.i.p.a(this.f13746g, list, null, null, eVar, list2, Integer.valueOf(i3), Boolean.valueOf(z));
            TextViewBindingAdapter.setText(this.f13694c, str);
            e.t.j.g.e0.F(this.f13695d, gVar);
            this.f13695d.setVisibility(i2);
        }
        if ((j2 & 2) != 0) {
            e.l.i.f0.g(this.b, Boolean.TRUE);
        }
    }

    @Override // e.l.k.u5
    public void h(@Nullable BaseSideDialog baseSideDialog) {
        this.f13696e = baseSideDialog;
        synchronized (this) {
            this.f13747h |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13747h != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13747h = 2L;
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
            h((BaseSideDialog) obj);
            return true;
        }
        return false;
    }

    private v5(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[4], (TextView) objArr[1], (TextView) objArr[2], (TextView) objArr[5]);
        this.f13747h = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13745f = constraintLayout;
        constraintLayout.setTag(null);
        LabelsViewNew labelsViewNew = (LabelsViewNew) objArr[3];
        this.f13746g = labelsViewNew;
        labelsViewNew.setTag(null);
        this.f13694c.setTag(null);
        this.f13695d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
