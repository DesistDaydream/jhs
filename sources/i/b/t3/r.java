package i.b.t3;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.umeng.analytics.pro.am;
import h.t1;
import i.b.q0;
import i.b.t3.b;
import i.b.w3.i0;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlinx.coroutines.channels.AbstractChannel;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B)\u0012 \u00102\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0013\u0018\u000100j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`1¢\u0006\u0004\b3\u00104J\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\b\u0010\tJ#\u0010\u0001\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u00002\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\nH\u0014¢\u0006\u0004\b\u0001\u0010\fJ\u0011\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\nH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0018\u001a\u00020\u00112\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0014¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001a8T@\u0014X\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u00118D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020\u00118V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\u00118D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u001fR\u0016\u0010(\u001a\u00020\u00118D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u001fR\u001a\u0010-\u001a\u00060)j\u0002`*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\u00118D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u001f¨\u00065"}, d2 = {"Li/b/t3/r;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/AbstractChannel;", "", "element", "Lkotlinx/coroutines/internal/UndeliveredElementException;", "m0", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/UndeliveredElementException;", "D", "(Ljava/lang/Object;)Ljava/lang/Object;", "Li/b/z3/f;", "select", "(Ljava/lang/Object;Li/b/z3/f;)Ljava/lang/Object;", "f0", "()Ljava/lang/Object;", "g0", "(Li/b/z3/f;)Ljava/lang/Object;", "", "wasClosed", "Lh/t1;", "c0", "(Z)V", "Li/b/t3/x;", "receive", ExifInterface.LONGITUDE_WEST, "(Li/b/t3/x;)Z", "", NotifyType.LIGHTS, "()Ljava/lang/String;", "bufferDebugString", "Z", "()Z", "isBufferAlwaysEmpty", "isEmpty", com.huawei.hms.push.e.a, "Ljava/lang/Object;", "value", IAdInterListener.AdReqParam.WIDTH, "isBufferFull", "a0", "isBufferEmpty", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", e.j.a.b.c.f.f10128d, "Ljava/util/concurrent/locks/ReentrantLock;", "lock", am.aH, "isBufferAlwaysFull", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Lh/k2/u/l;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public class r<E> extends AbstractChannel<E> {

    /* renamed from: d  reason: collision with root package name */
    private final ReentrantLock f15842d;

    /* renamed from: e  reason: collision with root package name */
    private Object f15843e;

    public r(@k.e.a.e h.k2.u.l<? super E, t1> lVar) {
        super(lVar);
        this.f15842d = new ReentrantLock();
        this.f15843e = a.f15798d;
    }

    private final UndeliveredElementException m0(Object obj) {
        h.k2.u.l<E, t1> lVar;
        Object obj2 = this.f15843e;
        UndeliveredElementException undeliveredElementException = null;
        if (obj2 != a.f15798d && (lVar = this.b) != null) {
            undeliveredElementException = OnUndeliveredElementKt.d(lVar, obj2, null, 2, null);
        }
        this.f15843e = obj;
        return undeliveredElementException;
    }

    @Override // i.b.t3.b
    @k.e.a.d
    public Object D(E e2) {
        z<E> M;
        i0 A;
        ReentrantLock reentrantLock = this.f15842d;
        reentrantLock.lock();
        try {
            p<?> n = n();
            if (n != null) {
                return n;
            }
            if (this.f15843e == a.f15798d) {
                do {
                    M = M();
                    if (M != null) {
                        if (M instanceof p) {
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
                t1 t1Var = t1.a;
                reentrantLock.unlock();
                M.i(e2);
                return M.e();
            }
            UndeliveredElementException m0 = m0(e2);
            if (m0 == null) {
                return a.f15799e;
            }
            throw m0;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // i.b.t3.b
    @k.e.a.d
    public Object E(E e2, @k.e.a.d i.b.z3.f<?> fVar) {
        ReentrantLock reentrantLock = this.f15842d;
        reentrantLock.lock();
        try {
            p<?> n = n();
            if (n != null) {
                return n;
            }
            if (this.f15843e == a.f15798d) {
                while (true) {
                    b.d<E> j2 = j(e2);
                    Object z = fVar.z(j2);
                    if (z == null) {
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
                        return z;
                    }
                }
            }
            if (!fVar.s()) {
                return i.b.z3.g.d();
            }
            UndeliveredElementException m0 = m0(e2);
            if (m0 == null) {
                return a.f15799e;
            }
            throw m0;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public boolean W(@k.e.a.d x<? super E> xVar) {
        ReentrantLock reentrantLock = this.f15842d;
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
        return this.f15843e == a.f15798d;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public void c0(boolean z) {
        ReentrantLock reentrantLock = this.f15842d;
        reentrantLock.lock();
        try {
            UndeliveredElementException m0 = m0(a.f15798d);
            t1 t1Var = t1.a;
            reentrantLock.unlock();
            super.c0(z);
            if (m0 != null) {
                throw m0;
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    @k.e.a.e
    public Object f0() {
        ReentrantLock reentrantLock = this.f15842d;
        reentrantLock.lock();
        try {
            Object obj = this.f15843e;
            i0 i0Var = a.f15798d;
            if (obj != i0Var) {
                this.f15843e = i0Var;
                t1 t1Var = t1.a;
                return obj;
            }
            Object n = n();
            if (n == null) {
                n = a.f15801g;
            }
            return n;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    @k.e.a.e
    public Object g0(@k.e.a.d i.b.z3.f<?> fVar) {
        ReentrantLock reentrantLock = this.f15842d;
        reentrantLock.lock();
        try {
            Object obj = this.f15843e;
            i0 i0Var = a.f15798d;
            if (obj == i0Var) {
                Object n = n();
                if (n == null) {
                    n = a.f15801g;
                }
                return n;
            } else if (!fVar.s()) {
                return i.b.z3.g.d();
            } else {
                Object obj2 = this.f15843e;
                this.f15843e = i0Var;
                t1 t1Var = t1.a;
                return obj2;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel, i.b.t3.y
    public boolean isEmpty() {
        ReentrantLock reentrantLock = this.f15842d;
        reentrantLock.lock();
        try {
            return b0();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // i.b.t3.b
    @k.e.a.d
    public String l() {
        return "(value=" + this.f15843e + ')';
    }

    @Override // i.b.t3.b
    public final boolean u() {
        return false;
    }

    @Override // i.b.t3.b
    public final boolean w() {
        return false;
    }
}
