package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/* loaded from: classes.dex */
public interface d extends r, WritableByteChannel {
    c a();

    d a(String str) throws IOException;

    d e(long j2) throws IOException;

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r, java.io.Flushable
    void flush() throws IOException;

    d h() throws IOException;

    d write(byte[] bArr) throws IOException;

    d write(byte[] bArr, int i2, int i3) throws IOException;

    d writeByte(int i2) throws IOException;

    d writeInt(int i2) throws IOException;

    d writeShort(int i2) throws IOException;
}
