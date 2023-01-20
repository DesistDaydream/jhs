package androidx.camera.core.impl.utils;

import androidx.annotation.RequiresApi;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteOrder;

@RequiresApi(21)
/* loaded from: classes.dex */
public class ByteOrderedDataOutputStream extends FilterOutputStream {
    private ByteOrder mByteOrder;
    public final OutputStream mOutputStream;

    public ByteOrderedDataOutputStream(OutputStream outputStream, ByteOrder byteOrder) {
        super(outputStream);
        this.mOutputStream = outputStream;
        this.mByteOrder = byteOrder;
    }

    public void setByteOrder(ByteOrder byteOrder) {
        this.mByteOrder = byteOrder;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.mOutputStream.write(bArr);
    }

    public void writeByte(int i2) throws IOException {
        this.mOutputStream.write(i2);
    }

    public void writeInt(int i2) throws IOException {
        ByteOrder byteOrder = this.mByteOrder;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            this.mOutputStream.write((i2 >>> 0) & 255);
            this.mOutputStream.write((i2 >>> 8) & 255);
            this.mOutputStream.write((i2 >>> 16) & 255);
            this.mOutputStream.write((i2 >>> 24) & 255);
        } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
            this.mOutputStream.write((i2 >>> 24) & 255);
            this.mOutputStream.write((i2 >>> 16) & 255);
            this.mOutputStream.write((i2 >>> 8) & 255);
            this.mOutputStream.write((i2 >>> 0) & 255);
        }
    }

    public void writeShort(short s) throws IOException {
        ByteOrder byteOrder = this.mByteOrder;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            this.mOutputStream.write((s >>> 0) & 255);
            this.mOutputStream.write((s >>> 8) & 255);
        } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
            this.mOutputStream.write((s >>> 8) & 255);
            this.mOutputStream.write((s >>> 0) & 255);
        }
    }

    public void writeUnsignedInt(long j2) throws IOException {
        writeInt((int) j2);
    }

    public void writeUnsignedShort(int i2) throws IOException {
        writeShort((short) i2);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        this.mOutputStream.write(bArr, i2, i3);
    }
}
