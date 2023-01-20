package e.j.a.b.c.n.u;

import android.os.IBinder;
import com.google.android.gms.common.api.internal.BasePendingResult;
import java.lang.ref.WeakReference;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public final class s2 implements IBinder.DeathRecipient, t2 {
    private final WeakReference<BasePendingResult<?>> a;
    private final WeakReference<e.j.a.b.c.n.x> b;

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference<IBinder> f10323c;

    private s2(BasePendingResult<?> basePendingResult, e.j.a.b.c.n.x xVar, IBinder iBinder) {
        this.b = new WeakReference<>(xVar);
        this.a = new WeakReference<>(basePendingResult);
        this.f10323c = new WeakReference<>(iBinder);
    }

    private final void b() {
        BasePendingResult<?> basePendingResult = this.a.get();
        e.j.a.b.c.n.x xVar = this.b.get();
        if (xVar != null && basePendingResult != null) {
            xVar.a(basePendingResult.j().intValue());
        }
        IBinder iBinder = this.f10323c.get();
        if (iBinder != null) {
            try {
                iBinder.unlinkToDeath(this, 0);
            } catch (NoSuchElementException unused) {
            }
        }
    }

    @Override // e.j.a.b.c.n.u.t2
    public final void a(BasePendingResult<?> basePendingResult) {
        b();
    }

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        b();
    }

    public /* synthetic */ s2(BasePendingResult basePendingResult, e.j.a.b.c.n.x xVar, IBinder iBinder, r2 r2Var) {
        this(basePendingResult, null, iBinder);
    }
}
