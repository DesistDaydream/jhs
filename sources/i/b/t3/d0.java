package i.b.t3;

import androidx.exifinterface.media.ExifInterface;
import h.r0;
import h.t1;
import i.b.q0;
import i.b.w3.i0;
import i.b.w3.s;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u001a\u001a\u00028\u0000\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0012¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u00020\b2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00128\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u001a\u001a\u00028\u00008\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Li/b/t3/d0;", ExifInterface.LONGITUDE_EAST, "Li/b/t3/b0;", "Li/b/w3/s$d;", "otherOp", "Li/b/w3/i0;", "m0", "(Li/b/w3/s$d;)Li/b/w3/i0;", "Lh/t1;", "j0", "()V", "Li/b/t3/p;", "closed", "l0", "(Li/b/t3/p;)V", "", "toString", "()Ljava/lang/String;", "Li/b/n;", com.huawei.hms.push.e.a, "Li/b/n;", "cont", e.j.a.b.c.f.f10128d, "Ljava/lang/Object;", "k0", "()Ljava/lang/Object;", "pollResult", "<init>", "(Ljava/lang/Object;Li/b/n;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public class d0<E> extends b0 {

    /* renamed from: d  reason: collision with root package name */
    private final E f15813d;
    @h.k2.d
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    public final i.b.n<t1> f15814e;

    /* JADX WARN: Multi-variable type inference failed */
    public d0(E e2, @k.e.a.d i.b.n<? super t1> nVar) {
        this.f15813d = e2;
        this.f15814e = nVar;
    }

    @Override // i.b.t3.b0
    public void j0() {
        this.f15814e.P(i.b.p.f15778d);
    }

    @Override // i.b.t3.b0
    public E k0() {
        return this.f15813d;
    }

    @Override // i.b.t3.b0
    public void l0(@k.e.a.d p<?> pVar) {
        i.b.n<t1> nVar = this.f15814e;
        Throwable r0 = pVar.r0();
        Result.a aVar = Result.Companion;
        nVar.resumeWith(Result.m106constructorimpl(r0.a(r0)));
    }

    @Override // i.b.t3.b0
    @k.e.a.e
    public i0 m0(@k.e.a.e s.d dVar) {
        Object m2 = this.f15814e.m(t1.a, dVar != null ? dVar.f15896c : null);
        if (m2 != null) {
            if (q0.b()) {
                if (!(m2 == i.b.p.f15778d)) {
                    throw new AssertionError();
                }
            }
            if (dVar != null) {
                dVar.d();
            }
            return i.b.p.f15778d;
        }
        return null;
    }

    @Override // i.b.w3.s
    @k.e.a.d
    public String toString() {
        return i.b.r0.a(this) + '@' + i.b.r0.b(this) + '(' + k0() + ')';
    }
}
