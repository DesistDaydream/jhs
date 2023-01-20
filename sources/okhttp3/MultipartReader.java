package okhttp3;

import com.caverock.androidsvg.SVG;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.tencent.android.tpush.common.MessageKey;
import h.k2.g;
import h.k2.v.f0;
import h.k2.v.u;
import j.c0;
import j.m;
import j.m0;
import j.o;
import j.o0;
import j.z;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import okhttp3.internal.http1.HeadersReader;
import okio.ByteString;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 &2\u00020\u0001:\u0003&'(B\u0017\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b!\u0010\"B\u0011\b\u0016\u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b!\u0010%J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\b\u0018\u00010\u0015R\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u0019\u0010\u001a\u001a\u00020\u00198\u0007@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0011R\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006)"}, d2 = {"Lokhttp3/MultipartReader;", "Ljava/io/Closeable;", "", "maxResult", "currentPartBytesRemaining", "(J)J", "Lokhttp3/MultipartReader$Part;", "nextPart", "()Lokhttp3/MultipartReader$Part;", "Lh/t1;", "close", "()V", "", "partCount", ExpandableTextView.P, "Lokio/ByteString;", "crlfDashDashBoundary", "Lokio/ByteString;", "", "noMoreParts", "Z", "Lokhttp3/MultipartReader$PartSource;", "currentPart", "Lokhttp3/MultipartReader$PartSource;", "closed", "", "boundary", "Ljava/lang/String;", "()Ljava/lang/String;", "dashDashBoundary", "Lj/o;", MessageKey.MSG_SOURCE, "Lj/o;", "<init>", "(Lj/o;Ljava/lang/String;)V", "Lokhttp3/ResponseBody;", "response", "(Lokhttp3/ResponseBody;)V", "Companion", "Part", "PartSource", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class MultipartReader implements Closeable {
    public static final Companion Companion = new Companion(null);
    @d
    private static final c0 afterBoundaryOptions;
    @d
    private final String boundary;
    private boolean closed;
    private final ByteString crlfDashDashBoundary;
    private PartSource currentPart;
    private final ByteString dashDashBoundary;
    private boolean noMoreParts;
    private int partCount;
    private final o source;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lokhttp3/MultipartReader$Companion;", "", "Lj/c0;", "afterBoundaryOptions", "Lj/c0;", "getAfterBoundaryOptions", "()Lj/c0;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        @d
        public final c0 getAfterBoundaryOptions() {
            return MultipartReader.afterBoundaryOptions;
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00058\u0007@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\bR\u0019\u0010\n\u001a\u00020\t8\u0007@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f¨\u0006\u000f"}, d2 = {"Lokhttp3/MultipartReader$Part;", "Ljava/io/Closeable;", "Lh/t1;", "close", "()V", "Lokhttp3/Headers;", "headers", "Lokhttp3/Headers;", "()Lokhttp3/Headers;", "Lj/o;", "body", "Lj/o;", "()Lj/o;", "<init>", "(Lokhttp3/Headers;Lj/o;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Part implements Closeable {
        @d
        private final o body;
        @d
        private final Headers headers;

        public Part(@d Headers headers, @d o oVar) {
            this.headers = headers;
            this.body = oVar;
        }

        @g(name = "body")
        @d
        public final o body() {
            return this.body;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.body.close();
        }

        @g(name = "headers")
        @d
        public final Headers headers() {
            return this.headers;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000e¨\u0006\u0011"}, d2 = {"Lokhttp3/MultipartReader$PartSource;", "Lj/m0;", "Lh/t1;", "close", "()V", "Lj/m;", "sink", "", "byteCount", "read", "(Lj/m;J)J", "Lj/o0;", "timeout", "()Lj/o0;", "Lj/o0;", "<init>", "(Lokhttp3/MultipartReader;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public final class PartSource implements m0 {
        private final o0 timeout = new o0();

        public PartSource() {
        }

        @Override // j.m0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (f0.g(MultipartReader.this.currentPart, this)) {
                MultipartReader.this.currentPart = null;
            }
        }

        @Override // j.m0
        public long read(@d m mVar, long j2) {
            if (j2 >= 0) {
                if (f0.g(MultipartReader.this.currentPart, this)) {
                    o0 timeout = MultipartReader.this.source.timeout();
                    o0 o0Var = this.timeout;
                    long timeoutNanos = timeout.timeoutNanos();
                    long a = o0.Companion.a(o0Var.timeoutNanos(), timeout.timeoutNanos());
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    timeout.timeout(a, timeUnit);
                    if (timeout.hasDeadline()) {
                        long deadlineNanoTime = timeout.deadlineNanoTime();
                        if (o0Var.hasDeadline()) {
                            timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), o0Var.deadlineNanoTime()));
                        }
                        try {
                            long currentPartBytesRemaining = MultipartReader.this.currentPartBytesRemaining(j2);
                            long read = currentPartBytesRemaining == 0 ? -1L : MultipartReader.this.source.read(mVar, currentPartBytesRemaining);
                            timeout.timeout(timeoutNanos, timeUnit);
                            if (o0Var.hasDeadline()) {
                                timeout.deadlineNanoTime(deadlineNanoTime);
                            }
                            return read;
                        } catch (Throwable th) {
                            timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                            if (o0Var.hasDeadline()) {
                                timeout.deadlineNanoTime(deadlineNanoTime);
                            }
                            throw th;
                        }
                    }
                    if (o0Var.hasDeadline()) {
                        timeout.deadlineNanoTime(o0Var.deadlineNanoTime());
                    }
                    try {
                        long currentPartBytesRemaining2 = MultipartReader.this.currentPartBytesRemaining(j2);
                        long read2 = currentPartBytesRemaining2 == 0 ? -1L : MultipartReader.this.source.read(mVar, currentPartBytesRemaining2);
                        timeout.timeout(timeoutNanos, timeUnit);
                        if (o0Var.hasDeadline()) {
                            timeout.clearDeadline();
                        }
                        return read2;
                    } catch (Throwable th2) {
                        timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                        if (o0Var.hasDeadline()) {
                            timeout.clearDeadline();
                        }
                        throw th2;
                    }
                }
                throw new IllegalStateException("closed".toString());
            }
            throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
        }

        @Override // j.m0
        @d
        public o0 timeout() {
            return this.timeout;
        }
    }

    static {
        c0.a aVar = c0.f15959d;
        ByteString.a aVar2 = ByteString.Companion;
        afterBoundaryOptions = aVar.d(aVar2.l("\r\n"), aVar2.l("--"), aVar2.l(ExpandableTextView.N), aVar2.l("\t"));
    }

    public MultipartReader(@d o oVar, @d String str) throws IOException {
        this.source = oVar;
        this.boundary = str;
        this.dashDashBoundary = new m().B("--").B(str).j0();
        this.crlfDashDashBoundary = new m().B("\r\n--").B(str).j0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long currentPartBytesRemaining(long j2) {
        this.source.R(this.crlfDashDashBoundary.size());
        long f2 = this.source.getBuffer().f(this.crlfDashDashBoundary);
        if (f2 == -1) {
            return Math.min(j2, (this.source.getBuffer().O0() - this.crlfDashDashBoundary.size()) + 1);
        }
        return Math.min(j2, f2);
    }

    @g(name = "boundary")
    @d
    public final String boundary() {
        return this.boundary;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.currentPart = null;
        this.source.close();
    }

    @e
    public final Part nextPart() throws IOException {
        if (!this.closed) {
            if (this.noMoreParts) {
                return null;
            }
            if (this.partCount == 0 && this.source.C(0L, this.dashDashBoundary)) {
                this.source.skip(this.dashDashBoundary.size());
            } else {
                while (true) {
                    long currentPartBytesRemaining = currentPartBytesRemaining(SVG.A);
                    if (currentPartBytesRemaining == 0) {
                        break;
                    }
                    this.source.skip(currentPartBytesRemaining);
                }
                this.source.skip(this.crlfDashDashBoundary.size());
            }
            boolean z = false;
            while (true) {
                int y0 = this.source.y0(afterBoundaryOptions);
                if (y0 == -1) {
                    throw new ProtocolException("unexpected characters after boundary");
                }
                if (y0 == 0) {
                    this.partCount++;
                    Headers readHeaders = new HeadersReader(this.source).readHeaders();
                    PartSource partSource = new PartSource();
                    this.currentPart = partSource;
                    return new Part(readHeaders, z.d(partSource));
                } else if (y0 == 1) {
                    if (!z) {
                        if (this.partCount != 0) {
                            this.noMoreParts = true;
                            return null;
                        }
                        throw new ProtocolException("expected at least 1 part");
                    }
                    throw new ProtocolException("unexpected characters after boundary");
                } else if (y0 == 2 || y0 == 3) {
                    z = true;
                }
            }
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MultipartReader(@k.e.a.d okhttp3.ResponseBody r3) throws java.io.IOException {
        /*
            r2 = this;
            j.o r0 = r3.source()
            okhttp3.MediaType r3 = r3.contentType()
            if (r3 == 0) goto L16
            java.lang.String r1 = "boundary"
            java.lang.String r3 = r3.parameter(r1)
            if (r3 == 0) goto L16
            r2.<init>(r0, r3)
            return
        L16:
            java.net.ProtocolException r3 = new java.net.ProtocolException
            java.lang.String r0 = "expected the Content-Type to have a boundary parameter"
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.MultipartReader.<init>(okhttp3.ResponseBody):void");
    }
}
