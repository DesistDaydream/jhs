package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.model.SearchUser;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public class vc extends uc {
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13771k = null;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private static final SparseIntArray f13772l = null;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final ConstraintLayout f13773h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final TextView f13774i;

    /* renamed from: j  reason: collision with root package name */
    private long f13775j;

    public vc(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f13771k, f13772l));
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x011d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 424
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.vc.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13775j != 0;
        }
    }

    @Override // e.l.k.uc
    public void i(@Nullable SearchUser searchUser) {
        this.f13716g = searchUser;
        synchronized (this) {
            this.f13775j |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13775j = 4L;
        }
        requestRebind();
    }

    @Override // e.l.k.uc
    public void j(@Nullable e.l.g.c1.b bVar) {
        this.f13715f = bVar;
        synchronized (this) {
            this.f13775j |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (8 == i2) {
            i((SearchUser) obj);
        } else if (10 != i2) {
            return false;
        } else {
            j((e.l.g.c1.b) obj);
        }
        return true;
    }

    private vc(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (NImageView) objArr[1], (TextView) objArr[4], (TextView) objArr[6], (TextView) objArr[2], (TextView) objArr[3]);
        this.f13775j = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        this.f13712c.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13773h = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[5];
        this.f13774i = textView;
        textView.setTag(null);
        this.f13713d.setTag(null);
        this.f13714e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
