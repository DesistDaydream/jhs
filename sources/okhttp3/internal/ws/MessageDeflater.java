package okhttp3.internal.ws;

import h.h2.b;
import j.k0;
import j.m;
import j.p;
import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Deflater;
import k.e.a.d;
import kotlin.Metadata;
import okio.ByteString;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lokhttp3/internal/ws/MessageDeflater;", "Ljava/io/Closeable;", "Lj/m;", "Lokio/ByteString;", "suffix", "", "endsWith", "(Lj/m;Lokio/ByteString;)Z", "buffer", "Lh/t1;", "deflate", "(Lj/m;)V", "close", "()V", "Ljava/util/zip/Deflater;", "deflater", "Ljava/util/zip/Deflater;", "Lj/p;", "deflaterSink", "Lj/p;", "deflatedBytes", "Lj/m;", "noContextTakeover", "Z", "<init>", "(Z)V", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class MessageDeflater implements Closeable {
    private final m deflatedBytes;
    private final Deflater deflater;
    private final p deflaterSink;
    private final boolean noContextTakeover;

    public MessageDeflater(boolean z) {
        this.noContextTakeover = z;
        m mVar = new m();
        this.deflatedBytes = mVar;
        Deflater deflater = new Deflater(-1, true);
        this.deflater = deflater;
        this.deflaterSink = new p((k0) mVar, deflater);
    }

    private final boolean endsWith(m mVar, ByteString byteString) {
        return mVar.C(mVar.O0() - byteString.size(), byteString);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.deflaterSink.close();
    }

    public final void deflate(@d m mVar) throws IOException {
        ByteString byteString;
        if (this.deflatedBytes.O0() == 0) {
            if (this.noContextTakeover) {
                this.deflater.reset();
            }
            this.deflaterSink.write(mVar, mVar.O0());
            this.deflaterSink.flush();
            m mVar2 = this.deflatedBytes;
            byteString = MessageDeflaterKt.EMPTY_DEFLATE_BLOCK;
            if (endsWith(mVar2, byteString)) {
                long O0 = this.deflatedBytes.O0() - 4;
                m.a D0 = m.D0(this.deflatedBytes, null, 1, null);
                try {
                    D0.k(O0);
                    b.a(D0, null);
                } finally {
                }
            } else {
                this.deflatedBytes.writeByte(0);
            }
            m mVar3 = this.deflatedBytes;
            mVar.write(mVar3, mVar3.O0());
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
