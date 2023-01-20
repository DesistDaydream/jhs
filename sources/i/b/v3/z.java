package i.b.v3;

import h.t1;
import i.b.q0;
import i.b.w3.i0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlinx.coroutines.flow.StateFlowImpl;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\rJ\u001b\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b0\u00072\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\tH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Li/b/v3/z;", "Li/b/v3/c0/c;", "Lkotlinx/coroutines/flow/StateFlowImpl;", "flow", "", "c", "(Lkotlinx/coroutines/flow/StateFlowImpl;)Z", "", "Lh/e2/c;", "Lh/t1;", com.huawei.hms.push.e.a, "(Lkotlinx/coroutines/flow/StateFlowImpl;)[Lkotlin/coroutines/Continuation;", "f", "()V", "g", "()Z", e.j.a.b.c.f.f10128d, "(Lh/e2/c;)Ljava/lang/Object;", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class z extends i.b.v3.c0.c<StateFlowImpl<?>> {
    public static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(z.class, Object.class, "_state");
    public volatile Object _state = null;

    @Override // i.b.v3.c0.c
    /* renamed from: c */
    public boolean a(@k.e.a.d StateFlowImpl<?> stateFlowImpl) {
        i0 i0Var;
        if (this._state != null) {
            return false;
        }
        i0Var = y.a;
        this._state = i0Var;
        return true;
    }

    @k.e.a.e
    public final Object d(@k.e.a.d h.e2.c<? super t1> cVar) {
        i0 i0Var;
        i0 i0Var2;
        i.b.o oVar = new i.b.o(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
        oVar.G();
        if (!q0.b() || h.e2.k.a.a.a(!(this._state instanceof i.b.o)).booleanValue()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
            i0Var = y.a;
            if (!atomicReferenceFieldUpdater.compareAndSet(this, i0Var, oVar)) {
                if (q0.b()) {
                    Object obj = this._state;
                    i0Var2 = y.b;
                    if (!h.e2.k.a.a.a(obj == i0Var2).booleanValue()) {
                        throw new AssertionError();
                    }
                }
                t1 t1Var = t1.a;
                Result.a aVar = Result.Companion;
                oVar.resumeWith(Result.m106constructorimpl(t1Var));
            }
            Object B = oVar.B();
            if (B == h.e2.j.b.h()) {
                h.e2.k.a.f.c(cVar);
            }
            return B;
        }
        throw new AssertionError();
    }

    @Override // i.b.v3.c0.c
    @k.e.a.d
    /* renamed from: e */
    public h.e2.c<t1>[] b(@k.e.a.d StateFlowImpl<?> stateFlowImpl) {
        this._state = null;
        return i.b.v3.c0.b.a;
    }

    public final void f() {
        i0 i0Var;
        i0 i0Var2;
        i0 i0Var3;
        i0 i0Var4;
        while (true) {
            Object obj = this._state;
            if (obj == null) {
                return;
            }
            i0Var = y.b;
            if (obj == i0Var) {
                return;
            }
            i0Var2 = y.a;
            if (obj == i0Var2) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
                i0Var3 = y.b;
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, i0Var3)) {
                    return;
                }
            } else {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = a;
                i0Var4 = y.a;
                if (atomicReferenceFieldUpdater2.compareAndSet(this, obj, i0Var4)) {
                    t1 t1Var = t1.a;
                    Result.a aVar = Result.Companion;
                    ((i.b.o) obj).resumeWith(Result.m106constructorimpl(t1Var));
                    return;
                }
            }
        }
    }

    public final boolean g() {
        i0 i0Var;
        i0 i0Var2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        i0Var = y.a;
        Object andSet = atomicReferenceFieldUpdater.getAndSet(this, i0Var);
        if (!q0.b() || (!(andSet instanceof i.b.o))) {
            i0Var2 = y.b;
            return andSet == i0Var2;
        }
        throw new AssertionError();
    }
}
