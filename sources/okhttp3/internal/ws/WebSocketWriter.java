package okhttp3.internal.ws;

import com.bytedance.msdk.api.reward.RewardItem;
import j.m;
import j.n;
import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import okio.ByteString;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010!\u001a\u00020\u0019\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010/\u001a\u00020\u0019\u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b4\u00105J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\nJ\u001f\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000e\u0010\bJ\u001d\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\bJ\u000f\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0015\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001bR\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010)\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010\u001bR\u0016\u0010/\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010\u001bR\u0016\u00100\u001a\u00020%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010'R\u0018\u00102\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103¨\u00066"}, d2 = {"Lokhttp3/internal/ws/WebSocketWriter;", "Ljava/io/Closeable;", "", "opcode", "Lokio/ByteString;", "payload", "Lh/t1;", "writeControlFrame", "(ILokio/ByteString;)V", "writePing", "(Lokio/ByteString;)V", "writePong", "code", RewardItem.KEY_REASON, "writeClose", "formatOpcode", "data", "writeMessageFrame", "close", "()V", "Ljava/util/Random;", "random", "Ljava/util/Random;", "getRandom", "()Ljava/util/Random;", "", "perMessageDeflate", "Z", "Lj/n;", "sink", "Lj/n;", "getSink", "()Lj/n;", "isClient", "", "minimumDeflateSize", "J", "Lj/m;", "sinkBuffer", "Lj/m;", "Lj/m$a;", "maskCursor", "Lj/m$a;", "", "maskKey", "[B", "writerClosed", "noContextTakeover", "messageBuffer", "Lokhttp3/internal/ws/MessageDeflater;", "messageDeflater", "Lokhttp3/internal/ws/MessageDeflater;", "<init>", "(ZLj/n;Ljava/util/Random;ZZJ)V", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class WebSocketWriter implements Closeable {
    private final boolean isClient;
    private final m.a maskCursor;
    private final byte[] maskKey;
    private final m messageBuffer = new m();
    private MessageDeflater messageDeflater;
    private final long minimumDeflateSize;
    private final boolean noContextTakeover;
    private final boolean perMessageDeflate;
    @d
    private final Random random;
    @d
    private final n sink;
    private final m sinkBuffer;
    private boolean writerClosed;

    public WebSocketWriter(boolean z, @d n nVar, @d Random random, boolean z2, boolean z3, long j2) {
        this.isClient = z;
        this.sink = nVar;
        this.random = random;
        this.perMessageDeflate = z2;
        this.noContextTakeover = z3;
        this.minimumDeflateSize = j2;
        this.sinkBuffer = nVar.getBuffer();
        this.maskKey = z ? new byte[4] : null;
        this.maskCursor = z ? new m.a() : null;
    }

    private final void writeControlFrame(int i2, ByteString byteString) throws IOException {
        if (!this.writerClosed) {
            int size = byteString.size();
            if (((long) size) <= 125) {
                this.sinkBuffer.writeByte(i2 | 128);
                if (this.isClient) {
                    this.sinkBuffer.writeByte(size | 128);
                    this.random.nextBytes(this.maskKey);
                    this.sinkBuffer.write(this.maskKey);
                    if (size > 0) {
                        long O0 = this.sinkBuffer.O0();
                        this.sinkBuffer.r0(byteString);
                        this.sinkBuffer.C0(this.maskCursor);
                        this.maskCursor.l(O0);
                        WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                        this.maskCursor.close();
                    }
                } else {
                    this.sinkBuffer.writeByte(size);
                    this.sinkBuffer.r0(byteString);
                }
                this.sink.flush();
                return;
            }
            throw new IllegalArgumentException("Payload size must be less than or equal to 125".toString());
        }
        throw new IOException("closed");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        MessageDeflater messageDeflater = this.messageDeflater;
        if (messageDeflater != null) {
            messageDeflater.close();
        }
    }

    @d
    public final Random getRandom() {
        return this.random;
    }

    @d
    public final n getSink() {
        return this.sink;
    }

    public final void writeClose(int i2, @e ByteString byteString) throws IOException {
        ByteString byteString2 = ByteString.EMPTY;
        if (i2 != 0 || byteString != null) {
            if (i2 != 0) {
                WebSocketProtocol.INSTANCE.validateCloseCode(i2);
            }
            m mVar = new m();
            mVar.writeShort(i2);
            if (byteString != null) {
                mVar.r0(byteString);
            }
            byteString2 = mVar.j0();
        }
        try {
            writeControlFrame(8, byteString2);
        } finally {
            this.writerClosed = true;
        }
    }

    public final void writeMessageFrame(int i2, @d ByteString byteString) throws IOException {
        if (!this.writerClosed) {
            this.messageBuffer.r0(byteString);
            int i3 = i2 | 128;
            if (this.perMessageDeflate && byteString.size() >= this.minimumDeflateSize) {
                MessageDeflater messageDeflater = this.messageDeflater;
                if (messageDeflater == null) {
                    messageDeflater = new MessageDeflater(this.noContextTakeover);
                    this.messageDeflater = messageDeflater;
                }
                messageDeflater.deflate(this.messageBuffer);
                i3 |= 64;
            }
            long O0 = this.messageBuffer.O0();
            this.sinkBuffer.writeByte(i3);
            int i4 = this.isClient ? 128 : 0;
            if (O0 <= 125) {
                this.sinkBuffer.writeByte(((int) O0) | i4);
            } else if (O0 <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                this.sinkBuffer.writeByte(i4 | 126);
                this.sinkBuffer.writeShort((int) O0);
            } else {
                this.sinkBuffer.writeByte(i4 | 127);
                this.sinkBuffer.t0(O0);
            }
            if (this.isClient) {
                this.random.nextBytes(this.maskKey);
                this.sinkBuffer.write(this.maskKey);
                if (O0 > 0) {
                    this.messageBuffer.C0(this.maskCursor);
                    this.maskCursor.l(0L);
                    WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                    this.maskCursor.close();
                }
            }
            this.sinkBuffer.write(this.messageBuffer, O0);
            this.sink.v();
            return;
        }
        throw new IOException("closed");
    }

    public final void writePing(@d ByteString byteString) throws IOException {
        writeControlFrame(9, byteString);
    }

    public final void writePong(@d ByteString byteString) throws IOException {
        writeControlFrame(10, byteString);
    }
}
