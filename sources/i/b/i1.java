package i.b;

import com.caverock.androidsvg.SVG;
import com.umeng.analytics.pro.am;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0013\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b*\u0010\u0015J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0019\u0010\u000f\u001a\u00020\u000e2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00048T@\u0014X\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\bR\"\u0010\u001b\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0013\u0010 \u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u001f\u0010\nR\u0013\u0010\"\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b!\u0010\nR\u0016\u0010%\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u00028T@\u0014X\u0094\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\nR\u0013\u0010)\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b(\u0010\n¨\u0006+"}, d2 = {"Li/b/i1;", "Lkotlinx/coroutines/CoroutineDispatcher;", "", "unconfined", "", "B0", "(Z)J", "J0", "()J", "K0", "()Z", "L0", "Li/b/y0;", "task", "Lh/t1;", "C0", "(Li/b/y0;)V", "E0", "(Z)V", "z0", "shutdown", "()V", "D0", "nextTime", "Li/b/w3/a;", "c", "Li/b/w3/a;", "unconfinedQueue", am.av, "J", "useCount", "j", "isActive", "H0", "isUnconfinedLoopActive", "b", "Z", "shared", "G0", "isEmpty", "I0", "isUnconfinedQueueEmpty", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public abstract class i1 extends CoroutineDispatcher {
    private long a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private i.b.w3.a<y0<?>> f15742c;

    public static /* synthetic */ void A0(i1 i1Var, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                z = false;
            }
            i1Var.z0(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
    }

    private final long B0(boolean z) {
        if (z) {
            return SVG.T;
        }
        return 1L;
    }

    public static /* synthetic */ void F0(i1 i1Var, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                z = false;
            }
            i1Var.E0(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
    }

    public final void C0(@k.e.a.d y0<?> y0Var) {
        i.b.w3.a<y0<?>> aVar = this.f15742c;
        if (aVar == null) {
            aVar = new i.b.w3.a<>();
            this.f15742c = aVar;
        }
        aVar.a(y0Var);
    }

    public long D0() {
        i.b.w3.a<y0<?>> aVar = this.f15742c;
        return (aVar == null || aVar.d()) ? Long.MAX_VALUE : 0L;
    }

    public final void E0(boolean z) {
        this.a += B0(z);
        if (z) {
            return;
        }
        this.b = true;
    }

    public boolean G0() {
        return I0();
    }

    public final boolean H0() {
        return this.a >= B0(true);
    }

    public final boolean I0() {
        i.b.w3.a<y0<?>> aVar = this.f15742c;
        if (aVar != null) {
            return aVar.d();
        }
        return true;
    }

    public long J0() {
        return !K0() ? Long.MAX_VALUE : 0L;
    }

    public final boolean K0() {
        y0<?> e2;
        i.b.w3.a<y0<?>> aVar = this.f15742c;
        if (aVar == null || (e2 = aVar.e()) == null) {
            return false;
        }
        e2.run();
        return true;
    }

    public boolean L0() {
        return false;
    }

    public final boolean j() {
        return this.a > 0;
    }

    public void shutdown() {
    }

    public final void z0(boolean z) {
        long B0 = this.a - B0(z);
        this.a = B0;
        if (B0 > 0) {
            return;
        }
        if (q0.b()) {
            if (!(this.a == 0)) {
                throw new AssertionError();
            }
        }
        if (this.b) {
            shutdown();
        }
    }
}
