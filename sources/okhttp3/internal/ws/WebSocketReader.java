package okhttp3.internal.ws;

import com.bytedance.msdk.api.reward.RewardItem;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.tencent.android.tpush.common.MessageKey;
import j.m;
import j.o;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import k.e.a.d;
import kotlin.Metadata;
import okhttp3.internal.Util;
import okio.ByteString;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u00011B/\u0012\u0006\u0010.\u001a\u00020\u0013\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010 \u001a\u00020\u0013¢\u0006\u0004\b/\u00100J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0004J\r\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004R\u0019\u0010\f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0015R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u0015R\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010\u0015R\u0018\u0010)\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010\u0015¨\u00062"}, d2 = {"Lokhttp3/internal/ws/WebSocketReader;", "Ljava/io/Closeable;", "Lh/t1;", "readHeader", "()V", "readControlFrame", "readMessageFrame", "readUntilNonControlFrame", "readMessage", "processNextFrame", "close", "Lj/o;", MessageKey.MSG_SOURCE, "Lj/o;", "getSource", "()Lj/o;", "Lj/m;", "controlFrameBuffer", "Lj/m;", "", "perMessageDeflate", "Z", "isFinalFrame", "isControlFrame", "messageFrameBuffer", "", "opcode", ExpandableTextView.P, "readingCompressedMessage", "Lj/m$a;", "maskCursor", "Lj/m$a;", "noContextTakeover", "Lokhttp3/internal/ws/MessageInflater;", "messageInflater", "Lokhttp3/internal/ws/MessageInflater;", "", "frameLength", "J", "closed", "", "maskKey", "[B", "Lokhttp3/internal/ws/WebSocketReader$FrameCallback;", "frameCallback", "Lokhttp3/internal/ws/WebSocketReader$FrameCallback;", "isClient", "<init>", "(ZLj/o;Lokhttp3/internal/ws/WebSocketReader$FrameCallback;ZZ)V", "FrameCallback", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class WebSocketReader implements Closeable {
    private boolean closed;
    private final FrameCallback frameCallback;
    private long frameLength;
    private final boolean isClient;
    private boolean isControlFrame;
    private boolean isFinalFrame;
    private final m.a maskCursor;
    private final byte[] maskKey;
    private MessageInflater messageInflater;
    private final boolean noContextTakeover;
    private int opcode;
    private final boolean perMessageDeflate;
    private boolean readingCompressedMessage;
    @d
    private final o source;
    private final m controlFrameBuffer = new m();
    private final m messageFrameBuffer = new m();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0005\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\tJ\u001f\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002H&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lokhttp3/internal/ws/WebSocketReader$FrameCallback;", "", "", "text", "Lh/t1;", "onReadMessage", "(Ljava/lang/String;)V", "Lokio/ByteString;", "bytes", "(Lokio/ByteString;)V", "payload", "onReadPing", "onReadPong", "", "code", RewardItem.KEY_REASON, "onReadClose", "(ILjava/lang/String;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public interface FrameCallback {
        void onReadClose(int i2, @d String str);

        void onReadMessage(@d String str) throws IOException;

        void onReadMessage(@d ByteString byteString) throws IOException;

        void onReadPing(@d ByteString byteString);

        void onReadPong(@d ByteString byteString);
    }

    public WebSocketReader(boolean z, @d o oVar, @d FrameCallback frameCallback, boolean z2, boolean z3) {
        this.isClient = z;
        this.source = oVar;
        this.frameCallback = frameCallback;
        this.perMessageDeflate = z2;
        this.noContextTakeover = z3;
        this.maskKey = z ? null : new byte[4];
        this.maskCursor = z ? null : new m.a();
    }

    private final void readControlFrame() throws IOException {
        String str;
        long j2 = this.frameLength;
        if (j2 > 0) {
            this.source.h(this.controlFrameBuffer, j2);
            if (!this.isClient) {
                this.controlFrameBuffer.C0(this.maskCursor);
                this.maskCursor.l(0L);
                WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        }
        switch (this.opcode) {
            case 8:
                short s = 1005;
                long O0 = this.controlFrameBuffer.O0();
                if (O0 != 1) {
                    if (O0 != 0) {
                        s = this.controlFrameBuffer.readShort();
                        str = this.controlFrameBuffer.p0();
                        String closeCodeExceptionMessage = WebSocketProtocol.INSTANCE.closeCodeExceptionMessage(s);
                        if (closeCodeExceptionMessage != null) {
                            throw new ProtocolException(closeCodeExceptionMessage);
                        }
                    } else {
                        str = "";
                    }
                    this.frameCallback.onReadClose(s, str);
                    this.closed = true;
                    return;
                }
                throw new ProtocolException("Malformed close payload length of 1.");
            case 9:
                this.frameCallback.onReadPing(this.controlFrameBuffer.j0());
                return;
            case 10:
                this.frameCallback.onReadPong(this.controlFrameBuffer.j0());
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + Util.toHexString(this.opcode));
        }
    }

    private final void readHeader() throws IOException, ProtocolException {
        boolean z;
        if (!this.closed) {
            long timeoutNanos = this.source.timeout().timeoutNanos();
            this.source.timeout().clearTimeout();
            try {
                int and = Util.and(this.source.readByte(), 255);
                this.source.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                int i2 = and & 15;
                this.opcode = i2;
                boolean z2 = (and & 128) != 0;
                this.isFinalFrame = z2;
                boolean z3 = (and & 8) != 0;
                this.isControlFrame = z3;
                if (z3 && !z2) {
                    throw new ProtocolException("Control frames must be final.");
                }
                boolean z4 = (and & 64) != 0;
                if (i2 == 1 || i2 == 2) {
                    if (!z4) {
                        z = false;
                    } else if (!this.perMessageDeflate) {
                        throw new ProtocolException("Unexpected rsv1 flag");
                    } else {
                        z = true;
                    }
                    this.readingCompressedMessage = z;
                } else if (z4) {
                    throw new ProtocolException("Unexpected rsv1 flag");
                }
                if ((and & 32) != 0) {
                    throw new ProtocolException("Unexpected rsv2 flag");
                }
                if (!((and & 16) != 0)) {
                    int and2 = Util.and(this.source.readByte(), 255);
                    boolean z5 = (and2 & 128) != 0;
                    if (z5 == this.isClient) {
                        throw new ProtocolException(this.isClient ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
                    }
                    long j2 = and2 & 127;
                    this.frameLength = j2;
                    if (j2 == 126) {
                        this.frameLength = Util.and(this.source.readShort(), 65535);
                    } else if (j2 == 127) {
                        long readLong = this.source.readLong();
                        this.frameLength = readLong;
                        if (readLong < 0) {
                            throw new ProtocolException("Frame length 0x" + Util.toHexString(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF");
                        }
                    }
                    if (this.isControlFrame && this.frameLength > 125) {
                        throw new ProtocolException("Control frame must be less than 125B.");
                    }
                    if (z5) {
                        this.source.readFully(this.maskKey);
                        return;
                    }
                    return;
                }
                throw new ProtocolException("Unexpected rsv3 flag");
            } catch (Throwable th) {
                this.source.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                throw th;
            }
        }
        throw new IOException("closed");
    }

    private final void readMessage() throws IOException {
        while (!this.closed) {
            long j2 = this.frameLength;
            if (j2 > 0) {
                this.source.h(this.messageFrameBuffer, j2);
                if (!this.isClient) {
                    this.messageFrameBuffer.C0(this.maskCursor);
                    this.maskCursor.l(this.messageFrameBuffer.O0() - this.frameLength);
                    WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                    this.maskCursor.close();
                }
            }
            if (this.isFinalFrame) {
                return;
            }
            readUntilNonControlFrame();
            if (this.opcode != 0) {
                throw new ProtocolException("Expected continuation opcode. Got: " + Util.toHexString(this.opcode));
            }
        }
        throw new IOException("closed");
    }

    private final void readMessageFrame() throws IOException {
        int i2 = this.opcode;
        if (i2 != 1 && i2 != 2) {
            throw new ProtocolException("Unknown opcode: " + Util.toHexString(i2));
        }
        readMessage();
        if (this.readingCompressedMessage) {
            MessageInflater messageInflater = this.messageInflater;
            if (messageInflater == null) {
                messageInflater = new MessageInflater(this.noContextTakeover);
                this.messageInflater = messageInflater;
            }
            messageInflater.inflate(this.messageFrameBuffer);
        }
        if (i2 == 1) {
            this.frameCallback.onReadMessage(this.messageFrameBuffer.p0());
        } else {
            this.frameCallback.onReadMessage(this.messageFrameBuffer.j0());
        }
    }

    private final void readUntilNonControlFrame() throws IOException {
        while (!this.closed) {
            readHeader();
            if (!this.isControlFrame) {
                return;
            }
            readControlFrame();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        MessageInflater messageInflater = this.messageInflater;
        if (messageInflater != null) {
            messageInflater.close();
        }
    }

    @d
    public final o getSource() {
        return this.source;
    }

    public final void processNextFrame() throws IOException {
        readHeader();
        if (this.isControlFrame) {
            readControlFrame();
        } else {
            readMessageFrame();
        }
    }
}
