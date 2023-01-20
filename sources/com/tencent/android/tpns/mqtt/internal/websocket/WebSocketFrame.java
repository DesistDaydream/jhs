package com.tencent.android.tpns.mqtt.internal.websocket;

import com.umeng.analytics.pro.cb;
import h.k2.v.n;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.SecureRandom;

/* loaded from: classes3.dex */
public class WebSocketFrame {
    public static final int frameLengthOverhead = 6;
    private boolean closeFlag;
    private boolean fin;
    private byte opcode;
    private byte[] payload;

    public WebSocketFrame(byte b, boolean z, byte[] bArr) {
        this.closeFlag = false;
        this.opcode = b;
        this.fin = z;
        this.payload = bArr;
    }

    public static void appendFinAndOpCode(ByteBuffer byteBuffer, byte b, boolean z) {
        byteBuffer.put((byte) ((b & cb.f7124m) | (z ? (byte) 128 : (byte) 0)));
    }

    private static void appendLength(ByteBuffer byteBuffer, int i2, boolean z) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Length cannot be negative");
        }
        int i3 = z ? -128 : 0;
        if (i2 <= 65535) {
            if (i2 >= 126) {
                byteBuffer.put((byte) (i3 | 126));
                byteBuffer.put((byte) (i2 >> 8));
                byteBuffer.put((byte) (i2 & 255));
                return;
            }
            byteBuffer.put((byte) (i2 | i3));
            return;
        }
        byteBuffer.put((byte) (i3 | 127));
        byteBuffer.put((byte) 0);
        byteBuffer.put((byte) 0);
        byteBuffer.put((byte) 0);
        byteBuffer.put((byte) 0);
        byteBuffer.put((byte) ((i2 >> 24) & 255));
        byteBuffer.put((byte) ((i2 >> 16) & 255));
        byteBuffer.put((byte) ((i2 >> 8) & 255));
        byteBuffer.put((byte) (i2 & 255));
    }

    public static void appendLengthAndMask(ByteBuffer byteBuffer, int i2, byte[] bArr) {
        if (bArr != null) {
            appendLength(byteBuffer, i2, true);
            byteBuffer.put(bArr);
            return;
        }
        appendLength(byteBuffer, i2, false);
    }

    public static byte[] generateMaskingKey() {
        SecureRandom secureRandom = new SecureRandom();
        return new byte[]{(byte) secureRandom.nextInt(255), (byte) secureRandom.nextInt(255), (byte) secureRandom.nextInt(255), (byte) secureRandom.nextInt(255)};
    }

    private void setFinAndOpCode(byte b) {
        this.fin = (b & n.a) != 0;
        this.opcode = (byte) (b & cb.f7124m);
    }

    public byte[] encodeFrame() {
        byte[] bArr = this.payload;
        int length = bArr.length + 6;
        if (bArr.length > 65535) {
            length += 8;
        } else if (bArr.length >= 126) {
            length += 2;
        }
        ByteBuffer allocate = ByteBuffer.allocate(length);
        appendFinAndOpCode(allocate, this.opcode, this.fin);
        byte[] generateMaskingKey = generateMaskingKey();
        appendLengthAndMask(allocate, this.payload.length, generateMaskingKey);
        int i2 = 0;
        while (true) {
            byte[] bArr2 = this.payload;
            if (i2 < bArr2.length) {
                byte b = (byte) (bArr2[i2] ^ generateMaskingKey[i2 % 4]);
                bArr2[i2] = b;
                allocate.put(b);
                i2++;
            } else {
                allocate.flip();
                return allocate.array();
            }
        }
    }

    public byte getOpcode() {
        return this.opcode;
    }

    public byte[] getPayload() {
        return this.payload;
    }

    public boolean isCloseFlag() {
        return this.closeFlag;
    }

    public boolean isFin() {
        return this.fin;
    }

    public WebSocketFrame(byte[] bArr) {
        int i2 = 0;
        this.closeFlag = false;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        setFinAndOpCode(wrap.get());
        byte b = wrap.get();
        boolean z = (b & n.a) != 0;
        int i3 = (byte) (b & n.b);
        int i4 = i3 == 127 ? 8 : i3 == 126 ? 2 : 0;
        while (true) {
            i4--;
            if (i4 <= 0) {
                break;
            }
            i3 |= (wrap.get() & 255) << (i4 * 8);
        }
        byte[] bArr2 = null;
        if (z) {
            byte[] bArr3 = new byte[4];
            wrap.get(bArr3, 0, 4);
            bArr2 = bArr3;
        }
        byte[] bArr4 = new byte[i3];
        this.payload = bArr4;
        wrap.get(bArr4, 0, i3);
        if (!z) {
            return;
        }
        while (true) {
            byte[] bArr5 = this.payload;
            if (i2 >= bArr5.length) {
                return;
            }
            bArr5[i2] = (byte) (bArr5[i2] ^ bArr2[i2 % 4]);
            i2++;
        }
    }

    public WebSocketFrame(InputStream inputStream) throws IOException {
        int i2 = 0;
        this.closeFlag = false;
        setFinAndOpCode((byte) inputStream.read());
        byte b = this.opcode;
        int i3 = 2;
        if (b != 2) {
            if (b == 8) {
                this.closeFlag = true;
                return;
            }
            throw new IOException("Invalid Frame: Opcode: " + ((int) this.opcode));
        }
        byte read = (byte) inputStream.read();
        boolean z = (read & n.a) != 0;
        int i4 = (byte) (read & n.b);
        if (i4 == 127) {
            i3 = 8;
        } else if (i4 != 126) {
            i3 = 0;
        }
        i4 = i3 > 0 ? 0 : i4;
        while (true) {
            i3--;
            if (i3 < 0) {
                break;
            }
            i4 |= (((byte) inputStream.read()) & 255) << (i3 * 8);
        }
        byte[] bArr = null;
        if (z) {
            byte[] bArr2 = new byte[4];
            inputStream.read(bArr2, 0, 4);
            bArr = bArr2;
        }
        this.payload = new byte[i4];
        int i5 = i4;
        int i6 = 0;
        while (i6 != i4) {
            int read2 = inputStream.read(this.payload, i6, i5);
            i6 += read2;
            i5 -= read2;
        }
        if (!z) {
            return;
        }
        while (true) {
            byte[] bArr3 = this.payload;
            if (i2 >= bArr3.length) {
                return;
            }
            bArr3[i2] = (byte) (bArr3[i2] ^ bArr[i2 % 4]);
            i2++;
        }
    }
}
