package k.b.a.a.o;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.BitSet;
import k.b.a.a.h;
import k.b.a.a.i;
import k.b.a.a.k.p;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

/* loaded from: classes4.dex */
public class d implements k.b.a.a.b, k.b.a.a.a, i, h {

    /* renamed from: c  reason: collision with root package name */
    private static final BitSet f16236c = new BitSet(256);

    /* renamed from: d  reason: collision with root package name */
    private static final byte f16237d = 61;

    /* renamed from: e  reason: collision with root package name */
    private static final byte f16238e = 9;

    /* renamed from: f  reason: collision with root package name */
    private static final byte f16239f = 32;

    /* renamed from: g  reason: collision with root package name */
    private static final byte f16240g = 13;

    /* renamed from: h  reason: collision with root package name */
    private static final byte f16241h = 10;

    /* renamed from: i  reason: collision with root package name */
    private static final int f16242i = 73;
    private final Charset a;
    private final boolean b;

    static {
        for (int i2 = 33; i2 <= 60; i2++) {
            f16236c.set(i2);
        }
        for (int i3 = 62; i3 <= 126; i3++) {
            f16236c.set(i3);
        }
        BitSet bitSet = f16236c;
        bitSet.set(9);
        bitSet.set(32);
    }

    public d() {
        this(StandardCharsets.UTF_8, false);
    }

    public static final byte[] c(byte[] bArr) throws DecoderException {
        if (bArr == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        while (i2 < bArr.length) {
            byte b = bArr[i2];
            if (b == 61) {
                i2++;
                try {
                    if (bArr[i2] != 13) {
                        int a = g.a(bArr[i2]);
                        i2++;
                        byteArrayOutputStream.write((char) ((a << 4) + g.a(bArr[i2])));
                    }
                } catch (ArrayIndexOutOfBoundsException e2) {
                    throw new DecoderException("Invalid quoted-printable encoding", e2);
                }
            } else if (b != 13 && b != 10) {
                byteArrayOutputStream.write(b);
            }
            i2++;
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static int h(int i2, boolean z, ByteArrayOutputStream byteArrayOutputStream) {
        if (z) {
            return i(i2, byteArrayOutputStream);
        }
        byteArrayOutputStream.write(i2);
        return 1;
    }

    private static final int i(int i2, ByteArrayOutputStream byteArrayOutputStream) {
        byteArrayOutputStream.write(61);
        char b = g.b(i2 >> 4);
        char b2 = g.b(i2);
        byteArrayOutputStream.write(b);
        byteArrayOutputStream.write(b2);
        return 3;
    }

    public static final byte[] j(BitSet bitSet, byte[] bArr) {
        return k(bitSet, bArr, false);
    }

    public static final byte[] k(BitSet bitSet, byte[] bArr, boolean z) {
        if (bArr == null) {
            return null;
        }
        if (bitSet == null) {
            bitSet = f16236c;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (z) {
            int i2 = 1;
            for (int i3 = 0; i3 < bArr.length - 3; i3++) {
                int n = n(i3, bArr);
                if (i2 < 73) {
                    i2 += h(n, !bitSet.get(n), byteArrayOutputStream);
                } else {
                    h(n, !bitSet.get(n) || o(n), byteArrayOutputStream);
                    byteArrayOutputStream.write(61);
                    byteArrayOutputStream.write(13);
                    byteArrayOutputStream.write(10);
                    i2 = 1;
                }
            }
            int n2 = n(bArr.length - 3, bArr);
            if (i2 + h(n2, !bitSet.get(n2) || (o(n2) && i2 > 68), byteArrayOutputStream) > 71) {
                byteArrayOutputStream.write(61);
                byteArrayOutputStream.write(13);
                byteArrayOutputStream.write(10);
            }
            int length = bArr.length - 2;
            while (length < bArr.length) {
                int n3 = n(length, bArr);
                h(n3, !bitSet.get(n3) || (length > bArr.length + (-2) && o(n3)), byteArrayOutputStream);
                length++;
            }
        } else {
            int length2 = bArr.length;
            for (int i4 = 0; i4 < length2; i4++) {
                int i5 = bArr[i4];
                if (i5 < 0) {
                    i5 += 256;
                }
                if (bitSet.get(i5)) {
                    byteArrayOutputStream.write(i5);
                } else {
                    i(i5, byteArrayOutputStream);
                }
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static int n(int i2, byte[] bArr) {
        byte b = bArr[i2];
        return b < 0 ? b + 256 : b;
    }

    private static boolean o(int i2) {
        return i2 == 32 || i2 == 9;
    }

    public String a(String str, String str2) throws DecoderException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        return new String(decode(p.g(str)), str2);
    }

    public String b(String str, Charset charset) throws DecoderException {
        if (str == null) {
            return null;
        }
        return new String(decode(p.g(str)), charset);
    }

    public String d(String str, String str2) throws UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        return p.p(encode(str.getBytes(str2)));
    }

    @Override // k.b.a.a.a
    public byte[] decode(byte[] bArr) throws DecoderException {
        return c(bArr);
    }

    @Override // k.b.a.a.h
    public String e(String str) throws DecoderException {
        return b(str, l());
    }

    @Override // k.b.a.a.b
    public byte[] encode(byte[] bArr) {
        return k(f16236c, bArr, this.b);
    }

    @Override // k.b.a.a.i
    public String f(String str) throws EncoderException {
        return g(str, l());
    }

    public String g(String str, Charset charset) {
        if (str == null) {
            return null;
        }
        return p.p(encode(str.getBytes(charset)));
    }

    public Charset l() {
        return this.a;
    }

    public String m() {
        return this.a.name();
    }

    public d(boolean z) {
        this(StandardCharsets.UTF_8, z);
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
        throw new DecoderException("Objects of type " + obj.getClass().getName() + " cannot be quoted-printable decoded");
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
        throw new EncoderException("Objects of type " + obj.getClass().getName() + " cannot be quoted-printable encoded");
    }

    public d(Charset charset) {
        this(charset, false);
    }

    public d(Charset charset, boolean z) {
        this.a = charset;
        this.b = z;
    }

    public d(String str) throws IllegalCharsetNameException, IllegalArgumentException, UnsupportedCharsetException {
        this(Charset.forName(str), false);
    }
}
