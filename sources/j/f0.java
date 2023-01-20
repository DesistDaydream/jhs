package j;

import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.qiniu.android.collect.ReportItem;
import com.tencent.android.tpush.common.MessageKey;
import com.umeng.analytics.pro.am;
import h.q0;
import h.t1;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0017¢\u0006\u0004\b3\u00104J-\u0010\u0007\u001a\u00020\u0004*\u00020\u00022\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005H\u0082\b¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0016\u001a\u00020\u000e8G@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0010R\u001c\u0010\u001c\u001a\u00020\u00178\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010 \u001a\u00020\u001d8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b\u0013\u0010\u001fR$\u0010$\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\n\u0010!\u001a\u0004\b\"\u0010\r\"\u0004\b#\u0010\u000bR\"\u0010+\u001a\u00020%8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010-\u001a\u00020%8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010&\u001a\u0004\b\u0018\u0010(\"\u0004\b,\u0010*R\"\u00101\u001a\u00020%8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b.\u0010&\u001a\u0004\b/\u0010(\"\u0004\b0\u0010*R\u0019\u0010\t\u001a\u00020\u00028G@\u0006¢\u0006\f\n\u0004\b\u0007\u0010!\u001a\u0004\b2\u0010\r¨\u00065"}, d2 = {"Lj/f0;", "", "Lj/k0;", "Lkotlin/Function1;", "Lh/t1;", "Lh/q;", ReportItem.LogTypeBlock, "f", "(Lj/k0;Lh/k2/u/l;)V", "sink", com.huawei.hms.push.e.a, "(Lj/k0;)V", am.av, "()Lj/k0;", "Lj/m0;", "b", "()Lj/m0;", e.j.a.b.c.f.f10128d, "()V", "g", "Lj/m0;", "r", MessageKey.MSG_SOURCE, "", "h", "J", "j", "()J", "maxBufferSize", "Lj/m;", "Lj/m;", "()Lj/m;", "buffer", "Lj/k0;", "i", "n", "foldedSink", "", "Z", NotifyType.LIGHTS, "()Z", am.ax, "(Z)V", "sourceClosed", "m", "canceled", "c", "k", "o", "sinkClosed", "q", "<init>", "(J)V", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class f0 {
    @k.e.a.d
    private final m a = new m();
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f15965c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f15966d;
    @k.e.a.e

    /* renamed from: e  reason: collision with root package name */
    private k0 f15967e;
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    private final k0 f15968f;
    @k.e.a.d

    /* renamed from: g  reason: collision with root package name */
    private final m0 f15969g;

    /* renamed from: h  reason: collision with root package name */
    private final long f15970h;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"j/f0$a", "Lj/k0;", "Lj/m;", MessageKey.MSG_SOURCE, "", "byteCount", "Lh/t1;", "write", "(Lj/m;J)V", "flush", "()V", "close", "Lj/o0;", "timeout", "()Lj/o0;", am.av, "Lj/o0;", "okio"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a implements k0 {
        private final o0 a = new o0();

        public a() {
        }

        @Override // j.k0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            synchronized (f0.this.g()) {
                if (f0.this.k()) {
                    return;
                }
                k0 i2 = f0.this.i();
                if (i2 == null) {
                    if (f0.this.l() && f0.this.g().O0() > 0) {
                        throw new IOException("source is closed");
                    }
                    f0.this.o(true);
                    m g2 = f0.this.g();
                    if (g2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                    }
                    g2.notifyAll();
                    i2 = null;
                }
                t1 t1Var = t1.a;
                if (i2 != null) {
                    f0 f0Var = f0.this;
                    o0 timeout = i2.timeout();
                    o0 timeout2 = f0Var.q().timeout();
                    long timeoutNanos = timeout.timeoutNanos();
                    long a = o0.Companion.a(timeout2.timeoutNanos(), timeout.timeoutNanos());
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    timeout.timeout(a, timeUnit);
                    if (timeout.hasDeadline()) {
                        long deadlineNanoTime = timeout.deadlineNanoTime();
                        if (timeout2.hasDeadline()) {
                            timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                        }
                        try {
                            i2.close();
                            timeout.timeout(timeoutNanos, timeUnit);
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(deadlineNanoTime);
                                return;
                            }
                            return;
                        } catch (Throwable th) {
                            timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(deadlineNanoTime);
                            }
                            throw th;
                        }
                    }
                    if (timeout2.hasDeadline()) {
                        timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                    }
                    try {
                        i2.close();
                        timeout.timeout(timeoutNanos, timeUnit);
                        if (timeout2.hasDeadline()) {
                            timeout.clearDeadline();
                        }
                    } catch (Throwable th2) {
                        timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                        if (timeout2.hasDeadline()) {
                            timeout.clearDeadline();
                        }
                        throw th2;
                    }
                }
            }
        }

        @Override // j.k0, java.io.Flushable
        public void flush() {
            k0 i2;
            synchronized (f0.this.g()) {
                if (!f0.this.k()) {
                    if (!f0.this.h()) {
                        i2 = f0.this.i();
                        if (i2 == null) {
                            if (f0.this.l() && f0.this.g().O0() > 0) {
                                throw new IOException("source is closed");
                            }
                            i2 = null;
                        }
                        t1 t1Var = t1.a;
                    } else {
                        throw new IOException("canceled");
                    }
                } else {
                    throw new IllegalStateException("closed".toString());
                }
            }
            if (i2 != null) {
                f0 f0Var = f0.this;
                o0 timeout = i2.timeout();
                o0 timeout2 = f0Var.q().timeout();
                long timeoutNanos = timeout.timeoutNanos();
                long a = o0.Companion.a(timeout2.timeoutNanos(), timeout.timeoutNanos());
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                timeout.timeout(a, timeUnit);
                if (timeout.hasDeadline()) {
                    long deadlineNanoTime = timeout.deadlineNanoTime();
                    if (timeout2.hasDeadline()) {
                        timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                    }
                    try {
                        i2.flush();
                        timeout.timeout(timeoutNanos, timeUnit);
                        if (timeout2.hasDeadline()) {
                            timeout.deadlineNanoTime(deadlineNanoTime);
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                        if (timeout2.hasDeadline()) {
                            timeout.deadlineNanoTime(deadlineNanoTime);
                        }
                        throw th;
                    }
                }
                if (timeout2.hasDeadline()) {
                    timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                }
                try {
                    i2.flush();
                    timeout.timeout(timeoutNanos, timeUnit);
                    if (timeout2.hasDeadline()) {
                        timeout.clearDeadline();
                    }
                } catch (Throwable th2) {
                    timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                    if (timeout2.hasDeadline()) {
                        timeout.clearDeadline();
                    }
                    throw th2;
                }
            }
        }

        @Override // j.k0
        @k.e.a.d
        public o0 timeout() {
            return this.a;
        }

        @Override // j.k0
        public void write(@k.e.a.d m mVar, long j2) {
            k0 k0Var;
            synchronized (f0.this.g()) {
                if (!f0.this.k()) {
                    if (!f0.this.h()) {
                        while (true) {
                            if (j2 <= 0) {
                                k0Var = null;
                                break;
                            }
                            k0Var = f0.this.i();
                            if (k0Var != null) {
                                break;
                            } else if (!f0.this.l()) {
                                long j3 = f0.this.j() - f0.this.g().O0();
                                if (j3 == 0) {
                                    this.a.waitUntilNotified(f0.this.g());
                                    if (f0.this.h()) {
                                        throw new IOException("canceled");
                                    }
                                } else {
                                    long min = Math.min(j3, j2);
                                    f0.this.g().write(mVar, min);
                                    j2 -= min;
                                    m g2 = f0.this.g();
                                    if (g2 == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                                    }
                                    g2.notifyAll();
                                }
                            } else {
                                throw new IOException("source is closed");
                            }
                        }
                        t1 t1Var = t1.a;
                    } else {
                        throw new IOException("canceled");
                    }
                } else {
                    throw new IllegalStateException("closed".toString());
                }
            }
            if (k0Var != null) {
                f0 f0Var = f0.this;
                o0 timeout = k0Var.timeout();
                o0 timeout2 = f0Var.q().timeout();
                long timeoutNanos = timeout.timeoutNanos();
                long a = o0.Companion.a(timeout2.timeoutNanos(), timeout.timeoutNanos());
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                timeout.timeout(a, timeUnit);
                if (timeout.hasDeadline()) {
                    long deadlineNanoTime = timeout.deadlineNanoTime();
                    if (timeout2.hasDeadline()) {
                        timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                    }
                    try {
                        k0Var.write(mVar, j2);
                        timeout.timeout(timeoutNanos, timeUnit);
                        if (timeout2.hasDeadline()) {
                            timeout.deadlineNanoTime(deadlineNanoTime);
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                        if (timeout2.hasDeadline()) {
                            timeout.deadlineNanoTime(deadlineNanoTime);
                        }
                        throw th;
                    }
                }
                if (timeout2.hasDeadline()) {
                    timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                }
                try {
                    k0Var.write(mVar, j2);
                    timeout.timeout(timeoutNanos, timeUnit);
                    if (timeout2.hasDeadline()) {
                        timeout.clearDeadline();
                    }
                } catch (Throwable th2) {
                    timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                    if (timeout2.hasDeadline()) {
                        timeout.clearDeadline();
                    }
                    throw th2;
                }
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"j/f0$b", "Lj/m0;", "Lj/m;", "sink", "", "byteCount", "read", "(Lj/m;J)J", "Lh/t1;", "close", "()V", "Lj/o0;", "timeout", "()Lj/o0;", am.av, "Lj/o0;", "okio"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class b implements m0 {
        private final o0 a = new o0();

        public b() {
        }

        @Override // j.m0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            synchronized (f0.this.g()) {
                f0.this.p(true);
                m g2 = f0.this.g();
                if (g2 != null) {
                    g2.notifyAll();
                    t1 t1Var = t1.a;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                }
            }
        }

        @Override // j.m0
        public long read(@k.e.a.d m mVar, long j2) {
            synchronized (f0.this.g()) {
                if (!f0.this.l()) {
                    if (!f0.this.h()) {
                        while (f0.this.g().O0() == 0) {
                            if (f0.this.k()) {
                                return -1L;
                            }
                            this.a.waitUntilNotified(f0.this.g());
                            if (f0.this.h()) {
                                throw new IOException("canceled");
                            }
                        }
                        long read = f0.this.g().read(mVar, j2);
                        m g2 = f0.this.g();
                        if (g2 != null) {
                            g2.notifyAll();
                            return read;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                    }
                    throw new IOException("canceled");
                }
                throw new IllegalStateException("closed".toString());
            }
        }

        @Override // j.m0
        @k.e.a.d
        public o0 timeout() {
            return this.a;
        }
    }

    public f0(long j2) {
        this.f15970h = j2;
        if (j2 >= 1) {
            this.f15968f = new a();
            this.f15969g = new b();
            return;
        }
        throw new IllegalArgumentException(("maxBufferSize < 1: " + j2).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(k0 k0Var, h.k2.u.l<? super k0, t1> lVar) {
        o0 timeout = k0Var.timeout();
        o0 timeout2 = q().timeout();
        long timeoutNanos = timeout.timeoutNanos();
        long a2 = o0.Companion.a(timeout2.timeoutNanos(), timeout.timeoutNanos());
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        timeout.timeout(a2, timeUnit);
        if (timeout.hasDeadline()) {
            long deadlineNanoTime = timeout.deadlineNanoTime();
            if (timeout2.hasDeadline()) {
                timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
            }
            try {
                lVar.invoke(k0Var);
                h.k2.v.c0.d(1);
                timeout.timeout(timeoutNanos, timeUnit);
                if (timeout2.hasDeadline()) {
                    timeout.deadlineNanoTime(deadlineNanoTime);
                }
                h.k2.v.c0.c(1);
                return;
            } catch (Throwable th) {
                h.k2.v.c0.d(1);
                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                if (timeout2.hasDeadline()) {
                    timeout.deadlineNanoTime(deadlineNanoTime);
                }
                h.k2.v.c0.c(1);
                throw th;
            }
        }
        if (timeout2.hasDeadline()) {
            timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
        }
        try {
            lVar.invoke(k0Var);
            h.k2.v.c0.d(1);
            timeout.timeout(timeoutNanos, timeUnit);
            if (timeout2.hasDeadline()) {
                timeout.clearDeadline();
            }
            h.k2.v.c0.c(1);
        } catch (Throwable th2) {
            h.k2.v.c0.d(1);
            timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
            if (timeout2.hasDeadline()) {
                timeout.clearDeadline();
            }
            h.k2.v.c0.c(1);
            throw th2;
        }
    }

    @h.k2.g(name = "-deprecated_sink")
    @h.i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "sink", imports = {}))
    @k.e.a.d
    public final k0 a() {
        return this.f15968f;
    }

    @h.k2.g(name = "-deprecated_source")
    @h.i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = MessageKey.MSG_SOURCE, imports = {}))
    @k.e.a.d
    public final m0 b() {
        return this.f15969g;
    }

    public final void d() {
        synchronized (this.a) {
            this.b = true;
            this.a.l();
            m mVar = this.a;
            if (mVar != null) {
                mVar.notifyAll();
                t1 t1Var = t1.a;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
            }
        }
    }

    public final void e(@k.e.a.d k0 k0Var) throws IOException {
        boolean z;
        m mVar;
        while (true) {
            synchronized (this.a) {
                if (this.f15967e == null) {
                    if (!this.b) {
                        if (this.a.b0()) {
                            this.f15966d = true;
                            this.f15967e = k0Var;
                            return;
                        }
                        z = this.f15965c;
                        mVar = new m();
                        m mVar2 = this.a;
                        mVar.write(mVar2, mVar2.O0());
                        m mVar3 = this.a;
                        if (mVar3 != null) {
                            mVar3.notifyAll();
                            t1 t1Var = t1.a;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                        }
                    } else {
                        this.f15967e = k0Var;
                        throw new IOException("canceled");
                    }
                } else {
                    throw new IllegalStateException("sink already folded".toString());
                }
            }
            try {
                k0Var.write(mVar, mVar.O0());
                if (z) {
                    k0Var.close();
                } else {
                    k0Var.flush();
                }
            } catch (Throwable th) {
                synchronized (this.a) {
                    this.f15966d = true;
                    m mVar4 = this.a;
                    if (mVar4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                    }
                    mVar4.notifyAll();
                    t1 t1Var2 = t1.a;
                    throw th;
                }
            }
        }
    }

    @k.e.a.d
    public final m g() {
        return this.a;
    }

    public final boolean h() {
        return this.b;
    }

    @k.e.a.e
    public final k0 i() {
        return this.f15967e;
    }

    public final long j() {
        return this.f15970h;
    }

    public final boolean k() {
        return this.f15965c;
    }

    public final boolean l() {
        return this.f15966d;
    }

    public final void m(boolean z) {
        this.b = z;
    }

    public final void n(@k.e.a.e k0 k0Var) {
        this.f15967e = k0Var;
    }

    public final void o(boolean z) {
        this.f15965c = z;
    }

    public final void p(boolean z) {
        this.f15966d = z;
    }

    @h.k2.g(name = "sink")
    @k.e.a.d
    public final k0 q() {
        return this.f15968f;
    }

    @h.k2.g(name = MessageKey.MSG_SOURCE)
    @k.e.a.d
    public final m0 r() {
        return this.f15969g;
    }
}
