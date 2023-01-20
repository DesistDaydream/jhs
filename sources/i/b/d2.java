package i.b;

import kotlin.Metadata;
import kotlinx.coroutines.JobSupport;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\u00020\u00038\u0010@\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u0005R\u0016\u0010\u0010\u001a\u00020\u00038P@\u0010X\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005¨\u0006\u0015"}, d2 = {"Li/b/d2;", "Lkotlinx/coroutines/JobSupport;", "Li/b/z;", "", "l1", "()Z", "complete", "", "exception", e.j.a.b.c.f.f10128d, "(Ljava/lang/Throwable;)Z", "b", "Z", "t0", "handlesException", "v0", "onCancelComplete", "Li/b/b2;", "parent", "<init>", "(Li/b/b2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public class d2 extends JobSupport implements z {
    private final boolean b;

    public d2(@k.e.a.e b2 b2Var) {
        super(true);
        C0(b2Var);
        this.b = l1();
    }

    private final boolean l1() {
        JobSupport jobSupport;
        t y0 = y0();
        if (!(y0 instanceof u)) {
            y0 = null;
        }
        u uVar = (u) y0;
        if (uVar != null && (jobSupport = (JobSupport) uVar.f15739d) != null) {
            while (!jobSupport.t0()) {
                t y02 = jobSupport.y0();
                if (!(y02 instanceof u)) {
                    y02 = null;
                }
                u uVar2 = (u) y02;
                if (uVar2 != null) {
                    jobSupport = (JobSupport) uVar2.f15739d;
                    if (jobSupport == null) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // i.b.z
    public boolean complete() {
        return K0(h.t1.a);
    }

    @Override // i.b.z
    public boolean d(@k.e.a.d Throwable th) {
        return K0(new b0(th, false, 2, null));
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean t0() {
        return this.b;
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean v0() {
        return true;
    }
}
