package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.model.Game;

/* loaded from: classes2.dex */
public class zb extends yb {
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f14061e = null;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f14062f = null;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final TextView f14063c;

    /* renamed from: d  reason: collision with root package name */
    private long f14064d;

    public zb(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f14061e, f14062f));
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            r19 = this;
            r1 = r19
            monitor-enter(r19)
            long r2 = r1.f14064d     // Catch: java.lang.Throwable -> L90
            r4 = 0
            r1.f14064d = r4     // Catch: java.lang.Throwable -> L90
            monitor-exit(r19)     // Catch: java.lang.Throwable -> L90
            com.jihuanshe.model.Game r0 = r1.b
            e.l.g.y r6 = r1.a
            r7 = 5
            long r9 = r2 & r7
            r11 = 0
            int r12 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r12 == 0) goto L1e
            if (r0 == 0) goto L1e
            java.lang.String r9 = r0.getName()
            goto L1f
        L1e:
            r9 = r11
        L1f:
            r12 = 7
            long r14 = r2 & r12
            r16 = 16
            r10 = 0
            int r18 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r18 == 0) goto L41
            if (r6 == 0) goto L31
            java.lang.Boolean r6 = r6.v()
            goto L32
        L31:
            r6 = r11
        L32:
            boolean r6 = androidx.databinding.ViewDataBinding.safeUnbox(r6)
            if (r18 == 0) goto L42
            if (r6 == 0) goto L3d
            long r2 = r2 | r16
            goto L42
        L3d:
            r14 = 8
            long r2 = r2 | r14
            goto L42
        L41:
            r6 = 0
        L42:
            long r14 = r2 & r16
            int r16 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r16 == 0) goto L56
            if (r0 == 0) goto L4e
            java.lang.Integer r11 = r0.getWarehouse()
        L4e:
            int r0 = androidx.databinding.ViewDataBinding.safeUnbox(r11)
            if (r0 != 0) goto L56
            r0 = 1
            goto L57
        L56:
            r0 = 0
        L57:
            long r14 = r2 & r12
            int r11 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r11 == 0) goto L7a
            if (r6 == 0) goto L60
            r10 = r0
        L60:
            if (r11 == 0) goto L6a
            if (r10 == 0) goto L67
            r14 = 64
            goto L69
        L67:
            r14 = 32
        L69:
            long r2 = r2 | r14
        L6a:
            android.widget.TextView r0 = r1.f14063c
            if (r10 == 0) goto L72
            r6 = 2131099809(0x7f0600a1, float:1.7811982E38)
            goto L75
        L72:
            r6 = 2131099685(0x7f060025, float:1.781173E38)
        L75:
            int r0 = androidx.databinding.ViewDataBinding.getColorFromResource(r0, r6)
            r10 = r0
        L7a:
            long r11 = r2 & r12
            int r0 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r0 == 0) goto L85
            android.widget.TextView r0 = r1.f14063c
            com.vector.databinding.adapter.TextViewBinding.j(r0, r10)
        L85:
            long r2 = r2 & r7
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L8f
            android.widget.TextView r0 = r1.f14063c
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r9)
        L8f:
            return
        L90:
            r0 = move-exception
            monitor-exit(r19)     // Catch: java.lang.Throwable -> L90
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.zb.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14064d != 0;
        }
    }

    @Override // e.l.k.yb
    public void i(@Nullable e.l.g.y yVar) {
        this.a = yVar;
        synchronized (this) {
            this.f14064d |= 2;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14064d = 4L;
        }
        requestRebind();
    }

    @Override // e.l.k.yb
    public void j(@Nullable Game game) {
        this.b = game;
        synchronized (this) {
            this.f14064d |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (8 == i2) {
            j((Game) obj);
        } else if (2 != i2) {
            return false;
        } else {
            i((e.l.g.y) obj);
        }
        return true;
    }

    private zb(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f14064d = -1L;
        TextView textView = (TextView) objArr[0];
        this.f14063c = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
