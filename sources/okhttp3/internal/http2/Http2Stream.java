package okhttp3.internal.http2;

import com.bytedance.msdk.api.reward.RewardItem;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.tencent.android.tpush.common.MessageKey;
import h.k2.v.u;
import h.t1;
import j.k;
import j.k0;
import j.m;
import j.m0;
import j.o;
import j.o0;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import okhttp3.Headers;
import okhttp3.internal.Util;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u0000 u2\u00020\u0001:\u0004uvwxB3\b\u0000\u0012\u0006\u0010b\u001a\u00020(\u0012\u0006\u0010R\u001a\u00020Q\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010-\u001a\u00020\u0006\u0012\b\u0010,\u001a\u0004\u0018\u00010\t¢\u0006\u0004\bs\u0010tJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\f\u0010\u000bJ+\u0010\u0013\u001a\u00020\u00122\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u0019J\r\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010\"\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\"\u0010#J\u0015\u0010$\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b$\u0010%J\u001d\u0010*\u001a\u00020\u00122\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b*\u0010+J\u001d\u0010.\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\u0006¢\u0006\u0004\b.\u0010/J\u0015\u00100\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b0\u0010%J\u000f\u00103\u001a\u00020\u0012H\u0000¢\u0006\u0004\b1\u00102J\u0015\u00106\u001a\u00020\u00122\u0006\u00105\u001a\u000204¢\u0006\u0004\b6\u00107J\u000f\u00109\u001a\u00020\u0012H\u0000¢\u0006\u0004\b8\u00102J\u000f\u0010;\u001a\u00020\u0012H\u0000¢\u0006\u0004\b:\u00102R \u0010=\u001a\u00060<R\u00020\u00008\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u0013\u0010A\u001a\u00020\u00068F@\u0006¢\u0006\u0006\u001a\u0004\bA\u0010BR*\u0010D\u001a\u0002042\u0006\u0010C\u001a\u0002048\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u00107R\u0016\u0010I\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR*\u0010K\u001a\u0002042\u0006\u0010C\u001a\u0002048\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010E\u001a\u0004\bL\u0010G\"\u0004\bM\u00107R*\u0010N\u001a\u0002042\u0006\u0010C\u001a\u0002048\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010E\u001a\u0004\bO\u0010G\"\u0004\bP\u00107R\u0019\u0010R\u001a\u00020Q8\u0006@\u0006¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010UR \u0010'\u001a\u00060VR\u00020\u00008\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b'\u0010W\u001a\u0004\bX\u0010YR \u0010\u0018\u001a\u00060ZR\u00020\u00008\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0018\u0010[\u001a\u0004\b\\\u0010]R \u0010\u001a\u001a\u00060ZR\u00020\u00008\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001a\u0010[\u001a\u0004\b^\u0010]R\u001c\u0010`\u001a\b\u0012\u0004\u0012\u00020\t0_8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0019\u0010b\u001a\u00020(8\u0006@\u0006¢\u0006\f\n\u0004\bb\u0010c\u001a\u0004\bd\u0010eR\u0013\u0010f\u001a\u00020\u00068F@\u0006¢\u0006\u0006\u001a\u0004\bf\u0010BR*\u0010g\u001a\u0002042\u0006\u0010C\u001a\u0002048\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\bg\u0010E\u001a\u0004\bh\u0010G\"\u0004\bi\u00107R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028@@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010o\u001a\u0004\bp\u0010q\"\u0004\br\u0010%¨\u0006y"}, d2 = {"Lokhttp3/internal/http2/Http2Stream;", "", "Lokhttp3/internal/http2/ErrorCode;", RewardItem.KEY_ERROR_CODE, "Ljava/io/IOException;", "errorException", "", "closeInternal", "(Lokhttp3/internal/http2/ErrorCode;Ljava/io/IOException;)Z", "Lokhttp3/Headers;", "takeHeaders", "()Lokhttp3/Headers;", "trailers", "", "Lokhttp3/internal/http2/Header;", "responseHeaders", "outFinished", "flushHeaders", "Lh/t1;", "writeHeaders", "(Ljava/util/List;ZZ)V", "enqueueTrailers", "(Lokhttp3/Headers;)V", "Lj/o0;", "readTimeout", "()Lj/o0;", "writeTimeout", "Lj/m0;", "getSource", "()Lj/m0;", "Lj/k0;", "getSink", "()Lj/k0;", "rstStatusCode", "close", "(Lokhttp3/internal/http2/ErrorCode;Ljava/io/IOException;)V", "closeLater", "(Lokhttp3/internal/http2/ErrorCode;)V", "Lj/o;", MessageKey.MSG_SOURCE, "", "length", "receiveData", "(Lj/o;I)V", "headers", "inFinished", "receiveHeaders", "(Lokhttp3/Headers;Z)V", "receiveRstStream", "cancelStreamIfNecessary$okhttp", "()V", "cancelStreamIfNecessary", "", "delta", "addBytesToWriteWindow", "(J)V", "checkOutNotClosed$okhttp", "checkOutNotClosed", "waitForIo$okhttp", "waitForIo", "Lokhttp3/internal/http2/Http2Stream$FramingSink;", "sink", "Lokhttp3/internal/http2/Http2Stream$FramingSink;", "getSink$okhttp", "()Lokhttp3/internal/http2/Http2Stream$FramingSink;", "isOpen", "()Z", "<set-?>", "readBytesAcknowledged", "J", "getReadBytesAcknowledged", "()J", "setReadBytesAcknowledged$okhttp", "hasResponseHeaders", "Z", "readBytesTotal", "getReadBytesTotal", "setReadBytesTotal$okhttp", "writeBytesTotal", "getWriteBytesTotal", "setWriteBytesTotal$okhttp", "Lokhttp3/internal/http2/Http2Connection;", "connection", "Lokhttp3/internal/http2/Http2Connection;", "getConnection", "()Lokhttp3/internal/http2/Http2Connection;", "Lokhttp3/internal/http2/Http2Stream$FramingSource;", "Lokhttp3/internal/http2/Http2Stream$FramingSource;", "getSource$okhttp", "()Lokhttp3/internal/http2/Http2Stream$FramingSource;", "Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "getReadTimeout$okhttp", "()Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "getWriteTimeout$okhttp", "Ljava/util/ArrayDeque;", "headersQueue", "Ljava/util/ArrayDeque;", "id", ExpandableTextView.P, "getId", "()I", "isLocallyInitiated", "writeBytesMaximum", "getWriteBytesMaximum", "setWriteBytesMaximum$okhttp", "Ljava/io/IOException;", "getErrorException$okhttp", "()Ljava/io/IOException;", "setErrorException$okhttp", "(Ljava/io/IOException;)V", "Lokhttp3/internal/http2/ErrorCode;", "getErrorCode$okhttp", "()Lokhttp3/internal/http2/ErrorCode;", "setErrorCode$okhttp", "<init>", "(ILokhttp3/internal/http2/Http2Connection;ZZLokhttp3/Headers;)V", "Companion", "FramingSink", "FramingSource", "StreamTimeout", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class Http2Stream {
    public static final Companion Companion = new Companion(null);
    public static final long EMIT_BUFFER_SIZE = 16384;
    @d
    private final Http2Connection connection;
    @e
    private ErrorCode errorCode;
    @e
    private IOException errorException;
    private boolean hasResponseHeaders;
    private final ArrayDeque<Headers> headersQueue;
    private final int id;
    private long readBytesAcknowledged;
    private long readBytesTotal;
    @d
    private final StreamTimeout readTimeout;
    @d
    private final FramingSink sink;
    @d
    private final FramingSource source;
    private long writeBytesMaximum;
    private long writeBytesTotal;
    @d
    private final StreamTimeout writeTimeout;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lokhttp3/internal/http2/Http2Stream$Companion;", "", "", "EMIT_BUFFER_SIZE", "J", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010)\u001a\u00020\u001b¢\u0006\u0004\b.\u0010/J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0015\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010)\u001a\u00020\u001b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b)\u0010\u001d\u001a\u0004\b*\u0010\u001f\"\u0004\b+\u0010!R\u0019\u0010,\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\u0016\u001a\u0004\b-\u0010\u0018¨\u00060"}, d2 = {"Lokhttp3/internal/http2/Http2Stream$FramingSource;", "Lj/m0;", "", "read", "Lh/t1;", "updateConnectionFlowControl", "(J)V", "Lj/m;", "sink", "byteCount", "(Lj/m;J)J", "Lj/o;", MessageKey.MSG_SOURCE, "receive$okhttp", "(Lj/o;J)V", "receive", "Lj/o0;", "timeout", "()Lj/o0;", "close", "()V", "readBuffer", "Lj/m;", "getReadBuffer", "()Lj/m;", "maxByteCount", "J", "", "closed", "Z", "getClosed$okhttp", "()Z", "setClosed$okhttp", "(Z)V", "Lokhttp3/Headers;", "trailers", "Lokhttp3/Headers;", "getTrailers", "()Lokhttp3/Headers;", "setTrailers", "(Lokhttp3/Headers;)V", "finished", "getFinished$okhttp", "setFinished$okhttp", "receiveBuffer", "getReceiveBuffer", "<init>", "(Lokhttp3/internal/http2/Http2Stream;JZ)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public final class FramingSource implements m0 {
        private boolean closed;
        private boolean finished;
        private final long maxByteCount;
        @e
        private Headers trailers;
        @d
        private final m receiveBuffer = new m();
        @d
        private final m readBuffer = new m();

        public FramingSource(long j2, boolean z) {
            this.maxByteCount = j2;
            this.finished = z;
        }

        private final void updateConnectionFlowControl(long j2) {
            Http2Stream http2Stream = Http2Stream.this;
            if (Util.assertionsEnabled && Thread.holdsLock(http2Stream)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
            }
            Http2Stream.this.getConnection().updateConnectionFlowControl$okhttp(j2);
        }

        @Override // j.m0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long O0;
            synchronized (Http2Stream.this) {
                this.closed = true;
                O0 = this.readBuffer.O0();
                this.readBuffer.l();
                Http2Stream http2Stream = Http2Stream.this;
                if (http2Stream != null) {
                    http2Stream.notifyAll();
                    t1 t1Var = t1.a;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                }
            }
            if (O0 > 0) {
                updateConnectionFlowControl(O0);
            }
            Http2Stream.this.cancelStreamIfNecessary$okhttp();
        }

        public final boolean getClosed$okhttp() {
            return this.closed;
        }

        public final boolean getFinished$okhttp() {
            return this.finished;
        }

        @d
        public final m getReadBuffer() {
            return this.readBuffer;
        }

        @d
        public final m getReceiveBuffer() {
            return this.receiveBuffer;
        }

        @e
        public final Headers getTrailers() {
            return this.trailers;
        }

        /* JADX WARN: Code restructure failed: missing block: B:45:0x00d9, code lost:
            throw new java.io.IOException("stream closed");
         */
        @Override // j.m0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public long read(@k.e.a.d j.m r18, long r19) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 259
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.FramingSource.read(j.m, long):long");
        }

        public final void receive$okhttp(@d o oVar, long j2) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            long j3;
            Http2Stream http2Stream = Http2Stream.this;
            if (Util.assertionsEnabled && Thread.holdsLock(http2Stream)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
            }
            while (j2 > 0) {
                synchronized (Http2Stream.this) {
                    z = this.finished;
                    z2 = true;
                    z3 = this.readBuffer.O0() + j2 > this.maxByteCount;
                    t1 t1Var = t1.a;
                }
                if (z3) {
                    oVar.skip(j2);
                    Http2Stream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    oVar.skip(j2);
                    return;
                } else {
                    long read = oVar.read(this.receiveBuffer, j2);
                    if (read != -1) {
                        j2 -= read;
                        synchronized (Http2Stream.this) {
                            if (this.closed) {
                                j3 = this.receiveBuffer.O0();
                                this.receiveBuffer.l();
                            } else {
                                if (this.readBuffer.O0() != 0) {
                                    z2 = false;
                                }
                                this.readBuffer.E(this.receiveBuffer);
                                if (z2) {
                                    Http2Stream http2Stream2 = Http2Stream.this;
                                    if (http2Stream2 == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                                    }
                                    http2Stream2.notifyAll();
                                }
                                j3 = 0;
                            }
                        }
                        if (j3 > 0) {
                            updateConnectionFlowControl(j3);
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
        }

        public final void setClosed$okhttp(boolean z) {
            this.closed = z;
        }

        public final void setFinished$okhttp(boolean z) {
            this.finished = z;
        }

        public final void setTrailers(@e Headers headers) {
            this.trailers = headers;
        }

        @Override // j.m0
        @d
        public o0 timeout() {
            return Http2Stream.this.getReadTimeout$okhttp();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u0004¨\u0006\f"}, d2 = {"Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "Lj/k;", "Lh/t1;", "timedOut", "()V", "Ljava/io/IOException;", "cause", "newTimeoutException", "(Ljava/io/IOException;)Ljava/io/IOException;", "exitAndThrowIfTimedOut", "<init>", "(Lokhttp3/internal/http2/Http2Stream;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public final class StreamTimeout extends k {
        public StreamTimeout() {
        }

        public final void exitAndThrowIfTimedOut() throws IOException {
            if (exit()) {
                throw newTimeoutException(null);
            }
        }

        @Override // j.k
        @d
        public IOException newTimeoutException(@e IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // j.k
        public void timedOut() {
            Http2Stream.this.closeLater(ErrorCode.CANCEL);
            Http2Stream.this.getConnection().sendDegradedPingLater$okhttp();
        }
    }

    public Http2Stream(int i2, @d Http2Connection http2Connection, boolean z, boolean z2, @e Headers headers) {
        this.id = i2;
        this.connection = http2Connection;
        this.writeBytesMaximum = http2Connection.getPeerSettings().getInitialWindowSize();
        ArrayDeque<Headers> arrayDeque = new ArrayDeque<>();
        this.headersQueue = arrayDeque;
        this.source = new FramingSource(http2Connection.getOkHttpSettings().getInitialWindowSize(), z2);
        this.sink = new FramingSink(z);
        this.readTimeout = new StreamTimeout();
        this.writeTimeout = new StreamTimeout();
        if (headers != null) {
            if (!isLocallyInitiated()) {
                arrayDeque.add(headers);
                return;
            }
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet".toString());
        } else if (!isLocallyInitiated()) {
            throw new IllegalStateException("remotely-initiated streams should have headers".toString());
        }
    }

    private final boolean closeInternal(ErrorCode errorCode, IOException iOException) {
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            if (this.errorCode != null) {
                return false;
            }
            if (this.source.getFinished$okhttp() && this.sink.getFinished()) {
                return false;
            }
            this.errorCode = errorCode;
            this.errorException = iOException;
            notifyAll();
            t1 t1Var = t1.a;
            this.connection.removeStream$okhttp(this.id);
            return true;
        }
    }

    public final void addBytesToWriteWindow(long j2) {
        this.writeBytesMaximum += j2;
        if (j2 > 0) {
            notifyAll();
        }
    }

    public final void cancelStreamIfNecessary$okhttp() throws IOException {
        boolean z;
        boolean isOpen;
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            z = !this.source.getFinished$okhttp() && this.source.getClosed$okhttp() && (this.sink.getFinished() || this.sink.getClosed());
            isOpen = isOpen();
            t1 t1Var = t1.a;
        }
        if (z) {
            close(ErrorCode.CANCEL, null);
        } else if (isOpen) {
        } else {
            this.connection.removeStream$okhttp(this.id);
        }
    }

    public final void checkOutNotClosed$okhttp() throws IOException {
        if (!this.sink.getClosed()) {
            if (!this.sink.getFinished()) {
                if (this.errorCode != null) {
                    IOException iOException = this.errorException;
                    if (iOException == null) {
                        throw new StreamResetException(this.errorCode);
                    }
                    throw iOException;
                }
                return;
            }
            throw new IOException("stream finished");
        }
        throw new IOException("stream closed");
    }

    public final void close(@d ErrorCode errorCode, @e IOException iOException) throws IOException {
        if (closeInternal(errorCode, iOException)) {
            this.connection.writeSynReset$okhttp(this.id, errorCode);
        }
    }

    public final void closeLater(@d ErrorCode errorCode) {
        if (closeInternal(errorCode, null)) {
            this.connection.writeSynResetLater$okhttp(this.id, errorCode);
        }
    }

    public final void enqueueTrailers(@d Headers headers) {
        synchronized (this) {
            boolean z = true;
            if (!this.sink.getFinished()) {
                if (headers.size() == 0) {
                    z = false;
                }
                if (z) {
                    this.sink.setTrailers(headers);
                    t1 t1Var = t1.a;
                } else {
                    throw new IllegalArgumentException("trailers.size() == 0".toString());
                }
            } else {
                throw new IllegalStateException("already finished".toString());
            }
        }
    }

    @d
    public final Http2Connection getConnection() {
        return this.connection;
    }

    @e
    public final synchronized ErrorCode getErrorCode$okhttp() {
        return this.errorCode;
    }

    @e
    public final IOException getErrorException$okhttp() {
        return this.errorException;
    }

    public final int getId() {
        return this.id;
    }

    public final long getReadBytesAcknowledged() {
        return this.readBytesAcknowledged;
    }

    public final long getReadBytesTotal() {
        return this.readBytesTotal;
    }

    @d
    public final StreamTimeout getReadTimeout$okhttp() {
        return this.readTimeout;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0011 A[Catch: all -> 0x0023, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:11:0x0011, B:15:0x0017, B:16:0x0022), top: B:20:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0017 A[Catch: all -> 0x0023, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:11:0x0011, B:15:0x0017, B:16:0x0022), top: B:20:0x0001 }] */
    @k.e.a.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final j.k0 getSink() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.hasResponseHeaders     // Catch: java.lang.Throwable -> L23
            if (r0 != 0) goto Le
            boolean r0 = r2.isLocallyInitiated()     // Catch: java.lang.Throwable -> L23
            if (r0 == 0) goto Lc
            goto Le
        Lc:
            r0 = 0
            goto Lf
        Le:
            r0 = 1
        Lf:
            if (r0 == 0) goto L17
            h.t1 r0 = h.t1.a     // Catch: java.lang.Throwable -> L23
            monitor-exit(r2)
            okhttp3.internal.http2.Http2Stream$FramingSink r0 = r2.sink
            return r0
        L17:
            java.lang.String r0 = "reply before requesting the sink"
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L23
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L23
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L23
            throw r1     // Catch: java.lang.Throwable -> L23
        L23:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.getSink():j.k0");
    }

    @d
    public final FramingSink getSink$okhttp() {
        return this.sink;
    }

    @d
    public final m0 getSource() {
        return this.source;
    }

    @d
    public final FramingSource getSource$okhttp() {
        return this.source;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    @d
    public final StreamTimeout getWriteTimeout$okhttp() {
        return this.writeTimeout;
    }

    public final boolean isLocallyInitiated() {
        return this.connection.getClient$okhttp() == ((this.id & 1) == 1);
    }

    public final synchronized boolean isOpen() {
        if (this.errorCode != null) {
            return false;
        }
        if ((this.source.getFinished$okhttp() || this.source.getClosed$okhttp()) && (this.sink.getFinished() || this.sink.getClosed())) {
            if (this.hasResponseHeaders) {
                return false;
            }
        }
        return true;
    }

    @d
    public final o0 readTimeout() {
        return this.readTimeout;
    }

    public final void receiveData(@d o oVar, int i2) throws IOException {
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        this.source.receive$okhttp(oVar, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004a A[Catch: all -> 0x0063, TryCatch #0 {, blocks: (B:10:0x0033, B:14:0x003b, B:17:0x004a, B:18:0x004f, B:15:0x0041), top: B:26:0x0033 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void receiveHeaders(@k.e.a.d okhttp3.Headers r3, boolean r4) {
        /*
            r2 = this;
            boolean r0 = okhttp3.internal.Util.assertionsEnabled
            if (r0 == 0) goto L32
            boolean r0 = java.lang.Thread.holdsLock(r2)
            if (r0 != 0) goto Lb
            goto L32
        Lb:
            java.lang.AssertionError r3 = new java.lang.AssertionError
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "Thread "
            r4.append(r0)
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            java.lang.String r0 = r0.getName()
            r4.append(r0)
            java.lang.String r0 = " MUST NOT hold lock on "
            r4.append(r0)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        L32:
            monitor-enter(r2)
            boolean r0 = r2.hasResponseHeaders     // Catch: java.lang.Throwable -> L63
            r1 = 1
            if (r0 == 0) goto L41
            if (r4 != 0) goto L3b
            goto L41
        L3b:
            okhttp3.internal.http2.Http2Stream$FramingSource r0 = r2.source     // Catch: java.lang.Throwable -> L63
            r0.setTrailers(r3)     // Catch: java.lang.Throwable -> L63
            goto L48
        L41:
            r2.hasResponseHeaders = r1     // Catch: java.lang.Throwable -> L63
            java.util.ArrayDeque<okhttp3.Headers> r0 = r2.headersQueue     // Catch: java.lang.Throwable -> L63
            r0.add(r3)     // Catch: java.lang.Throwable -> L63
        L48:
            if (r4 == 0) goto L4f
            okhttp3.internal.http2.Http2Stream$FramingSource r3 = r2.source     // Catch: java.lang.Throwable -> L63
            r3.setFinished$okhttp(r1)     // Catch: java.lang.Throwable -> L63
        L4f:
            boolean r3 = r2.isOpen()     // Catch: java.lang.Throwable -> L63
            r2.notifyAll()     // Catch: java.lang.Throwable -> L63
            h.t1 r4 = h.t1.a     // Catch: java.lang.Throwable -> L63
            monitor-exit(r2)
            if (r3 != 0) goto L62
            okhttp3.internal.http2.Http2Connection r3 = r2.connection
            int r4 = r2.id
            r3.removeStream$okhttp(r4)
        L62:
            return
        L63:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.receiveHeaders(okhttp3.Headers, boolean):void");
    }

    public final synchronized void receiveRstStream(@d ErrorCode errorCode) {
        if (this.errorCode == null) {
            this.errorCode = errorCode;
            notifyAll();
        }
    }

    public final void setErrorCode$okhttp(@e ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public final void setErrorException$okhttp(@e IOException iOException) {
        this.errorException = iOException;
    }

    public final void setReadBytesAcknowledged$okhttp(long j2) {
        this.readBytesAcknowledged = j2;
    }

    public final void setReadBytesTotal$okhttp(long j2) {
        this.readBytesTotal = j2;
    }

    public final void setWriteBytesMaximum$okhttp(long j2) {
        this.writeBytesMaximum = j2;
    }

    public final void setWriteBytesTotal$okhttp(long j2) {
        this.writeBytesTotal = j2;
    }

    @d
    public final synchronized Headers takeHeaders() throws IOException {
        this.readTimeout.enter();
        while (this.headersQueue.isEmpty() && this.errorCode == null) {
            waitForIo$okhttp();
        }
        this.readTimeout.exitAndThrowIfTimedOut();
        if (!this.headersQueue.isEmpty()) {
        } else {
            IOException iOException = this.errorException;
            if (iOException != null) {
                throw iOException;
            }
            throw new StreamResetException(this.errorCode);
        }
        return this.headersQueue.removeFirst();
    }

    @d
    public final synchronized Headers trailers() throws IOException {
        Headers trailers;
        if (this.errorCode != null) {
            IOException iOException = this.errorException;
            if (iOException != null) {
                throw iOException;
            }
            throw new StreamResetException(this.errorCode);
        }
        if (this.source.getFinished$okhttp() && this.source.getReceiveBuffer().b0() && this.source.getReadBuffer().b0()) {
            trailers = this.source.getTrailers();
            if (trailers == null) {
                trailers = Util.EMPTY_HEADERS;
            }
        } else {
            throw new IllegalStateException("too early; can't read the trailers yet".toString());
        }
        return trailers;
    }

    public final void waitForIo$okhttp() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public final void writeHeaders(@d List<Header> list, boolean z, boolean z2) throws IOException {
        boolean z3;
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            this.hasResponseHeaders = true;
            if (z) {
                this.sink.setFinished(true);
            }
            t1 t1Var = t1.a;
        }
        if (!z2) {
            synchronized (this.connection) {
                z3 = this.connection.getWriteBytesTotal() >= this.connection.getWriteBytesMaximum();
            }
            z2 = z3;
        }
        this.connection.writeHeaders$okhttp(this.id, z, list);
        if (z2) {
            this.connection.flush();
        }
    }

    @d
    public final o0 writeTimeout() {
        return this.writeTimeout;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010!\u001a\u00020\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u000eR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u0006R\u0016\u0010\u001f\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u0006¨\u0006&"}, d2 = {"Lokhttp3/internal/http2/Http2Stream$FramingSink;", "Lj/k0;", "", "outFinishedOnLastFrame", "Lh/t1;", "emitFrame", "(Z)V", "Lj/m;", MessageKey.MSG_SOURCE, "", "byteCount", "write", "(Lj/m;J)V", "flush", "()V", "Lj/o0;", "timeout", "()Lj/o0;", "close", "Lokhttp3/Headers;", "trailers", "Lokhttp3/Headers;", "getTrailers", "()Lokhttp3/Headers;", "setTrailers", "(Lokhttp3/Headers;)V", "closed", "Z", "getClosed", "()Z", "setClosed", "sendBuffer", "Lj/m;", "finished", "getFinished", "setFinished", "<init>", "(Lokhttp3/internal/http2/Http2Stream;Z)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public final class FramingSink implements k0 {
        private boolean closed;
        private boolean finished;
        private final m sendBuffer;
        @e
        private Headers trailers;

        public FramingSink(boolean z) {
            this.finished = z;
            this.sendBuffer = new m();
        }

        private final void emitFrame(boolean z) throws IOException {
            long min;
            boolean z2;
            synchronized (Http2Stream.this) {
                Http2Stream.this.getWriteTimeout$okhttp().enter();
                while (Http2Stream.this.getWriteBytesTotal() >= Http2Stream.this.getWriteBytesMaximum() && !this.finished && !this.closed && Http2Stream.this.getErrorCode$okhttp() == null) {
                    Http2Stream.this.waitForIo$okhttp();
                }
                Http2Stream.this.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
                Http2Stream.this.checkOutNotClosed$okhttp();
                min = Math.min(Http2Stream.this.getWriteBytesMaximum() - Http2Stream.this.getWriteBytesTotal(), this.sendBuffer.O0());
                Http2Stream http2Stream = Http2Stream.this;
                http2Stream.setWriteBytesTotal$okhttp(http2Stream.getWriteBytesTotal() + min);
                z2 = z && min == this.sendBuffer.O0() && Http2Stream.this.getErrorCode$okhttp() == null;
                t1 t1Var = t1.a;
            }
            Http2Stream.this.getWriteTimeout$okhttp().enter();
            try {
                Http2Stream.this.getConnection().writeData(Http2Stream.this.getId(), z2, this.sendBuffer, min);
            } finally {
                Http2Stream.this.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
            }
        }

        @Override // j.k0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Http2Stream http2Stream = Http2Stream.this;
            if (Util.assertionsEnabled && Thread.holdsLock(http2Stream)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
            }
            synchronized (Http2Stream.this) {
                if (this.closed) {
                    return;
                }
                boolean z = Http2Stream.this.getErrorCode$okhttp() == null;
                t1 t1Var = t1.a;
                if (!Http2Stream.this.getSink$okhttp().finished) {
                    boolean z2 = this.sendBuffer.O0() > 0;
                    if (this.trailers != null) {
                        while (this.sendBuffer.O0() > 0) {
                            emitFrame(false);
                        }
                        Http2Stream.this.getConnection().writeHeaders$okhttp(Http2Stream.this.getId(), z, Util.toHeaderList(this.trailers));
                    } else if (z2) {
                        while (this.sendBuffer.O0() > 0) {
                            emitFrame(true);
                        }
                    } else if (z) {
                        Http2Stream.this.getConnection().writeData(Http2Stream.this.getId(), true, null, 0L);
                    }
                }
                synchronized (Http2Stream.this) {
                    this.closed = true;
                    t1 t1Var2 = t1.a;
                }
                Http2Stream.this.getConnection().flush();
                Http2Stream.this.cancelStreamIfNecessary$okhttp();
            }
        }

        @Override // j.k0, java.io.Flushable
        public void flush() throws IOException {
            Http2Stream http2Stream = Http2Stream.this;
            if (Util.assertionsEnabled && Thread.holdsLock(http2Stream)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
            }
            synchronized (Http2Stream.this) {
                Http2Stream.this.checkOutNotClosed$okhttp();
                t1 t1Var = t1.a;
            }
            while (this.sendBuffer.O0() > 0) {
                emitFrame(false);
                Http2Stream.this.getConnection().flush();
            }
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final boolean getFinished() {
            return this.finished;
        }

        @e
        public final Headers getTrailers() {
            return this.trailers;
        }

        public final void setClosed(boolean z) {
            this.closed = z;
        }

        public final void setFinished(boolean z) {
            this.finished = z;
        }

        public final void setTrailers(@e Headers headers) {
            this.trailers = headers;
        }

        @Override // j.k0
        @d
        public o0 timeout() {
            return Http2Stream.this.getWriteTimeout$okhttp();
        }

        @Override // j.k0
        public void write(@d m mVar, long j2) throws IOException {
            Http2Stream http2Stream = Http2Stream.this;
            if (Util.assertionsEnabled && Thread.holdsLock(http2Stream)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
            }
            this.sendBuffer.write(mVar, j2);
            while (this.sendBuffer.O0() >= 16384) {
                emitFrame(false);
            }
        }

        public /* synthetic */ FramingSink(Http2Stream http2Stream, boolean z, int i2, u uVar) {
            this((i2 & 1) != 0 ? false : z);
        }
    }
}
