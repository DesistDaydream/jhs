package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.ShareDialog;

/* loaded from: classes2.dex */
public class t5 extends s5 {
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13608j = null;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private static final SparseIntArray f13609k;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final ConstraintLayout f13610h;

    /* renamed from: i  reason: collision with root package name */
    private long f13611i;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13609k = sparseIntArray;
        sparseIntArray.put(R.id.titleTv, 6);
    }

    public t5(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f13608j, f13609k));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.t.j.h.g gVar;
        e.t.j.h.g gVar2;
        e.t.j.h.g gVar3;
        e.t.j.h.g gVar4;
        synchronized (this) {
            j2 = this.f13611i;
            this.f13611i = 0L;
        }
        ShareDialog shareDialog = this.f13555g;
        e.t.j.h.g gVar5 = null;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 == 0 || shareDialog == null) {
            gVar = null;
            gVar2 = null;
            gVar3 = null;
            gVar4 = null;
        } else {
            e.t.j.h.g savePicture = shareDialog.getSavePicture();
            e.t.j.h.g shareWXFriend = shareDialog.getShareWXFriend();
            gVar2 = shareDialog.getShareQQ();
            gVar3 = shareDialog.getShareWXCircle();
            gVar4 = shareWXFriend;
            gVar = savePicture;
            gVar5 = shareDialog.getCancel();
        }
        if (i2 != 0) {
            e.t.j.g.e0.F(this.a, gVar5);
            e.t.j.g.e0.F(this.b, gVar);
            e.t.j.g.e0.F(this.f13551c, gVar2);
            e.t.j.g.e0.F(this.f13553e, gVar3);
            e.t.j.g.e0.F(this.f13554f, gVar4);
        }
    }

    @Override // e.l.k.s5
    public void h(@Nullable ShareDialog shareDialog) {
        this.f13555g = shareDialog;
        synchronized (this) {
            this.f13611i |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13611i != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13611i = 2L;
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
            h((ShareDialog) obj);
            return true;
        }
        return false;
    }

    private t5(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[5], (LinearLayout) objArr[1], (LinearLayout) objArr[4], (TextView) objArr[6], (LinearLayout) objArr[3], (LinearLayout) objArr[2]);
        this.f13611i = -1L;
        this.a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13610h = constraintLayout;
        constraintLayout.setTag(null);
        this.b.setTag(null);
        this.f13551c.setTag(null);
        this.f13553e.setTag(null);
        this.f13554f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
