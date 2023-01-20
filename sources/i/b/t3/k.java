package i.b.t3;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.am;
import h.t1;
import i.b.k0;
import i.b.r1;
import i.b.t3.c0;
import java.util.concurrent.CancellationException;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u0005B%\u0012\u0006\u0010;\u001a\u00020:\u0012\f\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010<\u001a\u00020\b¢\u0006\u0004\b=\u0010>J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\u00020\u00032\u000e\u0010\u0007\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\nJ5\u0010\u001c\u001a\u00020\u00032#\u0010\u001b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00030\u0018H\u0097\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0004\b\u001f\u0010 J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000!H\u0096\u0001¢\u0006\u0004\b\"\u0010#J\u001b\u0010$\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00028\u0000H\u0096Aø\u0001\u0000¢\u0006\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\b8\u0016@\u0017X\u0097\u0005¢\u0006\u0006\u001a\u0004\b&\u0010'R\"\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\b8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010'R\u001c\u00103\u001a\b\u0012\u0004\u0012\u00028\u0000008V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0016\u00105\u001a\u00020\b8\u0016@\u0017X\u0097\u0005¢\u0006\u0006\u001a\u0004\b4\u0010'R(\u00109\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000000068\u0016@\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b7\u00108\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006?"}, d2 = {"Li/b/t3/k;", ExifInterface.LONGITUDE_EAST, "Li/b/a;", "Lh/t1;", "Li/b/t3/w;", "Li/b/t3/i;", "", "cause", "", am.av, "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "b", "(Ljava/util/concurrent/CancellationException;)V", "b0", "(Ljava/lang/Throwable;)V", "value", "u1", "(Lh/t1;)V", "handled", "o1", "(Ljava/lang/Throwable;Z)V", "K", "Lkotlin/Function1;", "Lh/k0;", "name", "handler", "x", "(Lh/k2/u/l;)V", "element", "offer", "(Ljava/lang/Object;)Z", "Li/b/t3/y;", "v", "()Li/b/t3/y;", "N", "(Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "c", "()Z", "isFull", e.j.a.b.c.f.f10128d, "Li/b/t3/i;", "t1", "()Li/b/t3/i;", "_channel", "j", "isActive", "Li/b/t3/c0;", "getChannel", "()Li/b/t3/c0;", "channel", "O", "isClosedForSend", "Li/b/z3/e;", "h", "()Li/b/z3/e;", "onSend", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "active", "<init>", "(Lkotlin/coroutines/CoroutineContext;Li/b/t3/i;Z)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public class k<E> extends i.b.a<t1> implements w<E>, i<E> {
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final i<E> f15827d;

    public k(@k.e.a.d CoroutineContext coroutineContext, @k.e.a.d i<E> iVar, boolean z) {
        super(coroutineContext, z);
        this.f15827d = iVar;
    }

    public static /* synthetic */ Object v1(k kVar, Object obj, h.e2.c cVar) {
        return kVar.f15827d.N(obj, cVar);
    }

    @Override // i.b.t3.c0
    public boolean K(@k.e.a.e Throwable th) {
        boolean K = this.f15827d.K(th);
        start();
        return K;
    }

    @Override // i.b.t3.c0
    @k.e.a.e
    public Object N(E e2, @k.e.a.d h.e2.c<? super t1> cVar) {
        return v1(this, e2, cVar);
    }

    @Override // i.b.t3.c0
    public boolean O() {
        return this.f15827d.O();
    }

    @Override // kotlinx.coroutines.JobSupport, i.b.b2
    @h.i(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public final /* synthetic */ boolean a(@k.e.a.e Throwable th) {
        if (th == null) {
            th = new JobCancellationException(e0(), null, this);
        }
        b0(th);
        return true;
    }

    @Override // kotlinx.coroutines.JobSupport, i.b.b2
    public final void b(@k.e.a.e CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(e0(), null, this);
        }
        b0(cancellationException);
    }

    @Override // kotlinx.coroutines.JobSupport
    public void b0(@k.e.a.d Throwable th) {
        CancellationException e1 = JobSupport.e1(this, th, null, 1, null);
        this.f15827d.b(e1);
        Z(e1);
    }

    @Override // i.b.t3.c0
    public boolean c() {
        return this.f15827d.c();
    }

    @Override // i.b.t3.w
    @k.e.a.d
    public c0<E> getChannel() {
        return this;
    }

    @Override // i.b.t3.c0
    @k.e.a.d
    public i.b.z3.e<E, c0<E>> h() {
        return this.f15827d.h();
    }

    @Override // i.b.a, kotlinx.coroutines.JobSupport, i.b.b2
    public boolean j() {
        return super.j();
    }

    @Override // i.b.a
    public void o1(@k.e.a.d Throwable th, boolean z) {
        if (this.f15827d.K(th) || z) {
            return;
        }
        k0.b(getContext(), th);
    }

    @Override // i.b.t3.c0
    public boolean offer(E e2) {
        return this.f15827d.offer(e2);
    }

    @k.e.a.d
    public final i<E> t1() {
        return this.f15827d;
    }

    @Override // i.b.a
    /* renamed from: u1 */
    public void p1(@k.e.a.d t1 t1Var) {
        c0.a.a(this.f15827d, null, 1, null);
    }

    @Override // i.b.t3.i
    @k.e.a.d
    public y<E> v() {
        return this.f15827d.v();
    }

    @Override // i.b.t3.c0
    @r1
    public void x(@k.e.a.d h.k2.u.l<? super Throwable, t1> lVar) {
        this.f15827d.x(lVar);
    }
}
