package i.b;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.am;
import i.b.v0;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\b \u0018\u00002\u00020\u00012\u00020\u0002:\u000489\u001c:B\u0007¢\u0006\u0004\b7\u0010\rJ\u001b\u0010\u0007\u001a\u00020\u00062\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0017\u0010\rJ\u000f\u0010\u0018\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0018\u0010\rJ%\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00112\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010 \u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u00112\n\u0010\u001e\u001a\u00060\u0003j\u0002`\u0004H\u0004¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\"\u0010#J!\u0010&\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020$2\n\u0010\u001e\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b&\u0010'J\u0019\u0010(\u001a\u00020\u000b2\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b(\u0010)J\u001d\u0010*\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u000bH\u0004¢\u0006\u0004\b,\u0010\rR$\u00102\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00068B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0016\u00104\u001a\u00020\u00068T@\u0014X\u0094\u0004¢\u0006\u0006\u001a\u0004\b3\u0010/R\u0016\u00106\u001a\u00020\u00118T@\u0014X\u0094\u0004¢\u0006\u0006\u001a\u0004\b5\u0010#¨\u0006;"}, d2 = {"Li/b/j1;", "Li/b/k1;", "Li/b/v0;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "task", "", "U0", "(Ljava/lang/Runnable;)Z", "S0", "()Ljava/lang/Runnable;", "Lh/t1;", "R0", "()V", "Li/b/j1$c;", "b1", "(Li/b/j1$c;)Z", "", "now", "delayedTask", "", "Y0", "(JLi/b/j1$c;)I", "V0", "shutdown", "timeMillis", "Li/b/n;", "continuation", "c", "(JLi/b/n;)V", ReportItem.LogTypeBlock, "Li/b/e1;", "Z0", "(JLjava/lang/Runnable;)Li/b/e1;", "J0", "()J", "Lkotlin/coroutines/CoroutineContext;", "context", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "T0", "(Ljava/lang/Runnable;)V", "X0", "(JLi/b/j1$c;)V", "W0", "value", NotifyType.LIGHTS, "()Z", "a1", "(Z)V", "isCompleted", "G0", "isEmpty", "D0", "nextTime", "<init>", am.av, "b", e.j.a.b.c.f.f10128d, "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public abstract class j1 extends k1 implements v0 {

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f15755d = AtomicReferenceFieldUpdater.newUpdater(j1.class, Object.class, "_queue");

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f15756e = AtomicReferenceFieldUpdater.newUpdater(j1.class, Object.class, "_delayed");
    private volatile Object _queue = null;
    private volatile Object _delayed = null;
    private volatile int _isCompleted = 0;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\r\u001a\u00020\f\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"i/b/j1$a", "Li/b/j1$c;", "Lh/t1;", "run", "()V", "", "toString", "()Ljava/lang/String;", "Li/b/n;", e.j.a.b.c.f.f10128d, "Li/b/n;", "cont", "", "nanoTime", "<init>", "(Li/b/j1;JLi/b/n;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public final class a extends c {

        /* renamed from: d  reason: collision with root package name */
        private final n<h.t1> f15757d;

        /* JADX WARN: Multi-variable type inference failed */
        public a(long j2, @k.e.a.d n<? super h.t1> nVar) {
            super(j2);
            this.f15757d = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f15757d.E(j1.this, h.t1.a);
        }

        @Override // i.b.j1.c
        @k.e.a.d
        public String toString() {
            return super.toString() + this.f15757d.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\u0010\f\u001a\u00060\bj\u0002`\t¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\f\u001a\u00060\bj\u0002`\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"i/b/j1$b", "Li/b/j1$c;", "Lh/t1;", "run", "()V", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", e.j.a.b.c.f.f10128d, "Ljava/lang/Runnable;", ReportItem.LogTypeBlock, "", "nanoTime", "<init>", "(JLjava/lang/Runnable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class b extends c {

        /* renamed from: d  reason: collision with root package name */
        private final Runnable f15759d;

        public b(long j2, @k.e.a.d Runnable runnable) {
            super(j2);
            this.f15759d = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f15759d.run();
        }

        @Override // i.b.j1.c
        @k.e.a.d
        public String toString() {
            return super.toString() + this.f15759d.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\b\b \u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u00052\u00020\u0006B\u000f\u0012\u0006\u0010.\u001a\u00020\u000b¢\u0006\u0004\b/\u00100J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0014\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\"\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R0\u0010(\u001a\b\u0012\u0002\b\u0003\u0018\u00010#2\f\u0010$\u001a\b\u0012\u0002\b\u0003\u0018\u00010#8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010%\"\u0004\b&\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010*R\u0016\u0010.\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b,\u0010-¨\u00061"}, d2 = {"i/b/j1$c", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Li/b/j1$c;", "Li/b/e1;", "Li/b/w3/r0;", "other", "", com.huawei.hms.push.e.a, "(Li/b/j1$c;)I", "", "now", "", "i", "(J)Z", "Li/b/j1$d;", "delayed", "Li/b/j1;", "eventLoop", "h", "(JLi/b/j1$d;Li/b/j1;)I", "Lh/t1;", "dispose", "()V", "", "toString", "()Ljava/lang/String;", "b", ExpandableTextView.P, "f", "()I", e.j.a.b.c.f.f10128d, "(I)V", "index", "Li/b/w3/q0;", "value", "()Li/b/w3/q0;", am.av, "(Li/b/w3/q0;)V", "heap", "", "Ljava/lang/Object;", "_heap", "c", "J", "nanoTime", "<init>", "(J)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static abstract class c implements Runnable, Comparable<c>, e1, i.b.w3.r0 {
        private Object a;
        private int b = -1;
        @h.k2.d

        /* renamed from: c  reason: collision with root package name */
        public long f15760c;

        public c(long j2) {
            this.f15760c = j2;
        }

        @Override // i.b.w3.r0
        public void a(@k.e.a.e i.b.w3.q0<?> q0Var) {
            i.b.w3.i0 i0Var;
            Object obj = this.a;
            i0Var = m1.a;
            if (obj != i0Var) {
                this.a = q0Var;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        @Override // i.b.w3.r0
        @k.e.a.e
        public i.b.w3.q0<?> b() {
            Object obj = this.a;
            if (!(obj instanceof i.b.w3.q0)) {
                obj = null;
            }
            return (i.b.w3.q0) obj;
        }

        @Override // i.b.w3.r0
        public void d(int i2) {
            this.b = i2;
        }

        @Override // i.b.e1
        public final synchronized void dispose() {
            i.b.w3.i0 i0Var;
            i.b.w3.i0 i0Var2;
            Object obj = this.a;
            i0Var = m1.a;
            if (obj == i0Var) {
                return;
            }
            if (!(obj instanceof d)) {
                obj = null;
            }
            d dVar = (d) obj;
            if (dVar != null) {
                dVar.j(this);
            }
            i0Var2 = m1.a;
            this.a = i0Var2;
        }

        @Override // java.lang.Comparable
        /* renamed from: e */
        public int compareTo(@k.e.a.d c cVar) {
            int i2 = ((this.f15760c - cVar.f15760c) > 0L ? 1 : ((this.f15760c - cVar.f15760c) == 0L ? 0 : -1));
            if (i2 > 0) {
                return 1;
            }
            return i2 < 0 ? -1 : 0;
        }

        @Override // i.b.w3.r0
        public int f() {
            return this.b;
        }

        public final synchronized int h(long j2, @k.e.a.d d dVar, @k.e.a.d j1 j1Var) {
            i.b.w3.i0 i0Var;
            Object obj = this.a;
            i0Var = m1.a;
            if (obj == i0Var) {
                return 2;
            }
            synchronized (dVar) {
                c e2 = dVar.e();
                if (j1Var.l()) {
                    return 1;
                }
                if (e2 == null) {
                    dVar.b = j2;
                } else {
                    long j3 = e2.f15760c;
                    if (j3 - j2 < 0) {
                        j2 = j3;
                    }
                    if (j2 - dVar.b > 0) {
                        dVar.b = j2;
                    }
                }
                long j4 = this.f15760c;
                long j5 = dVar.b;
                if (j4 - j5 < 0) {
                    this.f15760c = j5;
                }
                dVar.a(this);
                return 0;
            }
        }

        public final boolean i(long j2) {
            return j2 - this.f15760c >= 0;
        }

        @k.e.a.d
        public String toString() {
            return "Delayed[nanos=" + this.f15760c + ']';
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"i/b/j1$d", "Li/b/w3/q0;", "Li/b/j1$c;", "", "b", "J", "timeNow", "<init>", "(J)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class d extends i.b.w3.q0<c> {
        @h.k2.d
        public long b;

        public d(long j2) {
            this.b = j2;
        }
    }

    private final void R0() {
        i.b.w3.i0 i0Var;
        i.b.w3.i0 i0Var2;
        if (q0.b() && !l()) {
            throw new AssertionError();
        }
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15755d;
                i0Var = m1.f15771h;
                if (atomicReferenceFieldUpdater.compareAndSet(this, null, i0Var)) {
                    return;
                }
            } else if (!(obj instanceof i.b.w3.v)) {
                i0Var2 = m1.f15771h;
                if (obj == i0Var2) {
                    return;
                }
                i.b.w3.v vVar = new i.b.w3.v(8, true);
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                vVar.a((Runnable) obj);
                if (f15755d.compareAndSet(this, obj, vVar)) {
                    return;
                }
            } else {
                ((i.b.w3.v) obj).d();
                return;
            }
        }
    }

    private final Runnable S0() {
        i.b.w3.i0 i0Var;
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (!(obj instanceof i.b.w3.v)) {
                i0Var = m1.f15771h;
                if (obj == i0Var) {
                    return null;
                }
                if (f15755d.compareAndSet(this, obj, null)) {
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                    return (Runnable) obj;
                }
            } else {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
                i.b.w3.v vVar = (i.b.w3.v) obj;
                Object l2 = vVar.l();
                if (l2 != i.b.w3.v.s) {
                    return (Runnable) l2;
                }
                f15755d.compareAndSet(this, obj, vVar.k());
            }
        }
    }

    private final boolean U0(Runnable runnable) {
        i.b.w3.i0 i0Var;
        while (true) {
            Object obj = this._queue;
            if (l()) {
                return false;
            }
            if (obj == null) {
                if (f15755d.compareAndSet(this, null, runnable)) {
                    return true;
                }
            } else if (!(obj instanceof i.b.w3.v)) {
                i0Var = m1.f15771h;
                if (obj == i0Var) {
                    return false;
                }
                i.b.w3.v vVar = new i.b.w3.v(8, true);
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                vVar.a((Runnable) obj);
                vVar.a(runnable);
                if (f15755d.compareAndSet(this, obj, vVar)) {
                    return true;
                }
            } else {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
                i.b.w3.v vVar2 = (i.b.w3.v) obj;
                int a2 = vVar2.a(runnable);
                if (a2 == 0) {
                    return true;
                }
                if (a2 == 1) {
                    f15755d.compareAndSet(this, obj, vVar2.k());
                } else if (a2 == 2) {
                    return false;
                }
            }
        }
    }

    private final void V0() {
        c m2;
        l3 b2 = m3.b();
        long nanoTime = b2 != null ? b2.nanoTime() : System.nanoTime();
        while (true) {
            d dVar = (d) this._delayed;
            if (dVar == null || (m2 = dVar.m()) == null) {
                return;
            }
            N0(nanoTime, m2);
        }
    }

    private final int Y0(long j2, c cVar) {
        if (l()) {
            return 1;
        }
        d dVar = (d) this._delayed;
        if (dVar == null) {
            f15756e.compareAndSet(this, null, new d(j2));
            dVar = (d) this._delayed;
        }
        return cVar.h(j2, dVar, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a1(boolean z) {
        this._isCompleted = z ? 1 : 0;
    }

    private final boolean b1(c cVar) {
        d dVar = (d) this._delayed;
        return (dVar != null ? dVar.h() : null) == cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean l() {
        return this._isCompleted;
    }

    @Override // i.b.i1
    public long D0() {
        c h2;
        i.b.w3.i0 i0Var;
        if (super.D0() == 0) {
            return 0L;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof i.b.w3.v)) {
                i0Var = m1.f15771h;
                return obj == i0Var ? Long.MAX_VALUE : 0L;
            } else if (!((i.b.w3.v) obj).h()) {
                return 0L;
            }
        }
        d dVar = (d) this._delayed;
        if (dVar == null || (h2 = dVar.h()) == null) {
            return Long.MAX_VALUE;
        }
        long j2 = h2.f15760c;
        l3 b2 = m3.b();
        return h.o2.q.o(j2 - (b2 != null ? b2.nanoTime() : System.nanoTime()), 0L);
    }

    @Override // i.b.i1
    public boolean G0() {
        i.b.w3.i0 i0Var;
        if (I0()) {
            d dVar = (d) this._delayed;
            if (dVar == null || dVar.g()) {
                Object obj = this._queue;
                if (obj != null) {
                    if (obj instanceof i.b.w3.v) {
                        return ((i.b.w3.v) obj).h();
                    }
                    i0Var = m1.f15771h;
                    if (obj != i0Var) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0057  */
    @Override // i.b.i1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long J0() {
        /*
            r9 = this;
            boolean r0 = r9.K0()
            r1 = 0
            if (r0 == 0) goto L9
            return r1
        L9:
            java.lang.Object r0 = r9._delayed
            i.b.j1$d r0 = (i.b.j1.d) r0
            if (r0 == 0) goto L4d
            boolean r3 = r0.g()
            if (r3 != 0) goto L4d
            i.b.l3 r3 = i.b.m3.b()
            if (r3 == 0) goto L20
            long r3 = r3.nanoTime()
            goto L24
        L20:
            long r3 = java.lang.System.nanoTime()
        L24:
            monitor-enter(r0)
            i.b.w3.r0 r5 = r0.e()     // Catch: java.lang.Throwable -> L4a
            r6 = 0
            if (r5 == 0) goto L44
            i.b.j1$c r5 = (i.b.j1.c) r5     // Catch: java.lang.Throwable -> L4a
            boolean r7 = r5.i(r3)     // Catch: java.lang.Throwable -> L4a
            r8 = 0
            if (r7 == 0) goto L3a
            boolean r5 = r9.U0(r5)     // Catch: java.lang.Throwable -> L4a
            goto L3b
        L3a:
            r5 = 0
        L3b:
            if (r5 == 0) goto L42
            i.b.w3.r0 r5 = r0.k(r8)     // Catch: java.lang.Throwable -> L4a
            r6 = r5
        L42:
            monitor-exit(r0)
            goto L45
        L44:
            monitor-exit(r0)
        L45:
            i.b.j1$c r6 = (i.b.j1.c) r6
            if (r6 == 0) goto L4d
            goto L24
        L4a:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L4d:
            java.lang.Runnable r0 = r9.S0()
            if (r0 == 0) goto L57
            r0.run()
            return r1
        L57:
            long r0 = r9.D0()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i.b.j1.J0():long");
    }

    public final void T0(@k.e.a.d Runnable runnable) {
        if (U0(runnable)) {
            O0();
        } else {
            s0.f15796m.T0(runnable);
        }
    }

    public final void W0() {
        this._queue = null;
        this._delayed = null;
    }

    public final void X0(long j2, @k.e.a.d c cVar) {
        int Y0 = Y0(j2, cVar);
        if (Y0 == 0) {
            if (b1(cVar)) {
                O0();
            }
        } else if (Y0 == 1) {
            N0(j2, cVar);
        } else if (Y0 != 2) {
            throw new IllegalStateException("unexpected result".toString());
        }
    }

    @k.e.a.d
    public final e1 Z0(long j2, @k.e.a.d Runnable runnable) {
        long d2 = m1.d(j2);
        if (d2 < h.u2.e.f15706c) {
            l3 b2 = m3.b();
            long nanoTime = b2 != null ? b2.nanoTime() : System.nanoTime();
            b bVar = new b(d2 + nanoTime, runnable);
            X0(nanoTime, bVar);
            return bVar;
        }
        return o2.a;
    }

    @Override // i.b.v0
    public void c(long j2, @k.e.a.d n<? super h.t1> nVar) {
        long d2 = m1.d(j2);
        if (d2 < h.u2.e.f15706c) {
            l3 b2 = m3.b();
            long nanoTime = b2 != null ? b2.nanoTime() : System.nanoTime();
            a aVar = new a(d2 + nanoTime, nVar);
            q.a(nVar, aVar);
            X0(nanoTime, aVar);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(@k.e.a.d CoroutineContext coroutineContext, @k.e.a.d Runnable runnable) {
        T0(runnable);
    }

    @Override // i.b.v0
    @k.e.a.e
    public Object m0(long j2, @k.e.a.d h.e2.c<? super h.t1> cVar) {
        return v0.a.a(this, j2, cVar);
    }

    @Override // i.b.i1
    public void shutdown() {
        h3.b.c();
        a1(true);
        R0();
        do {
        } while (J0() <= 0);
        V0();
    }

    @Override // i.b.v0
    @k.e.a.d
    public e1 t(long j2, @k.e.a.d Runnable runnable, @k.e.a.d CoroutineContext coroutineContext) {
        return v0.a.b(this, j2, runnable, coroutineContext);
    }
}
