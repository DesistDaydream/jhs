package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.CreateListDialog;
import com.vector.databinding.adapter.EditTextBinding;

/* loaded from: classes2.dex */
public class l4 extends k4 {
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13044i = null;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static final SparseIntArray f13045j;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final ConstraintLayout f13046e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final LinearLayout f13047f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final TextView f13048g;

    /* renamed from: h  reason: collision with root package name */
    private long f13049h;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13045j = sparseIntArray;
        sparseIntArray.put(R.id.title, 5);
    }

    public l4(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f13044i, f13045j));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.t.j.h.g gVar;
        e.t.j.h.g gVar2;
        e.t.j.h.g gVar3;
        e.t.j.h.a aVar;
        Boolean bool;
        synchronized (this) {
            j2 = this.f13049h;
            this.f13049h = 0L;
        }
        CreateListDialog createListDialog = this.f13000d;
        int i2 = 0;
        int i3 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i3 != 0) {
            if (createListDialog != null) {
                gVar2 = createListDialog.getOnClickClose();
                bool = createListDialog.getDelShow();
                gVar3 = createListDialog.getOnClickDel();
                aVar = createListDialog.getOnTextChanged();
                gVar = createListDialog.getOnClick();
            } else {
                gVar = null;
                gVar2 = null;
                bool = null;
                gVar3 = null;
                aVar = null;
            }
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (i3 != 0) {
                j2 |= safeUnbox ? 8L : 4L;
            }
            if (!safeUnbox) {
                i2 = 8;
            }
        } else {
            gVar = null;
            gVar2 = null;
            gVar3 = null;
            aVar = null;
        }
        if ((j2 & 3) != 0) {
            EditTextBinding.g(this.a, null, null, aVar);
            e.t.j.g.e0.F(this.b, gVar2);
            this.f13047f.setVisibility(i2);
            e.t.j.g.e0.F(this.f13047f, gVar3);
            e.t.j.g.e0.F(this.f13048g, gVar);
        }
    }

    @Override // e.l.k.k4
    public void h(@Nullable CreateListDialog createListDialog) {
        this.f13000d = createListDialog;
        synchronized (this) {
            this.f13049h |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13049h != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13049h = 2L;
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
            h((CreateListDialog) obj);
            return true;
        }
        return false;
    }

    private l4(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (EditText) objArr[3], (ImageView) objArr[1], (TextView) objArr[5]);
        this.f13049h = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13046e = constraintLayout;
        constraintLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[2];
        this.f13047f = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.f13048g = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
