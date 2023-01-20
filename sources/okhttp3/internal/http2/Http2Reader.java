package okhttp3.internal.http2;

import androidx.appcompat.widget.ActivityChooserModel;
import com.baidu.mobads.sdk.internal.bj;
import com.bytedance.msdk.api.reward.RewardItem;
import com.caverock.androidsvg.SVG;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.qiniu.android.collect.ReportItem;
import com.tencent.android.tpush.common.MessageKey;
import h.k2.v.f0;
import h.k2.v.u;
import j.m;
import j.m0;
import j.o;
import j.o0;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import k.e.a.d;
import kotlin.Metadata;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
import okio.ByteString;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 .2\u00020\u0001:\u0003./0B\u0017\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010'\u001a\u00020\u001b¢\u0006\u0004\b,\u0010-J/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ5\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\nJ/\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\nJ\u001f\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J/\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\nJ/\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\nJ/\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\nJ/\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\nJ/\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\nJ/\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\nJ\u0015\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u00061"}, d2 = {"Lokhttp3/internal/http2/Http2Reader;", "Ljava/io/Closeable;", "Lokhttp3/internal/http2/Http2Reader$Handler;", "handler", "", "length", "flags", "streamId", "Lh/t1;", "readHeaders", "(Lokhttp3/internal/http2/Http2Reader$Handler;III)V", "padding", "", "Lokhttp3/internal/http2/Header;", "readHeaderBlock", "(IIII)Ljava/util/List;", "readData", "readPriority", "(Lokhttp3/internal/http2/Http2Reader$Handler;I)V", "readRstStream", "readSettings", "readPushPromise", "readPing", "readGoAway", "readWindowUpdate", "readConnectionPreface", "(Lokhttp3/internal/http2/Http2Reader$Handler;)V", "", "requireSettings", "nextFrame", "(ZLokhttp3/internal/http2/Http2Reader$Handler;)Z", "close", "()V", "Lj/o;", MessageKey.MSG_SOURCE, "Lj/o;", "Lokhttp3/internal/http2/Hpack$Reader;", "hpackReader", "Lokhttp3/internal/http2/Hpack$Reader;", "client", "Z", "Lokhttp3/internal/http2/Http2Reader$ContinuationSource;", "continuation", "Lokhttp3/internal/http2/Http2Reader$ContinuationSource;", "<init>", "(Lj/o;Z)V", "Companion", "ContinuationSource", "Handler", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class Http2Reader implements Closeable {
    public static final Companion Companion = new Companion(null);
    @d
    private static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private final ContinuationSource continuation;
    private final Hpack.Reader hpackReader;
    private final o source;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\t\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/http2/Http2Reader$Companion;", "", "", "length", "flags", "padding", "lengthWithoutPadding", "(III)I", "Ljava/util/logging/Logger;", bj.a, "Ljava/util/logging/Logger;", "getLogger", "()Ljava/util/logging/Logger;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        @d
        public final Logger getLogger() {
            return Http2Reader.logger;
        }

        public final int lengthWithoutPadding(int i2, int i3, int i4) throws IOException {
            if ((i3 & 8) != 0) {
                i2--;
            }
            if (i4 <= i2) {
                return i2 - i4;
            }
            throw new IOException("PROTOCOL_ERROR padding " + i4 + " > remaining length " + i2);
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b%\u0010&J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0004R\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\"\u0010\u001c\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\"\u0010\u001f\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0014\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R\"\u0010\"\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0014\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018¨\u0006'"}, d2 = {"Lokhttp3/internal/http2/Http2Reader$ContinuationSource;", "Lj/m0;", "Lh/t1;", "readContinuationHeader", "()V", "Lj/m;", "sink", "", "byteCount", "read", "(Lj/m;J)J", "Lj/o0;", "timeout", "()Lj/o0;", "close", "Lj/o;", MessageKey.MSG_SOURCE, "Lj/o;", "", "flags", ExpandableTextView.P, "getFlags", "()I", "setFlags", "(I)V", "padding", "getPadding", "setPadding", "length", "getLength", "setLength", "streamId", "getStreamId", "setStreamId", "left", "getLeft", "setLeft", "<init>", "(Lj/o;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class ContinuationSource implements m0 {
        private int flags;
        private int left;
        private int length;
        private int padding;
        private final o source;
        private int streamId;

        public ContinuationSource(@d o oVar) {
            this.source = oVar;
        }

        private final void readContinuationHeader() throws IOException {
            int i2 = this.streamId;
            int readMedium = Util.readMedium(this.source);
            this.left = readMedium;
            this.length = readMedium;
            int and = Util.and(this.source.readByte(), 255);
            this.flags = Util.and(this.source.readByte(), 255);
            Companion companion = Http2Reader.Companion;
            if (companion.getLogger().isLoggable(Level.FINE)) {
                companion.getLogger().fine(Http2.INSTANCE.frameLog(true, this.streamId, this.length, and, this.flags));
            }
            int readInt = this.source.readInt() & Integer.MAX_VALUE;
            this.streamId = readInt;
            if (and == 9) {
                if (readInt != i2) {
                    throw new IOException("TYPE_CONTINUATION streamId changed");
                }
                return;
            }
            throw new IOException(and + " != TYPE_CONTINUATION");
        }

        @Override // j.m0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        public final int getFlags() {
            return this.flags;
        }

        public final int getLeft() {
            return this.left;
        }

        public final int getLength() {
            return this.length;
        }

        public final int getPadding() {
            return this.padding;
        }

        public final int getStreamId() {
            return this.streamId;
        }

        @Override // j.m0
        public long read(@d m mVar, long j2) throws IOException {
            while (true) {
                int i2 = this.left;
                if (i2 == 0) {
                    this.source.skip(this.padding);
                    this.padding = 0;
                    if ((this.flags & 4) != 0) {
                        return -1L;
                    }
                    readContinuationHeader();
                } else {
                    long read = this.source.read(mVar, Math.min(j2, i2));
                    if (read == -1) {
                        return -1L;
                    }
                    this.left -= (int) read;
                    return read;
                }
            }
        }

        public final void setFlags(int i2) {
            this.flags = i2;
        }

        public final void setLeft(int i2) {
            this.left = i2;
        }

        public final void setLength(int i2) {
            this.length = i2;
        }

        public final void setPadding(int i2) {
            this.padding = i2;
        }

        public final void setStreamId(int i2) {
            this.streamId = i2;
        }

        @Override // j.m0
        @d
        public o0 timeout() {
            return this.source.timeout();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\u000bJ5\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\tH&¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H&¢\u0006\u0004\b\u001f\u0010 J'\u0010$\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\"H&¢\u0006\u0004\b$\u0010%J\u001f\u0010(\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&H&¢\u0006\u0004\b(\u0010)J/\u0010-\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0002H&¢\u0006\u0004\b-\u0010.J-\u00101\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00042\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&¢\u0006\u0004\b1\u00102J?\u00109\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\"2\u0006\u00106\u001a\u0002032\u0006\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u00020&H&¢\u0006\u0004\b9\u0010:¨\u0006;"}, d2 = {"Lokhttp3/internal/http2/Http2Reader$Handler;", "", "", "inFinished", "", "streamId", "Lj/o;", MessageKey.MSG_SOURCE, "length", "Lh/t1;", "data", "(ZILj/o;I)V", "associatedStreamId", "", "Lokhttp3/internal/http2/Header;", "headerBlock", "headers", "(ZIILjava/util/List;)V", "Lokhttp3/internal/http2/ErrorCode;", RewardItem.KEY_ERROR_CODE, "rstStream", "(ILokhttp3/internal/http2/ErrorCode;)V", "clearPrevious", "Lokhttp3/internal/http2/Settings;", "settings", "(ZLokhttp3/internal/http2/Settings;)V", "ackSettings", "()V", "ack", "payload1", "payload2", "ping", "(ZII)V", "lastGoodStreamId", "Lokio/ByteString;", "debugData", "goAway", "(ILokhttp3/internal/http2/ErrorCode;Lokio/ByteString;)V", "", "windowSizeIncrement", "windowUpdate", "(IJ)V", "streamDependency", ActivityChooserModel.ATTRIBUTE_WEIGHT, "exclusive", RemoteMessageConst.Notification.PRIORITY, "(IIIZ)V", "promisedStreamId", "requestHeaders", "pushPromise", "(IILjava/util/List;)V", "", "origin", "protocol", ReportItem.RequestKeyHost, "port", "maxAge", "alternateService", "(ILjava/lang/String;Lokio/ByteString;Ljava/lang/String;IJ)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public interface Handler {
        void ackSettings();

        void alternateService(int i2, @d String str, @d ByteString byteString, @d String str2, int i3, long j2);

        void data(boolean z, int i2, @d o oVar, int i3) throws IOException;

        void goAway(int i2, @d ErrorCode errorCode, @d ByteString byteString);

        void headers(boolean z, int i2, int i3, @d List<Header> list);

        void ping(boolean z, int i2, int i3);

        void priority(int i2, int i3, int i4, boolean z);

        void pushPromise(int i2, int i3, @d List<Header> list) throws IOException;

        void rstStream(int i2, @d ErrorCode errorCode);

        void settings(boolean z, @d Settings settings);

        void windowUpdate(int i2, long j2);
    }

    public Http2Reader(@d o oVar, boolean z) {
        this.source = oVar;
        this.client = z;
        ContinuationSource continuationSource = new ContinuationSource(oVar);
        this.continuation = continuationSource;
        this.hpackReader = new Hpack.Reader(continuationSource, 4096, 0, 4, null);
    }

    private final void readData(Handler handler, int i2, int i3, int i4) throws IOException {
        if (i4 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
        }
        boolean z = (i3 & 1) != 0;
        if (!((i3 & 32) != 0)) {
            int and = (i3 & 8) != 0 ? Util.and(this.source.readByte(), 255) : 0;
            handler.data(z, i4, this.source, Companion.lengthWithoutPadding(i2, i3, and));
            this.source.skip(and);
            return;
        }
        throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
    }

    private final void readGoAway(Handler handler, int i2, int i3, int i4) throws IOException {
        if (i2 < 8) {
            throw new IOException("TYPE_GOAWAY length < 8: " + i2);
        } else if (i4 == 0) {
            int readInt = this.source.readInt();
            int readInt2 = this.source.readInt();
            int i5 = i2 - 8;
            ErrorCode fromHttp2 = ErrorCode.Companion.fromHttp2(readInt2);
            if (fromHttp2 != null) {
                ByteString byteString = ByteString.EMPTY;
                if (i5 > 0) {
                    byteString = this.source.V(i5);
                }
                handler.goAway(readInt, fromHttp2, byteString);
                return;
            }
            throw new IOException("TYPE_GOAWAY unexpected error code: " + readInt2);
        } else {
            throw new IOException("TYPE_GOAWAY streamId != 0");
        }
    }

    private final List<Header> readHeaderBlock(int i2, int i3, int i4, int i5) throws IOException {
        this.continuation.setLeft(i2);
        ContinuationSource continuationSource = this.continuation;
        continuationSource.setLength(continuationSource.getLeft());
        this.continuation.setPadding(i3);
        this.continuation.setFlags(i4);
        this.continuation.setStreamId(i5);
        this.hpackReader.readHeaders();
        return this.hpackReader.getAndResetHeaderList();
    }

    private final void readHeaders(Handler handler, int i2, int i3, int i4) throws IOException {
        if (i4 != 0) {
            boolean z = (i3 & 1) != 0;
            int and = (i3 & 8) != 0 ? Util.and(this.source.readByte(), 255) : 0;
            if ((i3 & 32) != 0) {
                readPriority(handler, i4);
                i2 -= 5;
            }
            handler.headers(z, i4, -1, readHeaderBlock(Companion.lengthWithoutPadding(i2, i3, and), and, i3, i4));
            return;
        }
        throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
    }

    private final void readPing(Handler handler, int i2, int i3, int i4) throws IOException {
        if (i2 != 8) {
            throw new IOException("TYPE_PING length != 8: " + i2);
        } else if (i4 == 0) {
            handler.ping((i3 & 1) != 0, this.source.readInt(), this.source.readInt());
        } else {
            throw new IOException("TYPE_PING streamId != 0");
        }
    }

    private final void readPriority(Handler handler, int i2, int i3, int i4) throws IOException {
        if (i2 == 5) {
            if (i4 != 0) {
                readPriority(handler, i4);
                return;
            }
            throw new IOException("TYPE_PRIORITY streamId == 0");
        }
        throw new IOException("TYPE_PRIORITY length: " + i2 + " != 5");
    }

    private final void readPushPromise(Handler handler, int i2, int i3, int i4) throws IOException {
        if (i4 != 0) {
            int and = (i3 & 8) != 0 ? Util.and(this.source.readByte(), 255) : 0;
            handler.pushPromise(i4, this.source.readInt() & Integer.MAX_VALUE, readHeaderBlock(Companion.lengthWithoutPadding(i2 - 4, i3, and), and, i3, i4));
            return;
        }
        throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
    }

    private final void readRstStream(Handler handler, int i2, int i3, int i4) throws IOException {
        if (i2 != 4) {
            throw new IOException("TYPE_RST_STREAM length: " + i2 + " != 4");
        } else if (i4 != 0) {
            int readInt = this.source.readInt();
            ErrorCode fromHttp2 = ErrorCode.Companion.fromHttp2(readInt);
            if (fromHttp2 != null) {
                handler.rstStream(i4, fromHttp2);
                return;
            }
            throw new IOException("TYPE_RST_STREAM unexpected error code: " + readInt);
        } else {
            throw new IOException("TYPE_RST_STREAM streamId == 0");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x007a, code lost:
        throw new java.io.IOException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: " + r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void readSettings(okhttp3.internal.http2.Http2Reader.Handler r8, int r9, int r10, int r11) throws java.io.IOException {
        /*
            r7 = this;
            if (r11 != 0) goto Lb8
            r11 = 1
            r10 = r10 & r11
            if (r10 == 0) goto L14
            if (r9 != 0) goto Lc
            r8.ackSettings()
            return
        Lc:
            java.io.IOException r8 = new java.io.IOException
            java.lang.String r9 = "FRAME_SIZE_ERROR ack frame should be empty!"
            r8.<init>(r9)
            throw r8
        L14:
            int r10 = r9 % 6
            if (r10 != 0) goto La1
            okhttp3.internal.http2.Settings r10 = new okhttp3.internal.http2.Settings
            r10.<init>()
            r0 = 0
            h.o2.k r9 = h.o2.q.n1(r0, r9)
            r1 = 6
            h.o2.i r9 = h.o2.q.S0(r9, r1)
            int r1 = r9.d()
            int r2 = r9.f()
            int r9 = r9.g()
            if (r9 < 0) goto L38
            if (r1 > r2) goto L9d
            goto L3a
        L38:
            if (r1 < r2) goto L9d
        L3a:
            j.o r3 = r7.source
            short r3 = r3.readShort()
            r4 = 65535(0xffff, float:9.1834E-41)
            int r3 = okhttp3.internal.Util.and(r3, r4)
            j.o r4 = r7.source
            int r4 = r4.readInt()
            r5 = 2
            r6 = 4
            if (r3 == r5) goto L89
            r5 = 3
            if (r3 == r5) goto L87
            if (r3 == r6) goto L7b
            r5 = 5
            if (r3 == r5) goto L5a
            goto L96
        L5a:
            r5 = 16384(0x4000, float:2.2959E-41)
            if (r4 < r5) goto L64
            r5 = 16777215(0xffffff, float:2.3509886E-38)
            if (r4 > r5) goto L64
            goto L96
        L64:
            java.io.IOException r8 = new java.io.IOException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: "
            r9.append(r10)
            r9.append(r4)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        L7b:
            r3 = 7
            if (r4 < 0) goto L7f
            goto L96
        L7f:
            java.io.IOException r8 = new java.io.IOException
            java.lang.String r9 = "PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1"
            r8.<init>(r9)
            throw r8
        L87:
            r3 = 4
            goto L96
        L89:
            if (r4 == 0) goto L96
            if (r4 != r11) goto L8e
            goto L96
        L8e:
            java.io.IOException r8 = new java.io.IOException
            java.lang.String r9 = "PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1"
            r8.<init>(r9)
            throw r8
        L96:
            r10.set(r3, r4)
            if (r1 == r2) goto L9d
            int r1 = r1 + r9
            goto L3a
        L9d:
            r8.settings(r0, r10)
            return
        La1:
            java.io.IOException r8 = new java.io.IOException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "TYPE_SETTINGS length % 6 != 0: "
            r10.append(r11)
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            r8.<init>(r9)
            throw r8
        Lb8:
            java.io.IOException r8 = new java.io.IOException
            java.lang.String r9 = "TYPE_SETTINGS streamId != 0"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Reader.readSettings(okhttp3.internal.http2.Http2Reader$Handler, int, int, int):void");
    }

    private final void readWindowUpdate(Handler handler, int i2, int i3, int i4) throws IOException {
        if (i2 == 4) {
            long and = Util.and(this.source.readInt(), 2147483647L);
            if (and != 0) {
                handler.windowUpdate(i4, and);
                return;
            }
            throw new IOException("windowSizeIncrement was 0");
        }
        throw new IOException("TYPE_WINDOW_UPDATE length !=4: " + i2);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.source.close();
    }

    public final boolean nextFrame(boolean z, @d Handler handler) throws IOException {
        try {
            this.source.R(9L);
            int readMedium = Util.readMedium(this.source);
            if (readMedium <= 16384) {
                int and = Util.and(this.source.readByte(), 255);
                int and2 = Util.and(this.source.readByte(), 255);
                int readInt = this.source.readInt() & Integer.MAX_VALUE;
                Logger logger2 = logger;
                if (logger2.isLoggable(Level.FINE)) {
                    logger2.fine(Http2.INSTANCE.frameLog(true, readInt, readMedium, and, and2));
                }
                if (z && and != 4) {
                    throw new IOException("Expected a SETTINGS frame but was " + Http2.INSTANCE.formattedType$okhttp(and));
                }
                switch (and) {
                    case 0:
                        readData(handler, readMedium, and2, readInt);
                        return true;
                    case 1:
                        readHeaders(handler, readMedium, and2, readInt);
                        return true;
                    case 2:
                        readPriority(handler, readMedium, and2, readInt);
                        return true;
                    case 3:
                        readRstStream(handler, readMedium, and2, readInt);
                        return true;
                    case 4:
                        readSettings(handler, readMedium, and2, readInt);
                        return true;
                    case 5:
                        readPushPromise(handler, readMedium, and2, readInt);
                        return true;
                    case 6:
                        readPing(handler, readMedium, and2, readInt);
                        return true;
                    case 7:
                        readGoAway(handler, readMedium, and2, readInt);
                        return true;
                    case 8:
                        readWindowUpdate(handler, readMedium, and2, readInt);
                        return true;
                    default:
                        this.source.skip(readMedium);
                        return true;
                }
            }
            throw new IOException("FRAME_SIZE_ERROR: " + readMedium);
        } catch (EOFException unused) {
            return false;
        }
    }

    public final void readConnectionPreface(@d Handler handler) throws IOException {
        if (this.client) {
            if (!nextFrame(true, handler)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            return;
        }
        o oVar = this.source;
        ByteString byteString = Http2.CONNECTION_PREFACE;
        ByteString V = oVar.V(byteString.size());
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(Util.format("<< CONNECTION " + V.hex(), new Object[0]));
        }
        if (!f0.g(byteString, V)) {
            throw new IOException("Expected a connection header but was " + V.utf8());
        }
    }

    private final void readPriority(Handler handler, int i2) throws IOException {
        int readInt = this.source.readInt();
        handler.priority(i2, readInt & Integer.MAX_VALUE, Util.and(this.source.readByte(), 255) + 1, (readInt & ((int) SVG.S)) != 0);
    }
}
