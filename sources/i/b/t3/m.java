package i.b.t3;

import androidx.exifinterface.media.ExifInterface;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.umeng.analytics.pro.am;
import h.q0;
import h.t1;
import i.b.q2;
import i.b.r1;
import i.b.x1;
import java.util.concurrent.CancellationException;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.channels.ChannelIterator;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u0004B%\u0012\u0006\u0010E\u001a\u00020D\u0012\f\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010F\u001a\u00020\t¢\u0006\u0004\bG\u0010HJ\u000f\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\u00020\u00032\u000e\u0010\b\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0012\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001¢\u0006\u0004\b\u0012\u0010\u000bJ5\u0010\u0017\u001a\u00020\u00032#\u0010\u0016\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0097\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0096\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u001f\u001a\u0004\u0018\u00018\u0000H\u0096\u0001¢\u0006\u0004\b\u001f\u0010 J\u0013\u0010!\u001a\u00028\u0000H\u0096Aø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u001f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0097Aø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010\"J\u0015\u0010%\u001a\u0004\u0018\u00018\u0000H\u0097Aø\u0001\u0000¢\u0006\u0004\b%\u0010\"J\u001b\u0010&\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00028\u0000H\u0096Aø\u0001\u0000¢\u0006\u0004\b&\u0010'R\u0019\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048F@\u0006¢\u0006\u0006\u001a\u0004\b(\u0010)R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000+8\u0016@\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b,\u0010-R(\u00103\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u0000000/8\u0016@\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b1\u00102R%\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000#0+8\u0016@\u0017X\u0097\u0005ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b4\u0010-R\u0016\u00108\u001a\u00020\t8\u0016@\u0017X\u0097\u0005¢\u0006\u0006\u001a\u0004\b6\u00107R\u0016\u00109\u001a\u00020\t8\u0016@\u0017X\u0097\u0005¢\u0006\u0006\u001a\u0004\b9\u00107R\u0016\u0010;\u001a\u00020\t8\u0016@\u0017X\u0097\u0005¢\u0006\u0006\u001a\u0004\b:\u00107R\"\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010)R\u001e\u0010A\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000+8\u0016@\u0017X\u0097\u0005¢\u0006\u0006\u001a\u0004\b@\u0010-R\u0016\u0010C\u001a\u00020\t8\u0016@\u0017X\u0097\u0005¢\u0006\u0006\u001a\u0004\bB\u00107\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006I"}, d2 = {"Li/b/t3/m;", ExifInterface.LONGITUDE_EAST, "Li/b/a;", "Lh/t1;", "Li/b/t3/l;", "cancel", "()V", "", "cause", "", am.av, "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "b", "(Ljava/util/concurrent/CancellationException;)V", "b0", "(Ljava/lang/Throwable;)V", "K", "Lkotlin/Function1;", "Lh/k0;", "name", "handler", "x", "(Lh/k2/u/l;)V", "Lkotlinx/coroutines/channels/ChannelIterator;", "iterator", "()Lkotlinx/coroutines/channels/ChannelIterator;", "element", "offer", "(Ljava/lang/Object;)Z", "poll", "()Ljava/lang/Object;", ExpandableTextView.P, "(Lh/e2/c;)Ljava/lang/Object;", "Li/b/t3/g0;", "y", "C", "N", "(Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "getChannel", "()Li/b/t3/l;", "channel", "Li/b/z3/d;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Li/b/z3/d;", "onReceive", "Li/b/z3/e;", "Li/b/t3/c0;", "h", "()Li/b/z3/e;", "onSend", "L", "onReceiveOrClosed", "f", "()Z", "isClosedForReceive", "isEmpty", "O", "isClosedForSend", e.j.a.b.c.f.f10128d, "Li/b/t3/l;", "t1", "_channel", "B", "onReceiveOrNull", "c", "isFull", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "active", "<init>", "(Lkotlin/coroutines/CoroutineContext;Li/b/t3/l;Z)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public class m<E> extends i.b.a<t1> implements l<E> {
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final l<E> f15834d;

    public m(@k.e.a.d CoroutineContext coroutineContext, @k.e.a.d l<E> lVar, boolean z) {
        super(coroutineContext, z);
        this.f15834d = lVar;
    }

    public static /* synthetic */ Object u1(m mVar, h.e2.c cVar) {
        return mVar.f15834d.I(cVar);
    }

    public static /* synthetic */ Object v1(m mVar, h.e2.c cVar) {
        return mVar.f15834d.y(cVar);
    }

    public static /* synthetic */ Object w1(m mVar, h.e2.c cVar) {
        return mVar.f15834d.C(cVar);
    }

    public static /* synthetic */ Object x1(m mVar, Object obj, h.e2.c cVar) {
        return mVar.f15834d.N(obj, cVar);
    }

    @Override // i.b.t3.y
    @k.e.a.d
    public i.b.z3.d<E> A() {
        return this.f15834d.A();
    }

    @Override // i.b.t3.y
    @k.e.a.d
    public i.b.z3.d<E> B() {
        return this.f15834d.B();
    }

    @Override // i.b.t3.y
    @h.i(level = DeprecationLevel.WARNING, message = "Deprecated in favor of receiveOrClosed and receiveOrNull extension", replaceWith = @q0(expression = "receiveOrNull", imports = {"kotlinx.coroutines.channels.receiveOrNull"}))
    @q2
    @h.g2.g
    @k.e.a.e
    public Object C(@k.e.a.d h.e2.c<? super E> cVar) {
        return w1(this, cVar);
    }

    @Override // i.b.t3.y
    @k.e.a.e
    public Object I(@k.e.a.d h.e2.c<? super E> cVar) {
        return u1(this, cVar);
    }

    @Override // i.b.t3.c0
    public boolean K(@k.e.a.e Throwable th) {
        return this.f15834d.K(th);
    }

    @Override // i.b.t3.y
    @k.e.a.d
    public i.b.z3.d<g0<E>> L() {
        return this.f15834d.L();
    }

    @Override // i.b.t3.c0
    @k.e.a.e
    public Object N(E e2, @k.e.a.d h.e2.c<? super t1> cVar) {
        return x1(this, e2, cVar);
    }

    @Override // i.b.t3.c0
    public boolean O() {
        return this.f15834d.O();
    }

    @Override // kotlinx.coroutines.JobSupport, i.b.b2
    @h.i(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public final /* synthetic */ boolean a(@k.e.a.e Throwable th) {
        b0(new JobCancellationException(e0(), null, this));
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
        this.f15834d.b(e1);
        Z(e1);
    }

    @Override // i.b.t3.c0
    public boolean c() {
        return this.f15834d.c();
    }

    @Override // kotlinx.coroutines.JobSupport, i.b.b2
    public /* synthetic */ void cancel() {
        b0(new JobCancellationException(e0(), null, this));
    }

    @Override // i.b.t3.y
    public boolean f() {
        return this.f15834d.f();
    }

    @k.e.a.d
    public final l<E> getChannel() {
        return this;
    }

    @Override // i.b.t3.c0
    @k.e.a.d
    public i.b.z3.e<E, c0<E>> h() {
        return this.f15834d.h();
    }

    @Override // i.b.t3.y
    public boolean isEmpty() {
        return this.f15834d.isEmpty();
    }

    @Override // i.b.t3.y
    @k.e.a.d
    public ChannelIterator<E> iterator() {
        return this.f15834d.iterator();
    }

    @Override // i.b.t3.c0
    public boolean offer(E e2) {
        return this.f15834d.offer(e2);
    }

    @Override // i.b.t3.y
    @k.e.a.e
    public E poll() {
        return this.f15834d.poll();
    }

    @k.e.a.d
    public final l<E> t1() {
        return this.f15834d;
    }

    @Override // i.b.t3.c0
    @r1
    public void x(@k.e.a.d h.k2.u.l<? super Throwable, t1> lVar) {
        this.f15834d.x(lVar);
    }

    @Override // i.b.t3.y
    @x1
    @k.e.a.e
    public Object y(@k.e.a.d h.e2.c<? super g0<? extends E>> cVar) {
        return v1(this, cVar);
    }
}
