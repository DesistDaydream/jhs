package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.model.Game;
import com.jihuanshe.ui.widget.GamesPopupWindow;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class le extends ke {
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13081g = null;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f13082h = null;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final FrameLayout f13083c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final View f13084d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final LinearLayout f13085e;

    /* renamed from: f  reason: collision with root package name */
    private long f13086f;

    public le(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f13081g, f13082h));
    }

    private boolean i(e.n.f<List<Game>> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13086f |= 1;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            r24 = this;
            r1 = r24
            monitor-enter(r24)
            long r2 = r1.f13086f     // Catch: java.lang.Throwable -> Lb1
            r4 = 0
            r1.f13086f = r4     // Catch: java.lang.Throwable -> Lb1
            monitor-exit(r24)     // Catch: java.lang.Throwable -> Lb1
            com.jihuanshe.ui.widget.GamesPopupWindow r0 = r1.b
            r6 = 7
            long r6 = r6 & r2
            r8 = 6
            r10 = 0
            r11 = 0
            int r12 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r12 == 0) goto L63
            e.l.o.a.a.a r6 = e.l.o.a.a.a.a
            e.n.f r6 = r6.f()
            r1.updateLiveDataRegistration(r10, r6)
            if (r6 == 0) goto L29
            java.lang.Object r6 = r6.getValue()
            java.util.List r6 = (java.util.List) r6
            goto L2a
        L29:
            r6 = r11
        L2a:
            if (r0 == 0) goto L31
            e.l.g.y r7 = r0.a()
            goto L32
        L31:
            r7 = r11
        L32:
            long r13 = r2 & r8
            int r15 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r15 == 0) goto L5b
            if (r0 == 0) goto L5b
            int r13 = r0.b()
            e.t.j.h.g r14 = r0.g()
            e.t.j.h.l r15 = r0.i()
            com.vector.util.LayoutManagers$a r16 = r0.d()
            e.t.j.h.g r0 = r0.h()
            r22 = r16
            r16 = r6
            r6 = r13
            r13 = r22
            r23 = r14
            r14 = r7
            r7 = r23
            goto L6b
        L5b:
            r16 = r6
            r14 = r7
            r0 = r11
            r7 = r0
            r13 = r7
            r15 = r13
            goto L6a
        L63:
            r0 = r11
            r7 = r0
            r13 = r7
            r14 = r13
            r15 = r14
            r16 = r15
        L6a:
            r6 = 0
        L6b:
            if (r12 == 0) goto L8a
            com.vector.view.scrollable.ListView r12 = r1.a
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r10 = r13
            r13 = r12
            r12 = r15
            r15 = r17
            r17 = r18
            r18 = r19
            r19 = r20
            r20 = r21
            com.vector.databinding.adapter.ListViewBinding.a(r13, r14, r15, r16, r17, r18, r19, r20)
            goto L8c
        L8a:
            r10 = r13
            r12 = r15
        L8c:
            long r2 = r2 & r8
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 == 0) goto Lb0
            com.vector.view.scrollable.ListView r2 = r1.a
            com.vector.databinding.adapter.ListViewBinding.l(r2, r12, r11, r11)
            com.vector.view.scrollable.ListView r2 = r1.a
            r3 = 0
            com.vector.databinding.adapter.ListViewBinding.g(r2, r10, r3)
            android.widget.FrameLayout r2 = r1.f13083c
            e.t.j.g.e0.F(r2, r7)
            android.view.View r2 = r1.f13084d
            e.t.j.g.e0.u(r2, r6)
            android.widget.LinearLayout r2 = r1.f13085e
            e.t.j.g.e0.u(r2, r6)
            android.widget.LinearLayout r2 = r1.f13085e
            e.t.j.g.e0.F(r2, r0)
        Lb0:
            return
        Lb1:
            r0 = move-exception
            monitor-exit(r24)     // Catch: java.lang.Throwable -> Lb1
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.le.executeBindings():void");
    }

    @Override // e.l.k.ke
    public void h(@Nullable GamesPopupWindow gamesPopupWindow) {
        this.b = gamesPopupWindow;
        synchronized (this) {
            this.f13086f |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13086f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13086f = 4L;
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
            h((GamesPopupWindow) obj);
            return true;
        }
        return false;
    }

    private le(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ListView) objArr[3]);
        this.f13086f = -1L;
        this.a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f13083c = frameLayout;
        frameLayout.setTag(null);
        View view2 = (View) objArr[1];
        this.f13084d = view2;
        view2.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[2];
        this.f13085e = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
