package okhttp3.internal.http2;

import com.baidu.mobads.sdk.internal.bj;
import com.bytedance.msdk.api.reward.RewardItem;
import com.caverock.androidsvg.SVG;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.tencent.android.tpush.common.MessageKey;
import h.k2.v.u;
import j.m;
import j.n;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0012\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 L2\u00020\u0001:\u0001LB\u0017\u0012\u0006\u0010A\u001a\u00020@\u0012\u0006\u0010?\u001a\u00020\u001c¢\u0006\u0004\bJ\u0010KJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\nJ\u001d\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ/\u0010 \u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b \u0010!J/\u0010$\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u00022\b\u0010#\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b$\u0010%J\u0015\u0010&\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u000b¢\u0006\u0004\b&\u0010\u000eJ%\u0010*\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u0002¢\u0006\u0004\b*\u0010+J%\u0010/\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b/\u00100J\u001d\u00102\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u0004¢\u0006\u0004\b2\u0010\bJ-\u00105\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u00022\u0006\u00104\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0002¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u0006H\u0016¢\u0006\u0004\b7\u0010\nJ+\u00109\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b9\u0010:R\u0016\u0010;\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010=\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010?\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010>R\u0016\u0010A\u001a\u00020@8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0019\u0010D\u001a\u00020C8\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u0016\u0010H\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010I¨\u0006M"}, d2 = {"Lokhttp3/internal/http2/Http2Writer;", "Ljava/io/Closeable;", "", "streamId", "", "byteCount", "Lh/t1;", "writeContinuationFrames", "(IJ)V", "connectionPreface", "()V", "Lokhttp3/internal/http2/Settings;", "peerSettings", "applyAndAckSettings", "(Lokhttp3/internal/http2/Settings;)V", "promisedStreamId", "", "Lokhttp3/internal/http2/Header;", "requestHeaders", "pushPromise", "(IILjava/util/List;)V", "flush", "Lokhttp3/internal/http2/ErrorCode;", RewardItem.KEY_ERROR_CODE, "rstStream", "(ILokhttp3/internal/http2/ErrorCode;)V", "maxDataLength", "()I", "", "outFinished", "Lj/m;", MessageKey.MSG_SOURCE, "data", "(ZILj/m;I)V", "flags", "buffer", "dataFrame", "(IILj/m;I)V", "settings", "ack", "payload1", "payload2", "ping", "(ZII)V", "lastGoodStreamId", "", "debugData", "goAway", "(ILokhttp3/internal/http2/ErrorCode;[B)V", "windowSizeIncrement", "windowUpdate", "length", "type", "frameHeader", "(IIII)V", "close", "headerBlock", "headers", "(ZILjava/util/List;)V", "maxFrameSize", ExpandableTextView.P, "closed", "Z", "client", "Lj/n;", "sink", "Lj/n;", "Lokhttp3/internal/http2/Hpack$Writer;", "hpackWriter", "Lokhttp3/internal/http2/Hpack$Writer;", "getHpackWriter", "()Lokhttp3/internal/http2/Hpack$Writer;", "hpackBuffer", "Lj/m;", "<init>", "(Lj/n;Z)V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class Http2Writer implements Closeable {
    public static final Companion Companion = new Companion(null);
    private static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private boolean closed;
    private final m hpackBuffer;
    @d
    private final Hpack.Writer hpackWriter;
    private int maxFrameSize;
    private final n sink;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lokhttp3/internal/http2/Http2Writer$Companion;", "", "Ljava/util/logging/Logger;", "kotlin.jvm.PlatformType", bj.a, "Ljava/util/logging/Logger;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }
    }

    public Http2Writer(@d n nVar, boolean z) {
        this.sink = nVar;
        this.client = z;
        m mVar = new m();
        this.hpackBuffer = mVar;
        this.maxFrameSize = 16384;
        this.hpackWriter = new Hpack.Writer(0, false, mVar, 3, null);
    }

    private final void writeContinuationFrames(int i2, long j2) throws IOException {
        while (j2 > 0) {
            long min = Math.min(this.maxFrameSize, j2);
            j2 -= min;
            frameHeader(i2, (int) min, 9, j2 == 0 ? 4 : 0);
            this.sink.write(this.hpackBuffer, min);
        }
    }

    public final synchronized void applyAndAckSettings(@d Settings settings) throws IOException {
        if (!this.closed) {
            this.maxFrameSize = settings.getMaxFrameSize(this.maxFrameSize);
            if (settings.getHeaderTableSize() != -1) {
                this.hpackWriter.resizeHeaderTable(settings.getHeaderTableSize());
            }
            frameHeader(0, 0, 4, 1);
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.closed = true;
        this.sink.close();
    }

    public final synchronized void connectionPreface() throws IOException {
        if (!this.closed) {
            if (this.client) {
                Logger logger2 = logger;
                if (logger2.isLoggable(Level.FINE)) {
                    logger2.fine(Util.format(">> CONNECTION " + Http2.CONNECTION_PREFACE.hex(), new Object[0]));
                }
                this.sink.r0(Http2.CONNECTION_PREFACE);
                this.sink.flush();
                return;
            }
            return;
        }
        throw new IOException("closed");
    }

    public final synchronized void data(boolean z, int i2, @e m mVar, int i3) throws IOException {
        if (!this.closed) {
            dataFrame(i2, z ? 1 : 0, mVar, i3);
        } else {
            throw new IOException("closed");
        }
    }

    public final void dataFrame(int i2, int i3, @e m mVar, int i4) throws IOException {
        frameHeader(i2, i4, 0, i3);
        if (i4 > 0) {
            this.sink.write(mVar, i4);
        }
    }

    public final synchronized void flush() throws IOException {
        if (!this.closed) {
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final void frameHeader(int i2, int i3, int i4, int i5) throws IOException {
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(Http2.INSTANCE.frameLog(false, i2, i3, i4, i5));
        }
        if (!(i3 <= this.maxFrameSize)) {
            throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.maxFrameSize + ": " + i3).toString());
        }
        if ((((int) SVG.S) & i2) == 0) {
            Util.writeMedium(this.sink, i3);
            this.sink.writeByte(i4 & 255);
            this.sink.writeByte(i5 & 255);
            this.sink.writeInt(i2 & Integer.MAX_VALUE);
            return;
        }
        throw new IllegalArgumentException(("reserved bit set: " + i2).toString());
    }

    @d
    public final Hpack.Writer getHpackWriter() {
        return this.hpackWriter;
    }

    public final synchronized void goAway(int i2, @d ErrorCode errorCode, @d byte[] bArr) throws IOException {
        if (!this.closed) {
            if (errorCode.getHttpCode() != -1) {
                frameHeader(0, bArr.length + 8, 7, 0);
                this.sink.writeInt(i2);
                this.sink.writeInt(errorCode.getHttpCode());
                if (!(bArr.length == 0)) {
                    this.sink.write(bArr);
                }
                this.sink.flush();
            } else {
                throw new IllegalArgumentException("errorCode.httpCode == -1".toString());
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void headers(boolean z, int i2, @d List<Header> list) throws IOException {
        if (!this.closed) {
            this.hpackWriter.writeHeaders(list);
            long O0 = this.hpackBuffer.O0();
            long min = Math.min(this.maxFrameSize, O0);
            int i3 = (O0 > min ? 1 : (O0 == min ? 0 : -1));
            int i4 = i3 == 0 ? 4 : 0;
            if (z) {
                i4 |= 1;
            }
            frameHeader(i2, (int) min, 1, i4);
            this.sink.write(this.hpackBuffer, min);
            if (i3 > 0) {
                writeContinuationFrames(i2, O0 - min);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final int maxDataLength() {
        return this.maxFrameSize;
    }

    public final synchronized void ping(boolean z, int i2, int i3) throws IOException {
        if (!this.closed) {
            frameHeader(0, 8, 6, z ? 1 : 0);
            this.sink.writeInt(i2);
            this.sink.writeInt(i3);
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void pushPromise(int i2, int i3, @d List<Header> list) throws IOException {
        if (!this.closed) {
            this.hpackWriter.writeHeaders(list);
            long O0 = this.hpackBuffer.O0();
            int min = (int) Math.min(this.maxFrameSize - 4, O0);
            int i4 = min + 4;
            long j2 = min;
            int i5 = (O0 > j2 ? 1 : (O0 == j2 ? 0 : -1));
            frameHeader(i2, i4, 5, i5 == 0 ? 4 : 0);
            this.sink.writeInt(i3 & Integer.MAX_VALUE);
            this.sink.write(this.hpackBuffer, j2);
            if (i5 > 0) {
                writeContinuationFrames(i2, O0 - j2);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void rstStream(int i2, @d ErrorCode errorCode) throws IOException {
        if (!this.closed) {
            if (errorCode.getHttpCode() != -1) {
                frameHeader(i2, 4, 3, 0);
                this.sink.writeInt(errorCode.getHttpCode());
                this.sink.flush();
            } else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void settings(@d Settings settings) throws IOException {
        if (!this.closed) {
            int i2 = 0;
            frameHeader(0, settings.size() * 6, 4, 0);
            while (i2 < 10) {
                if (settings.isSet(i2)) {
                    this.sink.writeShort(i2 != 4 ? i2 != 7 ? i2 : 4 : 3);
                    this.sink.writeInt(settings.get(i2));
                }
                i2++;
            }
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void windowUpdate(int i2, long j2) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        if (j2 != 0 && j2 <= 2147483647L) {
            frameHeader(i2, 4, 8, 0);
            this.sink.writeInt((int) j2);
            this.sink.flush();
        } else {
            throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j2).toString());
        }
    }
}
