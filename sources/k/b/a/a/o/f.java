package k.b.a.a.o;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.BitSet;
import k.b.a.a.h;
import k.b.a.a.i;
import k.b.a.a.k.p;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

/* loaded from: classes4.dex */
public class f implements k.b.a.a.b, k.b.a.a.a, i, h {
    public static final byte b = 37;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public static final BitSet f16244c;

    /* renamed from: d  reason: collision with root package name */
    private static final BitSet f16245d = new BitSet(256);
    @Deprecated
    public volatile String a;

    static {
        for (int i2 = 97; i2 <= 122; i2++) {
            f16245d.set(i2);
        }
        for (int i3 = 65; i3 <= 90; i3++) {
            f16245d.set(i3);
        }
        for (int i4 = 48; i4 <= 57; i4++) {
            f16245d.set(i4);
        }
        BitSet bitSet = f16245d;
        bitSet.set(45);
        bitSet.set(95);
        bitSet.set(46);
        bitSet.set(42);
        bitSet.set(32);
        f16244c = (BitSet) bitSet.clone();
    }

    public f() {
        this("UTF-8");
    }

    public static final byte[] b(byte[] bArr) throws DecoderException {
        if (bArr == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        while (i2 < bArr.length) {
            byte b2 = bArr[i2];
            if (b2 == 43) {
                byteArrayOutputStream.write(32);
            } else if (b2 == 37) {
                int i3 = i2 + 1;
                try {
                    int a = g.a(bArr[i3]);
                    i2 = i3 + 1;
                    byteArrayOutputStream.write((char) ((a << 4) + g.a(bArr[i2])));
                } catch (ArrayIndexOutOfBoundsException e2) {
                    throw new DecoderException("Invalid URL encoding: ", e2);
                }
            } else {
                byteArrayOutputStream.write(b2);
            }
            i2++;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static final byte[] d(BitSet bitSet, byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bitSet == null) {
            bitSet = f16245d;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = bArr[i2];
            if (i3 < 0) {
                i3 += 256;
            }
            if (bitSet.get(i3)) {
                if (i3 == 32) {
                    i3 = 43;
                }
                byteArrayOutputStream.write(i3);
            } else {
                byteArrayOutputStream.write(37);
                char b2 = g.b(i3 >> 4);
                char b3 = g.b(i3);
                byteArrayOutputStream.write(b2);
                byteArrayOutputStream.write(b3);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public String a(String str, String str2) throws DecoderException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        return new String(decode(p.g(str)), str2);
    }

    public String c(String str, String str2) throws UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        return p.p(encode(str.getBytes(str2)));
    }

    @Override // k.b.a.a.a
    public byte[] decode(byte[] bArr) throws DecoderException {
        return b(bArr);
    }

    @Override // k.b.a.a.h
    public String e(String str) throws DecoderException {
        if (str == null) {
            return null;
        }
        try {
            return a(str, g());
        } catch (UnsupportedEncodingException e2) {
            throw new DecoderException(e2.getMessage(), e2);
        }
    }

    @Override // k.b.a.a.b
    public byte[] encode(byte[] bArr) {
        return d(f16245d, bArr);
    }

    @Override // k.b.a.a.i
    public String f(String str) throws EncoderException {
        if (str == null) {
            return null;
        }
        try {
            return c(str, g());
        } catch (UnsupportedEncodingException e2) {
            throw new EncoderException(e2.getMessage(), e2);
        }
    }

    public String g() {
        return this.a;
    }

    @Deprecated
    public String h() {
        return this.a;
    }

    public f(String str) {
        this.a = str;
    }

    @Override // k.b.a.a.e
    public Object decode(Object obj) throws DecoderException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof String) {
            return e((String) obj);
        }
        throw new DecoderException("Objects of type " + obj.getClass().getName() + " cannot be URL decoded");
    }

    @Override // k.b.a.a.f
    public Object encode(Object obj) throws EncoderException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        if (obj instanceof String) {
            return f((String) obj);
        }
        throw new EncoderException("Objects of type " + obj.getClass().getName() + " cannot be URL encoded");
    }
}
