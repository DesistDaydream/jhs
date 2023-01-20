package i.b.z3;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.am;
import h.k2.u.l;
import h.k2.u.p;
import h.k2.v.f0;
import h.p0;
import h.r0;
import h.t1;
import i.b.b2;
import i.b.c2;
import i.b.e1;
import i.b.g0;
import i.b.k0;
import i.b.q0;
import i.b.w0;
import i.b.w3.b0;
import i.b.w3.h0;
import i.b.w3.q;
import i.b.w3.s;
import i.b.z3.a;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

@p0
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\u00060\u0006j\u0002`\u0007:\u0004ZI[6B\u0015\u0012\f\u0010L\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\bX\u0010YJ.\u0010\r\u001a\u00020\u000b2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\bH\u0082\b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0014\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J \u0010\u0018\u001a\u00020\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0011\u0010\u001e\u001a\u0004\u0018\u00010\tH\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u001aH\u0001¢\u0006\u0004\b!\u0010\u001dJ\u0017\u0010$\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u001b\u0010+\u001a\u0004\u0018\u00010\t2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\b+\u0010,J\u0019\u0010/\u001a\u0004\u0018\u00010\t2\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b/\u00100J\u000f\u00102\u001a\u000201H\u0016¢\u0006\u0004\b2\u00103J5\u00106\u001a\u00020\u000b*\u0002042\u001c\u0010\f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\t05H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b6\u00107JG\u0010;\u001a\u00020\u000b\"\u0004\b\u0001\u00108*\b\u0012\u0004\u0012\u00028\u0001092\"\u0010\f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\t0:H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b;\u0010<J[\u0010@\u001a\u00020\u000b\"\u0004\b\u0001\u0010=\"\u0004\b\u0002\u00108*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020>2\u0006\u0010?\u001a\u00028\u00012\"\u0010\f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\t0:H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b@\u0010AJ8\u0010D\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020B2\u001c\u0010\f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\t05H\u0016ø\u0001\u0000¢\u0006\u0004\bD\u0010ER\u001c\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0016\u0010J\u001a\u00020&8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bI\u0010(R\u001c\u0010L\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u0010KR(\u0010P\u001a\u0004\u0018\u00010\"2\b\u0010\n\u001a\u0004\u0018\u00010\"8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\bM\u0010N\"\u0004\bO\u0010%R\u001e\u0010S\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00078V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u0016\u0010W\u001a\u00020T8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bU\u0010V\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\\"}, d2 = {"Li/b/z3/b;", "R", "Li/b/w3/q;", "Li/b/z3/a;", "Li/b/z3/f;", "Lh/e2/c;", "Lh/e2/k/a/c;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlin/Function0;", "", "value", "Lh/t1;", ReportItem.LogTypeBlock, "o0", "(Lh/k2/u/a;Lh/k2/u/a;)V", "G", "()V", "n0", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "Lkotlin/Result;", "result", "resumeWith", "(Ljava/lang/Object;)V", "", "exception", "y", "(Ljava/lang/Throwable;)V", "q0", "()Ljava/lang/Object;", com.huawei.hms.push.e.a, "r0", "Li/b/e1;", "handle", "k", "(Li/b/e1;)V", "", "s", "()Z", "Li/b/w3/s$d;", "otherOp", "n", "(Li/b/w3/s$d;)Ljava/lang/Object;", "Li/b/w3/b;", "desc", am.aD, "(Li/b/w3/b;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "Li/b/z3/c;", "Lkotlin/Function1;", e.j.a.b.c.f.f10128d, "(Li/b/z3/c;Lh/k2/u/l;)V", "Q", "Li/b/z3/d;", "Lkotlin/Function2;", "B", "(Li/b/z3/d;Lh/k2/u/p;)V", "P", "Li/b/z3/e;", RemoteMessageConst.MessageBody.PARAM, "f", "(Li/b/z3/e;Ljava/lang/Object;Lh/k2/u/p;)V", "", "timeMillis", "h", "(JLh/k2/u/l;)V", "v", "()Lh/e2/c;", "completion", "b", "isSelected", "Lh/e2/c;", "uCont", "p0", "()Li/b/e1;", "s0", "parentHandle", "getCallerFrame", "()Lh/e2/k/a/c;", "callerFrame", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "<init>", "(Lh/e2/c;)V", am.av, "c", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class b<R> extends q implements i.b.z3.a<R>, f<R>, h.e2.c<R>, h.e2.k.a.c {

    /* renamed from: e */
    public static final AtomicReferenceFieldUpdater f15949e = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_state");

    /* renamed from: f */
    public static final AtomicReferenceFieldUpdater f15950f = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_result");

    /* renamed from: d */
    private final h.e2.c<R> f15951d;
    public volatile Object _state = g.f();
    public volatile Object _result = g.c();
    private volatile Object _parentHandle = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u001b\u0012\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u001c\u0012\u0006\u0010\u001b\u001a\u00020\u0019¢\u0006\u0004\b \u0010!J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ#\u0010\u000e\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0018\u001a\u00020\u00138\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00198\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001aR\u001a\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u001c8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"i/b/z3/b$a", "Li/b/w3/d;", "", "k", "()Ljava/lang/Object;", "Lh/t1;", NotifyType.LIGHTS, "()V", "failure", "j", "(Ljava/lang/Object;)V", "affected", "i", "(Ljava/lang/Object;)Ljava/lang/Object;", e.j.a.b.c.f.f10128d, "(Ljava/lang/Object;Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "", "b", "J", "g", "()J", "opSequence", "Li/b/w3/b;", "Li/b/w3/b;", "desc", "Li/b/z3/b;", "c", "Li/b/z3/b;", "impl", "<init>", "(Li/b/z3/b;Li/b/w3/b;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a extends i.b.w3.d<Object> {
        private final long b = g.b().a();
        @h.k2.d
        @k.e.a.d

        /* renamed from: c */
        public final b<?> f15952c;
        @h.k2.d
        @k.e.a.d

        /* renamed from: d */
        public final i.b.w3.b f15953d;

        public a(@k.e.a.d b<?> bVar, @k.e.a.d i.b.w3.b bVar2) {
            i iVar;
            this.f15952c = bVar;
            this.f15953d = bVar2;
            iVar = g.f15958e;
            this.b = iVar.a();
            bVar2.d(this);
        }

        private final void j(Object obj) {
            boolean z = obj == null;
            if (b.f15949e.compareAndSet(this.f15952c, this, z ? null : g.f()) && z) {
                this.f15952c.n0();
            }
        }

        private final Object k() {
            b<?> bVar = this.f15952c;
            while (true) {
                Object obj = bVar._state;
                if (obj == this) {
                    return null;
                }
                if (obj instanceof b0) {
                    ((b0) obj).c(this.f15952c);
                } else if (obj == g.f()) {
                    if (b.f15949e.compareAndSet(this.f15952c, g.f(), this)) {
                        return null;
                    }
                } else {
                    return g.d();
                }
            }
        }

        private final void l() {
            b.f15949e.compareAndSet(this.f15952c, this, g.f());
        }

        @Override // i.b.w3.d
        public void d(@k.e.a.e Object obj, @k.e.a.e Object obj2) {
            j(obj2);
            this.f15953d.a(this, obj2);
        }

        @Override // i.b.w3.d
        public long g() {
            return this.b;
        }

        @Override // i.b.w3.d
        @k.e.a.e
        public Object i(@k.e.a.e Object obj) {
            Object k2;
            if (obj != null || (k2 = k()) == null) {
                try {
                    return this.f15953d.c(this);
                } catch (Throwable th) {
                    if (obj == null) {
                        l();
                    }
                    throw th;
                }
            }
            return k2;
        }

        @Override // i.b.w3.b0
        @k.e.a.d
        public String toString() {
            return "AtomicSelectOp(sequence=" + g() + ')';
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"i/b/z3/b$b", "Li/b/w3/s;", "Li/b/e1;", e.j.a.b.c.f.f10128d, "Li/b/e1;", "handle", "<init>", "(Li/b/e1;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* renamed from: i.b.z3.b$b */
    /* loaded from: classes4.dex */
    public static final class C0485b extends s {
        @h.k2.d
        @k.e.a.d

        /* renamed from: d */
        public final e1 f15954d;

        public C0485b(@k.e.a.d e1 e1Var) {
            this.f15954d = e1Var;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001c\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u000b¨\u0006\u000f"}, d2 = {"i/b/z3/b$c", "Li/b/w3/b0;", "", "affected", "c", "(Ljava/lang/Object;)Ljava/lang/Object;", "Li/b/w3/s$d;", am.av, "Li/b/w3/s$d;", "otherOp", "Li/b/w3/d;", "()Li/b/w3/d;", "atomicOp", "<init>", "(Li/b/w3/s$d;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class c extends b0 {
        @h.k2.d
        @k.e.a.d
        public final s.d a;

        public c(@k.e.a.d s.d dVar) {
            this.a = dVar;
        }

        @Override // i.b.w3.b0
        @k.e.a.e
        public i.b.w3.d<?> a() {
            return this.a.a();
        }

        @Override // i.b.w3.b0
        @k.e.a.e
        public Object c(@k.e.a.e Object obj) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectBuilderImpl<*>");
            b bVar = (b) obj;
            this.a.d();
            Object e2 = this.a.a().e(null);
            b.f15949e.compareAndSet(bVar, this, e2 == null ? this.a.f15896c : g.f());
            return e2;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"i/b/z3/b$d", "Li/b/c2;", "Li/b/b2;", "", "cause", "Lh/t1;", "j0", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "job", "<init>", "(Li/b/z3/b;Li/b/b2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public final class d extends c2<b2> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@k.e.a.d b2 b2Var) {
            super(b2Var);
            b.this = r1;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(Throwable th) {
            j0(th);
            return t1.a;
        }

        @Override // i.b.d0
        public void j0(@k.e.a.e Throwable th) {
            if (b.this.s()) {
                b.this.y(this.f15739d.q());
            }
        }

        @Override // i.b.w3.s
        @k.e.a.d
        public String toString() {
            return "SelectOnCancelling[" + b.this + ']';
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Lh/t1;", "run", "()V", "i/b/x2$a", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class e implements Runnable {
        public final /* synthetic */ l b;

        public e(l lVar) {
            b.this = r1;
            this.b = lVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (b.this.s()) {
                i.b.x3.a.c(this.b, b.this.v());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(@k.e.a.d h.e2.c<? super R> cVar) {
        Object obj;
        this.f15951d = cVar;
        obj = g.f15956c;
        this._result = obj;
        this._parentHandle = null;
    }

    private final void G() {
        b2 b2Var = (b2) getContext().get(b2.y0);
        if (b2Var != null) {
            e1 f2 = b2.a.f(b2Var, true, false, new d(b2Var), 2, null);
            s0(f2);
            if (b()) {
                f2.dispose();
            }
        }
    }

    public final void n0() {
        e1 p0 = p0();
        if (p0 != null) {
            p0.dispose();
        }
        Object U = U();
        Objects.requireNonNull(U, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        for (s sVar = (s) U; !f0.g(sVar, this); sVar = sVar.V()) {
            if (sVar instanceof C0485b) {
                ((C0485b) sVar).f15954d.dispose();
            }
        }
    }

    private final void o0(h.k2.u.a<? extends Object> aVar, h.k2.u.a<t1> aVar2) {
        Object obj;
        Object obj2;
        Object obj3;
        if (q0.b() && !b()) {
            throw new AssertionError();
        }
        while (true) {
            Object obj4 = this._result;
            obj = g.f15956c;
            if (obj4 == obj) {
                Object invoke = aVar.invoke();
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15950f;
                obj2 = g.f15956c;
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, invoke)) {
                    return;
                }
            } else if (obj4 == h.e2.j.b.h()) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f15950f;
                Object h2 = h.e2.j.b.h();
                obj3 = g.f15957d;
                if (atomicReferenceFieldUpdater2.compareAndSet(this, h2, obj3)) {
                    aVar2.invoke();
                    return;
                }
            } else {
                throw new IllegalStateException("Already resumed");
            }
        }
    }

    private final e1 p0() {
        return (e1) this._parentHandle;
    }

    private final void s0(e1 e1Var) {
        this._parentHandle = e1Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i.b.z3.a
    public <Q> void B(@k.e.a.d i.b.z3.d<? extends Q> dVar, @k.e.a.d p<? super Q, ? super h.e2.c<? super R>, ? extends Object> pVar) {
        dVar.e(this, pVar);
    }

    @Override // i.b.z3.f
    public boolean b() {
        while (true) {
            Object obj = this._state;
            if (obj == g.f()) {
                return false;
            }
            if (!(obj instanceof b0)) {
                return true;
            }
            ((b0) obj).c(this);
        }
    }

    @Override // i.b.z3.a
    public void d(@k.e.a.d i.b.z3.c cVar, @k.e.a.d l<? super h.e2.c<? super R>, ? extends Object> lVar) {
        cVar.g(this, lVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i.b.z3.a
    public <P, Q> void f(@k.e.a.d i.b.z3.e<? super P, ? extends Q> eVar, P p, @k.e.a.d p<? super Q, ? super h.e2.c<? super R>, ? extends Object> pVar) {
        eVar.z(this, p, pVar);
    }

    @Override // h.e2.k.a.c
    @k.e.a.e
    public h.e2.k.a.c getCallerFrame() {
        h.e2.c<R> cVar = this.f15951d;
        if (!(cVar instanceof h.e2.k.a.c)) {
            cVar = null;
        }
        return (h.e2.k.a.c) cVar;
    }

    @Override // h.e2.c
    @k.e.a.d
    public CoroutineContext getContext() {
        return this.f15951d.getContext();
    }

    @Override // h.e2.k.a.c
    @k.e.a.e
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // i.b.z3.a
    public void h(long j2, @k.e.a.d l<? super h.e2.c<? super R>, ? extends Object> lVar) {
        if (j2 <= 0) {
            if (s()) {
                i.b.x3.b.c(lVar, v());
                return;
            }
            return;
        }
        k(w0.d(getContext()).t(j2, new e(lVar), getContext()));
    }

    @Override // i.b.z3.f
    public void k(@k.e.a.d e1 e1Var) {
        C0485b c0485b = new C0485b(e1Var);
        if (!b()) {
            I(c0485b);
            if (!b()) {
                return;
            }
        }
        e1Var.dispose();
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x0031, code lost:
        n0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0036, code lost:
        return i.b.p.f15778d;
     */
    @Override // i.b.z3.f
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object n(@k.e.a.e i.b.w3.s.d r4) {
        /*
            r3 = this;
        L0:
            java.lang.Object r0 = r3._state
            java.lang.Object r1 = i.b.z3.g.f()
            r2 = 0
            if (r0 != r1) goto L37
            if (r4 != 0) goto L18
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = i.b.z3.b.f15949e
            java.lang.Object r1 = i.b.z3.g.f()
            boolean r0 = r0.compareAndSet(r3, r1, r2)
            if (r0 != 0) goto L31
            goto L0
        L18:
            i.b.z3.b$c r0 = new i.b.z3.b$c
            r0.<init>(r4)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = i.b.z3.b.f15949e
            java.lang.Object r2 = i.b.z3.g.f()
            boolean r1 = r1.compareAndSet(r3, r2, r0)
            if (r1 != 0) goto L2a
            goto L0
        L2a:
            java.lang.Object r4 = r0.c(r3)
            if (r4 == 0) goto L31
            return r4
        L31:
            r3.n0()
            i.b.w3.i0 r4 = i.b.p.f15778d
            return r4
        L37:
            boolean r1 = r0 instanceof i.b.w3.b0
            if (r1 == 0) goto L6b
            if (r4 == 0) goto L65
            i.b.w3.d r1 = r4.a()
            boolean r2 = r1 instanceof i.b.z3.b.a
            if (r2 == 0) goto L59
            r2 = r1
            i.b.z3.b$a r2 = (i.b.z3.b.a) r2
            i.b.z3.b<?> r2 = r2.f15952c
            if (r2 == r3) goto L4d
            goto L59
        L4d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "Cannot use matching select clauses on the same object"
            java.lang.String r0 = r0.toString()
            r4.<init>(r0)
            throw r4
        L59:
            r2 = r0
            i.b.w3.b0 r2 = (i.b.w3.b0) r2
            boolean r1 = r1.b(r2)
            if (r1 == 0) goto L65
            java.lang.Object r4 = i.b.w3.c.b
            return r4
        L65:
            i.b.w3.b0 r0 = (i.b.w3.b0) r0
            r0.c(r3)
            goto L0
        L6b:
            if (r4 != 0) goto L6e
            return r2
        L6e:
            i.b.w3.s$a r4 = r4.f15896c
            if (r0 != r4) goto L75
            i.b.w3.i0 r4 = i.b.p.f15778d
            return r4
        L75:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: i.b.z3.b.n(i.b.w3.s$d):java.lang.Object");
    }

    @Override // i.b.z3.a
    public <P, Q> void q(@k.e.a.d i.b.z3.e<? super P, ? extends Q> eVar, @k.e.a.d p<? super Q, ? super h.e2.c<? super R>, ? extends Object> pVar) {
        a.C0484a.a(this, eVar, pVar);
    }

    @p0
    @k.e.a.e
    public final Object q0() {
        Object obj;
        Object obj2;
        Object obj3;
        if (!b()) {
            G();
        }
        Object obj4 = this._result;
        obj = g.f15956c;
        if (obj4 == obj) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15950f;
            obj3 = g.f15956c;
            if (atomicReferenceFieldUpdater.compareAndSet(this, obj3, h.e2.j.b.h())) {
                return h.e2.j.b.h();
            }
            obj4 = this._result;
        }
        obj2 = g.f15957d;
        if (obj4 != obj2) {
            if (obj4 instanceof i.b.b0) {
                throw ((i.b.b0) obj4).a;
            }
            return obj4;
        }
        throw new IllegalStateException("Already resumed");
    }

    @p0
    public final void r0(@k.e.a.d Throwable th) {
        if (s()) {
            Result.a aVar = Result.Companion;
            resumeWith(Result.m106constructorimpl(r0.a(th)));
        } else if (th instanceof CancellationException) {
        } else {
            Object q0 = q0();
            if (q0 instanceof i.b.b0) {
                Throwable th2 = ((i.b.b0) q0).a;
                if (q0.e()) {
                    th2 = h0.t(th2);
                }
                if (th2 == (!q0.e() ? th : h0.t(th))) {
                    return;
                }
            }
            k0.b(getContext(), th);
        }
    }

    @Override // h.e2.c
    public void resumeWith(@k.e.a.d Object obj) {
        Object obj2;
        Object obj3;
        Object obj4;
        if (q0.b() && !b()) {
            throw new AssertionError();
        }
        while (true) {
            Object obj5 = this._result;
            obj2 = g.f15956c;
            if (obj5 == obj2) {
                Object d2 = g0.d(obj, null, 1, null);
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15950f;
                obj3 = g.f15956c;
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj3, d2)) {
                    return;
                }
            } else if (obj5 == h.e2.j.b.h()) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f15950f;
                Object h2 = h.e2.j.b.h();
                obj4 = g.f15957d;
                if (atomicReferenceFieldUpdater2.compareAndSet(this, h2, obj4)) {
                    if (Result.m112isFailureimpl(obj)) {
                        h.e2.c<R> cVar = this.f15951d;
                        Throwable m109exceptionOrNullimpl = Result.m109exceptionOrNullimpl(obj);
                        Result.a aVar = Result.Companion;
                        if (q0.e() && (cVar instanceof h.e2.k.a.c)) {
                            m109exceptionOrNullimpl = h0.o(m109exceptionOrNullimpl, (h.e2.k.a.c) cVar);
                        }
                        cVar.resumeWith(Result.m106constructorimpl(r0.a(m109exceptionOrNullimpl)));
                        return;
                    }
                    this.f15951d.resumeWith(obj);
                    return;
                }
            } else {
                throw new IllegalStateException("Already resumed");
            }
        }
    }

    @Override // i.b.z3.f
    public boolean s() {
        Object n = n(null);
        if (n == i.b.p.f15778d) {
            return true;
        }
        if (n == null) {
            return false;
        }
        throw new IllegalStateException(("Unexpected trySelectIdempotent result " + n).toString());
    }

    @Override // i.b.w3.s
    @k.e.a.d
    public String toString() {
        return "SelectInstance(state=" + this._state + ", result=" + this._result + ')';
    }

    @Override // i.b.z3.f
    @k.e.a.d
    public h.e2.c<R> v() {
        return this;
    }

    @Override // i.b.z3.f
    public void y(@k.e.a.d Throwable th) {
        Object obj;
        Object obj2;
        Object obj3;
        if (q0.b() && !b()) {
            throw new AssertionError();
        }
        while (true) {
            Object obj4 = this._result;
            obj = g.f15956c;
            if (obj4 == obj) {
                h.e2.c<R> cVar = this.f15951d;
                i.b.b0 b0Var = new i.b.b0((q0.e() && (cVar instanceof h.e2.k.a.c)) ? h0.o(th, (h.e2.k.a.c) cVar) : th, false, 2, null);
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15950f;
                obj2 = g.f15956c;
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, b0Var)) {
                    return;
                }
            } else if (obj4 == h.e2.j.b.h()) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f15950f;
                Object h2 = h.e2.j.b.h();
                obj3 = g.f15957d;
                if (atomicReferenceFieldUpdater2.compareAndSet(this, h2, obj3)) {
                    h.e2.c d2 = IntrinsicsKt__IntrinsicsJvmKt.d(this.f15951d);
                    Result.a aVar = Result.Companion;
                    d2.resumeWith(Result.m106constructorimpl(r0.a(th)));
                    return;
                }
            } else {
                throw new IllegalStateException("Already resumed");
            }
        }
    }

    @Override // i.b.z3.f
    @k.e.a.e
    public Object z(@k.e.a.d i.b.w3.b bVar) {
        return new a(this, bVar).c(null);
    }
}
