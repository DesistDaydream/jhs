package i.b;

import com.umeng.analytics.pro.am;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002#\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0015¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u000eJ\u001a\u0010\u0010\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0016R\u001e\u0010\u001b\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001a¨\u0006\u001e"}, d2 = {"Li/b/k3;", "Lkotlin/Function1;", "", "Lh/k0;", "name", "cause", "Lh/t1;", "Lkotlinx/coroutines/CompletionHandler;", "", "state", "", "b", "(I)Ljava/lang/Void;", e.j.a.b.c.f.f10128d, "()V", am.av, "c", "(Ljava/lang/Throwable;)V", "Li/b/e1;", "Li/b/e1;", "cancelHandle", "Li/b/b2;", "Li/b/b2;", "job", "Ljava/lang/Thread;", "kotlin.jvm.PlatformType", "Ljava/lang/Thread;", "targetThread", "<init>", "(Li/b/b2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class k3 implements h.k2.u.l<Throwable, h.t1> {

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f15764d = AtomicIntegerFieldUpdater.newUpdater(k3.class, "_state");
    private volatile int _state = 0;
    private final Thread a = Thread.currentThread();
    private e1 b;

    /* renamed from: c  reason: collision with root package name */
    private final b2 f15765c;

    public k3(@k.e.a.d b2 b2Var) {
        this.f15765c = b2Var;
    }

    private final Void b(int i2) {
        throw new IllegalStateException(("Illegal state " + i2).toString());
    }

    public final void a() {
        while (true) {
            int i2 = this._state;
            if (i2 != 0) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        Thread.interrupted();
                        return;
                    } else {
                        b(i2);
                        throw new KotlinNothingValueException();
                    }
                }
            } else if (f15764d.compareAndSet(this, i2, 1)) {
                e1 e1Var = this.b;
                if (e1Var != null) {
                    e1Var.dispose();
                    return;
                }
                return;
            }
        }
    }

    public void c(@k.e.a.e Throwable th) {
        int i2;
        do {
            i2 = this._state;
            if (i2 != 0) {
                if (i2 == 1 || i2 == 2 || i2 == 3) {
                    return;
                }
                b(i2);
                throw new KotlinNothingValueException();
            }
        } while (!f15764d.compareAndSet(this, i2, 2));
        this.a.interrupt();
        this._state = 3;
    }

    public final void d() {
        int i2;
        this.b = this.f15765c.i(true, true, this);
        do {
            i2 = this._state;
            if (i2 != 0) {
                if (i2 == 2 || i2 == 3) {
                    return;
                }
                b(i2);
                throw new KotlinNothingValueException();
            }
        } while (!f15764d.compareAndSet(this, i2, 0));
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ h.t1 invoke(Throwable th) {
        c(th);
        return h.t1.a;
    }
}
