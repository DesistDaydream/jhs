package k.b.a.a.k;

import com.umeng.analytics.pro.cb;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

/* loaded from: classes4.dex */
public class o implements k.b.a.a.b, k.b.a.a.a {

    /* renamed from: c  reason: collision with root package name */
    public static final String f16072c = "UTF-8";
    private final Charset a;
    public static final Charset b = StandardCharsets.UTF_8;

    /* renamed from: d  reason: collision with root package name */
    private static final char[] f16073d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: e  reason: collision with root package name */
    private static final char[] f16074e = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public o() {
        this.a = b;
    }

    public static int b(char[] cArr, byte[] bArr, int i2) throws DecoderException {
        int length = cArr.length;
        if ((length & 1) == 0) {
            int i3 = length >> 1;
            if (bArr.length - i2 >= i3) {
                int i4 = 0;
                while (i4 < length) {
                    int i5 = i4 + 1;
                    i4 = i5 + 1;
                    bArr[i2] = (byte) (((x(cArr[i4], i4) << 4) | x(cArr[i5], i5)) & 255);
                    i2++;
                }
                return i3;
            }
            throw new DecoderException("Output array is not large enough to accommodate decoded data.");
        }
        throw new DecoderException("Odd number of characters.");
    }

    public static byte[] c(String str) throws DecoderException {
        return d(str.toCharArray());
    }

    public static byte[] d(char[] cArr) throws DecoderException {
        byte[] bArr = new byte[cArr.length >> 1];
        b(cArr, bArr, 0);
        return bArr;
    }

    public static void h(byte[] bArr, int i2, int i3, boolean z, char[] cArr, int i4) {
        i(bArr, i2, i3, z ? f16073d : f16074e, cArr, i4);
    }

    private static void i(byte[] bArr, int i2, int i3, char[] cArr, char[] cArr2, int i4) {
        for (int i5 = i2; i5 < i2 + i3; i5++) {
            int i6 = i4 + 1;
            cArr2[i4] = cArr[(bArr[i5] & 240) >>> 4];
            i4 = i6 + 1;
            cArr2[i6] = cArr[bArr[i5] & cb.f7124m];
        }
    }

    public static char[] j(ByteBuffer byteBuffer) {
        return k(byteBuffer, true);
    }

    public static char[] k(ByteBuffer byteBuffer, boolean z) {
        return l(byteBuffer, z ? f16073d : f16074e);
    }

    public static char[] l(ByteBuffer byteBuffer, char[] cArr) {
        return p(w(byteBuffer), cArr);
    }

    public static char[] m(byte[] bArr) {
        return o(bArr, true);
    }

    public static char[] n(byte[] bArr, int i2, int i3, boolean z) {
        char[] cArr = new char[i3 << 1];
        i(bArr, i2, i3, z ? f16073d : f16074e, cArr, 0);
        return cArr;
    }

    public static char[] o(byte[] bArr, boolean z) {
        return p(bArr, z ? f16073d : f16074e);
    }

    public static char[] p(byte[] bArr, char[] cArr) {
        char[] cArr2 = new char[bArr.length << 1];
        i(bArr, 0, bArr.length, cArr, cArr2, 0);
        return cArr2;
    }

    public static String q(ByteBuffer byteBuffer) {
        return new String(j(byteBuffer));
    }

    public static String r(ByteBuffer byteBuffer, boolean z) {
        return new String(k(byteBuffer, z));
    }

    public static String s(byte[] bArr) {
        return new String(m(bArr));
    }

    public static String t(byte[] bArr, boolean z) {
        return new String(o(bArr, z));
    }

    private static byte[] w(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        if (byteBuffer.hasArray()) {
            byte[] array = byteBuffer.array();
            if (remaining == array.length) {
                byteBuffer.position(remaining);
                return array;
            }
        }
        byte[] bArr = new byte[remaining];
        byteBuffer.get(bArr);
        return bArr;
    }

    public static int x(char c2, int i2) throws DecoderException {
        int digit = Character.digit(c2, 16);
        if (digit != -1) {
            return digit;
        }
        throw new DecoderException("Illegal hexadecimal character " + c2 + " at index " + i2);
    }

    public byte[] a(ByteBuffer byteBuffer) throws DecoderException {
        return d(new String(w(byteBuffer), u()).toCharArray());
    }

    @Override // k.b.a.a.a
    public byte[] decode(byte[] bArr) throws DecoderException {
        return d(new String(bArr, u()).toCharArray());
    }

    @Override // k.b.a.a.b
    public byte[] encode(byte[] bArr) {
        return s(bArr).getBytes(u());
    }

    public byte[] g(ByteBuffer byteBuffer) {
        return q(byteBuffer).getBytes(u());
    }

    public String toString() {
        return super.toString() + "[charsetName=" + this.a + "]";
    }

    public Charset u() {
        return this.a;
    }

    public String v() {
        return this.a.name();
    }

    @Override // k.b.a.a.e
    public Object decode(Object obj) throws DecoderException {
        if (obj instanceof String) {
            return decode(((String) obj).toCharArray());
        }
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof ByteBuffer) {
            return a((ByteBuffer) obj);
        }
        try {
            return d((char[]) obj);
        } catch (ClassCastException e2) {
            throw new DecoderException(e2.getMessage(), e2);
        }
    }

    @Override // k.b.a.a.f
    public Object encode(Object obj) throws EncoderException {
        byte[] bArr;
        if (obj instanceof String) {
            bArr = ((String) obj).getBytes(u());
        } else if (obj instanceof ByteBuffer) {
            bArr = w((ByteBuffer) obj);
        } else {
            try {
                bArr = (byte[]) obj;
            } catch (ClassCastException e2) {
                throw new EncoderException(e2.getMessage(), e2);
            }
        }
        return m(bArr);
    }

    public o(Charset charset) {
        this.a = charset;
    }

    public o(String str) {
        this(Charset.forName(str));
    }
}
