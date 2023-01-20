package i.b.y3;

import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.umeng.analytics.pro.am;
import i.b.q0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b(\u0010)J\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u0012*\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0011J!\u0010\u0017\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0000¢\u0006\u0004\b\u001b\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\f¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u001f8@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u001f8@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\b#\u0010!R\u001e\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010&¨\u0006*"}, d2 = {"Li/b/y3/n;", "", "Li/b/y3/i;", "task", "c", "(Li/b/y3/i;)Li/b/y3/i;", "victim", "", "blockingOnly", "", "m", "(Li/b/y3/n;Z)J", "Li/b/y3/e;", "queue", "j", "(Li/b/y3/e;)Z", "i", "()Li/b/y3/i;", "Lh/t1;", e.j.a.b.c.f.f10128d, "(Li/b/y3/i;)V", "h", "fair", am.av, "(Li/b/y3/i;Z)Li/b/y3/i;", NotifyType.LIGHTS, "(Li/b/y3/n;)J", "k", "globalQueue", "g", "(Li/b/y3/e;)V", "", "f", "()I", "size", com.huawei.hms.push.e.a, "bufferSize", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "buffer", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class n {
    private static final AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "lastScheduledTask");

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f15936c = AtomicIntegerFieldUpdater.newUpdater(n.class, "producerIndex");

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f15937d = AtomicIntegerFieldUpdater.newUpdater(n.class, "consumerIndex");

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f15938e = AtomicIntegerFieldUpdater.newUpdater(n.class, "blockingTasksInBuffer");
    private final AtomicReferenceArray<i> a = new AtomicReferenceArray<>(128);
    private volatile Object lastScheduledTask = null;
    private volatile int producerIndex = 0;
    private volatile int consumerIndex = 0;
    private volatile int blockingTasksInBuffer = 0;

    public static /* synthetic */ i b(n nVar, i iVar, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return nVar.a(iVar, z);
    }

    private final i c(i iVar) {
        if (iVar.b.f0() == 1) {
            f15938e.incrementAndGet(this);
        }
        if (e() == 127) {
            return iVar;
        }
        int i2 = this.producerIndex & 127;
        while (this.a.get(i2) != null) {
            Thread.yield();
        }
        this.a.lazySet(i2, iVar);
        f15936c.incrementAndGet(this);
        return null;
    }

    private final void d(i iVar) {
        if (iVar != null) {
            if (iVar.b.f0() == 1) {
                int decrementAndGet = f15938e.decrementAndGet(this);
                if (q0.b()) {
                    if (!(decrementAndGet >= 0)) {
                        throw new AssertionError();
                    }
                }
            }
        }
    }

    private final i i() {
        i andSet;
        while (true) {
            int i2 = this.consumerIndex;
            if (i2 - this.producerIndex == 0) {
                return null;
            }
            int i3 = i2 & 127;
            if (f15937d.compareAndSet(this, i2, i2 + 1) && (andSet = this.a.getAndSet(i3, null)) != null) {
                d(andSet);
                return andSet;
            }
        }
    }

    private final boolean j(e eVar) {
        i i2 = i();
        if (i2 != null) {
            eVar.a(i2);
            return true;
        }
        return false;
    }

    private final long m(n nVar, boolean z) {
        i iVar;
        do {
            iVar = (i) nVar.lastScheduledTask;
            if (iVar == null) {
                return -2L;
            }
            if (z) {
                if (!(iVar.b.f0() == 1)) {
                    return -2L;
                }
            }
            long a = l.f15933h.a() - iVar.a;
            long j2 = l.f15928c;
            if (a < j2) {
                return j2 - a;
            }
        } while (!b.compareAndSet(nVar, iVar, null));
        b(this, iVar, false, 2, null);
        return -1L;
    }

    @k.e.a.e
    public final i a(@k.e.a.d i iVar, boolean z) {
        if (z) {
            return c(iVar);
        }
        i iVar2 = (i) b.getAndSet(this, iVar);
        if (iVar2 != null) {
            return c(iVar2);
        }
        return null;
    }

    public final int e() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int f() {
        return this.lastScheduledTask != null ? e() + 1 : e();
    }

    public final void g(@k.e.a.d e eVar) {
        i iVar = (i) b.getAndSet(this, null);
        if (iVar != null) {
            eVar.a(iVar);
        }
        do {
        } while (j(eVar));
    }

    @k.e.a.e
    public final i h() {
        i iVar = (i) b.getAndSet(this, null);
        return iVar != null ? iVar : i();
    }

    public final long k(@k.e.a.d n nVar) {
        if (q0.b()) {
            if (!(e() == 0)) {
                throw new AssertionError();
            }
        }
        int i2 = nVar.producerIndex;
        AtomicReferenceArray<i> atomicReferenceArray = nVar.a;
        for (int i3 = nVar.consumerIndex; i3 != i2; i3++) {
            int i4 = i3 & 127;
            if (nVar.blockingTasksInBuffer == 0) {
                break;
            }
            i iVar = atomicReferenceArray.get(i4);
            if (iVar != null) {
                if ((iVar.b.f0() == 1) && atomicReferenceArray.compareAndSet(i4, iVar, null)) {
                    f15938e.decrementAndGet(nVar);
                    b(this, iVar, false, 2, null);
                    return -1L;
                }
            }
        }
        return m(nVar, true);
    }

    public final long l(@k.e.a.d n nVar) {
        if (q0.b()) {
            if (!(e() == 0)) {
                throw new AssertionError();
            }
        }
        i i2 = nVar.i();
        if (i2 != null) {
            i b2 = b(this, i2, false, 2, null);
            if (q0.b()) {
                if (b2 == null) {
                    return -1L;
                }
                throw new AssertionError();
            }
            return -1L;
        }
        return m(nVar, false);
    }
}
