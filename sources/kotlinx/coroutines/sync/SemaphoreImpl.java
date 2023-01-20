package kotlinx.coroutines.sync;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.huawei.hms.push.e;
import com.umeng.analytics.pro.am;
import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.f;
import h.k2.u.l;
import h.t1;
import i.b.a4.d;
import i.b.n;
import i.b.o;
import i.b.q;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u001b\u001a\u00020\u0011¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\n\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\n\u0010\u0007J\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\tJ\u0013\u0010\f\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u0003H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0015R\"\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00030\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/sync/SemaphoreImpl;", "Li/b/a4/d;", "Li/b/n;", "Lh/t1;", "cont", "", "f", "(Li/b/n;)Z", "h", "()Z", "g", "b", "c", "(Lh/e2/c;)Ljava/lang/Object;", e.a, "release", "()V", "", am.av, "()I", "availablePermits", ExpandableTextView.P, "permits", "Lkotlin/Function1;", "", "Lh/k2/u/l;", "onCancellationRelease", "acquiredPermits", "<init>", "(II)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class SemaphoreImpl implements d {

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f17025c = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "head");

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicLongFieldUpdater f17026d = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "deqIdx");

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f17027e = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "tail");

    /* renamed from: f  reason: collision with root package name */
    private static final AtomicLongFieldUpdater f17028f = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "enqIdx");

    /* renamed from: g  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f17029g = AtomicIntegerFieldUpdater.newUpdater(SemaphoreImpl.class, "_availablePermits");
    public volatile int _availablePermits;
    private final l<Throwable, t1> a;
    private final int b;
    private volatile long deqIdx = 0;
    private volatile long enqIdx = 0;
    private volatile Object head;
    private volatile Object tail;

    public SemaphoreImpl(int i2, int i3) {
        this.b = i2;
        boolean z = true;
        if (!(i2 > 0)) {
            throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + i2).toString());
        }
        if ((i3 < 0 || i2 < i3) ? false : false) {
            i.b.a4.e eVar = new i.b.a4.e(0L, null, 2);
            this.head = eVar;
            this.tail = eVar;
            this._availablePermits = i2 - i3;
            this.a = new SemaphoreImpl$onCancellationRelease$1(this);
            return;
        }
        throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + i2).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0058, code lost:
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0074, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean f(i.b.n<? super h.t1> r18) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.SemaphoreImpl.f(i.b.n):boolean");
    }

    private final boolean g(n<? super t1> nVar) {
        Object D = nVar.D(t1.a, null, this.a);
        if (D != null) {
            nVar.P(D);
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0054, code lost:
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0070, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean h() {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.SemaphoreImpl.h():boolean");
    }

    @Override // i.b.a4.d
    public int a() {
        return Math.max(this._availablePermits, 0);
    }

    @Override // i.b.a4.d
    public boolean b() {
        int i2;
        do {
            i2 = this._availablePermits;
            if (i2 <= 0) {
                return false;
            }
        } while (!f17029g.compareAndSet(this, i2, i2 - 1));
        return true;
    }

    @Override // i.b.a4.d
    @k.e.a.e
    public Object c(@k.e.a.d c<? super t1> cVar) {
        if (f17029g.getAndDecrement(this) > 0) {
            return t1.a;
        }
        Object e2 = e(cVar);
        return e2 == b.h() ? e2 : t1.a;
    }

    @k.e.a.e
    public final /* synthetic */ Object e(@k.e.a.d c<? super t1> cVar) {
        o b = q.b(IntrinsicsKt__IntrinsicsJvmKt.d(cVar));
        while (true) {
            if (!f(b)) {
                if (f17029g.getAndDecrement(this) > 0) {
                    t1 t1Var = t1.a;
                    Result.a aVar = Result.Companion;
                    b.resumeWith(Result.m106constructorimpl(t1Var));
                    break;
                }
            } else {
                break;
            }
        }
        Object B = b.B();
        if (B == b.h()) {
            f.c(cVar);
        }
        return B;
    }

    @Override // i.b.a4.d
    public void release() {
        while (true) {
            int i2 = this._availablePermits;
            if (i2 < this.b) {
                if (f17029g.compareAndSet(this, i2, i2 + 1) && (i2 >= 0 || h())) {
                    return;
                }
            } else {
                throw new IllegalStateException(("The number of released permits cannot be greater than " + this.b).toString());
            }
        }
    }
}
