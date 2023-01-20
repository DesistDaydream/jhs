package j;

import androidx.exifinterface.media.ExifInterface;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.qiniu.android.collect.ReportItem;
import com.tencent.android.tpush.common.MessageKey;
import com.umeng.analytics.pro.am;
import h.t1;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u0000 $2\u00020\u0001:\u0002%&B\u0007¢\u0006\u0004\b#\u0010\bJ\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\f\u0010\bJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0016\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001a\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0014¢\u0006\u0004\b\u001c\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006'"}, d2 = {"Lj/k;", "Lj/o0;", "", "now", "remainingNanos", "(J)J", "Lh/t1;", "enter", "()V", "", "exit", "()Z", "timedOut", "Lj/k0;", "sink", "(Lj/k0;)Lj/k0;", "Lj/m0;", MessageKey.MSG_SOURCE, "(Lj/m0;)Lj/m0;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function0;", ReportItem.LogTypeBlock, "withTimeout", "(Lh/k2/u/a;)Ljava/lang/Object;", "Ljava/io/IOException;", "cause", "access$newTimeoutException", "(Ljava/io/IOException;)Ljava/io/IOException;", "newTimeoutException", "timeoutAt", "J", "next", "Lj/k;", "inQueue", "Z", "<init>", "Companion", am.av, "b", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public class k extends o0 {
    public static final a Companion = new a(null);
    private static final long IDLE_TIMEOUT_MILLIS;
    private static final long IDLE_TIMEOUT_NANOS;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    private static k head;
    private boolean inQueue;
    private k next;
    private long timeoutAt;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"j/k$a", "", "Lj/k;", "node", "", "timeoutNanos", "", "hasDeadline", "Lh/t1;", com.huawei.hms.push.e.a, "(Lj/k;JZ)V", e.j.a.b.c.f.f10128d, "(Lj/k;)Z", "c", "()Lj/k;", "IDLE_TIMEOUT_MILLIS", "J", "IDLE_TIMEOUT_NANOS", "", "TIMEOUT_WRITE_SIZE", ExpandableTextView.P, "head", "Lj/k;", "<init>", "()V", "okio"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean d(k kVar) {
            synchronized (k.class) {
                for (k kVar2 = k.head; kVar2 != null; kVar2 = kVar2.next) {
                    if (kVar2.next == kVar) {
                        kVar2.next = kVar.next;
                        kVar.next = null;
                        return false;
                    }
                }
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void e(k kVar, long j2, boolean z) {
            synchronized (k.class) {
                if (k.head == null) {
                    k.head = new k();
                    new b().start();
                }
                long nanoTime = System.nanoTime();
                int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
                if (i2 != 0 && z) {
                    kVar.timeoutAt = Math.min(j2, kVar.deadlineNanoTime() - nanoTime) + nanoTime;
                } else if (i2 != 0) {
                    kVar.timeoutAt = j2 + nanoTime;
                } else if (z) {
                    kVar.timeoutAt = kVar.deadlineNanoTime();
                } else {
                    throw new AssertionError();
                }
                long remainingNanos = kVar.remainingNanos(nanoTime);
                k kVar2 = k.head;
                while (kVar2.next != null && remainingNanos >= kVar2.next.remainingNanos(nanoTime)) {
                    kVar2 = kVar2.next;
                }
                kVar.next = kVar2.next;
                kVar2.next = kVar;
                if (kVar2 == k.head) {
                    k.class.notify();
                }
                t1 t1Var = t1.a;
            }
        }

        @k.e.a.e
        public final k c() throws InterruptedException {
            k kVar = k.head.next;
            if (kVar != null) {
                long remainingNanos = kVar.remainingNanos(System.nanoTime());
                if (remainingNanos <= 0) {
                    k.head.next = kVar.next;
                    kVar.next = null;
                    return kVar;
                }
                long j2 = remainingNanos / 1000000;
                k.class.wait(j2, (int) (remainingNanos - (1000000 * j2)));
                return null;
            }
            long nanoTime = System.nanoTime();
            k.class.wait(k.IDLE_TIMEOUT_MILLIS);
            if (k.head.next != null || System.nanoTime() - nanoTime < k.IDLE_TIMEOUT_NANOS) {
                return null;
            }
            return k.head;
        }

        public /* synthetic */ a(h.k2.v.u uVar) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"j/k$b", "Ljava/lang/Thread;", "Lh/t1;", "run", "()V", "<init>", "okio"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class b extends Thread {
        public b() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            k c2;
            while (true) {
                try {
                    synchronized (k.class) {
                        c2 = k.Companion.c();
                        if (c2 == k.head) {
                            k.head = null;
                            return;
                        }
                        t1 t1Var = t1.a;
                    }
                    if (c2 != null) {
                        c2.timedOut();
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"j/k$c", "Lj/k0;", "Lj/m;", MessageKey.MSG_SOURCE, "", "byteCount", "Lh/t1;", "write", "(Lj/m;J)V", "flush", "()V", "close", "Lj/k;", "j", "()Lj/k;", "", "toString", "()Ljava/lang/String;", "okio"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class c implements k0 {
        public final /* synthetic */ k0 b;

        public c(k0 k0Var) {
            this.b = k0Var;
        }

        @Override // j.k0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            k kVar = k.this;
            kVar.enter();
            try {
                this.b.close();
                t1 t1Var = t1.a;
                if (kVar.exit()) {
                    throw kVar.access$newTimeoutException(null);
                }
            } catch (IOException e2) {
                if (!kVar.exit()) {
                    throw e2;
                }
                throw kVar.access$newTimeoutException(e2);
            } finally {
                kVar.exit();
            }
        }

        @Override // j.k0, java.io.Flushable
        public void flush() {
            k kVar = k.this;
            kVar.enter();
            try {
                this.b.flush();
                t1 t1Var = t1.a;
                if (kVar.exit()) {
                    throw kVar.access$newTimeoutException(null);
                }
            } catch (IOException e2) {
                if (!kVar.exit()) {
                    throw e2;
                }
                throw kVar.access$newTimeoutException(e2);
            } finally {
                kVar.exit();
            }
        }

        @Override // j.k0
        @k.e.a.d
        /* renamed from: j */
        public k timeout() {
            return k.this;
        }

        @k.e.a.d
        public String toString() {
            return "AsyncTimeout.sink(" + this.b + ')';
        }

        @Override // j.k0
        public void write(@k.e.a.d m mVar, long j2) {
            j.e(mVar.O0(), 0L, j2);
            while (true) {
                long j3 = 0;
                if (j2 <= 0) {
                    return;
                }
                i0 i0Var = mVar.a;
                while (true) {
                    if (j3 >= 65536) {
                        break;
                    }
                    j3 += i0Var.f15982c - i0Var.b;
                    if (j3 >= j2) {
                        j3 = j2;
                        break;
                    }
                    i0Var = i0Var.f15985f;
                }
                k kVar = k.this;
                kVar.enter();
                try {
                    this.b.write(mVar, j3);
                    t1 t1Var = t1.a;
                    if (kVar.exit()) {
                        throw kVar.access$newTimeoutException(null);
                    }
                    j2 -= j3;
                } catch (IOException e2) {
                    if (!kVar.exit()) {
                        throw e2;
                    }
                    throw kVar.access$newTimeoutException(e2);
                } finally {
                    kVar.exit();
                }
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"j/k$d", "Lj/m0;", "Lj/m;", "sink", "", "byteCount", "read", "(Lj/m;J)J", "Lh/t1;", "close", "()V", "Lj/k;", "j", "()Lj/k;", "", "toString", "()Ljava/lang/String;", "okio"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class d implements m0 {
        public final /* synthetic */ m0 b;

        public d(m0 m0Var) {
            this.b = m0Var;
        }

        @Override // j.m0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            k kVar = k.this;
            kVar.enter();
            try {
                this.b.close();
                t1 t1Var = t1.a;
                if (kVar.exit()) {
                    throw kVar.access$newTimeoutException(null);
                }
            } catch (IOException e2) {
                if (!kVar.exit()) {
                    throw e2;
                }
                throw kVar.access$newTimeoutException(e2);
            } finally {
                kVar.exit();
            }
        }

        @Override // j.m0
        @k.e.a.d
        /* renamed from: j */
        public k timeout() {
            return k.this;
        }

        @Override // j.m0
        public long read(@k.e.a.d m mVar, long j2) {
            k kVar = k.this;
            kVar.enter();
            try {
                long read = this.b.read(mVar, j2);
                if (kVar.exit()) {
                    throw kVar.access$newTimeoutException(null);
                }
                return read;
            } catch (IOException e2) {
                if (kVar.exit()) {
                    throw kVar.access$newTimeoutException(e2);
                }
                throw e2;
            } finally {
                kVar.exit();
            }
        }

        @k.e.a.d
        public String toString() {
            return "AsyncTimeout.source(" + this.b + ')';
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        IDLE_TIMEOUT_MILLIS = millis;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long remainingNanos(long j2) {
        return this.timeoutAt - j2;
    }

    @h.p0
    @k.e.a.d
    public final IOException access$newTimeoutException(@k.e.a.e IOException iOException) {
        return newTimeoutException(iOException);
    }

    public final void enter() {
        if (!this.inQueue) {
            long timeoutNanos = timeoutNanos();
            boolean hasDeadline = hasDeadline();
            if (timeoutNanos != 0 || hasDeadline) {
                this.inQueue = true;
                Companion.e(this, timeoutNanos, hasDeadline);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit".toString());
    }

    public final boolean exit() {
        if (this.inQueue) {
            this.inQueue = false;
            return Companion.d(this);
        }
        return false;
    }

    @k.e.a.d
    public IOException newTimeoutException(@k.e.a.e IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    @k.e.a.d
    public final k0 sink(@k.e.a.d k0 k0Var) {
        return new c(k0Var);
    }

    @k.e.a.d
    public final m0 source(@k.e.a.d m0 m0Var) {
        return new d(m0Var);
    }

    public void timedOut() {
    }

    public final <T> T withTimeout(@k.e.a.d h.k2.u.a<? extends T> aVar) {
        enter();
        try {
            try {
                T invoke = aVar.invoke();
                h.k2.v.c0.d(1);
                if (exit()) {
                    throw access$newTimeoutException(null);
                }
                h.k2.v.c0.c(1);
                return invoke;
            } catch (IOException e2) {
                if (exit()) {
                    throw access$newTimeoutException(e2);
                }
                throw e2;
            }
        } catch (Throwable th) {
            h.k2.v.c0.d(1);
            exit();
            h.k2.v.c0.c(1);
            throw th;
        }
    }
}
