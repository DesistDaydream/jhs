package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.NoticeDialog;

/* loaded from: classes2.dex */
public class h5 extends g5 {
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12774i = null;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static final SparseIntArray f12775j;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final FrameLayout f12776f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final TextView f12777g;

    /* renamed from: h  reason: collision with root package name */
    private long f12778h;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f12775j = sparseIntArray;
        sparseIntArray.put(R.id.scrollView, 5);
    }

    public h5(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f12774i, f12775j));
    }

    private boolean i(e.n.p pVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12778h |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean j(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12778h |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean k(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12778h |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean l(e.n.p pVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f12778h |= 4;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d2  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.h5.executeBindings():void");
    }

    @Override // e.l.k.g5
    public void h(@Nullable NoticeDialog noticeDialog) {
        this.f12713e = noticeDialog;
        synchronized (this) {
            this.f12778h |= 16;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12778h != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12778h = 32L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return false;
                    }
                    return k((e.n.i) obj, i3);
                }
                return l((e.n.p) obj, i3);
            }
            return j((e.n.i) obj, i3);
        }
        return i((e.n.p) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            h((NoticeDialog) obj);
            return true;
        }
        return false;
    }

    private h5(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (TextView) objArr[3], (TextView) objArr[4], (ScrollView) objArr[5], (TextView) objArr[1]);
        this.f12778h = -1L;
        this.a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f12776f = frameLayout;
        frameLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f12777g = textView;
        textView.setTag(null);
        this.b.setTag(null);
        this.f12712d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
