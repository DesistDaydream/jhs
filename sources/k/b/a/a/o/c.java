package k.b.a.a.o;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.BitSet;
import k.b.a.a.h;
import k.b.a.a.i;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

/* loaded from: classes4.dex */
public class c extends e implements i, h {

    /* renamed from: f  reason: collision with root package name */
    private static final BitSet f16231f;

    /* renamed from: g  reason: collision with root package name */
    private static final byte f16232g = 32;

    /* renamed from: h  reason: collision with root package name */
    private static final byte f16233h = 95;

    /* renamed from: d  reason: collision with root package name */
    private final Charset f16234d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f16235e;

    static {
        BitSet bitSet = new BitSet(256);
        f16231f = bitSet;
        bitSet.set(32);
        bitSet.set(33);
        bitSet.set(34);
        bitSet.set(35);
        bitSet.set(36);
        bitSet.set(37);
        bitSet.set(38);
        bitSet.set(39);
        bitSet.set(40);
        bitSet.set(41);
        bitSet.set(42);
        bitSet.set(43);
        bitSet.set(44);
        bitSet.set(45);
        bitSet.set(46);
        bitSet.set(47);
        for (int i2 = 48; i2 <= 57; i2++) {
            f16231f.set(i2);
        }
        BitSet bitSet2 = f16231f;
        bitSet2.set(58);
        bitSet2.set(59);
        bitSet2.set(60);
        bitSet2.set(62);
        bitSet2.set(64);
        for (int i3 = 65; i3 <= 90; i3++) {
            f16231f.set(i3);
        }
        BitSet bitSet3 = f16231f;
        bitSet3.set(91);
        bitSet3.set(92);
        bitSet3.set(93);
        bitSet3.set(94);
        bitSet3.set(96);
        for (int i4 = 97; i4 <= 122; i4++) {
            f16231f.set(i4);
        }
        BitSet bitSet4 = f16231f;
        bitSet4.set(123);
        bitSet4.set(124);
        bitSet4.set(125);
        bitSet4.set(126);
    }

    public c() {
        this(StandardCharsets.UTF_8);
    }

    @Override // k.b.a.a.o.e
    public byte[] b(byte[] bArr) throws DecoderException {
        boolean z;
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = false;
                break;
            } else if (bArr[i2] == 95) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            byte[] bArr2 = new byte[bArr.length];
            for (int i3 = 0; i3 < bArr.length; i3++) {
                byte b = bArr[i3];
                if (b != 95) {
                    bArr2[i3] = b;
                } else {
                    bArr2[i3] = f16232g;
                }
            }
            return d.c(bArr2);
        }
        return d.c(bArr);
    }

    @Override // k.b.a.a.o.e
    public byte[] c(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] j2 = d.j(f16231f, bArr);
        if (this.f16235e) {
            for (int i2 = 0; i2 < j2.length; i2++) {
                if (j2[i2] == 32) {
                    j2[i2] = f16233h;
                }
            }
        }
        return j2;
    }

    @Override // k.b.a.a.e
    public Object decode(Object obj) throws DecoderException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return e((String) obj);
        }
        throw new DecoderException("Objects of type " + obj.getClass().getName() + " cannot be decoded using Q codec");
    }

    @Override // k.b.a.a.h
    public String e(String str) throws DecoderException {
        if (str == null) {
            return null;
        }
        try {
            return a(str);
        } catch (UnsupportedEncodingException e2) {
            throw new DecoderException(e2.getMessage(), e2);
        }
    }

    @Override // k.b.a.a.f
    public Object encode(Object obj) throws EncoderException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return f((String) obj);
        }
        throw new EncoderException("Objects of type " + obj.getClass().getName() + " cannot be encoded using Q codec");
    }

    @Override // k.b.a.a.i
    public String f(String str) throws EncoderException {
        if (str == null) {
            return null;
        }
        return j(str, k());
    }

    @Override // k.b.a.a.o.e
    public String h() {
        return "Q";
    }

    public String i(String str, String str2) throws EncoderException {
        if (str == null) {
            return null;
        }
        try {
            return d(str, str2);
        } catch (UnsupportedEncodingException e2) {
            throw new EncoderException(e2.getMessage(), e2);
        }
    }

    public String j(String str, Charset charset) throws EncoderException {
        if (str == null) {
            return null;
        }
        return g(str, charset);
    }

    public Charset k() {
        return this.f16234d;
    }

    public String l() {
        return this.f16234d.name();
    }

    public boolean m() {
        return this.f16235e;
    }

    public void n(boolean z) {
        this.f16235e = z;
    }

    public c(Charset charset) {
        this.f16235e = false;
        this.f16234d = charset;
    }

    public c(String str) {
        this(Charset.forName(str));
    }
}
