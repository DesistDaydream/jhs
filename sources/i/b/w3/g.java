package i.b.w3;

import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import i.b.w3.g;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\b \u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u00020\u0002B\u0011\u0012\b\u0010\u0018\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\"\u0010#J \u0010\u0006\u001a\u0004\u0018\u00018\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\b¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0015\u0010\u0016\u001a\u0004\u0018\u00018\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0018\u001a\u0004\u0018\u00018\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00018\u00008B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00028B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00028\u00008B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0015R\u0013\u0010!\u001a\u00020\t8F@\u0006¢\u0006\u0006\u001a\u0004\b \u0010\u0010¨\u0006$"}, d2 = {"Li/b/w3/g;", "N", "", "Lkotlin/Function0;", "", "onClosedAction", "k", "(Lh/k2/u/a;)Li/b/w3/g;", "value", "", "m", "(Li/b/w3/g;)Z", "Lh/t1;", "b", "()V", "j", "()Z", NotifyType.LIGHTS, "g", "removed", e.j.a.b.c.f.f10128d, "()Li/b/w3/g;", "next", "f", "prev", "c", "leftmostAliveNode", com.huawei.hms.push.e.a, "()Ljava/lang/Object;", "nextOrClosed", "h", "rightmostAliveNode", "i", "isTail", "<init>", "(Li/b/w3/g;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public abstract class g<N extends g<N>> {
    private static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "_next");
    private static final AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "_prev");
    private volatile Object _next = null;
    private volatile Object _prev;

    public g(@k.e.a.e N n) {
        this._prev = n;
    }

    private final N c() {
        N f2 = f();
        while (f2 != null && f2.g()) {
            f2 = (N) f2._prev;
        }
        return f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object e() {
        return this._next;
    }

    private final N h() {
        if (!i.b.q0.b() || (!i())) {
            N d2 = d();
            while (d2.g()) {
                d2 = (N) d2.d();
            }
            return d2;
        }
        throw new AssertionError();
    }

    public final void b() {
        b.lazySet(this, null);
    }

    @k.e.a.e
    public final N d() {
        Object e2 = e();
        if (e2 == f.b()) {
            return null;
        }
        return (N) e2;
    }

    @k.e.a.e
    public final N f() {
        return (N) this._prev;
    }

    public abstract boolean g();

    public final boolean i() {
        return d() == null;
    }

    public final boolean j() {
        return a.compareAndSet(this, null, f.b());
    }

    @k.e.a.e
    public final N k(@k.e.a.d h.k2.u.a aVar) {
        Object e2 = e();
        if (e2 != f.b()) {
            return (N) e2;
        }
        aVar.invoke();
        throw new KotlinNothingValueException();
    }

    public final void l() {
        if (i.b.q0.b() && !g()) {
            throw new AssertionError();
        }
        if (i.b.q0.b() && !(!i())) {
            throw new AssertionError();
        }
        while (true) {
            N c2 = c();
            N h2 = h();
            h2._prev = c2;
            if (c2 != null) {
                c2._next = h2;
            }
            if (!h2.g() && (c2 == null || !c2.g())) {
                return;
            }
        }
    }

    public final boolean m(@k.e.a.d N n) {
        return a.compareAndSet(this, null, n);
    }
}
