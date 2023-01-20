package i.b.t3;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.umeng.analytics.pro.am;
import h.t1;
import i.b.q0;
import i.b.t3.b;
import i.b.w3.i0;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlinx.coroutines.channels.AbstractChannel;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B9\u0012\u0006\u0010.\u001a\u00020\u0003\u0012\u0006\u00105\u001a\u000202\u0012 \u0010I\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t\u0018\u00010Gj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`H¢\u0006\u0004\bJ\u0010KJ\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0001\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00028\u00002\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0014¢\u0006\u0004\b\u0001\u0010\u0013J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0015\u001a\u00020\u0014H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0018\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001f\u001a\u00020\u001e2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0014¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u001eH\u0014¢\u0006\u0004\b\"\u0010#R\u001e\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8T@\u0014X\u0094\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u00038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u001e8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u00020\u001e8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00100R\u0016\u00109\u001a\u00020\u001e8D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\b8\u00100R\u0016\u0010;\u001a\u00020\u001e8D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\b:\u00100R\u0016\u0010=\u001a\u00020\u001e8D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\b<\u00100R\u0016\u0010?\u001a\u00020\u001e8D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\b>\u00100R\u0016\u0010@\u001a\u00020\u001e8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b@\u00100R\u001a\u0010E\u001a\u00060Aj\u0002`B8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010F\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010-¨\u0006L"}, d2 = {"Li/b/t3/h;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/AbstractChannel;", "", "currentSize", "Li/b/w3/i0;", "o0", "(I)Li/b/w3/i0;", "element", "Lh/t1;", "m0", "(ILjava/lang/Object;)V", "n0", "(I)V", "", "D", "(Ljava/lang/Object;)Ljava/lang/Object;", "Li/b/z3/f;", "select", "(Ljava/lang/Object;Li/b/z3/f;)Ljava/lang/Object;", "Li/b/t3/b0;", "send", "k", "(Li/b/t3/b0;)Ljava/lang/Object;", "f0", "()Ljava/lang/Object;", "g0", "(Li/b/z3/f;)Ljava/lang/Object;", "Li/b/t3/x;", "receive", "", ExifInterface.LONGITUDE_WEST, "(Li/b/t3/x;)Z", "wasClosed", "c0", "(Z)V", "", com.huawei.hms.push.e.a, "[Ljava/lang/Object;", "buffer", "", NotifyType.LIGHTS, "()Ljava/lang/String;", "bufferDebugString", "g", ExpandableTextView.P, "capacity", "c", "()Z", "isFull", "Lkotlinx/coroutines/channels/BufferOverflow;", "h", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "f", "isClosedForReceive", IAdInterListener.AdReqParam.WIDTH, "isBufferFull", am.aH, "isBufferAlwaysFull", "Z", "isBufferAlwaysEmpty", "a0", "isBufferEmpty", "isEmpty", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", e.j.a.b.c.f.f10128d, "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "head", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(ILkotlinx/coroutines/channels/BufferOverflow;Lh/k2/u/l;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public class h<E> extends AbstractChannel<E> {

    /* renamed from: d  reason: collision with root package name */
    private final ReentrantLock f15822d;

    /* renamed from: e  reason: collision with root package name */
    private Object[] f15823e;

    /* renamed from: f  reason: collision with root package name */
    private int f15824f;

    /* renamed from: g  reason: collision with root package name */
    private final int f15825g;

    /* renamed from: h  reason: collision with root package name */
    private final BufferOverflow f15826h;
    private volatile int size;

    public h(int i2, @k.e.a.d BufferOverflow bufferOverflow, @k.e.a.e h.k2.u.l<? super E, t1> lVar) {
        super(lVar);
        this.f15825g = i2;
        this.f15826h = bufferOverflow;
        if (i2 >= 1) {
            this.f15822d = new ReentrantLock();
            Object[] objArr = new Object[Math.min(i2, 8)];
            h.a2.n.w2(objArr, a.f15798d, 0, 0, 6, null);
            t1 t1Var = t1.a;
            this.f15823e = objArr;
            this.size = 0;
            return;
        }
        throw new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + i2 + " was specified").toString());
    }

    private final void m0(int i2, E e2) {
        if (i2 < this.f15825g) {
            n0(i2);
            Object[] objArr = this.f15823e;
            objArr[(this.f15824f + i2) % objArr.length] = e2;
            return;
        }
        if (q0.b()) {
            if (!(this.f15826h == BufferOverflow.DROP_OLDEST)) {
                throw new AssertionError();
            }
        }
        Object[] objArr2 = this.f15823e;
        int i3 = this.f15824f;
        objArr2[i3 % objArr2.length] = null;
        objArr2[(i2 + i3) % objArr2.length] = e2;
        this.f15824f = (i3 + 1) % objArr2.length;
    }

    private final void n0(int i2) {
        Object[] objArr = this.f15823e;
        if (i2 >= objArr.length) {
            int min = Math.min(objArr.length * 2, this.f15825g);
            Object[] objArr2 = new Object[min];
            for (int i3 = 0; i3 < i2; i3++) {
                Object[] objArr3 = this.f15823e;
                objArr2[i3] = objArr3[(this.f15824f + i3) % objArr3.length];
            }
            h.a2.n.n2(objArr2, a.f15798d, i2, min);
            this.f15823e = objArr2;
            this.f15824f = 0;
        }
    }

    private final i0 o0(int i2) {
        if (i2 < this.f15825g) {
            this.size = i2 + 1;
            return null;
        }
        int i3 = g.a[this.f15826h.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }
            return a.f15799e;
        }
        return a.f15800f;
    }

    @Override // i.b.t3.b
    @k.e.a.d
    public Object D(E e2) {
        z<E> M;
        i0 A;
        ReentrantLock reentrantLock = this.f15822d;
        reentrantLock.lock();
        try {
            int i2 = this.size;
            p<?> n = n();
            if (n != null) {
                return n;
            }
            i0 o0 = o0(i2);
            if (o0 != null) {
                return o0;
            }
            if (i2 == 0) {
                do {
                    M = M();
                    if (M != null) {
                        if (M instanceof p) {
                            this.size = i2;
                            return M;
                        }
                        A = M.A(e2, null);
                    }
                } while (A == null);
                if (q0.b()) {
                    if (!(A == i.b.p.f15778d)) {
                        throw new AssertionError();
                    }
                }
                this.size = i2;
                t1 t1Var = t1.a;
                reentrantLock.unlock();
                M.i(e2);
                return M.e();
            }
            m0(i2, e2);
            return a.f15799e;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // i.b.t3.b
    @k.e.a.d
    public Object E(E e2, @k.e.a.d i.b.z3.f<?> fVar) {
        ReentrantLock reentrantLock = this.f15822d;
        reentrantLock.lock();
        try {
            int i2 = this.size;
            p<?> n = n();
            if (n != null) {
                return n;
            }
            i0 o0 = o0(i2);
            if (o0 != null) {
                return o0;
            }
            if (i2 == 0) {
                while (true) {
                    b.d<E> j2 = j(e2);
                    Object z = fVar.z(j2);
                    if (z == null) {
                        this.size = i2;
                        z<? super E> o = j2.o();
                        t1 t1Var = t1.a;
                        reentrantLock.unlock();
                        o.i(e2);
                        return o.e();
                    } else if (z == a.f15800f) {
                        break;
                    } else if (z != i.b.w3.c.b) {
                        if (z != i.b.z3.g.d() && !(z instanceof p)) {
                            throw new IllegalStateException(("performAtomicTrySelect(describeTryOffer) returned " + z).toString());
                        }
                        this.size = i2;
                        return z;
                    }
                }
            }
            if (!fVar.s()) {
                this.size = i2;
                return i.b.z3.g.d();
            }
            m0(i2, e2);
            return a.f15799e;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public boolean W(@k.e.a.d x<? super E> xVar) {
        ReentrantLock reentrantLock = this.f15822d;
        reentrantLock.lock();
        try {
            return super.W(xVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public final boolean Z() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public final boolean a0() {
        return this.size == 0;
    }

    @Override // i.b.t3.b, i.b.t3.c0
    public boolean c() {
        ReentrantLock reentrantLock = this.f15822d;
        reentrantLock.lock();
        try {
            return z();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public void c0(boolean z) {
        h.k2.u.l<E, t1> lVar = this.b;
        ReentrantLock reentrantLock = this.f15822d;
        reentrantLock.lock();
        try {
            int i2 = this.size;
            UndeliveredElementException undeliveredElementException = null;
            for (int i3 = 0; i3 < i2; i3++) {
                Object obj = this.f15823e[this.f15824f];
                if (lVar != null && obj != a.f15798d) {
                    undeliveredElementException = OnUndeliveredElementKt.c(lVar, obj, undeliveredElementException);
                }
                Object[] objArr = this.f15823e;
                int i4 = this.f15824f;
                objArr[i4] = a.f15798d;
                this.f15824f = (i4 + 1) % objArr.length;
            }
            this.size = 0;
            t1 t1Var = t1.a;
            reentrantLock.unlock();
            super.c0(z);
            if (undeliveredElementException != null) {
                throw undeliveredElementException;
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel, i.b.t3.y
    public boolean f() {
        ReentrantLock reentrantLock = this.f15822d;
        reentrantLock.lock();
        try {
            return super.f();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    @k.e.a.e
    public Object f0() {
        ReentrantLock reentrantLock = this.f15822d;
        reentrantLock.lock();
        try {
            int i2 = this.size;
            if (i2 == 0) {
                Object n = n();
                if (n == null) {
                    n = a.f15801g;
                }
                return n;
            }
            Object[] objArr = this.f15823e;
            int i3 = this.f15824f;
            Object obj = objArr[i3];
            b0 b0Var = null;
            objArr[i3] = null;
            this.size = i2 - 1;
            Object obj2 = a.f15801g;
            if (i2 == this.f15825g) {
                b0 b0Var2 = null;
                while (true) {
                    b0 P = P();
                    if (P == null) {
                        b0Var = b0Var2;
                        break;
                    }
                    i0 m0 = P.m0(null);
                    if (m0 != null) {
                        if (q0.b()) {
                            if (!(m0 == i.b.p.f15778d)) {
                                throw new AssertionError();
                            }
                        }
                        obj2 = P.k0();
                        b0Var = P;
                        r6 = true;
                    } else {
                        P.n0();
                        b0Var2 = P;
                    }
                }
            }
            if (obj2 != a.f15801g && !(obj2 instanceof p)) {
                this.size = i2;
                Object[] objArr2 = this.f15823e;
                objArr2[(this.f15824f + i2) % objArr2.length] = obj2;
            }
            this.f15824f = (this.f15824f + 1) % this.f15823e.length;
            t1 t1Var = t1.a;
            if (r6) {
                b0Var.j0();
            }
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x009c A[Catch: all -> 0x00c0, TRY_LEAVE, TryCatch #0 {all -> 0x00c0, blocks: (B:3:0x0005, B:5:0x0009, B:8:0x0010, B:11:0x0016, B:13:0x002a, B:15:0x0034, B:34:0x0082, B:36:0x0086, B:38:0x008a, B:44:0x00ac, B:39:0x0096, B:41:0x009c, B:17:0x0041, B:20:0x0046, B:23:0x004b, B:25:0x0051, B:28:0x005d, B:30:0x0061, B:31:0x0066, B:32:0x0080), top: B:52:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00bc  */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object g0(@k.e.a.d i.b.z3.f<?> r9) {
        /*
            r8 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r8.f15822d
            r0.lock()
            int r1 = r8.size     // Catch: java.lang.Throwable -> Lc0
            if (r1 != 0) goto L16
            i.b.t3.p r9 = r8.n()     // Catch: java.lang.Throwable -> Lc0
            if (r9 == 0) goto L10
            goto L12
        L10:
            i.b.w3.i0 r9 = i.b.t3.a.f15801g     // Catch: java.lang.Throwable -> Lc0
        L12:
            r0.unlock()
            return r9
        L16:
            java.lang.Object[] r2 = r8.f15823e     // Catch: java.lang.Throwable -> Lc0
            int r3 = r8.f15824f     // Catch: java.lang.Throwable -> Lc0
            r4 = r2[r3]     // Catch: java.lang.Throwable -> Lc0
            r5 = 0
            r2[r3] = r5     // Catch: java.lang.Throwable -> Lc0
            int r2 = r1 + (-1)
            r8.size = r2     // Catch: java.lang.Throwable -> Lc0
            i.b.w3.i0 r2 = i.b.t3.a.f15801g     // Catch: java.lang.Throwable -> Lc0
            int r3 = r8.f15825g     // Catch: java.lang.Throwable -> Lc0
            r6 = 1
            if (r1 != r3) goto L81
        L2a:
            kotlinx.coroutines.channels.AbstractChannel$g r3 = r8.U()     // Catch: java.lang.Throwable -> Lc0
            java.lang.Object r7 = r9.z(r3)     // Catch: java.lang.Throwable -> Lc0
            if (r7 != 0) goto L41
            java.lang.Object r2 = r3.o()     // Catch: java.lang.Throwable -> Lc0
            r5 = r2
            i.b.t3.b0 r5 = (i.b.t3.b0) r5     // Catch: java.lang.Throwable -> Lc0
            java.lang.Object r2 = r5.k0()     // Catch: java.lang.Throwable -> Lc0
        L3f:
            r3 = 1
            goto L82
        L41:
            i.b.w3.i0 r3 = i.b.t3.a.f15801g     // Catch: java.lang.Throwable -> Lc0
            if (r7 != r3) goto L46
            goto L81
        L46:
            java.lang.Object r3 = i.b.w3.c.b     // Catch: java.lang.Throwable -> Lc0
            if (r7 != r3) goto L4b
            goto L2a
        L4b:
            java.lang.Object r2 = i.b.z3.g.d()     // Catch: java.lang.Throwable -> Lc0
            if (r7 != r2) goto L5d
            r8.size = r1     // Catch: java.lang.Throwable -> Lc0
            java.lang.Object[] r9 = r8.f15823e     // Catch: java.lang.Throwable -> Lc0
            int r1 = r8.f15824f     // Catch: java.lang.Throwable -> Lc0
            r9[r1] = r4     // Catch: java.lang.Throwable -> Lc0
            r0.unlock()
            return r7
        L5d:
            boolean r2 = r7 instanceof i.b.t3.p     // Catch: java.lang.Throwable -> Lc0
            if (r2 == 0) goto L66
            r5 = r7
            i.b.t3.b0 r5 = (i.b.t3.b0) r5     // Catch: java.lang.Throwable -> Lc0
            r2 = r7
            goto L3f
        L66:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc0
            r9.<init>()     // Catch: java.lang.Throwable -> Lc0
            java.lang.String r1 = "performAtomicTrySelect(describeTryOffer) returned "
            r9.append(r1)     // Catch: java.lang.Throwable -> Lc0
            r9.append(r7)     // Catch: java.lang.Throwable -> Lc0
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> Lc0
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> Lc0
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> Lc0
            r1.<init>(r9)     // Catch: java.lang.Throwable -> Lc0
            throw r1     // Catch: java.lang.Throwable -> Lc0
        L81:
            r3 = 0
        L82:
            i.b.w3.i0 r7 = i.b.t3.a.f15801g     // Catch: java.lang.Throwable -> Lc0
            if (r2 == r7) goto L96
            boolean r7 = r2 instanceof i.b.t3.p     // Catch: java.lang.Throwable -> Lc0
            if (r7 != 0) goto L96
            r8.size = r1     // Catch: java.lang.Throwable -> Lc0
            java.lang.Object[] r9 = r8.f15823e     // Catch: java.lang.Throwable -> Lc0
            int r7 = r8.f15824f     // Catch: java.lang.Throwable -> Lc0
            int r7 = r7 + r1
            int r1 = r9.length     // Catch: java.lang.Throwable -> Lc0
            int r7 = r7 % r1
            r9[r7] = r2     // Catch: java.lang.Throwable -> Lc0
            goto Lac
        L96:
            boolean r9 = r9.s()     // Catch: java.lang.Throwable -> Lc0
            if (r9 != 0) goto Lac
            r8.size = r1     // Catch: java.lang.Throwable -> Lc0
            java.lang.Object[] r9 = r8.f15823e     // Catch: java.lang.Throwable -> Lc0
            int r1 = r8.f15824f     // Catch: java.lang.Throwable -> Lc0
            r9[r1] = r4     // Catch: java.lang.Throwable -> Lc0
            java.lang.Object r9 = i.b.z3.g.d()     // Catch: java.lang.Throwable -> Lc0
            r0.unlock()
            return r9
        Lac:
            int r9 = r8.f15824f     // Catch: java.lang.Throwable -> Lc0
            int r9 = r9 + r6
            java.lang.Object[] r1 = r8.f15823e     // Catch: java.lang.Throwable -> Lc0
            int r1 = r1.length     // Catch: java.lang.Throwable -> Lc0
            int r9 = r9 % r1
            r8.f15824f = r9     // Catch: java.lang.Throwable -> Lc0
            h.t1 r9 = h.t1.a     // Catch: java.lang.Throwable -> Lc0
            r0.unlock()
            if (r3 == 0) goto Lbf
            r5.j0()
        Lbf:
            return r4
        Lc0:
            r9 = move-exception
            r0.unlock()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: i.b.t3.h.g0(i.b.z3.f):java.lang.Object");
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel, i.b.t3.y
    public boolean isEmpty() {
        ReentrantLock reentrantLock = this.f15822d;
        reentrantLock.lock();
        try {
            return b0();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // i.b.t3.b
    @k.e.a.e
    public Object k(@k.e.a.d b0 b0Var) {
        ReentrantLock reentrantLock = this.f15822d;
        reentrantLock.lock();
        try {
            return super.k(b0Var);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // i.b.t3.b
    @k.e.a.d
    public String l() {
        return "(buffer:capacity=" + this.f15825g + ",size=" + this.size + ')';
    }

    @Override // i.b.t3.b
    public final boolean u() {
        return false;
    }

    @Override // i.b.t3.b
    public final boolean w() {
        return this.size == this.f15825g && this.f15826h == BufferOverflow.SUSPEND;
    }
}
