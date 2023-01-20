package i.b.t3;

import androidx.exifinterface.media.ExifInterface;
import i.b.q0;
import i.b.r0;
import i.b.w3.i0;
import i.b.w3.s;
import kotlin.Metadata;
import kotlinx.coroutines.channels.ClosedReceiveChannelException;
import kotlinx.coroutines.channels.ClosedSendChannelException;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0010\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0011\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b%\u0010&J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00028\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0012\u001a\u00020\t2\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0013\u0010\u001d\u001a\u00020\u00178F@\u0006¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u001f\u001a\u00020\u00178F@\u0006¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u00008V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u00008V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010!¨\u0006'"}, d2 = {"Li/b/t3/p;", ExifInterface.LONGITUDE_EAST, "Li/b/t3/b0;", "Li/b/t3/z;", "Li/b/w3/s$d;", "otherOp", "Li/b/w3/i0;", "m0", "(Li/b/w3/s$d;)Li/b/w3/i0;", "Lh/t1;", "j0", "()V", "value", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/Object;Li/b/w3/s$d;)Li/b/w3/i0;", "i", "(Ljava/lang/Object;)V", "closed", "l0", "(Li/b/t3/p;)V", "", "toString", "()Ljava/lang/String;", "", e.j.a.b.c.f.f10128d, "Ljava/lang/Throwable;", "closeCause", "r0", "()Ljava/lang/Throwable;", "sendException", "q0", "receiveException", "o0", "()Li/b/t3/p;", "offerResult", "p0", "pollResult", "<init>", "(Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class p<E> extends b0 implements z<E> {
    @h.k2.d
    @k.e.a.e

    /* renamed from: d  reason: collision with root package name */
    public final Throwable f15835d;

    public p(@k.e.a.e Throwable th) {
        this.f15835d = th;
    }

    @Override // i.b.t3.z
    @k.e.a.e
    public i0 A(E e2, @k.e.a.e s.d dVar) {
        i0 i0Var = i.b.p.f15778d;
        if (dVar != null) {
            dVar.d();
        }
        return i0Var;
    }

    @Override // i.b.t3.z
    public void i(E e2) {
    }

    @Override // i.b.t3.b0
    public void j0() {
    }

    @Override // i.b.t3.b0
    public void l0(@k.e.a.d p<?> pVar) {
        if (q0.b()) {
            throw new AssertionError();
        }
    }

    @Override // i.b.t3.b0
    @k.e.a.e
    public i0 m0(@k.e.a.e s.d dVar) {
        i0 i0Var = i.b.p.f15778d;
        if (dVar != null) {
            dVar.d();
        }
        return i0Var;
    }

    @Override // i.b.t3.z
    @k.e.a.d
    /* renamed from: o0 */
    public p<E> e() {
        return this;
    }

    @Override // i.b.t3.b0
    @k.e.a.d
    /* renamed from: p0 */
    public p<E> k0() {
        return this;
    }

    @k.e.a.d
    public final Throwable q0() {
        Throwable th = this.f15835d;
        return th != null ? th : new ClosedReceiveChannelException(o.a);
    }

    @k.e.a.d
    public final Throwable r0() {
        Throwable th = this.f15835d;
        return th != null ? th : new ClosedSendChannelException(o.a);
    }

    @Override // i.b.w3.s
    @k.e.a.d
    public String toString() {
        return "Closed@" + r0.b(this) + '[' + this.f15835d + ']';
    }
}
