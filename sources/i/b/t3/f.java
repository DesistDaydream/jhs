package i.b.t3;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.umeng.analytics.pro.am;
import h.t1;
import i.b.q0;
import i.b.w3.i0;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlinx.coroutines.channels.AbstractChannel;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\t\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u001bB\u000f\u0012\u0006\u0010O\u001a\u00020B¢\u0006\u0004\bP\u0010FJ\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ4\u0010\u000f\u001a\u00020\t2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\fH\u0082\u0010¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\bJ\u0019\u0010\u001b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0017¢\u0006\u0004\b\u001b\u0010\bJ\u001f\u0010\u001e\u001a\u00020\t2\u000e\u0010\u0005\u001a\n\u0018\u00010\u001cj\u0004\u0018\u0001`\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00028\u0000H\u0014¢\u0006\u0004\b\"\u0010#J#\u0010\u0001\u001a\u00020!2\u0006\u0010 \u001a\u00028\u00002\n\u0010%\u001a\u0006\u0012\u0002\b\u00030$H\u0014¢\u0006\u0004\b\u0001\u0010&R\u001a\u0010+\u001a\u00060'j\u0002`(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R2\u00100\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0,j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f`-8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00103\u001a\u00020\u00068T@\u0014X\u0094\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R$\u00108\u001a\u00020\u00112\u0006\u00104\u001a\u00020\u00118B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b5\u0010\u0013\"\u0004\b6\u00107R$\u0010;\u001a\u00020\u00112\u0006\u00104\u001a\u00020\u00118B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b9\u0010\u0013\"\u0004\b:\u00107R\u0016\u0010=\u001a\u00020\u00068T@\u0014X\u0094\u0004¢\u0006\u0006\u001a\u0004\b<\u00102R\u0016\u0010A\u001a\u00020>8T@\u0014X\u0094\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@R$\u0010G\u001a\u00020B2\u0006\u00104\u001a\u00020B8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001e\u0010K\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0H8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0019\u0010O\u001a\u00020B8\u0006@\u0006¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010D¨\u0006Q"}, d2 = {"Li/b/t3/f;", ExifInterface.LONGITUDE_EAST, "Li/b/t3/b;", "Li/b/t3/i;", "", "cause", "", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/Throwable;)Z", "Lh/t1;", "U", "()V", "Li/b/t3/f$a;", "addSub", "removeSub", "e0", "(Li/b/t3/f$a;Li/b/t3/f$a;)V", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "()J", "index", ExifInterface.LONGITUDE_WEST, "(J)Ljava/lang/Object;", "Li/b/t3/y;", "v", "()Li/b/t3/y;", "K", am.av, "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "b", "(Ljava/util/concurrent/CancellationException;)V", "element", "", "D", "(Ljava/lang/Object;)Ljava/lang/Object;", "Li/b/z3/f;", "select", "(Ljava/lang/Object;Li/b/z3/f;)Ljava/lang/Object;", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", e.j.a.b.c.f.f10128d, "Ljava/util/concurrent/locks/ReentrantLock;", "bufferLock", "", "Lkotlinx/coroutines/internal/SubscribersList;", "f", "Ljava/util/List;", "subscribers", am.aH, "()Z", "isBufferAlwaysFull", "value", "a0", "d0", "(J)V", "tail", "Y", "b0", "head", IAdInterListener.AdReqParam.WIDTH, "isBufferFull", "", NotifyType.LIGHTS, "()Ljava/lang/String;", "bufferDebugString", "", "Z", "()I", "c0", "(I)V", "size", "", com.huawei.hms.push.e.a, "[Ljava/lang/Object;", "buffer", "g", ExpandableTextView.P, "X", "capacity", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class f<E> extends b<E> implements i<E> {
    private volatile long _head;
    private volatile int _size;
    private volatile long _tail;

    /* renamed from: d  reason: collision with root package name */
    private final ReentrantLock f15816d;

    /* renamed from: e  reason: collision with root package name */
    private final Object[] f15817e;

    /* renamed from: f  reason: collision with root package name */
    private final List<a<E>> f15818f;

    /* renamed from: g  reason: collision with root package name */
    private final int f15819g;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B\u0015\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00010\u001f¢\u0006\u0004\b,\u0010-J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u0006J\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\u000f\u0010\tJ\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00072\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00048T@\u0014X\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0006R\u0016\u0010\u0017\u001a\u00020\u00048T@\u0014X\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0006R\u0016\u0010\u0019\u001a\u00020\u00048T@\u0014X\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0006R\u001a\u0010\u001e\u001a\u00060\u001aj\u0002`\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00010\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R$\u0010)\u001a\u00020#2\u0006\u0010$\u001a\u00020#8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00048T@\u0014X\u0094\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0006¨\u0006."}, d2 = {"i/b/t3/f$a", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/AbstractChannel;", "Li/b/t3/y;", "", "o0", "()Z", "", "p0", "()Ljava/lang/Object;", "", "cause", "K", "(Ljava/lang/Throwable;)Z", "m0", "f0", "Li/b/z3/f;", "select", "g0", "(Li/b/z3/f;)Ljava/lang/Object;", IAdInterListener.AdReqParam.WIDTH, "isBufferFull", "Z", "isBufferAlwaysEmpty", "a0", "isBufferEmpty", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", e.j.a.b.c.f.f10128d, "Ljava/util/concurrent/locks/ReentrantLock;", "subLock", "Li/b/t3/f;", com.huawei.hms.push.e.a, "Li/b/t3/f;", "broadcastChannel", "", "value", "n0", "()J", "q0", "(J)V", "subHead", am.aH, "isBufferAlwaysFull", "<init>", "(Li/b/t3/f;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a<E> extends AbstractChannel<E> implements y<E> {
        private volatile long _subHead;

        /* renamed from: d  reason: collision with root package name */
        private final ReentrantLock f15820d;

        /* renamed from: e  reason: collision with root package name */
        private final f<E> f15821e;

        public a(@k.e.a.d f<E> fVar) {
            super(null);
            this.f15821e = fVar;
            this.f15820d = new ReentrantLock();
            this._subHead = 0L;
        }

        private final boolean o0() {
            if (m() != null) {
                return false;
            }
            return (a0() && this.f15821e.m() == null) ? false : true;
        }

        private final Object p0() {
            long n0 = n0();
            p<?> m2 = this.f15821e.m();
            if (n0 >= this.f15821e.a0()) {
                if (m2 == null) {
                    m2 = m();
                }
                return m2 != null ? m2 : i.b.t3.a.f15801g;
            }
            Object W = this.f15821e.W(n0);
            p<?> m3 = m();
            return m3 != null ? m3 : W;
        }

        @Override // i.b.t3.b, i.b.t3.c0
        public boolean K(@k.e.a.e Throwable th) {
            boolean K = super.K(th);
            if (K) {
                f.f0(this.f15821e, null, this, 1, null);
                ReentrantLock reentrantLock = this.f15820d;
                reentrantLock.lock();
                try {
                    q0(this.f15821e.a0());
                    t1 t1Var = t1.a;
                } finally {
                    reentrantLock.unlock();
                }
            }
            return K;
        }

        @Override // kotlinx.coroutines.channels.AbstractChannel
        public boolean Z() {
            return false;
        }

        @Override // kotlinx.coroutines.channels.AbstractChannel
        public boolean a0() {
            return n0() >= this.f15821e.a0();
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x002f  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x003e  */
        @Override // kotlinx.coroutines.channels.AbstractChannel
        @k.e.a.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object f0() {
            /*
                r8 = this;
                java.util.concurrent.locks.ReentrantLock r0 = r8.f15820d
                r0.lock()
                java.lang.Object r1 = r8.p0()     // Catch: java.lang.Throwable -> L45
                boolean r2 = r1 instanceof i.b.t3.p     // Catch: java.lang.Throwable -> L45
                r3 = 1
                if (r2 == 0) goto Lf
                goto L13
            Lf:
                i.b.w3.i0 r2 = i.b.t3.a.f15801g     // Catch: java.lang.Throwable -> L45
                if (r1 != r2) goto L15
            L13:
                r2 = 0
                goto L20
            L15:
                long r4 = r8.n0()     // Catch: java.lang.Throwable -> L45
                r6 = 1
                long r4 = r4 + r6
                r8.q0(r4)     // Catch: java.lang.Throwable -> L45
                r2 = 1
            L20:
                r0.unlock()
                boolean r0 = r1 instanceof i.b.t3.p
                r4 = 0
                if (r0 != 0) goto L2a
                r0 = r4
                goto L2b
            L2a:
                r0 = r1
            L2b:
                i.b.t3.p r0 = (i.b.t3.p) r0
                if (r0 == 0) goto L34
                java.lang.Throwable r0 = r0.f15835d
                r8.K(r0)
            L34:
                boolean r0 = r8.m0()
                if (r0 == 0) goto L3b
                goto L3c
            L3b:
                r3 = r2
            L3c:
                if (r3 == 0) goto L44
                i.b.t3.f<E> r0 = r8.f15821e
                r2 = 3
                i.b.t3.f.f0(r0, r4, r4, r2, r4)
            L44:
                return r1
            L45:
                r1 = move-exception
                r0.unlock()
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: i.b.t3.f.a.f0():java.lang.Object");
        }

        @Override // kotlinx.coroutines.channels.AbstractChannel
        @k.e.a.e
        public Object g0(@k.e.a.d i.b.z3.f<?> fVar) {
            ReentrantLock reentrantLock = this.f15820d;
            reentrantLock.lock();
            try {
                Object p0 = p0();
                boolean z = false;
                if (!(p0 instanceof p) && p0 != i.b.t3.a.f15801g) {
                    if (!fVar.s()) {
                        p0 = i.b.z3.g.d();
                    } else {
                        q0(n0() + 1);
                        z = true;
                    }
                }
                reentrantLock.unlock();
                p pVar = (p) (!(p0 instanceof p) ? null : p0);
                if (pVar != null) {
                    K(pVar.f15835d);
                }
                if (m0() ? true : z) {
                    f.f0(this.f15821e, null, null, 3, null);
                }
                return p0;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        public final boolean m0() {
            p pVar;
            boolean z = false;
            while (true) {
                pVar = null;
                if (!o0() || !this.f15820d.tryLock()) {
                    break;
                }
                try {
                    E e2 = (E) p0();
                    if (e2 != i.b.t3.a.f15801g) {
                        if (e2 instanceof p) {
                            pVar = (p) e2;
                            break;
                        }
                        z<E> M = M();
                        if (M == null || (M instanceof p)) {
                            break;
                        }
                        i0 A = M.A(e2, null);
                        if (A != null) {
                            if (q0.b()) {
                                if (!(A == i.b.p.f15778d)) {
                                    throw new AssertionError();
                                }
                            }
                            q0(n0() + 1);
                            this.f15820d.unlock();
                            M.i(e2);
                            z = true;
                        }
                    }
                } finally {
                    this.f15820d.unlock();
                }
            }
            if (pVar != null) {
                K(pVar.f15835d);
            }
            return z;
        }

        public final long n0() {
            return this._subHead;
        }

        public final void q0(long j2) {
            this._subHead = j2;
        }

        @Override // i.b.t3.b
        public boolean u() {
            throw new IllegalStateException("Should not be used".toString());
        }

        @Override // i.b.t3.b
        public boolean w() {
            throw new IllegalStateException("Should not be used".toString());
        }
    }

    public f(int i2) {
        super(null);
        this.f15819g = i2;
        if (i2 >= 1) {
            this.f15816d = new ReentrantLock();
            this.f15817e = new Object[i2];
            this._head = 0L;
            this._tail = 0L;
            this._size = 0;
            this.f15818f = i.b.w3.e.d();
            return;
        }
        throw new IllegalArgumentException(("ArrayBroadcastChannel capacity must be at least 1, but " + i2 + " was specified").toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // i.b.t3.i
    /* renamed from: T */
    public final boolean a(Throwable th) {
        boolean K = K(th);
        for (a<E> aVar : this.f15818f) {
            aVar.a(th);
        }
        return K;
    }

    private final void U() {
        boolean z = false;
        boolean z2 = false;
        for (a<E> aVar : this.f15818f) {
            if (aVar.m0()) {
                z = true;
            }
            z2 = true;
        }
        if (z || !z2) {
            f0(this, null, null, 3, null);
        }
    }

    private final long V() {
        long j2 = Long.MAX_VALUE;
        for (a<E> aVar : this.f15818f) {
            j2 = h.o2.q.v(j2, aVar.n0());
        }
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final E W(long j2) {
        return (E) this.f15817e[(int) (j2 % this.f15819g)];
    }

    private final long Y() {
        return this._head;
    }

    private final int Z() {
        return this._size;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long a0() {
        return this._tail;
    }

    private final void b0(long j2) {
        this._head = j2;
    }

    private final void c0(int i2) {
        this._size = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0(long j2) {
        this._tail = j2;
    }

    private final void e0(a<E> aVar, a<E> aVar2) {
        b0 P;
        i0 m0;
        while (true) {
            ReentrantLock reentrantLock = this.f15816d;
            reentrantLock.lock();
            if (aVar != null) {
                try {
                    aVar.q0(a0());
                    boolean isEmpty = this.f15818f.isEmpty();
                    this.f15818f.add(aVar);
                    if (!isEmpty) {
                        return;
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
            if (aVar2 != null) {
                this.f15818f.remove(aVar2);
                if (Y() != aVar2.n0()) {
                    return;
                }
            }
            long V = V();
            long a0 = a0();
            long Y = Y();
            long v = h.o2.q.v(V, a0);
            if (v <= Y) {
                return;
            }
            int Z = Z();
            while (Y < v) {
                Object[] objArr = this.f15817e;
                int i2 = this.f15819g;
                objArr[(int) (Y % i2)] = null;
                boolean z = Z >= i2;
                Y++;
                b0(Y);
                Z--;
                c0(Z);
                if (z) {
                    do {
                        P = P();
                        if (P != null && !(P instanceof p)) {
                            m0 = P.m0(null);
                        }
                    } while (m0 == null);
                    if (q0.b()) {
                        if (!(m0 == i.b.p.f15778d)) {
                            throw new AssertionError();
                        }
                    }
                    Object[] objArr2 = this.f15817e;
                    int i3 = (int) (a0 % this.f15819g);
                    if (P != null) {
                        objArr2[i3] = P.k0();
                        c0(Z + 1);
                        d0(a0 + 1);
                        t1 t1Var = t1.a;
                        reentrantLock.unlock();
                        P.j0();
                        U();
                        aVar = null;
                        aVar2 = null;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.channels.Send");
                    }
                }
            }
            return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void f0(f fVar, a aVar, a aVar2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            aVar = null;
        }
        if ((i2 & 2) != 0) {
            aVar2 = null;
        }
        fVar.e0(aVar, aVar2);
    }

    @Override // i.b.t3.b
    @k.e.a.d
    public Object D(E e2) {
        ReentrantLock reentrantLock = this.f15816d;
        reentrantLock.lock();
        try {
            p<?> n = n();
            if (n != null) {
                return n;
            }
            int Z = Z();
            if (Z >= this.f15819g) {
                return i.b.t3.a.f15800f;
            }
            long a0 = a0();
            this.f15817e[(int) (a0 % this.f15819g)] = e2;
            c0(Z + 1);
            d0(a0 + 1);
            t1 t1Var = t1.a;
            reentrantLock.unlock();
            U();
            return i.b.t3.a.f15799e;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // i.b.t3.b
    @k.e.a.d
    public Object E(E e2, @k.e.a.d i.b.z3.f<?> fVar) {
        ReentrantLock reentrantLock = this.f15816d;
        reentrantLock.lock();
        try {
            p<?> n = n();
            if (n != null) {
                return n;
            }
            int Z = Z();
            if (Z >= this.f15819g) {
                return i.b.t3.a.f15800f;
            }
            if (!fVar.s()) {
                return i.b.z3.g.d();
            }
            long a0 = a0();
            this.f15817e[(int) (a0 % this.f15819g)] = e2;
            c0(Z + 1);
            d0(a0 + 1);
            t1 t1Var = t1.a;
            reentrantLock.unlock();
            U();
            return i.b.t3.a.f15799e;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // i.b.t3.b, i.b.t3.c0
    public boolean K(@k.e.a.e Throwable th) {
        if (super.K(th)) {
            U();
            return true;
        }
        return false;
    }

    public final int X() {
        return this.f15819g;
    }

    @Override // i.b.t3.i
    public void b(@k.e.a.e CancellationException cancellationException) {
        a(cancellationException);
    }

    @Override // i.b.t3.b
    @k.e.a.d
    public String l() {
        return "(buffer:capacity=" + this.f15817e.length + ",size=" + Z() + ')';
    }

    @Override // i.b.t3.b
    public boolean u() {
        return false;
    }

    @Override // i.b.t3.i
    @k.e.a.d
    public y<E> v() {
        a aVar = new a(this);
        f0(this, aVar, null, 2, null);
        return aVar;
    }

    @Override // i.b.t3.b
    public boolean w() {
        return Z() >= this.f15819g;
    }
}
