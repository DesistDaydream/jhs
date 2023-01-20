package i.b;

import androidx.exifinterface.media.ExifInterface;
import com.qiniu.android.collect.ReportItem;
import com.tencent.android.tpush.common.MessageKey;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.JobSupport;

@x1
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u00042\u00020\u0005B\u0019\u0012\u0006\u00109\u001a\u000201\u0012\b\b\u0002\u0010<\u001a\u00020\u0010¢\u0006\u0004\b=\u0010>J\u000f\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0019\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0004¢\u0006\u0004\b\u0019\u0010\rJ\u001e\u0010\u001c\u001a\u00020\u00062\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\rJ\u0019\u0010\u001d\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0014¢\u0006\u0004\b\u001d\u0010\rJ\u0017\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0014H\u0010¢\u0006\u0004\b!\u0010\u0016J6\u0010&\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"2\u001c\u0010%\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00170$ø\u0001\u0000¢\u0006\u0004\b&\u0010'JO\u0010,\u001a\u00020\u0006\"\u0004\b\u0001\u0010(2\u0006\u0010#\u001a\u00020\"2\u0006\u0010)\u001a\u00028\u00012'\u0010%\u001a#\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00170*¢\u0006\u0002\b+ø\u0001\u0000¢\u0006\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u00108V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u001f\u00107\u001a\u0002018\u0006@\u0006¢\u0006\u0012\n\u0004\b2\u00103\u0012\u0004\b6\u0010\b\u001a\u0004\b4\u00105R\u0016\u00109\u001a\u0002018\u0004@\u0005X\u0085\u0004¢\u0006\u0006\n\u0004\b8\u00103R\u0016\u0010;\u001a\u0002018V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u00105\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006?"}, d2 = {"Li/b/a;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/JobSupport;", "Li/b/b2;", "Lh/e2/c;", "Li/b/n0;", "Lh/t1;", "n1", "()V", "q1", "U0", "value", "p1", "(Ljava/lang/Object;)V", "", "cause", "", "handled", "o1", "(Ljava/lang/Throwable;Z)V", "", "e0", "()Ljava/lang/String;", "", "state", "T0", "Lkotlin/Result;", "result", "resumeWith", "l1", "exception", "B0", "(Ljava/lang/Throwable;)V", "N0", "Lkotlinx/coroutines/CoroutineStart;", MessageKey.MSG_ACCEPT_TIME_START, "Lkotlin/Function1;", ReportItem.LogTypeBlock, "s1", "(Lkotlinx/coroutines/CoroutineStart;Lh/k2/u/l;)V", "R", "receiver", "Lkotlin/Function2;", "Lh/q;", "r1", "(Lkotlinx/coroutines/CoroutineStart;Ljava/lang/Object;Lh/k2/u/p;)V", "j", "()Z", "isActive", "Lkotlin/coroutines/CoroutineContext;", "b", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "getContext$annotations", "context", "c", "parentContext", "getCoroutineContext", "coroutineContext", "active", "<init>", "(Lkotlin/coroutines/CoroutineContext;Z)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public abstract class a<T> extends JobSupport implements b2, h.e2.c<T>, n0 {
    @k.e.a.d
    private final CoroutineContext b;
    @h.k2.d
    @k.e.a.d

    /* renamed from: c */
    public final CoroutineContext f15713c;

    public /* synthetic */ a(CoroutineContext coroutineContext, boolean z, int i2, h.k2.v.u uVar) {
        this(coroutineContext, (i2 & 2) != 0 ? true : z);
    }

    public static /* synthetic */ void m1() {
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void B0(@k.e.a.d Throwable th) {
        k0.b(this.b, th);
    }

    @Override // kotlinx.coroutines.JobSupport
    @k.e.a.d
    public String N0() {
        String b = i0.b(this.b);
        if (b != null) {
            return h.t2.y.a + b + "\":" + super.N0();
        }
        return super.N0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.JobSupport
    public final void T0(@k.e.a.e Object obj) {
        if (obj instanceof b0) {
            b0 b0Var = (b0) obj;
            o1(b0Var.a, b0Var.a());
            return;
        }
        p1(obj);
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void U0() {
        q1();
    }

    @Override // kotlinx.coroutines.JobSupport
    @k.e.a.d
    public String e0() {
        return r0.a(this) + " was cancelled";
    }

    @Override // h.e2.c
    @k.e.a.d
    public final CoroutineContext getContext() {
        return this.b;
    }

    @Override // i.b.n0
    @k.e.a.d
    public CoroutineContext getCoroutineContext() {
        return this.b;
    }

    @Override // kotlinx.coroutines.JobSupport, i.b.b2
    public boolean j() {
        return super.j();
    }

    public void l1(@k.e.a.e Object obj) {
        U(obj);
    }

    public final void n1() {
        C0((b2) this.f15713c.get(b2.y0));
    }

    public void o1(@k.e.a.d Throwable th, boolean z) {
    }

    public void p1(T t) {
    }

    public void q1() {
    }

    public final <R> void r1(@k.e.a.d CoroutineStart coroutineStart, R r, @k.e.a.d h.k2.u.p<? super R, ? super h.e2.c<? super T>, ? extends Object> pVar) {
        n1();
        coroutineStart.invoke(pVar, r, this);
    }

    @Override // h.e2.c
    public final void resumeWith(@k.e.a.d Object obj) {
        Object L0 = L0(g0.d(obj, null, 1, null));
        if (L0 == i2.b) {
            return;
        }
        l1(L0);
    }

    public final void s1(@k.e.a.d CoroutineStart coroutineStart, @k.e.a.d h.k2.u.l<? super h.e2.c<? super T>, ? extends Object> lVar) {
        n1();
        coroutineStart.invoke(lVar, this);
    }

    public a(@k.e.a.d CoroutineContext coroutineContext, boolean z) {
        super(z);
        this.f15713c = coroutineContext;
        this.b = coroutineContext.plus(this);
    }
}
