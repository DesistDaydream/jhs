package k.b.a.a.o;

import java.nio.ByteBuffer;
import java.util.BitSet;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

/* loaded from: classes4.dex */
public class b implements k.b.a.a.b, k.b.a.a.a {

    /* renamed from: e  reason: collision with root package name */
    private static final byte f16228e = 37;
    private final BitSet a;
    private final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private int f16229c;

    /* renamed from: d  reason: collision with root package name */
    private int f16230d;

    public b() {
        this.a = new BitSet();
        this.f16229c = Integer.MAX_VALUE;
        this.f16230d = Integer.MIN_VALUE;
        this.b = false;
        i((byte) 37);
    }

    private boolean a(byte b) {
        return !k(b) || (h(b) && this.a.get(b));
    }

    private boolean b(byte[] bArr) {
        for (byte b : bArr) {
            if (b == 32) {
                return true;
            }
        }
        return false;
    }

    private byte[] c(byte[] bArr, int i2, boolean z) {
        ByteBuffer allocate = ByteBuffer.allocate(i2);
        for (byte b : bArr) {
            if (z && a(b)) {
                if (b < 0) {
                    b = (byte) (b + 256);
                }
                char b2 = g.b(b >> 4);
                char b3 = g.b(b);
                allocate.put((byte) 37);
                allocate.put((byte) b2);
                allocate.put((byte) b3);
            } else if (this.b && b == 32) {
                allocate.put((byte) 43);
            } else {
                allocate.put(b);
            }
        }
        return allocate.array();
    }

    private int d(byte[] bArr) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < bArr.length) {
            i2 += bArr[i2] == 37 ? 3 : 1;
            i3++;
        }
        return i3;
    }

    private int g(byte[] bArr) {
        int i2 = 0;
        for (byte b : bArr) {
            i2 += a(b) ? 3 : 1;
        }
        return i2;
    }

    private boolean h(byte b) {
        return b >= this.f16229c && b <= this.f16230d;
    }

    private void i(byte b) {
        this.a.set(b);
        if (b < this.f16229c) {
            this.f16229c = b;
        }
        if (b > this.f16230d) {
            this.f16230d = b;
        }
    }

    private void j(byte[] bArr) {
        if (bArr != null) {
            for (byte b : bArr) {
                i(b);
            }
        }
        i((byte) 37);
    }

    private boolean k(byte b) {
        return b >= 0;
    }

    @Override // k.b.a.a.a
    public byte[] decode(byte[] bArr) throws DecoderException {
        if (bArr == null) {
            return null;
        }
        ByteBuffer allocate = ByteBuffer.allocate(d(bArr));
        int i2 = 0;
        while (i2 < bArr.length) {
            byte b = bArr[i2];
            if (b == 37) {
                int i3 = i2 + 1;
                try {
                    int a = g.a(bArr[i3]);
                    i2 = i3 + 1;
                    allocate.put((byte) ((a << 4) + g.a(bArr[i2])));
                } catch (ArrayIndexOutOfBoundsException e2) {
                    throw new DecoderException("Invalid percent decoding: ", e2);
                }
            } else if (this.b && b == 43) {
                allocate.put((byte) 32);
            } else {
                allocate.put(b);
            }
            i2++;
        }
        return allocate.array();
    }

    @Override // k.b.a.a.b
    public byte[] encode(byte[] bArr) throws EncoderException {
        if (bArr == null) {
            return null;
        }
        int g2 = g(bArr);
        boolean z = g2 != bArr.length;
        return (z || (this.b && b(bArr))) ? c(bArr, g2, z) : bArr;
    }

    @Override // k.b.a.a.f
    public Object encode(Object obj) throws EncoderException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        throw new EncoderException("Objects of type " + obj.getClass().getName() + " cannot be Percent encoded");
    }

    public b(byte[] bArr, boolean z) {
        this.a = new BitSet();
        this.f16229c = Integer.MAX_VALUE;
        this.f16230d = Integer.MIN_VALUE;
        this.b = z;
        j(bArr);
    }

    @Override // k.b.a.a.e
    public Object decode(Object obj) throws DecoderException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        throw new DecoderException("Objects of type " + obj.getClass().getName() + " cannot be Percent decoded");
    }
}
